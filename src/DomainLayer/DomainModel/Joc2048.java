/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainLayer.DomainModel;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Francesc
 */
@Entity
public class Joc2048 implements Serializable {
    
    @Id
    private final Integer idJoc;
    private Integer idPartida;
    
    @Transient
    private static Joc2048 instance;
    
    protected Joc2048(){
        idJoc = 0;
    }
    
    public static synchronized Joc2048 joc2048() {
        if (instance == null) {
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
            if (l.isEmpty()) {
                instance = new Joc2048();
                instance.setIdPartida(0);
                session.save(instance);
            }
            else instance = l.get(0);
            session.getTransaction().commit();
            factory.close();
        }
        return instance;
    }

    public Integer getIdPartida() {
        return joc2048().idPartida;
    }
    
    public void setIdPartida(Integer id) {
        idPartida = id;
    }
    
    
}
