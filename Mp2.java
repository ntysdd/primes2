import java.math.BigInteger;

public class Mp2 {
    static boolean isPrime(BigInteger n) {
        return n.signum() > 0 && n.isProbablePrime(100);
    }

    public static void main(String[] args) {

        for (int i = 1; i <= 1000; i++) {
            if (!isPrime(BigInteger.valueOf(i))) {
                continue;
            }

            System.out.print(i);
            f(i);

            System.out.println();
        }

    }

    static void f(int n) {
        int count = 0;


        for (int i = 2; ; i++) {
            BigInteger d = BigInteger.valueOf(i - 1);
            BigInteger x = BigInteger.valueOf(i).pow(n)
                .subtract(BigInteger.ONE).divide(d);
            if (isPrime(x)) {
                System.out.print(" " + i);
                count++;
                if (count == 100) {
                    return;
                }
            }
        }
    }

}
