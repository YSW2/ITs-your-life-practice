package app.sec05;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import org.bson.conversions.Bson;

public class DeleteManyTest {
    public static void main (String[] args) {
        MongoCollection collection = Database.getCollection("todo");
        Bson query = Filters.gt("age", 15);
        DeleteResult result = collection.deleteMany(query);
        System.out.println(result.getDeletedCount());
    }
}