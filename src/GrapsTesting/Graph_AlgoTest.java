package GrapsTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.NodeData;

class Graph_AlgoTest {

	
	private static DGraph graphTestToGraphAlgo;
	private static Graph_Algo graphAlgoTest=new Graph_Algo();
	private static NodeData node0=new NodeData(0);
	private static NodeData node1=new NodeData(1);
	private static NodeData node2=new NodeData(2);
	private static NodeData node3=new NodeData(3);
	private static NodeData node4=new NodeData(4);
	private static NodeData node5=new NodeData(5);

	@BeforeAll
	public static void beforeall() {
		graphTestToGraphAlgo=new DGraph();
		graphTestToGraphAlgo.addNode(node0);
		graphTestToGraphAlgo.addNode(node1);
		graphTestToGraphAlgo.addNode(node2);
		graphTestToGraphAlgo.addNode(node3);
		graphTestToGraphAlgo.addNode(node4);
		graphTestToGraphAlgo.addNode(node5);
		graphTestToGraphAlgo.connect(0, 3, 50);
		graphTestToGraphAlgo.connect(0, 4, 50);
		graphTestToGraphAlgo.connect(0, 5, 50);
		graphTestToGraphAlgo.connect(5, 0, 50);
		graphTestToGraphAlgo.connect(2, 3, 50);
		graphTestToGraphAlgo.connect(4, 1, 50);
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testInitGraph() {
		graphAlgoTest.init(graphTestToGraphAlgo);
		//assertEquals(graphAlgoTest., node0);
	}

	@Test
	void testInitString() {
		graphAlgoTest.init("graph.csv");

	}

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testIsConnected() {
		fail("Not yet implemented");
	}

	@Test
	void testShortestPathDist() {
		fail("Not yet implemented");
	}

	@Test
	void testShortestPath() {
		fail("Not yet implemented");
	}

	@Test
	void testTSP() {
		fail("Not yet implemented");
	}

	@Test
	void testCopy() {
		
		
	}

}
