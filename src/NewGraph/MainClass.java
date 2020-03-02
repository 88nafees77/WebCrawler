package NewGraph;

public class MainClass {
	public static void main(String[] args) {
		String url = "https://www.swiggy.com/";
		WebCrowler crowler = new WebCrowler(url);
//		TestGraph crowler = new TestGraph();
		Graph<String> graph = crowler.createGraph(2);
		System.out.println(graph.hasEdge(new Vertex<String>(url), new Vertex<String>(url)));
		System.out.println(graph.maxCycle(new Vertex<String>(url)));

	}
}