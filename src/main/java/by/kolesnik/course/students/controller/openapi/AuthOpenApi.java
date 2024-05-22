package by.kolesnik.course.students.controller.openapi;

import by.kolesnik.course.students.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;

@Tag(name = "Авторизация и регистрация пользователей", description = "Данный контроллер позволяет идентифицировать пользователя и определить его права либо зарегистрировать нового пользователя")
public interface AuthOpenApi {

    @Operation(
            method = "POST",
            summary = "Авторизация",
            description = "Идентификация пользователя по введенным email и паролю и предоставление прав соответственно роли",
            tags = "работа с пользователями",
            security = @SecurityRequirement(name = "Общедоступная страница"),
            requestBody = @RequestBody(
                    description = "Авторизация пользователя",
                    required = true,
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @ApiResponses({
            @ApiResponse(
                    description = "Пользователь успешно авторизован",
                    responseCode = "200",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = TokenResponseDto.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                           "token": "enJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbkBnbWFpbC5jb20iLCJpYXQiOjE3MTYzMjYwNTAsImV4cCI6MTcxNjkzMDg1MH0.9V3_8lYQvYNddjg-uHN5fKEY2fDtZeFfM7Nk9C-WJIE"
                                         }
                                    ]
                                    """)
                    )
            ),
            @ApiResponse(
                    description = "не верный синтаксис json",
                    responseCode = "400",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject("""
                                    [
                                        {
                                             "timestamp": "2024-05-21T22:26:04.867+00:00",
                                             "status": 400,
                                             "error": "Bad Request",
                                             "path": "/auth/login"
                                           }
                                    ]
                                    """)
                    )
            ),
            @ApiResponse(
                    description = "не верный логин или пароль",
                    responseCode = "403",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = ErrorResponse.class),
                            examples = @ExampleObject("""
                                    [
                                        {
                                              "timestamp": "2024-05-21T22:28:23.143+00:00",
                                              "status": 403,
                                              "error": "Forbidden",
                                              "path": "/auth/login"
                                            }
                                    ]
                                    """)
                    )
            )
    }
    )
    TokenResponseDto login(@RequestBody LoginRequestDto dto);

    @Operation(
            method = "POST",
            summary = "Регистрация пользователя",
            description = "Сохранение нового пользователя в базу данных с ролью user",
            tags = "работа с пользователями",
            security = @SecurityRequirement(name = "Общедоступная страница"),
            requestBody = @RequestBody(
                    description = "Сохранение пользователя в базе данных",
                    required = true,
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    TokenResponseDto register(@RequestBody RegisterRequestDto dto);
}
