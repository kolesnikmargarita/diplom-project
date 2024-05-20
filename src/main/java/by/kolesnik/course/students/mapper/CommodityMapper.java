package by.kolesnik.course.students.mapper;

import by.kolesnik.course.students.dto.CommodityDto;
import by.kolesnik.course.students.dto.CommodityUpdateDto;
import by.kolesnik.course.students.entity.Commodity;
import org.springframework.stereotype.Component;

@Component
public class CommodityMapper {

    public Commodity toEntity(CommodityDto dto) {

        final Commodity commodity = new Commodity();

        commodity.setArticle(dto.getArticle());
        commodity.setName(dto.getName());
        commodity.setPrice(dto.getPrice());
        commodity.setDescription(dto.getDescription());
        commodity.setCategory(dto.getCategory());

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
}
