package aiss.youtubeminer.model.videominer;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

/**
 * @author Juan C. Alonso
 */
@Entity
@Table(name = "Video")
@Schema(description = "Vídeo extraído de Dailymotion")
public class Video {

    @Id
    @JsonProperty("id")
    @Schema(description = "ID único del vídeo", example = "x8m9v2")
    private String id;

    @JsonProperty("name")
    @Column(name="name")
    @NotEmpty(message = "Video name cannot be empty")
    @Schema(description = "Título del vídeo", example = "Entrevista exclusiva")
    private String name;

    @JsonProperty("description")
    @Column(columnDefinition="TEXT", name="description")
    @Schema(description = "Descripción detallada del contenido")
    private String description;

    @JsonProperty("releaseTime")
    @Column(name="releaseTime")
    @NotEmpty(message = "Video release time cannot be empty")
    @Schema(description = "Fecha de publicación", example = "2023-10-15")
    private String releaseTime;

    @JsonProperty("user")
    @OneToOne(cascade = CascadeType.ALL)
    @Schema(description = "Usuario que subió el vídeo")
    private User author;

    @JsonProperty("comments")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "videoId")
    @Schema(description = "Lista de comentarios (extraídos de los tags de Dailymotion)")
    private List<Comment> comments;

    @JsonProperty("captions")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "videoId")
    @Schema(description = "Lista de subtítulos disponibles")
    private List<Caption> captions;

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

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Caption> getCaptions() {
        return captions;
    }

    public void setCaptions(List<Caption> captions) {
        this.captions = captions;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", author=" + author +
                ", comments=" + comments +
                ", captions=" + captions +
                '}';
    }
}