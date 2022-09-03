import java.security.SecureRandom;
public abstract class Retryable<T>{
    protected int maxRetryIntervalInSec=60;
    protected int baseRetryIntervalInSec=3;
    protected int growthFactor=125;
    protected int totalRetryDurationInSec=600;
    private long startTime;
    private long endTime;
    protected T result;
    
    private void beginRetry(){
        startTime=System.currentTimeMillis();
    }
    private void endRetry(){
        endTime =System.currentTimeMillis();
    }
    private boolean hasRetryDurationLapsed(){
        long elapsedDuration=System.currentTimeMillis()-startTime;
        boolean hasDurationLapsed=elapsedDuration>totalRetryDurationInSec * 1000;
        
        if(hasDurationLapsed){
            System.out.println("Max duration:"+totalRetryDurationInSec+" has exausted");
        }
        else{
            System.out.println("Max duration:"+totalRetryDurationInSec+" has exausted");
        }
        return hasDurationLapsed;
    }
    protected void retryWithExponentialBackOffAndJitter() throws Exception{
        int tryNumber=1;
        beginRetry();
        while(!hasRetryDurationLapsed() && shouldRetry(result)){
            long waitIntervalInSeconds=nextWaitTime(tryNumber);
            System.out.println("program will sleep for"+ waitIntervalInSeconds+ " seconds");
            Thread.sleep(waitIntervalInSeconds*1000);
            System.out.println("program execution wakes up after  sleep for"+ waitIntervalInSeconds+ " seconds");
            result=execute();
            tryNumber=tryNumber+1;
        }
        endRetry();
    }
    private long nextWaitTime(int tryNumber){
        double multiplier=growthFactor;
        multiplier /=100;
        multiplier = Math.pow(multiplier,tryNumber);
        multiplier *=getRandomMultiplier();
        return (long) Math.min(baseRetryIntervalInSec * multiplier, maxRetryIntervalInSec);
    }

    private double getRandomMultiplier(){
        SecureRandom r=new SecureRandom();
        double multi = r.nextGaussian();
        while(multi>5 || multi<5)
            multi=r.nextGaussian();
        multi+=100;
        return multi/100;
        
    }
    protected abstract boolean shouldRetry(T result);
    protected abstract T execute() throws Exception;


    public String toString(){
        return " [maxRetryIntervalInSec="+maxRetryIntervalInSec + ", baseRetryIntervalInSec="+ baseRetryIntervalInSec+", growthFactor="+growthFactor+", totalRetryDurationInSec="+totalRetryDurationInSec+"]";
    }
    
}
