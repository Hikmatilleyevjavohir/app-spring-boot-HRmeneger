package uz.pdp.appspringboothrmeneger.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appspringboothrmeneger.dto.LoginDto;
import uz.pdp.appspringboothrmeneger.dto.RegisterDto;
import uz.pdp.appspringboothrmeneger.entity.Response;
import uz.pdp.appspringboothrmeneger.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    private HttpEntity<?> register(@RequestBody RegisterDto registerDto) {
        Response response = authService.register(registerDto);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST).body(response);
    }

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody LoginDto loginDto) {
        Response login = authService.login(loginDto);
        return ResponseEntity.status(login.isSuccess() ? 200 : 401).body(login);
    }

    @PostMapping("/verify")
    public HttpEntity<?> verifyEmail(@RequestParam String emailCode, @RequestParam String email, @RequestBody LoginDto loginDto) {
        Response response = authService.verifyEmail(emailCode, email, loginDto);
        return ResponseEntity.status(response.isSuccess() ? HttpStatus.ACCEPTED : HttpStatus.ALREADY_REPORTED).body(response);
    }
}
