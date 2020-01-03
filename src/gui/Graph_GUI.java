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
			setCanvs();
			setMenu();
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
	  * this method set the size of the canvas for the graph
	  */
	private void setCanvs() {
		StdDraw.setCanvasSize(1100,650);
		
	}

	/**
	 * this method draw a just canvas because the graph is empty
	 */
	private void drawEmptyG() {
		StdDraw.setCanvasSize(1100,650);
		setMenu();
	}

	/**
	 * this method drawing the vertices of the graph
	 * @param n
	 */

	private void drawNode(node_data n) {
		StdDraw.setPenRadius(0.025);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.setFont(new Font("TimesRoman", Font.BOLD, 15));
		Point3D nodeLoc=n.getLocation();
		StdDraw.point(nodeLoc.x(), nodeLoc.y());
	}
	
	/**
	 * this method set the menu bar for the graph canvas
	 */
	private void setMenu() {
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Menu");
		menuBar.add(menu);
		
		//setMenuBar(menuBar);
	}

//	/**
//	 * this method drawing the direction of the edge from src node to dest node
//	 * @param n
//	 */
//	private void drawDirection(node_data src ,node_data dest) {
//		StdDraw.setPenRadius(0.02);
//		StdDraw.setPenColor(StdDraw.DARK_GRAY);
//		StdDraw.setFont(new Font("TimesRoman", Font.BOLD, 15));
//		Point3D nodeLocSrc=src.getLocation();
//		Point3D nodeLocDest=dest.getLocation();
//
//		if(dest.getLocation().x()>src.getLocation().x())
//			StdDraw.point(dest.getLocation().x()-, nodeLoc.y());
//	}



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
