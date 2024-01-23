package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.bl.Cart;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.Clients;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.Roles;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.Users;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.repository.ClientsRepository;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.repository.UsersRepository;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.service.UserService;

import java.util.Collections;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UsersRepository usersRepository;
    private final ClientsRepository clientsRepository;
    private final UserService userService;

    @GetMapping("/registration")
    public String getPageRegistration(Model model) {

        model.addAttribute("users", new Users());
        model.addAttribute("clients", new Clients());

        return "registration";
    }


    @PostMapping("/registration")
    public String saveNewUserToDB(@Valid Users user, // username / password
                                  BindingResult bindingResult1,
                                  @Valid Clients client,
                                  BindingResult bindingResult2
    ) {

        if (bindingResult1.hasErrors()) {
            return "registration";
        }

        if (bindingResult2.hasErrors()) {
            return "registration";
        }

        // Перевірка на username (login)
        if (userService.getLogicUserByUsername(user.getUsername())) {
            return "registration";
        }

        // Закріплення ролі за користувачем
        user.setRolesset(Collections.singleton(new Roles(1L, "ROLE_Users")));

        Users user1 = usersRepository.save(user);
        client.setUser(user1);
        clientsRepository.save(client);


        return "redirect:/login";
    }

    @PostMapping("/login")
    public String authUser(@RequestParam(name = "username") String username,
                           @RequestParam(name = "password") String pass,
                           HttpServletRequest request) {


        if(userService.getLogicUserByUsernameAndPassword(username, pass)){

            return "redirect:/login";

        } else {

            Users user = userService.getUserByUsernameAndPassword(username, pass);
            HttpSession session = request.getSession();
            session.setAttribute("user", user.getId());

            return "redirect:/order";
        }
    }

}
