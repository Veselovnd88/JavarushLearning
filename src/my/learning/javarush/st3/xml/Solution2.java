package my.learning.javarush.st3.xml;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/*
Комментарий внутри xml
*/

public class Solution2 {

    private static String[] escapeSymbols = {"<", ">", "'", "\"", "&"};

    public static String toXmlWithComment(Object obj, String tagName, String comment) {// передаем объект, тег и строку которую нужно вставить в комментарий
        try {
            return addCommentToTag(convertObjectToXML(obj), tagName, comment);//сюда передали сконвертированный в ксмл объект(строка) тег и коммент
        } catch (Exception ignored) {
            ignored.toString();
        }
        return null;
    }

    private static String addCommentToTag(String xml, String tagName, String comment) throws Exception {
        Document document = getDocument(xml);// сделали документ как объекты
        document.normalizeDocument();// проверяет узлы и слепляет их, нормализует

        addCdataBlocks(document, document.getDocumentElement());//второй параметр - возвращает рут. добавили блоки CDATA
        addComments(tagName, comment, document);

        StringWriter writer = new StringWriter();
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
        transformer.transform(new DOMSource(document), new StreamResult(writer));// эта конструкия трансформирует обратно в строку
        return writer.toString();
    }

    private static void addCdataBlocks(Document document, Node rootElement) {
        if (rootElement.hasChildNodes()) {// если у рута есть потомки
            NodeList childNodes = rootElement.getChildNodes();// получаем список потомков
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                addCdataBlocks(document, childNodes.item(i));// рекурсивно идет по дереву для каждого узла
            }
        } else {
            String textContent = rootElement.getTextContent();// получает содержание тега
            //System.out.println("TextContent " + textContent);
            if (containsEscapeSymbols(textContent)) {// проверяет на наличие символов, если они есть
                rootElement.setTextContent("");//сделал контент пустой строкой

                rootElement.getParentNode().appendChild(document.createCDATASection(textContent));//создали в этом разделе
                //секцию СИдейта
            }
        }
    }


    private static void addComments(String tagName, String comment, Document document) {
        NodeList nodeList = document.getElementsByTagName(tagName);//список всех узлов с указанным тегом
        for (int i = 0; i < nodeList.getLength(); i++) {
            Comment documentComment = document.createComment(comment);//создает комментарий
            documentComment.normalize();
            Node item = nodeList.item(i);
            item.getParentNode().insertBefore(documentComment, item);//вставляет комментарий перед узлом
        }
    }

    private static Document getDocument(String xml) throws Exception {// возвращает объектную модель документа, оно парсит xml
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();// фабрика по созданю объектов
        builderFactory.setNamespaceAware(true);// установка для xml
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();// по сути парсер документов
        return documentBuilder.parse(new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8)));//парсим - передали поток из байтов
    }


    private static String convertObjectToXML(Object o) throws Exception {
        StringWriter writer = new StringWriter();
        Marshaller marshaller = JAXBContext.newInstance(o.getClass()).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(o, writer);
        return writer.toString();// сконвертировали в xml
    }

    private static boolean containsEscapeSymbols(String s) {//проверка на содержание искейп символов
        if (s == null || s.isEmpty()) {
            return false;
        } else {
            for (String character : escapeSymbols) {
                if (s.contains(character))
                    return true;
            }
            return false;
        }
    }

    public static void task() throws Exception {
        AnExample obj = new AnExample();// создали экземпляр
        System.out.println(toXmlWithComment(obj, "needCDATA", "comment"));
    }

    @XmlType(name = "anExample")// аннотация добавляет первый тег с названием класса
    @XmlRootElement// рутовый тег, топ левел класс
    public static class AnExample {//класс для тестирования
        @XmlElement(name = "needCDATA", type = String.class)// аннотация доабвляется для определения списка из строк
        public String[] needCDATA = new String[]{"<needCDATA><![CDATA[need CDATA because of < <>& and >]]></needCDATA>", ""};
        //массив строк - первая тег с Сдата, вторая пустая строка
        public List<String> characters = new ArrayList<>();// в классе поле - список строк
    }

}

