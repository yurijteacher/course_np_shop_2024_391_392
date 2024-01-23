package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.bl.Cart;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.Clients;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.Product;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.Users;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.repository.ClientsRepository;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final ClientsRepository clientsRepository;

    @GetMapping("/cart")
    public String getPageCart(HttpServletRequest request,
                              Model model
                              ){

        HttpSession session = request.getSession();

       Cart cart = (Cart) session.getAttribute("cart");

       if(cart == null){
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
                                    ){

        HttpSession session = request.getSession();

        // set
        Cart cart = (Cart) session.getAttribute("cart");

        if(cart==null) cart = new Cart();

        cart.addNewItemToCart(product, quantity);
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


    @PostMapping("/updateProductFromCart")
    public String updateProductByCart(@RequestParam(name = "id") Product product,
                                      @RequestParam(name = "quantity") int quantity,
                                      HttpServletRequest request){

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart==null) cart = new Cart();
        cart.updateItemFromCart(product, quantity);
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

    @PostMapping("/deleteProductFromCart")
    public String deleteItemFromCart(@RequestParam(name = "id") Product product,
                                     HttpServletRequest request){

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart==null) cart = new Cart();
        cart.deleteItemCart(product);
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }


    @PostMapping("/deleteAllProductFromCart")
    public String deleteAllProductFromCart(HttpServletRequest request){

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart==null) cart = new Cart();
        cart.deleteAllItemCart();
        session.setAttribute("cart", cart);

        return "redirect:/cart";
    }

    @GetMapping("/order")
    public String getPageOrder(HttpServletRequest request,
                               Model model
    ){

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");

        if(cart == null){
            cart = new Cart();
        }

        Long id = (Long) session.getAttribute("user");
        Clients client = clientsRepository.findById(id).get();

        model.addAttribute("client", client);
        model.addAttribute("cart", cart.getCart());
        model.addAttribute("total", cart.getTotalValue());
//        model.addAttribute("user", user.getUsername());

        return "order";
    }


    @PostMapping("/buy")
    public String buyProduct(@RequestParam(name = "payment") String payment,
                             @RequestParam(name = "delivery") String delivery,
                             HttpServletRequest request
                             ){


        return "redirect:/thank";
    }


}
