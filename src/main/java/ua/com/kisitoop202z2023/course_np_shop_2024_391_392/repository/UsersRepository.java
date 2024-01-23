package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.Users;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {

    List<Users> findAllByUsername(String username); // select * from users where username="Vasya";

    List<Users> findAllByUsernameAndPassword(String user, String pass);

}
