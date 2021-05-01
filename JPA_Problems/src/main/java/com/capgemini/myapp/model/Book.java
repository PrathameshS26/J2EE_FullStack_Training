package com.capgemini.myapp.model;

import java.util.*;

import javax.persistence.*;

@Entity
public class Book {

	@Id
	@Column(name="title", length=10)
	private String title;
	@Column(name = "ISBN", length=10)
	private String ISBN;
	@Column(name="price")
	private Double price;
	
	@ManyToMany
	@JoinTable(name = "book_author_table" , joinColumns = {@JoinColumn(name = "title")}, inverseJoinColumns = {@JoinColumn(name = "")})
	private Set <Author> authorSet = new HashSet<Author>(); 
	
	public Book() {}

	

	public Book(String iSBN, String title, Double price) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.price = price;
	}



	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Set<Author> getAuthorSet() {
		return authorSet;
	}

	public void setAuthorSet(Set<Author> authorSet) {
		this.authorSet = authorSet;
	}
}
