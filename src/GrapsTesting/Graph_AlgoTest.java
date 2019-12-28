package GrapsTesting;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import algorithms.Graph_Algo;
import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.graph;
import dataStructure.node_data;

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
		//graphTestToGraphAlgo.connect(0, 5, 50);
		//graphTestToGraphAlgo.connect(5, 0, 50);
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
		Graph_Algo graphAlgoTestInit=new Graph_Algo();
		graphAlgoTestInit.init(graphTestToGraphAlgo);
		assertEquals(graphAlgoTest, graphAlgoTestInit);
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
		graphAlgoTest.init(graphTestToGraphAlgo);
		boolean isCon1=graphAlgoTest.isConnected();
		//the first isn't connect so have to be false
		if(isCon1)
			fail();
		
		//and now i connect all the graph that it's have to be connected
		graphTestToGraphAlgo.connect(0, 1, 50);
		graphTestToGraphAlgo.connect(1, 0, 50);
		graphTestToGraphAlgo.connect(1, 2, 50);
		graphTestToGraphAlgo.connect(2, 1, 50);
		graphTestToGraphAlgo.connect(2, 3, 50);
		graphTestToGraphAlgo.connect(3, 2, 50);
		graphTestToGraphAlgo.connect(3, 4, 50);
		graphTestToGraphAlgo.connect(4, 3, 50);
		graphTestToGraphAlgo.connect(4, 5, 50);
		graphTestToGraphAlgo.connect(5, 4, 50);
		//graphTestToGraphAlgo.connect(5, 0, 50);
		//graphTestToGraphAlgo.connect(0, 5, 50);
		graphAlgoTest.init(graphTestToGraphAlgo);
		boolean isCon2=graphAlgoTest.isConnected();
		//the second is connect so have to be true
		if(!isCon2)
			fail();
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
		graphAlgoTest.init(graphTestToGraphAlgo);
		graph graphCopy=new DGraph();
		graphCopy=(DGraph)graphAlgoTest.copy();
		assertEquals(graphTestToGraphAlgo, graphCopy);

		//change the copy graph that not have to change the original graph
		NodeData node6=new NodeData(6);
		graphCopy.addNode(node6);
		graphCopy.connect(0, 6, 50);
		assertNotEquals(graphTestToGraphAlgo, graphCopy);

	}

}
