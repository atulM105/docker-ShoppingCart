package com.mindtree.shoppingcart.entity;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart implements Serializable,Comparable<Cart>{
	
	@Id
	@GeneratedValue
	@Column(name="CART_ID")
	private int cartId;
	
	private float priceTotal;
	
	@Column(name="Product_Quantity")
	private HashMap<Integer, Integer> productQuantity;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="User_Id",unique=true)
	private User user;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Product> product;

	/**
	 * @return the cartId
	 */
	public int getCartId() {
		return cartId;
	}

	/**
	 * @param cartId the cartId to set
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the priceTotal
	 */
	public float getPriceTotal() {
		return priceTotal;
	}

	/**
	 * @param priceTotal the priceTotal to set
	 */
	public void setPriceTotal(float priceTotal) {
		this.priceTotal = priceTotal;
	}

	/**
	 * @return the productQuantity
	 */
	public HashMap<Integer, Integer> getProductQuantity() {
		return productQuantity;
	}

	/**
	 * @param productQuantity the productQuantity to set
	 */
	public void setProductQuantity(HashMap<Integer, Integer> productQuantity) {
		this.productQuantity = productQuantity;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the product
	 */
	public List<Product> getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Cart(int cartId, float priceTotal, HashMap<Integer, Integer> productQuantity, User user,
			List<Product> product) {
		super();
		this.cartId = cartId;
		this.priceTotal = priceTotal;
		this.productQuantity = productQuantity;
		this.user = user;
		this.product = product;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", priceTotal=" + priceTotal + ", productQuantity=" + productQuantity
				+ ", user=" + user + ", product=" + product + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cartId;
		result = prime * result + Float.floatToIntBits(priceTotal);
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((productQuantity == null) ? 0 : productQuantity.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (cartId != other.cartId)
			return false;
		if (Float.floatToIntBits(priceTotal) != Float.floatToIntBits(other.priceTotal))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (productQuantity == null) {
			if (other.productQuantity != null)
				return false;
		} else if (!productQuantity.equals(other.productQuantity))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public int compareTo(Cart o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * @return the cartId
	 */
	
	
	

}
