/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainLayer.DataInterface;

import DomainLayer.DomainModel.Partida;
import java.util.Set;

/**
 *
 * @author Bernat Montseny
 */
public interface CtrlPartida {
    
    public Partida get(Integer idPartida) throws Exception;
    
    public boolean exists (Integer idPartida);
    
    Set<Partida> all();
}
