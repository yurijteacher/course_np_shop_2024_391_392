package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
