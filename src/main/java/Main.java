import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Collection<MyThread> tasks = new ArrayList<>();
        tasks.add(new MyThread());
        tasks.add(new MyThread());
        tasks.add(new MyThread());
        tasks.add(new MyThread());
        final ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Collection<Future<Integer>> results = threadPool.invokeAll(tasks);
        Integer results2 = threadPool.invokeAny(tasks);

        for (Future<Integer> result : results) {
            System.out.println("Выведено сообщений " + result.get());
        }
        System.out.println("результат случайной задачи " + results2);
        long start = System.currentTimeMillis();
        long end = start + 15 * 1000;

        while (System.currentTimeMillis() < end) {
        }

        threadPool.shutdown();

    }
}
