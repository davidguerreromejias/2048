/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import DomainLayer.DataInterface.CtrlJugador;
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
public class CtrlJugadorDB implements CtrlJugador {

    public CtrlJugadorDB() {
    }

    @Override
    public Jugador getU(String username) throws Exception {
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
        List<Jugador> l = session.createQuery("from Jugador where username = :usr").setParameter("usr", username).list();
        session.getTransaction().commit();
        factory.close();
        if (!l.isEmpty()) return l.get(0);
        throw new Exception("jugadorNoExisteix");
    }

    @Override
    public Jugador getE(String email) throws Exception {
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
        List<Jugador> l = session.createQuery("from Jugador where email = :em").setParameter("em", email).list();
        session.getTransaction().commit();
        factory.close();
        if (!l.isEmpty()) return l.get(0);
        throw new Exception("jugadorNoExisteix");
    }

    @Override
    public Boolean existsU(String username) {
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
        List<Jugador> l = session.createQuery("from Jugador where username = :usr").setParameter("usr", username).list();
        session.getTransaction().commit();
        factory.close();
        return !l.isEmpty(); 
    }

    @Override
    public Boolean existsE(String email) {
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
        List<Jugador> l = session.createQuery("from Jugador where email = :em").setParameter("em", email).list();
        session.getTransaction().commit();
        factory.close();
        return !l.isEmpty();
    }

    @Override
    public Set<Jugador> all() {
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
        List<Jugador> l = session.createQuery("from Jugador").list();
        session.getTransaction().commit();
        factory.close();
        Set<Jugador> r = new HashSet();
        for (Jugador j : l) {
            r.add(j);
        }
        return r;
    }
    
}
