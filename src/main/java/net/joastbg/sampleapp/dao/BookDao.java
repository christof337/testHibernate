package net.joastbg.sampleapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.joastbg.sampleapp.entities.Book;
import net.joastbg.sampleapp.exceptions.DaoException;

@Service
@Transactional
public class BookDao {
	

	@Autowired
	SessionFactory sessionFactory;
	
	public Long persist(Book book){
		Session session = sessionFactory.getCurrentSession();
		Long returnID = (Long) session.save(book);
		return returnID;
	}
	
	public Book find(Long id){
		Session session = sessionFactory.getCurrentSession();
		return (Book) session.load(Book.class, id);
	}

	public Book findByTitle(String title) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("FROM Book WHERE title = :title");
		q.setString("title", title);
		List l = q.list();
		if ( l.isEmpty() ) {
			throw new DaoException("No result");
		} else if ( l.size() > 1 ) {
			throw new DaoException("Multiple results");
		} else {
			return (Book) l.get(0);
		}
	}	
	
	public Book findByIsbn(String isbn) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("FROM Book WHERE isbn = :isbn");
		q.setString("isbn", isbn);
		List l = q.list();
		if ( l.isEmpty() ) {
			throw new DaoException("No result");
		} else if ( l.size() > 1 ) {
			throw new DaoException("Multiple results");
		} else {
			return (Book) l.get(0);
		}
	}	
}
