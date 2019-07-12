package test.task.com.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.task.com.demo.dto.AvatarPicturesDTO;
import test.task.com.demo.dto.PictureUrlsDTO;
import test.task.com.demo.model.UserRequest;
import test.task.com.demo.repo.UserRequestRepository;

import java.util.Collection;

@Service
public class UserRequestServiceImpl implements UserRequestService {

    private final UserRequestRepository userRequestRepository;

    public UserRequestServiceImpl(UserRequestRepository userRequestRepository) {
        this.userRequestRepository = userRequestRepository;
    }

    @Override
    @Transactional
    public void save(UserRequest userRequest) {
        userRequestRepository.save(userRequest);
    }

    @Override
    public void clear() {
        userRequestRepository.deleteAll();
    }

    @Override
    @Transactional
    public UserRequest getUserRequest(long id) {
        return userRequestRepository.findById(id).get();
    }

    @Override
    @Transactional
    public AvatarPicturesDTO getAvatarPicturesDTO(long id) {
        return new AvatarPicturesDTO(userRequestRepository.findById(id).get().getAvatarPictures());
    }

    @Override
    @Transactional
    public PictureUrlsDTO getPictureUrlsDTO(long id) {
        return new PictureUrlsDTO(userRequestRepository.findById(id).get().getPictureUrls());
    }

    @Override
    public Collection<UserRequest> getAllUserRequests() {
        return userRequestRepository.findAll();
    }
}
