package aiss.youtubeminer.model.videominer;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Juan C. Alonso
 */
@Entity
@Table(name = "Comment")
@Schema(description = "Comentario del vídeo (generado a partir de los Tags de Dailymotion)")
public class Comment {

    @Id
    @JsonProperty("id")
    @Schema(description = "ID generado para el comentario", example = "v123-tag-0")
    private String id;

    @JsonProperty("text")
    @Column(columnDefinition="TEXT", name = "text")
    @Schema(description = "Texto del tag", example = "Música")
    private String text;

    @JsonProperty("createdOn")
    @Column(name="createdOn")
    @Schema(description = "Fecha de creación del comentario")
    private String createdOn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }


    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", createdOn='" + createdOn + '\'' +
                '}';
    }
}