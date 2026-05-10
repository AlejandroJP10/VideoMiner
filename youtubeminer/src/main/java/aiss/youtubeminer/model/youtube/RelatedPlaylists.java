
package aiss.youtubeminer.model.youtube;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "likes",
    "uploads"
})
@Generated("jsonschema2pojo")
public class RelatedPlaylists {

    @JsonProperty("likes")
    private String likes;
    @JsonProperty("uploads")
    private String uploads;

    @JsonProperty("likes")
    public String getLikes() {
        return likes;
    }

    @JsonProperty("likes")
    public void setLikes(String likes) {
        this.likes = likes;
    }

    @JsonProperty("uploads")
    public String getUploads() {
        return uploads;
    }

    @JsonProperty("uploads")
    public void setUploads(String uploads) {
        this.uploads = uploads;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(RelatedPlaylists.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("likes");
        sb.append('=');
        sb.append(((this.likes == null)?"<null>":this.likes));
        sb.append(',');
        sb.append("uploads");
        sb.append('=');
        sb.append(((this.uploads == null)?"<null>":this.uploads));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
