import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        // Número de threads produtoras e consumidoras
        int producerCount = 2;
        int consumerCount = 2;

        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

        // ExecutorService
        ExecutorService executor = Executors.newCachedThreadPool();

        // Criador de threads produtoras
        for (int i = 0; i < producerCount; i++) {
            executor.execute(new Producer(queue));
        }

        // Criador de threads consumidoras
        for (int i = 0; i < consumerCount; i++) {
            executor.execute(new Consumer(queue));
        }

        try {
            // Timer
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Encerrando o ExecutorService
        executor.shutdownNow();
        System.out.println("A execução acabou :D!");
    }
}