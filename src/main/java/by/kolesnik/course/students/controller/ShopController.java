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
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController implements ShopOpenApi {

    private final CategoriesFacade categoriesFacade;
    private final CommoditiesFacade commoditiesFacade;

    @Override
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
