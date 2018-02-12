package NLBBanka.NLBBankaCrawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.jsoup.Jsoup;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.util.JSON;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
    	DB database = mongoClient.getDB("prvaDB");
    	DBCollection collection = database.getCollection("Valuti");
    	
    	 org.jsoup.nodes.Document doc = Jsoup.connect("http://www.nlb.mk/%D0%A4%D0%B8%D0%B7%D0%B8%D1%87%D0%BA%D0%B8_%D0%BB%D0%B8%D1%86%D0%B0/%D0%90%D0%BB%D0%B0%D1%82%D0%BA%D0%B8/%D0%9A%D1%83%D1%80%D1%81%D0%BD%D0%B0_%D0%BB%D0%B8%D1%81%D1%82%D0%B0.aspx").get();

         org.jsoup.select.Elements rows = doc.select("tr");
         
         //org.jsoup.select.Elements date=doc.select("td.ns-kursna-home-datum");
         
         String jsonMsg = "[";

         for(org.jsoup.nodes.Element row :rows)
        
         {

             org.jsoup.select.Elements columns = row.select("td");
             
             int i = 1;
             
             jsonMsg = jsonMsg + "{";
          	
          //	 jsonMsg = jsonMsg + "\""+ date.text()+"\"";
              
          	// jsonMsg = jsonMsg + ",";
          	
          	//System.out.print(date.text());

             for (org.jsoup.nodes.Element column:columns)

             {
            	 
                
                 if(i==2)
                 {
                 	jsonMsg = jsonMsg + "\"Валута\":";
                 	
                 	jsonMsg = jsonMsg + "\""+ column.text()+"\"";
                     
                 	jsonMsg = jsonMsg + ",";
                 	
                 	System.out.print(column.text());
                 }
//                 if(i==3)
//                 {
//                 	jsonMsg = jsonMsg + "\"Земја\":";
//                 	
//                 	jsonMsg = jsonMsg + "\""+ column.text()+"\"";
//                     
//                 	jsonMsg = jsonMsg + ",";
//                 	
//                 	System.out.print(column.text());
//                 }
//                 if(i==4)
//                 {
//                 	jsonMsg = jsonMsg + "\"Единица валута\":";
//                 	
//                 	jsonMsg = jsonMsg + "\""+ column.text()+"\"";
//                     
//                 	jsonMsg = jsonMsg + ",";
//                 	
//                 	System.out.print(column.text());
//                 }
                 if(i==5)
                 {
                 	jsonMsg = jsonMsg + "\"Куповен\":";
                 	
                 	jsonMsg = jsonMsg + "\""+ column.text()+"\"";
                     
                 	jsonMsg = jsonMsg + ",";
                 	
                 	System.out.print(column.text());
                 }
                 if(i==6)
                 {
                 	jsonMsg = jsonMsg + "\"Продажен\":";
                 	
                 	jsonMsg = jsonMsg + "\""+ column.text()+"\"";
                     
                 	//jsonMsg = jsonMsg + ",";
                 	
                 	System.out.print(column.text());
                 }
//                 if(i==7)
//                 {
//                 	jsonMsg = jsonMsg + "\"Чекови\":";
//                 	
//                 	jsonMsg = jsonMsg + "\""+ column.text()+"\"";
//                     
//                 	
//                 	System.out.print(column.text());
//                 }
//
              i++;

             }
             
            
             
             jsonMsg = jsonMsg + "},";
             
             System.out.println();
              
         }

         
         jsonMsg = jsonMsg.substring(0, jsonMsg.length()-1);
         jsonMsg = jsonMsg + "]";

         System.out.print(jsonMsg);
    	
    	         
//         java.util.List<DBObject> docs = new ArrayList<DBObject>();
//           
//         DBObject jArray =  (DBObject) JSON.parse(jsonMsg);//ova kako eden objekt go glea cel json
//         System.out.println(jArray);
//         Set<String> keys = jArray.keySet();//gi vadi klucevite od jsonot
//         for (String key : keys) {//za sekoj kluc vo setot klucevi
//			docs.add((DBObject) jArray.get(key));
//		 }
//         
//         collection.insert(docs);
//         // kako hash mapa gi gledalo JSON bibliotekava, ali radi sea falaaaaaaaaaa! nsto
//    	//collection.insert(dbObject);
//    	
//    	System.out.println("Uspesno vneseno vo baza");
//    	
//    	mongoClient.close();
    }
}
