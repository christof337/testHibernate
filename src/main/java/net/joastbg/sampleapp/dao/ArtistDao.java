package net.joastbg.sampleapp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.joastbg.sampleapp.entities.Artist;
import net.joastbg.sampleapp.exceptions.DaoException;

@Service
@Transactional
public class ArtistDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public Long persist(Artist Artist){
		Session session = sessionFactory.getCurrentSession();
		Long returnID = (Long) session.save(Artist);
		return returnID;
	}
	
	public Artist find(Long id){
		Session session = sessionFactory.getCurrentSession();
		return (Artist) session.load(Artist.class, id);
	}	
	
	public Artist findByName(String name) throws DaoException {
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("FROM Artist WHERE name = :name");
		q.setString("name", name);
		List l = q.list();
		if ( l.size() > 1 ) {
			throw new DaoException("Multiple results");
		} else {
			return (Artist) l.get(0);
		}
	}	
}
