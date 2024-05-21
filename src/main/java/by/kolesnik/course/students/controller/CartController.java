package by.kolesnik.course.students.controller;

import by.kolesnik.course.students.controller.openapi.CartOpenApi;
import by.kolesnik.course.students.dto.commodity.CommodityGetDto;
import by.kolesnik.course.students.facade.CartFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController implements CartOpenApi {

    private final CartFacade facade;

    @Override
    @GetMapping
    public List<CommodityGetDto> getAll() {
        return facade.findAll();
    }

    @Override
    @PostMapping("/{article}")
    public CommodityGetDto add(@PathVariable Integer article) {
        return facade.add(article);
    }

    @Override
    @DeleteMapping("/{article}")
    public void delete(@PathVariable Integer article) {
        facade.delete(article);
    }
}
