import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.*;

public class Random_Graph {
    private Map<Integer,List<Integer>>adjacencyList;

    public Random_Graph(int v){
        adjacencyList= new HashMap<Integer,List<Integer>>();
        for (int i = 1; i <= v; i++)
            adjacencyList.put(i, new LinkedList<Integer>());
    }

    public void setEdge(int to, int from){
        if(to>adjacencyList.size()|| from >adjacencyList.size())
            System.out.println("Non existent vertices");

        List<Integer>sls = adjacencyList.get(to);
        sls.add(from);
        List<Integer>dls = adjacencyList.get(from);
        dls.add(to);
    }

    public List<Integer>getEdge(int to){
        if(to>adjacencyList.size()){
            System.out.println("Non existent vertices");
            return null;
        }
        return adjacencyList.get(to);

    }

    public static void main(String args[]){
        System.out.println("Enter number of edges: ");

        Scanner input = new Scanner(System.in);
        int e = input.nextInt();
        try{
            int minV = (int)Math.ceil((1+Math.sqrt(1+8*e))/2);
            int maxV = e+1;

            Random random = new Random();
            int v = Math.abs(random.nextInt(maxV-minV)+minV);
            System.out.println("Graph has "+v+" vertices.");

            Random_Graph reg = new Random_Graph(v);
            int count = 1, to,from;
            while(count<=e){
                to = Math.abs(random.nextInt(v+1-1)+1);
                from = Math.abs(random.nextInt(v+1-1)+1);

                reg.setEdge(to,from);
                count++;
            }

            System.out.println("Adjacency List of graph is: ");
            for (int i=1;i<=v;i++){
                System.out.print(i+"->");
                List<Integer>edgeList = reg.getEdge(i);

                if(edgeList.size() == 0)
                        System.out.println("Null");
                else{
                    for (int j = 1;;j++){
                        if(j!=edgeList.size())
                            System.out.println(edgeList.get(j-1)+"->");
                        else{
                            System.out.print(edgeList.get(j-1));

                            break;
                        }
                    }
                }

              System.out.println();

            }

        }
        catch(Exception E){
            System.out.println("Error");
        }
        input.close();
    }

    void BFS(int s){
        boolean visited[] = new boolean [V];
        LinkedList<Integer>queue = new LinkedList<Integer>();

        visited[s]= true;
        queue.add(s);
        while(queue.size()!=0){
            s= queue.poll();
            System.out.print(s+" ");
            Iterator<Integer>i=adj[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
    }
    void Graph
        ::DFSUtil(int v, boolean visited[]){
        visited[v]=true;
        System.out.println(v);
        list<int>::iterator i;
        for (i = adj[v].begin();i!=adj[v].end()++i)
            if(!visited[*i])
                DFSUtil(*i,visited);
    }
    void Graph::DFS(int v){
        boolean visited = new boolean[V];
        for(int i = 0; i<V;i++)
            visited[i]= false;
        DFSUtil(v,visited);

    }

    class ShortPath
    {
        static final int V = 9;
        int minDistance(int dist[],Boolean sptSet[])
        {int min = Integer.MIN_VALUE, min_index = -1;
        for(int v = 0; v<V;v++)
            if(sptSet[v] == false&&dist[v]<=min)
            {
                min = dist[v];
                min_index = v;
            }
        return min_index;

        }
        void printSolution(int dist[], int n)
        {
            System.out.println("Vertex distance from source");
            for(int i = 0;i<V;i++)
                System.out.println(i+"tt"+dist[i]);
        }
        void dijkstra(int graph[][],int src)
        {
            int dist[] = new int[V];
            Boolean sptSet[] = new Boolean[V];

            for(int i = 0; i<V;i++)
            {
                dist[i] = Integer.MAX_VALUE;
                sptSet[i]= false;
            }
            dist[src]= 0;
            for(int count = 0; count<V-1;count++)
            {
                int u = minDistance(dist,sptSet);

                sptSet[u] = true;

                for(int v = 0; v<V;v++)
                    if(!sptSet[v]&&graph[u][v]!=0&&dist[u]!=Integer.MAX_VALUE&&dist[u]+graph[u][v]<dist[v])
                        dist[v]= dist[u]+graph[u][v];
            }
            printSolution(dist,V);
        }
    }
}

