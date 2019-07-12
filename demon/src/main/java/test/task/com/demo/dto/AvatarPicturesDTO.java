package test.task.com.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
public class AvatarPicturesDTO {

    private Collection<String> avatarPictures = new ArrayList<>();

    public AvatarPicturesDTO(Collection<String> avatarPictures) {
        this.avatarPictures = avatarPictures;
    }

    public static AvatarPicturesDTO of(Collection<String> avatarPictures) {
        return new AvatarPicturesDTO(avatarPictures);
    }
}
