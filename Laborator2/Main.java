import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    public static void main(String[] args) throws IOException{
       String html = "http://rss.cnn.com/rss/edition.rss";

        Document doc = Jsoup.parse(html);  //parse = analizeaza content-ul documentului
        //System.out.println(doc);
        Elements item = doc.getElementsByTag("item");
        System.out.println("number of items: " + item.size());

        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        for(Element elem : item){
            ArrayList<String> row = new ArrayList<>();
            for(Element e: elem.children()){
                if(e.tagName().equals("title")){
                    String title = e.text();
                    row.add(title);
                }
                if(e.tagName().equals("description")){
                    String description = e.text();
                    row.add(description);
                }
                if(e.tagName().equals("link")){
                    String link = e.text();
                    row.add(link);
                }
                if(e.tagName().equals("guid")){
                    String guid = e.text();
                    row.add(guid);
                }
                if(e.tagName().equals("guid")){
                    String guid = e.text();
                    row.add(guid);
                }
                if(e.tagName().equals("pubdate")){
                    String pubdate = e.text();
                    row.add(pubdate);
                }
            }
            list.add(row);
            //System.out.println("item: "+ elem + " has " + title + description + link + guid + pubdate);
        }
        for(int i = 0; i < list.size(); i++){
            System.out.println("acest item are: ");
            for(int j = 0; j < list.get(i).size(); j++){
                System.out.println(list.get(i).get(j));
            }
        }



        //Elements allElements = doc.getAllElements();
        //for (Element element : allElements) {
        //    System.out.println(element.nodeName() + " " + element.ownText());
        //    //System.out.println(element.nextElementSiblings());
        //}
        //Elements item = doc.getElementsByClass("opened");
        //System.out.println(allElements.size());
        //Element item = doc.getElementById("folder1");
        //System.out.println(item);
        //String blogUrl = "https://spring.io/blog";
        //Document doc = Jsoup.connect(blogUrl).get();
        //Elements item = doc.select("rss");
        //System.out.println(item.size());
        }
    }
