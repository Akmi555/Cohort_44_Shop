package de.ait_tr.shop.controller;

import de.ait_tr.shop.model.entity.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Sergey Bugaenko
 * {@code @date} 16.08.2024
 */

// http://localhost:8080/products
    /*
    http://example.com/home
    http://example.com/about
    http://example.com/api/products
    http://example.com/api/customer

Сохранение нового продукта
POST /products

Получить продукт по id
GET    /products/id
GET    /products

Обновление PUT    /products/id
Удаление DELETE /products/id

     */

@RestController
@RequestMapping("/products")
public class ProductController {

    // /products/example
    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        // TODO обращаемся к сервису для сохранения продукты
        return product;
    }

//    // GET /products?id=3
//    @GetMapping
//    public Product getById(@RequestParam("id") long id) {
//        // TODO обращаемся к сервису для получения продукта по id
//        return null;
//    }

    // GET /products/{id} - переменная пути
    @GetMapping("/{product_id}")
    public Product getById(@PathVariable("product_id") long id) {
        // TODO обращаемся к сервису для получения продукта по id
        return null;
    }

    // PUT -> /products/id и в теле запроса - объект Json с теми полями, которые мы хотим поменять
    @PutMapping("/{id}")
    public Product updateProduct (@PathVariable Long id, @RequestBody Product product) {
        return product;
    }

    // DELETE -> /products/id
    @DeleteMapping("/{id}")
    public Product remove(@PathVariable Long id) {

        return null;
    }


    @GetMapping
    public List<Product> getAll() {
        return null;
    }







}
