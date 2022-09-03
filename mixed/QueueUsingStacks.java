import java.util.*;
public class QueueUsingStacks{
    Stack<Integer> s1=new Stack<>();
    Stack<Integer> s2=new Stack<>();
    void insert(int e){
        s1.push(e);
    }
    int remove(){
        if(s1.size()==0 && s2.size()==0)
            return -1;
        if(s2.size()!=0)
            return s2.pop();
        while(!s1.isEmpty())
            s2.push(s1.pop());
        return s2.pop();
    }
    public static void main(String[] args) {
        QueueUsingStacks obj=new QueueUsingStacks();
        obj.insert(1);
        obj.insert(2);
        obj.insert(3);
        obj.insert(4);
        obj.insert(5);
        obj.insert(6);
        obj.insert(7);


        System.out.print(obj.remove());
        System.out.print(obj.remove());
        System.out.print(obj.remove());
        System.out.print(obj.remove());

    }
}
