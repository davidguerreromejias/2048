package DomainLayer.DomainModel;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@IdClass(ClauCasella.class)
public class Casella implements Serializable {
	
    @Id
    private int idPartida;
    @Id
    private int numeroFila;
    @Id
    private int numeroColumna;
    private int numero;

	
    public Casella(){}
	
    public Casella(int i, int j, int idP){
        idPartida = idP;
        numeroFila = i;
        numeroColumna = j;
        numero = 0;
    }
    
    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getNumeroFila() {
        return numeroFila;
    }

    public void setNumeroFila(int numeroFila) {
        this.numeroFila = numeroFila;
    }

    public int getNumeroColumna() {
        return numeroColumna;
    }

    public void setNumeroColumna(int numeroColumna) {
        this.numeroColumna = numeroColumna;
    }
    
    public void setNumero(int n){
        numero = n;
    }
    public int getNumero(){
        return numero;
    }		
}