
package aiss.youtubeminer.model.youtube;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "channelId",
    "videoId",
    "topLevelComment",
    "canReply",
    "totalReplyCount",
    "isPublic"
})
@Generated("jsonschema2pojo")
public class ThreadSnippet {

    @JsonProperty("channelId")
    private String channelId;
    @JsonProperty("videoId")
    private String videoId;
    @JsonProperty("topLevelComment")
    private TopLevelComment topLevelComment;
    @JsonProperty("canReply")
    private Boolean canReply;
    @JsonProperty("totalReplyCount")
    private Integer totalReplyCount;
    @JsonProperty("isPublic")
    private Boolean isPublic;

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

    @JsonProperty("topLevelComment")
    public TopLevelComment getTopLevelComment() {
        return topLevelComment;
    }

    @JsonProperty("topLevelComment")
    public void setTopLevelComment(TopLevelComment topLevelComment) {
        this.topLevelComment = topLevelComment;
    }

    @JsonProperty("canReply")
    public Boolean getCanReply() {
        return canReply;
    }

    @JsonProperty("canReply")
    public void setCanReply(Boolean canReply) {
        this.canReply = canReply;
    }

    @JsonProperty("totalReplyCount")
    public Integer getTotalReplyCount() {
        return totalReplyCount;
    }

    @JsonProperty("totalReplyCount")
    public void setTotalReplyCount(Integer totalReplyCount) {
        this.totalReplyCount = totalReplyCount;
    }

    @JsonProperty("isPublic")
    public Boolean getIsPublic() {
        return isPublic;
    }

    @JsonProperty("isPublic")
    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ThreadSnippet.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("channelId");
        sb.append('=');
        sb.append(((this.channelId == null)?"<null>":this.channelId));
        sb.append(',');
        sb.append("videoId");
        sb.append('=');
        sb.append(((this.videoId == null)?"<null>":this.videoId));
        sb.append(',');
        sb.append("topLevelComment");
        sb.append('=');
        sb.append(((this.topLevelComment == null)?"<null>":this.topLevelComment));
        sb.append(',');
        sb.append("canReply");
        sb.append('=');
        sb.append(((this.canReply == null)?"<null>":this.canReply));
        sb.append(',');
        sb.append("totalReplyCount");
        sb.append('=');
        sb.append(((this.totalReplyCount == null)?"<null>":this.totalReplyCount));
        sb.append(',');
        sb.append("isPublic");
        sb.append('=');
        sb.append(((this.isPublic == null)?"<null>":this.isPublic));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
