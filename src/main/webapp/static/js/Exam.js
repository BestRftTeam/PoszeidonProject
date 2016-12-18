			var idk = new Array();
	function StartExam_F(){
		//alert(window.sessionStorage.getItem("coursename"));
		$.ajax({
			url:"StartExam",
			type: "GET",
			data: {courseName: window.sessionStorage.getItem("coursename")},
			success: function(responseText){
				//alert(responseText);
				var test = $.parseJSON(responseText);
				var i = 1;
				//alert(test);
				$.each(test.testSheet, function(k,v) {
					//if (k==="testSheet"){
					//alert(v.score);
						var score = v.score; 
						var question=v.question;
						var tp = new Array();
						var answerOptions = v.answerOptions;
						//alert(v.answerOptions);
						//alert(answerOptions);
						/*$.each($.parseJSON(v.answerOptions),function(kq,vq){
							alert(vq);
							//score = vq.score;
							//question = vq.question;
							tp.add(vq);
							//answers = vq.answers;
							
						});*/
						KerdestHozzaad_f(i,score,question,answerOptions);
						i++;
						//alert(i);
					//}	
					
				});
				var d = new Date;
				var hour = d.getHours()+1;
				if (hour>=24) hour=hour-24;
				document.getElementById("StartTime").value = d.getHours()+":"+d.getMinutes();
				document.getElementById("EndTime").value = hour+":"+d.getMinutes();
				document.getElementById("Questions").value = i-1;
				window.sessionStorage.setItem("kerdesszam",i-1);
				window.sessionStorage.setItem("testName",test.testName);
				
				var div = document.createElement("div");
				div.class = "col-xs-6 col-sm-6 col-md-6";
				div.id = "SaveExam_container";
				var but = document.createElement("BUTTON");
				but.id = "SaveExam_B";
				but.onclick = Save_Exam;
				but.innerHTML = "Finish";
				
				div.appendChild(but);
				document.getElementById("KerdesHozzaadoBody").appendChild(div);
				
			},
			error: function(responseText){
				alert(responseText.responseText);
			}
		})
	}
	
	function KerdestHozzaad_f(kerdesszam,score,question,questionanswerOptions){
		//alert(questionanswerOptions);
		var valami = questionanswerOptions+"";
		var div = document.getElementById("KerdesHozzaadoBody");
		var tmp = valami.split(",");
		//kinézetcheat:D
		var szokoz = document.createElement("Label");
		szokoz.innerHTML = "    ";
		var szokoz1 = document.createElement("Label");
		szokoz1.innerHTML = "    ";
		var szokoz2 = document.createElement("Label");
		szokoz2.innerHTML = "    ";
		//tábla létrehozása
		var table = document.createElement("table");
		var k_szam = kerdesszam;//parseInt(window.sessionStorage.getItem("kerdesszam"));
		idk.push(2);
		table.id = "Table_" + k_szam;
		table.class = "table table-striped table-hover";
		//table.border = 0;
		table.style.width = "550px";
		//1. sor objektumai
		var input = document.createElement("input");
		input.id = "Kerdes_" + k_szam;
		input.style.width = "450px";
		input.disabled = true;;
		input.value = question;
		var input2 = document.createElement("input");
		input2.id = "KerdesValue_" + k_szam;
		input2.style.width = "20px";
		input2.disabled = true;
		input2.value = score;
		
		//1. sor
		var row0 = table.insertRow(0);
		var cell0 = row0.insertCell(0);
		
		cell0.appendChild(input);
		cell0.appendChild(szokoz);
		cell0.appendChild(input2);
		
		div.appendChild(table);
		

		//2. sor
		var row1 = table.insertRow(1);
		var cell1 = row1.insertCell(0);
		cell1.id = "Cell_"+k_szam;
		//2. sor objektumai
		var input_a1 = document.createElement("input");
		input_a1.id = k_szam +"_"+1;
		input_a1.style.width = "450px";
		input_a1.value = tmp[0];
		input_a1.disabled = true;
		var c_box1 = document.createElement("input");
		c_box1.id = "c_"+k_szam+"_"+1;
		c_box1.type = "checkbox";
		var input_a2 = document.createElement("input");
		input_a2.id = k_szam +"_"+2;
		input_a2.style.width = "450px";
		input_a2.value = tmp[1];
		input_a2.disabled = true;
		var c_box2 = document.createElement("input");
		c_box2.id = "c_"+k_szam+"_"+2;
		c_box2.type = "checkbox";
		
		cell1.appendChild(input_a1);
		cell1.appendChild(szokoz1);
		cell1.appendChild(c_box1);

		cell1.appendChild(input_a2);
		cell1.appendChild(szokoz2);
		cell1.appendChild(c_box2);
		
		for (var i = 2;i < tmp.length;i++){
			Valaszok(tmp[i],k_szam,table)
		}
		
		
	}
	
	function Valaszok(questionanswerOption,tab){
		//var table = document.getElementById;
		var szokoz = document.createElement("Label");
		//alert(tab);
		//alert(document.getElementById("Table_"+k_szam));
		szokoz.innerHTML = "    ";
		//var tmp = table.split("_");
		var k_szam = tab;
		idk[k_szam-1] = idk[k_szam-1] + 1;
		var cell = document.getElementById("Table_"+k_szam).rows[1].cells[0];
		var input = document.createElement("input");
		input.id = k_szam +"_"+idk[k_szam-1];
		input.style.width = "450px";
		input.disabled = true;
		input.value = questionanswerOption;
		var c_box = document.createElement("input");
		c_box.id = "c_"+k_szam+"_"+idk[k_szam-1];
		c_box.type = "checkbox";
		cell.appendChild(input);
		cell.appendChild(szokoz);
		cell.appendChild(c_box);
	}
	
	function Save_Exam(){
		/*var answers = {
				yes:"yes",
				ans : []
		};
		*/
		var test = {
				TestName: window.sessionStorage.getItem("testName"),
			    questions: [],
				//availability: document.getElementById("Availability").value,
			};
		
		var questionsnum = parseInt(window.sessionStorage.getItem("kerdesszam"));
		for (var i = 1;i < (questionsnum+1);i++){
			var answers = {
					ans : []
			};
			var s = "";
			for (var j = 1;j<idk[i-1]+1;j++){
				var tmp = j+"True";
				if (j===idk[i-1]) {
					s+= "{Answer:"+document.getElementById(i+"_"+j).value + ",";
					s+= "True:"+document.getElementById("c_"+i+"_"+j).checked +"}";
				}
				else {
					s+= "{Answer:"+document.getElementById(i+"_"+j).value + ",";
					s+= "True:"+document.getElementById("c_"+i+"_"+j).checked +"},";
				}
				answers.ans.push({
					//"Answer": document.getElementById(i+"_"+j).value,
					"True": document.getElementById("c_"+i+"_"+j).checked
				});
			}
			//alert(answers.ans[0].True)
			//alert("["+s+"]");
			
			//alert(answers.ans.pop().Answer);
			//alert(answers.ans.pop().Answer);
			test.questions.push({
				//"Question": document.getElementById("Kerdes_"+i).value,
				"Value": document.getElementById("KerdesValue_"+i).value,
				"Answers": answers//"["+s+"]"
			});
		}
		var json = JSON.stringify(test); 
		//alert(test.questions.pop().yes);
		alert(test.questions[0].Answers.ans[1].Answer);
		$.ajax({
			url:"SaveStudentExam",
			type: "POST",
			data: {"courseName":window.sessionStorage.getItem("coursename"),sheet: json},
			success: function(responseText){
				window.location.assign("Courses.html");
			},
			error: function(responseText){
				
			}
		});
	}