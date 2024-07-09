import java.util.Iterator;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MixStreams {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        return IntStream.iterate(0, i -> i + 1)
                .takeWhile(i -> firstIterator.hasNext() || secondIterator.hasNext())
                .mapToObj(i -> Stream.of(
                        firstIterator.hasNext() ? firstIterator.next() : null,
                        secondIterator.hasNext() ? secondIterator.next() : null))
                .flatMap(s -> s)
                .filter(Objects::nonNull);
    }
}
