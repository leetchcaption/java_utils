package core;

// ͼ�еĽڵ�
	public class Node {
        private int index;
        private String nodeName;
        private boolean isBeginNode;
        private boolean isEndNode;

		public int getIndex() {
			return index;
		}
		
		public String getNodeName() {
			return nodeName;
		}
		
		public boolean isBeginNode() {
			
			return isBeginNode;
		}
		
		public boolean isEndNode() {
			return isEndNode;
		}

		public void setBeginNode(boolean isBeginNode) {
			this.isBeginNode = isBeginNode;
		}

		public void setEndNode(boolean isEndNode) {
			this.isEndNode = isEndNode;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public void setNodeName(String nodeName) {
			this.nodeName = nodeName;
		}
		
		//���ӿ�¡������ʹÿ�ο�¡�õ��Ķ�����һ���µĶ���
		@Override
		public Node clone() {
			Node node=new Node();
			node.setIndex(this.getIndex());
			node.setNodeName(this.getNodeName());
			node.setBeginNode(this.isBeginNode);
			node.setEndNode(this.isEndNode);
			return node;
		}
		
		//�����õ�hashSet������ϵĲ��ظ��ԣ�����hashCode��equals����
		@Override
		public boolean equals(Object obj) {
			return ((Node)(obj)).getIndex()==this.getIndex();
		}
		
		@Override
		public int hashCode() {
			return this.getIndex();
		}
	}