package app.sec04;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

public class UpdateOneTest {
    public static void main (String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");
        String id = "1";
        Bson query = Filters.eq("_id", id);
        Bson updates = Updates.combine(
                Updates.set("username", "modified name"),
                Updates.currentTimestamp("lastUpdated")
        );
        UpdateResult result = collection.updateOne(query, updates);
        System.out.println(result.getModifiedCount());
    }
}