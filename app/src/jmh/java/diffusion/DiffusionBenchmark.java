package diffusion;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode({ Mode.AverageTime, Mode.SingleShotTime })
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(value = 1)
public class DiffusionBenchmark {

  @Param({ "10" })
  public int trials;

  @Param({ "10", "20", "50", "100" })
  public int steps;

  @Benchmark
  @Timeout(time = 5, timeUnit = TimeUnit.SECONDS)
  public void RunTestsBenchmark(Blackhole bh) {
    Diffusion sim = new Diffusion();
    int[] output = sim.simulateTrials(steps, trials);
    bh.consume(output);
  }
}
