package diffusion;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1)
public class DiffusionBenchmarkWithResults {

  @Param({ "10" })
  public int trials;

  @Param({ "10", "20", "50", "100" })
  public int steps;

  ArrayList<Integer> pos;

  @Setup
  public void prepare() {
    pos = new ArrayList<Integer>();
  }

  @TearDown
  public void output() {
    String positions = pos.toString();
    System.out.println("Steps: " + steps + " Positions:" + positions);
  }

  @Benchmark
  @Timeout(time = 5, timeUnit = TimeUnit.SECONDS)
  public void RunTestsBenchmark(Blackhole bh) {
    Diffusion sim = new Diffusion();
    int output = 0;
    for (int trial = 0; trial < trials; trial++) {
      output = sim.simulateTrial(steps);
      pos.add(Integer.valueOf(output));
    }
    bh.consume(output);
  }
}
