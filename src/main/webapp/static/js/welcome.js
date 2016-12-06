function Page(param){
	//alert(param);
	if ($("#framePage")) $("#framePage").remove(); 
	var frame = document.createElement("iframe");
	frame.setAttribute("src", param);
	frame.setAttribute("class","embed-responsive-item");
	frame.setAttribute("id","framePage");
	document.getElementById("pages_b").appendChild(frame);
}
/*
$("#courses").click(Page("Courses.html"));
$("#exams").click(Page("Exams.html"));
$("#test").click(Page("Test.html"));*/