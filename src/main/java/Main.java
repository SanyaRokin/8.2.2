import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        LongAdder stat = new LongAdder();
        Shop shop1 = new Shop(stat);
        Shop shop2 = new Shop(stat);
        Shop shop3 = new Shop(stat);

        Thread thread1 = new Thread(null, shop1::calculate, "Магазин 1");
        Thread thread2 = new Thread(null, shop2::calculate, "Магазин 2");
        Thread thread3 = new Thread(null, shop3::calculate, "Магазин 3");
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println("Продажи за день: " + stat.sum()+ "р.");
    }
}
