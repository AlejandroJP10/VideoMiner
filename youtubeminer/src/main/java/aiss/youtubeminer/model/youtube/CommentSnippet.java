
package aiss.youtubeminer.model.youtube;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "channelId",
    "videoId",
    "textDisplay",
    "textOriginal",
    "authorDisplayName",
    "authorProfileImageUrl",
    "authorChannelUrl",
    "authorChannelId",
    "canRate",
    "viewerRating",
    "likeCount",
    "publishedAt",
    "updatedAt"
})
@Generated("jsonschema2pojo")
public class CommentSnippet {

    @JsonProperty("channelId")
    private String channelId;
    @JsonProperty("videoId")
    private String videoId;
    @JsonProperty("textDisplay")
    private String textDisplay;
    @JsonProperty("textOriginal")
    private String textOriginal;
    @JsonProperty("authorDisplayName")
    private String authorDisplayName;
    @JsonProperty("authorProfileImageUrl")
    private String authorProfileImageUrl;
    @JsonProperty("authorChannelUrl")
    private String authorChannelUrl;
    @JsonProperty("authorChannelId")
    private AuthorChannelId authorChannelId;
    @JsonProperty("canRate")
    private Boolean canRate;
    @JsonProperty("viewerRating")
    private String viewerRating;
    @JsonProperty("likeCount")
    private Integer likeCount;
    @JsonProperty("publishedAt")
    private String publishedAt;
    @JsonProperty("updatedAt")
    private String updatedAt;

    @JsonProperty("channelId")
    public String getChannelId() {
        return channelId;
    }

    @JsonProperty("channelId")
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @JsonProperty("videoId")
    public String getVideoId() {
        return videoId;
    }

    @JsonProperty("videoId")
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @JsonProperty("textDisplay")
    public String getTextDisplay() {
        return textDisplay;
    }

    @JsonProperty("textDisplay")
    public void setTextDisplay(String textDisplay) {
        this.textDisplay = textDisplay;
    }

    @JsonProperty("textOriginal")
    public String getTextOriginal() {
        return textOriginal;
    }

    @JsonProperty("textOriginal")
    public void setTextOriginal(String textOriginal) {
        this.textOriginal = textOriginal;
    }

    @JsonProperty("authorDisplayName")
    public String getAuthorDisplayName() {
        return authorDisplayName;
    }

    @JsonProperty("authorDisplayName")
    public void setAuthorDisplayName(String authorDisplayName) {
        this.authorDisplayName = authorDisplayName;
    }

    @JsonProperty("authorProfileImageUrl")
    public String getAuthorProfileImageUrl() {
        return authorProfileImageUrl;
    }

    @JsonProperty("authorProfileImageUrl")
    public void setAuthorProfileImageUrl(String authorProfileImageUrl) {
        this.authorProfileImageUrl = authorProfileImageUrl;
    }

    @JsonProperty("authorChannelUrl")
    public String getAuthorChannelUrl() {
        return authorChannelUrl;
    }

    @JsonProperty("authorChannelUrl")
    public void setAuthorChannelUrl(String authorChannelUrl) {
        this.authorChannelUrl = authorChannelUrl;
    }

    @JsonProperty("authorChannelId")
    public AuthorChannelId getAuthorChannelId() {
        return authorChannelId;
    }

    @JsonProperty("authorChannelId")
    public void setAuthorChannelId(AuthorChannelId authorChannelId) {
        this.authorChannelId = authorChannelId;
    }

    @JsonProperty("canRate")
    public Boolean getCanRate() {
        return canRate;
    }

    @JsonProperty("canRate")
    public void setCanRate(Boolean canRate) {
        this.canRate = canRate;
    }

    @JsonProperty("viewerRating")
    public String getViewerRating() {
        return viewerRating;
    }

    @JsonProperty("viewerRating")
    public void setViewerRating(String viewerRating) {
        this.viewerRating = viewerRating;
    }

    @JsonProperty("likeCount")
    public Integer getLikeCount() {
        return likeCount;
    }

    @JsonProperty("likeCount")
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    @JsonProperty("publishedAt")
    public String getPublishedAt() {
        return publishedAt;
    }

    @JsonProperty("publishedAt")
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CommentSnippet .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("channelId");
        sb.append('=');
        sb.append(((this.channelId == null)?"<null>":this.channelId));
        sb.append(',');
        sb.append("videoId");
        sb.append('=');
        sb.append(((this.videoId == null)?"<null>":this.videoId));
        sb.append(',');
        sb.append("textDisplay");
        sb.append('=');
        sb.append(((this.textDisplay == null)?"<null>":this.textDisplay));
        sb.append(',');
        sb.append("textOriginal");
        sb.append('=');
        sb.append(((this.textOriginal == null)?"<null>":this.textOriginal));
        sb.append(',');
        sb.append("authorDisplayName");
        sb.append('=');
        sb.append(((this.authorDisplayName == null)?"<null>":this.authorDisplayName));
        sb.append(',');
        sb.append("authorProfileImageUrl");
        sb.append('=');
        sb.append(((this.authorProfileImageUrl == null)?"<null>":this.authorProfileImageUrl));
        sb.append(',');
        sb.append("authorChannelUrl");
        sb.append('=');
        sb.append(((this.authorChannelUrl == null)?"<null>":this.authorChannelUrl));
        sb.append(',');
        sb.append("authorChannelId");
        sb.append('=');
        sb.append(((this.authorChannelId == null)?"<null>":this.authorChannelId));
        sb.append(',');
        sb.append("canRate");
        sb.append('=');
        sb.append(((this.canRate == null)?"<null>":this.canRate));
        sb.append(',');
        sb.append("viewerRating");
        sb.append('=');
        sb.append(((this.viewerRating == null)?"<null>":this.viewerRating));
        sb.append(',');
        sb.append("likeCount");
        sb.append('=');
        sb.append(((this.likeCount == null)?"<null>":this.likeCount));
        sb.append(',');
        sb.append("publishedAt");
        sb.append('=');
        sb.append(((this.publishedAt == null)?"<null>":this.publishedAt));
        sb.append(',');
        sb.append("updatedAt");
        sb.append('=');
        sb.append(((this.updatedAt == null)?"<null>":this.updatedAt));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
