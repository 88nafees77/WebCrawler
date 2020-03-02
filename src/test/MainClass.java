package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainClass {
	public static void main(String[] args) {
		String url = "https://google.com";
		Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
		Set<String> visited = new HashSet<>();
		Graph crawler = new Graph(url);
		int max_depth = 2;
		crawler.createGraphBfs(graph, visited, max_depth);
		System.out.println("MyGraph " + graph);

	}
}
