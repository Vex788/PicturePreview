package test.task.com.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class UserRequest {
    @Id
    @GeneratedValue
    private long id;

    @ElementCollection
    private Collection<String> pictureUrls;

    @ElementCollection
    private Collection<String> avatarPictures;
}
