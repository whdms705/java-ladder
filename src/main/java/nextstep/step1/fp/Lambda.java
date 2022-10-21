package nextstep.step1.fp;

import java.util.List;

public class Lambda {
    public static void printAllOld(List<Integer> numbers) {
        System.out.println("printAllOld");

        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public static void printAllLambda(List<Integer> numbers) {
        System.out.println("printAllLambda");

        numbers.forEach(System.out::println);
    }

    public static void runThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from thread");
            }
        }).start();
    }

    public static int sumAll(List<Integer> numbers) {
        return numbers.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    public static int sumAllEven(List<Integer> numbers) {
        return numbers.stream()
            .mapToInt(Integer::intValue)
            .filter(number -> number % 2 == 0)
            .sum();
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return numbers.stream()
            .mapToInt(Integer::intValue)
            .filter(number -> number > 3)
            .sum();
    }

    public static int sumAllByCondition(List<Integer> numbers, Conditional conditional) {
        return numbers.stream()
            .filter(number -> conditional.test(number))
            .mapToInt(Integer::intValue)
            .sum();
    }
}