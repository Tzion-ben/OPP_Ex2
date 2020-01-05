package Tests;

import dataStructure.DGraph;
import dataStructure.NodeData;
import gui.GraphGUI;
import utils.Point3D;

public class Gui_TestNotJunit {

	public static void main(String[] args) {

		DGraph graphTest;
		DGraph graphTestEmpty;

		NodeData node2=new NodeData(2);
		NodeData node1=new NodeData(1);
		NodeData node18=new NodeData(18);
		NodeData node17=new NodeData(17);
		NodeData node10=new NodeData(10);
		NodeData node3=new NodeData(3);
		NodeData node180=new NodeData(180);
		NodeData node9=new NodeData(9);
		NodeData node15=new NodeData(15);
		graphTest=new DGraph();
		graphTest.addNode(node2);
		graphTest.addNode(node1);
		graphTest.addNode(node18);
		graphTest.addNode(node17);
		graphTest.addNode(node10);
		graphTest.addNode(node3);
		graphTest.addNode(node180);
		graphTest.addNode(node9);
		graphTest.addNode(node15);


		graphTest.connect(1, 2, 590);
		graphTest.connect(2, 3, 1);

		graphTest.connect(2, 1, 5);
		graphTest.connect(1, 18, 3);
		graphTest.connect(18, 1, 10);
		graphTest.connect(1, 17, 16);
		graphTest.connect(17, 1, 58);
		graphTest.connect(1, 10, 78);
		graphTest.connect(10, 1, 94);
		graphTest.connect(1, 3, 63);
		graphTest.connect(3, 1, 20);
		graphTest.connect(17, 180, 19);
		graphTest.connect(180, 17, 45);
		graphTest.connect(180, 9, 52);
		graphTest.connect(9, 180, 100);
		graphTest.connect(17, 15, 190);
		graphTest.connect(15, 17, 96);
//		graphTest=new DGraph();
//		graphTest.addNode(node0);
//		graphTest.addNode(node1);
//		graphTest.addNode(node2);
//		graphTest.addNode(node3);
//		graphTest.addNode(node4);
//		graphTest.addNode(node5);
		
		Point3D p0=new Point3D(50, 400, 0);
		Point3D p1=new Point3D(159, 420, 0);
		Point3D p2=new Point3D(1980, 1680, 0);
		Point3D p3=new Point3D(50, 120, 0);
		Point3D p4=new Point3D(10, 60, 0);
		Point3D p5=new Point3D(10, 93, 0);
		Point3D p6=new Point3D(105, 233, 0);
		Point3D p7=new Point3D(107, 670, 0);
		Point3D p8=new Point3D(150, 563, 0);
		Point3D p9=new Point3D(185, 279, 0);



		node2.setLocation(p0);
		node1.setLocation(p1);
		node18.setLocation(p2);
		node3.setLocation(p3);
		node17.setLocation(p4);
		node10.setLocation(p5);
		node3.setLocation(p6);
		node180.setLocation(p4);
		node9.setLocation(p5);
		node15.setLocation(p6);


		graphTest.connect(0, 3, 12);
		graphTest.connect(0, 4, 978);
		graphTest.connect(0, 5, 534);
		graphTest.connect(5, 0, 45);
		graphTest.connect(2, 3, 567);
		graphTest.connect(4, 1, 789);


//		graphTest.addNode(node6);
//		graphTest.connect(6, 0, 45);
//		graphTest.connect(6, 0, 45);

		graphTestEmpty=new DGraph();

		GraphGUI drawTest=new GraphGUI(graphTest);





	}
}
