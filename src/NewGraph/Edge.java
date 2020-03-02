package NewGraph;

public class Edge<T> {

	private Vertex<T> from;

	private Vertex<T> to;

	public Edge(Vertex<T> from, Vertex<T> to) {
		super();
		this.from = from;
		this.to = to;
	}

	public Vertex<T> getFrom() {
		return from;
	}

	public Vertex<T> getTo() {
		return to;
	}

}
