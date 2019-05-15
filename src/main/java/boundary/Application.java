package boundary;

import boundary.ApplicationConsoleBoundary.TerminationState;

public class Application {

  public static void main(String[] args) {
    ApplicationConsoleBoundary applicationConsoleBoundary = new ApplicationConsoleBoundary(System.in);

    TerminationState exitStatus = applicationConsoleBoundary.runApplication();

    if (exitStatus == TerminationState.CORRECT_TERMINATION) {
      System.exit(0);
    } else {
      System.exit(-1);
      }
  }

}
