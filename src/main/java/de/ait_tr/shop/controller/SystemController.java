package de.ait_tr.shop.controller;

import de.ait_tr.shop.model.dto.ProductSupplyDto;
import de.ait_tr.shop.service.interfaces.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Sergey Bugaenko
 * {@code @date} 03.09.2024
 */

@RestController
@RequestMapping("/system")
public class SystemController {

    private final ProductService productService;

    public SystemController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductSupplyDto> getAllProducts() {
        return productService.getAllActiveProductsForSupply();
    }
}
