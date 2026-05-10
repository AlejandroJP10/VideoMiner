package aiss.dailymotionminer.controller;

import aiss.dailymotionminer.etl.Transformer;
import aiss.dailymotionminer.model.dailymotion.Subtitle;
import aiss.dailymotionminer.model.dailymotion.SubtitleContainer;
import aiss.dailymotionminer.model.dailymotion.Tag;
import aiss.dailymotionminer.model.videominer.Caption;
import aiss.dailymotionminer.model.videominer.Channel;
import aiss.dailymotionminer.model.videominer.Comment;
import aiss.dailymotionminer.model.videominer.Video;
import aiss.dailymotionminer.service.DailymotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;

@io.swagger.v3.oas.annotations.tags.Tag(name = "Dailymotion Miner", description="Controlador para la extracción de datos desde Dailymotion hacia VideoMiner")
@RestController
@RequestMapping("/dailymotionminer/channels")
public class DailymotionController {

    @Autowired
    private DailymotionService dailymotionService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${videominer.uri}")
    private String videoMinerURI;

    @Value("${dailymotionminer.maxVideos}")
    private Integer defaultMaxVideos;

    @Value("${dailymotionminer.maxPages}")
    private Integer defaultMaxPages;

    @GetMapping("/{id}")
    public Channel getChannel(
            @PathVariable String id,
            @RequestParam(required = false) Integer maxVideos,
            @RequestParam(required = false) Integer maxPages) {

        int nVideos = (maxVideos != null) ? maxVideos : defaultMaxVideos;
        int nPages = (maxPages != null) ? maxPages : defaultMaxPages;

        return buildChannel(id, nVideos, nPages);
    }

    @Operation(
            summary= "Extraer y transformar canal de Dailymotion",
            description= "Obtiene la información de un canal, sus vídeos, etiquetas (a falta de comentarios) y subtítulos, los transforma al formato de VideoMiner y los envía al servicio central.",
            tags= {"post"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Canal procesado y enviado con éxito",
            content= @Content(schema = @Schema(implementation = Channel.class))),
            @ApiResponse(responseCode = "404", description = "No se encontró el canal en Dailymotion"),
            @ApiResponse(responseCode = "502", description = "Error al conectar con Dailymotion o VideoMiner")
    })

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Channel createChannel(
            @Parameter(description = "ID del usuario o canal en Dailymotion", required = true, example = "x160jw6")
            @PathVariable String id,
            @Parameter(description = "Máximo de vídeos a importar")
            @RequestParam(required = false) Integer maxVideos,
            @Parameter(description = "Máximo de páginas de comentarios/subtítulos a procesar")
            @RequestParam(required = false) Integer maxPages) {

        int nVideos = (maxVideos != null) ? maxVideos : defaultMaxVideos;
        int nPages = (maxPages != null) ? maxPages : defaultMaxPages;

        Channel vChannel = buildChannel(id, nVideos, nPages);

        restTemplate.postForObject(videoMinerURI, vChannel, Channel.class);

        return vChannel;
    }

    private Channel buildChannel(String id, int nVideos, int nPages) {

        aiss.dailymotionminer.model.dailymotion.Channel dChannel =
                dailymotionService.getChannel(id);

        Channel vChannel = Transformer.transformChannel(dChannel);

        List<aiss.dailymotionminer.model.dailymotion.Video> dVideos =
                dailymotionService.getListVideos(id, nVideos, nPages);

        List<Video> vVideos = new ArrayList<>();

        aiss.dailymotionminer.model.dailymotion.User dUser =
                dailymotionService.getUser(id);

        for (aiss.dailymotionminer.model.dailymotion.Video dVideo : dVideos) {

            Video vVideo = Transformer.transformVideo(dVideo);

            vVideo.setAuthor(Transformer.transformUser(dUser));

            Tag dTags = dailymotionService.getTags(dVideo.getId());
            List<Comment> vComments = new ArrayList<>();

            if (dTags != null && dTags.getTags() != null) {
                for (int i = 0; i < dTags.getTags().size(); i++) {
                    String tag = dTags.getTags().get(i);
                    vComments.add(Transformer.transformComment(tag, dVideo.getId(), i));
                }
            }

            vVideo.setComments(vComments);

            SubtitleContainer dSubtitles = dailymotionService.getSubtitles(dVideo.getId());
            List<Caption> vCaptions = new ArrayList<>();

            if (dSubtitles != null && dSubtitles.getList() != null) {
                for (Subtitle sub : dSubtitles.getList()) {
                    vCaptions.add(Transformer.transformCaption(sub));
                }
            }

            vVideo.setCaptions(vCaptions);

            vVideos.add(vVideo);
        }

        vChannel.setVideos(vVideos);

        return vChannel;
    }
}