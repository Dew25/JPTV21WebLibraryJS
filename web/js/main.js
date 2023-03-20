/*
 * Напишите форму создания новой книги
 * Обработайте нажатие на кнопку "Добавить"
 * Выведите в консоле все поля книги. console.log("name: "+name); и так далее.
 */
"use strict";
let debug = false;

//alert("Hello!");
let h = document.getElementsByTagName("H1");
h[0].innerHTML = "Hello, Ребята!";
if(debug){
    console.log("Произошла замена текста в теге H1");
}
let inputText = document.getElementById("inputText");
inputText.value = "Это вставленный с помощью js текст";

//var
//let
const clickMe = document.getElementById("clickMe");
clickMe.addEventListener('click',e=>{
    for(let i=0; i < h.length;i++){
        if(i===0){
            h[i].innerHTML=inputText.value;
        }else{
            inputText.value=inputText.value + ' 2';
            h[i].innerHTML=inputText.value;
        }
    }
    document.getElementById('myText').innerHTML='Это мой текст';
    
  inputText.value = '';
})
