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
      padding: 16px 8px;
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
      fone-size:18;
      }
      button:hover {
      opacity: 0.8;
      }
      .formcontainer {
      text-align: left;
      margin: 24px 50px 12px;
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
      /* Change styles for span on extra small screens */
      @media screen and (max-width: 300px) {
      span.psw {
      display: block;
      float: none;
      }
    </style>
  </head>
  <body>
    <form action="/login" method="POST">
      <h1>Login Form</h1>
      <p><font color="red">${errorMessage}</font></p>
      <div class="formcontainer">
      <hr/>
      <div class="container">
        <label for="uname"><strong>Id</strong></label>
        <input type="text" placeholder="Enter Id" name="name" required>
        <label for="psw"><strong>Password</strong></label>
        <input type="password" placeholder="Enter Password" name="password" required>
        <input list="usertype" type ="text" placeholder:"Enter your type" name ="usertype">
              <datalist id="usertype">
            <option value="Admin">
            <option value="Instructor">
            <option value="Student">
          </datalist>
      </div>
      <button type="submit">Login</button>
      </div>
    </form>
  </body>
</html>