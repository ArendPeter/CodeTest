import java.util.ArrayList;

public class Prob2{
	//wrapper method
	public ArrayList paths(GNode node){
		return paths(node, null);
	}
	
	//specialized method which will scan every path except the backtracking one
	public ArrayList paths(GNode node, GNode from){
		ArrayList<ArrayList<GNode>> myList = new ArrayList<ArrayList<GNode>>();
		GNode[] c = node.getChildren();
		//loop through children of current node
		for(int i = 0; i < c.length; i++){
			if(c[i] == from)
				continue;
			ArrayList<ArrayList<GNode>> childList = paths(c[i],node);
			//for every array of child lists add self to all lists and return
			//general case: add self to every list of child
			for(int j = 0; j < childList.size(); j++){
				childList.get(j).add(0,node);
				myList.add(childList.get(j));
			}
		}
		//null case: where the node either all has a parent for children or no children
		if(c.length == 0 || (c.length == 1 && c[0]==from)){
			ArrayList<GNode> temp = new <GNode>ArrayList();
			temp.add(node);
			myList.add(temp);
		}
		return myList;
	}
}