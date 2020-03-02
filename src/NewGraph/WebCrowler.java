package NewGraph;

import java.util.*;

public class WebCrowler {

	UrlFinder finder = new UrlFinder();

	String url;

	public WebCrowler(String url) {
		this.url = url;
	}

	public Graph<String> createGraph(int max_depth) {
		Graph<String> graph = new Graph<String>();
		createGraph(url, graph, new HashSet<Node<String>>(), max_depth);
		return graph;
	}

	private void createGraph(String url, Graph<String> graph, Set<Node<String>> visited, int max_depth) {
		if (max_depth == 0)
			return;
		List<String> listOfUrl = finder.getUrl(url);
		Node<String> fromNode = new Node<>(url);
		visited.add(fromNode);
		System.out.println(url);
		for (String connectedUrls : listOfUrl) {
			Edge<String> edge = new Edge<String>(fromNode, new Node<>(connectedUrls));
			graph.addEdge(edge);
		}
		for (String urll : listOfUrl) {
			if (!visited.contains(urll)) {
				createGraph(urll, graph, visited, max_depth - 1);
			}
		}
	}
}