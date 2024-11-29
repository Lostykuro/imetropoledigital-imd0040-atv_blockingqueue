import java.util.concurrent.*;

class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                // Consome o número da fila e x2
                int number = queue.take();
                int result = number * 2;
                System.out.println(Thread.currentThread().getName() + " consumiu: " + number + " -> Dobro: " + result);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}