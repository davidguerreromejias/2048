/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainLayer.DomainModel;

import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author Francesc
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class UsuariRegistrat implements Serializable {
    
    private String nom;
    private String cognom;
    @Id
    private String username;
    private String pwd;

    public UsuariRegistrat() {
        
    }
    
    public UsuariRegistrat(String nom, String cognom, String username, String pwd) {
        this.nom = nom;
        this.cognom = cognom;
        this.username = username;
        this.pwd = pwd;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }   
}
