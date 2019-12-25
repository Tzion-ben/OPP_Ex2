package GrapsTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.node_data;

class DGraphTest {
	
	private static DGraph ex1;
	
	@BeforeAll
	public static void beforeall() {
		ex1=new DGraph();
	}
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetNode() {
		NodeData zeroNode=new NodeData(0);
		NodeData oneNode=new NodeData(1);
		NodeData towNode=new NodeData(2);
		ex1.addNode(zeroNode);
		ex1.addNode(oneNode);
		ex1.addNode(towNode);
		assertEquals(zeroNode, ex1.getNode(0));
		assertEquals(oneNode, ex1.getNode(1));
		assertEquals(towNode, ex1.getNode(2));
		
	}

	@Test
	void testGetEdge() {
		fail("Not yet implemented");
	}

	@Test
	void testConnect() {
		//edgeData oneTo2Egde=new edgeData(1,2,50);
		//edgeData oneTo3Egde=new edgeData(1,3,50);	
		ex1.connect(4, 1, 50);
		ex1.connect(3, 2, 55);

		
	}

	@Test
	void testGetV() {
		fail("Not yet implemented");
	}

	@Test
	void testGetE() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveNode() {
		NodeData Node3=new NodeData(3);
		NodeData Node4=new NodeData(4);
		NodeData Node5=new NodeData(5);
		ex1.addNode(Node3);
		ex1.addNode(Node4);
		ex1.addNode(Node5);
		ex1.connect(0, 3, 50);
		ex1.connect(0, 4, 50);
		ex1.connect(0, 5, 50);
		ex1.connect(5, 0, 50);
		ex1.connect(2, 3, 50);
		ex1.connect(4, 1, 50);
		node_data rem=ex1.removeNode(0);
		
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
