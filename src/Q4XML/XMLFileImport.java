package Q4XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

// 1. XML File 불러오기 : 단순 출력
public class XMLFileImport {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        try {
            //File file = new File("C:\\Users\\pciio\\IdeaProjects\\JavaStudy\\CompanyXML.xml");
            // 1. 빌드팩토리 생성
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // 2. 빌드팩토리의 빌더 생성
            DocumentBuilder db = dbf.newDocumentBuilder();
            // 3. 빌더를 통해 XML 파일 파싱 후 Document 생성
            Document document = db.parse(new File("C:\\Users\\pciio\\IdeaProjects\\JavaStudy\\CompanyXML.xml"));
            //Element rootEl = document.getDocumentElement();
            //document.getDocumentElement().normalize();
            // 4. Root 엘리먼트 확인 출력
            System.out.println("Root Element :" + document.getDocumentElement().getNodeName());
            // 5. Document의 company 리스트를 가져옴
            NodeList nList = document.getElementsByTagName("company");
            System.out.println("----------------------------");
            // 6. 가져온 company 리스트를 반복문을 통해 출력
            for (int temp = 0; temp < nList.getLength(); temp++) {
                // 7. 리스트의 한 데이터를 가져옴
                Node nNode = nList.item(temp);
                //System.out.println("\nCurrent Element :" + nNode.getNodeName() + " " + temp + "번");
                System.out.println("\n--- " + nNode.getNodeName() + " " + (temp+1) + " 번---");
                // 8. 가져온 태그의 타입이 엘리먼트일 때 내용 출력
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    // 9. 해당 태그를 엘리먼트로 형변환
                    Element eElement = (Element) nList.item(temp);
                    //System.out.println(eElement + "확인");
                    // 10. 엘리먼트의 속성 출력
                    System.out.println("Company name : " + eElement.getAttribute("name"));
                    System.out.println("Company ceo : " + eElement.getAttribute("ceo"));
                    System.out.println("Company address : " + eElement.getAttribute("address"));
                    System.out.println("Company emp-count : " + eElement.getAttribute("emp-count"));
                    System.out.println("Company industry : " + eElement.getAttribute("industry"));
                    System.out.println("Company foundation-day : " + eElement.getAttribute("foundation-day"));
                    System.out.println("Company homepage : " + eElement.getAttribute("homepage"));

                    //System.out.println("First Name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                    //System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    //System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
                }
            }
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
