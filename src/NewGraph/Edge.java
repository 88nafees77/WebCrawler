package NewGraph;

public class Edge<T> {

	private Node<T> from;

	private Node<T> to;

	public Edge(Node<T> from, Node<T> to) {
		super();
		this.from = from;
		this.to = to;
	}

	public Node<T> getFrom() {
		return from;
	}

	public Node<T> getTo() {
		return to;
	}

}
