package algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.edgeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author Tzion
 *
 */
public class Graph_Algo implements graph_algorithms{

	/**
	 * this method Initializing graphAlgo from graph type DGraph 
	 */
	@Override
	public void init(graph g) {
		this.grafAlgo=g;
	}

	/**
	 * this method Initializing graphAlgo from csv file that holding a graph type DGraph
	 */
	@Override
	public void init(String file_name) {
		graph graphHelp=new DGraph(); 
		String line = "";
		String cvsSplitBy = ",";
		try 
		{
			int i=0;
			BufferedReader brGraph = new BufferedReader(new FileReader(file_name));
			while ((line = brGraph.readLine()) != null) 
			{
				if(i!=0) {
					String[] edgesVertesis = line.split(cvsSplitBy);
					int src=Integer.parseInt(edgesVertesis[0]);
					int dest=Integer.parseInt(edgesVertesis[1]);
					int weigth=Integer.parseInt(edgesVertesis[2]);
					//read the src to 0 place at the array, and the dest to 1 place 
					//of the array and the weigth at the place 2 of the array
					node_data addSrc=new NodeData(src);
					graphHelp.addNode(addSrc);
					node_data addDest=new NodeData(dest);
					graphHelp.addNode(addDest);					
					graphHelp.connect(src, dest, weigth);

				}
				else if(i==0) {
					//don't want to read the first line of the explanation of every thing 
					//at the file
					line = "";
					i++;
				}
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("could not read file");
		}
		init(graphHelp);
	}

	@Override
	public void save(String file_name) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double shortestPathDist(int src, int dest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * this method create a deep copy of the graphAlgo
	 */
	@Override
	public graph copy() {
		DGraph graphToCopy=new DGraph(); 
		Collection<node_data> vertices= this.grafAlgo.getV();
		Iterator<node_data> vert=vertices.iterator();
		while(vert.hasNext()) {
			//1. create a vertex 
			node_data tempVertex=new NodeData(vert.next().getKey());
			graphToCopy.addNode(tempVertex);
			//2. create the all edgaes for that specific vertex
			Collection<edge_data> edgesOfNode= this.grafAlgo.getE(vert.next().getKey());
			Iterator<edge_data> edge=edgesOfNode.iterator();
			while(edge.hasNext()) {
				graphToCopy.connect(edge.next().getSrc(), edge.next().getDest()
						, edge.next().getWeight());
			}//end creating the edges
		}
		return null;
	}

	//****************** My methods *****************
	/**
	 * this method checking if two nodes are equal
	 */
	@Override
	public boolean equals(Object obj) {
		boolean flag=true;
		if(obj!=null&&(obj instanceof graph_algorithms)){
			graph n=(DGraph) obj;
			if(!this.grafAlgo.getV().equals(n.getV()))
			{
				flag=false;
				return flag;
			}
			else {
				
				
			}
		}
		return flag;
	}//end equal
	
	//****************** Private Methods and Data *****************
	private graph grafAlgo; 

	public Graph_Algo() {
		this.grafAlgo=new DGraph();
	}
}
