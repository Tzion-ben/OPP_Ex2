package dataStructure;
/**
 * This class implements the node_data interface on a node that represents
 * vertex
 * @author Tzion
 */

import utils.Point3D;

public class NodeData implements node_data {

	@Override
	public int getKey() {
		return this.id;
	}

	@Override
	public Point3D getLocation() {
		return this.Location;
	}

	@Override
	public void setLocation(Point3D p) {
		this.Location=p;
	}

	@Override
	public double getWeight() {
		return this.weigth;
	}

	@Override
	public void setWeight(double w) {
		this.weigth=w;
	}

	@Override
	public String getInfo() {
		return this.info;
	}

	@Override
	public void setInfo(String s) {
		this.info=s;
	}

	@Override
	public int getTag() {
		return this.tag;
	}

	@Override
	public void setTag(int t) {
		this.tag=t;
	}

	//****************** Private Methods and Data *****************
	
	private Point3D Location;
	private int id;
	private double weigth;
	private String info;
	private int tag;
	//****************** Constructors *****************
	
	public NodeData(int id) {
		this.Location=null;//the coordinate of the vertices with x,y,z 3D
		this.id=id;//the id of vertex ,i put it to -1 because id can be i to infinity 
		this.weigth=0;
		this.info=null;//for meta data in the algorithms
		this.tag=0;//to make a sign in the algorithms 
	}
}
