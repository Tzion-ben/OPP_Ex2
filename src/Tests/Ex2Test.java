package Tests;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algorithms.*;
import dataStructure.*;
import utils.*;
import gui.*;

/**
 * EX2 Structure test:
 * 1. make sure your code compile with this dummy test (DO NOT Change a thing in this test). 
 * 2. the only change require is to run your GUI window (see line 64).
 * 3. EX2 auto-test will be based on such file structure.
 * 4. Do include this test-case in you submitted repository, in folder Tests (under src).
 * 5. Do note that all the required packages are imported - do NOT use other 
 * 
 * @author boaz.benmoshe
 *
 */
class Ex2Test {
	private static graph _graph;
	private static graph_algorithms _alg;
	public static final double EPS = 0.001; 
	private static Point3D min = new Point3D(0,0,0);
	private static Point3D max = new Point3D(100,100,0);
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		_graph = tinyGraph();
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testConnectivity() {
		_alg = new Graph_Algo(_graph);
		boolean con = _alg.isConnected();
		if(!con) {
			fail("shoulbe be connected");
		}
	}
	@Test
	void testgraph() {
		boolean ans = drawGraph(_graph);
		assertTrue(ans);
	}
	
	private static graph tinyGraph() {
		graph ans = new DGraph();
		return ans;
	}
	
	
	boolean drawGraph(graph g) { 
		DGraph graphTest;
		DGraph graphTestEmpty;

		NodeData node0=new NodeData(0);
		NodeData node1=new NodeData(1);
		NodeData node2=new NodeData(2);
		NodeData node3=new NodeData(3);
		NodeData node4=new NodeData(4);
		NodeData node5=new NodeData(5);
		NodeData node6=new NodeData(6);
		graphTest=new DGraph();
		graphTest.addNode(node0);
		graphTest.addNode(node1);
		graphTest.addNode(node2);
		graphTest.addNode(node3);
		graphTest.addNode(node4);
		graphTest.addNode(node5);

		Point3D p0=new Point3D(50, 400, 0);
		Point3D p1=new Point3D(159, 420, 0);
		Point3D p2=new Point3D(1980, 1680, 0);
		Point3D p3=new Point3D(50, 120, 0);
		Point3D p4=new Point3D(10, 60, 0);
		Point3D p5=new Point3D(10, 93, 0);
		Point3D p6=new Point3D(105, 233, 0);



		node0.setLocation(p0);
		node1.setLocation(p1);
		node2.setLocation(p2);
		node3.setLocation(p3);
		node4.setLocation(p4);
		node5.setLocation(p5);
		node6.setLocation(p6);


		graphTest.connect(0, 3, 12);
		graphTest.connect(0, 4, 978);
		graphTest.connect(0, 5, 534);
		graphTest.connect(5, 0, 45);
		graphTest.connect(2, 3, 567);
		graphTest.connect(4, 1, 789);


		graphTest.addNode(node6);
		graphTest.connect(6, 0, 45);
		graphTest.connect(6, 0, 45);

		graphTestEmpty=new DGraph();
		
		GraphGUI drawTest=new GraphGUI(graphTest);
		return true;
	}

}