/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainLayer.DomainControllers;

import DataLayer.*;
import DomainLayer.DataInterface.*;
/**
 *
 * @author Bernat Montseny
 */
public class DataFactory {
    private static DataFactory instance = null;
    private static CtrlJoc2048 ctrlJoc2048 = null;
    private static CtrlUsuariRegistrat ctrlUsuariRegitrat = null;
    private static CtrlJugador ctrlJugador = null;
    private static CtrlPartida ctrlPartida = null;
    private static CtrlCasella ctrlCasella = null;
    
    protected DataFactory() {}
    
    public static DataFactory getInstance() {
        if (instance == null) {
            instance = new DataFactory();
        }
        return instance;
    }

    public static CtrlJoc2048 getCtrlJoc2048() {
        if (ctrlJoc2048 == null) {
            ctrlJoc2048 = new CtrlJoc2048DB();
        }
        return ctrlJoc2048;
    }

    public static CtrlUsuariRegistrat getCtrlUsuariRegitrat() {
        if (ctrlUsuariRegitrat == null) {
            ctrlUsuariRegitrat = new CtrlUsuariRegistratDB();
        }
        return ctrlUsuariRegitrat;
    }

    public static CtrlJugador getCtrlJugador() {
        if (ctrlJugador == null) {
            ctrlJugador = new CtrlJugadorDB();
        }
        return ctrlJugador;
    }

    public static CtrlPartida getCtrlPartida() {
        if (ctrlPartida == null) {
            ctrlPartida = new CtrlPartidaDB();
        }
        return ctrlPartida;
    }

    public static CtrlCasella getCtrlCasella() {
        if (ctrlCasella == null) {
            ctrlCasella = new CtrlCasellaDB();
        }
        return ctrlCasella;
    }
    
    
}
