package by.kolesnik.course.students.controller;

import by.kolesnik.course.students.controller.openapi.AuthOpenApi;
import by.kolesnik.course.students.dto.LoginRequestDto;
import by.kolesnik.course.students.dto.RegisterRequestDto;
import by.kolesnik.course.students.dto.TokenResponseDto;
import by.kolesnik.course.students.dto.UserRegistrationDto;
import by.kolesnik.course.students.facade.AuthFacade;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@SecurityScheme(type = SecuritySchemeType.HTTP, name = "basicAuth", scheme = "bearer", bearerFormat = "bearer")
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController implements AuthOpenApi {

    private final AuthFacade authFacade;

    @Override
    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody LoginRequestDto dto) {
        return authFacade.login(dto);
    }

    @Override
    @PostMapping("/registration")
    public TokenResponseDto register(@RequestBody RegisterRequestDto dto) {

        return authFacade.register(dto);
    }
}
