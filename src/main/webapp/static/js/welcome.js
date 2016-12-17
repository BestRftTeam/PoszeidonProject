function Page(param){
	//alert(param);
	if ($("#framePage")) $("#framePage").remove(); 
	var frame = document.createElement("iframe");
	frame.setAttribute("src", param);
	frame.setAttribute("class","embed-responsive-item");
	frame.setAttribute("id","framePage");
	document.getElementById("pages_b").appendChild(frame);
}
function Logout(){
	$.ajax({
		url: "Logout",
		success: function(responseText){
			window.location.assign("../index.html");
		},
		error: function(responseText){
			alert(responseText.responseText);
		}
	});
	
}
$(document).ready(function(){
	$.ajax({
			url: "Welcome",
			success: function(responseText){
				//alert(responseText);
				var tmp = responseText.split("*");
				var tmp2 = tmp[1].split(";");
				for (var i = 0; i<tmp2.length-1;i++){
					if (tmp2[i]=="STUDENT"){
						document.getElementById("courses").style.visibility = "visible";
						document.getElementById("exams").style.visibility = "visible";
						document.getElementById("test").style.visibility = "visible";
						document.getElementById("statistic").style.visibility = "visible";	
					}
					if (tmp2[i]=="TEACHER"){
						document.getElementById("courses").style.visibility = "visible";
						document.getElementById("exams").style.visibility = "visible";
						document.getElementById("test").style.visibility = "visible";
					}
					if (tmp2[i]=="PARENT"){
						document.getElementById("statistic").style.visibility = "visible";
						document.getElementById("childrend").style.visibility = "visible";
					}
				}
				if (document.getElementById("courses").style.visibility==="hidden") $("#courses").remove();
				if (document.getElementById("exams").style.visibility==="hidden") $("#exams").remove();
				if (document.getElementById("test").style.visibility==="hidden") $("#test").remove();
				if (document.getElementById("statistic").style.visibility==="hidden") $("#statistic").remove();
				if (document.getElementById("children").style.visibility==="hidden") $("#children").remove();
			},
			error: function(responseText){
				alert(reponseText);
			},
			type: "GET"
	})
});
/*
$("#courses").click(Page("Courses.html"));
$("#exams").click(Page("Exams.html"));
$("#test").click(Page("Test.html"));*/