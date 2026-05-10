package aiss.dailymotionminer.service;

import aiss.dailymotionminer.model.dailymotion.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DailymotionServiceTest {

    @Autowired
    DailymotionService service;

    // Usa un canal real de Dailymotion
    private final String realUserId = "x51lpey";   // Canal real de ejemplo
    private final String realVideoId = "xn6y98";  // Vídeo real de ejemplo

    @Test
    @DisplayName("Get Channel from Dailymotion")
    void getChannel() {
        Channel channel = service.getChannel(realUserId);
        assertNotNull(channel, "El canal no puede ser null");
        assertNotNull(channel.getId(), "El canal debe tener id");
        System.out.println(channel);
    }

    @Test
    @DisplayName("Get List of Videos from Dailymotion")
    void getListVideos() {
        List<Video> videos = service.getListVideos(realUserId, 5, 1);
        assertNotNull(videos, "La lista no puede ser null");
        assertFalse(videos.isEmpty(), "La lista de vídeos está vacía");
        System.out.println(videos);
        System.out.println("Total vídeos: " + videos.size());
    }

    @Test
    @DisplayName("Get User from Dailymotion")
    void getUser() {
        User user = service.getUser(realUserId);
        assertNotNull(user, "El usuario no puede ser null");
        assertNotNull(user.getId(), "El usuario debe tener id");
        System.out.println(user);
    }

    @Test
    @DisplayName("Get Tags from Dailymotion Video")
    void getTags() {
        Tag tags = service.getTags(realVideoId);
        // Puede ser null si el vídeo no tiene tags
        if (tags != null) {
            assertNotNull(tags.getTags(), "La lista de tags no puede ser null");
            System.out.println(tags.getTags());
        } else {
            System.out.println("El vídeo no tiene tags o no existen");
        }
    }

    @Test
    @DisplayName("Get Subtitles from Dailymotion Video")
    void getSubtitles() {
        SubtitleContainer subtitles = service.getSubtitles(realVideoId);
        // Puede ser null si no hay subtítulos
        if (!subtitles.getList().isEmpty()) {
            assertNotNull(subtitles.getList(), "La lista de subtítulos no puede ser null");
            System.out.println(subtitles.getList());
        } else {
            System.out.println("El vídeo no tiene subtítulos o no existen");
        }
    }
}
