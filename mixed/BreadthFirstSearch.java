import java.util.*;
public class BreadthFirstSearch{
    private final int maxCount=20;
    private int[][] adjMatrix;
    private Vertex[] vertices;
    private Queue<Integer> queue;
    private int vertexCount;

    public BreadthFirstSearch(){
        this.adjMatrix=new int[maxCount][maxCount];
        this.vertices=new Vertex[maxCount];
        queue=new LinkedList<>();
    }
    
    public void addVertex(char label){
        vertices[vertexCount++]=new Vertex(label);
    }

    public void addEdge(int source,int dest){
        adjMatrix[source][dest]=1;
        adjMatrix[dest][source]=1;
    }
    public void displayVertex(int index){
        System.out.println(vertices[index].label+",");
    }
    public void bfs(int src){
        vertices[src].isVisited=true;
        displayVertex(src);
        queue.offer(src);
        int v1;
        while(!queue.isEmpty()){
            int v2=queue.remove();
            while( (v1=getUnvisitedNode(v2)) != -1 ){
                vertices[v1].isVisited=true;
                displayVertex(v1);
                queue.offer(v1);
            }
        }
    }
    int getUnvisitedNode(int v){
        for(int i=0;i<vertexCount;i++){
            if(adjMatrix[v][i]==1 && vertices[i].isVisited==false)
                return i;
        }
        return -1;

    }
    public static void main(String[] args) {

        BreadthFirstSearch bfs= new BreadthFirstSearch();
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

        bfs.bfs(3);
    }

    class Vertex{
        char label;
        boolean isVisited;
        public Vertex(char label){
            this.label=label;
        }
    }
}
