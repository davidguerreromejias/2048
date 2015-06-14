/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainLayer.DataInterface;

import DomainLayer.DomainModel.Jugador;
import TuplePair.TuplePair;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import org.javatuples.Pair;

/**
 *
 * @author Bernat Montseny
 */
public interface StrategyPuntuacio {
    
    public ArrayList<TuplePair<String,Integer>> ObteRanking(Set<Jugador> sJp);
}
