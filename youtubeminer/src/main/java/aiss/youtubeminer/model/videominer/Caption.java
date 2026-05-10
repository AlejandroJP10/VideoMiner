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
@Table(name = "Caption")
@Schema(description = "Subtítulo del vídeo")
public class Caption {

    @Id
    @JsonProperty("id")
    @Schema(description = "ID del subtítulo", example = "en-US")
    private String id;

    @Column(name="name")
    @JsonProperty("name")
    @Schema(description = "Nombre o URL del subtítulo", example = "https://www.dailymotion.com/...")
    private String name;

    @Column(name="language")
    @JsonProperty("language")
    @Schema(description = "Idioma del subtítulo", example = "English")
    private String language;


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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Caption{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}