package cineplex_accademy.controller;


import cineplex_accademy.dto.UserDto;
import cineplex_accademy.dto.response.LoginResponse;
import cineplex_accademy.entity.User;
import cineplex_accademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/authentication")
    public ResponseEntity<LoginResponse> authentication(@RequestBody UserDto userDto){
        String token =userService.authentication(userDto);
        User user = userService.findByUsername(userDto.getUsername());
        if(user==null){
            return null;
        }
      return new ResponseEntity<>(new LoginResponse(user,token), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> register(@RequestBody UserDto userDto){
        return userService.registerUser(userDto);

    }


}
