package GrapsTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.edgeData;
import dataStructure.edge_data;
import dataStructure.node_data;

class DGraphTest {
	
	private static DGraph graphTest;
	private static NodeData zeroNode=new NodeData(0);
	private static NodeData oneNode=new NodeData(1);
	private static NodeData towNode=new NodeData(2);
	private static NodeData Node3=new NodeData(3);
	private static NodeData Node4=new NodeData(4);
	private static NodeData Node5=new NodeData(5);
	
	@BeforeAll
	public static void beforeall() {
		graphTest=new DGraph();
		graphTest.addNode(zeroNode);
		graphTest.addNode(oneNode);
		graphTest.addNode(towNode);
		graphTest.addNode(Node3);
		graphTest.addNode(Node4);
		graphTest.addNode(Node5);
	}
	
	@Test
	void testGetNode() {
		assertEquals(zeroNode, graphTest.getNode(0));
		assertEquals(oneNode, graphTest.getNode(1));
		assertEquals(towNode, graphTest.getNode(2));
	}

	@Test
	void testGetEdge() {
		graphTest.connect(4, 1, 50);
		edge_data fourTo1Egde=graphTest.getEdge(4, 1);
		edgeData expected=new edgeData(4,1,50);
		assertEquals(expected.getSrc(), fourTo1Egde.getSrc());
		assertEquals(expected.getDest(), fourTo1Egde.getDest());
		assertEquals(expected.getInfo(), fourTo1Egde.getInfo());
		assertEquals(expected.getTag(), fourTo1Egde.getTag());
		assertEquals(expected.getWeight(), fourTo1Egde.getWeight());
	}

	@Test
	void testConnect() {
		graphTest.connect(4, 1, 50);
		edge_data fourTo1Egde=graphTest.getEdge(4, 1);
		edgeData expected=new edgeData(4,1,50);
		assertEquals(expected.getSrc(), fourTo1Egde.getSrc());
		assertEquals(expected.getDest(), fourTo1Egde.getDest());
		assertEquals(expected.getInfo(), fourTo1Egde.getInfo());
		assertEquals(expected.getTag(), fourTo1Egde.getTag());
		assertEquals(expected.getWeight(), fourTo1Egde.getWeight());
		System.out.println("mc: "+graphTest.getMC());
	}

	@Test
	void testGetV() {
		
	}

	@Test
	void testGetE() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveNode() {
		graphTest.connect(0, 3, 50);
		graphTest.connect(0, 4, 50);
		graphTest.connect(0, 5, 50);
		graphTest.connect(5, 0, 50);
		graphTest.connect(2, 3, 50);
		graphTest.connect(4, 1, 50);
		node_data rem=graphTest.removeNode(0);
		
	}

	@Test
	void testRemoveEdge() {
		fail("Not yet implemented");
	}

	@Test
	void testNodeSize() {
		fail("Not yet implemented");
	}

	@Test
	void testEdgeSize() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMC() {
		fail("Not yet implemented");
	}

}
