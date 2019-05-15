package test;

import static org.junit.Assert.*;

import controller.SistemaVideoOnDemand;
import controller.impl.DefaultSistemaVideoOnDemand;
import controller.impl.PersistenceException;
import entity.DAO.TransactionManager;
import entity.DAO.TransactionManagerFactory;
import entity.Video;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RicercaVideoTest {

  @BeforeClass
  public static void initializeDB() throws Exception {
    TransactionManager tm = TransactionManagerFactory.createTransactionManager();
    tm.beginTransaction();
    Statement stmt = tm.getConnection().createStatement();
    stmt.execute("DROP TABLE IF EXISTS VIDEO");
    stmt.execute("DROP TABLE IF EXISTS VIDEO_APPROFONDIMENTO");
    stmt.execute("CREATE TABLE VIDEO ( ID INTEGER PRIMARY KEY, NOME VARCHAR(100), SPORT VARCHAR(20), DATA_REGISTRAZIONE DATE, TIPO VARCHAR(10))");
    stmt.execute("INSERT INTO VIDEO VALUES('1','Napoli-Juventus','Calcio','2017-06-04', 'evento')");
    stmt.execute("INSERT INTO VIDEO VALUES('2','Milan-Roma','Calcio','2017-06-05', 'evento')");
    stmt.execute("INSERT INTO VIDEO VALUES('3','Milan-Napoli','Calcio','2017-06-08', 'evento')");
    stmt.execute("INSERT INTO VIDEO VALUES('4','GP Spagna','Formula 1','2017-06-04', 'evento')");
    stmt.execute("CREATE TABLE VIDEO_APPROFONDIMENTO ( VIDEO_ID INTEGER, GIORNALISTA_ID INTEGER, PRIMARY KEY(VIDEO_ID, GIORNALISTA_ID))");
    tm.commitTransaction();
  }

  private SistemaVideoOnDemand instance;

  @Before
  public void setUpClass() throws Exception {
    instance = DefaultSistemaVideoOnDemand.getInstance();
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void testRicercaPerNomeZeroMatches() throws PersistenceException {
    List<Video> list = instance.ricercaPerNome("Fiorentina");
    assertEquals(0, list.size());
  }

  @Test
  public void testRicercaPerNomeOneMatches() throws PersistenceException {
    List<Video> list = instance.ricercaPerNome("Juventus");
    assertEquals(1, list.size());
  }

  @Test
  public void testRicercaPerNomeMoreMatches() throws PersistenceException {
    List<Video> list = instance.ricercaPerNome("Napoli");
    assertEquals(2, list.size());
  }


  @Test
  public void testRicercaPerSportZeroMatches() throws PersistenceException {
    List<Video> list = instance.ricercaPerNome("Basket");
    assertEquals(0, list.size());
  }

  @Test
  public void testRicercaPerSportOneMatches() throws PersistenceException {
    List<Video> list = instance.ricercaPerSport("Formula 1");
    assertEquals(1, list.size());
  }

  @Test
  public void testRicercaPerSportMoreMatches() throws PersistenceException {
    List<Video> list = instance.ricercaPerSport("Calcio");
    assertEquals(3, list.size());
  }

}
