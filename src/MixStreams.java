import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.Spliterators;
import java.util.Spliterator;

public class MixStreams {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        Iterator<T> zippedIterator = new Iterator<T>() {
            private boolean switcher = true;

            @Override
            public boolean hasNext() {
                return firstIterator.hasNext() && secondIterator.hasNext();
            }

            @Override
            public T next() {
                if (switcher) {
                    switcher = false;
                    return firstIterator.next();
                } else {
                    switcher = true;
                    return secondIterator.next();
                }
            }
        };

        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(zippedIterator, Spliterator.ORDERED), false);
    }
}
