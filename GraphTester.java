import java.util.ArrayList;

public class GraphTester{
	
	public static void main(String args[]){
		//create some test graphs
		TestNode[][] graphs = new TestNode[4][];
		TestNode[] tempList;
		
		//graph 0
		graphs[0] = new TestNode[5];
		for(int i = 0; i < graphs[0].length	; i++)
			graphs[0][i] = new TestNode(""+i);
		
		int[][] adjList0 = {
			{1},
			{0,2},
			{1,3,4},
			{2},{2}
		};
		
		for(int i = 0; i < adjList0.length; i++){
			tempList = new TestNode[adjList0[i].length];
			for(int j = 0; j < adjList0[i].length; j++){
				tempList[j] = graphs[0][adjList0[i][j]];
			}
			graphs[0][i].setChildren(tempList);
		}
		
		//graph 1 (prob 2 example)
		graphs[1] = new TestNode[10];
		for(int i = 0; i < graphs[1].length	; i++)
			graphs[1][i] = new TestNode(""+(char)('A'+i));
		
		int[][] adjList1 = {
			{1,2,3},
			{0,4,5},
			{0,6,7,8},
			{0,9},
			{1},{1},
			{2},{2},{2},
			{3}
		};
		
		for(int i = 0; i < adjList1.length; i++){
			tempList = new TestNode[adjList1[i].length];
			for(int j = 0; j < adjList1[i].length; j++){
				tempList[j] = graphs[1][adjList1[i][j]];
			}
			graphs[1][i].setChildren(tempList);
		}
		
		//graph 2
		graphs[2] = new TestNode[13];
		for(int i = 0; i < graphs[2].length; i++){
			graphs[2][i] = new TestNode(""+i);
		}
		
		int[][] adjList2 = {
			{5},{5},{5},{5},{5},
			{0,1,2,3,4,6},
			{5,7},
			{6,8,9,10,11,12},
			{7},{7},{7},{7},{7}
		};
		
		for(int i = 0; i < adjList2.length; i++){
			tempList = new TestNode[adjList2[i].length];
			for(int j = 0; j < adjList2[i].length; j++){
				tempList[j] = graphs[2][adjList2[i][j]];
			}
			graphs[2][i].setChildren(tempList);
		}
		
		//graph 3 (single node graph)
		graphs[3] = new TestNode[1];
		graphs[3][0] = new TestNode("I");
		tempList = new TestNode[0];
		graphs[3][0].setChildren(tempList);
		
		//prob1
		Prob1 p1 = new Prob1();
		//prob2
		Prob2 p2 = new Prob2();
		
		//test points
		int[] testPoints = {1,0,3,0};
		//simulate
		for(int k = 0; k < graphs.length; k++){
			System.out.println("______Info for graph "+k+"____");
			System.out.println("-Walk Graph-");
			ArrayList<TestNode> a = (ArrayList<TestNode>)p1.walkGraph(graphs[k][testPoints[k]]);
			for(int i = 0; i < a.size(); i++){
				System.out.println("\t"+a.get(i));
			}
			
			System.out.println("-Paths-");
			ArrayList<ArrayList<TestNode>> a2 = 
				(ArrayList<ArrayList<TestNode>>)(p2.paths(graphs[k][testPoints[k]]));
			for(int i = 0; i < a2.size(); i++){
				for(int j = 0; j < a2.get(i).size(); j++){
					System.out.print(a2.get(i).get(j)+" ");
				}
				System.out.print("\n");
			}
		}
	}
	
	public static class TestNode implements GNode{
		String name;
		TestNode[] children;
		
		public TestNode(String name){
			this.name = name;
		}
		
		public String getName(){
			return name;
		}
		
		public GNode[] getChildren(){
			return children;
		}
		
		public void setChildren(TestNode[] children){
			this.children = children;
		}
		
		public String toString(){
			return name;
		}
	}
}