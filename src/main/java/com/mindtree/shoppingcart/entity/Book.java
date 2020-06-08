package com.mindtree.shoppingcart.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class Book extends Product{
	
	private String bookGenre;
	
	private String bookAuthor;
	
	private String bookPublications;

	/**
	 * @return the bookGenre
	 */
	public String getBookGenre() {
		return bookGenre;
	}

	/**
	 * @param bookGenre the bookGenre to set
	 */
	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	/**
	 * @return the bookAuthor
	 */
	public String getBookAuthor() {
		return bookAuthor;
	}

	/**
	 * @param bookAuthor the bookAuthor to set
	 */
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	/**
	 * @return the bookPublications
	 */
	public String getBookPublications() {
		return bookPublications;
	}

	/**
	 * @param bookPublications the bookPublications to set
	 */
	public void setBookPublications(String bookPublications) {
		this.bookPublications = bookPublications;
	}

	public Book(int productId,String productName,float productPrice,String bookGenre, String bookAuthor, String bookPublications) {
		super(productId,productName,productPrice);
		this.bookGenre = bookGenre;
		this.bookAuthor = bookAuthor;
		this.bookPublications = bookPublications;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [bookGenre=" + bookGenre + ", bookAuthor=" + bookAuthor + ", bookPublications=" + bookPublications
				+ "]";
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int productId, String productName, float productPrice) {
		super(productId, productName, productPrice);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookAuthor == null) ? 0 : bookAuthor.hashCode());
		result = prime * result + ((bookGenre == null) ? 0 : bookGenre.hashCode());
		result = prime * result + ((bookPublications == null) ? 0 : bookPublications.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookAuthor == null) {
			if (other.bookAuthor != null)
				return false;
		} else if (!bookAuthor.equals(other.bookAuthor))
			return false;
		if (bookGenre == null) {
			if (other.bookGenre != null)
				return false;
		} else if (!bookGenre.equals(other.bookGenre))
			return false;
		if (bookPublications == null) {
			if (other.bookPublications != null)
				return false;
		} else if (!bookPublications.equals(other.bookPublications))
			return false;
		return true;
	}

	
	
	
	
	

}
