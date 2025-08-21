package diffusion;

import java.io.FileWriter;
import java.io.IOException;

public class DiffusedWrite extends Diffusion {

  public boolean coinFlip() {
    return super.coinFlip();
  }

  public int simulateTrial(int n) {
    return super.simulateTrial(n);
  }

  public int[] simulateTrials(int n, int m) {
    return super.simulateTrials(n, m);
  }

  public void simulateToFile(int[] groups, int trials) {
    int run = 0;
    int rows = (groups.length * trials);
    String[] data = new String[rows];
    for (int group = 0; group < groups.length; group++) {
      for (int trial = 0; trial < trials; trial++) {
        int pos = simulateTrial(groups[group]);
        data[run] = "" + groups[group] + "," + trial + "," + pos + "\n";
        run++;
      }
    }
    write_file(data);
  }

  void write_file(String[] data) {
    try {
      FileWriter dataDocument = new FileWriter("Data.txt");
      dataDocument.append("Steps,Trial,Pos\n");
      for (int run = 0; run < data.length; run++) {
        dataDocument.append(data[run]);
      }
      dataDocument.close();
      System.out.println("Successfully wrote the data.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}
