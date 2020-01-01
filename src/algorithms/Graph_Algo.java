package algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.management.StringValueExp;

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
		this.grafAlgo= g;
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
	/**
	 * this method is checking if the directional graph is connect or not by
	 * the method of DFS traversal on the graph recursivly
	 */
	@Override
	public boolean isConnected() {
		zeroAllTags();
		Collection<node_data> vertices= this.grafAlgo.getV();
		Iterator<node_data> vert=vertices.iterator();
		//while(vert.hasNext()) {
		if(vert.hasNext()) {
			node_data tempVertex=new NodeData(vert.next().getKey());			
			DFSRec(tempVertex,this.grafAlgo);	
		}

		Iterator<node_data> vertSec=vertices.iterator();
		while(vertSec.hasNext()) {
			if(vertSec.next().getTag()==0) 
				return false;
		}

		graph transpoGraph=transpozeGraph();
		Collection<node_data> verticesT= transpoGraph.getV();
		Iterator<node_data> vertT=verticesT.iterator();
		//while(vertT.hasNext()) {
		if(vertT.hasNext()) {
			node_data tempVertexT=new NodeData(vertT.next().getKey());			
			DFSRec(tempVertexT ,transpoGraph);	
		}
		Iterator<node_data> vertSecT=verticesT.iterator();
		while(vertSecT.hasNext()) {
			if(vertSecT.next().getTag()==0) 
				return false;
		}
		return true;
	}//end of isConnected

	/**
	 * 
	 */
	@Override
	public double shortestPathDist(int src, int dest) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		boolean flag=isConnected();
		if (!flag)
			return null;
		//if the graph is not a strongly connected then we return null

		zeroAllTags();
		infinityAllWeight();
		setsAllInfo();
		if(this.grafAlgo.getNode(src)!=null) {
			//thet if is checking if the hashMap of the vertices is not empty and
			//contains the vertex with the id of src 
			this.grafAlgo.getNode(src).setWeight(0);
			DFSRecForWeight(this.grafAlgo.getNode(src),dest,this.grafAlgo);

			List<node_data> shPathVerts=new ArrayList<node_data>();
			//Collection<node_data> vertices1= this.grafAlgo.getV();
			//Iterator<node_data> vertEnd=vertices1.iterator();
			String thePath=this.grafAlgo.getNode(dest).getInfo();
			String [] vertesisToPath=thePath.split(",");
			for(int i=0;i<vertesisToPath.length;i++) {
				shPathVerts.add(this.grafAlgo.getNode(Integer.parseInt(vertesisToPath[i])));
			}
			return shPathVerts;
		}
		//if the pay is not exisest so returns null
		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * this method create a deep copy of the graph
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
			Collection<edge_data> edgesOfNode= this.grafAlgo.getE(tempVertex.getKey());
			Iterator<edge_data> edge=edgesOfNode.iterator();
			while(edge.hasNext()) {
				edge_data tempEdge=edge.next();
				graphToCopy.connect(tempEdge.getSrc(), tempEdge.getDest()
						, tempEdge.getWeight());
			}//end creating the edges
		}
		return graphToCopy;
	}
	//****************** My methods *****************

	/**
	 * this private methos is run on every neighbors of the node by the dest id of all the edges of the 
	 * specific node, and tag all the neighbors with '1' that mean this node was visited
	 * so at the end if all the nodes tags will be 1 the graph is strongly connected  
	 * tag==0 :NOT VISETED ,tag==1 :VISETED
	 * @param ver
	 */
	private void DFSRec(node_data vert , graph g) {
		vert.setTag(1);
		Collection<edge_data> edgesOfVert= g.getE(vert.getKey());
		Iterator<edge_data> edge=edgesOfVert.iterator();
		while(edge.hasNext()) {
			node_data tempVert=g.getNode(edge.next().getDest());
			//the next node to check is the vertex that is near we know it by the DEST
			if(tempVert.getTag()==0)
				DFSRec(tempVert,g);
		}
	}//end DFSRec

	/**
	 * this private method return the transpose graph the this graph
	 * @return
	 */
	private graph transpozeGraph () {
		graph grafAlgoT=new DGraph();
		Collection<node_data> vertices= this.grafAlgo.getV();
		Iterator<node_data> vert=vertices.iterator();
		while(vert.hasNext()) {
			node_data tempVertex=new NodeData(vert.next().getKey());
			tempVertex.setTag(0);//sets all the tags to 0 so can run again on the transpose graph
			grafAlgoT.addNode(tempVertex);	
		}	//create the Vertex, for dint stop at NULLPOINTEREXPTION with the oppisid srd and dest

		Iterator<node_data> vert1=vertices.iterator();
		while(vert1.hasNext()) {
			node_data tempVertex=new NodeData(vert1.next().getKey());
			//create the edges of the every vertex
			Collection<edge_data> edgesOfVert= this.grafAlgo.getE(tempVertex.getKey());
			Iterator<edge_data> edge=edgesOfVert.iterator();
			while(edge.hasNext()) {
				edge_data tempEdge=edge.next();
				grafAlgoT.connect(tempEdge.getDest(),tempEdge.getSrc(), tempEdge.getWeight());			
			}		
		}//create all the transpose graph
		return grafAlgoT;
	} 

	/**
	 * this private method sets all the w at the graph to zero 
	 * before started to check at the method isConnectd
	 */
	private void zeroAllTags() {
		Collection<node_data> vertices= this.grafAlgo.getV();
		Iterator<node_data> vert=vertices.iterator();
		while(vert.hasNext()) 
			vert.next().setTag(0);
	}

	/**
	 * this private method sets all the Weight at the graph to infinity 
	 * before started to check at the method the shortest path
	 */
	private void infinityAllWeight() {
		Collection<node_data> vertices= this.grafAlgo.getV();
		Iterator<node_data> vert=vertices.iterator();
		while(vert.hasNext()) 
			vert.next().setWeight(Double.MAX_VALUE);;
	}

	/**
	 * this private method sets all the info at the graph vertesis to the strinng
	 * with the number of the node id ofr helf find the path at the method shortest

	 */
	private void setsAllInfo() {
		String s="";
		Collection<node_data> vertices= this.grafAlgo.getV();
		Iterator<node_data> vert=vertices.iterator();
		while(vert.hasNext()) {
			node_data tempVert=vert.next();
			tempVert.setInfo(String.valueOf(tempVert.getKey()));
		}
	}

	/**
	 * this private methos is run on every neighbors of the node by the dest id of all the edges of the 
	 * specific node, 
	 * 
	 * 
	 * tag==0 :NOT VISETED ,tag==1 :VISETED
	 * @param ver
	 */
	private void DFSRecForWeight(node_data vert ,int dest, graph g) {
		vert.setTag(1);
		int minNodeIdW=Integer.MAX_VALUE;
		double minNodeWeight=Double.MAX_VALUE;
		Collection<edge_data> edgesOfVert= g.getE(vert.getKey());
		Iterator<edge_data> edge=edgesOfVert.iterator();
		while(edge.hasNext()) {
			edge_data tempEdge=edge.next();
			node_data neighborVert=g.getNode(tempEdge.getDest());
			if((neighborVert.getTag()!=1)&&(vert.getWeight()+tempEdge.getWeight()<neighborVert.getWeight())) {
				neighborVert.setWeight(vert.getWeight()+tempEdge.getWeight());
				neighborVert.setTag(1);
				if(neighborVert.getWeight()<minNodeWeight) { 
					minNodeWeight=neighborVert.getWeight();
					minNodeIdW=neighborVert.getKey();
					neighborVert.setInfo(vert.getInfo()+","+neighborVert.getInfo());
				}
			}
		}
		if(minNodeIdW!=Integer.MAX_VALUE && minNodeIdW!=dest)
			DFSRecForWeight(this.grafAlgo.getNode(minNodeIdW),dest,this.grafAlgo);
		else
			return;

	}//end DFSRec

	//****************** Private Methods and Data *****************
	private graph grafAlgo; 
	//****************** Contractor *****************
	public Graph_Algo() {
		this.grafAlgo=new DGraph();
	}
}