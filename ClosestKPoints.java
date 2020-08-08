import java.util.List;
import java.util.PriorityQueue;

public class ClosestKPoints {
    
    public static void main(String[] args) {
        int[] arr={5,9,7,4,8,2,3,};
        PriorityQueue<Integer> queue=new PriorityQueue<>(2,(a,b)->b-a);
        for(int i:arr){
            queue.offer(i);
        }
        while(!queue.isEmpty()){
            System.out.print(queue.remove()+",");
        }
        System.out.println(); 
    }
}