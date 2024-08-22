package lk.ijse;

class Pool{
    int num;
    boolean value = false;

    synchronized public void put(int num){
        while (value){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.num = num;
        System.out.println("Producer produce - "+num);
        value = true;
        notify();
    }
    synchronized public void get() throws InterruptedException {
        while (!value){
            wait();
        }
        System.out.println("Consumer consume - "+num);
        value = false;
        notify();
    }
}
class Producer implements Runnable{
    Pool pool;
    public Producer(Pool pool){
        this.pool = pool;
        Thread t1 = new Thread(this, "Producer");
        t1.start();
    }
    @Override
    public void run() {
        int i = 0;
        while (true){
            pool.put(i++);
        }
    }
}
class Consumer implements Runnable{
    Pool pool;
    public Consumer(Pool pool){
        this.pool = pool;
        Thread t2 = new Thread(this, "Consumer");
        t2.start();
    }
    @Override
    public void run() {
        while (true){
            try {
                pool.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Pool pool = new Pool();
        new Producer(pool);
        new Consumer(pool);

    }
}