package aiss.youtubeminer.etl;

import aiss.youtubeminer.model.videominer.Caption;
import aiss.youtubeminer.model.videominer.Channel;
import aiss.youtubeminer.model.youtube.*;
import aiss.youtubeminer.model.videominer.*;

import java.util.ArrayList;

public class Transformer {

    public static Channel transformChannel(aiss.youtubeminer.model.youtube.Channel youtubeChannel) {
        Channel minerChannel = new Channel();
        minerChannel.setId(youtubeChannel.getId());
        minerChannel.setName(youtubeChannel.getSnippet().getTitle());
        minerChannel.setDescription(youtubeChannel.getSnippet().getDescription());
        minerChannel.setCreatedTime(youtubeChannel.getSnippet().getPublishedAt());
        minerChannel.setVideos(new ArrayList<>());
        return minerChannel;
    }

    public static Video transformVideo(VideoItem youtubeVideo) {
        Video minerVideo = new Video();
        minerVideo.setId(youtubeVideo.getId().getVideoId());
        minerVideo.setName(youtubeVideo.getSnippet().getTitle());
        minerVideo.setDescription(youtubeVideo.getSnippet().getDescription());
        minerVideo.setReleaseTime(youtubeVideo.getSnippet().getPublishedAt());

        User author = new User();
        author.setName(youtubeVideo.getSnippet().getChannelTitle());
        author.setUser_link("https://www.youtube.com/channel/" + youtubeVideo.getSnippet().getChannelId());

        minerVideo.setAuthor(author);
        minerVideo.setComments(new ArrayList<>());
        minerVideo.setCaptions(new ArrayList<>());

        return minerVideo;
    }

    public static Comment transformComment(CommentThread youtubeThread) {
        Comment minerComment = new Comment();

        CommentSnippet snippet = youtubeThread.getSnippet().getTopLevelComment().getSnippet();

        minerComment.setId(youtubeThread.getSnippet().getTopLevelComment().getId());
        minerComment.setText(snippet.getTextDisplay());
        minerComment.setCreatedOn(snippet.getPublishedAt());

        return minerComment;
    }

    public static Caption transformCaption(aiss.youtubeminer.model.youtube.Caption youtubeCaption) {
        Caption minerCaption = new Caption();

        minerCaption.setId(youtubeCaption.getId());
        minerCaption.setName(youtubeCaption.getSnippet().getName());
        minerCaption.setLanguage(youtubeCaption.getSnippet().getLanguage());

        return minerCaption;
    }

}
