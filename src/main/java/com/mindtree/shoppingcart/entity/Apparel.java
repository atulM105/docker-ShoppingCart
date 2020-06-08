package com.mindtree.shoppingcart.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class Apparel extends Product {
	
	private String apparelType;
	
	private String apparelBrand;
	
	private String apparelDesign;

	public String getApparelType() {
		return apparelType;
	}

	public void setApparelType(String apparelType) {
		this.apparelType = apparelType;
	}

	public String getApparelBrand() {
		return apparelBrand;
	}

	public void setApparelBrand(String apparelBrand) {
		this.apparelBrand = apparelBrand;
	}

	public String getApparelDesign() {
		return apparelDesign;
	}

	public void setApparelDesign(String apparelDesign) {
		this.apparelDesign = apparelDesign;
	}

	public Apparel(int productId,String productName,float productPrice,String apparelType, String apparelBrand, String apparelDesign) {
		super( productId, productName, productPrice);
		this.apparelType = apparelType;
		this.apparelBrand = apparelBrand;
		this.apparelDesign = apparelDesign;
	}

	@Override
	public String toString() {
		return "Apparel [apparelType=" + apparelType + ", apparelBrand=" + apparelBrand + ", apparelDesign="
				+ apparelDesign + "]";
	}

	public Apparel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apparelBrand == null) ? 0 : apparelBrand.hashCode());
		result = prime * result + ((apparelDesign == null) ? 0 : apparelDesign.hashCode());
		result = prime * result + ((apparelType == null) ? 0 : apparelType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apparel other = (Apparel) obj;
		if (apparelBrand == null) {
			if (other.apparelBrand != null)
				return false;
		} else if (!apparelBrand.equals(other.apparelBrand))
			return false;
		if (apparelDesign == null) {
			if (other.apparelDesign != null)
				return false;
		} else if (!apparelDesign.equals(other.apparelDesign))
			return false;
		if (apparelType == null) {
			if (other.apparelType != null)
				return false;
		} else if (!apparelType.equals(other.apparelType))
			return false;
		return true;
	}
	
	
	

}
