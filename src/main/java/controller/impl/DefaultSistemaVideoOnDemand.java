package controller.impl;

import controller.SistemaVideoOnDemand;
import entity.Video;
import java.util.List;

public final class DefaultSistemaVideoOnDemand implements SistemaVideoOnDemand {

  private static SistemaVideoOnDemand INSTANCE;
  private final DefaultVideoManager defaultVideoManager;

  private DefaultSistemaVideoOnDemand(DefaultVideoManager defaultVideoManager) {
    this.defaultVideoManager = defaultVideoManager;
  }

  public static synchronized SistemaVideoOnDemand getInstance() {
    if(INSTANCE == null) {
      INSTANCE = new DefaultSistemaVideoOnDemand(new DefaultVideoManager());
    }

    return INSTANCE;
  }

  @Override
  public List<Video> ricercaPerNome(String nome) throws PersistenceException {
    return defaultVideoManager.ricercaPerNome(nome);
  }

  @Override
  public List<Video> ricercaPerSport(String sport) throws PersistenceException {
    return defaultVideoManager.ricercaPerSport(sport);
  }

  @Override
  public void caricamentoContenuto() {

  }

  @Override
  public int OttieniVisualizzazioniVideo(Video video) {
    return 0;
  }
}
