package by.kolesnik.course.students.mapper;

import by.kolesnik.course.students.dto.commodity.CommodityAddDto;
import by.kolesnik.course.students.dto.commodity.CommodityDto;
import by.kolesnik.course.students.dto.commodity.CommodityGetDto;
import by.kolesnik.course.students.entity.Commodity;
import org.springframework.stereotype.Component;

@Component
public class CommodityMapper {

    public Commodity toEntity(CommodityAddDto dto) {

        final Commodity commodity = new Commodity();

        commodity.setArticle(dto.getArticle());
        commodity.setName(dto.getName());
        commodity.setPrice(dto.getPrice());
        commodity.setDescription(dto.getDescription());

        return commodity;
    }

    public CommodityDto toDto(Commodity commodity) {

        final CommodityDto dto = new CommodityDto();

        dto.setArticle(commodity.getArticle());
        dto.setName(commodity.getName());
        dto.setPrice(commodity.getPrice());
        dto.setDescription(commodity.getDescription());
        dto.setCategory(commodity.getCategory());

        return dto;
    }

    public CommodityGetDto toGetDto(Commodity commodity) {

        final CommodityGetDto dto = new CommodityGetDto();

        dto.setId(commodity.getId());
        dto.setArticle(commodity.getArticle());
        dto.setName(commodity.getName());
        dto.setPrice(commodity.getPrice());
        dto.setDescription(commodity.getDescription());
        dto.setCategoryName(commodity.getCategory().getName());

        return dto;
    }
}
