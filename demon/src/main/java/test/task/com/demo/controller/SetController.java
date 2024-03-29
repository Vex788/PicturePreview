package test.task.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.task.com.demo.dto.PictureUrlsDTO;
import test.task.com.demo.dto.UserIdDTO;
import test.task.com.demo.image_operations.ImageDownload;
import test.task.com.demo.image_operations.ImageResize;
import test.task.com.demo.model.UserRequest;
import test.task.com.demo.services.UserRequestServiceImpl;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class SetController {

    @Autowired
    private UserRequestServiceImpl userRequestService;

    @GetMapping("/set")
    public UserIdDTO onSet(@RequestBody PictureUrlsDTO pictureUrlsDTO) {
        UserRequest userRequest = new UserRequest();

        userRequestService.save(userRequest); // hardcode for get new id

        // download pictures
        Collection<String> avatarPictures =
                ImageDownload.download(userRequest.getId(), pictureUrlsDTO.getPictureUrls());
        // resize 100x100
        ImageResize.resize(avatarPictures);

        userRequest.setPictureUrls(pictureUrlsDTO.getPictureUrls()); // set urls on image
        userRequest.setAvatarPictures(avatarPictures); // set the path to the processed images

        userRequestService.save(userRequest); // save to db

        return new UserIdDTO(userRequest.getId()); // send request id
    }
}
