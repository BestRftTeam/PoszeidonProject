	$( document ).ready(function() {
		$.ajax({
				url: "GetRole",
				type: "GET",
				success: function(responseText){
					var tmp = responseText.split(";");
					var table = document.getElementById("exams_t");
					if (tmp[0]==="STUDENT"){
						StudentStat();
						My_Exams_F();
					}
					
				},
				error: function(reponseText){
					
				}
		});
	});
	
	function StudentStat(){
		 google.charts.load("current", {packages:['corechart']});
		 google.charts.setOnLoadCallback(drawChart);
		 function drawChart(){
			$.ajax({
				url: "StudentStat",
				async: false,
				type: "GET",
				success: function(responseText){
					//alert(responseText);
					var table = document.getElementById("exam_t");
					var row = table.insertRow(-1);
					var cell = row.insertCell(0);
	    		    var data = new google.visualization.DataTable();
	                data.addColumn('string', 'Teszt Name');
	                data.addColumn('number', 'Score');
	                data.addColumn('number', 'Max Score');
					$.each($.parseJSON(responseText), function(k,v) {
		                data.addRow([v.ExamName,parseInt(v.Score),parseInt(v.MaxScore)]);	
					});
					
	    		    var view = new google.visualization.DataView(data);
	    		    view.setColumns([0, 2,
	    		                     { calc: "stringify",
	    		                       sourceColumn: 2,
	    		                       type: "string",
	    		                       role: "annotation" },
	    		                     1]);
	
	    		    var options = {
	    		      width: 1200,
	    		      height: 600,
	    		      bar: {groupWidth: "95%"},
	    		      legend: { position: "none" },
	    		    };
	    		    var chart = new google.visualization.ColumnChart(cell);
	    		    chart.draw(view, options);
	    		    
				},
				error: function(responseText){
					
				}
			});
		 }
	}

	function delete_exam_table(){
		var table = document.getElementById("exam_t");
		var rownum = table.rows.length;
		for (var i = 0; i < rownum;i++){
			table.deleteRow(0);
		}
	}
	function Exam_F(){
		 var examname = document.getElementById(this.id).innerHTML;
		 window.sessionStorage.setItem("examname",examname);
		 google.charts.load("current", {packages:['corechart']});
		 google.charts.setOnLoadCallback(drawChart);
		 function drawChart(){
			
			
			$.ajax({
				url: "OneExamStat",
				type:"GET",
				data: {examName: examname},
				success: function(responseText){
					delete_exam_table();
					var table = document.getElementById("exam_t");
						//alert(responseText);
						var table = document.getElementById("exam_t");
						var row = table.insertRow(-1);
						var cell = row.insertCell(0);
		    		    var data = new google.visualization.DataTable();
		    		    data.addColumn('number', 'Question');
		    		    data.addColumn('number', 'Score');
		                
		                var AnswerNum = 1;
						$.each($.parseJSON(responseText), function(k,v) {
							//alert(v.Score);
			                data.addRow([AnswerNum,parseFloat(v.Score)]);
			                AnswerNum++;
						});
						
		    		    var view = new google.visualization.DataView(data);
		    		    view.setColumns([0,
		    		                     { calc: "stringify",
		    		                       sourceColumn: 1,
		    		                       type: "string",
		    		                       role: "annotation" },
		    		                     1]);
		
		    		    var options = {
		    		      width: 1200,
		    		      height: 600,
		    		      bar: {groupWidth: "95%"},
		    		      legend: { position: "none" },
		    		    };
		    		    var chart = new google.visualization.ColumnChart(cell);
		    		    chart.draw(view, options);
				
		
				}
			});
		 }
	}
	function My_Exams_F(){
		$.ajax({
			url: "Exams",
			type:"GET",
			success: function(responseText){
				if (responseText.length>4){
					var table = document.getElementById("exams_t");
					$.each($.parseJSON(responseText), function(k,v) {
						var tr = table.insertRow(-1);
						var td = tr.insertCell(0);
						td.id = "exams_"+v.ExamName;
						td.innerHTML = v.ExamName;
						td.onclick = Exam_F;
					});
				}else{}
			},
			error: function (responseText){
				alert(responseText.responseText);
			}
			
		});
	}