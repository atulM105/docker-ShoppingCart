package com.mindtree.shoppingcart.dto;

public class CartDTO {

	private int cartId;
	
	private int userId;
	
	private int productQuantity;
	
	

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
	 * @return the productId
	 */
	public int getuserId() {
		return userId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the productQuantity
	 */
	public int getProductQuantity() {
		return productQuantity;
	}

	/**
	 * @param productQuantity the productQuantity to set
	 */
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	/**
	 * @return the totalPrice
	 */


	public CartDTO(int cartId, int userId, int productQuantity) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.productQuantity = productQuantity;
		
	}

	public CartDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CartDTO [cartId=" + cartId + ", userId=" + userId + ", productQuantity=" + productQuantity
				+ "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cartId;
		result = prime * result + productQuantity;
		result = prime * result + userId;
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
		CartDTO other = (CartDTO) obj;
		if (cartId != other.cartId)
			return false;
		if (productQuantity != other.productQuantity)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	


	
	
}
