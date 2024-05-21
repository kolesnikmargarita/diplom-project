package by.kolesnik.course.students.facade;

import by.kolesnik.course.students.dto.commodity.CommodityAddDto;
import by.kolesnik.course.students.dto.commodity.CommodityDto;
import by.kolesnik.course.students.dto.commodity.CommodityGetDto;
import by.kolesnik.course.students.dto.commodity.CommodityUpdateDto;
import by.kolesnik.course.students.entity.Category;
import by.kolesnik.course.students.entity.Commodity;
import by.kolesnik.course.students.mapper.CommodityMapper;
import by.kolesnik.course.students.service.CategoryService;
import by.kolesnik.course.students.service.CommodityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CommoditiesFacade {

    private final CommodityService commodityService;
    private final CategoryService categoryService;
    private final CommodityMapper commodityMapper;

    public List<CommodityGetDto> getAll() {
        return commodityService.findAll().stream().map(commodityMapper::toGetDto).toList();
    }

    public List<CommodityGetDto> findByCategory(String categoryName) {
        final Category category = categoryService.findByName(categoryName);
        final List<Commodity> commodities = commodityService.findByCategory(category);
        return commodities.stream().map(commodityMapper::toGetDto).toList();
    }

    public CommodityGetDto add(CommodityAddDto dto, String categoryName) {
        final Category category = categoryService.findByName(categoryName);
        final Commodity commodity = commodityMapper.toEntity(dto);
        commodity.setCategory(category);
        return commodityMapper.toGetDto(commodityService.save(commodity));
    }

    public void delete(Integer article) {
        final Commodity commodity = commodityService.findByArticle(article);
        commodityService.delete(commodity);
    }

    public CommodityGetDto update(Integer article, CommodityUpdateDto dto) {
        final Commodity commodity = commodityService.findByArticle(article);

        if(dto.getName() != null) {
            commodity.setName(dto.getName());
        }
        if(dto.getPrice() != null) {
            commodity.setPrice(dto.getPrice());
        }
        if(dto.getDescription() != null) {
            commodity.setDescription(dto.getDescription());
        }
        if(dto.getCategoryName() != null) {
            final Category category = categoryService.findByName(dto.getCategoryName());
            commodity.setCategory(category);
        }

        commodityService.save(commodity);

        return commodityMapper.toGetDto(commodity);
    }
}
