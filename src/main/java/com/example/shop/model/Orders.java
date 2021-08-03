package com.example.shop.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
    //id,user_id,books_id,quantityOfOrder;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users users;
    @ManyToOne
    @JoinColumn(name = "books_id")
    private Books books;
}
