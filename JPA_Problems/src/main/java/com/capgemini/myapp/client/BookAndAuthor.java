package com.capgemini.myapp.client;

import javax.persistence.*;

import com.capgemini.myapp.model.Author;
import com.capgemini.myapp.model.Book;

public class BookAndAuthor {

	public static void main(String[] args) {
		
		Book book1 = new Book("100-10-01", "book1", 1005.00);
		Book book2 = new Book("100-10-02", "book2", 225.50);
		Book book3 = new Book("100-10-03", "book3", 500.00);
		Book book4 = new Book("100-10-04", "book4", 800.00);
		Book book5 = new Book("100-10-05", "book5", 1500.00);
		Book book6 = new Book("100-10-06", "book6", 1800.00);
		
		Author auth1 = new Author(101 , "author1");
		Author auth2 = new Author(102 , "author2");
		Author auth3 = new Author(103 , "author3");
		
		auth1.getBookSet().add(book1);
		auth1.getBookSet().add(book2);
		auth1.getBookSet().add(book3);
		auth2.getBookSet().add(book6);
		auth2.getBookSet().add(book3);
		auth3.getBookSet().add(book5);
		auth3.getBookSet().add(book4);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(auth1);
		entityManager.persist(auth2);
		entityManager.persist(auth3);
		
		entityManager.persist(book1);
		entityManager.persist(book2);
		entityManager.persist(book3);
		entityManager.persist(book4);
		entityManager.persist(book5);
		entityManager.persist(book6);
	
//		Query query = entityManager.createQuery("select e.title from Book as e ");
//		List<String> bookList = query.getResultList();
//		for(String list : bookList) {
//			System.out.println(list);
//		}
//		
		//Scanner sc = new Scanner(System.in);
//		Query query = entityManager.createQuery("select e.bookSet from Author as e where e.name = ?1");
//		query.setParameter(1, sc.next());
//		List<Book> bookList = query.getResultList();
//		for(Book set : bookList) {
//			System.out.println(set.getTitle());
//		}
		
//		Query query = entityManager.createQuery("select e.title from Book as e where e.price > 500.00 and e.price < 1000.00");
//		List<String> bookList= query.getResultList();
//		for(String list: bookList) {
//			System.out.println(list);
//		}
	
//		Query query = entityManager.createQuery("select e.authorSet from Book as e where e.ISBN =? 1");
//		query.setParameter(1, sc.next());
//		List<Author> authList = query.getResultList();
//		for(Author list : authList) {
//			System.out.println(list.getName());
//		}
//		
//		sc.close();
		entityManager.getTransaction().commit();
		entityManager.close();

	}

}
