package net.joastbg.sampleapp.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DiskDao {
	

	@Autowired
	SessionFactory sessionFactory;
	
	public Long persist(Disk disk){
		Session session = sessionFactory.getCurrentSession();
		Long returnID = (Long) session.save(disk);
		return returnID;
	}
	
	public Disk find(Long id){
		Session session = sessionFactory.getCurrentSession();
		return (Disk) session.load(Disk.class, id);
	}

	
}
