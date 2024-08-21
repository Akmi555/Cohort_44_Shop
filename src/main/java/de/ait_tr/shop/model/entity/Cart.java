package de.ait_tr.shop.model.entity;

import jakarta.persistence.*;

import java.util.List;

/**
 * @author Sergey Bugaenko
 * {@code @date} 20.08.2024
 */

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

}
