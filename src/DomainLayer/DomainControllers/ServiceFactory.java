/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainLayer.DomainControllers;

import DomainLayer.DataInterface.ServiceMissatgeAdapter;

/**
 *
 * @author Bernat Montseny
 */
public class ServiceFactory {
    
    private static ServiceFactory instance = null;
    private static ServiceMissatgeAdapter serviceMissatgeAdapter = null;
    
    protected ServiceFactory(){}
    
    public static ServiceFactory getInstance() {
        if(instance == null) {
           instance = new ServiceFactory();
        }
        return instance;
    }
    
    public static ServiceMissatgeAdapter getServiceMissatgeAdapter() {
        if(serviceMissatgeAdapter == null) {
            // falta la classe que implementa el serviceMissatgeAdapter
          // serviceMissatgeAdapter = new ServiceMissatgeAdapterI();
        }
        return serviceMissatgeAdapter;
    }
}
