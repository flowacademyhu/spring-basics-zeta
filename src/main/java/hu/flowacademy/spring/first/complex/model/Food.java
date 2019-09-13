package hu.flowacademy.spring.first.complex.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "foods")
    private List<Order> orders;

//    @OneToMany(mappedBy = "food")
//    private List<Order> orders;

//    public List<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }

    public Food() {
    }

    public Food(String name) {
        this.name = name;
    }

    // @TODO components

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

}
