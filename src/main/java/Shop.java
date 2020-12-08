import java.util.Arrays;
import java.util.concurrent.atomic.LongAdder;

public class Shop {
    private final int[] mas = new int[50];
    private final LongAdder longAdder;

    public Shop(LongAdder longAdder) {
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int)(Math.random() * 10);
            for (int j = 0; j < i; j++) {
                if (mas[i] == mas[j]) {
                    mas[j] = (int) (Math.random() * 10);
                }
            }
        }
        this.longAdder = longAdder;
    }
    public int getSum(){
        return Arrays.stream(mas).sum();
    }
    void calculate(){
        System.out.println("Продажи магазина " + Thread.currentThread().getName() + " составили " + getSum() + " р.");
        longAdder.add(getSum());
    }
}
