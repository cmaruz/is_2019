package controller.impl;

import entity.DAO.DAOException;
import entity.DAO.TransactionManager;
import entity.DAO.TransactionManagerFactory;
import entity.DAO.VideoDAO;
import entity.Video;
import java.util.List;

public class DefaultVideoManager {


  public List<Video> ricercaPerNome(String nome) throws PersistenceException {
    TransactionManager tm = TransactionManagerFactory.createTransactionManager();
    tm.beginTransaction();
    try
    {
      List<Video> list = VideoDAO.readVideoNome(tm,nome);
      tm.commitTransaction();
      return list;
    }
    catch(DAOException e)
    {
      tm.rollbackTransaction();
      throw new PersistenceException("Impossibile ottenere i video.", e);
    }
  }

  public List<Video> ricercaPerSport(String nome) throws PersistenceException {
    TransactionManager tm = TransactionManagerFactory.createTransactionManager();
    tm.beginTransaction();
    try
    {
      List<Video> list = VideoDAO.readVideoSport(tm,nome);
      tm.commitTransaction();
      return list;
    }
    catch(DAOException e)
    {
      tm.rollbackTransaction();
      throw new PersistenceException("Impossibile ottenere i video.", e);
    }
  }
}
