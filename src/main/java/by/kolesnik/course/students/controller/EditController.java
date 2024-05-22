package by.kolesnik.course.students.controller;

import by.kolesnik.course.students.controller.openapi.EditOpenApi;
import by.kolesnik.course.students.dto.category.CategoryAddDto;
import by.kolesnik.course.students.dto.category.CategoryGetDto;
import by.kolesnik.course.students.dto.category.CategoryUpdateDto;
import by.kolesnik.course.students.dto.commodity.CommodityAddDto;
import by.kolesnik.course.students.dto.commodity.CommodityGetDto;
import by.kolesnik.course.students.dto.commodity.CommodityUpdateDto;
import by.kolesnik.course.students.facade.CategoriesFacade;
import by.kolesnik.course.students.facade.CommoditiesFacade;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@SecurityScheme(type = SecuritySchemeType.HTTP, name = "basicAuth", scheme = "bearer", bearerFormat = "bearer")
@RequestMapping("/edit")
@RequiredArgsConstructor
public class EditController implements EditOpenApi {

    private final CategoriesFacade categoriesFacade;
    private final CommoditiesFacade commoditiesFacade;

    @Override
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryGetDto addCategory(@RequestBody CategoryAddDto category) {
        return categoriesFacade.add(category);
    }

    @Override
    @PostMapping("/{categoryName}")
    @PreAuthorize("hasRole('ADMIN')")
    public CommodityGetDto addCommodity(@PathVariable String categoryName, @RequestBody CommodityAddDto dto) {
        return commoditiesFacade.add(dto, categoryName);
    }

    @Override
    @DeleteMapping("/{article}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteCommodity(@PathVariable Integer article) {
        commoditiesFacade.delete(article);
    }

    @Override
    @PatchMapping("/{article}")
    @PreAuthorize("hasRole('ADMIN')")
    public CommodityGetDto updateCommodity(@PathVariable Integer article, @RequestBody CommodityUpdateDto dto) {
        return commoditiesFacade.update(article, dto);
    }

    @Override
    @PutMapping("/{categoryName}")
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryGetDto updateCategory(@PathVariable String categoryName, @RequestBody CategoryUpdateDto dto) {
        return categoriesFacade.update(categoryName, dto);
    }
}
