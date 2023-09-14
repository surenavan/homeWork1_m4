package hmm4_1;


class RunnableThread1 extends Counter implements Runnable{
    public void run(){
        for (int i = 0; i < 1000; i++) {
            increment();
        }
    }
}


class RunnableThread2 extends Counter implements Runnable{
    public void run(){
        for (int i = 0; i < 1000; i++) {
            increment();
        }
    }
}


public class Main extends Counter{
    public static void main(String[] args) {

        Thread thread1 = new Thread(new RunnableThread1());
        Thread thread2 = new Thread(new RunnableThread2());

        thread1.start();
        thread2.start();

        try{
           thread1.join();
           thread2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }



        System.out.println(RunnableThread1.getValue());
        System.out.println(RunnableThread2.getValue());

    }

}

