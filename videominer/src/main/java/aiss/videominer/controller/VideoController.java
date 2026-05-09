package aiss.videominer.controller;
import aiss.videominer.exceptions.ChannelNotFoundException;
import aiss.videominer.exceptions.VideoNotFoundException;
import aiss.videominer.model.Channel;
import aiss.videominer.model.Video;
import aiss.videominer.repository.ChannelRepository;
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

@Tag(name="Video", description = "Video management API")
@RestController
@RequestMapping("/videominer")
public class VideoController {

    @Autowired
    ChannelRepository channelRepository;
    @Autowired
    VideoRepository videoRepository;

    @ApiResponse(responseCode = "200", description = "Listado de videos",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = Video.class)), mediaType = "application/json")})
    @Operation(summary = "Retrieve all Videos", description = "Get a list of all Video objects", tags = {"get", "videos"})
    @GetMapping("/videos")
    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Video obtenido",
                    content = {@Content(schema = @Schema(implementation = Video.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Video no encontrado", content = {@Content(schema = @Schema())})
    })
    @Operation(summary = "Retrieve a Video",
            description = "Get a Video object by specifying its Id", tags = {"get", "videos"})
    @GetMapping("/videos/{videoId}")
    public Video findOne(@Parameter(description = "id from video to be searched")
                         @PathVariable(value = "videoId") String videoId) throws VideoNotFoundException {
        Optional<Video> video = videoRepository.findById(videoId);
        if (!video.isPresent()) {
            throw new VideoNotFoundException();
        }
        return video.get();
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listado de videos de un canal",
                    content = {@Content(array = @ArraySchema(schema = @Schema(implementation = Video.class)), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Canal no encontrado", content = {@Content(schema = @Schema())})
    })
    @Operation(summary = "Retrieve all Videos from Channel",
            description = "Get a list of all Video objects from an Channel object by specifying its Id", tags = {"get", "videos", "channels"})
    @GetMapping("/channels/{channelId}/videos")
    public List<Video> getAllVideosByChannelId(@Parameter(description = "id from channel whose videos needs to be listed")
                                               @PathVariable(value = "channelId") String channelId) throws ChannelNotFoundException {
        Optional<Channel> channel = channelRepository.findById(channelId);
        if (!channel.isPresent()) {
            throw new ChannelNotFoundException();
        }
        List<Video> videos = new ArrayList<>(channel.get().getVideos());
        return videos;
    }
}
