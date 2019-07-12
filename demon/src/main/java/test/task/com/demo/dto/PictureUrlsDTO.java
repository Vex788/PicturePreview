package test.task.com.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
public class PictureUrlsDTO {

    private Collection<String> pictureUrls;

    public PictureUrlsDTO(Collection<String> pictureUrls) {
        this.pictureUrls = pictureUrls;
    }

    public static PictureUrlsDTO of(Collection<String> pictureUrls) {
        return new PictureUrlsDTO(pictureUrls);
    }
}
