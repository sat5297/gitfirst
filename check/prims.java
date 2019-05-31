import java.util.*;
public class prims
{
public static int [][] mst,cost;
public static int n;
public static int [] distance,visited,parent;

public static void read()
	{
	Scanner sc = new Scanner(System.in);
	for(int i = 0; i < n; i++)
	   {
	   for(int j = 0; j < n; j++)
	      {
	       System.out.print((i+1)+"\t"+(j+1)+"\t");
	       cost[i][j] = sc.nextInt();
	      }
	   }
	}

public static void prim()
	{
	int min = 999;
	int src = 0;
	for(int i = 0; i < n; i++)
	   {
	   for(int j = 0; j < n; j++)
	      {
	      if(cost[i][j] != 0 && cost[i][j] <= min)
	      	{
	      	min = cost[i][j];
	      	src = i;
	      	}
	      }
	   }
	for(int u = 0; u < n ; u++)
		{
		  distance[u] = cost[src][u];
		  visited[u] = 0;
		  parent[u] = src;
		}
	visited[src] = 1;
	distance[src] = 0;
	int k,count,sum;
	k = count = sum = 0;
	
	while(count < n-1)
		{
		  min = 999;
		  int u = 0;
		  for(int i = 0; i < n ; i++)
	  		{
	  			if((visited[i] == 0) && (distance[i] <= min))
	  				{
	  				  min = distance[i];
	  				  u = i;
	  				}
	  		}
	  	  mst[k][0] = u;
	  	  mst[k][1] = parent[u];
	  	  mst[k][2] = cost[u][parent[u]];
	  	  k++;
	  	  count++;
	  	  sum += cost[u][parent[u]];
	  	  visited[u] = 1;
	  	  for(int i = 0; i < n ; i++)
	  	  	{
	  	  	  if(visited[i] == 0 && cost[u][i] < distance[i])
	  	  	  	{
	  	  	  	   distance[i] = cost[u][i];
	  	  	  	   parent[i] = u;
	  	  	  	}
	  	  	}
	  	  }
	  	  if(sum >= 999)
	  	  	System.out.println("The spanning tree doesnot exists");
	  	  else
	  	  	{
	  	  	System.out.println("Minimum Cost Spanning Tree :- \n");
	  	  	for(int i = 0; i < k ; i++)
	  	  			System.out.println((mst[i][0] + 1)+" : "+(mst[i][1] + 1)+" = "+(mst[i][2]));		
			
			System.out.println("Minimum Cost: " + sum);
			}
		}

public static void main(String args[])
	{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number of vertices:\n");
	n = sc.nextInt();
	cost = new int[n][n];
	mst  = new int[n][n];
	distance = new int[n];
	visited = new int[n];
	parent = new int[n];
	System.out.println("Enter the cost:\nSource\tDestination\tCost:");
	read();
	prim();
	}
}
