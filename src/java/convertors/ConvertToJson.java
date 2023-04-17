/**
 * Конвертор создает JsonObject/JsonArray формат классов Java.
 * Используйте соответствующие методы для преобразования.
 */
package convertors;

import entity.Author;
import entity.Book;
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
        for(Entry entry: mapAuthors.entrySet()){
            Author author = (Author) entry.getKey();
            JsonObject jsonObjectAuthor = getJsonObjectAuthor(author);
            List<Book> authorBooks = (List<Book>) entry.getValue();
            JsonArray jsonArrayBooks = getJsonArrayBooks(authorBooks);
            jsonEntryObjectBuilder.add("author",jsonObjectAuthor);
            jsonEntryObjectBuilder.add("authorBooks",jsonArrayBooks);
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
}
