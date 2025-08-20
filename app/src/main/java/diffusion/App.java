package diffusion;

public class App {

  public static void main(String[] args) {
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
}
