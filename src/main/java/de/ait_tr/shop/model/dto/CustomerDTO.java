package de.ait_tr.shop.model.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Sergey Bugaenko
 * {@code @date} 27.08.2024
 */

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class CustomerDTO {

    private Long id;
    private String name;
    private boolean active;
    @JsonManagedReference
    private CartDto cart;


    @Override
    public String toString() {
        return String.format("CustomerDTO: id - %d, name - %s, active - %s, cart_id: %d",
                id, name,  active ? "yes" : "no", cart.getId() );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CartDto getCart() {
        return cart;
    }

    public void setCart(CartDto cart) {
        this.cart = cart;
    }
}
