			window.sessionStorage.setItem("kerdesszam",0);
			var idk = new Array();
			
			function KerdestHozzaad_f(){
				var div = document.getElementById("KerdesHozzaadoBody");
				
				//kinézetcheat:D
				var szokoz = document.createElement("Label");
				szokoz.innerHTML = "    ";
				var szokoz1 = document.createElement("Label");
				szokoz1.innerHTML = "    ";
				var szokoz2 = document.createElement("Label");
				szokoz2.innerHTML = "    ";
				//tábla létrehozása
				var table = document.createElement("table");
				var k_szam = parseInt(window.sessionStorage.getItem("kerdesszam"));
				idk.push(2);
				table.id = "Table_" + k_szam;
				table.class = "table table-striped table-hover";
				//table.border = 0;
				table.style.width = "550px";
				//1. sor objektumai
				var input = document.createElement("input");
				input.id = "Kerdes_" + k_szam;
				input.style.width = "450px";
				var button = document.createElement("BUTTON");
				button.id = "Button_" + k_szam;
				button.innerHTML = "+";
				button.onclick = Valaszok;
				var input2 = document.createElement("input");
				input2.id = "KerdesValue_" + k_szam;
				input2.style.width = "20px";
				
				//1. sor
				var row0 = table.insertRow(0);
				var cell0 = row0.insertCell(0);
				
				cell0.appendChild(input);
				cell0.appendChild(szokoz);
				cell0.appendChild(input2);
				cell0.appendChild(button);
				//2. sor
				var row1 = table.insertRow(1);
				var cell1 = row1.insertCell(0);
				cell1.id = "Cell_"+k_szam;
				//2. sor objektumai
				var input_a1 = document.createElement("input");
				input_a1.id = k_szam +"_"+1;
				input_a1.style.width = "450px";
				var c_box1 = document.createElement("input");
				c_box1.id = "c_"+k_szam+"_"+1;
				c_box1.type = "checkbox";
				var input_a2 = document.createElement("input");
				input_a2.id = k_szam +"_"+2;
				input_a2.style.width = "450px";
				var c_box2 = document.createElement("input");
				c_box2.id = "c_"+k_szam+"_"+2;
				c_box2.type = "checkbox";
				
				cell1.appendChild(input_a1);
				cell1.appendChild(szokoz1);
				cell1.appendChild(c_box1);

				cell1.appendChild(input_a2);
				cell1.appendChild(szokoz2);
				cell1.appendChild(c_box2);
				
				
				div.appendChild(table);
			}
			
			function e_KerdesHozzaad(){
				
				if (window.sessionStorage.getItem("kerdesszam")==null) 
					window.sessionStorage.setItem("kerdesszam",1);
				else
					var k_szam = parseInt(sessionStorage.getItem("kerdesszam"))+1;
					window.sessionStorage.setItem("kerdesszam",k_szam);
				
				if (document.getElementById("i_KerdesekSzama").value=="")
					var KerdesekSzama = 1;
				else
					var KerdesekSzama = document.getElementById("i_KerdesekSzama").value;
				for (var i = 0; i < KerdesekSzama;i++){
					KerdestHozzaad_f();
					if (i != KerdesekSzama - 1) {
						k_szam = k_szam + 1;
						window.sessionStorage.setItem("kerdesszam",k_szam);
					}
				}
			}
			function Valaszok(){
				var table = $(this).closest("table").attr("id");
				var szokoz = document.createElement("Label");
				szokoz.innerHTML = "    ";
				var tmp = table.split("_");
				var k_szam = parseInt(tmp[1]);
				idk[k_szam-1] = idk[k_szam-1] + 1;
				var cell = document.getElementById(table).rows[1].cells[0];
				var input = document.createElement("input");
				input.id = k_szam +"_"+idk[k_szam-1];
				input.style.width = "450px";
				var c_box = document.createElement("input");
				c_box.id = "c_"+k_szam+"_"+idk[k_szam-1];
				c_box.type = "checkbox";
				cell.appendChild(input);
				cell.appendChild(szokoz);
				cell.appendChild(c_box);
			}
			function Save_Test(){
				/*var answers = {
						yes:"yes",
						ans : []
				};
				*/
				var test = {
						TestName: document.getElementById("TestName").value,
					    questions: [],
						availability: document.getElementById("Availability").value,
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
							"Answer": document.getElementById(i+"_"+j).value,
							"True": document.getElementById("c_"+i+"_"+j).checked
						});
					}
					//alert(answers.ans[0].True)
					//alert("["+s+"]");
					
					//alert(answers.ans.pop().Answer);
					//alert(answers.ans.pop().Answer);
					test.questions.push({
						"Question": document.getElementById("Kerdes_"+i).value,
						"Value": document.getElementById("KerdesValue_"+i).value,
						"Answers": answers//"["+s+"]"
					});
				}
				var json = JSON.stringify(test); 
				//alert(test.questions.pop().yes);
				alert(test.questions[0].Answers.ans[1].Answer);
				$.ajax({
					url:"SaveExam",
					type: "POST",
					data: {"courseName":window.sessionStorage.getItem("coursename"),sheet: json},
					success: function(responseText){
						window.location.assign("Courses.html");
					},
					error: function(responseText){
						
					}
				});
			}
	