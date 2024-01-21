package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.bl;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.Product;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ItemCart {

    private Product product;
    private int quantity;


}
