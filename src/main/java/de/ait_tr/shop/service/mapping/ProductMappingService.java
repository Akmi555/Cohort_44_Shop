package de.ait_tr.shop.service.mapping;

import de.ait_tr.shop.model.dto.ProductDTO;
import de.ait_tr.shop.model.dto.ProductSupplyDto;
import de.ait_tr.shop.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Sergey Bugaenko
 * {@code @date} 20.08.2024
 */

@Mapper(componentModel = "spring")
public interface ProductMappingService {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    @Mapping(target = "image", ignore = true)
    Product mapDtoToEntity(ProductDTO dto);

    ProductDTO mapEntityToDto(Product entity);

    ProductSupplyDto mapEntityToSupplyDto(Product entity);


//    public Product mapDtoToEntity(ProductDTO dto){
//        Product entity = new Product();
//        entity.setTitle(dto.getTitle());
//        entity.setPrice(dto.getPrice());
//        return entity;
//    }
//
//    public ProductDTO mapEntityToDto(Product entity){
//        ProductDTO dto = new ProductDTO();
//        dto.setId(entity.getId());
//        dto.setPrice(entity.getPrice());
//        dto.setTitle(entity.getTitle());
//        return dto;
//    }
}
