package stub.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stub.entities.UserDetailEntity;
import stub.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;

@Component
@RestController
@RequestMapping("/users")
class UserController {

    @GetMapping("/get/{id}")
    public UserDetailEntity getUsers(@PathVariable Long id) {
        return new UserDetailEntity(id, "name", "grade", "Some school", "City");
    }

    @GetMapping("/get/all")
    public List<UserEntity> getAllUsers() {
        ArrayList<UserEntity> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(new UserEntity((long) i, "name " + i, "Grade " + i));
        }
        return list;
    }
}