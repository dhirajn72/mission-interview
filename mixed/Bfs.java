

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dhiraj
 * @date 09/07/19
 */
public class Bfs {
    private final int maxCount=20;
    private int[][] adjMatrix;
    private Vertex[] vertices;
    private Queue<Integer> queue;
    private int vertexCount;

    public Bfs() {
        this.adjMatrix = new int[maxCount][maxCount];
        this.vertices = new Vertex[maxCount];
        queue=new LinkedList<>();
    }

    public void addVertex(char lable){
        vertices[vertexCount++]=new Vertex(lable);
    }
    public void addEdge(int source,int dest){
        adjMatrix[source][dest]=1;
        adjMatrix[dest][source]=1;
    }

    public void displayVertex(int index){
        System.out.print(vertices[index].label+",");
    }

    public void bfs(){
        vertices[0].visited=true;
        displayVertex(0);
        queue.offer(0);
        int v1;
        while (!queue.isEmpty()){
            int v2=queue.remove();
            while ((v1=getUnvisitedNode(v2))!=-1){
                vertices[v1].visited=true;
                displayVertex(v1);
                queue.offer(v1);
            }
        }

        for (int i=0;i<vertexCount;i++)
            vertices[i].visited=false;
    }

    private int getUnvisitedNode(int v) {
        for (int i=0;i<vertexCount;i++){
            if (adjMatrix[v][i]==1 && vertices[i].visited==false)
                return i;
        }
        return -1;
    }


    public static void main(String[] args) {

        Bfs bfs= new Bfs();
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

/**
 * @author Dhiraj
 * @date 05/06/19
 */
class Vertex {
    public char label;
    public boolean visited;

    public Vertex(char label) {
        this.label = label;
        this.visited=false;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label=" + label +
                ", visited=" + visited +
                '}';
    }
}
   }
