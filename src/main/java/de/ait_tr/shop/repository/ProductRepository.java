package de.ait_tr.shop.repository;

import de.ait_tr.shop.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Sergey Bugaenko
 * {@code @date} 19.08.2024
 */

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByActiveTrue();
//    List<Product> findAllByActive(boolean active);
}
