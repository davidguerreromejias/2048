/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import DomainLayer.DataInterface.CtrlPartida;
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
public class CtrlPartidaDB implements CtrlPartida{

    public CtrlPartidaDB() {
    }

    @Override
    public Partida get(Integer idPartida) throws Exception{
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
        List<Partida> l = session.createQuery("from Partida where idPartida = :idP").setParameter("idP", idPartida).list();
        session.getTransaction().commit();
        factory.close();
        if (!l.isEmpty()) {
           return l.get(0);
        }
        throw new Exception("partidaNoExisteix");
    }

    @Override
    public boolean exists(Integer idPartida) {
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
        List<Partida> l = session.createQuery("from Partida where idPartida = :idP").setParameter("idP", idPartida).list();
        session.getTransaction().commit();
        factory.close();
        return !l.isEmpty();
    }

    @Override
    public Set<Partida> all() {
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
        List<Partida> l = session.createQuery("from Partida").list();
        session.getTransaction().commit();
        factory.close();
        Set<Partida> r = new HashSet();
        for (Partida p : l) {
            r.add(p);
        }
        return r;
    }
    
}
