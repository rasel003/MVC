package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.net.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class globalcontroller extends HttpServlet
{
	String dispatchURL = null;
    String requestURL = null;
        
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        	response.setContentType("text/html");
			PrintWriter out = response.getWriter();
            			
			requestURL  = request.getPathInfo();
            System.out.println("path Info: "+requestURL);
       
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	            Document doc = dBuilder.parse(getClass().getResourceAsStream("mvc.xml"));
	            doc.getDocumentElement().normalize();
				
				NodeList mvc = doc.getElementsByTagName("mvc");
				Element emp = null;
			   
				for(int i=0; i<mvc.getLength();i++){
					emp = (Element) mvc.item(i);
				   String  ctrl = emp.getElementsByTagName("ctrl-url").item(0).getTextContent();
			   
				   if(ctrl.equals(requestURL)){
						String  url = emp.getElementsByTagName("ctrl").item(0).getTextContent();
						String  view = emp.getElementsByTagName("view").item(0).getTextContent();
						 
						   dispatchURL = view;
						   System.out.println("value Matched :"+ctrl);
						   System.out.println("dispatch url: "+dispatchURL);
						   
						   String obj = url;
						 try{
							 InterfaceController con = (InterfaceController)Class.forName(obj).getConstructor().newInstance();
							 con.process(request,response,dispatchURL);
						 }
						 catch (Exception e) {
							e.printStackTrace();
						 }
				   }
				   else {
					System.out.println("This is from else");
				   }
				}             
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	   doGet(request, response);
    }
}