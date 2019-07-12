package test.task.com.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserIdDTO {

    private long id;

    public UserIdDTO(long id) {
        this.id = id;
    }

    public static UserIdDTO of(long id) {
        return new UserIdDTO(id);
    }
}
