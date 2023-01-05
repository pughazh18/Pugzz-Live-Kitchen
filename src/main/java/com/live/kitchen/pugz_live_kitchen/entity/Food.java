package com.live.kitchen.pugz_live_kitchen.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(
        name="food",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})}
)
public class Food {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    //@Column(name="id",nullable = false)
    private Long foodId;

    @Column(name = "name",nullable = false)
    private String foodName;

    @Column(name="price",nullable = false)
    private Long foodPrice;

    @Column(name="quantity",nullable = false)
    private Long foodQuantity;

//    @OneToMany(mappedBy = "food",cascade = CascadeType.ALL,orphanRemoval = true)
//    private Set<Orders> orders=new HashSet<>();

}
