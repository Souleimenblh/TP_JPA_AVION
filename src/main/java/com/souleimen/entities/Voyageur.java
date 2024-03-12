package com.souleimen.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Voyageur implements Serializable{
@Id
@GeneratedValue (strategy=GenerationType.IDENTITY) 
//pour autoincrement
private int code;
private String nom;
private String ville;
public int getCode() {
return code;
}
public void setCode(int code) {
this.code = code;
}
public String getNom() {
return nom;
}
public void setNom(String nom) {
this.nom = nom;
}
public String getVille() {
return ville;
}
public void setVille(String ville) {
this.ville = ville;
}
}
