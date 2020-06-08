package com.mindtree.shoppingcart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.shoppingcart.dto.CartDTO;
import com.mindtree.shoppingcart.entity.Product;
import com.mindtree.shoppingcart.entity.User;
import com.mindtree.shoppingcart.exception.ServiceException;
import com.mindtree.shoppingcart.service.ShoppingCartService;


@RestController
public class ShoppingCartController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ShoppingCartService shoppingCartService;

	
	/**
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "/deleteAllProductFromCart", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAllProductFromCart() throws ServiceException {

		logger.info("delete all the products details from the cart");
		shoppingCartService.deleteAllProductsDetailsFromCart();

		return new ResponseEntity<String>("all products deleted from the cart", HttpStatus.OK);

	}

	
	/**
	 * @return
	 * @throws ServiceException
	 */
	@PostConstruct
	@RequestMapping(value = "/addProducts", method = RequestMethod.POST)
	public List<Product> addProduct() throws ServiceException {

		List<Product> products = new ArrayList<Product>();

		logger.info("add all products details");
		products = shoppingCartService.addProduct();

		return products;

	}

	/**
	 * @param userId
	 * @param productId
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "/addDetails/{userId}/{productId}", method = RequestMethod.POST)
	public ResponseEntity<String> addDetailsToCart(@PathVariable int userId, @PathVariable int productId)
			throws ServiceException {

		shoppingCartService.addProductDetailsToCart(userId, productId);
		return new ResponseEntity<String>("details entered succesfully",HttpStatus.OK);

	}

	/**
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public List<User> addUser() throws ServiceException {

		List<User> listOfUser = new ArrayList<>();

		logger.info("adding user details");
		listOfUser = shoppingCartService.addUser();

		return listOfUser;

	}

	/**
	 * @param productName
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "/searchProductByName/{productName}", method = RequestMethod.GET)
	public List<Product> searchProductByName(@PathVariable String productName) throws ServiceException {

		List<Product> searchProduct = new ArrayList<>();

		logger.info("search product details by the product name");
		searchProduct = shoppingCartService.getProductByProductName(productName);

		return searchProduct;

	}

	/**
	 * @param cartDTO
	 * @return
	 * @throws ServiceException
	 */
	@PutMapping(value = "/updatecart")
	public ResponseEntity<String> updateCart(@RequestBody CartDTO cartDTO) throws ServiceException {

		logger.info("updating cart details");
		shoppingCartService.updateCart(cartDTO);
		return new ResponseEntity<String>("cart updated successfully", HttpStatus.OK);

	}

	/**
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "/searchAllProduct", method = RequestMethod.GET)
	public List<Product> searchAllProduct() throws ServiceException {

		List<Product> searchProduct = new ArrayList<>();

		logger.info("search all the products details");
		searchProduct = shoppingCartService.searchAllProduct();

		return searchProduct;

	}

	/**
	 * @param cartId
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "/deleteProductsFromCart/{cartId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAllProductFromCart(@PathVariable int cartId) throws ServiceException {

		logger.info("delete specific products from the cart");
		shoppingCartService.deleteProductFromCart(cartId);

		return new ResponseEntity<String>("products delete successfully", HttpStatus.OK);

	}

}
