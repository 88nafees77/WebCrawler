package test;

public class MainClass {
	public static void main(String[] args) {
		String url = "https://www.geeksforgeeks.org/";
		Graph graph = new WebGraph(url);
		int max_depth = 4;
		graph.createGraph(max_depth);
		// graph.traverseGraph(url);
		System.out.println(graph.maxCycle(url));

	}
}
