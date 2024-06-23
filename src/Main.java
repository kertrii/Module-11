import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Ivan", "Peter", "Bill", "Alex", "Steve", "Dima");
        System.out.println(HomeWork.getOddIndexedNames(names));
        System.out.println();

        System.out.println(HomeWork.sortedNames(names));
        System.out.println();

        String[] array = {"1, 2, 0", "4, 5"};
        System.out.println(HomeWork.getSortedNumbers(array));
        System.out.println();

        long a = 25214903917L;
        long c = 11;
        long m = (long) Math.pow(2, 48);
        long seed = 1;

        LinearCongruentialGenerator lcg = new LinearCongruentialGenerator(a, c, m, seed);
        Stream<Long> randomNumbers = lcg.generateStream();
        randomNumbers.limit(10).forEach(System.out::println);
        System.out.println();

        Stream<String> first = Stream.of("A", "B", "C", "D");
        Stream<String> second = Stream.of("1", "2", "3");

        Stream<String> zipped = MixStreams.zip(first, second);
        zipped.forEach(System.out::println);
    }
}