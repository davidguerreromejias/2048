/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainLayer.DomainModel;

import DomainLayer.DataInterface.StrategyPuntuacio;
import TuplePair.TuplePair;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import org.javatuples.Pair;

/**
 *
 * @author Bernat Montseny
 */
public class StrategyPuntuacioMitjana implements StrategyPuntuacio{

    public StrategyPuntuacioMitjana() {
    }

    @Override
    public ArrayList<TuplePair<String, Integer>> ObteRanking(Set<Jugador> sJp) {
        ArrayList<TuplePair<String, Integer>> Os = new ArrayList<TuplePair<String, Integer>>();
            for (Jugador J : sJp) {
                String n = J.getUsername();
                Integer p = J.getMitjanaPuntuacio();
                TuplePair<String,Integer> aux = new TuplePair(n,p);
                Os.add(aux);
            }
        return Os;
    }
    
}
