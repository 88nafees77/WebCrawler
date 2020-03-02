package NewGraph;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class UrlFinder {
	public List<String> getUrl(String currentUrl) {
		List<String> urls = new ArrayList<String>();
		try {
			Connection connection = Jsoup.connect(currentUrl);
			Document htmlDocument = connection.get();
			Elements linksOnPage = htmlDocument.select("a[href]");
			for (Element element : linksOnPage) {
				urls.add(element.absUrl("href"));
			}
			return urls;
		} catch (Exception e) {
		}
		return urls;
	}

}
