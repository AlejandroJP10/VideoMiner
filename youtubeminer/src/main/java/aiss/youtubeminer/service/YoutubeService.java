package aiss.youtubeminer.service;

import aiss.youtubeminer.model.youtube.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class YoutubeService {

    @Autowired
    private RestTemplate restTemplate;


    @Value("${youtube.api.key}")
    private String apiKey;
    private final String baseUrl = "https://www.googleapis.com/youtube/v3/";

    public Channel getChannel(String channelId) {
        String url = baseUrl + "/channels?part=snippet,contentDetails&id=" + channelId + "&key=" + apiKey;
        ChannelResponse response = restTemplate.getForObject(url, ChannelResponse.class);
        if(response != null && response.getItems() != null && !response.getItems().isEmpty()) {
            return response.getItems().getFirst();
        }

        return null;
    }

    public List<CommentThread> getComments(String videoId, int maxResults) {
        String url = baseUrl + "/commentThreads?part=snippet&videoId=" + videoId + "&maxResults=" + maxResults + "&key=" + apiKey;
        CommentThreadResponse response = restTemplate.getForObject(url, CommentThreadResponse.class);
        if(response != null && response.getItems() != null) {
            return response.getItems();
        }

        return new ArrayList<>();
    }

    public List<Caption> getCaptions(String videoId) {
        String url = baseUrl + "/captions?part=snippet&videoId=" + videoId + "&key=" + apiKey;
        CaptionResponse response = restTemplate.getForObject(url, CaptionResponse.class);
        if(response != null && response.getItems() != null) {
            return response.getItems();
        }
        return new ArrayList<>();
    }

    public List<VideoItem> getVideos(String channelId, int maxResults) {
        String url = baseUrl + "/search?part=snippet&channelId=" + channelId
                + "&type=video&order=date&maxResults=" + maxResults
                + "&key=" + apiKey;

        VideoSearchResponse response = restTemplate.getForObject(url, VideoSearchResponse.class);
        if (response != null && response.getItems() != null) {
            return response.getItems();
        }

        return new ArrayList<>();
    }

}
