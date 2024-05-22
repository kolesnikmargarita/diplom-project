package by.kolesnik.course.students.controller.openapi;

import by.kolesnik.course.students.dto.ErrorResponse;
import by.kolesnik.course.students.dto.category.CategoryAddDto;
import by.kolesnik.course.students.dto.category.CategoryGetDto;
import by.kolesnik.course.students.dto.category.CategoryUpdateDto;
import by.kolesnik.course.students.dto.category.CategoryDto;
import by.kolesnik.course.students.dto.commodity.CommodityAddDto;
import by.kolesnik.course.students.dto.commodity.CommodityDto;
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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Работа с товарами", description = "Данный контроллер позволяет просматривать товары, категории товаров, товары по категориям")
public interface ShopOpenApi {

    @Operation(
            method = "GET",
            summary = "Список всех товаров",
            description = "Вывод товаров, добавленных пользователем в корзину",
            tags = "Товары",
            security = @SecurityRequirement(name = "Страница доступна всем авторизованным пользователям"),
            requestBody = @RequestBody(
                    description = "Список товаров, находящихся в базе данных",
                    required = true,
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @ApiResponses({
            @ApiResponse(
                    description = "Информация о товарах отображена",
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
                                                  "description": "ключ гаечный открытый 12-13",
                                                  "categoryName": "Tools"
                                              },
                                              {
                                                  "id": 9,
                                                  "article": 1344323,
                                                  "name": "Скотч",
                                                  "price": 11.67,
                                                  "description": "Скотч двусторонний полипропиленовый, 25мХ5см",
                                                  "categoryName": "Colors"
                                              },
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
            )
    }
    )
    List<CommodityGetDto> getAll();

    @Operation(
            method = "GET",
            summary = "Список всех категорий",
            description = "Вывод категорий товаров",
            tags = "Категории товаров",
            security = @SecurityRequirement(name = "Страница доступна всем авторизованным пользователям"),
            requestBody = @RequestBody(
                    description = "Список категорий, находящихся в базе данных",
                    required = true,
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @ApiResponses({
            @ApiResponse(
                    description = "Информация о категориях отображена",
                    responseCode = "200",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = CategoryGetDto.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                                "id": 4,
                                                "name": "Tools"
                                            },
                                            {
                                                "id": 5,
                                                "name": "Colors"
                                            },
                                            {
                                                "id": 6,
                                                "name": "Electronics"
                                            }
                                    ]
                                    """)
                    )
            )
    }
    )
    List<CategoryGetDto> getCategories();

    @Operation(
            method = "GET",
            summary = "Список всех товаров категории",
            description = "Вывод товаров, относящихся к выбранной категории",
            tags = "Товары",
            security = @SecurityRequirement(name = "Страница доступна всем авторизованным пользователям"),
            requestBody = @RequestBody(
                    description = "Список товаров, относящихся к категории",
                    required = true,
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE
                    )
            )
    )
    @ApiResponses({
            @ApiResponse(
                    description = "Информация о товарах категории отображена",
                    responseCode = "200",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            array = @ArraySchema(schema = @Schema(implementation = CommodityGetDto.class)),
                            examples = @ExampleObject("""
                                    [
                                        {
                                                     "id": 2,
                                                     "article": 1345678,
                                                     "name": "Ключ гаечный",
                                                     "price": 1.2,
                                                     "description": "ключ гаечный открытый 12-13",
                                                     "categoryName": "Tools"
                                                 },
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
            )
    }
    )
    List<CommodityGetDto> getCommodities(@PathVariable String categoryName);
}
