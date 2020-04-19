/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.florianlaffargue.symbnb.coreBNB.dto;

import com.florianlaffargue.symbnb.coreBNB.entity.Annonce;

/**
 *
 * @author Flo
 */
public class ImageDto {

    private int id;  
    private AnnonceDto annonce;
  
    private String url;
    private String caption;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AnnonceDto getAnnonce() {
        return annonce;
    }

    public void setAnnonce(AnnonceDto annonce) {
        this.annonce = annonce;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

}
