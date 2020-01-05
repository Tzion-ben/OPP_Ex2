package Tests;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
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
	private static NodeData node15=new NodeData(15);



	@BeforeAll
	public static void beforeall() {
		graphTestToGraphAlgo=new DGraph();
		graphTestToGraphAlgo.addNode(node2);
		graphTestToGraphAlgo.addNode(node1);
		graphTestToGraphAlgo.addNode(node18);
		graphTestToGraphAlgo.addNode(node17);
		graphTestToGraphAlgo.addNode(node10);
		graphTestToGraphAlgo.addNode(node3);
		graphTestToGraphAlgo.addNode(node180);
		graphTestToGraphAlgo.addNode(node9);
		graphTestToGraphAlgo.addNode(node15);


		graphTestToGraphAlgo.connect(1, 2, 590);
		graphTestToGraphAlgo.connect(2, 3, 1);

		graphTestToGraphAlgo.connect(2, 1, 5);
		graphTestToGraphAlgo.connect(1, 18, 3);
		graphTestToGraphAlgo.connect(18, 1, 10);
		graphTestToGraphAlgo.connect(1, 17, 16);
		graphTestToGraphAlgo.connect(17, 1, 58);
		graphTestToGraphAlgo.connect(1, 10, 78);
		graphTestToGraphAlgo.connect(10, 1, 94);
		graphTestToGraphAlgo.connect(1, 3, 63);
		graphTestToGraphAlgo.connect(3, 1, 2);
		graphTestToGraphAlgo.connect(17, 180, 19);
		graphTestToGraphAlgo.connect(180, 17, 45);
		graphTestToGraphAlgo.connect(180, 9, 52);
		graphTestToGraphAlgo.connect(9, 180, 100);
		graphTestToGraphAlgo.connect(17, 15, 190);
		graphTestToGraphAlgo.connect(15, 17, 96);
	}

	@Test
	void testSaveAndInit() {
		DGraph graphTestToSave=new DGraph();
		Graph_Algo graphAlgoTestSave=new Graph_Algo(graphTestToSave);
		graphAlgoTestSave.init("graph2.csv");
		graphAlgoTestSave.save("outputGraph.csv");
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

		//remove the not good vertex
		node_data returnNode=graphTestToGraphAlgo.removeNode(400);
		assertEquals(notCon, returnNode);
	}

	@Test
	void testShortestPathDist() {
		graphAlgoTest.init(graphTestToGraphAlgo);

		double expected=6;
		double notExpected=8;
		double actual=graphAlgoTest.shortestPathDist(2, 18);
		assertEquals(expected, actual);
		assertNotEquals(notExpected, actual);
	}

	@Test
	void testShortestPath() {
		List<node_data> sgPath =graphAlgoTest.shortestPath(2, 18);
		ArrayList<node_data> expected=new ArrayList<node_data>();
		expected.add(node2);
		expected.add(node3);
		expected.add(node1);
		expected.add(node18);
		assertEquals(expected, sgPath);
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
		System.out.println(actual.toString());

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
