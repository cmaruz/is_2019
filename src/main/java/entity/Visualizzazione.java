package entity;

import java.util.Date;

public class Visualizzazione {

  private Date dataVisualizzazione;
  private int quantita;

  public Visualizzazione(Date dataVisualizzazione, int quantita) {
    this.dataVisualizzazione = dataVisualizzazione;
    this.quantita = quantita;
  }

  public Date getDataVisualizzazione() {
    return dataVisualizzazione;
  }

  public void setDataVisualizzazione(Date dataVisualizzazione) {
    this.dataVisualizzazione = dataVisualizzazione;
  }

  public int getQuantita() {
    return quantita;
  }

  public void setQuantita(int quantita) {
    this.quantita = quantita;
  }
}
