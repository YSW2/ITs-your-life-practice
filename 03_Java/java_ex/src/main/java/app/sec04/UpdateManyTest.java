package app.sec04;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

public class UpdateManyTest {
    public static void main (String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");
        Bson query = Filters.gt("age", 16);
        Bson updates = Updates.combine(
                Updates.set("username", "modified name"),
                Updates.currentTimestamp("lastUpdated")
        );

        UpdateResult result = collection.updateMany(query, updates);
        System.out.println(result.getModifiedCount());
    }
}