/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainLayer.DataInterface;

import DomainLayer.DomainModel.Casella;
import java.util.Set;

/**
 *
 * @author Bernat Montseny
 */
public interface CtrlCasella {
    public Casella get (Integer idPartida, Integer numeroFila, Integer numeroColumna) throws Exception;
    public boolean exists(Integer idPartida, Integer numeroFila, Integer numeroColumna);
    public Set<Casella> all();
}
