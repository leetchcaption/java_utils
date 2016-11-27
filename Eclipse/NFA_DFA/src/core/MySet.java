package core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//MySet��һ�����ϣ����ҿ��Լ�¼������ϵ����ƣ��������ж����������Ƿ���ȣ���������equals����
public class MySet extends HashSet<Node> {
	private static final long serialVersionUID = 2700158967541967614L;
	private String setName;

	@Override
	public boolean equals(Object o) {
		@SuppressWarnings("unchecked")
		HashSet<Node> s = (HashSet<Node>)o;
		if (s.size() != this.size()) {
			return false;
		} else {
			Iterator<Node> iterator = s.iterator();
			while (iterator.hasNext()) {
				if (!this.contains(iterator.next())) {
					return false;
				}
			}
			return true;
		}
	}

	public String getSetName() {
		return setName;
	}

	public void setSetName(String setName) {
		this.setName = setName;
	}
	
	//override toString method,�������һ������
	public String toString(){
		String s="{";
		Iterator<Node> iterator=this.iterator();
		while(iterator.hasNext()){
			s=s+iterator.next().getNodeName()+"  ";
		}
		s+="}";
		return s;
	}
	
	//��һ��Setת����һ��MySet
	public  MySet SetConvertToMySet(Set<Node> set){
		Iterator<Node> iterator=set.iterator();
		while(iterator.hasNext()){
			this.add(iterator.next());
		}
		return this;
	}
 }
