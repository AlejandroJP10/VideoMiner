package aiss.youtubeminer.controller;

import aiss.youtubeminer.etl.Transformer;
import aiss.youtubeminer.model.videominer.*;
import aiss.youtubeminer.model.youtube.CommentThread;
import aiss.youtubeminer.model.youtube.VideoItem;
import aiss.youtubeminer.service.YoutubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/youtubeminer")
public class YoutubeController {

    @Autowired
    private YoutubeService youtubeService;

    @Autowired
    private RestTemplate restTemplate;

    private final String videoMinerUrl = "http://localhost:8080/videominer/channels";

    @PostMapping("/{channelId}")
    public Channel importChannel(@PathVariable String channelId,
                                 @RequestParam(defaultValue = "10") int maxVideos,
                                 @RequestParam(defaultValue = "10") int maxComments) {

        aiss.youtubeminer.model.youtube.Channel ytChannel = youtubeService.getChannel(channelId);
        Channel minerChannel = Transformer.transformChannel(ytChannel);

        List<VideoItem> ytVideos = youtubeService.getVideos(channelId, maxVideos);
        List<Video> minerVideos = new ArrayList<>();

        for (VideoItem ytVideo : ytVideos) {
            Video minerVideo = Transformer.transformVideo(ytVideo);
            String videoId = ytVideo.getId().getVideoId();

            List<CommentThread> ytComments = youtubeService.getComments(videoId, maxComments);
            List<Comment> minerComments = new ArrayList<>();
            for (CommentThread ytComment : ytComments) {
                minerComments.add(Transformer.transformComment(ytComment));
            }
            minerVideo.setComments(minerComments);

            List<aiss.youtubeminer.model.youtube.Caption> ytCaptions = youtubeService.getCaptions(videoId);
            List<Caption> minerCaptions = new ArrayList<>();
            for (aiss.youtubeminer.model.youtube.Caption ytCaption : ytCaptions) {
                minerCaptions.add(Transformer.transformCaption(ytCaption));
            }
            minerVideo.setCaptions(minerCaptions);

            minerVideos.add(minerVideo);
        }

        minerChannel.setVideos(minerVideos);

        Channel savedChannel = restTemplate.postForObject(videoMinerUrl, minerChannel, Channel.class);
        return savedChannel;
    }
}
