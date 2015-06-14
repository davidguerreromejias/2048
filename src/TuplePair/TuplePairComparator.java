/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TuplePair;

import java.util.Comparator;

/**
 *
 * @author Bernat Montseny
 */
public class TuplePairComparator implements Comparator<TuplePair<String,Integer>>{
    
    //@Override
    public int compare(TuplePair<String,Integer> o1, TuplePair<String,Integer> o2) {
        return o2.getR() - o1.getR();
    }

}
