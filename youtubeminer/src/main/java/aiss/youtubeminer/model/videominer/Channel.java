package aiss.youtubeminer.model.videominer;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Juan C. Alonso
 */
@Entity
@Table(name = "ChannelController")
@Schema(description = "Información del canal transformado para VideoMiner")
public class Channel {

    @Id
    @Schema(description = "ID del canal en Dailymotion", example = "x160jw6")
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    @Schema(description = "Nombre del canal", example = "Dailymotion España")
    @NotEmpty(message = "ChannelController name cannot be empty")
    private String name;

    @JsonProperty("description")
    @Schema(description = "Descripción del canal", example = "Canal oficial de RTVE")
    @Column(columnDefinition="TEXT")
    private String description;

    @JsonProperty("createdTime")
    @Schema(description = "Fecha de creación (String)", example = "2024-05-20")
    @NotEmpty(message = "ChannelController creation time cannot be empty")
    private String createdTime;

    @JsonProperty("videos")
    @Schema(description = "Lista de vídeos asociados al canal")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "channelId")
    @NotNull(message = "ChannelController videos cannot be null")
    private List<Video> videos;


    public Channel() {
        this.videos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    @Override
    public String toString() {
        return "ChannelController{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", videos=" + videos +
                '}';
    }
}