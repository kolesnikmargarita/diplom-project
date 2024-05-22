package by.kolesnik.course.students.controller.openapi;

import by.kolesnik.course.students.dto.ErrorResponse;
import by.kolesnik.course.students.dto.category.CategoryAddDto;
import by.kolesnik.course.students.dto.category.CategoryGetDto;
import by.kolesnik.course.students.dto.category.CategoryUpdateDto;
import by.kolesnik.course.students.dto.commodity.CommodityAddDto;
import by.kolesnik.course.students.dto.commodity.CommodityGetDto;
import by.kolesnik.course.students.dto.commodity.CommodityUpdateDto;
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
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Работа администратора с товарами", description = "Данный контроллер позволяет добавлять , удалять и  редактировать товары и категории в соответствии с правами, определяемыми ролью пользователя")
public interface EditOpenApi {

    @Operation(
            method = "POST",
            summary = "Добавить товар",
            description = "Добавление товара",
            tags = "Товары",
            security = @SecurityRequirement(name = "Страница доступна авторизованным пользователям, обладающих ролью ADMIN"),
            requestBody = @RequestBody(
                    description = "информация о товаре, добавленном в базу данных",
                    required = true,
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @ApiResponses({
            @ApiResponse(
                    description = "Товар успешно добавлен в базу данных",
                    responseCode = "200",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = CommodityGetDto.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                                   "id": 9,
                                                   "article": 1344323,
                                                   "name": "Скотч",
                                                   "price": 11.67,
                                                   "description": "Скотч двусторонний полипропиленовый, 25мХ5см",
                                                   "categoryName": "Colors"
                                               }
                                    ]
                                    """)
                    )
            ),
            @ApiResponse(
                    description = "Не известная ошибка сервера (не корректные данные о товаре)",
                    responseCode = "500",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                            "timestamp": "2024-05-22T00:03:29.294+00:00",
                                            "status": 500,
                                            "error": "Internal Server Error",
                                            "path": "/edit/Colors"
                                        }
                                    ]
                                    """)
                    )
            ),
            @ApiResponse(
                    description = "Не верный синтаксис json",
                    responseCode = "400",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                             "timestamp": "2024-05-22T00:35:32.904+00:00",
                                             "status": 400,
                                             "error": "Bad Request",
                                             "path": "/edit/Colors"
                                         }
                                    ]
                                    """)
                    )
            ),
            @ApiResponse(
                    description = "Отсутствуют права доступа",
                    responseCode = "403",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                             "timestamp": "2024-05-22T00:08:23.274+00:00",
                                             "status": 403,
                                             "error": "Forbidden",
                                             "path": "/edit/Colors"
                                         }
                                    ]
                                    """)
                    )
            )

    }
    )
    CommodityGetDto addCommodity(@PathVariable String categoryName, @RequestBody CommodityAddDto dto);

    @Operation(
            method = "DELETE",
            summary = "Удалить товар",
            description = "Удаление товара по артикулу",
            tags = "Товары",
            security = @SecurityRequirement(name = "Страница доступна авторизованным пользователям, обладающих ролью ADMIN"),
            requestBody = @RequestBody(
                    description = "удаление товара из базы данных",
                    required = true
            )
    )
    @ApiResponses({
            @ApiResponse(
                    description = "Товар успешно удален",
                    responseCode = "200"
            ),
            @ApiResponse(
                    description = "Не известная ошибка сервера (не корректные данные о товаре)",
                    responseCode = "500",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                            "timestamp": "2024-05-22T00:03:29.294+00:00",
                                            "status": 500,
                                            "error": "Internal Server Error",
                                            "path": "/edit/1234567"
                                        }
                                    ]
                                    """)
                    )
            ),
            @ApiResponse(
                    description = "Не верный синтаксис json",
                    responseCode = "400",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                             "timestamp": "2024-05-22T00:35:32.904+00:00",
                                             "status": 400,
                                             "error": "Bad Request",
                                             "path": "/edit/1234567"
                                         }
                                    ]
                                    """)
                    )
            ),
            @ApiResponse(
                    description = "Отсутствуют права доступа",
                    responseCode = "403",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                             "timestamp": "2024-05-22T00:08:23.274+00:00",
                                             "status": 403,
                                             "error": "Forbidden",
                                             "path": "/edit/1234567"
                                         }
                                    ]
                                    """)
                    )
            )

    }
    )
    void deleteCommodity(@PathVariable Integer article);

    @Operation(
            method = "POST",
            summary = "Добавить категорию",
            description = "Добавление категории",
            tags = "Категории товаров",
            security = @SecurityRequirement(name = "Страница доступна авторизованным пользователям, обладающих ролью ADMIN"),
            requestBody = @RequestBody(
                    description = "информация о категории, добавленной в базу данных",
                    required = true,
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @ApiResponses({
            @ApiResponse(
                    description = "Категория успешно добавлена в базу данных",
                    responseCode = "200",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = CategoryGetDto.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                            "id": 6,
                                            "name": "Electric"
                                        }
                                    ]
                                    """)
                    )
            ),
            @ApiResponse(
                    description = "Не известная ошибка сервера (не корректные данные о товаре)",
                    responseCode = "500",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                            "timestamp": "2024-05-22T00:03:29.294+00:00",
                                            "status": 500,
                                            "error": "Internal Server Error",
                                            "path": "/edit"
                                        }
                                    ]
                                    """)
                    )
            ),
            @ApiResponse(
                    description = "Не верный синтаксис json",
                    responseCode = "400",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                             "timestamp": "2024-05-22T00:35:32.904+00:00",
                                             "status": 400,
                                             "error": "Bad Request",
                                             "path": "/edit"
                                         }
                                    ]
                                    """)
                    )
            ),
            @ApiResponse(
                    description = "Отсутствуют права доступа",
                    responseCode = "403",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                             "timestamp": "2024-05-22T00:08:23.274+00:00",
                                             "status": 403,
                                             "error": "Forbidden",
                                             "path": "/edit"
                                         }
                                    ]
                                    """)
                    )
            )

    }
    )
    CategoryGetDto addCategory(@RequestBody CategoryAddDto category);

    @Operation(
            method = "PATCH",
            summary = "Изменить товар",
            description = "Изменение некоторой информации о товаре",
            tags = "Товары",
            security = @SecurityRequirement(name = "Страница доступна авторизованным пользователям, обладающих ролью ADMIN"),
            requestBody = @RequestBody(
                    description = "информация о товаре с изменениями",
                    required = true,
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @ApiResponses({
            @ApiResponse(
                    description = "Информация о товаре успешно изменена",
                    responseCode = "200",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = CommodityGetDto.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                             "id": 7,
                                             "article": 1234567,
                                             "name": "Рулетка",
                                             "price": 3.45,
                                             "description": "Рулетка 2.5 метра, материал корпуса - пластик",
                                             "categoryName": "Tools"
                                        }
                                    ]
                                    """)
                    )
            ),
            @ApiResponse(
                    description = "Не известная ошибка сервера (не корректные данные о товаре)",
                    responseCode = "500",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                            "timestamp": "2024-05-22T00:03:29.294+00:00",
                                            "status": 500,
                                            "error": "Internal Server Error",
                                            "path": "/edit/1234567"
                                        }
                                    ]
                                    """)
                    )
            ),
            @ApiResponse(
                    description = "Не верный синтаксис json",
                    responseCode = "400",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                             "timestamp": "2024-05-22T00:35:32.904+00:00",
                                             "status": 400,
                                             "error": "Bad Request",
                                             "path": "/edit/1234567"
                                         }
                                    ]
                                    """)
                    )
            ),
            @ApiResponse(
                    description = "Отсутствуют права доступа",
                    responseCode = "403",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                             "timestamp": "2024-05-22T00:08:23.274+00:00",
                                             "status": 403,
                                             "error": "Forbidden",
                                             "path": "/edit/1234567"
                                         }
                                    ]
                                    """)
                    )
            )

    }
    )
    CommodityGetDto updateCommodity(@PathVariable Integer article, @RequestBody CommodityUpdateDto dto);

    @Operation(
            method = "PUT",
            summary = "Изменить категорию",
            description = "Изменение информации о категории",
            tags = "Товары",
            security = @SecurityRequirement(name = "Страница доступна авторизованным пользователям, обладающих ролью ADMIN"),
            requestBody = @RequestBody(
                    description = "информация о категории с изменениями",
                    required = true,
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @ApiResponses({
            @ApiResponse(
                    description = "Информация о категории успешно изменена",
                    responseCode = "200",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = CategoryGetDto.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                             "id": 6,
                                             "name": "Electronics"
                                         }
                                    ]
                                    """)
                    )
            ),
            @ApiResponse(
                    description = "Не известная ошибка сервера (не корректные данные о товаре)",
                    responseCode = "500",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                            "timestamp": "2024-05-22T00:03:29.294+00:00",
                                            "status": 500,
                                            "error": "Internal Server Error",
                                            "path": "/edit/Electric"
                                        }
                                    ]
                                    """)
                    )
            ),
            @ApiResponse(
                    description = "Не верный синтаксис json",
                    responseCode = "400",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                             "timestamp": "2024-05-22T00:35:32.904+00:00",
                                             "status": 400,
                                             "error": "Bad Request",
                                             "path": "/edit/Electric"
                                         }
                                    ]
                                    """)
                    )
            ),
            @ApiResponse(
                    description = "Отсутствуют права доступа",
                    responseCode = "403",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                             "timestamp": "2024-05-22T00:08:23.274+00:00",
                                             "status": 403,
                                             "error": "Forbidden",
                                             "path": "/edit/Electric"
                                         }
                                    ]
                                    """)
                    )
            )

    }
    )
    CategoryGetDto updateCategory(@PathVariable String categoryName, @RequestBody CategoryUpdateDto dto);
}
