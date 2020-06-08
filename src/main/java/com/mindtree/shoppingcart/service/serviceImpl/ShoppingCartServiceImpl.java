package com.mindtree.shoppingcart.service.serviceImpl;
//
//import java.util.ArrayList;
//
//import java.util.HashMap;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.mindtree.shoppingcart.dto.CartDTO;
//import com.mindtree.shoppingcart.entity.Apparel;
//import com.mindtree.shoppingcart.entity.Book;
//import com.mindtree.shoppingcart.entity.Cart;
//import com.mindtree.shoppingcart.entity.Product;
//import com.mindtree.shoppingcart.entity.User;
//import com.mindtree.shoppingcart.exception.ServiceException;
//import com.mindtree.shoppingcart.repository.CartRepository;
//import com.mindtree.shoppingcart.repository.ProductRepository;
//import com.mindtree.shoppingcart.repository.UserRepository;
//import com.mindtree.shoppingcart.service.ShoppingCartService;
//
//
//@Service
//@Transactional
//public class ShoppingCartServiceImpl implements ShoppingCartService {
//
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private ProductRepository productRepository;
//
//	@Autowired
//	private CartRepository cartRepository;
//
//	
//	@Override
//	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//	public List<User> addUser() throws ServiceException {
//
//		List<User> listOfUser = new ArrayList<>();
//		HashMap<Integer, Integer> productQuantity = new HashMap<>();
//		
//		User users=null;
//		Cart cart=null;
//		
//		try {
//			users = new User();
//			cart = new Cart();
//			users.setUserId(1);
//			users.setUserEmail("amitesh@yahoo.com");
//			users.setUserName("amitesh");
//			cart.setProductQuantity(productQuantity);
//			cart.setPriceTotal(2);
//			cart.setUser(users);
//			users.setCart(cart);
//			listOfUser.add(users);
//			users = new User();
//			cart = new Cart();
//			users.setUserId(2);
//			users.setUserName("jackson");
//			users.setUserEmail("jacksonsentro@rediff.com");
//			cart.setProductQuantity(productQuantity);
//			cart.setPriceTotal(1);
//			
//			cart.setUser(users);
//			users.setCart(cart);
//			listOfUser.add(users);
//			logger.info("saving all the users");
//			userRepository.saveAll(listOfUser);
//		} catch (Exception e) {
//			logger.warn("exception while fetching the user details");
//			throw new ServiceException("unable to add users");
//		}
//	
//		return listOfUser;
//	}
//
//	
//	
//	@Override
//	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//	public List<Product> searchAllProduct() throws ServiceException {
//
//		List<Product> products = new ArrayList<Product>();
//		try {
//			logger.info("searching all the products availability");
//			products = productRepository.findAll();
//		} catch (Exception e) {
//			logger.warn("exception while fetching the products details");
//			throw new ServiceException("unable to search all products");
//		}
//	return products;
//	}
//
//
//	@Override
//	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//	public String addProductDetailsToCart(int userId, int productId) throws ServiceException {
//
//		List<Product> listOfProducts = new ArrayList<>();
//
//		HashMap<Integer, Integer> productQuantity = new HashMap<>();
//
//		Cart cart = new Cart();
//		User user = new User();
//		Product product = new Product();
//		float amount;
//		try {
//
//			user = userRepository.getOne(userId);
//			cart = user.getCart();
//
//			amount = cart.getPriceTotal();
//
//		} catch (Exception e) {
//			logger.warn("exception while fetching user id");
//			throw new ServiceException("no user id is found", e);
//		}
//
//		try {
//
//			product = productRepository.getOne(productId);
//			listOfProducts = cart.getProduct();
//			if (productQuantity.get(product.getProductId()) != null) {
//
//				listOfProducts.add(product);
//				
//			} else {
//				productQuantity.put(product.getProductId(), productQuantity.get(product.getProductId() + 1));
//				amount = amount + product.getProductPrice();
//			}
//			cart.setProduct(listOfProducts);
//			cart.setPriceTotal(amount);
//			cart.setProductQuantity(productQuantity);
//			user.setCart(cart);
//			cart.setUser(user);
//			listOfProducts = cart.getProduct();
//			
//			logger.info("saving all the details to the cart");
//			userRepository.save(cart.getUser());
//		} catch (Exception e) {
//			throw new ServiceException("no product id is found", e);
//		}
//
//		return "all details are inserted to the cart";
//	}
//	@Override
//	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//	public List<Product> getProductByProductName(String productName) throws ServiceException {
//
//		List<Product> products = null;
//		logger.info("fetching the products details by their name");
//		products = productRepository.findByProductName(productName);
//		if (products == null || products.isEmpty()) {
//			throw new ServiceException("Product name not found");
//		}
//		return products;
//	}
//
//
//	@Override
//	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//	public String updateCart(CartDTO cartDTO) throws ServiceException {
//
//		int delete= 0,update=0;
//
//		if (cartDTO.getProductQuantity() < 0) {
//			logger.info("quantity cannot be in negative");
//			throw new ServiceException("quantity shouldn't be in negative");
//		} else if (cartDTO.getProductQuantity() == 0) {
//			delete = cartRepository.deleteProductFromCart(cartDTO.getCartId());
//		}else{
//			update = cartRepository.updateProductInCart(cartDTO.getProductQuantity(),
//					cartDTO.getCartId(), cartDTO.getuserId());
//
//		}
//		if (delete == 0 && update == 0) {
//			throw new ServiceException("product not found in the cart");
//		}
//	
//		return "cart updated successfully";
//	}
//	
//	@Override
//	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
//	public List<Product> addProduct() throws ServiceException {
//
//		Product products = null;
//		List<Product> listOfProducts = new ArrayList<>();
//		try {
//			
//			products = new Apparel(1, "apparel", 80, "nike", "short", "sports");
//			listOfProducts.add(products);
//			products = new Book(2, "book", 90, "robert kiyosaki", "business", "armour");
//			listOfProducts.add(products);
//			products = new Book(3, "book", 67, "austen", "historical ", "tight");
//			listOfProducts.add(products);
//			products = new Apparel(4, "apparel", 49, "roadster", "long", "causual");
//			listOfProducts.add(products);
//			logger.info("saving all the products list");
//			productRepository.saveAll(listOfProducts);
//		} catch (Exception e) {
//			logger.warn("exception while fetching the products details");
//			throw new ServiceException("unable to add products");
//		}
//
//		return listOfProducts;
//	}
//
//	@Override
//	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
//	public Integer deleteAllProductsDetailsFromCart() throws ServiceException {
//		
//		logger.info("deleting all the details from the cart");
//		int deleteAllProductFromCart=cartRepository.deleteAllProductFromCart();
//		
//		if(deleteAllProductFromCart==0) {
//			logger.warn("unable to found product");
//			throw new ServiceException("no product in cart");
//		}
//		
//		return deleteAllProductFromCart;
//	}
//
//	@Override
//	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
//	public Integer deleteProductFromCart(int cartId) throws ServiceException {
//		
//		int deleteProduct=cartRepository.deleteProductFromCart(cartId);
//		if(deleteProduct==0) {
//			throw new ServiceException("no product found in the cart");
//		}
//		return deleteProduct;
//	}
//	
//	
//}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.shoppingcart.dto.CartDTO;
import com.mindtree.shoppingcart.entity.Apparel;
import com.mindtree.shoppingcart.entity.Book;
import com.mindtree.shoppingcart.entity.Cart;
import com.mindtree.shoppingcart.entity.Product;
import com.mindtree.shoppingcart.entity.User;
import com.mindtree.shoppingcart.exception.ServiceException;
import com.mindtree.shoppingcart.repository.CartRepository;
import com.mindtree.shoppingcart.repository.ProductRepository;
import com.mindtree.shoppingcart.repository.UserRepository;
import com.mindtree.shoppingcart.service.ShoppingCartService;

@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CartRepository cartRepository;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String addProductDetailsToCart(int userId, int productId) throws ServiceException {

		List<Product> listOfProducts = new ArrayList<>();

		HashMap<Integer, Integer> productQuantity = new HashMap<>();

		Cart cart = new Cart();
		User user = new User();
		Product product = new Product();
		float amount;
		try {

			user = userRepository.getOne(userId);
			cart = user.getCart();

			amount = cart.getPriceTotal();

//			productQuantity = cart.getProductQuantity();
		} catch (Exception e) {
			logger.warn("exception while fetching user id");
			throw new ServiceException("no user id is found", e);
		}

		try {

			product = productRepository.getOne(productId);
			listOfProducts = cart.getProduct();
			if (productQuantity.get(product.getProductId()) != null) {

				listOfProducts.add(product);
//				productQuantity.put(product.getProductId(), 1);
//				totalPrice = totalPrice + product.getProductPrice();

			} else {
				productQuantity.put(product.getProductId(), productQuantity.get(product.getProductId() + 1));
				amount = amount + product.getProductPrice();
			}
			cart.setProduct(listOfProducts);
			cart.setPriceTotal(amount);
			cart.setProductQuantity(productQuantity);
			user.setCart(cart);
			cart.setUser(user);
			listOfProducts = cart.getProduct();
			
			logger.info("saving all the details to the cart");
			userRepository.save(cart.getUser());
		} catch (Exception e) {
			throw new ServiceException("no product id is found", e);
		}

		return "all details are inserted to the cart";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<User> addUser() throws ServiceException {

		User users=null;
		Cart cart=null;
		List<User> listOfUser = new ArrayList<>();
		HashMap<Integer, Integer> productQuantity = new HashMap<>();
		try {
//			productQuantity.put(1, 0);
//			productQuantity.put(2, 0);
			users = new User();
			cart = new Cart();
			users.setUserId(1);
			users.setUserEmail("amitesh@yahoo.com");
			users.setUserName("amitesh");
			cart.setPriceTotal(2);
			cart.setProductQuantity(productQuantity);
			cart.setUser(users);
			users.setCart(cart);
			listOfUser.add(users);
			users = new User();
			cart = new Cart();
			users.setUserId(2);
			users.setUserEmail("jacksonsentro@rediff.com");
			users.setUserName("jackson");
			cart.setPriceTotal(1);
			cart.setProductQuantity(productQuantity);
			cart.setUser(users);
			users.setCart(cart);
			listOfUser.add(users);
			logger.info("saving all the users");
			userRepository.saveAll(listOfUser);
		} catch (Exception e) {
			logger.warn("exception while fetching the user details");
			throw new ServiceException("unable to add users");
		}
	

		return listOfUser;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Product> addProduct() throws ServiceException {

		Product products = null;
		List<Product> listOfProducts = new ArrayList<>();
		try {
			
			products = new Apparel(1, "apparel", 80, "nike", "short", "sports");
			listOfProducts.add(products);
			products = new Book(2, "book", 90, "chetan bhagat", "love story", "armour");
			listOfProducts.add(products);
			products = new Book(3, "book", 67, "austen", "historical ", "tight");
			listOfProducts.add(products);
			products = new Apparel(4, "apparel", 49, "roadster", "long", "causual");
			listOfProducts.add(products);
			logger.info("saving all the products list");
			productRepository.saveAll(listOfProducts);
		} catch (Exception e) {
			logger.warn("exception while fetching the products details");
			throw new ServiceException("unable to add products");
		}

		return listOfProducts;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Product> searchAllProduct() throws ServiceException {

		List<Product> products = new ArrayList<Product>();
		try {
			logger.info("searching all the products availability");
			products = productRepository.findAll();
		} catch (Exception e) {
			logger.warn("exception while fetching the products details");
			throw new ServiceException("unable to search all products");
		}
	return products;
	}



	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<Product> getProductByProductName(String productName) throws ServiceException {

		List<Product> products = null;
		logger.info("fetching the products details by their name");
		products = productRepository.findByProductName(productName);
		if (products == null || products.isEmpty()) {
			throw new ServiceException("Product name not found");
		}
		return products;
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String updateCart(CartDTO cartDTO) throws ServiceException {

		int remove= 0,update=0;

		if (cartDTO.getProductQuantity() < 0) {
			logger.info("quantity cannot be in negative");
			throw new ServiceException("quantity shouldn't be in negative");
		} else if (cartDTO.getProductQuantity() == 0) {
			remove = cartRepository.deleteProductFromCart(cartDTO.getCartId());
		}else{
			update = cartRepository.updateProductInCart(cartDTO.getProductQuantity(),
					cartDTO.getCartId(), cartDTO.getuserId());

		}
		if (remove == 0 && update == 0) {
			throw new ServiceException("product not found in the cart");
		}
	
		return "cart updated successfully";
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public Integer deleteAllProductsDetailsFromCart() throws ServiceException {
		
		logger.info("deleting all the details from the cart");
		int deleteAllProductFromCart=cartRepository.deleteAllProductFromCart();
		if(deleteAllProductFromCart==0) {
			logger.warn("unable to found product");
			throw new ServiceException("no product in cart");
		}
		
		return deleteAllProductFromCart;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public Integer deleteProductFromCart(int cartId) throws ServiceException {
		
		int deleteProduct=cartRepository.deleteProductFromCart(cartId);
		if(deleteProduct==0) {
			throw new ServiceException("no product found in the cart");
		}
		return deleteProduct;
	}
	
	
}
