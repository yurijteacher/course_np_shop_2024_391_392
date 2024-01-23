package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
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
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 55, message = "значення поля username має бути в діапазоні від 2 до 55 символів")
    private String firstName;
    @Size(min = 2, max = 55, message = "значення поля username має бути в діапазоні від 2 до 15 символів")
    private String lastName;
    @Email
    private String email;
    private int phone;
    private int age;

    @OneToOne
    @MapsId
    @MapKey
    @JoinColumn(name = "id")
    private Users user;


    @OneToMany(mappedBy="cliente")
    private List<Address> addressList;

    @OneToMany(mappedBy="clientes")
    private List<Order> orderList;
}
