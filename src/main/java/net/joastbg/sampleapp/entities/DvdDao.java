package net.joastbg.sampleapp.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DvdDao {
	

	@Autowired
	SessionFactory sessionFactory;
	
	public Long persist(Dvd dvd){
		Session session = sessionFactory.getCurrentSession();
		Long returnID = (Long) session.save(dvd);
		return returnID;
	}
	
	public Dvd find(Long id){
		Session session = sessionFactory.getCurrentSession();
		return (Dvd) session.load(Dvd.class, id);
	}

	
}
