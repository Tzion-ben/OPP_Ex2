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

import javax.management.StringValueExp;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import utils.*;
import algorithms.Graph_Algo;
import algorithms.graph_algorithms;
import dataStructure.NodeData;
import dataStructure.edgeData;
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
		Menu sOl = new Menu("Save or Load");
		Menu algo = new Menu("Algorithems");
		MenuItem save = new MenuItem("Save the Graph");
		MenuItem load = new MenuItem("Load the Graph");
		MenuItem isConnected = new MenuItem("isConnected");
		MenuItem shortestPathDist = new MenuItem("shortestPathDist");
		MenuItem shortestPath = new MenuItem("shortestPath");
		MenuItem TSP = new MenuItem("TSP");

		menuBar.add(sOl);
		menuBar.add(algo);
		this.setMenuBar(menuBar);
		sOl.add(save);
		sOl.add(load);

		save.addActionListener(this);
		load.addActionListener(this);
		isConnected.addActionListener(this);
		shortestPathDist.addActionListener(this);
		shortestPath.addActionListener(this);
		TSP.addActionListener(this);

		algo.add(isConnected);
		algo.add(shortestPathDist);
		algo.add(shortestPath);
		algo.add(TSP);
		this.addMouseListener(this);
	}

	/**
	 * this function is pained the vertices and the edges
	 */
	public void paint(Graphics g)
	{
		super.paint(g);
		setWorngLocatins();
		Collection<node_data> vertices= this.graphGui.getV();
		Iterator<node_data> vert=vertices.iterator();
		while(vert.hasNext()) {
			node_data tempVert=vert.next();
			g.setColor(Color.BLACK);
			Point3D pVert=new Point3D(tempVert.getLocation().ix(), tempVert.getLocation().iy());
			g.fillOval(pVert.ix(), pVert.iy(), 10, 10);
			String nodeId= String.valueOf(tempVert.getKey());
			g.drawString(nodeId, tempVert.getLocation().ix(), tempVert.getLocation().iy());
			if(vertices.size()>1) {
				Collection<edge_data> edgesOfNodeId= this.graphGui.getE(tempVert.getKey());
				Iterator<edge_data> edge=edgesOfNodeId.iterator();

				while(edge.hasNext()) {
					edge_data tempEdge=edge.next();
					g.setColor(Color.DARK_GRAY);
					g.drawLine(tempVert.getLocation().ix(), tempVert.getLocation().iy(),
							this.graphGui.getNode(tempEdge.getDest()).getLocation().ix(),
							this.graphGui.getNode(tempEdge.getDest()).getLocation().iy());
					g.setColor(Color.GREEN);
					String wEdge= String.valueOf(tempEdge.getWeight());
					g.drawString(wEdge, this.graphGui.getNode(tempEdge.getDest()).getLocation().ix()-30,
							this.graphGui.getNode(tempEdge.getDest()).getLocation().iy());
				}
			}
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String str = e.getActionCommand();

		if(str.compareTo("Save the Graph")==0)
		{
			initToAlgoGraph(this.graphGui);
			GrapAlgo.save("New Graph");
			JOptionPane.showMessageDialog(this,"The graph was saved at the project folder");
		}
		else if(str.compareTo("Load the Graph")==0)
		{
			try {
				if(this.graphGui.edgeSize()==0&&this.graphGui.nodeSize()==0) {
					initToAlgoGraph(this.graphGui);
					String toLoad = JOptionPane.showInputDialog(this, "Enter name of the file to load");
					GrapAlgo.init(toLoad);
					graph gAlgotemp=GrapAlgo.copy();
					GraphGUI g=new GraphGUI(gAlgotemp);
					//repaint();

					JOptionPane.showMessageDialog(this,"The graph loaded");	
				}
				else
					JOptionPane.showMessageDialog(this,"CAN'T load, you have to create empty graph"
							+ "and the load ,so try again :)");	
			}
			catch (Exception FileNotFoundException) {
				JOptionPane.showMessageDialog(this,"CAN'T load, Invalid file");	
			}
		}

		else if(str.compareTo("isConnected")==0)
		{
			initToAlgoGraph(this.graphGui);
			boolean isCon=this.GrapAlgo.isConnected();
			if(isCon)
				JOptionPane.showMessageDialog(this,"The graph is connected");
			else
				JOptionPane.showMessageDialog(this,"The graph ISN'T connected");
		}//end isConnected

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

			System.out.println("TSP");
		}
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
		addEdgePaintFromGiu();
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
		JOptionPane.showMessageDialog(this,"add vertex number: "+(idNodes-1));
		JOptionPane.showMessageDialog(this,"The coardinate is : "+p.ix()+" "+p.iy()+" ");
	}

	/**
	 * this method add vertex to the canvas
	 */
	private void addEdgePaintFromGiu() {
		try {
			String srcId = JOptionPane.showInputDialog(this, "Enter source of the edge");
			String destId = JOptionPane.showInputDialog(this, "Enter destination of the edge");
			String edgeEeight = JOptionPane.showInputDialog(this, "Enter the weight of the edge");
			this.graphGui.connect(Integer.parseInt(srcId), Integer.parseInt(destId),
					Double.parseDouble(edgeEeight));
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(this,"THE EDGE IS ALREDY IN ,ERROR");
		}


	}

	/**
	 * this method make the locations of the nodes that at the corners
	 * and make them in between the size of the my canvas
	 */
	private void setWorngLocatins() {
		Collection<node_data> vertices= this.graphGui.getV();
		Iterator<node_data> vert=vertices.iterator();
		while(vert.hasNext()) {
			node_data tempVert=vert.next();
			Point3D pVertOld=new Point3D(tempVert.getLocation().ix(), tempVert.getLocation().iy());
			Point3D pVertNew=new Point3D(tempVert.getLocation().ix(), tempVert.getLocation().iy());
			if(pVertOld.ix()<11||pVertOld.iy()<61) {
				//based on the logic that the courdinate cant be less then zero
				if(pVertOld.ix()<11&&pVertOld.iy()<61) 	
					pVertNew. add(10, 61-pVertOld.iy(), 0);
				else if(pVertOld.ix()<11)
					pVertNew. add(10, 0, 0);
				else if(pVertOld.iy()<61)
					pVertNew. add(0, 61-pVertOld.iy(), 0);
			}
			if(pVertOld.ix()>981||pVertOld.iy()>681) {
				if(pVertOld.ix()>981&&pVertOld.iy()>681) 
					pVertNew. add(-(pVertOld.ix()-980), -(pVertOld.iy()-680), 0);
				else if(pVertOld.ix()>981)
					pVertNew. add(-(pVertOld.ix()-980), 0, 0);
				else if(pVertOld.iy()>681)
					pVertNew. add(0, -(pVertOld.iy()-680), 0);
			}
			this.graphGui.getNode(tempVert.getKey()).setLocation(pVertNew);
			tempVert.setLocation(pVertNew);
		}
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
		initGUIGraph(this.graphGui);
	}

	/**
	 * this method initials a graph Algo from regular graph
	 * @param g
	 */
	private void initToAlgoGraph(graph g) {
		GrapAlgo=new Graph_Algo(g);
	}
}


