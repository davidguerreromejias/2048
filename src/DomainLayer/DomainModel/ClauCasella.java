package DomainLayer.DomainModel;

import java.io.Serializable;


public class ClauCasella implements Serializable {
	
	private int idPartida;
	private int numeroFila;
	private int numeroColumna;
	
	
	public ClauCasella() {
		
	}
	
	public ClauCasella(int idPartida, int numeroFila, int numeroColumna) {
		this.idPartida = idPartida;
		this.numeroFila = numeroFila;
		this.numeroColumna = numeroColumna;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPartida;
		result = prime * result + numeroColumna;
		result = prime * result + numeroFila;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClauCasella other = (ClauCasella) obj;
		if (idPartida != other.idPartida)
			return false;
		if (numeroColumna != other.numeroColumna)
			return false;
		if (numeroFila != other.numeroFila)
			return false;
		return true;
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
}
