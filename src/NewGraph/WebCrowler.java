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
		createGraph(url, graph, new HashSet<Vertex<String>>(), max_depth);
		return graph;
	}

	private void createGraph(String url, Graph<String> graph, Set<Vertex<String>> visited, int max_depth) {
		if (max_depth == 0) {
			System.out.println(max_depth + " " + url);
			return;
		}

		Set<String> listOfUrl = finder.getUrl(url);
		Vertex<String> fromNode = new Vertex<>(url);
		visited.add(fromNode);
		System.out.println(max_depth + " " + url);
		for (String connectedUrls : listOfUrl) {
			Edge<String> edge = new Edge<String>(fromNode, new Vertex<>(connectedUrls));
			graph.addEdge(edge);
		}
		for (String urll : listOfUrl) {
			if (!visited.contains(new Vertex<>(urll))) {
				createGraph(urll, graph, visited, max_depth - 1);
			} else {
				System.out.println("Already visited " + urll);
			}
		}
	}
}
