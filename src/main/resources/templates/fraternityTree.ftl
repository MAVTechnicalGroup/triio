<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" media="all" href="/stylesheets/styles.css"/>
        <link rel="stylesheet" type="text/css" media="all" href="/bootstrap3.3.2/css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" media="all" href="/stylesheets/animate.css"/>
        <link rel="stylesheet" type="text/css" media="all" href="/stylesheets/hover.css" />
 
        <script src="/js/fraternityTreeFunction.js" type="text/javascript"></script>       
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
		

        <script type="text/javascript">
		$(window).load(function(){
        	$('#uidModal').modal('show');
   		 });
   		 
   		 $(document).ready(function(){
			$(".addMember").click(function(){
				$("#addMemberModal").modal('show');
			});
		});
   		 
		</script>

        <title>Triio | Fraternity Trees</title>
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
        		<button class="addMember btn">Add Member</button>
       			<table class="table table-hover table-striped">
       				<thead>
						<tr>
							<td>Name</td>
							<td>Gender</td>
							<td>Chapter</td>
							<td>Line</td>
							<td>Class</td>
							<td>Big</td>
							<td>Little(s)</td>
						</tr>
					</thead>
					<tbody>
						<#list tree.getNodeMap()?keys as uid>
							<tr>
								<td>${tree.getNodeMap()[uid].getFirstName()} ${tree.getNodeMap()[uid].getLastName()}</td>
								<td>${tree.getNodeMap()[uid].getGender()}</td>
								<td>${tree.getNodeMap()[uid].getChapter()}</td>
								<td>${tree.getNodeMap()[uid].getLine()}</td>
								<td>${tree.getNodeMap()[uid].getCrossingClass()}</td>
								<td>
									<#assign big = tree.getNodeMap()[uid].getBig()>
									<#if big != "">
										 ${tree.getNodeMap()[big].getFirstName()} ${tree.getNodeMap()[big].getLastName()}
									</#if>
								</td>
								<td>
									<#list tree.getNodeMap()[uid].getLittles() as little>
										${tree.getNodeMap()[little].getFirstName()} ${tree.getNodeMap()[little].getLastName()}<br />
									</#list>
								</td>
							</tr>
						</#list>
					</tbody>
				</table>

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
			    
			    
			    <div id="addMemberModal" class="modal fade">
			        <div class="modal-dialog">
			            <div class="modal-content">
			                <div class="modal-header">
			                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			                    <h4 class="modal-title">Add Member</h4>
			                </div>
			                <div class="modal-body">
			                    <form>
			                    	<p>First Name: <input class="input-sm" type="text" name="input_firstName"></p>
			                    	<p>Last Name: <input class="input-sm" type="text" name="input_lastName"></p>
			                    	<p>Gender: <input class="input-sm" type="text" name="input_gender"></p>
			                    	<p>Chapter: <input class="input-sm" type="text" name="input_chapter"></p>
			                    	<p>Line: <input class="input-sm" type="text" name="input_line"></p>
			                    	<p>Class: <input class="input-sm" type="text" name="input_class"></p>
			                    	<p>Big:
				                    	<select name="input_big" class="form-control">
				                    		<option value=""></option>
					                    	<#list tree.getNodeMap()?keys as uid>
					                    		<option value="${uid}">${tree.getNodeMap()[uid].getFirstName()} ${tree.getNodeMap()[uid].getLastName()}</option>
					                    	</#list>
					                    </select>
					                </p>
			                    </form>
			                </div>
			                <div class="modal-footer">
			                    <button type="button" class="submit btn btn-default" onclick="addFraternityFamilyMember(${tree.getUID()})">Add Member</button>
			                </div>
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