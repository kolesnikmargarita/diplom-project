package by.kolesnik.course.students.facade;

import by.kolesnik.course.students.dto.commodity.CommodityGetDto;
import by.kolesnik.course.students.entity.Commodity;
import by.kolesnik.course.students.entity.User;
import by.kolesnik.course.students.mapper.CommodityMapper;
import by.kolesnik.course.students.service.CommodityService;
import by.kolesnik.course.students.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CartFacade {

    private final UserService userService;
    private final CommodityService commodityService;
    private final CommodityMapper commodityMapper;

    private User findByEmail() {
        final String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return userService.findByEmail(name);
    }

    public List<CommodityGetDto> findAll() {
        final User user = findByEmail();
        Collection<Commodity> commodities = user.getCommodities();
        return commodities.stream().map(commodityMapper::toGetDto).toList();
    }

    public CommodityGetDto add(Integer article) {
        final User user = findByEmail();
        final Commodity commodity = commodityService.findByArticle(article);
        final Collection<Commodity> commodities = user.getCommodities();
        commodities.add(commodity);
        user.setCommodities(commodities);
        userService.updateUser(user);
        return commodityMapper.toGetDto(commodity);
    }

    public void delete(Integer article) {
        final User user = findByEmail();
        final Commodity commodity = commodityService.findByArticle(article);
        final Collection<Commodity> commodities = user.getCommodities();
        commodities.remove(commodity);
        user.setCommodities(commodities);
        userService.updateUser(user);
    }
}
