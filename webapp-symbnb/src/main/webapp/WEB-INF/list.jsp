<%-- 
    Document   : index
    Created on : 17 avr. 2020, 17:00:42
    Author     : Flo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <title>Nos annonces</title>
    </head>
    
    <body>
        
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#">SymBNB</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarColor01">
                <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="home">Accueil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="list">Annonces</a>
                </li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    
                    <!--
                    <li class="nav item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" id="accountDropdownLink" data-toggle="dropdown">
                            <img src="" class="avatar avatar-mini" alt="avatar de "> 
                        </a>

                        <div class="dropdown-menu dropdown-menu-right">
                            <a href="" class="dropdown-item">Créer une annonce</a>
                            <div class="dropdown-divider"></div>
                            <a href="" class="dropdown-item">Mon compte</a>
                            <a href="" class="dropdown-item">Mes réservations</a>
                            <a href="" class="dropdown-item">Modifier mon profil</a>
                            <div class="dropdown-divider"></div>
                            <a href="" class="dropdown-item">Déconnexion</a>
                        </div>
                    </li> 
                    -->
                    
                    <c:choose>
                        <c:when test="${ not empty sessionScope.userId }">
                            <li class="nav item">
                                <img src="http://placehold.it/30x30" style="width:30px;height:30px;border-radius:50%">
                                <p class="nav-link">Bonjour ${sessionScope.userId}</p>
                            </li>
                            <li class="nav item">
                                 <a class="nav-link" href="logout">Déconnexion</a>
                            </li>

                        </c:when>
                        <c:otherwise>
                           <li class="nav-item">
                               <a href="login" class="nav-link">Connexion</a>
                           </li>
                        </c:otherwise>
                    </c:choose>
                              
                </ul>
            </div>
        </nav>
        
        <div class="container">
            
            <h2 class="h1 my-5">Nos annonces</h2>

            <div class="row">


                <c:forEach items="${requestScope.annonces}" var="annonce">
                    <div class="col-md-4" id="annonce-${annonce.id}">
                        <div class="card card-bg-light mb-3">
                            <div class="card-header text-center">
                                ${annonce.rooms} chambres, <strong>${annonce.price}&euro; par nuit</strong> <br>
                                <small>Pas encore noté</small>
                            </div>

                            <img src="${annonce.coverImage}" alt="image de l'appartement" style="height:200px;width:100%;display:block">

                            <div class="card-body">
                                <h4 class="card-title">${annonce.title}}</h4>
                                <p class="card-text">
                                ${annonce.introduction}
                                </p>
                                <a href="#" class="btn btn-secondary">En savoir plus !</a>
                                <c:if test="${sessionScope.userId == annonce.author.id}">
                                    <a href="edit?id=${annonce.id}" class="btn btn-warning">Modifier</a>
                                    <a href="delete?id=${annonce.id}" class="btn btn-danger" data-target="#annonce-${annonce.id}">Supprimer</a>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>

        </div>
    <script src="js/app.js"></script>
    </body>
</html>
