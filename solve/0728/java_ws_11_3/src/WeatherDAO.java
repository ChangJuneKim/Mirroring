import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class WeatherDAO {
	private List<Weather> list = new ArrayList<>();

	private DocumentBuilderFactory factory = null;
	private DocumentBuilder builder = null;
	private Document doc = null;

	public WeatherDAO() {

	}

	public void connectXML() {
		final String uri = "http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2650073000";
		try {
			this.factory = DocumentBuilderFactory.newInstance();
			this.builder = factory.newDocumentBuilder();

			// 문서 로딩 완료
			this.doc = builder.parse(uri);
		} catch (IOException | ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}
	}

	public List<Weather> getWeatherList() {
		connectXML();

		// 최상위 element
		Element root = doc.getDocumentElement();

		// data 태그에 우리가 필요로 하는 정보가 있음
		NodeList weatherInfo = root.getElementsByTagName("data");

		// data 태그들 만큼 순회
		for (int i = 0; i < weatherInfo.getLength(); ++i) {
			// data 태그 하나
			Node child = weatherInfo.item(i);

			// 날씨 객체 만들고
			Weather w = new Weather();

			// data 객체의 자식 객체들로 이루어진 nodeList 생성
			NodeList subNodes = child.getChildNodes();

			// subNodes 순회
			for (int j = 0; j < subNodes.getLength(); ++j) {
				Node sub = subNodes.item(j);
				
				// text 노드는 안봐도 됨
				if (sub.getNodeName().equals("#text"))
					continue;

//				System.out.println("getNodeName : " + sub.getNodeName());
//				System.out.println("getTextContent : " + sub.getTextContent());

				if (sub.getNodeName().equals("hour")) { // 시간
					w.setHour(Integer.parseInt(sub.getTextContent()));
				} else if (sub.getNodeName().equals("temp")) { // 온도
					w.setTemp(Double.parseDouble(sub.getTextContent()));
				} else if (sub.getNodeName().equals("wfKor")) { // 날씨
					w.setWfKor(sub.getTextContent());
				} else if (sub.getNodeName().equals("reh")) { // 습도
					w.setReh(Integer.parseInt(sub.getTextContent()));
				}
			}
			list.add(w);
		}

		return list;
	}

}
