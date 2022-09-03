
import java.util.*;
public class DFSTraversal{
    
    int maxCount=6;
    int[][] matrix;
    Vertex[] vertices;
    Stack<Integer> stack;
    int count;
    DFSTraversal(){
        this.matrix=new int[maxCount][maxCount];
        vertices=new Vertex[maxCount];
        stack=new Stack<>();
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
    void dfs(){
        vertices[0].isVisited=true;
        display(0);
        stack.push(0);
        int v1;
        while(!stack.isEmpty()){
            int v2=stack.peek();
            if( (v1=getUnvisitedNode(v2)) != -1 ){
                vertices[v1].isVisited=true;
                display(v1);
                stack.push(v1);
            }
            else{
                stack.pop();
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
        DFSTraversal dfs= new DFSTraversal();
        dfs.addVertex('A');
        dfs.addVertex('B');
        dfs.addVertex('C');
        dfs.addVertex('D');
        dfs.addVertex('E');

        dfs.addEdge(0,1);
        dfs.addEdge(1,2);
        dfs.addEdge(2,3);
        dfs.addEdge(3,4);
        //bfs.addEdge(0,4);
       // bfs.addEdge(0,3);

        dfs.dfs();

    }
    

    class Vertex{
        char label;
        boolean isVisited;
        Vertex(char label){
            this.label=label;
        }
    }
}
