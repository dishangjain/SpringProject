$(document).ready(
	function(){
		$("h1").css({"color":"green", "font-size":"30px", "text-align":"center"});
		$("h3").css({"color":"darkgreen", "font-size":"22px", "text-align":"center"});
		
		$("#mainMenu a").hover(
			function(){
				$(this).css({ "color":"red", "font-size":"18px"});
			},
			function(){
				$(this).css({ "color":"blue", "font-size":"16px"});
			}
		)
		
		$("table tr:odd").css({ "background-color":"lightblue"});
		$("table tr:even").css({ "background-color":"lightgreen"});
	}
);