package cineplex_accademy.service;

import cineplex_accademy.dto.UserDto;
import cineplex_accademy.entity.User;
import cineplex_accademy.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public ResponseEntity<String> registerUser(UserDto userDto) {
        User user = new User(
                userDto.getId(),userDto.getUsername(),passwordEncoder.encode(userDto.getPassword()),userDto.getRole()
        );
        userRepo.save(user);
        return new ResponseEntity<>("save successfully", HttpStatus.OK);
    }

    public String authentication(UserDto userDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userDto.getUsername(),userDto.getPassword()
        ));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(userDto.getUsername());
        }
        throw new RuntimeException();
    }

    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }
}
