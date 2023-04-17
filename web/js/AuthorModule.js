class AuthorModule{
    printFormAddAuthor(){
         document.getElementById('content').innerHTML=
        `<h3 class="w-100 mt-5 d-flex justify-content-center">Новый автор</h3>
        <div class="w-100 d-flex justify-content-center p-5">
            <div class="card" style="width: 40rem;">
                <div class="card-body">
                    <form method="POST" action="#">
                      <div class="mb-3 row">
                        <label for="firstname" class="col-sm-5 col-form-label">Имя:</label>
                        <div class="col-sm-7">
                          <input type="text" class="form-control" id="firstname" name="firstname" value="">
                        </div>
                      </div>
                      <div class="mb-3 row">
                        <label for="lastname" class="col-sm-5 col-form-label">Фамилия</label>
                        <div class="col-sm-7">
                          <input type="text" class="form-control" id="lastname" name="lastname" value="">
                        </div>
                      </div>
                      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                          <button type="button" class="btn btn-primary me-md-2" id="btnAddAuthor">Добавить</button>
                      </div>
                    </form>
                </div>
            </div>
        </div>
    `;
    };
    printListAuthors(){
        const book = {"id":1,"bookName":"Война и мир"};
        const author = {"id":1,"firstname":"Лев","lastname":"Толстой", "books":[book]};
        const authors = [author];
         document.getElementById('content').innerHTML=
        `<h3 class="w-100 mt-5 d-flex justify-content-center">Новый автор</h3>
        <div class="w-100 d-flex justify-content-center p-5">
            <div class="card" style="width: 40rem;">
            <table class="table">
            <thead>
              <tr>
                <th scope="col">№</th>
                <th scope="col">Автор</th>
                <th scope="col">Книги автора</th>
                
              </tr>
            </thead>
            <tbody>
              
            </tbody>
          </table>
            </div>
        </div>
            `;
            const tbody = document.getElementsByTagName('tbody');
            
            for(let i = 0;i< authors.length;i++){
                let tr = tbody.createRow();
                let cell1 = tr.createCell();
                cell1.innerHTML = i;
                let cell2 = tr.createCell();
                cell2.innerHTML = authors[i].firstname + ' '+authors[i].lastname;
                let cell3 = tr.createCell();
                cell3.innerHTML = '';
                for(let j = 0;j<authors[i].books.length;j++){
                    tr = tbody.createRow();
                    cell1 = tr.createCell();
                    cell1.innerHTML = '';
                    cell2 = tr.createCell();
                    cell2.innerHTML = '';
                    cell3 = tr.createCell();
                    cell3.innerHTML = authors[i].books[j].bookName;
                    cel13.addEventListener('click',e=>{
                        authorModule.printBook(authors[i].books[j].id);
                    })
                }
                
            }
                     
        
        
        
    };
    printBook(id){
        console.log('Печатаем книгу с id='+id);
    }
};
const authorModule = new AuthorModule();
export {authorModule};
