import java.util.*;
public class DFS{

    Vertex[] vertices;
    int[][] matrix;
    Stack<Integer> s;
    int curr;
    int max;
    DFS(int max){
        this.max=max;
        s=new Stack<>();
        vertices=new Vertex[max];
        matrix=new int[max][max];
    }
    void addVertex(char lable){
        vertices[curr++]=new Vertex(lable);
    }
    void addEdge(int src,int dest){
        matrix[src][dest]=1;
        matrix[src][dest]=1;
    }
    void display(int v){
        System.out.print(vertices[v].lable);
    }

    void dfs(){
        vertices[0].isVisited=true;
        System.out.println("Started from : ");
        display(0);
        System.out.println();
        s.push(0);
        while(!s.isEmpty()){
            int v1=getUnvisitedNode(s.peek());
            if(v1!=-1 ){
                vertices[v1].isVisited=true;
                display(s.peek());
                display(v1);
                System.out.println(" ");
                s.push(v1);
            }
            else{
                s.pop();
            }
        }
    }
    int getUnvisitedNode(int v){
        for(int i=0;i<vertices.length;i++){
            if(matrix[v][i]==1 && !vertices[i].isVisited)
                return i;
        }
        return -1;
    }
    public static void main(String[] args){
            DFS theGraph = new DFS(5);
            theGraph.addVertex('A'); // 0 (start for mst)
            theGraph.addVertex('B'); // 1
            theGraph.addVertex('C'); // 2
            theGraph.addVertex('D'); // 3
            theGraph.addVertex('E'); // 4


            theGraph.addEdge(0, 1); // AB
            theGraph.addEdge(0, 2); // AC
            theGraph.addEdge(0, 3); // AD
            theGraph.addEdge(0, 4); // AE
            theGraph.addEdge(1, 2); // BC
            theGraph.addEdge(1, 3); // BD
            theGraph.addEdge(1, 4); // BE
            theGraph.addEdge(2, 3); // CD
            theGraph.addEdge(2, 4); // CE
            theGraph.addEdge(3, 4); // DE
            System.out.print("Minimum spanning tree: ");
            theGraph.dfs(); // minimum spanning tree
            System.out.println();
    }
    class Vertex{
        char lable;
        boolean isVisited;
        Vertex(char lable){
            this.lable=lable;
        }
    }
}
