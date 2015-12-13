import java.io.IOException;
import java.util.Random;

/*
 * This is the testing function
 */

public class TestDijkstra {
	public static void main (String[] args) 
	{
		GlobalTopology global_topology = new GlobalTopology();
		global_topology.CLOCK=0;
		for(int curtime=0; curtime<= 600000; curtime++)
		{
			if (curtime-global_topology.CLOCK> 253)
			{
				//int[] CostList=Routing.UpdateCost();
				int[] CostList = {1, 6, 10, 2, 9, 10, 2, 10, 10, 2};
				System.out.println("The CostList is : "+ "");
				for(int i=0; i< CostList.length;i++)
				{
						System.out.println(CostList[i]);
				}
				System.out.println("\n");
				int[][][] RoutingTable= Routing.Dijkstra(CostList);
				PathInfo pathinfo = new PathInfo();
				Random random1 = new Random();
				int srcRouter = 4;
				Random random2 = new Random();
				int desNode = 2;
				// FindPath is used by ROUTERS to find the path (the next router) and the estimated propagation delay. 
				//The propogation delay (path.TpAll) will be the time from the ROUTER that is using this function to the DES NODE. 
				// int srcRouter is the ID of the router that is using this function, and desNode is the ID of the destination (Node )
				pathinfo = Routing.FindPath(RoutingTable, srcRouter, desNode, "rondnfd", CostList);
				System.out.println("Routing Table is \n");
				for(int i=0; i< 4;i++)
				{
					for(int j=0;j<8;j++)
					{
						System.out.println("("+RoutingTable[i][j][0]+","+RoutingTable[i][j][1]+","+RoutingTable[i][j][2]+")");
					}
					System.out.println("\n");
				}
				
				System.out.println("srcRouter is " + srcRouter+"\n");
				System.out.println("desNode is " + desNode+"\n");
				System.out.println("NextRouter is " + pathinfo.NextRouter+"\n");
				System.out.println("Cost is " + pathinfo.Cost+"\n");
				
			}
		}
	}
}
