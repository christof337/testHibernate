package net.joastbg.sampleapp.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthorDao {
	

	@Autowired
	SessionFactory sessionFactory;
	
	public Long persist(Author author){
		Session session = sessionFactory.getCurrentSession();
		Long returnID = (Long) session.save(author);
		return returnID;
	}
	
	public Author find(Long id){
		Session session = sessionFactory.getCurrentSession();
		return (Author) session.load(Author.class, id);
	}	
}
