import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DAGShortestPath {

	public static boolean[] visited;
	public static int noOfVertices,noOfEdges;
	public static Graph graph=null;
	public static Queue<Integer> VertexWithoutIncoming=new LinkedList<Integer>();
	public static ArrayList<Integer> topologicalOrder=new ArrayList<Integer>();
	public int[] inEdgesCount=null;

	public static int[] d;
	public final static int INFINITY=Integer.MAX_VALUE;

	public static void main(String[] args) {

		DAGShortestPath dagShortestPath=new DAGShortestPath();
		dagShortestPath.findShortestPath();
	}


	public void constructGraph()
	{
		int u, v, w;
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNext())
		{
			noOfVertices=scanner.nextInt();
			noOfEdges=scanner.nextInt();

			d=new int[noOfVertices+1];

			graph=new Graph(noOfVertices);
			for(int i=0;i<noOfEdges;i++)
			{
				u=scanner.nextInt();
				v=scanner.nextInt();
				w=scanner.nextInt();
				graph.addEdge(u, v, w);
			}
			break;
		}
		//graph.printGraph();
	}

	/**
	 * Initialize a single source graph
	 * INITIALIZE-SINGLE-SOURCE(G, s)
		for each vertex v in V [G]
			do d[v] <- Infinity
			¹[v] <- NIL
		d[s] <- 0
	 * 
	 */
	public void initializeSingleSource()
	{
		//Initialize source distance as zero
		d[1]=0; 

		//Initialize all vertices distance as infinity
		for(int i=2;i<=noOfVertices;i++)
		{
			d[i]=INFINITY;
		}		
	}

	/**
	 * Method to relax an edge
	 * 
	 * RELAX(u, v, w)
			if d[v] > d[u] +w(u, v)
				then d[v] <- d[u] +w(u, v)
					¹[v] <- u
	 * 
	 * @param u
	 * @param v
	 * @param w
	 */
	public void doRelax(int u, int v, int w)
	{
		if(d[v]>d[u]+w)
			d[v]=d[u]+w;
	}


	/**
	 * 
	 * DAG-SHORTEST-PATHS(G, w, s)
      topologically sort the vertices of G
      INITIALIZE-SINGLE-SOURCE(G, s)
      for each vertex u taken in the topological sorted order
         do for each vertex v in Adj[u]
            do RELAX(u, v, w)
	 * 
	 */
	public void findDAGShortestPath()
	{
		initializeSingleSource();
		doTopologicalSorting();
		for(int n: topologicalOrder)
		{
			ArrayList<Edge> outedges=graph.getOutEdges(n);
			for(Edge e : outedges)
			{
				doRelax(e.u, e.v, e.w);
			}
		}
	}


	public void findVerticesWithOutIncomingEdge()
	{
		inEdgesCount=graph.getInEdgesCount();
		for(int i=1;i<=noOfVertices;i++)
		{
			if(inEdgesCount[i]==0)
			{
				VertexWithoutIncoming.add(i);
				d[i]=0;//Additionally for DAG alone. If DAg has multiple sources(More than one edge has no incoming edges)
			}
		}

	}

	/**
	 * 
	 * 
	 * 
	 * L <- Empty list that will contain the sorted elements
	   S <- Set of all nodes with no incoming edges
		while S is non-empty do
    		remove a node n from S
    		add n to tail of L
    		for each node m with an edge e from n to m do
        		remove edge e from the graph
        		if m has no other incoming edges then
            	insert m into S
	   if graph has edges then
    		return error (graph has at least one cycle)
	   else 
    		return L (a topologically sorted order)
	 * 
	 */
	public void doTopologicalSorting()
	{
		topologicalOrder=new ArrayList<Integer>();
		findVerticesWithOutIncomingEdge();

		while(!VertexWithoutIncoming.isEmpty())
		{
			int n=VertexWithoutIncoming.poll();
			topologicalOrder.add(n);
			ArrayList<Edge> outEdges=graph.getOutEdges(n);
			for(Edge e : outEdges)
			{
				inEdgesCount[e.v]--;
				if(inEdgesCount[e.v]==0)
					VertexWithoutIncoming.add(e.v);
			}

		}

	}


	/**
	 * To construct the graph and find the shortest path
	 * 
	 */
	public void findShortestPath()
	{
		constructGraph();
		findDAGShortestPath();

		for(int i=1;i<=noOfVertices;i++)
		{
			System.out.println("Distance for "+i+" is "+d[i] );
		}
	}



}