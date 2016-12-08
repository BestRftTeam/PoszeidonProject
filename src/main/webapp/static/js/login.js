$("#login").click(function (){
	$.ajax({
		  type: "POST",
		  url: 'login',
		  data: {	Username: $("#username").val(),
					Password: $("#password").val() },
		  success: function(responseText){
			  window.sessionStorage("username","$(\"#username\").val()");
			//  window.location.assign(/pages/);
		  },
		  error: function(responseText){
			alert("Rossz felhasználónév/jelszó!");  
		  },
		  dataType: 'JSON'
		});
});
$("#registration").click(function(){
/*	$.ajax({
		  type: "GET",
		  url: 'register',
		});*/
});