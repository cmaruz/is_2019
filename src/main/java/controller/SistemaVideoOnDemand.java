package controller;

import controller.impl.PersistenceException;
import entity.Video;
import java.util.List;

public interface SistemaVideoOnDemand {
  List<Video> ricercaPerNome(String nome) throws PersistenceException;

  List<Video> ricercaPerSport(String sport) throws PersistenceException;


  void caricamentoContenuto();

  int OttieniVisualizzazioniVideo(Video video);

}
