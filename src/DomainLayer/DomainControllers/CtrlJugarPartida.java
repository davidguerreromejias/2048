/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainLayer.DomainControllers;
import DomainLayer.DataInterface.*;
import DomainLayer.DomainModel.*;
import TuplePair.TuplePair;
import TuplePair.TuplePairComparator;
import java.util.ArrayList;
import static java.util.Collections.sort;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.javatuples.*;
/**
 *
 * @author Bernat Montseny
 */
public class CtrlJugarPartida {
    /**
     * ctrl que parla amb la vista y crea el de login y ranking
     */
    private ControlerFactory controlerFactory;
    private DataFactory dataFactory;
    private ServiceFactory serviceFactory; 
    private Partida dlPartidaActual;
    private Jugador JugadorConnectat;
    
    public CtrlJugarPartida() {
        controlerFactory = new ControlerFactory();
        dataFactory = new DataFactory();
        serviceFactory = new ServiceFactory();
        dlPartidaActual = null;
        JugadorConnectat = null;
    }
    /**
     *
     * @return
     * @throws Exception
     */
    public Triplet<Integer,Integer,Set<Triplet<Integer,Integer,Integer>>> crearPartida() {
        CtrlJoc2048 cJ2048 = dataFactory.getCtrlJoc2048();
        Joc2048 J2048 = cJ2048.get();
        Integer i = J2048.getIdPartida()+1;
        J2048.setIdPartida(i);
        Set<Triplet<Integer,Integer,Integer>> casellesAmbNum = JugadorConnectat.crearPartida(i);
        Integer mpunt = JugadorConnectat.getMillorPuntuacio();
        dlPartidaActual = JugadorConnectat.getPartidaActual();
        actualitzarDB(dlPartidaActual, JugadorConnectat, true);
        return Triplet.with(0,mpunt,casellesAmbNum);
    }
    
    public void ferAutenticacio(String userN, String password) throws Exception {
        CtrlLogin cL = controlerFactory.getCtrlLogin();
        cL.Login(userN, password);
        CtrlJugador cJ = dataFactory.getCtrlJugador();
        JugadorConnectat = cJ.getU(userN);
        System.out.println("aut");
    }
    
    public Quartet<Boolean,Boolean,Integer,Set<Triplet<Integer,Integer,Integer>>> FerMoviment(String tipusMov) {
        if (tipusMov.equals("amunt")) { dlPartidaActual.movimentAmunt(); }
        else if (tipusMov.equals("avall")) { dlPartidaActual.movimentAvall(); }
        else if (tipusMov.equals("dreta")) { dlPartidaActual.movimentDreta(); }
        else if (tipusMov.equals("esquerra")) { dlPartidaActual.movimentEsquerra(); }
        boolean eA = dlPartidaActual.getEstaAcabada();
        if (!eA) {
            String missatge = dlPartidaActual.comprovarPartidaGuanyada();
            if (!missatge.isEmpty()) {
                ServiceMissatgeAdapter SA = serviceFactory.getServiceMissatgeAdapter();
                SA.enviarMissatge();
                eA = true;
            }
        }
        if (!eA) {
            dlPartidaActual.ComprovarPartidaPerduda();
            eA = dlPartidaActual.getEstaAcabada();
        }
        if (eA) {
            Integer p = dlPartidaActual.getPuntuacio();
            JugadorConnectat.actualitzaMillorPuntuacio(p);
            JugadorConnectat.switchPartida(dlPartidaActual);
        }
        if (!eA) {
            dlPartidaActual.nouNumero();
        }
        boolean eG = dlPartidaActual.getEstaGuanyada();
        Integer p = dlPartidaActual.getPuntuacio();
        Set<Triplet<Integer,Integer,Integer>> CI = dlPartidaActual.casellesAmbNum();
        actualitzarDB(dlPartidaActual, JugadorConnectat, false);
        return Quartet.with(eA, eG, p, CI);
    }
    
    public ArrayList<TuplePair<String,Integer>> ObtenirRanking() throws Exception {
        CtrlRanking cR = controlerFactory.getCtrlRanking();
        return cR.ConsultarRanking(dlPartidaActual.getStrategyPuntuacio());
    }
    
    private void actualitzarDB(Partida p, Jugador jg, Boolean crea) {
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
        if (crea) session.save(p);
        else session.update(p);
        session.update(jg);
        Casella caselles[][] = p.getMatriu();
        for(int i=0; i<4; ++i){
            for(int j=0; j<4; ++j){
                if (crea) session.save(caselles[i][j]);
                else session.update(caselles[i][j]);
            }
        }
        session.getTransaction().commit();
        factory.close();
    }
}