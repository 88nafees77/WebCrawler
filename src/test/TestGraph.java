package test;

import java.util.HashSet;

import NewGraph.Edge;
import NewGraph.Graph;
import NewGraph.Node;

public class TestGraph {

	public Graph<String> createGraph(int max_depth) {
		Graph<String> graph = new Graph<String>();
		graph.addEdge(new Edge<String>(new Node<String>("A"), new Node<String>("B")));
		graph.addEdge(new Edge<String>(new Node<String>("A"), new Node<String>("C")));
		graph.addEdge(new Edge<String>(new Node<String>("B"), new Node<String>("D")));
		graph.addEdge(new Edge<String>(new Node<String>("C"), new Node<String>("A")));
		graph.addEdge(new Edge<String>(new Node<String>("C"), new Node<String>("B")));
		graph.addEdge(new Edge<String>(new Node<String>("C"), new Node<String>("D")));
		graph.addEdge(new Edge<String>(new Node<String>("C"), new Node<String>("C")));
		graph.addEdge(new Edge<String>(new Node<String>("D"), new Node<String>("E")));
		graph.addEdge(new Edge<String>(new Node<String>("E"), new Node<String>("B")));
		graph.addEdge(new Edge<String>(new Node<String>("E"), new Node<String>("A")));
		return graph;
	}

}
