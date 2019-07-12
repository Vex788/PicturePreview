package test.task.com.demo.services;

import test.task.com.demo.dto.AvatarPicturesDTO;
import test.task.com.demo.dto.PictureUrlsDTO;
import test.task.com.demo.model.UserRequest;

import java.util.Collection;

public interface UserRequestService {
    void save(UserRequest userRequest);

    void clear();

    UserRequest getUserRequest(long id);

    AvatarPicturesDTO getAvatarPicturesDTO(long id);

    PictureUrlsDTO getPictureUrlsDTO(long id);

    Collection<UserRequest> getAllUserRequests();
}
