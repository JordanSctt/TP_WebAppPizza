
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.1.1">
    <title>Page administrateur</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/floating-labels/">

    <!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="bootstrap.min.css">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="floating-labels.css" >
  </head>
  <body>
  
  
  <!-- FORMULAIRE : -->
  
  
    <form class="form-signin" action="remove" method="POST">
 	 <div class="text-center mb-4">
    	<img class="mb-4" src="images/admin.jpg" alt="livreur pizza">
   		<h1 class="h1 mb-3 font-weight-normal">Administration</h1>
   		<a type="button" class="btn btn-outline-primary center" href="accueil">Accueil</a>	
 	 </div>
		
		<c:set var="users" value = "${userList.users}"/>
		<c:forEach items="${users}" var="user">					
  			<div class="form-label-group">
    			<h3 class="h3 mb-3 font-weight-normal"><c:out value="${user.login}" /></h3>
 	 		</div> 	 		
 	 	<c:choose>
 	 		<c:when test = "${user.isAdmin()}">			
  				<button class="btn btn-lg btn-secondary btn-block">Admin - no acces</button>  
  				<br>
  			</c:when>			
  			<c:otherwise>
  				<button class="btn btn-lg btn-primary btn-block" name="userToRemove" type="submit" value="${user.login}">Supprimer</button>  
  				<br> 				
  			</c:otherwise>
  		</c:choose>
  		</c:forEach>
  	  	   
  	<p class="mt-5 mb-3 text-muted text-center">&copy; Famille Bros <br> since 1998</p>
	</form>	
</body>
</html>
