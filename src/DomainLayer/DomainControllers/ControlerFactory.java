/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainLayer.DomainControllers;

/**
 *
 * @author Bernat Montseny
 */
public class ControlerFactory {
    private static ControlerFactory instance = null;
    private static CtrlLogin ctrlLogin = null;
    private static CtrlRanking ctrlRanking = null;
    
    protected ControlerFactory() {}
    
    public static ControlerFactory getInstance() {
        if(instance == null) {
            instance = new ControlerFactory();
        }
        return instance;
    }
    
    public static CtrlLogin getCtrlLogin() {
        if(ctrlLogin == null) {
            ctrlLogin = new CtrlLogin();
        }
        return ctrlLogin;
    }
    
    public static CtrlRanking getCtrlRanking() {
        if(ctrlRanking == null) {
            ctrlRanking = new CtrlRanking();
        }
        return ctrlRanking;
    }
}
