import{bookModule} from './BookModule.js';
import{authorModule} from './AuthorModule.js';
import{userModule} from './UserModule.js';
let debug = false;

const newBook = document.getElementById('newBook');
    newBook.addEventListener('click', e=>{
        bookModule.printCreateBook();
});
const listBooks = document.getElementById('listBooks');
    listBooks.addEventListener('click',e=>{
        bookModule.printListBooks();
});
const newAuthor = document.getElementById('newAuthor');
    newAuthor.addEventListener('click', e=>{
        authorModule.printCreateAuthor();
});
const listAuthors = document.getElementById('listAuthors');
    listAuthors.addEventListener('click', e=>{
        authorModule.printListAuthors();
});
const newUser = document.getElementById('newUser');
    newUser.addEventListener('click', e=>{
        userModule.printFormNewUser();
});
const listUsers = document.getElementById('listUsers');
    listUsers.addEventListener('click', e=>{
        userModule.printListUsers();
});
const logIn = document.getElementById('logIn');
    logIn.addEventListener('click', e=>{
        loginModule.printFormLogin();
});



 

