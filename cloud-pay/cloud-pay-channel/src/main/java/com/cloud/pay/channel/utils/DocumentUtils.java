package com.cloud.pay.channel.utils;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.cloud.pay.admin.util.ImgUtil;

/**
 * 基于w3c的document转换
 * @author wangy
 */
public class DocumentUtils {

	 private static Logger log = LoggerFactory.getLogger(DocumentUtils.class);
	
	 public static Document stringToDoc(String xmlStr) {    
	        //字符串转XML     
	        Document doc = null;    
	        try {    
	            xmlStr = new String(xmlStr.getBytes(),"UTF-8");    
	            StringReader sr = new StringReader(xmlStr);    
	            InputSource is = new InputSource(sr);    
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();    
	            DocumentBuilder builder;    
	            builder = factory.newDocumentBuilder();    
	            doc = builder.parse(is);    
	                
	        } catch (ParserConfigurationException e) {  
	            log.error(xmlStr);
	        } catch (SAXException e) {    
	        	log.error(xmlStr);    
	        } catch (IOException e) {
	        	log.error(xmlStr);   
	        }    
	        return doc;    
	    }  
	 
	 public static String docToString(Document doc) {    
	        // XML转字符串     
	        String xmlStr = "";    
	        try {    
	            TransformerFactory tf = TransformerFactory.newInstance();    
	            Transformer t = tf.newTransformer();    
	            t.setOutputProperty("encoding", "UTF-8");// 解决中文问题，试过用GBK不行     
	            ByteArrayOutputStream bos = new ByteArrayOutputStream();    
	            t.transform(new DOMSource(doc), new StreamResult(bos));    
	            xmlStr = bos.toString();    
	        } catch (TransformerConfigurationException e) {
	        	log.error("xml转换String失败：{}",e);
	        } catch (TransformerException e) {  
	        	log.error("xml转换String失败：{}",e);
	        }    
	        return xmlStr;    
	    }   
}
