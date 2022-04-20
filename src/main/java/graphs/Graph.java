package graphs;

import java.util.Stack;

public class Graph {
    private Edge[] graph; // adjacency list for this graph

    // Static nested class Edge
    public static class Edge { // Class Edge
        private int neighbor; // id of the neighbor
        private Edge next; // reference to the next "edge"

        public Edge(int neighbor) {
            this.neighbor = neighbor;
            next = null;
        }
    } // class Edge

    public Graph(int numVertices) {
        graph = new Edge[numVertices];
    }

    /**
     * Adds the given edge as an outgoing edge for the given vertex.
     * Modifies the adjacency list.
     *
     * @param vertexId id of the vertex
     * @param edge     outgoing edge
     *                 Do not modify.
     */
    public void addEdge(int vertexId, Edge edge) {
        Edge head = graph[vertexId]; // head of the linked list for this  node
        graph[vertexId] = edge; // insert in front
        if (head != null) {
            edge.next = head;
        }
    }

    public int getNumVertices() {
        return graph.length;
    }

    public void printNeighbors(int vertexId) {
        Edge current = graph[vertexId];
        while (current != null) {
            System.out.println(current.neighbor);
            current = current.next;
        }
    }

    public void dfs() {
        boolean visited[]  = new boolean[graph.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                dfsHelperWithStack(i, visited);
                // dfsHelper(i, visited);
        }
    }

    public void dfsHelper(int vertex, boolean[] visited) {
        Edge tmp;
        visited[vertex] = true;
        System.out.println(vertex);
        // iterate over edges of vertex
        for (tmp = graph[vertex]; tmp!=null; tmp = tmp.next)
        {
            if (!visited[tmp.neighbor])
                dfsHelper(tmp.neighbor, visited);
        }
    }

    public void dfsHelperWithStack(int vertex, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex);

        while (!stack.isEmpty()) {
            // pop the vertex nextV from the stack
            int nextV = stack.pop();
            // mark it as visited and print it
            visited[nextV] = true;
            System.out.println(nextV);
            // iterate over the neighbors of nextV
            Edge tmp = graph[nextV];
            while (tmp != null) {
                // if the neighbor has not been visited, push it onto the stack
                if (!visited[tmp.neighbor])
                    stack.push(tmp.neighbor);
                tmp = tmp.next;
            }

        }
    }

    public void printAdjacencyList() {
        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + ": ");
            Edge head = graph[i];
            while (head != null) {
                System.out.print(head.neighbor + " ");
                head = head.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(8);

        // edges going out of vertex 1
        Edge edge10 = new Edge(0);
        Edge edge12 = new Edge(2);
        g.addEdge(1, edge10);
        g.addEdge(1, edge12);

        // edge going out of 0
        Edge edge05 = new Edge(5);
        g.addEdge(0, edge05);

        //edge going out of 2
        Edge edge26 = new Edge(6);
        g.addEdge(2, edge26);

        // edges going out of 5
        Edge edge54 = new Edge(4);
        Edge edge56 = new Edge(6);
        g.addEdge(5, edge54);
        g.addEdge(5, edge56);

        // edge going out of 6
        Edge edge67 = new Edge(7);
        g.addEdge(6, edge67);

        //edge going out of 4
        Edge edge47 = new Edge(7);
        g.addEdge(4, edge47);

        // edge going out of 7
        Edge edge75 = new Edge(5);
        g.addEdge(7, edge75);

        // g.printAdjacencyList();
        g.dfs();
    }
}