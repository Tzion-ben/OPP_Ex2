package dataStructure;

import utils.Point3D;

public class edgeData implements edge_data {

	@Override
	public int getSrc() {
		return this.src;
	}

	@Override
	public int getDest() {
		return this.dest;
	}

	@Override
	public double getWeight() {
		return this.weigth;
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

	private int src;
	private int dest;
	private double weigth;
	private String info;
	private int tag;
	//****************** Constructors *****************

	/*public NodeData(Point3D Location,int id,double Weigth,String info,int tag) {
			this.Location=Location;
			this.id=id;
			this.Weigth=Weigth;
			this.info=info;
			this.tag=tag;*/

	public edgeData() {
		this.src=0-1;//the start of edge
		this.dest=-1;//the end of the edge
		this.weigth=0;//the weight
		this.info=null;//meta data
		this.tag=0;//to make a sign in the algorithms 

	}

}
