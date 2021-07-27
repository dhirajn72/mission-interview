
import java.util.Stack;

/**
 * @author Dhiraj
 * @date 09/07/19
 */
public class Dfs {
    private final int maxCount = 20;
    private int[][] adjMatrix;
    private Vertex[] vertices;
    private Stack<Integer> stack;
    private int vertexCount;

    public Dfs() {
        this.adjMatrix = new int[maxCount][maxCount];
        this.vertices = new Vertex[maxCount];
        stack = new Stack<>();
    }

    public static void main(String[] args) {

        Dfs dfs = new Dfs();
        dfs.addVertex('A');
        dfs.addVertex('B');
        dfs.addVertex('C');
        dfs.addVertex('D');
        dfs.addVertex('E');

        dfs.addEdge(0,1);
        dfs.addEdge(1,2);
        dfs.addEdge(2,3);
        dfs.addEdge(3,4);
        dfs.dfs();
    }

    public void addVertex(char lable) {
        vertices[vertexCount++] = new Vertex(lable);
    }

    public void addEdge(int source, int dest) {
        adjMatrix[source][dest] = 1;
        adjMatrix[dest][source] = 1;
    }

    public void displayVertex(int index) {
        System.out.print(vertices[index].label + ",");
    }

    public void dfs() {
        vertices[0].visited = true;
        displayVertex(0);
        stack.push(0);
        //Stack<Integer> topologicalorder=new Stack<>();
        while (!stack.isEmpty()) {
            int v2 = getUnvisitedNode(stack.peek());
            if (v2 == -1) {
                //topologicalorder.push(stack.pop());
                stack.pop();
            } else {
                vertices[v2].visited = true;
                displayVertex(v2);
                stack.push(v2);
            }
        }
        for (int i = 0; i < vertexCount; i++)
            vertices[i].visited = false;

        /*System.out.println();
        System.out.println("*********");
        while (!topologicalorder.isEmpty())
            System.out.print(topologicalorder.pop()+", ");
        System.out.println();
        System.out.println("************");*/
    }
    private int getUnvisitedNode(int v) {
        for (int i = 0; i < vertexCount; i++) {
            if (adjMatrix[v][i] == 1 && vertices[i].visited == false)
                return i;
        }
        return -1;
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
}}
