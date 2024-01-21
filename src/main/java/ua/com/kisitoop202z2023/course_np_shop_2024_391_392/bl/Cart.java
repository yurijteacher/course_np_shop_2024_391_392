package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.bl;

import lombok.Getter;
import lombok.Setter;
import ua.com.kisitoop202z2023.course_np_shop_2024_391_392.entity.Product;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter


public class Cart {

    List<ItemCart> cart;
    private double totalValue;
    private int sumItem;

    public Cart() {
        cart = new ArrayList<>();
        totalValue = 0;
        sumItem = 0;
    }


    public synchronized void addNewItemToCart(Product product, int quantity){

        boolean logic = true;

        for(ItemCart el : cart){
            if(el.getProduct().getId()==product.getId()){
                logic = false;
                el.setQuantity(el.getQuantity()+quantity);
            }
        }

        if(logic) cart.add(new ItemCart(product, quantity));
    }

    public synchronized void updateItemFromCart(Product product, int quantity){
        if(quantity<=0){
            for (ItemCart el : cart) {
             if(el.getProduct().getId()==product.getId()) {
                 cart.remove(el);
                 break;
             }
            }
        } else {
            for (ItemCart el : cart) {
                if(el.getProduct().getId()==product.getId()) {
                    el.setQuantity(quantity);
                }
            }
        }
    }

    public synchronized void deleteItemCart(Product product){
        for (ItemCart el : cart) {
            if (el.getProduct().getId() == product.getId()) {
                cart.remove(el);
                break;
            }
        }
    }

    public synchronized void deleteAllItemCart(){
        cart.clear();
        totalValue = 0;
        sumItem = 0;
    }

    public synchronized double getTotalValue(){

        totalValue = 0;

        for (ItemCart el : cart){
            totalValue += el.getQuantity()*el.getProduct().getPrice().doubleValue();
        }
        return totalValue;
    }

    public synchronized int getSumItem(){

        int a = 0;
        for (ItemCart el : cart){
            a++;
        }

        return a; //cart.size();
    }


}
