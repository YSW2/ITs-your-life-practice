package sec02;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsertMany2Test {
    public static void main (String[] args) {
        MongoCollection<Document> collection = Database.getCollection("todo");
        List<Document> insertList = new ArrayList<Document>();

        for (int i = 10; i < 20; i++) {
            Document doc = new Document();

            doc.append("name", "user_" + i);
            doc.append("age", i);
            doc.append("created", new Date());

            insertList.add(new Document(doc));
        }
        InsertManyResult result = collection.insertMany(insertList);
        System.out.println(result.getInsertedIds());
        Database.close();
    }
}