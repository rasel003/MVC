package controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.net.*;

public interface InterfaceController{
		
		public void process(HttpServletRequest request,HttpServletResponse response,String view)throws IOException,ServletException;
		
}