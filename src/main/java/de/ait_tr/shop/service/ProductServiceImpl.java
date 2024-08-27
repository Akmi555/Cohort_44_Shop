package de.ait_tr.shop.service;

import de.ait_tr.shop.model.dto.ProductDTO;
import de.ait_tr.shop.model.entity.Product;
import de.ait_tr.shop.repository.ProductRepository;
import de.ait_tr.shop.service.interfaces.ProductService;
import de.ait_tr.shop.service.mapping.ProductMappingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author Sergey Bugaenko
* {@code @date} 19.08.2024
*/

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMappingService mapper;

//    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    public ProductServiceImpl(ProductRepository repository, ProductMappingService mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }



    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        System.out.println("Method save work");
        Product product = mapper.mapDtoToEntity(productDTO);
//        product.setActive(true);
        return mapper.mapEntityToDto(repository.save(product));
    }

//    @Override
//    public ProductDTO getById(long id) {
//        logger.info("Method getById called with parameter: {}", id);
//        logger.warn("Method getById called with parameter: {}", id);
//        logger.error("Method getById called with parameter: {}", id);
//
//        Product product =  repository.findById(id).orElse(null);
//
//        if (product == null || !product.isActive() ) {
//            return null;
//        }
//
//        return mapper.mapEntityToDto(product);
//    }

    @Override
    public ProductDTO getById(long id) {

        Product product =  repository.findById(id).orElse(null);

        if (product == null || !product.isActive() ) {
            throw new RuntimeException("Product not found");
        }

        return mapper.mapEntityToDto(product);
    }

    @Override
    public List<ProductDTO> getAll() {
              // создаю поток из элементов списка
        return repository.findAll().stream()
                // фильтрую поток (оставляю только активные элементы
                .filter(Product::isActive)
                // маппинг: поток Product -> поток ProductDto.
                // Каждый элемент потока будет преобразован из Product в ProductDto
                .map(mapper::mapEntityToDto)
                // собираю элементы потока в список (List)
                .toList();
    }


    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductDTO remove(Long id) {
        return null;
    }



    @Override
    public ProductDTO removeByTitle(String title) {
        return null;
    }

    @Override
    public ProductDTO restoreById(Long id) {
        return null;
    }

    @Override
    public long getProductsCount() {
        return 0;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return null;
    }

    @Override
    public BigDecimal getAveragePrice() {
        return null;
    }
}
