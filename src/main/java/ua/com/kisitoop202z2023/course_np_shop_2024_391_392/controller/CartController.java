package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.bl.Cart;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.bl.ItemCart;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.*;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.repository.ClientsRepository;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.repository.OrderRepository;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.repository.ProductHasOrderRepository;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.service.UserService;

import java.util.Date;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final ClientsRepository clientsRepository;
    private final OrderRepository orderRepository;
    private final ProductHasOrderRepository productHasOrderRepository;
    private final UserService userService;

    @GetMapping("/cart")
    public String getPageCart(HttpServletRequest request,
                              Model model
    ) {

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        model.addAttribute("cart", cart.getCart());
        model.addAttribute("total", cart.getTotalValue());
        model.addAttribute("sum", cart.getSumItem());

        return "cart";
    }

    @PostMapping("/addItemToCart")
    public String saveNewItemToCart(@RequestParam(name = "id") Product product,
                                    @RequestParam(name = "quantity") int quantity,
                                    HttpServletRequest request
    ) {

        HttpSession session = request.getSession();

        // set
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) cart = new Cart();

        cart.addNewItemToCart(product, quantity);
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


    @PostMapping("/updateProductFromCart")
    public String updateProductByCart(@RequestParam(name = "id") Product product,
                                      @RequestParam(name = "quantity") int quantity,
                                      HttpServletRequest request) {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) cart = new Cart();
        cart.updateItemFromCart(product, quantity);
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

    @PostMapping("/deleteProductFromCart")
    public String deleteItemFromCart(@RequestParam(name = "id") Product product,
                                     HttpServletRequest request) {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) cart = new Cart();
        cart.deleteItemCart(product);
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


    @PostMapping("/deleteAllProductFromCart")
    public String deleteAllProductFromCart(HttpServletRequest request) {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) cart = new Cart();
        cart.deleteAllItemCart();
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

    @GetMapping("/order")
    public String getPageOrder(HttpServletRequest request,
                               Model model
    ) {

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }


        // Auth ??
//        Long id = (Long) session.getAttribute("user");


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users users = (Users) userService.loadUserByUsername(auth.getName());

        Clients client = null;
        if (users != null) {
            client = clientsRepository.findById(users.getId()).get();
        } else {
            client = new Clients();
        }

        model.addAttribute("client", client);
        model.addAttribute("cart", cart.getCart());
        model.addAttribute("total", cart.getTotalValue());

        return "order";
    }


    @PostMapping("/buy")
    public String buyProduct(@RequestParam(name = "payment") String payment,
                             @RequestParam(name = "delivery") String delivery,
                             HttpServletRequest request
    ) {

        String payment1 = "";
        payment1 = (payment.equals("1")) ? "Готівка" : "Безготівковий розрахунок";

        String delivery1 = "";
        if (delivery.equals("1")) {
            delivery1 = "Нова пошта";
        } else if (delivery.equals("2")) {
            delivery1 = "Самовивіз";
        } else {
            delivery1 = "Укрпошта";
        }

        HttpSession session = request.getSession();

//        Long id = (Long) session.getAttribute("user");


        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users users = (Users) userService.loadUserByUsername(auth.getName());
        Long id = users.getId();



        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) return "redirect:/category";

        Clients client = null;

        if (id != null) {

            client = clientsRepository.findById(id).get();

            Order order = new Order();
            order.setClientes(client);
            order.setDateCreated(new Date());
            order.setPayment(payment1);
            order.setDelivery(delivery1);

            Order order1 = orderRepository.save(order);

            for (ItemCart el : cart.getCart()) {
                productHasOrderRepository.save(new ProductHasOrder(el.getProduct(),
                        order1, el.getQuantity()));
            }

            cart.deleteAllItemCart();
            session.setAttribute("cart", cart);

            return "redirect:/thank";
        } else {
            return "redirect:/category";
        }
    }


    @GetMapping("/thank")
    public String getPageThank(){
        return "thank";
    }

}
