package de.ait_tr.shop.service.interfaces;

import de.ait_tr.shop.model.entity.Customer;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Sergey Bugaenko
 * {@code @date} 20.08.2024
 */

public interface CustomerService {
    Customer save(Customer customer);
    List<Customer> getAllActiveCustomers();
    Customer getById(long id);
    Customer update(Customer customer);
    void deleteById(long id);
    void deleteByName(String name);
    void restoreById(long id);
    long getActiveCustomerCount();
    BigDecimal getTotalCostOfCustomersProducts(long customerId);
    BigDecimal getAverageCostOfCustomersProducts(long customerId);
    void addProductToCustomersCart(long customerId, long productId);
    void removeProductFromCustomersCart(long customerId, long productId);
    void clearCustomersCart(long customerId);


}

/*
Сохранить покупателя в базе данных (при сохранении покупатель автоматически считается активным)
Вернуть всех покупателей из базы данных (активных)
Вернуть одного покупателя из базы данных по его идентификатору (если он активен)
Изменить одного покупателя в базе данных по его идентификатору
Удалить покупателя из базы данных по его идентификатору
Удалить покупателя из базы данных по его имени
Восстановить удалённого покупателя в базе данных по его идентификатору
Вернуть общее количество покупателей в базе данных (активных)
Вернуть стоимость корзины покупателя по его идентификатору (если он активен)
Вернуть среднюю стоимость продукта в корзине покупателя по его идентификатору (если он активен)
Добавить товар в корзину покупателя по их идентификаторам (если оба активны)
Удалить товар из корзины покупателя по их идентификаторам
Полностью очистить корзину покупателя по его идентификатору (если он активен)

 */
