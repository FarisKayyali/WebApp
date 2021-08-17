<%@ page import ="java.util.List"%>
<html>
  <head>
    <title>WebApp</title>
    <style>
      html, body {
      display: flex;
      justify-content: center;
      font-family: Roboto, Arial, sans-serif;
      font-size: 15px;
      }
      form {
      border: 5px solid #f1f1f1;
      }
      input[type=text], input[type=password] {
      width: 100%;
      padding: 16px 100px;
      margin: 8px 0;
      display: inline-block;
      border: 1px solid #ccc;
      box-sizing: border-box;
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
      h1 {
      text-align:center;
      }
      h2 {
      text-align:center;
      font-size:20;
      }
      button:hover {
      opacity: 0.8;
      }
      .formcontainer {
      text-align: left;
      margin: 24px 150px 12px;
      }
      .container {
      padding: 16px 0;
      text-align:left;
      }
      span.psw {
      float: right;
      padding-top: 0;
      padding-right: 15px;
      }
      @media screen and (max-width: 300px) {
      span.psw {
      display: block;
      float: none;
      }
    </style>
  </head>
  <body>
    <form action="/instructorcourses" method ="POST">
      <h1>Welcome ${name}</h1>
      <h2>select course</h2>
      <div class="formcontainer">
      <hr/>
      <div class="container">
        <input list="course" type ="text" placeholder:"Enter your type" name ="course">
                      <datalist id="course">
          <% List data= request.getAttribute("courses")==null?null:(List) request.getAttribute("courses");
           for(int i=0;i<data.size();i++){ %>
                <option><%=data.get(i).toString()%></option>
           <%
                }

           %>

                  </datalist>

      </div>
      <button type="submit" name="getStudents">Get students grade</button>
      </div>
    </form>

  </body>
</html>