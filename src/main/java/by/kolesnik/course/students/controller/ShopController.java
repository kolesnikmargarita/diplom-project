package by.kolesnik.course.students.controller;

import by.kolesnik.course.students.dto.CategoryDto;
import by.kolesnik.course.students.dto.CommodityDto;
import by.kolesnik.course.students.dto.CommodityUpdateDto;
import by.kolesnik.course.students.dto.UserDto;
import by.kolesnik.course.students.facade.CategoriesFacade;
import by.kolesnik.course.students.facade.CommoditiesFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

    private final CategoriesFacade categoriesFacade;
    private final CommoditiesFacade commoditiesFacade;

    @GetMapping
    public List<CommodityDto> getAll() {
        return commoditiesFacade.getAll();
    }

    @GetMapping("/categories")
    public List<CategoryDto> getCategories() {
        return categoriesFacade.getAll();
    }

    @GetMapping("/{categoryName}")
    public List<CommodityDto> getCommodities(@PathVariable String categoryName) {
        return commoditiesFacade.findByCategory(categoryName);
    }

    @PostMapping("/{category}")
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryDto addCategory(@PathVariable CategoryDto category) {
        return categoriesFacade.add(category);
    }

    @PostMapping("/{categoryName}")
    @PreAuthorize("hasRole('ADMIN')")
    public CommodityDto addCommodity(@PathVariable String categoryName, CommodityDto dto) {
        return commoditiesFacade.add(dto, categoryName);
    }

    @DeleteMapping("/{article}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteCommodity(@PathVariable Integer article) {
        commoditiesFacade.delete(article);
    }

    @PatchMapping("/{article}")
    @PreAuthorize("hasRole('ADMIN')")
    public CommodityDto updateCommodity(@PathVariable Integer article, CommodityUpdateDto dto) {
        return commoditiesFacade.update(article, dto);
    }

    @PutMapping("/{categoryName}")
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryDto updateCategory(@PathVariable String categoryName, CategoryDto dto) {
        return categoriesFacade.update(categoryName, dto);
    }
}
