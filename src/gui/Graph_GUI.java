package gui;
/**
 * This class makring a GUI of graph and make algorithms on this graph
 * 
 * @author tzion
 */


import java.util.Collection;
import java.util.Iterator;

import algorithms.Graph_Algo;
import dataStructure.*;
import utils.*;

public class Graph_GUI {

	/**
	 * this method initials a graph algo from regular DGraph
	 * @param g
	 */
	public void initToAlgoGraph(graph g) {
		Graph_Algo gAlgo=new Graph_Algo(g);
	}
	/**
	 * 
	 * @param g
	 * @return
	 */
	public boolean drawGraph(graph g) {
		boolean flag=false;
		if(g!=null) {
			setCanvas(g);
			Collection<node_data> vertices= g.getV();
			Iterator<node_data> vert=vertices.iterator();
			while(vert.hasNext()) {

			}



			initToAlgoGraph(g);
			return true;
		}
		return flag;
	}

	/**
	 * this method set the canvas depend on the locations of the most right verts and most
	 * left vertex
	 */
	public void setCanvas(graph g) {
		Collection<node_data> vertices= g.getV();
		Iterator<node_data> vert=vertices.iterator();
		double xPos=-1;
		double yPos=-1;
		while(vert.hasNext()) {
			
		}
		StdDraw.setCanvasSize((int)xPos, (int)yPos);;
	}

	public void drawNode() {

	}
}
