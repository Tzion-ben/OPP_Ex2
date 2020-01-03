package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dataStructure.DGraph;
import dataStructure.NodeData;
import gui.Graph_GUI;
import utils.Point3D;

class GUI_Test {

	private static DGraph graphTest;
	private static NodeData node0=new NodeData(0);
	private static NodeData node1=new NodeData(1);
	private static NodeData node2=new NodeData(2);
	private static NodeData node3=new NodeData(3);
	private static NodeData node4=new NodeData(4);
	private static NodeData node5=new NodeData(5);

	@BeforeAll
	public static void beforeall() {
		graphTest=new DGraph();
		graphTest.addNode(node0);
		graphTest.addNode(node1);
		graphTest.addNode(node2);
		graphTest.addNode(node3);
		graphTest.addNode(node4);
		graphTest.addNode(node5);
		
		Point3D p0=new Point3D(10, 12, 0);
		Point3D p1=new Point3D(50, 42, 0);
		Point3D p2=new Point3D(80, 104, 0);
		Point3D p3=new Point3D(100, 120, 0);
		Point3D p4=new Point3D(79, 84, 0);
		Point3D p5=new Point3D(100, 93, 0);

		
		node0.setLocation(p0);
		node1.setLocation(p1);
		node2.setLocation(p2);
		node3.setLocation(p3);
		node4.setLocation(p4);
		node5.setLocation(p5);

		
		graphTest.connect(0, 3, 50);
		graphTest.connect(0, 4, 50);
		graphTest.connect(0, 5, 50);
		graphTest.connect(5, 0, 50);
		graphTest.connect(2, 3, 50);
		graphTest.connect(4, 1, 50);
	}
	@Test
	void testDraw() {
		Graph_GUI drawTest=new Graph_GUI(graphTest);
	}

}
