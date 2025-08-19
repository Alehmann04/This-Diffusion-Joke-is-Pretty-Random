package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiffusionTests {

  // This is just an example test file to demonstrate how everything works
  // You should delete this file when you implement your own solution

  @Test
  void itRunsNTests() {
    Diffusion sim = new Diffusion();
    assertEquals(sim.simulate(10, 10).length, 10);
  }
}
