<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>News Create</title>    
	<spring:url value="/resources" var="publicUrl" />
    <link href="${publicUrl}/bootstrap/css/bootstrap.min.css" rel="stylesheet">   
    <link href="${publicUrl}/bootstrap/css/theme.css" rel="stylesheet">

  </head>

  <body>

    <jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <h3 class="blog-title"><span class="label label-success">News Detail</span></h3>

	  <spring:url value="/news" var="newsSaveUrl" ></spring:url>
      <form action="${newsSaveUrl}/save" method="post">
        <div class="row">         
          <div class="col-sm-6">
            <div class="form-group">
              <label for="title">Title</label>             
              <input type="text" class="form-control" name="title" id="title" required="required"/>
            </div>
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="status">Status</label>             
              <select id="status" name="status" class="form-control">
                <option value="Activa">Active</option>
                <option value="Inactiva">Inactive</option>                
              </select>  
            </div>
          </div>
        </div>
        <div class="row"> 
          <div class="col-sm-12">
            <div class="form-group">
              <label for="detail">Detail</label>             
              <textarea class="form-control" name="detail" id="detail" rows="10"></textarea>
            </div>  
          </div>
        </div>

        <button type="submit" class="btn btn-danger" >Save</button>
      </form> 

      <hr class="featurette-divider">

      <jsp:include page="../includes/footer.jsp"></jsp:include>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${publicUrl}/bootstrap/js/bootstrap.min.js"></script> 
    <script src="${publicUrl}/tinymce/tinymce.min.js"></script>
    <script>
      tinymce.init({
          selector: '#detail',
          plugins: "textcolor, table lists code",
          toolbar: " undo redo | bold italic | alignleft aligncenter alignright alignjustify \n\
                    | bullist numlist outdent indent | forecolor backcolor table code"
      });
    </script>
  </body>
</html>
