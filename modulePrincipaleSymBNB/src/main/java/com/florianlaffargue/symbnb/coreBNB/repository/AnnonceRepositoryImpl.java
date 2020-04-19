/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.florianlaffargue.symbnb.coreBNB.repository;

import com.florianlaffargue.symbnb.coreBNB.HibernateUtil;
import com.florianlaffargue.symbnb.coreBNB.dto.AnnonceDto;
import com.florianlaffargue.symbnb.coreBNB.dto.ImageDto;
import com.florianlaffargue.symbnb.coreBNB.entity.Annonce;
import com.florianlaffargue.symbnb.coreBNB.entity.Image;
import com.florianlaffargue.symbnb.coreBNB.entity.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Flo
 */
public class AnnonceRepositoryImpl {
    
    public Annonce getById(int id) {
        
        Session session = null;      
        Transaction tx = null;
        Annonce annonce = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            annonce = session.get(Annonce.class, id);
            tx.commit();
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
        
        return annonce; 
       
    }
    
    public List<Annonce> getAll() {
        
        Session session = null;      
        Transaction tx = null;
        List<Annonce> annonces = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            Query<Annonce> query = session.createQuery("SELECT a FROM Annonce a", Annonce.class);
            annonces = query.getResultList();
          
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
        
        return annonces; 
    }
    
    public List<Annonce> getList(int number) {
        
        Session session = null;      
        Transaction tx = null;
        List<Annonce> annonces = null;
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            Query<Annonce> query = session.createQuery("SELECT a FROM Annonce a", Annonce.class).setMaxResults(number);
            annonces = query.getResultList();
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
        
        return annonces; 
    }
    
    public void create(AnnonceDto dto) {
        
        Session session = null;      
        Transaction tx = null;
        Annonce annonce = null;
        
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            
            annonce = new Annonce();
            annonce.setTitle(dto.getTitle());
            annonce.setSlug(dto.getSlug());
            annonce.setPrice(dto.getPrice());
            annonce.setIntroduction(dto.getIntroduction());
            annonce.setContent(dto.getContent());
            annonce.setCoverImage(dto.getCoverImage());
            annonce.setRooms(dto.getRooms());
            
            User user = new User();
            user.setId(dto.getAuthor().getId());
            annonce.setAuthor(user);
            
            List<Image> images = new ArrayList();
            
            for (ImageDto imageDto : dto.getImages()) {
                Image image = new Image();
                image.setUrl(imageDto.getUrl());
                image.setCaption(imageDto.getCaption());
                image.setAnnonce(annonce);
                images.add(image);
            }
            
            annonce.setImages(images);
            
            session.persist(annonce);
            session.flush();
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
        

    }
    
    public Annonce update(int id, AnnonceDto dto) {
        
        Session session = null;      
        Transaction tx = null;
        Annonce annonce = null;
        
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            annonce = session.get(Annonce.class,id);
            
            annonce.setTitle(dto.getTitle());
            annonce.setSlug(dto.getSlug());
            annonce.setPrice(dto.getPrice());
            annonce.setIntroduction(dto.getIntroduction());
            annonce.setContent(dto.getContent());
            annonce.setCoverImage(dto.getCoverImage());
            annonce.setRooms(dto.getRooms());
            
            session.flush();
            
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if (session != null) {
                session.close();
            }
            
            return annonce;
        }
    }
    
    public Annonce delete(int id){
        
        Session session = null;      
        Transaction tx = null;
        Annonce annonce = null;
        
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();
            annonce = session.get(Annonce.class,id);
            session.delete(annonce);
            session.flush();
            
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
        
        return annonce;
    }
}
