/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainLayer.DataInterface;
import DomainLayer.DomainModel.UsuariRegistrat;
import java.util.Set;
/**
 *
 * @author Bernat Montseny
 */
public interface CtrlUsuariRegistrat {
    
    public UsuariRegistrat get (String username) throws Exception;
    
    public Boolean exists (String username);
    
    public Set<UsuariRegistrat> all();
}
