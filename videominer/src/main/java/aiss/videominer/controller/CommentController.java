package aiss.videominer.controller;

import aiss.videominer.exceptions.CommentNotFoundException;
import aiss.videominer.exceptions.VideoNotFoundException;
import aiss.videominer.model.Comment;
import aiss.videominer.model.Video;
import aiss.videominer.repository.CommentRepository;
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

@Tag(name="Comment", description = "Comment management API")
@RestController
@RequestMapping("/videominer")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;
    @Autowired
    VideoRepository videoRepository;

    @ApiResponse(responseCode = "200", description = "Listado de comentarios",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = Comment.class)), mediaType = "application/json")})
    @Operation(summary = "Retrieve all Comments", description = "Get a list of all Comment objects", tags = {"get", "comments"})
    @GetMapping("/comments")
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Comentario obtenido",
                    content = {@Content(schema = @Schema(implementation = Comment.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Comment no encontrado", content = {@Content(schema = @Schema())})
    })
    @Operation(summary = "Retrieve a Comment",
            description = "Get a Comment object by specifying its Id", tags = {"get", "comments"})
    @GetMapping("/comments/{commentId}")
    public Comment findOne(@Parameter(description = "id from comment to be searched")
                           @PathVariable(value = "commentId") String commentId) throws CommentNotFoundException {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if(!comment.isPresent()){
            throw new CommentNotFoundException();
        }
        return comment.get();
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listado de comentarios de un video",
                    content = {@Content(array = @ArraySchema(schema = @Schema(implementation = Comment.class)), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Video no encontrado", content = {@Content(schema = @Schema())})
    })
    @Operation(summary = "Retrieve all Comments from Video",
            description = "Get a list of all Comments objects from an Video object by specifying its Id", tags = {"get", "videos", "comments"})
    @GetMapping("/videos/{videoId}/comments")
    public List<Comment> getAllCommentsByVideoId(@Parameter(description = "id from video whose comments needs to be listed")
                                                 @PathVariable(value = "videoId") String videoId) throws VideoNotFoundException {
        Optional<Video> video = videoRepository.findById(videoId);
        if(!video.isPresent()){
            throw new VideoNotFoundException();
        }
        List<Comment> comments = new ArrayList<>(video.get().getComments());
        return comments;
    }

}
