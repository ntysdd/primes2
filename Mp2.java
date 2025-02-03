import java.math.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class Mp2 {
    static boolean isPrime(BigInteger n) {
        return n.signum() > 0 && n.isProbablePrime(100);
    }

    public static void main(String[] args) throws Exception {

        ExecutorService pool = Executors.newFixedThreadPool(4);

        List<Future<String>> futureList = new ArrayList<>();

        IntStream.range(1, 1000)
            .filter(x -> isPrime(BigInteger.valueOf(x)))
            .forEach(i -> futureList.add(pool.submit(() -> f(i))));

        for (Future<String> future : futureList) {
            System.out.println(future.get());
        }

        pool.shutdown();
    }

    static String f(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);

        int count = 0;

        for (int i = 2; ; i++) {
            BigInteger d = BigInteger.valueOf(i - 1);
            BigInteger x = BigInteger.valueOf(i).pow(n)
                .subtract(BigInteger.ONE).divide(d);
            if (isPrime(x)) {
                sb.append(" " + i);
                count++;
                if (count == 100) {
                    return sb.toString();
                }
            }
        }
    }

}
