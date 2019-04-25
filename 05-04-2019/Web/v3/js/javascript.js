
function changeImage(obj)
{
	console.log("element de la fonction changeimage" , obj);
  var v = obj.target.src;
  console.log(v);
  if(v == "file:///E:/ensup/master1/web/v3/assets/logo2.png")
    v = "file:///E:/ensup/master1/web/v3/assets/logov2.png";
  else
    v = "file:///E:/ensup/master1/web/v3/assets/logo2.png";
  obj.target.src = v;	
}

function mettreTexte(obj)
{
	console.log("element de la fonction changeimage" , obj);

	obj.target.innerHTML = "C'est effacé"
}

function changementTexte(obj)
{
	console.log("element de la fonction changeimage" , obj);

  obj.target.innerHTML = "Salut les ptits loulou voici mon premier site je vous propose de voir mon logo :";
}

function test(){
  alert("mon superbe test");
}

function changementRouge(obj)
{
	document.getElementById("body").style.backgroundColor="red";
	dansFonction();
}

function changementVert(obj)
{
	document.getElementById("body").style.backgroundColor="green";
}

function changementJaune(obj)
{
	document.getElementById("body").style.backgroundColor="yellow";
}

function changementViolet(obj)
{
	document.getElementById("body").style.backgroundColor="purple";
}

function dansFonction ()
{
		console.log("1");
		console.log("2");
		console.log("3");
}

 window.addEventListener("load",function(){
document.getElementById('image').addEventListener('click', changeImage);
document.getElementById('test').addEventListener('mouseover', mettreTexte);
document.getElementById('test').addEventListener('mouseout', changementTexte);
document.getElementById('ROUGE').addEventListener('click', changementRouge);
document.getElementById('VERT').addEventListener('click', changementVert);
document.getElementById('JAUNE').addEventListener('click', changementJaune);
document.getElementById('VIOLET').addEventListener('click', changementViolet);
 });