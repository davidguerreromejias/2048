/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TuplePair;

import java.util.Comparator;
import java.util.Objects;


/**
 *
 * @author Bernat Montseny
 */
public class TuplePair<String,Integer> {
    private String l;
    private Integer r;

    public TuplePair(String l, Integer r){
        this.l = l;
        this.r = r;
    }

    public TuplePair(){

    }

    public String getL(){
        return  l;
    }

    public Integer getR(){
        return r;
    }

    public void setL(String l){
        this.l = l;
    }

    public void setR(Integer r){
        this.r = r;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final TuplePair other = (TuplePair) obj;
        return (Objects.equals(this.l, other.l) && Objects.equals(this.r, other.r)) || (Objects.equals(this.l, other.r) &&
                Objects.equals(this.r,other.l));
    }
}
