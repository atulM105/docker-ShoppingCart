package com.mindtree.shoppingcart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.shoppingcart.dto.CartDTO;
import com.mindtree.shoppingcart.entity.Product;
import com.mindtree.shoppingcart.entity.User;
import com.mindtree.shoppingcart.exception.ServiceException;

@Service
public interface ShoppingCartService {

	/**
	 * @param userId
	 * @param productId
	 * @return
	 * @throws ServiceException
	 */
	public String addProductDetailsToCart(int userId, int productId) throws ServiceException;

	/**
	 * @return
	 * @throws ServiceException
	 */
	public List<User> addUser() throws ServiceException;

	/**
	 * @return
	 * @throws ServiceException
	 */
	public List<Product> addProduct() throws ServiceException;

	/**
	 * @return
	 * @throws ServiceException
	 */
	public List<Product> searchAllProduct() throws ServiceException;

	/**
	 * @param productName
	 * @return
	 * @throws ServiceException
	 */
	public List<Product> getProductByProductName(String productName) throws ServiceException;

	/**
	 * @return
	 * @throws ServiceException
	 */
	public Integer deleteAllProductsDetailsFromCart() throws ServiceException;

	/**
	 * @param cartDTO
	 * @return
	 * @throws ServiceException
	 */
	public String updateCart(CartDTO cartDTO) throws ServiceException;
	
	/**
	 * @param cartId
	 * @return
	 * @throws ServiceException
	 */
	public Integer deleteProductFromCart(int cartId) throws ServiceException;

}
