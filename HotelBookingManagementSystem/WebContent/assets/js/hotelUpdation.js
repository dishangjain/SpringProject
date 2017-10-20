function addValueBox()
{
	var attributeOption = document.getElementsByName("attributeOption")[0];
	var inputBox = document.getElementsByName("attributeValue")[0];
	var p = document.getElementById("p");
	var id = attributeOption.options[attributeOption.selectedIndex].value;
	if(id=="1"){
		p.innerHTML = "<label> Enter City :</label> <input name='attributeValue' type='text' placeholder='Please enter city' pattern='[A-Za-z0-9 ]{3,20}' required='true'>";
	}
	else if(id=="2"){
		p.innerHTML = "<label>Enter Hotel Name :</label> <input name='attributeValue' type='text' placeholder='Please enter Hotel Name' pattern='[A-Za-z0-9 ]{3,30}' required='true'>";
	}
	else if(id=="3"){
		p.innerHTML = "<label>Enter Address :</label> <input name='attributeValue' type='text' placeholder='Please enter address' pattern='[A-Za-z0-9,.-/\ ]{5,40}' required='true'>";
	}
	else if(id=="4"){
		p.innerHTML = "<label>Enter Description :</label> <input name='attributeValue' type='text' placeholder='Please enter Description' pattern='[A-Za-z0-9 ]{10,50}' required='true'>";
	}
	else if(id=="5"){
		p.innerHTML = "<label>Enter Cost/Night :</label> <input name='attributeValue' type='text' placeholder='eg. 1234.56' pattern='[1-9][0-9]{0,3}[.]?[0-9]{0,2}' required='true'>";
	}
	else if(id=="6"){
		p.innerHTML = "<label>Enter Primary Phone Number :</label> <input name='attributeValue' type='text' placeholder='eg. 7643564336' pattern='[7-9][0-9]{9}' required='true'>";
	}
	else if(id=="7"){
		p.innerHTML = "<label>Enter Secondary Phone Number :</label> <input name='attributeValue' type='text' placeholder='eg. 7943634665' pattern='[7-9][0-9]{9}' required='true'>";
	}
	else if(id=="8"){
		p.innerHTML = "<label>Enter Rating :</label> <input name='attributeValue' type='text' placeholder='eg.1.0' pattern='[1-4][.][0-9]' required='true'>";
	}
	else if(id=="9"){
		p.innerHTML = "<label>Enter Email ID :</label> <input name='attributeValue' type='text' placeholder='Please enter email' pattern='[A-Za-z0-9._%+-]{1,18}@[a-z0-9.-]{1,7}\.[a-z]{2,3}$' required='true'>";
	}
	else if(id=="10"){
		p.innerHTML = "<label>Enter Fax :</label> <input name='attributeValue' type='text' placeholder='eg. 000000' pattern='[0-9]{6}' required='true'>";
	}
	
}