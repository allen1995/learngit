package com.allen.dayup.java8.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * @Auther: 20190598
 * @Date: 2020/7/8 11:19
 * @Description:
 */
public class XpathDemo {

    public static void main(String[] args) throws DocumentException {
        Document document = new SAXReader().read(new File("src\\main\\java\\com\\allen\\dayup\\java8\\dom4j\\user.xml"));
        String xpath = "//name";
        List<Node> list = document.selectNodes(xpath);

        for( Node node : list){
            System.out.println(node.getText());
        }

        String xpath2 = "//user[@id='001']";
        Element userElement = (Element) document.selectSingleNode(xpath2);
        System.out.println(userElement.getNamespace());
        System.out.println("data:" + userElement.getData());
    }
}
