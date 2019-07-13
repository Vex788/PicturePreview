package test.task.com.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import test.task.com.demo.image_operations.ImageDownload;
import test.task.com.demo.image_operations.ImageResize;
import test.task.com.demo.model.UserRequest;
import test.task.com.demo.services.UserRequestServiceImpl;

import java.util.ArrayList;
import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    public UserRequestServiceImpl userRequestService;

    @Test
    public void createUserRequests() {
        System.out.println("createUserRequests");
        userRequestService.clear();

        for (int i = 0; i < 10; i++) {
            UserRequest userRequest = new UserRequest();

            userRequest.setPictureUrls(null);
            userRequest.setAvatarPictures(null);

            userRequestService.save(userRequest);
            System.out.println("User created: " + userRequest.getId());
        }
        Assert.assertEquals(10, userRequestService.getAllUserRequests().size());
    }

    @Test
    @Transactional
    public void doGet() {
        System.out.println("doGet");
        userRequestService.clear();

        for (int i = 0; i < 10; i++) {
            UserRequest userRequest = new UserRequest();

            Collection<String> pictures = new ArrayList<>();

            pictures.add("https://i.ytimg.com/vi/YCaGYUIfdy4/maxresdefault.jpg");
            pictures.add("https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");

            Collection<String> avatars = ImageDownload.download(i + 1, pictures);
            ImageResize.resize(avatars);

            userRequest.setPictureUrls(pictures);
            userRequest.setAvatarPictures(avatars);

            userRequestService.save(userRequest);
            System.out.println("User created: " + userRequest.getId());
        }

        Collection<UserRequest> userRequestCollection = userRequestService.getAllUserRequests();
        int count = 0;

        for (UserRequest userRequest : userRequestCollection) {
            Assert.assertEquals(2, userRequest.getAvatarPictures().size());
            count += userRequest.getAvatarPictures().size();
        }

        Assert.assertEquals(20, count);
    }

    @Test
    public void doSet() {
        System.out.println("doSet");
        userRequestService.clear();

        for (int i = 0; i < 10; i++) {
            UserRequest userRequest = new UserRequest();

            Collection<String> pictures = new ArrayList<>();

            pictures.add("https://i.ytimg.com/vi/YCaGYUIfdy4/maxresdefault.jpg");
            pictures.add("https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");

            userRequest.setPictureUrls(pictures);
            userRequest.setAvatarPictures(pictures);

            userRequestService.save(userRequest);
        }
            Collection<UserRequest> userRequestCollection = userRequestService.getAllUserRequests();

        for (UserRequest userRequest : userRequestCollection) {
            Collection<String> pictures = new ArrayList<>();

            pictures.add("https://i.ytimg.com/vi/YCaGYUIfdy4/maxresdefault.jpg");
            pictures.add("https://images.unsplash.com/photo-1518791841217-8f162f1e1131?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");

            userRequest.setPictureUrls(pictures);
            userRequest.setAvatarPictures(pictures);

            userRequestService.save(userRequest);

            System.out.println("User ID: " + userRequest.getId());

            Assert.assertEquals(2, userRequest.getPictureUrls().size());
            Assert.assertEquals(2, userRequest.getAvatarPictures().size());
        }
    }
}
