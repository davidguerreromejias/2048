/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainLayer.DomainModel;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.javatuples.Triplet;

/**
 *
 * @author Francesc
 */
@Entity
public class Jugador extends UsuariRegistrat {
    
    private String email;
    private Integer millorPuntuacio;
    @OneToOne (targetEntity=Partida.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Partida partidaActual;
    
    @Transient
    private Set<Partida> partidaJugada;
    

    public Jugador() {
        super();
    }
    
    public Jugador(String email, String nom, String cognom, String username, String pwd) {
        super(nom, cognom, username, pwd);
        this.email = email;
        this.millorPuntuacio = 0;
        this.partidaActual = null;
        this.partidaJugada = new HashSet<Partida>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMillorPuntuacio() {
        return millorPuntuacio;
    }

    public void setMillorPuntuacio(Integer millorPuntuacio) {
        this.millorPuntuacio = millorPuntuacio;
    }
    /*
    public Integer getPartidaActual() {
        return partidaActual;
    }

    public void setPartidaActual(Integer partidaActual) {
        this.partidaActual = partidaActual;
    }
    */
    public String getUsername() {
        return super.getUsername();
    }
    
    public void setUsername(String username) {
        super.setUsername(username);
    }
    
    public Set<Triplet<Integer,Integer,Integer>> crearPartida(Integer id) {
    	System.out.println("entra crarPartida");
        Partida p = new Partida(id,false,false,0);
        p.crearCaselles();
        p.nouNumero();
        p.nouNumero();
        Set<Triplet<Integer,Integer,Integer>> casAmbNum = p.casellesAmbNum();
        partidaActual = p;
        return casAmbNum;
    }
    
    public Integer getMitjanaPuntuacio() {
        Integer p = 0;
        if(!partidaJugada.isEmpty()) {
            for (Partida P : partidaJugada) {
                p += P.getPuntuacio();
            }
            p = p / partidaJugada.size();
        }
        return p;
    }
    
    public Boolean haJugatPartida() {
        if (partidaJugada.size()>0) {
            return true;
        }
        return false;
    }
    
    public Partida getPartidaActual() {
        return partidaActual;
    }

    public void actualitzaMillorPuntuacio(Integer p) {
        if (p>millorPuntuacio) { millorPuntuacio = p; }
    }

    public void switchPartida(Partida dlPartidaActual) {
        partidaJugada.add(partidaActual);
        partidaActual = null;
    }
}
