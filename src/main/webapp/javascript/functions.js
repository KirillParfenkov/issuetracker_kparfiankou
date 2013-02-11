function showBuilds(){

	var elem = document.getElementById("buildSelect");
	elem.style.display = "table-row";

}

function test(patam) {
	this.elements = patam;
}

function addEvent(elem, type, handler){

    if (elem.addEventListener){
        elem.addEventListener(type, handler, false)

    } else {
        elem.attachEvent("on"+type, handler)
    }
}

function addOption (oListbox, text, value, isDefaultSelected, isSelected)
{
    var oOption = document.createElement("option");
    oOption.appendChild(document.createTextNode(text));
    oOption.setAttribute("value", value);

    if (isDefaultSelected) oOption.defaultSelected = true;
    else if (isSelected) oOption.selected = true;

    oListbox.appendChild(oOption);
}

function convertSelectToArray(list) {

    var arr = new Array();
    var size = list.length;

    for (var i = 0; i < size; i++) {
        arr[i] = (list[i]);
    }

    return  arr;
}
