package dataStructure;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class DGraph implements graph{

	/**
	 * this method returns the specific vertex by his id in O(1)
	 */
	@Override
	public node_data getNode(int key) {
		if(!this.vertesis.isEmpty()&&this.vertesis.containsKey(key))
			return this.vertesis.get(key);
		return null;
	}

	/**
	 * this method returns a specific edge with unique source and destination in O(1)
	 */
	@Override
	public edge_data getEdge(int src, int dest) {
		if(!this.edges.isEmpty()&&this.edges.containsKey(src)&&this.edges.get(src)!=null) 
			//checking if the collection of the edges is not empty,
			//if it contains  source(src)and if for that source have a destination
			//and it is not a independent vertex without edges
			if(this.edges.get(src).containsKey(dest)) 
				return this.edges.get(src).get(dest);

		return null;//if the collection is Empty or the edge is not exist
	}

	@Override
	public void addNode(node_data n) {
		modeCount++;
		this.vertesis.put(n.getKey(), n);
		HashMap<Integer, edge_data> helpEdges=new HashMap<>();
		this.edges.put(n.getKey(),helpEdges);
		//when i create a vertex i create to him a specific hashMap 
		//that will hold his edges in the future
	}

	/**
	 * this method is create a new edge between src to dest
	 */
	@Override
	public void connect(int src, int dest, double w) {
		edgeData newEdge=new edgeData(src, dest, w);
		edges.get(src).put(dest, newEdge);
	}

	/**
	 * This method return a pointer (shallow copy) for the
	 * collection representing all the nodes in the graph. 
	 */
	@Override
	public Collection<node_data> getV() {
		return vertesis.values();
	}

	/**
	 * This method return a pointer (shallow copy) for the
	 * collection representing all the edges getting out of 
	 * the given node (all the edges starting (source) at the given node). 
	 */
	@Override
	public Collection<edge_data> getE(int node_id) {
		return edges.get(node_id).values();
	}

	/**
	 * 
	 */
	@Override
	public node_data removeNode(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nodeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edgeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMC() {
		return this.modeCount;
	}

	//****************** Private Methods and Data *****************

	static int modeCount=0;//static value to count hoe many times the graph was changed
	private HashMap<Integer, node_data> vertesis;
	//the keys is the id of the vertex and the value is a specific vertex 

	private HashMap<Integer,HashMap<Integer, edge_data>> edges ;
	//the keys is the source of the edge and the key of the HashMap the represents the values is the 
	//destination of the edge

	//****************** Contractors *****************

	public void setVertesis() {
		this.vertesis=new HashMap<Integer,node_data>();
	}
	public void setEdges() {
		this.edges=new HashMap <Integer,HashMap<Integer, edge_data>>();
	}

	public DGraph() {
		setVertesis();
		setEdges();
	}
}
