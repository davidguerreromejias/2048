/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import DomainLayer.DomainModel.Casella;
import DomainLayer.DataInterface.CtrlCasella;
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
public class CtrlCasellaDB implements CtrlCasella {

    public CtrlCasellaDB() {
    }

    @Override
    public Casella get(Integer idPartida, Integer numeroFila, Integer numeroColumna) throws Exception {
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
        List<Casella> l = session.createQuery("from Casella where idPartida = :idP and numeroFila = :nF and numeroColumna = :nC").setParameter("idP", idPartida).setParameter("nF", numeroFila).setParameter("nC", numeroColumna).list();
        session.getTransaction().commit();
        factory.close();
        if (!l.isEmpty()) {
           return l.get(0);
        }
        throw new Exception("casellaNoExisteix");
    }

    @Override
    public boolean exists(Integer idPartida, Integer numeroFila, Integer numeroColumna) {
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
        List<Casella> l = session.createQuery("from Casella where idPartida = :idP and numeroFila = :nF and numeroColumna = :nC").setParameter("idP", idPartida).setParameter("nF", numeroFila).setParameter("nC", numeroColumna).list();
        session.getTransaction().commit();
        factory.close();
        return !l.isEmpty();
    }

    @Override
    public Set<Casella> all() {
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
        List<Casella> l = session.createQuery("from Casella").list();
        session.getTransaction().commit();
        factory.close();
        Set<Casella> r = new HashSet();
        for (Casella c : l) {
            r.add(c);
        }
        return r;
    }
    
}
