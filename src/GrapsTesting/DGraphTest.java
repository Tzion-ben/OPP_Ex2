package GrapsTesting;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.edgeData;
import dataStructure.edge_data;
import dataStructure.node_data;

class DGraphTest {

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
		graphTest.connect(0, 3, 50);
		graphTest.connect(0, 4, 50);
		graphTest.connect(0, 5, 50);
		graphTest.connect(5, 0, 50);
		graphTest.connect(2, 3, 50);
		graphTest.connect(4, 1, 50);
	}

	@Test
	void testGetNode() {
		NodeData zeroExpected=new NodeData(0);
		NodeData oneExpected=new NodeData(1);
		NodeData towExpected=new NodeData(2);
		assertEquals(zeroExpected, graphTest.getNode(0));
		assertEquals(oneExpected, graphTest.getNode(1));
		assertEquals(towExpected, graphTest.getNode(2));
	}

	@Test
	void testGetEdge() {
		edge_data fourTo1Egde=graphTest.getEdge(4, 1);
		edgeData expected=new edgeData(4,1,50);
		assertEquals(expected, fourTo1Egde);
	}

	@Test
	void testConnect() {
		/*Use graphTest.connect(4, 1, 50); from BeforeAll*/
		edge_data fourTo1Egde=graphTest.getEdge(4, 1);
		edgeData expected=new edgeData(4,1,50);
		assertEquals(expected, fourTo1Egde);
	}

	@Test
	void testGetV() {
		Iterator<node_data> vertesis=this.graphTest.getV().iterator();
		int i=0;
		while(vertesis.hasNext()) {
			if(i==0) 
				assertEquals(node0, vertesis.next());
			if(i==1)
				assertEquals(node1, vertesis.next());
			if(i==2)
				assertEquals(node2, vertesis.next());
			if(i==3)
				assertEquals(node3, vertesis.next());
			if(i==4)
				assertEquals(node4, vertesis.next());
			if(i==5)
				assertEquals(node5, vertesis.next());
			i++;
		}
	}

	@Test
	void testGetE() {
		/*at this test i add a new node (vertex to the graph and the collection was updated and
		 *i check that it really updated)
		 */
		Collection<edge_data> edgesToChange= this.graphTest.getE(node0.getKey());
		this.graphTest.addNode(new NodeData(6));
		graphTest.connect(0, 6, 554);
		edge_data zeroto3=graphTest.getEdge(0, 3);
		edge_data zeroto4=graphTest.getEdge(0, 4);
		edge_data zeroto5=graphTest.getEdge(0, 5);
		edge_data zeroto6=graphTest.getEdge(0, 6);
		Iterator<edge_data> edges=edgesToChange.iterator();
		boolean flag=true;
		int i=0;
		while(edges.hasNext()) {
			if(i==0) { 
				edge_data temp0=edges.next();
				if(zeroto3.getSrc()!=temp0.getSrc()||zeroto3.getDest()!=temp0.getDest()
				||zeroto3.getWeight()!=temp0.getWeight())
					flag=false;
			}
			if(i==1) { 
				edge_data temp1=edges.next();
				if(zeroto4.getSrc()!=temp1.getSrc()||zeroto4.getDest()!=temp1.getDest()
				||zeroto4.getWeight()!=temp1.getWeight())
					flag=false;
			}
			if(i==2) { 
				edge_data temp2=edges.next();
				if(zeroto5.getSrc()!=temp2.getSrc()||zeroto5.getDest()!=temp2.getDest()
				||zeroto5.getWeight()!=temp2.getWeight())
					flag=false;
			}
			if(i==3) { 
				edge_data temp3=edges.next();
				if(zeroto6.getSrc()!=temp3.getSrc()||zeroto6.getDest()!=temp3.getDest()
				||zeroto6.getWeight()!=temp3.getWeight())
					flag=false;
			}
			i++;
		}
		graphTest.removeNode(6);
		if(!flag)
			fail();
	}

	@Test
	void testRemoveNode() {
		node_data rem=graphTest.removeNode(0);
		node_data expected=new NodeData(0);
		assertEquals(expected, rem);

		//put the node back, and all he's edges like before
		graphTest.addNode(node0);
		graphTest.connect(0, 3, 50);
		graphTest.connect(0, 4, 50);
		graphTest.connect(0, 5, 50);
		graphTest.connect(5, 0, 50);
	}

	@Test
	void testRemoveEdge() {
		edge_data rem=graphTest.removeEdge(0, 3);
		edge_data expected=new edgeData(0, 3, 50);
		assertEquals(expected, rem);
		
		//put the edge back, like was before
		graphTest.connect(0, 3, 50);		
	}

	@Test
	void testNodeSize() {
		int expected=6;
		assertEquals(expected, graphTest.nodeSize());
	}

	@Test
	void testEdgeSize() {
		int expected=6;
		assertEquals(expected, graphTest.edgeSize());

	}

	@Test
	void testGetMC() {
		int expected=12;
		//the MC that will return is from the oparations at the Before All
		assertEquals(expected, graphTest.getMC());
	}
	
	@Test
	void testEqualsGraphs() {
		
		NodeData node6=new NodeData(6);
		
		DGraph graphTestCopy;
		graphTestCopy=new DGraph();
		graphTestCopy.addNode(node0);
		graphTestCopy.addNode(node1);
		graphTestCopy.addNode(node2);
		graphTestCopy.addNode(node3);
		graphTestCopy.addNode(node4);
		graphTestCopy.addNode(node5);
		
		//that the differers between the two graph
		graphTestCopy.addNode(node6);
		graphTestCopy.connect(0, 6, 50);
		//end differers
		
		graphTestCopy.connect(0, 3, 50);
		graphTestCopy.connect(0, 4, 50);
		graphTestCopy.connect(0, 5, 50);
		graphTestCopy.connect(5, 0, 50);
		graphTestCopy.connect(2, 3, 50);
		graphTestCopy.connect(4, 1, 50);
		assertNotEquals(graphTest, graphTestCopy);
		
		//remove the differers
		graphTestCopy.removeNode(6);
		//end remove
		assertEquals(graphTest, graphTestCopy);
	}
}
