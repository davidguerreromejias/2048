/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainLayer.DataInterface;
import DomainLayer.DomainModel.Jugador;
import java.util.Set;
/**
 *
 * @author Bernat Montseny
 */
public interface CtrlJugador {
    
    public Jugador getU (String username)throws Exception;
    
    public Jugador getE (String email)throws Exception;
    
    public Boolean existsU (String username);
    
    public Boolean existsE (String email);
    
    Set<Jugador> all();
    
}
