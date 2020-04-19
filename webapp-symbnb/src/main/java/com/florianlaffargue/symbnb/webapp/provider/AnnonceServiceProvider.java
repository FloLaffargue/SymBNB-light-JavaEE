/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.florianlaffargue.symbnb.webapp.provider;

import com.florianlaffargue.symbnb.coreBNB.service.AnnonceService;

/**
 *
 * @author Flo
 */
public class AnnonceServiceProvider {
    
    private static AnnonceService annonceService = null;
    
    public static AnnonceService getAnnonceService() {
        if(annonceService == null) {
            annonceService = new AnnonceService();  
        }
        return annonceService;  
    }
      
}
