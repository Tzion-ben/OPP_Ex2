package Tests;

import dataStructure.DGraph;
import dataStructure.NodeData;
import gui.GraphGUI;
import utils.Point3D;

public class Gui_TestNotJunit {

	public static void main(String[] args) {

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





	}
}
