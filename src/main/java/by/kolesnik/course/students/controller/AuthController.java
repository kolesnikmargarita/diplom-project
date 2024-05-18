package by.kolesnik.course.students.controller;

import by.kolesnik.course.students.dto.LoginRequestDto;
import by.kolesnik.course.students.dto.RegisterRequestDto;
import by.kolesnik.course.students.dto.TokenResponseDto;
import by.kolesnik.course.students.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthFacade authFacade;

    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody LoginRequestDto dto) {
        return authFacade.login(dto);
    }

    @PostMapping("/registration")
    public TokenResponseDto register(@RequestBody RegisterRequestDto dto) {

        return authFacade.register(dto);
    }
}
