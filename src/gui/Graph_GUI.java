package gui;
/**
 * This class makring a GUI of graph and make algorithms on this graph
 * 
 * @author tzion
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JFrame;
import algorithms.Graph_Algo;
import dataStructure.*;
import utils.*;

public class Graph_GUI 
{

	private void initGUIGraph(graph g) 
	{
		Range rx=new Range(-150, 150);
		Range ry=new Range(-150, 150);

		
		Collection<node_data> vertices= g.getV();
		Iterator<node_data> vert=vertices.iterator();
		if(vertices.size()!=0) {
			StdDraw.setCanvasSize(1000,1000);
			StdDraw.setXscale(rx.get_min(), rx.get_max());
			StdDraw.setYscale(ry.get_min(), ry.get_max());
			while(vert.hasNext()) {
				node_data tempVert=vert.next();
				drawNode(tempVert);
			}
		}
		else
			drawEmptyG();
	}

	/**
	 * this method draw a just canvas because the graph is empty
	 */
	private void drawEmptyG() {
		StdDraw.setCanvasSize(500,500);
	}


	public void drawNode(node_data n) {
		StdDraw.setPenRadius(0.01);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.setFont(new Font("TimesRoman", Font.BOLD, 15));
		Point3D nodeLoc=n.getLocation();
		StdDraw.point(nodeLoc.x(), nodeLoc.y());
	}



	//********************* Constructor **********************
	/**
	 * constructor to draw the graph
	 */
	public Graph_GUI(graph g) {
		initGUIGraph(g);
	}

	/**
	 * this method initials a graph algo from regular graph
	 * @param g
	 */
	private void initToAlgoGraph(graph g) {
		Graph_Algo gAlgo=new Graph_Algo(g);
	}

}
