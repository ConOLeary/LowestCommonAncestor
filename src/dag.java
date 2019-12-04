import java.util.ArrayList;
import java.util.List;

public class dag {
	
//	public static class dagVert {
//
//		public int data;
//		
//	    public dagVert(int nodeData) {
//	        data = nodeData;
//	    }
//	}
	public static class dagEdge {

		
		public int u;
		public int v;
		
		public dagEdge(int u, int v)
		{
			this.u=u;
			this.v=v;
		}
		
	}
	public static class Graph {
		public ArrayList<dagEdge>[] adjacencyList=null;
		public int[] inEdgeCount=null;
		public int noOfVerts;
		@SuppressWarnings("unchecked")
		public Graph(int noOfVerts)
		{
			adjacencyList=(ArrayList<dagEdge>[])new ArrayList[noOfVerts+1];
			//TO initialize with empty arrayList
			for(int i=1;i<=noOfVerts;i++)
			{
				adjacencyList[i]=new ArrayList<dagEdge>();
			}
			inEdgeCount=new int[noOfVerts+1];
			this.noOfVerts=noOfVerts;
		}
//		public boolean noCircuits()
//		{
//			return circuitChecker(1);
//		}
//		private boolean circuitChecker(int currentVert)
//		{
//			for(int i = 0; i < adjacencyList[currentVert].size(); i++)
//			{
//				int travelTo = adjacencyList[currentVert].get(i).v;
//				if(travelTo == 1)
//					return false;
//				circuitChecker(travelTo);
//			}
//			return true;
//		}
		
		public boolean hasCircuit()
		{
			List<Integer> newVisits = new ArrayList<Integer>();
			List<Integer> oldNewVisits = new ArrayList<Integer>();
			List<Integer> hasBeenVisited = new ArrayList<Integer>();
			//shouldnt necessarily start from 1, as 1 could be an island
			for(int currentVertPerspective = 1; currentVertPerspective <= noOfVerts; currentVertPerspective++)
			{
				newVisits.clear();
				oldNewVisits.clear();
				hasBeenVisited.clear();
				newVisits.add(currentVertPerspective);
				for(int i = 0; i < noOfVerts; i++)
				{
					hasBeenVisited.addAll(newVisits);
					for(int n = 0; n < newVisits.size(); n++)
					{
						oldNewVisits.add(newVisits.get(n));
					}
					newVisits.clear();
					for(int j = 0; j < oldNewVisits.size(); j++)
					{
						for(int k = 0; k < adjacencyList[oldNewVisits.get(j)].size(); k++)
						{
							System.out.print(adjacencyList[oldNewVisits.get(j)].get(k).v);
							int newVert = adjacencyList[oldNewVisits.get(j)].get(k).v;
							if(hasBeenVisited.contains(newVert))
								return true;
							newVisits.add(newVert);
						}
					}
					oldNewVisits.clear();
				}
			}
			return false;
		}
		
		public void addEdge(int u, int v)
		{
			if(adjacencyList[u]==null)
				adjacencyList[u]=new ArrayList<dagEdge>();
			adjacencyList[u].add(new dagEdge(u, v));
		}
		public void removeEdge(int u, int v)
		{
			int indexToBeRemoved=-1;
			ArrayList<dagEdge> edgeList=adjacencyList[u];
			for(int i=0;i<adjacencyList[u].size();i++)
			{
				dagEdge e=edgeList.get(i);
				if(e.u==u&&e.v==v)
				{
					indexToBeRemoved=i;
				}
			}
			if(indexToBeRemoved!=-1)
				edgeList.remove(indexToBeRemoved);
		}
		public int[] getInEdgesCount()
		{
			for(int i=1;i<=noOfVerts;i++)
			{
				for(int j=1;j<adjacencyList.length;j++)
				{
					ArrayList<dagEdge> list=adjacencyList[j];
					for(dagEdge e : list)
					{
						if(e.v==i)
							inEdgeCount[i]++;
					}
				}

			}
			return inEdgeCount;
		}
		public void printGraph()
		{
			ArrayList<dagEdge> edgeList;
			for(int i=1;i<noOfVerts;i++)
			{
				edgeList=adjacencyList[i];
				for(dagEdge e : edgeList)
					System.out.println("u : "+e.u+" v : "+e.v);
			}
		}
	}

}
