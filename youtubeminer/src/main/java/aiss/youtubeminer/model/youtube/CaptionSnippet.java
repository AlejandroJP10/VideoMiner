
package aiss.youtubeminer.model.youtube;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "videoId",
    "lastUpdated",
    "trackKind",
    "language",
    "name",
    "audioTrackType",
    "isCC",
    "isLarge",
    "isEasyReader",
    "isDraft",
    "isAutoSynced",
    "status"
})
@Generated("jsonschema2pojo")
public class CaptionSnippet {

    @JsonProperty("videoId")
    private String videoId;
    @JsonProperty("lastUpdated")
    private String lastUpdated;
    @JsonProperty("trackKind")
    private String trackKind;
    @JsonProperty("language")
    private String language;
    @JsonProperty("name")
    private String name;
    @JsonProperty("audioTrackType")
    private String audioTrackType;
    @JsonProperty("isCC")
    private Boolean isCC;
    @JsonProperty("isLarge")
    private Boolean isLarge;
    @JsonProperty("isEasyReader")
    private Boolean isEasyReader;
    @JsonProperty("isDraft")
    private Boolean isDraft;
    @JsonProperty("isAutoSynced")
    private Boolean isAutoSynced;
    @JsonProperty("status")
    private String status;

    @JsonProperty("videoId")
    public String getVideoId() {
        return videoId;
    }

    @JsonProperty("videoId")
    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @JsonProperty("lastUpdated")
    public String getLastUpdated() {
        return lastUpdated;
    }

    @JsonProperty("lastUpdated")
    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @JsonProperty("trackKind")
    public String getTrackKind() {
        return trackKind;
    }

    @JsonProperty("trackKind")
    public void setTrackKind(String trackKind) {
        this.trackKind = trackKind;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("name")
    public String getName() {
        if (this.name == null || this.name.trim().isEmpty()) {
            return "Sin nombre";
        } else {
            return this.name;
        }
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("audioTrackType")
    public String getAudioTrackType() {
        return audioTrackType;
    }

    @JsonProperty("audioTrackType")
    public void setAudioTrackType(String audioTrackType) {
        this.audioTrackType = audioTrackType;
    }

    @JsonProperty("isCC")
    public Boolean getIsCC() {
        return isCC;
    }

    @JsonProperty("isCC")
    public void setIsCC(Boolean isCC) {
        this.isCC = isCC;
    }

    @JsonProperty("isLarge")
    public Boolean getIsLarge() {
        return isLarge;
    }

    @JsonProperty("isLarge")
    public void setIsLarge(Boolean isLarge) {
        this.isLarge = isLarge;
    }

    @JsonProperty("isEasyReader")
    public Boolean getIsEasyReader() {
        return isEasyReader;
    }

    @JsonProperty("isEasyReader")
    public void setIsEasyReader(Boolean isEasyReader) {
        this.isEasyReader = isEasyReader;
    }

    @JsonProperty("isDraft")
    public Boolean getIsDraft() {
        return isDraft;
    }

    @JsonProperty("isDraft")
    public void setIsDraft(Boolean isDraft) {
        this.isDraft = isDraft;
    }

    @JsonProperty("isAutoSynced")
    public Boolean getIsAutoSynced() {
        return isAutoSynced;
    }

    @JsonProperty("isAutoSynced")
    public void setIsAutoSynced(Boolean isAutoSynced) {
        this.isAutoSynced = isAutoSynced;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CaptionSnippet.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("videoId");
        sb.append('=');
        sb.append(((this.videoId == null)?"<null>":this.videoId));
        sb.append(',');
        sb.append("lastUpdated");
        sb.append('=');
        sb.append(((this.lastUpdated == null)?"<null>":this.lastUpdated));
        sb.append(',');
        sb.append("trackKind");
        sb.append('=');
        sb.append(((this.trackKind == null)?"<null>":this.trackKind));
        sb.append(',');
        sb.append("language");
        sb.append('=');
        sb.append(((this.language == null)?"<null>":this.language));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("audioTrackType");
        sb.append('=');
        sb.append(((this.audioTrackType == null)?"<null>":this.audioTrackType));
        sb.append(',');
        sb.append("isCC");
        sb.append('=');
        sb.append(((this.isCC == null)?"<null>":this.isCC));
        sb.append(',');
        sb.append("isLarge");
        sb.append('=');
        sb.append(((this.isLarge == null)?"<null>":this.isLarge));
        sb.append(',');
        sb.append("isEasyReader");
        sb.append('=');
        sb.append(((this.isEasyReader == null)?"<null>":this.isEasyReader));
        sb.append(',');
        sb.append("isDraft");
        sb.append('=');
        sb.append(((this.isDraft == null)?"<null>":this.isDraft));
        sb.append(',');
        sb.append("isAutoSynced");
        sb.append('=');
        sb.append(((this.isAutoSynced == null)?"<null>":this.isAutoSynced));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
