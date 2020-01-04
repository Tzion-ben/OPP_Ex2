package gui;


import java.awt.Color;
import java.awt.Graphics;
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

import utils.*;
import algorithms.Graph_Algo;
import algorithms.graph_algorithms;
import dataStructure.NodeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;

public class GraphGUI extends JFrame implements ActionListener, MouseListener
{
	static int idNodes=0;
	Collection<node_data> vertices;
	Iterator<node_data> vert;

	private void initGUIGraph(graph g) 
	{
		if(g==null) {//draw a empty graph
			setVisible(true);
			this.setSize(1000, 700);
			addMenu();
		}
		else {
			setVisible(true);
			this.setSize(1000, 700);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			checkNodeCount();
			addMenu();
		}
	}

	/**
	 * this method returns the number of the next node id
	 */
	private void checkNodeCount() {
		if(this.graphGui!=null) {
			Collection<node_data> vertices= this.graphGui.getV();
			Iterator<node_data> vert=vertices.iterator();
			while(vert.hasNext()) {
				idNodes++;
				vert.next();
			}
		}
	}
	/**
	 * this method add the menu to the canvas
	 */
	private void addMenu() {
		MenuBar menuBar = new MenuBar();
		Menu sOl = new Menu("Save and Load");
		Menu algo = new Menu("Algorithems");
		menuBar.add(sOl);
		menuBar.add(algo);
		this.setMenuBar(menuBar);
		MenuItem save = new MenuItem("Save the Graph");
		save.addActionListener(this);
		MenuItem load = new MenuItem("Load the Graph");
		load.addActionListener(this);
		sOl.add(save);
		sOl.add(load);
		MenuItem isConnected = new MenuItem("isConnected");
		isConnected.addActionListener(this);
		algo.add(isConnected);
		MenuItem shortestPathDist = new MenuItem("shortestPathDist");
		shortestPathDist.addActionListener(this);
		algo.add(shortestPathDist);
		MenuItem shortestPath = new MenuItem("shortestPath");
		shortestPath.addActionListener(this);
		algo.add(shortestPath);
		MenuItem TSP = new MenuItem("TSP");
		TSP.addActionListener(this);
		algo.add(TSP);
		this.addMouseListener(this);
	}

	/**
	 * this function is pained the vertices and the edges
	 */
	public void paint(Graphics g)
	{
		super.paint(g);
		Collection<node_data> vertices= this.graphGui.getV();
		Iterator<node_data> vert=vertices.iterator();
		while(vert.hasNext()) {
			node_data tempVert=vert.next();
			g.setColor(Color.BLACK);
			g.fillOval((int)tempVert.getLocation().x(), (int)tempVert.getLocation().y(), 10, 10);
			if(vertices.size()>1) {
				Collection<edge_data> edgesOfNodeId= this.graphGui.getE(tempVert.getKey());
				Iterator<edge_data> edge=edgesOfNodeId.iterator();
				while(edge.hasNext()) {
					edge_data tempEdge=edge.next();
					g.setColor(Color.DARK_GRAY);
					g.drawLine(tempVert.getLocation().ix(), tempVert.getLocation().iy(),
							this.graphGui.getNode(tempEdge.getDest()).getLocation().ix(),
							this.graphGui.getNode(tempEdge.getDest()).getLocation().iy());
				}
			}
		}

	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String str = e.getActionCommand();

		System.out.println(str);
		if(str.compareTo("Save the Graph")==0)
		{
			System.out.println("Save the Graph IN !!");
		}
		else if(str.compareTo("Load the Graph")==0)
		{
			System.out.println("Load the Graph IN !!");
		}
		
		else if(str.compareTo("isonnected")==0)
		{
			System.out.println("123");
			initToAlgoGraph(this.graphGui);
			boolean con=this.GrapAlgo.isConnected();
			System.out.println("connected ?: "+con);
		}
		else if(str.compareTo("shortestPathDist")==0)
		{
			initToAlgoGraph(this.graphGui);
			System.out.println("shortestPathDist");
		}
		else if(str.compareTo("shortestPath")==0)
		{
			initToAlgoGraph(this.graphGui);
			//double path=this.GrapAlgo.shortestPath(src, dest);
			System.out.println("shortestPath");
		}
		else if(str.compareTo("TSP")==0)
		{
			initToAlgoGraph(this.graphGui);
			boolean con=this.GrapAlgo.isConnected();
			System.out.println("TSP");
		}
		System.out.println(str);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		Point3D p = new Point3D(x,y);
		addNodePaintFromGui(p);
		repaint();
	}

	/**
	 * this method add vertex to the canvas
	 */
	private void addNodePaintFromGui(Point3D p) {
		node_data newVert=new NodeData(idNodes);
		this.graphGui.addNode(newVert);
		newVert.setLocation(p);
		idNodes++;
		System.out.println("add vertex number: "+idNodes);
		System.out.println("The coardinate is : "+p.ix()+" "+p.iy()+" ");
	}


	@Override
	public void mouseReleased(MouseEvent e) {

	}
	@Override
	public void mouseEntered(MouseEvent e) {

	}
	@Override
	public void mouseExited(MouseEvent e) {
	}

	//********************* Constructor and fields **********************
	private graph graphGui;
	private graph_algorithms GrapAlgo;
	/**
	 * constructor to draw the graph
	 */
	public GraphGUI(graph g) {
		this.graphGui=g;
		initGUIGraph(graphGui);
	}

	/**
	 * this method initials a graph Algo from regular graph
	 * @param g
	 */
	private void initToAlgoGraph(graph g) {
		GrapAlgo=new Graph_Algo(g);
	}
}

