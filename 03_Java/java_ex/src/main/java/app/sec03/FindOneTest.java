package app.sec03;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

public class FindOneTest {
    public static void main (String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");
        Bson query = Filters.eq("_id", 1);
        Document doc = collection.find(query).first();
        System.out.println(doc);
        Database.close();
    }
}