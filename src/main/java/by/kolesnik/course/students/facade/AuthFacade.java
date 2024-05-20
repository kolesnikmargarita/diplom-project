package by.kolesnik.course.students.facade;

import by.kolesnik.course.students.dto.LoginRequestDto;
import by.kolesnik.course.students.dto.RegisterRequestDto;
import by.kolesnik.course.students.dto.TokenResponseDto;
import by.kolesnik.course.students.entity.User;
import by.kolesnik.course.students.mapper.UserMapper;
import by.kolesnik.course.students.service.AuthService;
import by.kolesnik.course.students.service.JwtService;
import by.kolesnik.course.students.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class AuthFacade {

    private final JwtService jwtService;
    private final AuthService authService;
    private final UserService userService;

    @Transactional(readOnly = true)
    public TokenResponseDto login(LoginRequestDto dto) {
        // login
        authService.login(dto.getUsername(), dto.getPassword());

        // token generation
        return jwtService.generateToken(dto.getUsername());
    }

    @Transactional
    public TokenResponseDto register(RegisterRequestDto dto) {

        final User user = UserMapper.toEntity(dto);

        // создание пользователя
        userService.createUser(user);
        authService.login(user.getEmail(), user.getPassword());

        // token generation
        return jwtService.generateToken(user.getEmail());
    }
}
