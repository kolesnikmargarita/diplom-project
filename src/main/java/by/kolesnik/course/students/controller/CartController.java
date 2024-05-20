package by.kolesnik.course.students.controller;

import by.kolesnik.course.students.dto.CommodityDto;
import by.kolesnik.course.students.facade.CartFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartFacade facade;

    @GetMapping
    public List<CommodityDto> getAll() {
        return facade.findAll();
    }

    @PostMapping("/{article}")
    public CommodityDto add(@PathVariable Integer article) {
        return facade.add(article);
    }

    @DeleteMapping("/{article}")
    public void delete(@PathVariable Integer article) {
        facade.delete(article);
    }
}
