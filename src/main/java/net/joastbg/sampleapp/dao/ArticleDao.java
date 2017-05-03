package net.joastbg.sampleapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.joastbg.sampleapp.entities.Article;

@Service
@Transactional
public class ArticleDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public Long persist(Article article){
		Session session = sessionFactory.getCurrentSession();
		Long returnID = (Long) session.save(article);
		return returnID;
	}
	
	public Article find(Long id){
		Session session = sessionFactory.getCurrentSession();
		return (Article) session.load(Article.class, id);
	}
}
