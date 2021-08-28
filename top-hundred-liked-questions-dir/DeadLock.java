public class DeadLock{
    static Object ob1=new Object();
    static Object ob2=new Object();

    public static void main(String[] args){

        Thread t1=new Thread(){

            @Override
                public void run(){
                    synchronized(ob1){
                        System.out.println("Locked ob1");
                        System.out.println("Waiting for ob2");
                        try{
                            Thread.sleep(500);
                        }
                        catch(Exception e){}
                        synchronized(ob2){
                            System.out.println("Locked ob2");
                        }
                    }
                }
        }; 
        Thread t2=new Thread(){

            @Override
                public void run(){
                    synchronized(ob2){
                        System.out.println("Locked ob2");
                        System.out.println("Waiting for ob1");
                        try{
                            Thread.sleep(500);
                        }
                        catch(Exception e){}
                        synchronized(ob1){
                            System.out.println("Locked ob1");
                        }
                    }

                }
        };  
        t1.start();
        t2.start();
    }
}
