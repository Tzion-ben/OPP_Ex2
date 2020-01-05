package Tests;

import dataStructure.graph;
import gui.GraphGUI;

public class drawHelp implements Runnable
{	
	public void printG()
	{

//		graph graphTest = Thread.get;
//		GraphGUI drawTest=new GraphGUI(graphTest);

		try 
		{
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() 
	{
		printG();
	}
}
