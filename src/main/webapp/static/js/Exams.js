	function My_exams_F(){
		$.ajax({
			url:"Exams",
			type: "GET",
			async: false,
			success: function(responseText){
				if (responseText.length>4){
					var table = document.getElementById("exams_t");
					$.each($.parseJSON(responseText), function(k,v) {
						var tr = table.insertRow(-1);
						var td = tr.insertCell(0);
						td.id = "exams_"+v;
						td.innerHTML = v;
						td.onclick = Exam_F;
					});
				}else{}

			},
			error: function(responseText){
				alert(responseText.responseText);
			}	
		});
	}
	/* Egyenlőre ez nem így lesz, sőt biztos nem így lesz
	function Exam_F(){
		var exam_name = document.getElementById(this.id).innerHTML;
		window.sessionStorage.setItem("examname",exam_name);
		$.ajax({
			url: "exam",
			type:"GET",
			data: {examName: examname},
			success: function(responseText){
				if (responseText.length>4){
					var table = document.getElementById("exam_t");
					$.each($.parseJSON(responseText), function(k,v) {
							var tr = table.insertRow(-1);
							var td = tr.insertCell(0);
							td.id = "exam_"+k;
							td.innerHTML = v;
							if (document.getElementById("new_exam_name")===null){
								var row = table.insertRow(-1);
								var cell = row.insertCell(0);
								var but = document.createElement("BUTTON");
								but.id = "Startexam";
								but.innerHTML = "Startexam";
								but.onclick = StartExam_F;
								cell.appendChild(but);
						}
					});
				}else{
					
				
			}
		});
	}
*/
	
	$( document ).ready(function() {
		$.ajax({
			url: "GetRole",
			type: "GET",
			success: function(response){
				var tmp = response.split(";");
				for (var i = 0;i<tmp.length;i++){
					if (tmp[i]==="TEACHER"){
						var div = document.getElementById("exam_add");
						var input = document.createElement("input");
						input.id = "new_exam_name";
						var but = document.createElement("BUTTON");
						but.id = "but";
						but.innerHTML = "+";
						but.onclick = function(){
							if (document.getElementById("new_exam_name")!==""){
								$.ajax({
									url: "SaveExam",
									data: {Course_Name:document.getElementById("new_exam_name").value},
									type: "POST",
									success: function(responseText){
										var table = document.getElementById("exams_t");
										var newExam_r = table.insertRow(0);
										var newExam_c = newExam_r.insertCell(0);
										newExam_c.id = "exams_"+document.getElementById("new_exam_name").value;
										newExam_c.innerHTML = document.getElementById("new_exam_name").value;
										newExam_c.onclick = Exam_F;
										document.getElementById("new_exam_name").value = "";
									},
									error: function(responseText){
										
									}
								});
							}
						}
						div.appendChild(input);
						div.appendChild(but);
					}
				}
				
			},
			error: function(response){
				alert(response.responseText);
			}
		});
		My_exams_F();
		
	});