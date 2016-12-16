$("#login").click(function (){
	$.ajax({
		  type: "GET",
		  url: 'login',
		  data: {	Username: $("#username").val(),
					Password: $("#password").val() },
		  success: function(responseText){
			  //window.sessionStorage("username","$(\"#username\").val()");
			//  window.location.assign(/pages/);
			  //document.cookie = "username="+$("#username").val();
			  //alert(responseText);
			  //alert(document.cookie);
			  window.location.href = responseText;
		  },
		  error: function(responseText){
			//alert("Rossz felhasználónév/jelszó!");
			  alert("rossz");
			  alert(responseText.responseText);
		  }
		});
});
$("#registration").click(function(){
	$.ajax({
		  url: 'LoginToReg',
		  success: function(responseText){
			  //alert(responseText);
			  window.location.href = responseText;
			  
		  }
		});
});

