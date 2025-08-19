package org.example;

public class App {

  // public static void main(String[] args) {
  //   GreetingGenerator generator = new GreetingGenerator();
  //   System.out.println(generator.sayHello());
  // }

  public static void main(String[] args) {
    int n = 10;
    int m = 10;
    Diffusion sim = new Diffusion();
    int[] results = sim.simulate(n, m);

    for (int i = 0; i < results.length; i++) {
      System.out.println(
        "N:" + n + "  M:" + i + "  D:" + results[i] + "  T:10"
      );
    }
  }
}
