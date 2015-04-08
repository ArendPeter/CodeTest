import java.util.ArrayList;

public class GraphTester{
	
	public static void main(String args[]){
		//create some test graphs (didn't have time to make more)
		TestNode[][] graphs = new TestNode[1][];
		//graph 0
		graphs[0] = new TestNode[5];
		for(int i = 0; i < graphs[0].length	; i++)
			graphs[0][i] = new TestNode(""+i);
		
		TestNode[] tempList = new TestNode[1];
		tempList[0] = graphs[0][1];
		graphs[0][0].setChildren(tempList);
		
		tempList = new TestNode[2];
		tempList[0] = graphs[0][0];
		tempList[1] = graphs[0][2];
		graphs[0][1].setChildren(tempList);
		
		tempList = new TestNode[3];
		tempList[0] = graphs[0][1];
		tempList[1] = graphs[0][3];
		tempList[2] = graphs[0][4];
		graphs[0][2].setChildren(tempList);
		
		tempList = new TestNode[1];
		tempList[0] = graphs[0][2];
		graphs[0][3].setChildren(tempList);
		
		tempList = new TestNode[1];
		tempList[0] = graphs[0][2];
		graphs[0][4].setChildren(tempList);
		
		
		//test prob1
		Prob1 p1 = new Prob1();
		
		System.out.println("---Walk Graph---");
		ArrayList<GNode> a = p1.walkGraph(graphs[0][1]);
		for(int i = 0; i < a.size(); i++){
			System.out.println("\t"+a.get(i));
		}
		
		//test prob2
		Prob2 p2 = new Prob2();
		
		System.out.println("---Paths---");
		ArrayList<ArrayList<GNode>> a2 = p2.paths(graphs[0][1]);
		for(int i = 0; i < a2.size(); i++){
			for(int j = 0; j < a2.get(i).size(); j++){
				System.out.print(a2.get(i).get(j)+" ");
			}
			System.out.print("\n");
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