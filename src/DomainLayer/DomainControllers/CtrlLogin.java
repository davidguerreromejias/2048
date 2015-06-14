/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainLayer.DomainControllers;
import DomainLayer.DataInterface.*;
import DomainLayer.DomainModel.*;
/**
 *
 * @author Bernat Montseny
 */
public class CtrlLogin {
    
    private DataFactory dataFactory = null;

    public CtrlLogin() {
        dataFactory = DataFactory.getInstance();
    }
    
    public void Login(String userN, String passwd) throws Exception {
        CtrlUsuariRegistrat cUR = dataFactory.getCtrlUsuariRegitrat();
        UsuariRegistrat ur = cUR.get(userN);
        if(ur.getPwd().equals(passwd)) {
            throw new Exception ("pwdIncorrecte");
        }
    }
}
