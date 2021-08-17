<%@ page import ="java.util.List"%>
<%@ page import ="java.util.ArrayList"%>
<html>
<head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
p{
    color: #aed17b;
}
button {
      background-color: #8ebf42;
      color: white;
      padding: 14px 0;
      margin: 10px 0;
      border: none;
      cursor: grabbing;
      width: 100%;
      }
tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
    <body>

    <form action="/instructorstudents" method="POST">
    <h1>
        <span name="course">${course}</span> grades
    </h1>
    <table>
      <tr>
        <th>Student Id</th>
        <th>Student Name</th>
        <th>Grade</th>
      </tr>
      <% List oldData = new ArrayList();
      List data= request.getAttribute("inSt")==null?null:(List) request.getAttribute("inSt");
      int count = 0;
       for(int i=0;i<data.size();i+=3){ count = i / 3;%>
            <tr>
            <td><%=data.get(i)%></td>
            <td><%=data.get(i+1)%></td>
            <td><input type="text" name="grade${count}"><p > old grade <%=data.get(i+2)%></p></td>
            </tr>
       <%
           count++; }

       %>
    <%
    String grade[]= new String[data.size()/3];
    for(int i=0;i<data.size()/3;i++){
    grade[i]=request.getParameter("grade"+i);
    }
    %>


    </table>
          <button type="submit" name="submit">submit</button>
          </form>
    </body>
</html>