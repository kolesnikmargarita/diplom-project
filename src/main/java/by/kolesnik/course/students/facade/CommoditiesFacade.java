package by.kolesnik.course.students.facade;

import by.kolesnik.course.students.dto.CommodityDto;
import by.kolesnik.course.students.dto.CommodityUpdateDto;
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

    public List<CommodityDto> getAll() {
        return commodityService.findAll().stream().map(commodityMapper::toDto).toList();
    }

    public List<CommodityDto> findByCategory(String categoryName) {
        final Category category = categoryService.findByName(categoryName);
        final List<Commodity> commodities = commodityService.findByCategory(category);
        return commodities.stream().map(commodityMapper::toDto).toList();
    }

    public CommodityDto add(CommodityDto dto, String categoryName) {
        final Category category = categoryService.findByName(categoryName);
        dto.setCategory(category);
        final Commodity commodity = commodityMapper.toEntity(dto);
        return commodityMapper.toDto(commodityService.save(commodity));
    }

    public void delete(Integer article) {
        final Commodity commodity = commodityService.findByArticle(article);
        commodityService.delete(commodity);
    }

    public CommodityDto update(Integer article, CommodityUpdateDto dto) {
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

        return commodityMapper.toDto(commodity);
    }
}
