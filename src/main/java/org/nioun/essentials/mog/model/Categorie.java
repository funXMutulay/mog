package org.nioun.essentials.mog.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


public enum Categorie{
    
    PARFUM("Parfum"),
    BEBE("Bebe"),
    CORPS("Corps"),
    VISAGE("Visage"),
    CHEVEUX("Cheveux"),
    MAKEUP("Makeup");

    public final String label;

    Categorie(String label) {
        this.label = label;
    }
}
