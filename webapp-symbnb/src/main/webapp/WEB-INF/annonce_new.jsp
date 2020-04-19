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
        <title>Ajout d'une annonce</title>
    </head>
    <body>
        <h1>Ajout d'une annonce</h1>
        
        <div class="container">
            <form method="post">    
               <div class="form-group">
                   <label for="title">Titre</label>
                   <input type="text" name="title" class="form-control" placeholder="Titre" required>
               </div>
               <div class="form-group">
                   <label for="slug">Slug</label>
                   <input type="text" name="slug" placeholder="Slug" class="form-control" required>
               </div>
                <div class="form-group">
                   <label for="slug">Prix</label>
                   <input type="text" name="price" placeholder="Slug" class="form-control"required>
               </div>
                <div class="form-group">
                   <label for="slug">Intro</label>
                   <input type="text" name="introduction" placeholder="Slug" class="form-control" required>
               </div>
               <div class="form-group">
                   <label for="slug">Contenu</label>
                   <input type="text" name="content" placeholder="Slug" class="form-control" required>
               </div>
               <div class="form-group">
                   <label for="slug">Cover image</label>
                   <input type="text" name="coverImage" placeholder="Slug" class="form-control" required>
               </div>
               <div class="form-group">
                   <label for="slug">Chambres</label>
                   <input type="number" name="rooms" placeholder="Slug" class="form-control" required>
               </div>
                
                
               <h4>Image(s)</h4> 
               <div class="form-group">
                   <label for="slug">Url</label>
                   <input type="text" name="url" placeholder="url" class="form-control" required>
                   <label for="slug">Caption</label>
                   <input type="text" name="caption" placeholder="caption" class="form-control" required>
               </div>
               
               <div class="form-group">
                   <button type="submit" class="btn btn-success">Enregistrer !</button>
               </div>
                
                
            </form>
        </div>
        
    </body>
</html>
