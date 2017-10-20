function addValueBox()
{
	var attributeOption = document.getElementsByName("attributeOption")[0];
	var p = document.getElementById("p");
	var id = attributeOption.options[attributeOption.selectedIndex].value;
	if(id=="1"){
		p.innerHTML = "<label>Enter Room Number </label><input name='attributeValue' type='text' pattern='[0-9]{3}' placeholder='eg. 000' required='true'>";
	}
	else if(id=="2"){
		p.innerHTML = "<label>Select Room Type </label><select id='attributeValue' name='attributeValue' >"
						+ "<option value='Non AC'>Non AC</option>"
						+ "<option value='AC'>AC</option>"
						+ "<option value='AC Deluxe'>AC Deluxe</option>"
						+ "</select>";
		
	}
	else if(id=="3"){
		p.innerHTML = "<label>Enter Cost/Night </label><input name='attributeValue' placeholder='eg. 1234.56' type='text' pattern='[1-9][0-9]{0,3}[.]?[0-9]{0,2}' required='true'>";
	}
	else if(id=="4"){
		p.innerHTML = "<label>Enter Photo </label><input name='attributeValue' type='file' pattern='[A-za-z]+(.png|.jpeg|.jpg)' required='true'>";
	}
}



function getRoomNumbers(){
	var hotelID = document.getElementsByName("hotelID")[0];
	var selectedHotelID = hotelID.options[hotelID.selectedIndex].value;
	var rooms = document.getElementsByName(selectedHotelID);
	var roomIDs = new Array();
	for(i=0;i<rooms.length;i++){
		roomIDs[i] = rooms[i].value;
	}
	var roomID = document.getElementsByName("roomID")[0];
	for(i=0;i<roomID.options.length;i++){
		if(roomIDs.includes(roomID.options[i].value)){
			roomID.options[i].hidden = false;
		}
		else{
			roomID.options[i].hidden = true;
		}
	}
}