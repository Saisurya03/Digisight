<%@page import="java.util.Enumeration"%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>  
<%  
//String page1 = request.getParameter("fol");
//String dir = "e:/upload" + page1;

MultipartRequest m = new MultipartRequest(request, "e:/upload");  
Enumeration files = m.getFileNames();
while (files.hasMoreElements()){
   String name = (String) files.nextElement();
   String filename = m.getFilesystemName(name);
   out.print(filename + "<br>");
}
out.print("successfully uploaded");  
  
%>  