function changeImage(element)
{
	console.log(element);
  var v = element.src;
  console.log(v);
  if(v == "file:///E:/ensup/master1/web/v3/logo2.png")
    v = "file:///E:/ensup/master1/web/v3/logov2.png";
  else
    v = "file:///E:/ensup/master1/web/v3/logo2.png";
  element.src = v;	
}

function test(){
  alert("mon superbe test");
}