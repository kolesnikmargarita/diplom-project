package by.kolesnik.course.students.controller.openapi;

import by.kolesnik.course.students.dto.ErrorResponse;
import by.kolesnik.course.students.dto.TokenResponseDto;
import by.kolesnik.course.students.dto.commodity.CommodityGetDto;
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

import java.util.List;

@Tag(name = "Работа с корзиной пользователя", description = "Данный контроллер позволяет пользователю добавлять товары в корзину, удалять их, и просматривать список товаров, добавленных им в корзину")
public interface CartOpenApi {

    @Operation(
            method = "GET",
            summary = "Список товаров в корзине",
            description = "Вывод товаров, добавленных пользователем в корзину",
            tags = "Корзина",
            security = @SecurityRequirement(name = "Страница доступна всем авторизованным пользователям"),
            requestBody = @RequestBody(
                    description = "Список товаров, добавленных текущим пользователем в корзину",
                    required = true,
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @ApiResponses({
            @ApiResponse(
                    description = "Выведен список товаров в корзине текущего пользователя",
                    responseCode = "200",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = CommodityGetDto.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                                  "id": 8,
                                                  "article": 7654321,
                                                  "name": "Краска",
                                                  "price": 10.76,
                                                  "description": "Краска водоэмульсионная Alpina 2 кг белая",
                                                  "categoryName": "Colors"
                                              },
                                              {
                                                  "id": 2,
                                                  "article": 1345678,
                                                  "name": "Ключ гаечный",
                                                  "price": 1.2,
                                                  "description": "ключ гаечный 12-13",
                                                  "categoryName": "Tools"
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
                                             "path": "/cart"
                                         }
                                    ]
                                    """)
                    )
            )
    }
    )
    List<CommodityGetDto> getAll();

    @Operation(
            method = "POST",
            summary = "Добавление товара в корзину",
            description = "добавление товара в корзину текущего пользователя по артикулу товара",
            tags = "Корзина",
            security = @SecurityRequirement(name = "Страница доступна всем авторизованным пользователям"),
            requestBody = @RequestBody(
                    description = "Описание товара, добавленного в корзину",
                    required = true,
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @ApiResponses({
            @ApiResponse(
                    description = "Товар успешно добавлен в корзину",
                    responseCode = "200",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = CommodityGetDto.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                                  "id": 8,
                                                  "article": 7654321,
                                                  "name": "Краска",
                                                  "price": 10.76,
                                                  "description": "Краска водоэмульсионная Alpina 2 кг белая",
                                                  "categoryName": "Colors"
                                              }
                                    ]
                                    """)
                    )
            ),
            @ApiResponse(
                    description = "Товар с указанным артикулом не найден",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                           "message": "Товар с артикулом 1111111 не найден"
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
                                             "path": "/cart/1111111"
                                         }
                                    ]
                                    """)
                    )
            )
    }
    )
    CommodityGetDto add(@PathVariable Integer article);


    @Operation(
            method = "DELETE",
            summary = "Удаление товара из корзины",
            description = "Удаление товара из корзины текущего пользователя по артикулу товара",
            tags = "Корзина",
            security = @SecurityRequirement(name = "Страница доступна всем авторизованным пользователям"),
            requestBody = @RequestBody(
                    required = true
            )
    )
    @ApiResponses({
            @ApiResponse(
                    description = "Товар успешно удален",
                    responseCode = "200"
            ),
            @ApiResponse(
                    description = "Товар с указанным артикулом не найден",
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = ErrorResponse.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                           "message": "Товар с артикулом 1111111 не найден"
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
                                             "path": "/cart/1111111"
                                         }
                                    ]
                                    """)
                    )
            )
    }
    )
    void delete(@PathVariable Integer article);
}
