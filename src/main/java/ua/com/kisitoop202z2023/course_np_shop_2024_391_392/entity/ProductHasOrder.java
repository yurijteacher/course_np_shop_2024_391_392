package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name = "product_has_order")
public class ProductHasOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product producte;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order ordere;


    private int quantity;

    public ProductHasOrder(Product producte, Order ordere, int quantity) {
        this.producte = producte;
        this.ordere = ordere;
        this.quantity = quantity;
    }
}
