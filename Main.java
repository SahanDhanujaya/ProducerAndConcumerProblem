/*----------------------Thread Class------------------*/
/*
class A extends Thread{
    @Override //inherited from runnable interface
     public void run(){
         for (int i = 0; i < 10; i++) {
             System.out.println("print");
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
         }
    }
}
class B extends Thread{
    @Override //inherited from runnable interface
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("dhanu");
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
        A a = new A();
        B b = new B();
        a.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        b.start();
    }
}
*/
/*----------------------Runnable Interface------------------*/
/*class A implements Runnable{
    @Override //inherited from runnable interface
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("print");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class B implements Runnable{
    @Override //inherited from runnable interface
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("dhanu");
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
        A a = new A();
        B b = new B();
        Thread t1 = new Thread(a);
        t1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread t2 = new Thread(b);
        t2.start();
    }
}*/
/*--------------------------------isAlive()----------------------*/
/*
class A implements Runnable{
    @Override //inherited from runnable interface
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("print");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class B implements Runnable{
    @Override //inherited from runnable interface
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("dhanu");
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
        A a = new A();
        B b = new B();
        Thread t1 = new Thread(a);
        t1.start();
        System.out.println(t1.isAlive());;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread t2 = new Thread(b);
        t2.start();
        System.out.println(t2.isAlive());
    }
}*/
class Display{
    synchronized public static void print(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class T implements Runnable{
    @Override
    public void run(){
        Display.print();
    }
}
public class Main {
    public static void main(String[] args) {
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("hi Hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
