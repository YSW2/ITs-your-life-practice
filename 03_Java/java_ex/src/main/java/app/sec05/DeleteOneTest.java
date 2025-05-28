package app.sec05;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import org.bson.conversions.Bson;

public class DeleteOneTest {
    public static void main (String[] args) {
        MongoCollection collection = Database.getCollection("todo");
        Bson query = Filters.eq("_id", 1);
        DeleteResult result = collection.deleteOne(query);
        System.out.println(result.getDeletedCount());
    }
}