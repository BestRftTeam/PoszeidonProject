$("#reg").click(function (){
	if (validateEmail($("#email").val())){
	if($("#password").val()!=""){
		if ($("#password").val()==$("#password_confirmation").val()){
			$.ajax({
				type: "POST",
				url: 'Register',
				data: {	
							First_Name: $("#first_name").val(),
							Last_Name: $("#last_name").val(),
							Email: $("#email").val(),
							Password: $("#password").val(),
							Role: $("#role").val()	
				},
				success: function(responseText){
					//alert("be");
					$.ajax({
						  url: 'RegToLogin',
						  success: function(responseText){
							  window.location.href = responseText;
						  }
						});
				},
				error: function(responseText){
					alert("You have filled something wrong");
					//alert(responseText.responseText);
				}
				});
		}else{
			alert("Password and confirmation code are not the same");
		}
	}else{
		alert("You haven't filled the password field");
	}
	}else{
		alert("Email address is not valid");
	}
});

function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}

$("#back").click(function(){
	//window.location.assign("../");
	$.ajax({
		  url: 'RegToLogin',
		  success: function(responseText){
			  //alert(responseText);
			  window.location.href = responseText;
			 
		  }
		});
});