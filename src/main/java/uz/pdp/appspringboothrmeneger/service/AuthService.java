package uz.pdp.appspringboothrmeneger.service;

import org.springframework.stereotype.Service;
import uz.pdp.appspringboothrmeneger.dto.LoginDto;
import uz.pdp.appspringboothrmeneger.dto.RegisterDto;
import uz.pdp.appspringboothrmeneger.entity.Response;

@Service
public interface AuthService {

    Response register(RegisterDto registerDto);

    Response login(LoginDto loginDto);

    Response verifyEmail(String emailCode, String email, LoginDto loginDto);
}
