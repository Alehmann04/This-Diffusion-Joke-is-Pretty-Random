package org.example;

import java.util.SplittableRandom;

public class Diffusion {

  SplittableRandom rand = new SplittableRandom();

  public boolean coinFlip() {
    boolean flip = this.rand.nextBoolean();
    return flip;
  }

  public int goCoin(int n) {
    int current_pos = 0;
    for (int step = 0; step < n; step++) {
      if (coinFlip()) {
        current_pos++;
      } else {
        current_pos--;
      }
    }
    return current_pos;
  }

  public int[] simulate(int n, int m) {
    int[] results = new int[m];
    for (int trial = 0; trial < m; trial++) {
      results[trial] = goCoin(n);
    }
    return results;
  }
}
