package de.ait_tr.shop.service.mapping;

import de.ait_tr.shop.model.dto.CartDto;
import de.ait_tr.shop.model.entity.Cart;
import org.mapstruct.Mapper;

/**
 * @author Sergey Bugaenko
 * {@code @date} 27.08.2024
 */

@Mapper(componentModel = "spring", uses = CartMappingService.class)
public interface CartMappingService {

    Cart mapDtoToEntity(CartDto dto);

    CartDto mapEntityToDto(Cart entity);
}
