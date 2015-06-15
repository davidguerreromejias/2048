package DomainLayer.DomainModel;

import DomainLayer.DataInterface.StrategyPuntuacio;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import javax.persistence.*;
import org.javatuples.Triplet;

@Entity
public class Partida implements Serializable {
	
    @Id
    private Integer idPartida;
    private boolean estaAcabada;
    private boolean estaGuanyada;
    private Integer puntuacio;
    @ManyToOne (targetEntity=Jugador.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Jugador jugadorPartidaJugada;
    @OneToOne (targetEntity=Jugador.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Jugador jugadorPartidaActual;
        
    @Transient
    private Casella matriu[][];
    @Transient
    private StrategyPuntuacio strategyPuntuacio;
	
	
    public Partida(){}
    
    public Partida(Integer idPartida,boolean estaAcabada, boolean estaGuanyada, Integer puntuacio) {
        this.idPartida = idPartida;
        this.estaAcabada = estaAcabada;
        this.estaGuanyada = estaGuanyada;
        this.puntuacio = puntuacio;
        this.matriu = new Casella[4][4];
    }
    
    public int getIdPartida() {
	return idPartida;
    }
	
    public void setIdPartida(int idPartida) {
	this.idPartida = idPartida;
    }
	
    public boolean getEstaAcabada() {
    	return estaAcabada;
    }
	
    public void setEstaAcabada(boolean estaAcabada) {
	this.estaAcabada = estaAcabada;
    }
	
    public boolean getEstaGuanyada() {
	return estaGuanyada;
    }
	
    public void setEstaGuanyada(boolean estaGuanyada) {
	this.estaGuanyada = estaGuanyada;
    }
	
    public int getPuntuacio() {
    	return puntuacio;
    }
	
    public void setPuntuacio(int puntuacio) {
	this.puntuacio = puntuacio;
    }

    public Casella[][] getMatriu() {
	return matriu;
    }

    public void setMatriu(Casella[][] matriu) {
	this.matriu = matriu;
    }

    public Jugador getJugadorPartidaJugada() {
        return jugadorPartidaJugada;
    }

    public void setJugadorPartidaJugada(Jugador jugadorPartidaJugada) {
        this.jugadorPartidaJugada = jugadorPartidaJugada;
    }

    public Jugador getJugadorPartidaActual() {
        return jugadorPartidaActual;
    }

    public void setJugadorPartidaActual(Jugador jugadorPartidaActual) {
        this.jugadorPartidaActual = jugadorPartidaActual;
    }


    
    public void setStrategyPuntuacioMillor() {
        this.strategyPuntuacio = new StrategyPuntuacioMillor();
    }
    
    public StrategyPuntuacio getStrategyPuntuacio() {
        return strategyPuntuacio;
    }
    
    public void crearCaselles() {
        int i = 1;
        int j = 1;
        while (j<=4) {
            matriu[i-1][j-1] = new Casella(i,j,idPartida);
            i++;
            if (i==5) {
                j++;
                i=1;
            }
        }
    }
    
    public void nouNumero(){
        Random randomGenerator = new Random();
        int i = randomGenerator.nextInt(4)+1;
        int j = randomGenerator.nextInt(4)+1;
        boolean assignat = false;
        while(!assignat) {
            if (matriu[i-1][j-1].getNumero()==0) {
                int n = randomGenerator.nextInt(2);
                if (n==0) {n=2;}
                else if (n==1) {n=4;}
                matriu[i-1][j-1].setNumero(n);
                assignat = true;
            }
            i = randomGenerator.nextInt(4)+1;
            j = randomGenerator.nextInt(4)+1;
        }
    }

    public Set<Triplet<Integer,Integer,Integer>> casellesAmbNum() {
        Set<Triplet<Integer,Integer,Integer>> casAmbNum = new HashSet<Triplet<Integer,Integer,Integer>>();
        int i = 0;
        int j = 0;
        while (j<=3) {
            int n = matriu[i][j].getNumero();
            if (n!= 0) {
               casAmbNum.add(Triplet.with(i+1,j+1,n));
            }
            i++;
            if (i==4) {
                j++;
                i=0;
            }
        }
        return casAmbNum;
    }

    public String comprovarPartidaGuanyada() {
        Set<Triplet<Integer,Integer,Integer>> CI = casellesAmbNum();
        Iterator<Triplet<Integer,Integer,Integer>> it = CI.iterator();
        while (!estaGuanyada && it.hasNext()) {
            if(it.next().getValue2()==2048) {
                estaGuanyada = true;
                estaAcabada = true;
            }
        }
        String missatge = new String();
        if (estaGuanyada) {
            missatge = idPartida + "/" + puntuacio.toString();
        }
        return missatge;
    }

    public void movimentAmunt() {
        int j = 1;
        while (j<=4) {
            int i = 4;
            Casella c = matriu[i-1][j-1];
            int oldi = c.getNumeroFila()-1;
            int oldj = c.getNumeroColumna()-1;
            int oldn = c.getNumero();
            i--;
            while (i>=1) {
                c = matriu[i-1][j-1];
                int n = c.getNumero();
                if (n!=0) {
                    if (oldn!=0) {
                        c.setNumero(0);
                        c = matriu[oldi][oldj];
                        c.setNumero(n);
                        oldn = n;
                    }
                    else if (oldn==n){
                        c.setNumero(0);
                        c = matriu[oldi][oldj];
                        c.setNumero(n+n);
                        puntuacio += 2*n;
                        oldi--;
                        c = matriu[oldi][oldj];
                        n = c.getNumero();
                        oldn = n;
                    }
                    else if (oldn != n) {
                        oldi--;
                        c = matriu[oldi][oldj];
                        oldn = n;
                        c.setNumero(n);
                    }
                }
                i--;
            }
            j++;
        }
    }

    public void movimentAvall() {
        int j = 1;
        while (j<=4) {
            int i = 1;
            Casella c = matriu[i-1][j-1];
            int oldi = c.getNumeroFila()-1;
            int oldj = c.getNumeroColumna()-1;
            int oldn = c.getNumero();
            i++;
            while (i<=4) {
                c = matriu[i-1][j-1];
                int n = c.getNumero();
                if (n!=0) {
                    if (oldn!=0) {
                        c.setNumero(0);
                        c = matriu[oldi][oldj];
                        c.setNumero(n);
                        oldn = n;
                    }
                    else if (oldn==n){
                        c.setNumero(0);
                        c = matriu[oldi][oldj];
                        c.setNumero(n+n);
                        puntuacio += 2*n;
                        oldi++;
                        c = matriu[oldi][oldj];
                        n = c.getNumero();
                        oldn = n;
                    }
                    else if (oldn != n) {
                        oldi++;
                        c = matriu[oldi][oldj];
                        oldn = n;
                        c.setNumero(n);
                    }
                }
                i++;
            }
            j++;
        }
    }

    public void movimentDreta() {
        int i = 1;
        while (i<=4) {
            int j = 4;
            Casella c = matriu[i-1][j-1];
            int oldi = c.getNumeroFila()-1;
            int oldj = c.getNumeroColumna()-1;
            int oldn = c.getNumero();
            j--;
            while (j>=1) {
                c = matriu[i-1][j-1];
                int n = c.getNumero();
                if (n!=0) {
                    if (oldn!=0) {
                        c.setNumero(0);
                        c = matriu[oldi][oldj];
                        c.setNumero(n);
                        oldn = n;
                    }
                    else if (oldn==n){
                        c.setNumero(0);
                        c = matriu[oldi][oldj];
                        c.setNumero(n+n);
                        puntuacio += 2*n;
                        oldj--;
                        c = matriu[oldi][oldj];
                        n = c.getNumero();
                        oldn = n;
                    }
                    else if (oldn != n) {
                        oldj--;
                        c = matriu[oldi][oldj];
                        oldn = n;
                        c.setNumero(n);
                    }
                }
                j--;
            }
            i++;
        }
    }

    public void movimentEsquerra() {
        int i = 1;
        while (i<=4) {
            int j = 1;
            Casella c = matriu[i-1][j-1];
            int oldi = c.getNumeroFila()-1;
            int oldj = c.getNumeroColumna()-1;
            int oldn = c.getNumero();
            j++;
            while (j<=4) {
                c = matriu[i-1][j-1];
                int n = c.getNumero();
                if (n!=0) {
                    if (oldn!=0) {
                        c.setNumero(0);
                        c = matriu[oldi][oldj];
                        c.setNumero(n);
                        oldn = n;
                    }
                    else if (oldn==n){
                        c.setNumero(0);
                        c = matriu[oldi][oldj];
                        c.setNumero(n+n);
                        puntuacio += 2*n;
                        oldj++;
                        c = matriu[oldi][oldj];
                        n = c.getNumero();
                        oldn = n;
                    }
                    else if (oldn != n) {
                        oldj++;
                        c = matriu[oldi][oldj];
                        oldn = n;
                        c.setNumero(n);
                    }
                }
                j++;
            }
            i++;
        }
    }

    public void ComprovarPartidaPerduda() {
        int i = 1;
        int j = 1;
        boolean trobat = false;
        while(!trobat && i<=4 && j<=4) {
            Casella c = matriu[i-1][j-1];
            int n = c.getNumero();
            if (n==0) trobat = true;
            else {
                if (j==4 && i==4) {}
                else if (j==4) {
                    c = matriu[i][j-1];
                    int nd = c.getNumero();
                    if (n==nd) {trobat=true;}
                }
                else if (i==4) {
                    c = matriu[i-1][j];
                    int ns = c.getNumero();
                    if (n==ns) {trobat = true;}
                }
                else {
                    c = matriu[i][j-1];
                    int nd = c.getNumero();
                    if (n==nd) {trobat=true;}
                    if (!trobat) {
                        c = matriu[i][j-1];
                        nd = c.getNumero();
                        if (n==nd) {trobat=true;}
                    }
                }
            }
            j++;
            if (j==4) {
                i++;
                j=1;
            }
        }
        if (trobat) {estaAcabada=true;}
    }

}
