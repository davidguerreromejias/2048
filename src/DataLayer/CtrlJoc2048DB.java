/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import DomainLayer.DataInterface.CtrlJoc2048;
import DomainLayer.DomainModel.Casella;
import DomainLayer.DomainModel.Joc2048;
import DomainLayer.DomainModel.Jugador;
import DomainLayer.DomainModel.Partida;
import DomainLayer.DomainModel.UsuariRegistrat;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
/**
 *
 * @author Bernat Montseny
 */
public class CtrlJoc2048DB implements CtrlJoc2048 {
    
    public CtrlJoc2048DB() {}
    
    @Override
    public Joc2048 get() {
        AnnotationConfiguration config = new AnnotationConfiguration();
        config.addAnnotatedClass(Partida.class);
        config.addAnnotatedClass(Casella.class);
        config.addAnnotatedClass(Jugador.class);
        config.addAnnotatedClass(UsuariRegistrat.class);
        config.addAnnotatedClass(Joc2048.class);
        config.configure("hibernate.cfg.xml");
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        List<Joc2048> l = session.createQuery("from Joc2048").list();
        session.getTransaction().commit();
        factory.close();
        if (!l.isEmpty()) return l.get(0);
        else {
            Joc2048 j = Joc2048.joc2048();
            return j;
        }
    }
    
}
