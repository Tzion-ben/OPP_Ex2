package Tests;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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
	private static Graph_Algo graphAlgoTest=new Graph_Algo(graphTestToGraphAlgo);
//	private static NodeData node0=new NodeData(0);
//	private static NodeData node1=new NodeData(1);
//	private static NodeData node17=new NodeData(17);
//	private static NodeData node3=new NodeData(3);
//	private static NodeData node8=new NodeData(8);
//	private static NodeData node51=new NodeData(51);
//	private static NodeData node9=new NodeData(9);
//	private static NodeData node5=new NodeData(5);
//	private static NodeData node6=new NodeData(6);
	
	private static NodeData node2=new NodeData(2);
	private static NodeData node1=new NodeData(1);
	private static NodeData node18=new NodeData(18);
	private static NodeData node17=new NodeData(17);
	private static NodeData node10=new NodeData(10);
	private static NodeData node3=new NodeData(3);
	private static NodeData node180=new NodeData(180);
	private static NodeData node9=new NodeData(9);


	@BeforeAll
	public static void beforeall() {
//		graphTestToGraphAlgo=new DGraph();
//		graphTestToGraphAlgo.addNode(node0);
//		graphTestToGraphAlgo.addNode(node1);
//		//graphTestToGraphAlgo.addNode(node2);
//		graphTestToGraphAlgo.addNode(node3);
//		graphTestToGraphAlgo.addNode(node8);
//		graphTestToGraphAlgo.addNode(node51);
//		graphTestToGraphAlgo.addNode(node9);
//		graphTestToGraphAlgo.addNode(node5);
//		graphTestToGraphAlgo.addNode(node6);
//		graphTestToGraphAlgo.addNode(node17);
		
		graphTestToGraphAlgo=new DGraph();
		graphTestToGraphAlgo.addNode(node2);
		graphTestToGraphAlgo.addNode(node1);
		graphTestToGraphAlgo.addNode(node18);
		graphTestToGraphAlgo.addNode(node17);
		graphTestToGraphAlgo.addNode(node10);
		graphTestToGraphAlgo.addNode(node3);
		graphTestToGraphAlgo.addNode(node180);
		graphTestToGraphAlgo.addNode(node9);

		graphTestToGraphAlgo.connect(1, 2, 590);
		graphTestToGraphAlgo.connect(2, 1, 5);
		graphTestToGraphAlgo.connect(1, 18, 3);
		graphTestToGraphAlgo.connect(18, 1, 10);
		graphTestToGraphAlgo.connect(1, 17, 16);
		graphTestToGraphAlgo.connect(17, 1, 58);
		graphTestToGraphAlgo.connect(1, 10, 78);
		graphTestToGraphAlgo.connect(10, 1, 94);
		graphTestToGraphAlgo.connect(1, 3, 63);
		graphTestToGraphAlgo.connect(3, 1, 12);
		graphTestToGraphAlgo.connect(17, 180, 19);
		graphTestToGraphAlgo.connect(180, 17, 45);
		graphTestToGraphAlgo.connect(180, 9, 52);
		graphTestToGraphAlgo.connect(9, 180, 100);



		//		graphTestToGraphAlgo.connect(0, 3, 50);
		//		graphTestToGraphAlgo.connect(0, 4, 50);
		//		graphTestToGraphAlgo.connect(0, 5, 50);
		//		graphTestToGraphAlgo.connect(5, 0, 50);
		//		graphTestToGraphAlgo.connect(2, 3, 50);
		//		graphTestToGraphAlgo.connect(4, 1, 50);

	}

	@Test
	void testInitGraph() {
		Graph_Algo graphAlgoTestInit=new Graph_Algo(graphTestToGraphAlgo);
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
		//the first is connect so have to be true
		if(!isCon1)
			fail();

		//and now i connect all the graph that it's have to be connected
		graphTestToGraphAlgo.connect(1, 2, 50);
		graphTestToGraphAlgo.connect(2, 1, 50);
		graphTestToGraphAlgo.connect(2, 3, 50);
		graphTestToGraphAlgo.connect(3, 2, 50);
		graphAlgoTest.init(graphTestToGraphAlgo);

		boolean isCon2=graphAlgoTest.isConnected();
		//the second is connect so have to be true
		if(!isCon2)
			fail();
		
		node_data notCon=new NodeData(400);
		graphTestToGraphAlgo.addNode(notCon);
		graphAlgoTest.init(graphTestToGraphAlgo);
		boolean isCon3=graphAlgoTest.isConnected();
		//the second is connect so have to be true
		if(isCon3)
			fail();
		
		
		//remove the not gor vertex
		node_data returnNode=graphTestToGraphAlgo.removeNode(400);
		assertEquals(notCon, returnNode);
	}

	@Test
	void testShortestPathDist() {
//		graphTestToGraphAlgo.connect(0, 1, 1);
//		graphTestToGraphAlgo.connect(1, 0, 1);
//		graphTestToGraphAlgo.connect(1, 3, 2.9);
//		graphTestToGraphAlgo.connect(3, 1, 3);
//		graphTestToGraphAlgo.connect(3, 8, 9);
//		graphTestToGraphAlgo.connect(8, 3, 7);
//		graphTestToGraphAlgo.connect(8, 0, 5);
//		graphTestToGraphAlgo.connect(0, 8, 15);
//		graphTestToGraphAlgo.connect(51, 0, 29);
//		graphTestToGraphAlgo.connect(0, 51, 38);
//
//		graphTestToGraphAlgo.connect(9, 3, 38);
//		graphTestToGraphAlgo.connect(5, 3, 800);
//		//graphTestToGraphAlgo.connect(6, 3, 10);
//		graphTestToGraphAlgo.connect(0, 6, 38);
//		graphTestToGraphAlgo.connect(6, 5, 59);
//		graphTestToGraphAlgo.connect(3, 9, 38);
//		graphTestToGraphAlgo.connect(6, 17, 100);
//		graphTestToGraphAlgo.connect(17, 3, 2);
//		graphTestToGraphAlgo.connect(6, 0, 1);
//		graphAlgoTest.init(graphTestToGraphAlgo);
//		
//		double expected=4.9;
//		double actual=graphAlgoTest.shortestPathDist(6, 3);
//		assertEquals(expected, actual);
		
	}

	@Test
	void testShortestPath() {
//		graphTestToGraphAlgo.connect(0, 1, 1);
//		graphTestToGraphAlgo.connect(1, 0, 1);
//		graphTestToGraphAlgo.connect(1, 3, 2.9);
//		graphTestToGraphAlgo.connect(3, 1, 3);
//		graphTestToGraphAlgo.connect(3, 8, 9);
//		graphTestToGraphAlgo.connect(8, 3, 7);
//		graphTestToGraphAlgo.connect(8, 0, 5);
//		graphTestToGraphAlgo.connect(0, 8, 15);
//		graphTestToGraphAlgo.connect(51, 0, 29);
//		graphTestToGraphAlgo.connect(0, 51, 38);
//
//		graphTestToGraphAlgo.connect(9, 3, 38);
//		graphTestToGraphAlgo.connect(5, 3, 800);
//		//graphTestToGraphAlgo.connect(6, 3, 10);
//		graphTestToGraphAlgo.connect(0, 6, 38);
//		graphTestToGraphAlgo.connect(6, 5, 59);
//		graphTestToGraphAlgo.connect(3, 9, 38);
//		graphTestToGraphAlgo.connect(6, 17, 100);
//		graphTestToGraphAlgo.connect(17, 3, 2);
//		graphTestToGraphAlgo.connect(6, 0, 1);
//		graphAlgoTest.init(graphTestToGraphAlgo);
//
//		boolean falg=graphAlgoTest.isConnected();
//		List<node_data> sgPath =graphAlgoTest.shortestPath(6, 3);
//		
	
	}

	@Test
	void testTSP() {
		graphAlgoTest.init(graphTestToGraphAlgo);
		List<Integer> toTSP =new ArrayList<Integer>();
		toTSP.add(2);
		toTSP.add(3);
		toTSP.add(10);
		toTSP.add(9);

		List<node_data> expected =graphAlgoTest.TSP(toTSP);
		List<node_data> actual =new ArrayList<node_data>();
		actual.add(node2);
		actual.add(node1);
		actual.add(node3);
		actual.add(node1);
		actual.add(node10);
		actual.add(node1);
		actual.add(node17);
		actual.add(node180);
		actual.add(node9);
		assertEquals(expected, actual);
		
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
