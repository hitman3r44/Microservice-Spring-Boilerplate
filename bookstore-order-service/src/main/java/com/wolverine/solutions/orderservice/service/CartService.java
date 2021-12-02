package com.wolverine.solutions.orderservice.service;

import com.wolverine.solutions.orderservice.repository.dao.Cart;


public interface CartService {

    Cart getCart();
    
    Cart getCartByCartId(String cartId);

    String createCart();

    Cart getCartByUserName(String userName);

}
