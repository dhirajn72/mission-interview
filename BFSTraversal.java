import java.util.*;
public class BFSTraversal{
    
    int maxCount=6;
    int[][] matrix;
    Vertex[] vertices;
    Queue<Integer> queue;
    int count;
    BFSTraversal(){
        this.matrix=new int[maxCount][maxCount];
        vertices=new Vertex[maxCount];
        queue=new LinkedList<>();
    }
    void addVertex(char label){
        vertices[count++]=new Vertex(label);
    }

    void addEdge(int src,int dest){
        matrix[src][dest]=1;
        matrix[dest][src]=1;
    }
    void display(int v){
        System.out.println(vertices[v].label);
    }
    void bfs(){
        vertices[0].isVisited=true;
        display(0);
        queue.offer(0);
        int v1;
        while(!queue.isEmpty()){
            int v2=queue.remove();
            while( (v1=getUnvisitedNode(v2))!=-1 ){
                vertices[v1].isVisited=true;
                display(v1);
                queue.offer(v1);
            }
        }
    }

    int getUnvisitedNode(int v){
        for(int i=0;i<maxCount;i++){
            if(matrix[v][i]==1 && !vertices[i].isVisited)
                return i;
        }
        return -1;  
    }

    public static void main(String[] args){
        BFSTraversal bfs= new BFSTraversal();
        bfs.addVertex('A');
        bfs.addVertex('B');
        bfs.addVertex('C');
        bfs.addVertex('D');
        bfs.addVertex('E');

        bfs.addEdge(0,1);
        bfs.addEdge(1,2);
        bfs.addEdge(2,3);
        bfs.addEdge(3,4);
        bfs.addEdge(0,4);
        bfs.addEdge(0,3);

        bfs.bfs();

    }
    

    class Vertex{
        char label;
        boolean isVisited;
        Vertex(char label){
            this.label=label;
        }
    }
}
