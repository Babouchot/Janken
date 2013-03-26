<%-- 
    Document   : inscription
    Created on : 19 mars 2013, 13:41:47
    Author     : maureill
--%>

<%@ page language="java" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="janken.ejb.persistence.Gamer" %>
<%@ page import="janken.ejb.session.*" %>
<%@ page import="javax.naming.InitialContext" %>

<html>

<head><title>Inscription</title></head>

<body bgcolor="white">
<center>
<h2>Inscription à Janken :</h2>


<form method="post" action="/Janken-war/index.jsp">
<table border=10>
  <tr>
    <td>email : </td>
    <td><input type="text" name="mail" size="25" value=""></td>
  </tr>
  <tr>
    <td>pseudo : </td>
    <td><input type="text" name="pseudo" size="25" value=""></td>
  </tr>
  <tr>
    <td>mot de passe : </td>
    <td><input type="password" name="mdp" size="25" value=""></td>
  </tr>
</table>
<p>
<input type="submit" name="insc" value="S'inscrire">
<p>
</form>
</p>

<%
String mail = request.getParameter("mail");
String pseudo = request.getParameter("pseudo");
String mdp = request.getParameter("mdp");

if (mail != null && !"".equals(mail)) {
    try {
        InitialContext ic = new InitialContext();
        Object o = ic.lookup("java:comp/env/CustomerSessionLocal");
        GamerSessionLocal gamSession = (GamerSessionLocal) o;

        Gamer gamer = new Gamer(mail, pseudo, mdp);
        gamSession.persist(gamer);

    } catch(Exception e) {
        e.printStackTrace();
        out.println("Create Customer Failed : " + e.toString()); 
    } 
}
%>

<hr>
[<a href="/Janken-war/index.html">Accueil</a>]
</center>
</body>
</html>