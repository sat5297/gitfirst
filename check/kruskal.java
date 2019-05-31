import java.util.*;
public class kruskal
{
	public static int [][] cost,mst;
	public static int n,m;
	public static int [] parent;

	public static void read()
	{
		Scanner sc = new Scanner(System.in);
		for(int i = 0 ; i < m ; i++)
		{
			System.out.print("\nFor Edge"+(i+1)+":-");
			System.out.print("\nSource: ");
			cost[i][0] = sc.nextInt();
			System.out.print("\nDestination: ");
			cost[i][1] = sc.nextInt();
			System.out.print("\nCost: ");
			cost[i][2] = sc.nextInt();
		}
	}

	public static int min_edge()
	{
		int min = 999;
		int pos = -1;
		for(int i = 0; i < m; i++)
		{
			if(cost[i][2] < min)
			{
				min = cost[i][2];
				pos = i;
			}
		}
	return pos;
	}

	public static int find_parent(int a)
	{
		while(parent[a] != a)
			a = parent[a];
	return a;
	}

	public static void union(int a,int b)
	{
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}

	public static void kruskal()
	{
		int count = 0,k = 0, sum = 0;
		for(int i = 0; i < n ; i++)
			parent[i] = i;

		while(count < (n-1))
		{
			int pos = min_edge();
			if(pos == -1)
				break;
			int u = cost[pos][0] - 1;
			int v = cost[pos][1] - 1;
			int i = find_parent(u);
			int j = find_parent(v);

			if(i != j)
			{
				mst[k][0] = u;
				mst[k][1] = v;
				mst[k][2] = cost[pos][2];
				k++;
				count++;
				sum += cost[pos][2];
				union(i,j);
			}
		cost[pos][2] = 999;
		}

		if(count == (n-1))
		{
			System.out.println("\n\nMinimum Spanning Tree\n");

			for(int i = 0; i < n-1; i++)
				System.out.println((mst[i][0] + 1)+":"+(mst[i][1] + 1) +"=" + mst[i][2]);
			System.out.println("Minimum Cost: " + sum);
		}
		else
			System.out.println("Minimum Spanning Tree doesnot exists\n");
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices: ");
		n = sc.nextInt();
		System.out.println("Enter the number of edges: ");
		m = sc.nextInt();
		cost = new int[m][3];
		mst = new int[n-1][3];
		parent = new int[n];
		System.out.println("Enter the details of each Edge: ");
		read();
		kruskal();
	}
}
