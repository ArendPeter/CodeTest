import java.util.ArrayList;

public class Prob2{
	public ArrayList paths(GNode node){
		return paths(node, null);
	}
	
	public ArrayList paths(GNode node, GNode from){
		ArrayList<ArrayList<GNode>> myList = new ArrayList<ArrayList<GNode>>();
		GNode[] c = node.getChildren();
		for(int i = 0; i < c.length; i++){
			if(c[i] == from)
				continue;
			ArrayList<ArrayList<GNode>> childList = paths(c[i],node);
			if(childList.size() == 0){
				ArrayList cList = new ArrayList();
				cList.add(node);
				cList.add(c[i]);
				myList.add(cList);
			}else{
				for(int j = 0; j < childList.size(); j++){
					childList.get(j).add(0,node);
					myList.add(childList.get(j));
				}
			}
		}
		return myList;
	}
}