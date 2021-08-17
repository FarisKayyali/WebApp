<%@ page import ="java.util.List"%>
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

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
<h1>
Welcome ${name}
</h1>

<table>
  <tr>
    <th>CourseId</th>
    <th>Grade</th>
  </tr>
  <% List data= request.getAttribute("courses")==null?null:(List) request.getAttribute("courses");
   for(int i=0;i<data.size();i+=2){ %>
        <tr><td><%=data.get(i)%></td><td><%=data.get(i+1)%></td></tr>
   <%
        }

   %>

</table>

</body>
</html>