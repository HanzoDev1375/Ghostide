package ir.ninjacoder.ghostide.config;

import androidx.annotation.NonNull;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class JacksonFormatter {

  @NonNull
  public String formatYml(@NonNull String code) throws Exception {
    ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
    Map<String, Object> yamlMap = mapper.readValue(code, Map.class);
    String sortedYaml = mapper.writeValueAsString(yamlMap);
    return sortedYaml;
  }

  @NonNull
  public String formatProp(@NonNull String code) throws Exception {
    ObjectMapper mapper = new ObjectMapper(new JavaPropsFactory());
    Map<String, Object> sort = mapper.readValue(code, Map.class);
    String sortProp = mapper.writeValueAsString(sort);
    return sortProp;
  }

  public String formatXml(String xml) {
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(new InputSource(new StringReader(xml)));

      sortNode(document.getDocumentElement());

      Transformer transformer = TransformerFactory.newInstance().newTransformer();
      DOMSource source = new DOMSource(document);
      StreamResult result = new StreamResult(new StringWriter());
      transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
      transformer.setOutputProperty(OutputKeys.INDENT, "4");
      transformer.transform(source, result);

      return result.getWriter().toString();
    } catch (Exception e) {
      e.printStackTrace();
      return xml;
    }
  }

  private void sortNode(Node node) {
    if (node instanceof Element) {
      Element element = (Element) node;
      NodeList children = element.getChildNodes();

      List<Node> childNodes = new ArrayList<>();
      for (int i = 0; i < children.getLength(); i++) {
        Node child = children.item(i);
        childNodes.add(child);
      }

      childNodes.sort(Comparator.comparing(Node::getNodeName));

      for (Node child : childNodes) {
        element.removeChild(child);
      }

      for (Node child : childNodes) {
        element.appendChild(child);
      }
    }
  }
}
