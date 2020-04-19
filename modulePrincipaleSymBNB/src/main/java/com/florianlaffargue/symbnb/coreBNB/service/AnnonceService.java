/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.florianlaffargue.symbnb.coreBNB.service;

import com.florianlaffargue.symbnb.coreBNB.dto.AnnonceDto;
import com.florianlaffargue.symbnb.coreBNB.entity.Annonce;
import com.florianlaffargue.symbnb.coreBNB.repository.AnnonceRepositoryImpl;
import java.util.List;

/**
 *
 * @author Flo
 */
public class AnnonceService {
    
    private AnnonceRepositoryImpl annonceRepositoryImpl;
    
    public AnnonceService() {
        this.annonceRepositoryImpl = new AnnonceRepositoryImpl();
    }
    
    public Annonce getAnnonce(int id) {
        return this.annonceRepositoryImpl.getById(id);
    }
    
    public List<Annonce> getAllAnnonces() {
        return this.annonceRepositoryImpl.getAll();
                
    }
    public List<Annonce> getListAnnonces(int number) {
        return this.annonceRepositoryImpl.getList(number);
    }
    
    public Annonce updateAnnonce(int id, AnnonceDto dto) {
        return this.annonceRepositoryImpl.update(id, dto);
    }
    
    public Annonce deleteAnnonce(int id) {
        return this.annonceRepositoryImpl.delete(id);
    }
    
    public void createAnnonce(AnnonceDto dto) {
        this.annonceRepositoryImpl.create(dto);
    }
   
    
}
