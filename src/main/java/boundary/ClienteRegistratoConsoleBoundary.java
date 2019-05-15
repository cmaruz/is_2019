package boundary;


import controller.SistemaVideoOnDemand;
import controller.impl.PersistenceException;
import entity.Video;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ClienteRegistratoConsoleBoundary {

  private final Scanner input;
  private final SistemaVideoOnDemand sistemaVideo;

  public ClienteRegistratoConsoleBoundary(InputStream in, SistemaVideoOnDemand sistemaVideo) {
    this.input = new Scanner(in);
    this.sistemaVideo = sistemaVideo;
  }


  private void displayOptions() throws IOException {
      System.out.println("\nMenu\n");
      System.out.println("\n0. Esci dal programma.\n");
      System.out.println("1. Ricerca video per nome\n");
      System.out.println("2. Ricerca video per sport\n");
      System.out.println("Scelta: ");
  }

  public void showBoundary() throws IOException{
    while (true) {
        displayOptions();

        String selection = input.nextLine();

        try {
          int optionValue = Integer.parseInt(selection);
          switch (optionValue) {
            case 0:
              input.close();
              return;
            case 1:
              ricercaPerNome();
              break;
            case 2:
              ricercaPerSport();
              break;
            default:
              System.out.print("Nessuna funzione associata alla selezione! Riprova.\n\n");
          }
        } catch (NumberFormatException e) {
          System.err.println("Valore non valido. Riprova.\n");
        } catch (PersistenceException pe) {
          System.err.println("Impossibile accedere ai video. Riprova. \n");
        } finally {
          input.close();
          return;
        }
    }
  }

  private void ricercaPerSport() throws PersistenceException {
    System.out.println("Inserire il nome del video da cercare: ");
    String sport = input.nextLine();

    List<Video> videoList = sistemaVideo.ricercaPerSport(sport);
    visualizzaContenuto(videoList);
  }

  public void ricercaPerNome() throws PersistenceException {
    System.out.println("Inserire il nome del video da cercare: ");
    String nome = input.nextLine();

    List<Video> videoList = sistemaVideo.ricercaPerNome(nome);
    visualizzaContenuto(videoList);

  }

  private void visualizzaContenuto(List<Video> videoList) {
    if(videoList.size( ) == 0)
    {
      System.out.println("\nNessun video trovato.");
    } else {
      System.out.println("Lista dei video trovati :");

      for (Video v : videoList) {
        System.out.println(
            "ID Video : "
                + v.getID()
                + " - Nome : "
                + v.getNome()
                + " - Sport : "
                + v.getSport()
                + " - Data Registrazione : "
                + v.getDataRegistrazione());
      }
    }
  }

  public void registrazioneSistemaNotifica() {

  }
}




