package boundary;


import controller.impl.DefaultSistemaVideoOnDemand;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class ApplicationConsoleBoundary {

  private final InputStream in;
  private BufferedReader consoleReader;
  private PrintWriter consoleWriter;

  public ApplicationConsoleBoundary(InputStream in) {
    this.in = in;
  }

  /**
   * @throws IOException
   *
   */
  private void doLogin() {

  }

  /**
   *
   */
  private void doLogout() {
  }

  /**
   * @return
   * @throws IOException
   */
  public TerminationState runApplication()  {
    ClienteRegistratoConsoleBoundary clienteRegistratoConsoleBoundary = new ClienteRegistratoConsoleBoundary(
        in,
        DefaultSistemaVideoOnDemand.getInstance()
        );

    try {
      clienteRegistratoConsoleBoundary.showBoundary();
      return TerminationState.CORRECT_TERMINATION;
    } catch (IOException e) {
      handleException(e);
      return TerminationState.ABNORMAL_TERMINATION;
    }
  }

  /**
   * @param e
   */
  public void handleException(Exception e) {
    consoleWriter.format("Attenzione: Errore fatale nell'esecuzione: %s", e.getMessage());
    consoleWriter.flush();
  }

  public static enum TerminationState {
    CORRECT_TERMINATION,
    ABNORMAL_TERMINATION
  };

}