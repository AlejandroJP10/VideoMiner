package aiss.videominer.controller;

import aiss.videominer.exceptions.CaptionNotFoundException;
import aiss.videominer.exceptions.VideoNotFoundException;
import aiss.videominer.model.Caption;
import aiss.videominer.model.Video;
import aiss.videominer.repository.CaptionRepository;
import aiss.videominer.repository.VideoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Tag(name="Caption", description = "Caption management API")
@RestController
@RequestMapping("/videominer")
public class CaptionController {

    @Autowired
    CaptionRepository captionRepository;
    @Autowired
    VideoRepository videoRepository;

    @ApiResponse(responseCode = "200", description = "Listado de captions",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = Caption.class)), mediaType = "application/json")})
    @Operation(summary = "Retrieve all Captions", description = "Get a list of all Caption objects", tags = {"get", "captions"})
    @GetMapping("/captions")
    public List<Caption> findAll() {
        return captionRepository.findAll();
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Caption obtenido",
                    content = {@Content(schema = @Schema(implementation = Caption.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Caption no encontrado", content = {@Content(schema = @Schema())})
    })
    @Operation(summary = "Retrieve a Caption",
            description = "Get a Caption object by specifying its Id", tags = {"get", "captions"})
    @GetMapping("/captions/{captionId}")
    public Caption findOne(@Parameter(description = "id from caption to be searched")
                           @PathVariable(value = "captionId") String captionId) throws CaptionNotFoundException {
        Optional<Caption> caption = captionRepository.findById(captionId);
        if(!caption.isPresent()){
            throw new CaptionNotFoundException();
        }
        return caption.get();
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listado de captions de un video",
                    content = {@Content(array = @ArraySchema(schema = @Schema(implementation = Caption.class)), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Video no encontrado", content = {@Content(schema = @Schema())})
    })
    @Operation(summary = "Retrieve all Captions from Video",
            description = "Get a list of all Caption objects from an Video object by specifying its Id", tags = {"get", "videos", "captions"})
    @GetMapping("/videos/{videoId}/captions")
    public List<Caption> getAllCaptionsByVideoId(@Parameter(description = "id from video whose captions needs to be listed")
                                                 @PathVariable(value = "videoId") String videoId) throws VideoNotFoundException {
        Optional<Video> video = videoRepository.findById(videoId);
        if(!video.isPresent()){
            throw new VideoNotFoundException();
        }
        List<Caption> captions = new ArrayList<>(video.get().getCaptions());
        return captions;
    }

}
