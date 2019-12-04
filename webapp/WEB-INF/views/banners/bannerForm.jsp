<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="description" content="">
      <meta name="author" content="">
      <title>Banner Crete</title>    

	  <spring:url value="/resources" var="publicUrl"></spring:url>
	  <spring:url value="/banners/save" var="urlForm"></spring:url>

      <link href="${publicUrl}/bootstrap/css/bootstrap.min.css" rel="stylesheet">   
      <link href="${publicUrl}/bootstrap/css/theme.css" rel="stylesheet">

   </head>

   <body>

      <!-- Fixed navbar -->
      <nav class="navbar navbar-inverse navbar-fixed-top">
         <div class="container">
            <div class="navbar-header">
               <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
               </button>
               <a class="navbar-brand" href="#">My CineSite</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
               <ul class="nav navbar-nav">
                  <li><a href="#">Acerca</a></li>
                  <li><a href="#">Login</a></li>            
               </ul>
            </div><!--/.nav-collapse -->
         </div>
      </nav>

      <div class="container theme-showcase" role="main">

         <h3 class="blog-title"><span class="label label-success">Image data</span></h3>

         <form method="post" enctype="multipart/form-data" action="${urlForm}">
            <div class="row">         
               <div class="col-sm-6">
                  <div class="form-group">
                     <label for="title">Title</label>             
                     <input type="text" class="form-control" name="title" id="title" required="required"/>
                  </div>
               </div>


               <div class="col-sm-3">
                  <div class="form-group">
                     <label for="imageFile">Image</label>
                     <input type="file" id="imageFile" name="imageFile" required="required" />
                     <p class="help-block">recommended Size: 1140 x 250 </p>
                  </div> 
               </div> 

               <div class="col-sm-3">
                  <div class="form-group">
                     <label for="estatus">Status</label>             
                     <select id="estatus" name="status" class="form-control">
                        <option value="Active">Active</option>
                        <option value="Inactive">Inactive</option>                
                     </select>  
                  </div>
               </div>
            </div>

            <button type="submit" class="btn btn-danger" >Save</button>
         </form> 

         <hr class="featurette-divider">

         <!-- FOOTER -->
         <footer>        
            <p class="pull-right"><a href="#">Back to top</a></p>
            <p>&copy; 2017 My CineSite, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
         </footer>

      </div> <!-- /container -->

      <!-- Bootstrap core JavaScript
      ================================================== -->
      <!-- Placed at the end of the document so the pages load faster -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
      <script src="${publicUrl}/bootstrap/js/bootstrap.min.js"></script> 

   </body>
</html>
