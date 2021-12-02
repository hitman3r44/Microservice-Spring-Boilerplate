package com.wolverine.solutions.orderservice.service;

import com.wolverine.solutions.orderservice.repository.dao.CartItem;
import com.wolverine.solutions.orderservice.web.CartItemRequest;


public interface CartItemService {

    void addCartItem(CartItemRequest cartItemRequest);
    void removeCartItem(String cartItemId);
    CartItem getCartItem(String cartItemId);
    void removeAllCartItems(String cartId);

}
