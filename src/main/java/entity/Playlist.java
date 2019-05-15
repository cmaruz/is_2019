package entity;

import java.util.List;

public class Playlist {
  private String nome;
  private List<Video> lista;

  public Playlist(String nome, List<Video> lista) {
    this.nome = nome;
    this.lista = lista;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Video> getLista() {
    return lista;
  }

  public void setLista(List<Video> lista) {
    this.lista = lista;
  }
}
