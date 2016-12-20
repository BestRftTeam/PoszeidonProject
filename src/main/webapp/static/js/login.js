$("#login").click(function (){
	if (validateEmail($("#username").val())){
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
			alert("Rossz felhasználónév/jelszó!");
			 //alert("rossz");
			  //alert(responseText.responseText);
		  }
		});
	}else{
		alert("Email address is not valid");
	}
});

function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}
$("#registration").click(function(){
	$.ajax({
		  url: 'LoginToReg',
		  success: function(responseText){
			  //alert(responseText);
			  window.location.href = responseText;
			  
		  }
		});
});

