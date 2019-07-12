package test.task.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.task.com.demo.dto.AvatarPicturesDTO;
import test.task.com.demo.dto.UserIdDTO;
import test.task.com.demo.services.UserRequestServiceImpl;

@RestController
@RequestMapping("/")
public class GetController {

    @Autowired
    private UserRequestServiceImpl userRequestService;

    @GetMapping("/get")
    public AvatarPicturesDTO onGet(@RequestBody UserIdDTO userIdDTO) {
        return userRequestService.getAvatarPicturesDTO(userIdDTO.getId());
    }
}
