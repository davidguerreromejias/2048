/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;
import DomainLayer.DataInterface.CtrlUsuariRegistrat;
import DomainLayer.DomainModel.Casella;
import DomainLayer.DomainModel.Joc2048;
import DomainLayer.DomainModel.Jugador;
import DomainLayer.DomainModel.Partida;
import DomainLayer.DomainModel.UsuariRegistrat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
/**
 *
 * @author Bernat Montseny
 */
public class CtrlUsuariRegistratDB implements CtrlUsuariRegistrat{

    public CtrlUsuariRegistratDB() {
    }

    @Override
    public UsuariRegistrat get(String username) throws Exception{
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
        List<UsuariRegistrat> l = session.createQuery("from UsuariRegistrat where username = :usr").setParameter("usr", username).list();
        session.getTransaction().commit();
        factory.close();
        if (!l.isEmpty()) {
           return l.get(0); 
        }
        throw new Exception("usernameNoExisteix"); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Boolean exists(String username) {
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
        List<UsuariRegistrat> l = session.createQuery("from UsuariRegistrat where username = :usr").setParameter("usr", username).list();
        session.getTransaction().commit();
        factory.close();
        return !l.isEmpty(); 
    }

    @Override
    public Set<UsuariRegistrat> all() {
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
        List<UsuariRegistrat> l = session.createQuery("from UsuariRegistrat").list();
        session.getTransaction().commit();
        factory.close();
        Set<UsuariRegistrat> r = new HashSet();
        for (UsuariRegistrat uR : l) {
            r.add(uR);
        }
        return r;
    }
    
    
    
}
