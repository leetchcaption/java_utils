package core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Converter {

	public static FA NFAConvertToDFA(FA nfa) {
        List<MySet> left=getLeftSetList(nfa);
        //为每一个左边的集合取一个名字
        System.out.println("转换成的DFA如下：");
        System.out.print("状态集为:     {");
        for(int i=0;i<left.size();i++){
        	left.get(i).setSetName("A"+i);
        	System.out.print("A"+i+"   ");
        }
        System.out.println("}");
        
        //纪录终态集
        System.out.print("终态集为:     {");
        for(int i=0;i<left.size();i++){
        	//如果集合中包含了一个终态，则此集合为终态
        	MySet mySet=left.get(i);
        	Iterator<Node> iterator1=mySet.iterator();
        	boolean hasFound=false;
        	while(iterator1.hasNext()){
        		String name1=iterator1.next().getNodeName();
        		for(int j=0;j<nfa.getNodes().size();j++){
        			if(nfa.getNodes().get(j).isEndNode()&&name1.trim().equals(nfa.getNodes().get(j).getNodeName().trim())){
        				hasFound=true;
        				break;
        			}
        		}
        		if(hasFound)
        			break;
        	}
        	if(hasFound){
        		System.out.print(left.get(i).getSetName()+"  ");
        	}
        }
        System.out.println("}");
        
        //输出所有的边
        System.out.println("所有的转换方式为：   ");
        for(int i=0;i<left.size();i++){
        	Set<Edge> e = nfa.getAllDifferentEdge(nfa);
			Iterator<Edge> edgeIterator = e.iterator();
			while(edgeIterator.hasNext()){
				Edge edge=edgeIterator.next();
				Set<Node> nodes = nfa.getAllStateCrossEmptyAEmpty(left.get(i),
						edge.getEdgeName());
				MySet myset=new MySet().SetConvertToMySet(nodes);
				//如果右边的集合不为空，在左边去找那个相同的并取名字
				if(!myset.isEmpty()){
					for(int k=0;k<left.size();k++){
						if(myset.equals(left.get(k))){
							myset.setSetName(left.get(k).getSetName());
							System.out.println(left.get(i).getSetName()+"---"+edge.getEdgeName()+"--->"+myset.getSetName());
							break;
						}
					}
				}
			}
        	
        }
		return null;
	}

	public static List<MySet> getLeftSetList(FA nfa) {
		
		// 首先得到从初始状态经过若干条&符得到的状态集
		int beginIndex = nfa.getBeginNode().getIndex();
		Set<Node> s = nfa.getStateSetcrossAnyEmpty(beginIndex);

		ArrayList<MySet> list = new ArrayList<MySet>();
		list.add(new MySet().SetConvertToMySet(s));
		//计数器
		int i=0;
		while(i<list.size()){
			Set<Edge> e = nfa.getAllDifferentEdge(nfa);
			Iterator<Edge> edgeIterator = e.iterator();
			while (edgeIterator.hasNext()) {
				Edge ed = edgeIterator.next();
				Set<Node> nodes = nfa.getAllStateCrossEmptyAEmpty(list.get(i),
						ed.getEdgeName());
				MySet myset = new MySet().SetConvertToMySet(nodes);
				
				// 如果在右边出现的集合不为空并且在左边没出现过，则加上
				if (!myset.isEmpty()) {
					boolean hasFound = false;
					for (int k = 0; k < list.size(); k++) {
						if (list.get(k).equals(myset)) {
							hasFound = true;
							break;
						}
					}
					if (!hasFound) {
						list.add(myset);
					}
				}
			}
			i++;
		}
		return list;
	}
}
