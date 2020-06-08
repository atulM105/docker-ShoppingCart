package com.mindtree.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.shoppingcart.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	@Modifying
	@Transactional
	@Query(value = "delete from cart", nativeQuery = true)
	public int deleteAllProductFromCart();

	@Modifying
	@Transactional
	@Query(value = "update cart SET product_quantity=:productQuantity where cart_id =:cartId and user_id=:userId", nativeQuery = true)
	public int updateProductInCart(int productQuantity, int cartId, int userId);

	@Modifying
	@Transactional
	@Query(value = "delete from cart where cart_id=:cartId", nativeQuery = true)
	public int deleteProductFromCart(int cartId);

}
