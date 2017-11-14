class ThreadByThread extends Thread {
    private Thread t;
    private String threadName;

    ThreadByThread(String name){
        this.threadName=name;
        System.out.println("Creating "+threadName);
    }
    public void run(){
        System.out.println("Running "+threadName);
        try{
            for(int i=4;i>0;i--){
                System.out.println("Thread: "+threadName+", "+i);
                //让线程睡一会
                Thread.sleep(850);
            }
        }catch (InterruptedException e){
            System.out.println("Thread "+threadName+" interrupted.");
        }
        System.out.println("Thread "+threadName+" exiting.");
    }

    public void start(){
        System.out.println("Starting "+threadName);
        if(t==null){
            t=new Thread(this,threadName);
            t.start();
        }
    }
}

public class ThreadDemo{
    public static void main(String[] args){
        ThreadByThread t1=new ThreadByThread("Thread-1");
        t1.start();

        ThreadByThread t2=new ThreadByThread("Thread-2");
        t2.start();

        ThreadByThread t3=new ThreadByThread("Thread-3");
        t3.start();

        ThreadByThread t4=new ThreadByThread("Thread-4");
        t4.start();

        ThreadByThread t5=new ThreadByThread("Thread-5");
        t5.start();

        ThreadByThread t6=new ThreadByThread("Thread-6");
        t6.start();

        ThreadByThread t7=new ThreadByThread("Thread-7");
        t7.start();

        ThreadByThread t8=new ThreadByThread("Thread-8");
        t8.start();

        ThreadByThread t9=new ThreadByThread("Thread-9");
        t9.start();
    }
}