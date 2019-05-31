import java.util.*;

public class hamil
{
public static int[] graph[],path;
public static int n,cycle_count = 0;

public static void readAndInit()
{
	Scanner sc = new Scanner(System.in);
	graph = new int[n][n];
	for(int i = 0; i < n ; i++)
	{
		for(int j = 0; j < n;j ++)
			graph[i][j] = sc.nextInt();
		System.out.print("\t");
	}
	path = new int[n];
	for(int i = 0; i < n ; i++)
		path[i] = -1;
	path[0] = 0;
}

public static int nextValue(int pos,int v)
{
	if(graph[path[pos-1]][v] == 0)
		return 0;
	for(int i = 0; i < pos; i++)
	{
		if(path[i] == v)
			return 0;
	}
	return 1;
}

public static int hamiltonian(int pos)
{
	if(pos == n)
	{
		if(graph[path[pos-1]][0] == 1)
		{
			cycle_count++;
			System.out.print("\nCycle " + cycle_count + ":");
			
			for(int i = 0; i < n; i++)
					System.out.print((path[i] + 1) + " ---> ");
			System.out.println("1");

			return 1;
		}
		else
			return 0;
	}

	for(int v = 1; v < n; v++)
	{
		if(nextValue(pos,v) == 1)
		{
			path[pos] = v;
			if(hamiltonian(pos + 1) == 1)
				continue;
		}
		path[pos] = -1;
	}
	if(cycle_count == 0)
		return 0;
	else
		return 1;
}

public static void main(String args[])
{
	Scanner sc = new Scanner(System.in);
	System.out.println("\nWelcome\nEnter:\nNumber of vertices:");
	n = sc.nextInt();
	System.out.print("(" + n + "X" + n + ") Adjacency Matrix \n\t" );
	readAndInit();
	if(hamiltonian(1) == 0)
		System.out.println("PAth not present");
}
}