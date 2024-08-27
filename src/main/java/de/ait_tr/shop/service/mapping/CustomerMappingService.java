package de.ait_tr.shop.service.mapping;

import de.ait_tr.shop.model.dto.CustomerDTO;
import de.ait_tr.shop.model.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Sergey Bugaenko
 * {@code @date} 27.08.2024
 */

@Mapper(componentModel = "spring", uses = CartMappingService.class)
public interface CustomerMappingService {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    Customer mapDtoToEntity(CustomerDTO dto);

    CustomerDTO mapEntityToDto(Customer entity);
}
