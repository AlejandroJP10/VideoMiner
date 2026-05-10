
package aiss.youtubeminer.model.youtube;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "viewCount",
    "subscriberCount",
    "hiddenSubscriberCount",
    "videoCount"
})
@Generated("jsonschema2pojo")
public class Statistics {

    @JsonProperty("viewCount")
    private String viewCount;
    @JsonProperty("subscriberCount")
    private String subscriberCount;
    @JsonProperty("hiddenSubscriberCount")
    private Boolean hiddenSubscriberCount;
    @JsonProperty("videoCount")
    private String videoCount;

    @JsonProperty("viewCount")
    public String getViewCount() {
        return viewCount;
    }

    @JsonProperty("viewCount")
    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    @JsonProperty("subscriberCount")
    public String getSubscriberCount() {
        return subscriberCount;
    }

    @JsonProperty("subscriberCount")
    public void setSubscriberCount(String subscriberCount) {
        this.subscriberCount = subscriberCount;
    }

    @JsonProperty("hiddenSubscriberCount")
    public Boolean getHiddenSubscriberCount() {
        return hiddenSubscriberCount;
    }

    @JsonProperty("hiddenSubscriberCount")
    public void setHiddenSubscriberCount(Boolean hiddenSubscriberCount) {
        this.hiddenSubscriberCount = hiddenSubscriberCount;
    }

    @JsonProperty("videoCount")
    public String getVideoCount() {
        return videoCount;
    }

    @JsonProperty("videoCount")
    public void setVideoCount(String videoCount) {
        this.videoCount = videoCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Statistics.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("viewCount");
        sb.append('=');
        sb.append(((this.viewCount == null)?"<null>":this.viewCount));
        sb.append(',');
        sb.append("subscriberCount");
        sb.append('=');
        sb.append(((this.subscriberCount == null)?"<null>":this.subscriberCount));
        sb.append(',');
        sb.append("hiddenSubscriberCount");
        sb.append('=');
        sb.append(((this.hiddenSubscriberCount == null)?"<null>":this.hiddenSubscriberCount));
        sb.append(',');
        sb.append("videoCount");
        sb.append('=');
        sb.append(((this.videoCount == null)?"<null>":this.videoCount));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
