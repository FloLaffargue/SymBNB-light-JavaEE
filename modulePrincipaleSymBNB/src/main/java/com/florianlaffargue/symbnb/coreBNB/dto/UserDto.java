/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.florianlaffargue.symbnb.coreBNB.dto;

import com.florianlaffargue.symbnb.coreBNB.entity.Annonce;
import java.util.List;

/**
 *
 * @author Flo
 */
public class UserDto {

    private int id;
    private String firstName; 
    private String lastName;
    
    private String email;
    private String picture;
    private String hash;
    private String introduction;
    private String description;
    
    private String slug;
    
    private List<AnnonceDto> annonces;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public List<AnnonceDto> getAnnonces() {
        return annonces;
    }

    public void setAnnonces(List<AnnonceDto> annonces) {
        this.annonces = annonces;
    }

}
