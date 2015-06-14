/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainLayer.DomainControllers;

import DomainLayer.DataInterface.CtrlJugador;
import DomainLayer.DataInterface.StrategyPuntuacio;
import DomainLayer.DomainModel.Jugador;
import TuplePair.TuplePair;
import TuplePair.TuplePairComparator;
import java.util.ArrayList;
import static java.util.Collections.sort;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Bernat Montseny
 */
public class CtrlRanking {

    private DataFactory dataFactory = null;

    public CtrlRanking() {
        dataFactory = DataFactory.getInstance();
    }
    
    public ArrayList<TuplePair<String,Integer>> ConsultarRanking(StrategyPuntuacio SP) throws Exception {
        CtrlJugador Cj = dataFactory.getCtrlJugador();
        Set<Jugador> setJ = Cj.all();
        boolean zeroPartides = true;
        Set<Jugador> sJp = new HashSet<Jugador>();
        for (Jugador J : setJ) {
            if (J.haJugatPartida()) {
                zeroPartides = false;
                sJp.add(J);
            }
        }
        if (zeroPartides) throw new Exception ("noHiHaPartides");
        ArrayList<TuplePair<String,Integer>> OrderRank = SP.ObteRanking(sJp);
        sort(OrderRank, new TuplePairComparator());
        return OrderRank;
    }
}
