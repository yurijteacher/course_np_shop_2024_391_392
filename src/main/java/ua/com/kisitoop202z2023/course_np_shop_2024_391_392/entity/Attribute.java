package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "_attribute")

public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double valueAttribute;

    @OneToMany(mappedBy = "attributes")
    private List<AttributeHasProduct> attributeHasProducts;
}
