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
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
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
