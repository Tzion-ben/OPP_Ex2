package dataStructure;
/**
 * 
 * @author Tzion
 */
import java.util.Collection;
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
		modeCount++;
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
	 * this method removes all the edges the goes from the vertex in O(1)
	 * and then runs in O(n) on the all other vertices and remove all the 
	 * edges from all the vertices that there destination is the vertex that
	 * the method will remove
	 * @return the data of the removed node (null if none). 
	 * @param key 
	 */
	@Override
	public node_data removeNode(int key) {
		if(this.vertesis.containsKey(key)) {//iff a such vertex is exists remove it
			modeCount++;
			this.edges.remove(key);//removing all the edges that goes from the
			//specific vertex
			int edgesSize=edges.size();
			for(int i=0;i<edgesSize;i++) {//O(n), |v|=n
				if(i!=key)
					if(edges.get(i).containsKey(key)) {
						edges.get(i).remove(key);
					}
			}

			node_data removeNode=new NodeData(key);
			//save all the data of the removed vertex in new vertex to return
			removeNode.setLocation(this.vertesis.get(key).getLocation());
			removeNode.setWeight(this.vertesis.get(key).getWeight());
			removeNode.setInfo(this.vertesis.get(key).getInfo());
			removeNode.setTag(this.vertesis.get(key).getTag());
			this.vertesis.remove(key);//remove the vertex
			return removeNode;
		}
		//else: iff such vertex is NOT exists, return null
		return null;
	}

	/**
	 * this method will remove the edge iff it exists and return it's data,
	 * if not, it will return null 
	 */
	@Override
	public edge_data removeEdge(int src, int dest) {
		if(edges.get(src).containsKey(dest)) {//iff a such edge is exists remove it
			modeCount++;
			edge_data removeEdge=new edgeData(src, dest, edges.get(src).get(dest).getWeight());
			//save all the data of the removed edge in new edge to return
			removeEdge.setInfo(edges.get(src).get(dest).getInfo());
			removeEdge.setTag(edges.get(src).get(dest).getTag());
			edges.get(src).remove(dest);
			return removeEdge;
		}
		//else: iff such edge is NOT exists, return null
		return null;
	}
	
	/**
	 * this method returns the number of the vertices in the graph
	 */
	@Override
	public int nodeSize() {
		return vertesis.size();
	}
	
	/**
	 * this method returns the number of the edges in the directional graph
	 */
	@Override
	public int edgeSize() {
		return edges.size();
	}
	
	/**
	 * this method return the number of changes at the graph
	 */
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
