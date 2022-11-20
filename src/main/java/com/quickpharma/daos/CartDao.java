package com.quickpharma.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quickpharma.entities.Cart;
import com.quickpharma.entities.Product;
import com.quickpharma.entities.User;

public interface CartDao extends JpaRepository<Cart, Integer> {
	
	 List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
	    List<Cart> deleteByUser(User user);
	    
	    @Query("SELECT COUNT(cartId) FROM Cart  WHERE user=:user")
	    Integer countByUserId(@Param("user") User user);
	    
	    List<Cart> findByProduct(Product product);
}
