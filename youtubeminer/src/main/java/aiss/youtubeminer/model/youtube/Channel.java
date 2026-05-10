
package aiss.youtubeminer.model.youtube;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "etag",
    "id",
    "snippet",
    "contentDetails",
    "statistics"
})
@Generated("jsonschema2pojo")
public class Channel {

    @JsonProperty("kind")
    private String kind;
    @JsonProperty("etag")
    private String etag;
    @JsonProperty("id")
    private String id;
    @JsonProperty("snippet")
    private ChannelSnippet ChannelSnippet;
    @JsonProperty("contentDetails")
    private ContentDetails contentDetails;
    @JsonProperty("statistics")
    private Statistics statistics;

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("etag")
    public String getEtag() {
        return etag;
    }

    @JsonProperty("etag")
    public void setEtag(String etag) {
        this.etag = etag;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("snippet")
    public ChannelSnippet getSnippet() {
        return ChannelSnippet;
    }

    @JsonProperty("snippet")
    public void setSnippet(ChannelSnippet snippet) {
        this.ChannelSnippet = snippet;
    }

    @JsonProperty("contentDetails")
    public ContentDetails getContentDetails() {
        return contentDetails;
    }

    @JsonProperty("contentDetails")
    public void setContentDetails(ContentDetails contentDetails) {
        this.contentDetails = contentDetails;
    }

    @JsonProperty("statistics")
    public Statistics getStatistics() {
        return statistics;
    }

    @JsonProperty("statistics")
    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Channel.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("kind");
        sb.append('=');
        sb.append(((this.kind == null)?"<null>":this.kind));
        sb.append(',');
        sb.append("etag");
        sb.append('=');
        sb.append(((this.etag == null)?"<null>":this.etag));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("snippet");
        sb.append('=');
        sb.append(((this.ChannelSnippet == null)?"<null>":this.ChannelSnippet));
        sb.append(',');
        sb.append("contentDetails");
        sb.append('=');
        sb.append(((this.contentDetails == null)?"<null>":this.contentDetails));
        sb.append(',');
        sb.append("statistics");
        sb.append('=');
        sb.append(((this.statistics == null)?"<null>":this.statistics));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
