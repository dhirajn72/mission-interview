public class Deadlock{
    public static Object ob1=new Object();
    public static Object ob2=new Object();
    
    public static void main(String[] args){

        Thread t1=new Thread(){
            public void run(){
                synchronized(ob1){
                    System.out.println("Locked on ob1 object");
                    try{
                        Thread.sleep(100);
                    }
                    catch(Exception e){}
                    System.out.println("Waiting for lock on ob2 object");
                    synchronized(ob2){
                        System.out.println("Locked on ob2 object");
                    }
                }
            }
        };
        Thread t2=new Thread(){
            public void run(){
                synchronized(ob2){
                    System.out.println("Locked on ob2 object");
                    try{
                        Thread.sleep(100);
                    }
                    catch(Exception e){}
                    System.out.println("Waiting for lock on ob1 object");
                    synchronized(ob1){
                        System.out.println("Locked on ob1 object");
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
