package com.quickpharma.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quickpharma.daos.CartDao;
import com.quickpharma.dtos.AddToCartDto;
import com.quickpharma.dtos.CartDto;
import com.quickpharma.dtos.CartItemDtoR;
import com.quickpharma.entities.Cart;
import com.quickpharma.entities.Product;
import com.quickpharma.entities.User;

@Service
@Transactional
public class CartServiceImpl {
	
	@Autowired
    private  CartDao cartDao;

    public CartServiceImpl(){}

    public CartServiceImpl(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    public void addToCart(AddToCartDto addToCartDto, Product product, User user){
        Cart cart = new Cart(product, addToCartDto.getQuantity(), user);
        cartDao.save(cart);
    }


    public CartDto listCartItems(User user) {
        List<Cart> cartList = cartDao.findAllByUserOrderByCreatedDateDesc(user);
        List<CartItemDtoR> cartItems = new ArrayList<>();
        for (Cart cart:cartList){
            CartItemDtoR cartItemDto = getDtoFromCart(cart);
            cartItems.add(cartItemDto);
        }
        double totalCost = 0;
        for (CartItemDtoR cartItemDto :cartItems){
            totalCost += (cartItemDto.getProduct().getPrice()* cartItemDto.getQuantity());
        }
        CartDto cartDto = new CartDto(cartItems,totalCost);
        return cartDto;
    }


    public static CartItemDtoR getDtoFromCart(Cart cart) {
        CartItemDtoR cartItemDto = new CartItemDtoR(cart);
        return cartItemDto;
    }


    public void updateCartItem(AddToCartDto cartDto, User user,Product product){
        Cart cart = cartDao.getOne(cartDto.getId());
        cart.setQuantity(cartDto.getQuantity());
        cartDao.save(cart);
    }

    public void deleteCartItem(int id,int userId) throws RuntimeException {
        if (!cartDao.existsById(id))
            throw new	RuntimeException("Cart id is invalid : " + id);
        cartDao.deleteById(id);

    }

    public void deleteCartItems(int userId) {
        cartDao.deleteAll();
    }
   

    public void deleteUserCartItems(User user) {
        cartDao.deleteByUser(user);
    }
    public Integer cartItemCount(User user) {
    	return cartDao.countByUserId(user);
    }
}