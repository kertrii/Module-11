import java.util.stream.Stream;

public class LinearCongruentialGenerator {
    private long a;
    private long c;
    private long m;
    private long seed;
    public LinearCongruentialGenerator (long a, long c, long m, long seed) {
        this.a = a;
        this.c = c;
        this.m = m;
        this.seed = seed;
    }

    public Stream<Long> generateStream() {
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }
}
