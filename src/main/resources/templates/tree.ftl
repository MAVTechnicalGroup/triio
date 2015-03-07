<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" media="all" href="/stylesheets/styles.css"/>
        <link rel="stylesheet" type="text/css" media="all" href="/bootstrap3.3.2/css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" media="all" href="/stylesheets/animate.css"/>
        <link rel="stylesheet" type="text/css" media="all" href="/stylesheets/hover.css" />
 
        <script src="/js/traditionalTreeFunction.js" type="text/javascript"></script>       
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		

        <script type="text/javascript">
		$(window).load(function(){
        	$('#uidModal').modal('show');
   		 });
		</script>

        <title>Triio | Traditional Trees</title>
    </head>
    
    <body class="container_wrapper">
		<header>
    		<div class="row">
    			<nav class="navbar navbar-default">
    				<div class="container-fluid">
    					<div class="navbar-header" style="vertical-align:middle;">
    						<a href="/index.html"><img src="/assets/triio.png" alt="Triio" width="95"></a>
    					</div>
    					<div>
    						<ul class="nav navbar-nav navbar-right">
    							<li><a href="/index.html">Home</a></li>
    							<li class="active"><a href="/trees.html">Trees</a></li>
    							<li><a href="http://cs480-projects.github.io/teams/MAV/green.html">About Us</a></li>
    						</ul>
    					</div>
    				</div>
    			</nav>
            </div>
		</header>

        <div class="row">
        	<div class="col-sm-12">
        		<p>Tree displayed here.</p>
			    <!-- Modal HTML -->
			    <div id="uidModal" class="modal fade">
			        <div class="modal-dialog">
			            <div class="modal-content">
			                <div class="modal-header">
			                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			                    <h4 class="modal-title">Success!</h4>
			                </div>
			                <div class="modal-body">
			                	<p>This is your UID: ${tree.getUID()}</p>
			                    
			                    <p>Keep this UID handy so you can view and edit your tree later!</p>
			                </div>
			                <div class="modal-footer">
			                    <button type="button" class="submit btn btn-default" data-dismiss="modal">Close</button>			                </div>
			            	</div>
			        </div>
			    </div>
        	</div>
        </div>

       	<footer class="row">
        	<div class="col-sm-12">
                <hr />
                <p>&copy;2015 <a href="http://cs480-projects.github.io/teams/MAV/green.html">MAV Technical Group</a></p>
            </div>
            <div class="clear"></div>
       	</footer>
    </body>
</html>