function addValueBox()
{
	var attributeOption = document.getElementsByName("attributeOption")[0];
	var p = document.getElementById("p");
	var id = attributeOption.options[attributeOption.selectedIndex].value;
	if(id=="1"){
		p.innerHTML = "<label>Enter Value </label><input name='attributeValue' type='text' pattern='[0-9]{3}' required='true'>";
	}
	else if(id=="2"){
		p.innerHTML = "<label>Enter Value </label><select id='attributeValue' name='attributeValue' >"
						+ "<option value='Non AC'>Non AC</option>"
						+ "<option value='AC'>AC</option>"
						+ "<option value='AC Deluxe'>AC Deluxe</option>"
						+ "</select>";
		
	}
	else if(id=="3"){
		p.innerHTML = "<label>Enter Value </label><input name='attributeValue' type='text' pattern='[1-9][0-9]{0,3}[.]?[0-9]{0,2}' required='true'>";
	}
	else if(id=="4"){
		p.innerHTML = "<label>Enter Photo </label><input name='attributeValue' type='file' pattern='[A-za-z]+(.png|.jpeg|.jpg)' required='true'>";
	}
}