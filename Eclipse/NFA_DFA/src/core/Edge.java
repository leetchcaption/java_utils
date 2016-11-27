package core;

//图中的所有边,包括起点，终点和节点的内容
	public class Edge {

		protected Edge clone() {
			Edge edge=new Edge();
			edge.setEdgeName(this.getEdgeName());
			edge.setBeginIndex(this.getBeginIndex());
			edge.setEndIndex(this.getEndIndex());
			return edge;
		}

		public boolean equals(Object obj) {
			return edgeName.equals(((Edge)obj).getEdgeName());
		}

		public int hashCode() {
			return edgeName.hashCode();
		}

		private int beginIndex;
		private int endIndex;
		private String edgeName;

		public int getBeginIndex() {
			return beginIndex;
		}

		public String getEdgeName() {
			return edgeName;
		}

		public int getEndIndex() {
			return endIndex;
		}

		public void setBeginIndex(int beginIndex) {
			this.beginIndex = beginIndex;
		}

		public void setEdgeName(String edgeName) {
			this.edgeName = edgeName;
		}

		public void setEndIndex(int endIndex) {
			this.endIndex = endIndex;
		}
	}

