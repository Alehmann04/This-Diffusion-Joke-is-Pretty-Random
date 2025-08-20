package diffusion;

public class App {

  public static void noTime() {
    int n = 10;
    int m = 10;
    Diffusion sim = new Diffusion();
    int[] results = sim.simulateTrials(n, m);
    System.out.println(
      "Number of Steps (N)\tTrial Number (M)\tFinal Position (D)"
    );
    for (int i = 0; i < results.length; i++) {
      System.out.println("N:" + n + "  M:" + i + "  D:" + results[i]);
    }
  }

  public static void time() {
    Diffusion sim = new Diffusion();
    double[][] results = sim.simulateTrialsWithTime(10, 10);

    System.out.println(
      "Number of Steps (N)\tTrial Number (M)\tFinal Position (D)\tTime (T)"
    );
    for (int i = 0; i < results.length; i++) {
      System.out.printf(
        "N: %d steps\tM: %d trial\tD: %d units\tT: %f milliseconds\n",
        (int) results[i][0],
        (int) results[i][1],
        (int) results[i][2],
        results[i][3]
      );
    }
  }

  public static void timing() {
    int runs = 5;
    int[] groups = { 10, 20, 50, 100 };
    double[][] results = new double[(groups.length * runs)][4];

    Diffusion sim = new Diffusion();

    for (int group = 0; group < groups.length; group++) {
      for (int run = 0; run < runs; run++) {
        double start = System.nanoTime();
        int pos = sim.simulateTrial(groups[group]);
        double end = System.nanoTime();

        int x = (group + 1) * (run + 1) - 1;
        results[x][0] = groups[group];
        results[x][1] = run + 1;
        results[x][2] = pos;
        results[x][3] = (end - start) / 10000;
      }
    }

    for (int i = 0; i < results.length; i++) {
      System.out.printf(
        "%d\t%d\t%d\t%f\n",
        (int) results[i][0],
        (int) results[i][1],
        (int) results[i][2],
        results[i][3]
      );
    }
  }

  public static void main(String[] args) {
    //noTime();
    //time();
    timing();
  }
}
