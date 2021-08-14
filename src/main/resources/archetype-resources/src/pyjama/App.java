import java.util.Random;

public class App {
    public static long sumNumbers(int[] numbers, int numThreads) {
        long sum = 0;
        //#omp parallel for reduction(+:sum) shared(numbers) num_threads(numThreads)
        for(int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static int[] createArray(int n) {
        int[] a = new int[n];
        Random random = new Random(123); // fix the seed for reproduceability
        for(int i = 0; i < n; i++) {
            a[i] = random.nextInt(10); // random int between [0..10)
        }
        return a;
    }

    public static void main(String[] args) {
        int n = 10000000;
        int numThreads = 4;
        if (args.length == 0) {
            System.out.println("Usage: App n numThreads");
        }
        if (args.length >= 1) {
            n = Integer.parseInt(args[0]);
        } else {
            System.out.println("Using default n = "+n);
        }
        if (args.length >= 2) {
            numThreads = Integer.parseInt(args[1]);
        } else {
            System.out.println("Using default numThreads = "+numThreads);
        }
        System.out.print("Adding " + n + " random integers between 0 and 9");
        System.out.println(" using "+numThreads+" threads\n");

        int[] a = createArray(n);
        long start = System.currentTimeMillis();
        long sum = sumNumbers(a, numThreads);
        long end = System.currentTimeMillis();
        System.out.println("Sum = "+ sum);
        System.out.println("Time = "+ (end-start)  + " ms");
    }
}