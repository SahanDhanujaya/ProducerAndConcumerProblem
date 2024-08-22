package lk.ijse;

class Pool{
    int num;
    boolean value = false;

    synchronized public void produce(int num){
        while (value){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.num = num;
        System.out.println("Producer product - "+num);
        value = true;
        notify();
    }
    synchronized public void consume(){
        while (!value){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        value = false;
        System.out.println("Consumer consume - "+num);
        notify();
    }
}
class Consumer implements Runnable{
    Pool pool;
    Thread t = new Thread(this,"Consumer");
    public Consumer(Pool pool){
        this.pool = pool;
        t.start();
    }
    @Override
    public void run() {
        while (true){
            pool.consume();
        }
    }
}
class Producer implements Runnable{
    Pool pool;
    Thread t = new Thread(this,"Producer");
    public Producer(Pool pool){
        this.pool = pool;
        t.start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true){
            pool.produce(i++);
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