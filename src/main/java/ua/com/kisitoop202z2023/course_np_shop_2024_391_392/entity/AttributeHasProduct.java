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
@Table(name = "attribute_has_product")
public class AttributeHasProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private Attribute attributes;

    @ManyToOne
    @JoinColumn(name = "productes_id")
    private Product productes;

}
