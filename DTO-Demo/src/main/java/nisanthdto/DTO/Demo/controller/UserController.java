package nisanthdto.DTO.Demo.controller;

import nisanthdto.DTO.Demo.dto.UserLocationDTO;
import nisanthdto.DTO.Demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController
{
    @Autowired
    private UserService userService;
    @GetMapping("/users-location")
    public List<UserLocationDTO> getAllusersLocation()
    {
        return userService.getAllUsersLocaion();
    }
}
