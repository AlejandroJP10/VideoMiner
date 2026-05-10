
package aiss.youtubeminer.model.youtube;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "relatedPlaylists"
})
@Generated("jsonschema2pojo")
public class ContentDetails {

    @JsonProperty("relatedPlaylists")
    private RelatedPlaylists relatedPlaylists;

    @JsonProperty("relatedPlaylists")
    public RelatedPlaylists getRelatedPlaylists() {
        return relatedPlaylists;
    }

    @JsonProperty("relatedPlaylists")
    public void setRelatedPlaylists(RelatedPlaylists relatedPlaylists) {
        this.relatedPlaylists = relatedPlaylists;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ContentDetails.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("relatedPlaylists");
        sb.append('=');
        sb.append(((this.relatedPlaylists == null)?"<null>":this.relatedPlaylists));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
