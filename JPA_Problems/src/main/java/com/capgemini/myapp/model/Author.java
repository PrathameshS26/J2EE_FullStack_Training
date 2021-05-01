package com.capgemini.myapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Author {

	@Id
	@Column(name = "name" , length = 20)
	private String name;
	@Column(name = "Id")
	private int Id;
	
	
	@ManyToMany
	@JoinTable(name = "book_author_table" , joinColumns = {@JoinColumn(name = "name")} , inverseJoinColumns = {@JoinColumn(name = "title")})
	private Set<Book> bookSet = new HashSet<Book>();
	
	public Author() {}

	public Author(int id, String name) {
		super();
		Id = id;
		this.name = name;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBookSet() {
		return bookSet;
	}

	public void setBookSet(Set<Book> bookSet) {
		this.bookSet = bookSet;
	}
}
