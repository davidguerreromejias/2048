/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2048;

import DomainLayer.DomainControllers.CtrlJugarPartida;
import TuplePair.TuplePair;
import java.util.ArrayList;
import java.util.Set;
import org.javatuples.Quartet;
import org.javatuples.Triplet;


/**
 *
 * @author Octavi
 */
public class CPJugarPartida {
    
    private VistaJugarPartida vJugarPartida;
    private VistaLogin vLogin;
    private VistaFinalPartida vFinal;
    private VistaRanking vRank;
    private CtrlJugarPartida cdJugar;
    private String user;
    
    public CPJugarPartida(){
        cdJugar = new CtrlJugarPartida();
        vJugarPartida = null;
        vLogin = null;
        vRank = null;
        vFinal = null;
        user = null;
    }
    //JUGAR---------------------------------------------------------------------
    void inicializarPartida() {
        if(vFinal != null) vFinal.setVisible(false);
        if(vLogin != null) vLogin.setVisible(false);
        if(vRank != null) vRank.setVisible(false);
        if(vJugarPartida != null) vJugarPartida.setVisible(false);
        
        vJugarPartida = new VistaJugarPartida();
        vJugarPartida.setCPJugar(this);
        vJugarPartida.setVisible(true);
        
        Triplet<Integer,Integer,Set<Triplet<Integer,Integer,Integer>>> infoStart = cdJugar.crearPartida();
        //puntInicial, millorPunt, caselles(i,j,num)
        vJugarPartida.initPartida(infoStart);
    }

    Quartet<Boolean,Boolean,Integer,Set<Triplet<Integer,Integer,Integer>>> ferMoviment(String mov){
        Quartet<Boolean,Boolean,Integer,Set<Triplet<Integer,Integer,Integer>>> infoPartida = cdJugar.FerMoviment(mov);
        //guanyada, acabada, puntuacio, set(i, j, num)
        return infoPartida;
    }
    //FI JUGAR------------------------------------------------------------------
    
    
    //VISTA LOGIN---------------------------------------------------------------
    void inicializarLogin() {
        vLogin = new VistaLogin();
        vLogin.setVisible(true);
        vLogin.setCPJugar(this);
    }
     void doLogin(String u, String pass) throws Exception {
         if(u.equals("")) throw new Exception("Usuari incorrecte");
         if(pass.equals("")) throw new Exception("Contrasenya incorrecte");
         cdJugar.ferAutenticacio(u, pass);
         user = u;
     }
    //FI VISTA LOGIN------------------------------------------------------------
  
    //VISTA RANKING-------------------------------------------------------------
    void inicializarRanking() {
        vRank = new VistaRanking(user,this);
        vRank.setVisible(true);
        vFinal.setVisible(false);
    }
    ArrayList<TuplePair<String,Integer>> consultarRanking() throws Exception {
        ArrayList<TuplePair<String,Integer>> info = cdJugar.ObtenirRanking();
        return info;
    }
    //FI RANKING----------------------------------------------------------------

    void inicializarFinal(boolean guanyat, String punt) {
        vFinal = new VistaFinalPartida(guanyat, this, punt);
        vFinal.setVisible(true);
        vFinal.setCPJugar(this);
    }

    
}
