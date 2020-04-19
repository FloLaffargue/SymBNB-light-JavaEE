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
        <title>Modification de la page ${annonce.title}</title>
    </head>
    <body>
        <h1>Modifier l'annonce ${annonce.title}</h1>
        
        <div class="container">
            <form method="post">    
               <div class="form-group">
                   <label for="title">Titre</label>
                   <input type="text" name="title" class="form-control" placeholder="Titre" value="${annonce.title}" required>
               </div>
               <div class="form-group">
                   <label for="slug">Slug</label>
                   <input type="text" name="slug" placeholder="Slug" class="form-control" value="${annonce.slug}" required>
               </div>
                <div class="form-group">
                   <label for="slug">Prix</label>
                   <input type="text" name="price" placeholder="Slug" class="form-control" value="${annonce.price}" required>
               </div>
                <div class="form-group">
                   <label for="slug">Intro</label>
                   <input type="text" name="introduction" placeholder="Slug" class="form-control" value="${annonce.introduction}"required>
               </div>
               <div class="form-group">
                   <label for="slug">Contenu</label>
                   <input type="text" name="content" placeholder="Slug" class="form-control" value="${annonce.content}" required>
               </div>
               <div class="form-group">
                   <label for="slug">Image</label>
                   <input type="text" name="coverImage" placeholder="Slug" class="form-control" value="${annonce.coverImage}" required>
               </div>
               <div class="form-group">
                   <label for="slug">Chambres</label>
                   <input type="number" name="rooms" placeholder="Slug" class="form-control" value="${annonce.rooms}" required>
               </div>

               <div class="form-group">
                   <button type="submit" class="btn btn-success">Enregistrer !</button>
               </div>
               <input type="hidden" name="id" value="${annonce.id}"
            </form>
        </div>
        
    </body>
</html>
