import java.util.ArrayList;

public class Prob1{
	
	public ArrayList walkGraph(GNode n){
		ArrayList<GNode> a = new ArrayList<GNode>();
		addSubTree(null, n, a);
		return a;
	}
	
	public void addSubTree(GNode from, GNode n, ArrayList a){
		a.add(n);
		GNode[] c = n.getChildren();
		for(int i = 0; i < c.length; i++){
			if(c[i] == from)
				continue;
			addSubTree(n, c[i], a);
		}
	}
}