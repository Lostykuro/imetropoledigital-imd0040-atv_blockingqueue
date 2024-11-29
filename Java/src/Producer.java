import java.util.concurrent.*;

class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                //parte que gera numero
                int number = ThreadLocalRandom.current().nextInt(1, 101);
                queue.put(number);
                System.out.println(Thread.currentThread().getName() + " produziu: " + number);

                //cooldown
                Thread.sleep(ThreadLocalRandom.current().nextInt(200, 801));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}