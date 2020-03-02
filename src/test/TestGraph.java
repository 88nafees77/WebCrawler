package test;

import NewGraph.Edge;
import NewGraph.Graph;
import NewGraph.Vertex;

public class TestGraph {

	public Graph<String> createGraph(int max_depth) {
		Graph<String> graph = new Graph<String>();
		graph.addEdge(new Edge<String>(new Vertex<String>("A"), new Vertex<String>("B")));
		graph.addEdge(new Edge<String>(new Vertex<String>("A"), new Vertex<String>("C")));
		graph.addEdge(new Edge<String>(new Vertex<String>("B"), new Vertex<String>("D")));
		graph.addEdge(new Edge<String>(new Vertex<String>("C"), new Vertex<String>("A")));
		graph.addEdge(new Edge<String>(new Vertex<String>("C"), new Vertex<String>("B")));
		graph.addEdge(new Edge<String>(new Vertex<String>("C"), new Vertex<String>("D")));
		graph.addEdge(new Edge<String>(new Vertex<String>("C"), new Vertex<String>("C")));
		graph.addEdge(new Edge<String>(new Vertex<String>("D"), new Vertex<String>("E")));
		graph.addEdge(new Edge<String>(new Vertex<String>("E"), new Vertex<String>("B")));
		graph.addEdge(new Edge<String>(new Vertex<String>("E"), new Vertex<String>("A")));
		return graph;
	}

}
