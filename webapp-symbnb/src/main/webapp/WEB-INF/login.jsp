<%-- 
    Document   : annonce_edit
    Created on : 17 avr. 2020, 17:48:05
    Author     : Flo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css">
        <title>Connexion</title>
    </head>
    <body>
        <h1>Connectez-vous !</h1>
        
        <div class="container">
            
            <c:if test="${ not empty requestScope.error }">
                  <div class="alert alert-warning">
                    ${requestScope.error}
                   </div>
            </c:if>
            
            <form method="post">    
               <div class="form-group">
                   <label for="title">Login</label>
                   <input type="text" name="login" class="form-control" placeholder="Titre" value="${annonce.title}" required>
               </div>
               <div class="form-group">
                   <label for="slug">Mot de passe</label>
                   <input type="password" name="password" placeholder="Slug" class="form-control" value="${annonce.slug}" required>
               </div>

               <div class="form-group">
                   <button type="submit" class="btn btn-success">Enregistrer !</button>
               </div>
            </form>
        </div>
        
    </body>
</html>
