package org.example.jmh;

import java.util.concurrent.TimeUnit;
import org.example.Diffusion;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, warmups = 2)
@Warmup(iterations = 2)
public class SampleBenchmark {

  @Benchmark
  @Timeout(time = 5, timeUnit = TimeUnit.SECONDS)
  public void RunTestsBenchmark(Blackhole bh) {
    Diffusion sim = new Diffusion();
    int[] output = sim.simulate(10, 10);
    bh.consume(output);
  }
}
