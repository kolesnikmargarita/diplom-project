package by.kolesnik.course.students.controller;

import by.kolesnik.course.students.controller.openapi.ShopOpenApi;
import by.kolesnik.course.students.dto.category.CategoryAddDto;
import by.kolesnik.course.students.dto.category.CategoryGetDto;
import by.kolesnik.course.students.dto.category.CategoryUpdateDto;
import by.kolesnik.course.students.dto.category.CategoryDto;
import by.kolesnik.course.students.dto.commodity.CommodityAddDto;
import by.kolesnik.course.students.dto.commodity.CommodityDto;
import by.kolesnik.course.students.dto.commodity.CommodityGetDto;
import by.kolesnik.course.students.dto.commodity.CommodityUpdateDto;
import by.kolesnik.course.students.facade.CategoriesFacade;
import by.kolesnik.course.students.facade.CommoditiesFacade;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityScheme(type = SecuritySchemeType.HTTP, name = "basicAuth", scheme = "bearer", bearerFormat = "bearer")
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController implements ShopOpenApi {

    private final CategoriesFacade categoriesFacade;
    private final CommoditiesFacade commoditiesFacade;

    //@Override
    @GetMapping
    public List<CommodityGetDto> getAll() {
        return commoditiesFacade.getAll();
    }

    @Override
    @GetMapping("/categories")
    public List<CategoryGetDto> getCategories() {
        return categoriesFacade.getAll();
    }

    @Override
    @GetMapping("/categories/{categoryName}")
    public List<CommodityGetDto> getCommodities(@PathVariable String categoryName) {
        return commoditiesFacade.findByCategory(categoryName);
    }
}
