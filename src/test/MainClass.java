package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainClass {
	public static void main(String[] args) {
		String url = "https://google.com";
		Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
		Set<String> visited = new HashSet<>();
		WebGraph webGraph = new WebGraph();
		int max_depth = 2;
		// webGraph.createGraphBfs(url, graph, visited, max_depth);
		System.out.println("MyGraph " + graph);
		graph.put("A", new HashSet<String>(Arrays.asList("B", "D")));
		graph.put("B", new HashSet<String>(Arrays.asList("C")));
		graph.put("C", new HashSet<String>(Arrays.asList("E")));
		graph.put("E", new HashSet<String>(Arrays.asList("B", "A")));
		graph.put("D", new HashSet<String>(Arrays.asList("D", "B", "A", "C")));
		System.out.print(webGraph.maxCycle("A", graph, new HashMap<String, Integer>(), 0));

	}
}
