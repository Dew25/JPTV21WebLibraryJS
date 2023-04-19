/*
 * Конвертор создает JsonObject/JsonArray формат классов Java.
 * Используйте соответствующие методы для преобразования.
 */
package convertors;

import entity.Author;
import entity.Book;
import entity.Cover;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author Melnikov
 */
public class ConvertToJson {

    /**
     * Преобразование Map<Author, List<Book>> в JsonArray объектов JsonEntry
     * @param mapAuthors
     * @return JsonArray - массив объектов JsonEntry с ключем "author" и значением "authorBooks"
     */
    public JsonArray getJsonObjectMap(Map<Author, List<Book>> mapAuthors){
        JsonArrayBuilder jsonMapBuilder = Json.createArrayBuilder();
        JsonObjectBuilder jsonEntryObjectBuilder = Json.createObjectBuilder();
        //Чтобы получить значения mapAuthors в цикле проходим 
        //по множеству внутреннего класса Entry, в котором есть два поля: key и value
        //в key лежит объект типа Author, а в value - List<Book> массив написаных автором книг
        // Для удобства написали методы конвертации в JsonObject и JsonArray формат объектов книг и авторов
        for(Entry entry: mapAuthors.entrySet()){
            Author author = (Author) entry.getKey();
            List<Book> authorBooks = (List<Book>) entry.getValue();
            JsonObject jsonObjectAuthor = getJsonObjectAuthor(author);
            JsonArray jsonArrayBooks = getJsonArrayBooks(authorBooks);
            jsonEntryObjectBuilder.add("key",jsonObjectAuthor);
            jsonEntryObjectBuilder.add("value",jsonArrayBooks);
            jsonMapBuilder.add(jsonEntryObjectBuilder.build());
        }
        return jsonMapBuilder.build(); 
    }
    
    public JsonObject getJsonObjectAuthor(Author author){
        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("id", author.getId());
        job.add("firstname", author.getFirstname());
        job.add("lastname", author.getLastname());
        return job.build();
    }
    
    public JsonObject getJsonObjectBook(Book book){
        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("id", book.getId());
        job.add("bookName", book.getBookName());
        job.add("publishedYear", book.getPublishedYear());
        job.add("quantity", book.getQuantity());
        job.add("authors", getJsonArrayAuthors(book.getAuthors()));
        return job.build();
    }
    
    public JsonArray getJsonArrayAuthors(List<Author>listAuthors){
        JsonArrayBuilder jar = Json.createArrayBuilder();
        for (int i = 0; i < listAuthors.size(); i++) {
            Author author = listAuthors.get(i);
            jar.add(getJsonObjectAuthor(author));
        }
        return jar.build();
    }
    
    public JsonArray getJsonArrayBooks(List<Book>listBooks){
        JsonArrayBuilder jar = Json.createArrayBuilder();
        for (int i = 0; i < listBooks.size(); i++) {
            Book book = listBooks.get(i);
            jar.add(getJsonObjectBook(book));
        }
        return jar.build();
    }
    public JsonArray getJsonArrayCovers(List<Cover> listCovers){
        JsonArrayBuilder jar = Json.createArrayBuilder();
        JsonObjectBuilder job = Json.createObjectBuilder();
        for (int i = 0; i < listCovers.size(); i++) {
            Cover cover = listCovers.get(i);
            job = Json.createObjectBuilder();
            job.add("id", cover.getId().toString());
            job.add("url",cover.getUrl());
            job.add("description",cover.getDescription());
            job.build();
        }
        return jar.add(job).build();
        
    }
}
