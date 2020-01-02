package gui;
/**
 * This class makring a GUI of graph and make algorithms on this graph
 * 
 * @author tzion
 */


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

public class Graph_GUI extends JFrame implements ActionListener, MouseListener
{

	/**
	 * this method initials a graph algo from regular DGraph
	 * @param g
	 */
	public void initToAlgoGraph(graph g) {
		Graph_Algo gAlgo=new Graph_Algo(g);
	}
		
	/**
	 * constructor to draw the graph
	 */
	public Graph_GUI(graph g) {
		initGUIGraph();
	}
	
	private void initGUIGraph() 
	{
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Menu Of Actions");
		menuBar.add(menu);
		this.setMenuBar(menuBar);
		MenuItem sa = new MenuItem("Save");
		MenuItem load = new MenuItem("Load");
		MenuItem Algorithms = new MenuItem("Algorithms");
		sa.addActionListener(this);
		load.addActionListener(this);
		Algorithms.addActionListener(this);
		menu.add(sa);
		menu.add(load);
		menu.add(Algorithms);
		this.addMouseListener(this);
	}


	public void drawNode() {

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
