package diffusion;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiffusionTests {

  @Test
  void itRunsNTests() {
    Diffusion sim = new Diffusion();
    assertEquals(sim.simulateTrials(10, 10).length, 10);
  }

  @Test
  void itFollowsBoundRules() {
    int trials = 10;
    int[] params = { 10, 20, 50, 100 };
    int[] results;
    Diffusion sim = new Diffusion();
    for (int group = 0; group < params.length; group++) {
      results = sim.simulateTrials(params[group], trials);
      for (int run = 0; run < results.length; run++) {
        assertTrue((Math.abs(results[run]) < (params[group] + 1)));
      }
    }
  }
}
