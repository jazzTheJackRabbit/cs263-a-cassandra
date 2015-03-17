import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.apache.commons.codec.binary.Base64;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class WebSearch {
	
	public static String API_KEY = "OZJLisXlGzYkM02G/XphKCkIx6aWhUe+IYPNAN9ZEEk";
	
	public ArrayList<SearchResult> searchResults;	
	public String jsonResponse;
	
	public WebSearch(){
		this.searchResults = new ArrayList<SearchResult>();
	}
	
    public ArrayList<SearchResult> getTopSearchSummaries(String query) {    	
    	
    	//We have can query BING only 5000 times a month. I've saved a sample JSON response in getJSONSearchResults  
//    	String response = getJSONSearchResults();
    	
    	//Uncomment this line if you want to actually go out to the network and get search results.
    	String response = search(query);    	
    	this.jsonResponse = response;
    	
    	Gson gson = new Gson();  
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(response);
        JsonArray resultsArray = jsonElement.getAsJsonObject().get("d").getAsJsonObject().get("results").getAsJsonArray();
        
        int rank = 0;
        for(JsonElement jsonResult : resultsArray){
        	SearchResult searchResult = gson.fromJson(jsonResult, SearchResult.class);
        	searchResult.rank = rank;
        	this.searchResults.add(searchResult);
        	rank++;
        }        
        
        System.out.println("Search results returned for '"+query+"'");
        
        return this.searchResults;
    }
    

    public static String getJSONSearchResults(){
    	return "{\"d\":{\"results\":[{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=0&$top=1\",\"type\":\"WebResult\"},\"ID\":\"2c570137-bc5d-481e-86e3-f0e91e9f3e26\",\"Title\":\"Louvre - Wikipedia, the free encyclopedia\",\"Description\":\"The Louvre or the Louvre Museum is one of the world\\u0027s largest museums and a historic monument. A central landmark of Paris, France, it is located on the Right Bank of ...\",\"DisplayUrl\":\"en.wikipedia.org/wiki/Louvre\",\"Url\":\"http://en.wikipedia.org/wiki/Louvre\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=1&$top=1\",\"type\":\"WebResult\"},\"ID\":\"7db5321f-40d9-46d6-817c-1f15cd059910\",\"Title\":\"The Louvre wishes to thank - Louvre Museum Official Website\",\"Description\":\"Most viewed pages. Search the Collection; Search louvre.fr; Selected Works; Visitor Trails; Advance Tickets ; Calendar. Saturday Mar 14. Featured events. Exhibition\",\"DisplayUrl\":\"www.louvre.fr/en\",\"Url\":\"http://www.louvre.fr/en\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=2&$top=1\",\"type\":\"WebResult\"},\"ID\":\"98ff4492-4138-4af5-a454-78c2f8328c99\",\"Title\":\"What is the Louvre and where is it - Answers - The Most ...\",\"Description\":\"Louvre The Louvre is one of the world\\u0027s oldest and finest art gallery and museum. It is located in Paris, France.\",\"DisplayUrl\":\"www.answers.com/Q/What_is_the_Louvre_and_where_is_it\",\"Url\":\"http://www.answers.com/Q/What_is_the_Louvre_and_where_is_it\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=3&$top=1\",\"type\":\"WebResult\"},\"ID\":\"5c3d5811-b1ec-4cf9-8b41-3b8648f7ab20\",\"Title\":\"Louvre Pyramid - Wikipedia, the free encyclopedia\",\"Description\":\"The Louvre Pyramid (Pyramide du Louvre) is a large glass and metal pyramid, surrounded by three smaller pyramids, in the main courtyard (Cour Napoléon) of the Louvre ...\",\"DisplayUrl\":\"en.wikipedia.org/wiki/Louvre_Pyramid\",\"Url\":\"http://en.wikipedia.org/wiki/Louvre_Pyramid\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=4&$top=1\",\"type\":\"WebResult\"},\"ID\":\"b5dc004f-7977-47ba-8a4b-ef720fba4f3d\",\"Title\":\"Louvre, Paris - A View On Cities\",\"Description\":\"The Louvre, originally a royal palace but now the world\\u0027s most famous museum, is a must-visit for anyone with a slight interest in art. Some of the museum\\u0027s most ...\",\"DisplayUrl\":\"www.aviewoncities.com/paris/louvre.htm\",\"Url\":\"http://www.aviewoncities.com/paris/louvre.htm\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=5&$top=1\",\"type\":\"WebResult\"},\"ID\":\"30a39184-2bd7-487f-9dd1-a32b0eecf770\",\"Title\":\"The Louvre Museum, Paris, France - A Paris Guide\",\"Description\":\"First stop in Paris for most art lovers is the Louvre, the largest museum in the western world\",\"DisplayUrl\":\"www.aparisguide.com/louvre\",\"Url\":\"http://www.aparisguide.com/louvre/\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=6&$top=1\",\"type\":\"WebResult\"},\"ID\":\"9fd6fc21-d19d-43fe-819e-38e2fa38d533\",\"Title\":\"The Louvre Museum: Facts, Paintings & Tickets\",\"Description\":\"The Louvre is the world’s largest museum and houses one of the most impressive art collections in history. The magnificent, baroque-style palace and museum ...\",\"DisplayUrl\":\"www.livescience.com/31935-louvre-museum.html\",\"Url\":\"http://www.livescience.com/31935-louvre-museum.html\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=7&$top=1\",\"type\":\"WebResult\"},\"ID\":\"ea6c7d95-6d7e-4873-8dc4-8406831b1a4b\",\"Title\":\"Hours & Admission | Louvre Museum | Paris\",\"Description\":\"Most viewed pages. Search the Collection; Search louvre.fr; Selected Works; Visitor Trails; Advance Tickets ; Calendar. Friday Mar 13. Featured events. Exhibition\",\"DisplayUrl\":\"www.louvre.fr/en/hours-admission\",\"Url\":\"http://www.louvre.fr/en/hours-admission\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=8&$top=1\",\"type\":\"WebResult\"},\"ID\":\"97843fdc-28ea-423b-ac13-e1da136e3556\",\"Title\":\"Louvre Pyramid, Paris - A View On Cities\",\"Description\":\"The Louvre Pyramid was built in the 1980s as the main entrance to the Louvre Museum. The modern glass structure, which forms a nice contrast with the historic facades ...\",\"DisplayUrl\":\"www.aviewoncities.com/paris/louvrepyramid.htm\",\"Url\":\"http://www.aviewoncities.com/paris/louvrepyramid.htm\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=9&$top=1\",\"type\":\"WebResult\"},\"ID\":\"73d50838-a8a8-44c7-bf26-8ef650a67c68\",\"Title\":\"The Louvre | Rue de Rivoli 1er | Attractions | Time Out Paris\",\"Description\":\"Read Time Out\\u0027s review of The Louvre below or click here for our exclusive photo tour of the museum. The world\\u0027s largest museum is also its most visited, with...\",\"DisplayUrl\":\"www.timeout.com/paris/en/museums/the-louvre\",\"Url\":\"http://www.timeout.com/paris/en/museums/the-louvre\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=10&$top=1\",\"type\":\"WebResult\"},\"ID\":\"c7d216f1-2939-4486-906e-c2bbad8917f6\",\"Title\":\"Revamping the Louvre to Lose That Lost Feeling - NYTimes.com\",\"Description\":\"Jean-Luc Martinez, the president of the Louvre, is overseeing a nearly $67 million makeover to help newcomers crack the code of the labyrinthine museum.\",\"DisplayUrl\":\"www.nytimes.com/2014/12/15/arts/design/revamping-the-louvre-to...\",\"Url\":\"http://www.nytimes.com/2014/12/15/arts/design/revamping-the-louvre-to-lose-that-lost-feeling.html\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=11&$top=1\",\"type\":\"WebResult\"},\"ID\":\"47febf9c-dab5-4d13-93d4-b475797c3fb6\",\"Title\":\"The museum itself is amazing and worth... - Musee du Louvre\",\"Description\":\"Musee du Louvre: The museum itself is amazing and worth every dime if you love art or history. - See 33,967 traveler reviews, 12,263 candid photos, and ...\",\"DisplayUrl\":\"www.tripadvisor.com/ShowUserReviews-g187147-d188757-r259505004...\",\"Url\":\"http://www.tripadvisor.com/ShowUserReviews-g187147-d188757-r259505004-Musee_du_Louvre-Paris_Ile_de_France.html\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=12&$top=1\",\"type\":\"WebResult\"},\"ID\":\"f6467d54-0b21-4c47-8266-55eda52896c1\",\"Title\":\"Six Things You May Not Know About the Louvre — History ...\",\"Description\":\"On August 10, 1793, the Musée du Louvre, located on Paris’ Right Bank, opened its doors to the public. For more than 600 years, the Louvre had been a symbol of the ...\",\"DisplayUrl\":\"www.history.com/news/six-things-you-may-not-know-about-the-louvre\",\"Url\":\"http://www.history.com/news/six-things-you-may-not-know-about-the-louvre\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=13&$top=1\",\"type\":\"WebResult\"},\"ID\":\"3e2ca4f6-e2ac-41a3-9a9f-3a48f910aa29\",\"Title\":\"Facts on the Louvre Museum in Paris , France | USA Today\",\"Description\":\"The Louvre, which is along the banks of the Seine River in Paris, is the world\\u0027s largest museum and one of the most well-known museums in the world.\",\"DisplayUrl\":\"traveltips.usatoday.com/louvre-museum-paris-france-60153.html\",\"Url\":\"http://traveltips.usatoday.com/louvre-museum-paris-france-60153.html\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=14&$top=1\",\"type\":\"WebResult\"},\"ID\":\"699cdaac-6a66-4665-a7d7-cf94c2834ade\",\"Title\":\"What is the purpose the Louvre - Answers.com\",\"Description\":\"The Louvre is located in Paris, France. It is the home to the Mona Lisa. Originally it was a Palace for French Royalty. It was built by Louis XIV \\u0027The Sun King\\u0027\",\"DisplayUrl\":\"www.answers.com/Q/What_is_the_purpose_the_Louvre\",\"Url\":\"http://www.answers.com/Q/What_is_the_purpose_the_Louvre\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=15&$top=1\",\"type\":\"WebResult\"},\"ID\":\"95f35def-4558-42b6-b010-e78387adb473\",\"Title\":\"The Louvre Museum in Paris - Visitor Information\",\"Description\":\"A complete overview of the Louvre Museum in Paris, France, including opening hours, collection highlights, and tons of helpful tips for visitors.\",\"DisplayUrl\":\"goparis.about.com/od/parismuseums/a/Louvre_Museum.htm\",\"Url\":\"http://goparis.about.com/od/parismuseums/a/Louvre_Museum.htm\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=16&$top=1\",\"type\":\"WebResult\"},\"ID\":\"20c05507-f579-4196-ad56-41ea0aa4014b\",\"Title\":\"\\\" Gallery of the Louvre \\\" - The Painting - Samuel Morse\",\"Description\":\"The \\\"Gallery of the Louvre\\\" is a 6x9 foot painting containing 38 works of art from the Louvre in Paris. Samuel Morse wanted to \\u0027rehang\\u0027 Italian and French Renaissance ...\",\"DisplayUrl\":\"www.galleryofthelouvre.com/the-painting.html\",\"Url\":\"http://www.galleryofthelouvre.com/the-painting.html\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=17&$top=1\",\"type\":\"WebResult\"},\"ID\":\"6ef347a8-7a8a-4104-9ebe-d96a786089c4\",\"Title\":\"Inside the Louvre pyramid - \\u003eFromParis : Panoramas ...\",\"Description\":\"Louvre: The building The first royal \\\"Castle of the Louvre\\\" on this site was founded by Philippe II at the end of the 13th century, as a fortress to defend Paris on ...\",\"DisplayUrl\":\"fromparis.com/inside-the-louvre-pyramid.html\",\"Url\":\"http://fromparis.com/inside-the-louvre-pyramid.html\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=18&$top=1\",\"type\":\"WebResult\"},\"ID\":\"8b03c3ac-b46c-4aca-bed9-781b238179c3\",\"Title\":\"The History of the Louvre - Paris.Answers.com\",\"Description\":\"The history of the Louvre dates back centuries and is filled with interesting facts. It is now a museum in Paris which is open almost every day of the year except ...\",\"DisplayUrl\":\"paris.answers.com/historical-landmarks/the-history-of-the-louvre\",\"Url\":\"http://paris.answers.com/historical-landmarks/the-history-of-the-louvre\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=19&$top=1\",\"type\":\"WebResult\"},\"ID\":\"52dfd16e-d18d-4758-89be-fbeee8d88cff\",\"Title\":\"The Louvre: All the Paintings: Vincent Pomarède, Erich ...\",\"Description\":\"An historic publishing event! Endorsed by the Louvre and for the first time ever, every painting from the world\\u0027s most popular museum is available in one stunning book.\",\"DisplayUrl\":\"www.amazon.com/The-Louvre-Paintings-Vincent-Pomarède/dp/1579128866\",\"Url\":\"http://www.amazon.com/The-Louvre-Paintings-Vincent-Pomar%C3%A8de/dp/1579128866\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=20&$top=1\",\"type\":\"WebResult\"},\"ID\":\"fdacee62-395b-4bab-bce7-7f6a9f734499\",\"Title\":\"The Louvre Review | Fodor\\u0027s Travel\",\"Description\":\"The Louvre comprises three wings—the Richelieu, the Sully, and the Denon—arranged like a horseshoe, with the Pyramide nestled outside in the middle.\",\"DisplayUrl\":\"www.fodors.com/.../paris/things-to-do/sights/reviews/the-louvre-111758\",\"Url\":\"http://www.fodors.com/world/europe/france/paris/things-to-do/sights/reviews/the-louvre-111758\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=21&$top=1\",\"type\":\"WebResult\"},\"ID\":\"e46437b0-5dab-449f-b299-3d4279af86f8\",\"Title\":\"Louvre Museum | museum, Paris, France | Encyclopedia ...\",\"Description\":\"Louvre Museum, French Musée du Louvre, official name Great Louvre, French Grand Louvre, national museum and art gallery of France, housed in part of a large palace ...\",\"DisplayUrl\":\"www.britannica.com/EBchecked/topic/349409\",\"Url\":\"http://www.britannica.com/EBchecked/topic/349409/Louvre-Museum\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=22&$top=1\",\"type\":\"WebResult\"},\"ID\":\"9505b64e-5965-4858-8cc7-ee1641fdc77a\",\"Title\":\"Amazon.com: The Louvre: Charles Boyer, John Sughrue Jr ...\",\"Description\":\"A guided tour through the Louvre and a presentation of the history of this world-famous French landmark, showing how it became the scene of many world-shaking events ...\",\"DisplayUrl\":\"www.amazon.com/The-Louvre-Charles-Boyer/dp/B0009MDPTC\",\"Url\":\"http://www.amazon.com/The-Louvre-Charles-Boyer/dp/B0009MDPTC\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=23&$top=1\",\"type\":\"WebResult\"},\"ID\":\"12feac3a-59e6-48cb-a819-003c8f6f6e0e\",\"Title\":\"Visiting the Louvre - EuroCheapo.com - Expert Reviews of ...\",\"Description\":\"The Louvre Museum, the famous fortress-turned-palace-turned-museum is one of the world’s most visited – if not the most visited – collections of art.\",\"DisplayUrl\":\"www.eurocheapo.com/paris/features/visiting-the-louvre.html\",\"Url\":\"http://www.eurocheapo.com/paris/features/visiting-the-louvre.html\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=24&$top=1\",\"type\":\"WebResult\"},\"ID\":\"4aba1a04-2abf-4037-b578-b50ce38bdeb3\",\"Title\":\"Louvre | Define Louvre at Dictionary.com\",\"Description\":\"noun 1. any of a set of horizontal parallel slats in a door or window, sloping outwards to throw off rain and admit air Also called louvre boards. the slats together ...\",\"DisplayUrl\":\"dictionary.reference.com/browse/louvre?s=t\",\"Url\":\"http://dictionary.reference.com/browse/louvre?s=t\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=25&$top=1\",\"type\":\"WebResult\"},\"ID\":\"d2e2ad66-12e0-46de-9289-38486e9c5a2c\",\"Title\":\"Why the Louvre Abu Dhabi is worth celebrating, despite its ...\",\"Description\":\"The Louvre Abu Dhabi looks set to open in 2016, as work on Jean Nouvel’s colossal construction speeds up and his vision of a modern medina starts to ...\",\"DisplayUrl\":\"www.theguardian.com/.../09/louvre-abu-dhabi-worth-celebrating-jean...\",\"Url\":\"http://www.theguardian.com/artanddesign/jonathanjonesblog/2015/mar/09/louvre-abu-dhabi-worth-celebrating-jean-nouvel-human-rights\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=26&$top=1\",\"type\":\"WebResult\"},\"ID\":\"4c25b5bc-8600-4eea-a333-24a12d79d55e\",\"Title\":\"louvre - definition of louvre by The Free Dictionary\",\"Description\":\"I spent long hours in the Louvre, the most friendly of all galleries and the most convenient for meditation; or idled on the quays, fingering second-hand books that I ...\",\"DisplayUrl\":\"www.thefreedictionary.com/louvre\",\"Url\":\"http://www.thefreedictionary.com/louvre\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=27&$top=1\",\"type\":\"WebResult\"},\"ID\":\"58d996d6-9c45-4cc1-bd57-313974f0dfc9\",\"Title\":\"Le Musee du Louvre - The Louvre Museum - Discover France ...\",\"Description\":\"Evening view, courtyard of the Louvre and I.M. Pei pyramid. (Photographer: Benh Lieu Song.) Louvre {loov\\u0027-ruh} — a French palace and the national art museum of France.\",\"DisplayUrl\":\"www.discoverfrance.net/France/Paris/Museums-Paris/Louvre.shtml\",\"Url\":\"http://www.discoverfrance.net/France/Paris/Museums-Paris/Louvre.shtml\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=28&$top=1\",\"type\":\"WebResult\"},\"ID\":\"1efeeba6-2ca3-433a-89bd-1891079ce5a4\",\"Title\":\"How To Visit The Louvre – More Than One Secret Entrance ...\",\"Description\":\"TweetSharebar Tweet You would think something as widely reported and overstated online as “Secret Entrance To The Louvre!!!” would quickly stop being a secret.\",\"DisplayUrl\":\"www.landingstanding.com/secret-entrance-to-the-louvre\",\"Url\":\"http://www.landingstanding.com/secret-entrance-to-the-louvre/\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=29&$top=1\",\"type\":\"WebResult\"},\"ID\":\"537df5fa-162e-441b-9228-2dfa8b09eaa6\",\"Title\":\"The Louvre Guide for Nintendo 3DS - Official Site\",\"Description\":\"The Louvre in the comfort of your home! Nintendo 3DS Guide: Louvre is a piece of software designed for visitors to the Louvre Museum in France.\",\"DisplayUrl\":\"louvreguide.nintendo.com\",\"Url\":\"http://louvreguide.nintendo.com/\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=30&$top=1\",\"type\":\"WebResult\"},\"ID\":\"e5aaf860-d255-458e-a595-8dc88a20fce3\",\"Title\":\"Musée du Louvre - Lonely Planet\",\"Description\":\"Few art galleries are as prized or daunting as the Musée du Louvre, Paris’ pièce de résistance no first-time visitor to the city can resist.\",\"DisplayUrl\":\"www.lonelyplanet.com/.../sights/museums-galleries/musee-du-louvre\",\"Url\":\"http://www.lonelyplanet.com/france/paris/sights/museums-galleries/musee-du-louvre\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=31&$top=1\",\"type\":\"WebResult\"},\"ID\":\"86156c77-5c11-452f-af3e-f2bc9de23051\",\"Title\":\"The Louvre: All the Paintings by Erich Lessing ...\",\"Description\":\"An historic publishing event! Endorsed by the Louvre and for the first time ever, every painting from the world\\u0027s most popular museum is available in one stunning book.\",\"DisplayUrl\":\"www.barnesandnoble.com/w/the-louvre-erich-lessing/1113064131?ean=...\",\"Url\":\"http://www.barnesandnoble.com/w/the-louvre-erich-lessing/1113064131?ean=9781579128869\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=32&$top=1\",\"type\":\"WebResult\"},\"ID\":\"130f1077-4612-459e-956d-32dfe833b56f\",\"Title\":\"Unique Facts About Europe: The Louvre - Sheppard Software ...\",\"Description\":\"The Louvre . The Louvre Museum (Musée du Louvre) in Paris, France, is one of the largest and most famous museums in the world. The building, a former royal palace ...\",\"DisplayUrl\":\"www.sheppardsoftware.com/Europeweb/factfile/Unique-facts-Europe25.htm\",\"Url\":\"http://www.sheppardsoftware.com/Europeweb/factfile/Unique-facts-Europe25.htm\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=33&$top=1\",\"type\":\"WebResult\"},\"ID\":\"b6437882-34ea-4b13-81dc-13141860490f\",\"Title\":\"The Louvre: All the Paintings by Erich Lessing — Reviews ...\",\"Description\":\"The Louvre has 152 ratings and 20 reviews. Linda said: Having lived in Europe for a time, I was a huge Museé du Louvre fan. So when my dear husband boug...\",\"DisplayUrl\":\"www.goodreads.com/book/show/11257169\",\"Url\":\"http://www.goodreads.com/book/show/11257169-the-louvre\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=34&$top=1\",\"type\":\"WebResult\"},\"ID\":\"42345d1a-c154-4333-a5b2-1fd8a1e5e7c9\",\"Title\":\"What To See At The Louvre in Paris - Business Insider\",\"Description\":\"Paris\\u0027s Musée du Louvre is consistently the world\\u0027s most visited museum—and for good reason. The grand art museum houses 35,000 masterpieces, from prehistory to ...\",\"DisplayUrl\":\"www.businessinsider.com/what-to-see-at-the-louvre-in-paris-2013-7?op=1\",\"Url\":\"http://www.businessinsider.com/what-to-see-at-the-louvre-in-paris-2013-7?op=1\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=35&$top=1\",\"type\":\"WebResult\"},\"ID\":\"14855ace-085a-4b07-9c1b-4fcc243b755d\",\"Title\":\"5 tips for visiting the Louvre Museum | Venere Travel Blog\",\"Description\":\"The Musée du Louvre in Paris is perhaps the most famous museum in the world. As a result, it’s also one of the busiest visitor attractions in Paris.\",\"DisplayUrl\":\"www.venere.com/blog/louvre-museum-tips\",\"Url\":\"http://www.venere.com/blog/louvre-museum-tips/\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=36&$top=1\",\"type\":\"WebResult\"},\"ID\":\"9566307c-e188-407a-9626-9a17b8a229b7\",\"Title\":\"Facts about the Louvre - Travel France\",\"Description\":\"Facts about the Louvre abound! One of the world\\u0027s largest and most renowned museums of art, the Musee du Louvre is a central landmark in the city of Paris.\",\"DisplayUrl\":\"www.visit-and-travel-france.com/facts-about-the-louvre.html\",\"Url\":\"http://www.visit-and-travel-france.com/facts-about-the-louvre.html\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=37&$top=1\",\"type\":\"WebResult\"},\"ID\":\"3289afa8-4c8d-4aef-8452-f946540a4072\",\"Title\":\"History of the Louvre Museum in Paris , France\",\"Description\":\"The immediately visible part of the palace that houses the Louvre Museum in Paris was mostly completed in the 19th century, but the site stretches all the way to the ...\",\"DisplayUrl\":\"goparis.about.com/od/parismuseums/a/louvre-museum-history.htm\",\"Url\":\"http://goparis.about.com/od/parismuseums/a/louvre-museum-history.htm\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=38&$top=1\",\"type\":\"WebResult\"},\"ID\":\"82bbeec9-9a17-464b-8691-ef1d76d66c8d\",\"Title\":\"Louvre Tours, Paris Tours & Day Trips | My Louvre Tour\",\"Description\":\"MyLouvreTour.com is an officially licensed tour operator, recognized by the Louvre to skip waiting in the long line to access the Louvre Museums via pre-reserved entry.\",\"DisplayUrl\":\"www.mylouvretour.com\",\"Url\":\"http://www.mylouvretour.com/\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=39&$top=1\",\"type\":\"WebResult\"},\"ID\":\"afc07f03-9779-452f-bb42-b53f515a1adc\",\"Title\":\"The Louvre Museum - Art Wiki - Art.com blog\",\"Description\":\"The Louvre was originally built by royal architect Pierre Lescot as a palace for King Francis I. Although construction began in 1546, the Louvre Museum was not ...\",\"DisplayUrl\":\"blog.art.com/wiki/louvre-museum\",\"Url\":\"http://blog.art.com/wiki/louvre-museum/\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=40&$top=1\",\"type\":\"WebResult\"},\"ID\":\"91f1de51-6714-46e8-bd21-27ca22a44908\",\"Title\":\"S.F.B. Morse: Gallery of the Louvre - UW Faculty Web Server\",\"Description\":\"S.F.B. Morse: Gallery of the Louvre George L. Dillon, Collaborating with Jan Zielinski. Had Samuel F.B. Morse succeeded in his ambition to become a great American ...\",\"DisplayUrl\":\"faculty.washington.edu/dillon/Morse_Gallery\",\"Url\":\"http://faculty.washington.edu/dillon/Morse_Gallery/\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=41&$top=1\",\"type\":\"WebResult\"},\"ID\":\"39fc9213-3f7f-4dea-ae07-123cfbc3ef23\",\"Title\":\"Louvre Museum opens - Aug 10, 1793 - HISTORY.com\",\"Description\":\"On this day in History, Louvre Museum opens on Aug 10, 1793. Learn more about what happened today on History.\",\"DisplayUrl\":\"www.history.com/this-day-in-history/louvre-museum-opens\",\"Url\":\"http://www.history.com/this-day-in-history/louvre-museum-opens\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=42&$top=1\",\"type\":\"WebResult\"},\"ID\":\"4ce0a1f6-d200-4899-aed5-3eb13252431c\",\"Title\":\"The Louvre, Paris, France panorama in Paris - 360Cities\",\"Description\":\"Louvre Museum — is a historic monument in Paris and the national museum of France. It is a central landmark of the city, located on the Right Bank of the Seine in ...\",\"DisplayUrl\":\"www.360cities.net/image/france-paris-louvre\",\"Url\":\"http://www.360cities.net/image/france-paris-louvre\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=43&$top=1\",\"type\":\"WebResult\"},\"ID\":\"d7896ed5-8793-4623-8b03-eafc1490c4b6\",\"Title\":\"Paris Hotels - hotels in Louvre district\",\"Description\":\"Pariserve - Hotels Paris : selection of the most charming hotels and furnished apartments in Paris. Envied locations, calm and cosy atmosphere, elegance, charming ...\",\"DisplayUrl\":\"www.pariserve.com/louvre.htm\",\"Url\":\"http://www.pariserve.com/louvre.htm\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=44&$top=1\",\"type\":\"WebResult\"},\"ID\":\"378cc322-6c63-467f-922d-8509b725849c\",\"Title\":\"Museum Secrets Revealed: Inside the Louvre | Smithsonian ...\",\"Description\":\"Paris is a city of romance, legends, lights and mysteries. At its center stands the Louvre, once a royal palace and now arguably the greatest museum in the world.\",\"DisplayUrl\":\"www.smithsonianchannel.com/.../inside-the-louvre/1002922/3365398\",\"Url\":\"http://www.smithsonianchannel.com/shows/museum-secrets-revealed/inside-the-louvre/1002922/3365398\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=45&$top=1\",\"type\":\"WebResult\"},\"ID\":\"765e4e4e-87ff-4c15-90b8-507825572997\",\"Title\":\"How To Enjoy the Louvre Museum in Paris - About.com Travel\",\"Description\":\"The Louvre Museum in Paris is immense, and one could spend a week exploring its exhibits. Unfortunately, most of us don\\u0027t have that kind of time.\",\"DisplayUrl\":\"gofrance.about.com/od/parisattractions/ht/louvre.htm\",\"Url\":\"http://gofrance.about.com/od/parisattractions/ht/louvre.htm\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=46&$top=1\",\"type\":\"WebResult\"},\"ID\":\"3f09b245-071d-4b3d-8cf4-426d602c0afc\",\"Title\":\"Louvre Museum - Free Entry to the Louvre Museum with Paris ...\",\"Description\":\"The Louvre Museum is unquestionably one of the finest art galleries in the world and home to thousands of classic and modern masterpieces.\",\"DisplayUrl\":\"www.parispass.com/paris-attractions/Louvre-Museum.html\",\"Url\":\"http://www.parispass.com/paris-attractions/Louvre-Museum.html\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=47&$top=1\",\"type\":\"WebResult\"},\"ID\":\"6c8add0c-4273-4158-aa21-3a196c7a8d85\",\"Title\":\"some LANDSCAPES: The Louvre of the Pebble\",\"Description\":\"That bowl obscured by pebbles was a version of schiff, in which the German word for ship is reflected to suggest the presence of water. The lettering was ...\",\"DisplayUrl\":\"some-landscapes.blogspot.com/2015/02/the-louvre-of-pebble.html\",\"Url\":\"http://some-landscapes.blogspot.com/2015/02/the-louvre-of-pebble.html\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=48&$top=1\",\"type\":\"WebResult\"},\"ID\":\"151a7317-4837-4396-a55d-eba695556454\",\"Title\":\"Louvre Museum History, Facts & Location – Paris, France\",\"Description\":\"The Louvre is the national museum of France. It is situated in the capital city of Paris. The museum is considered by many to be the best in the world.\",\"DisplayUrl\":\"famouswonders.com/louvre-museum-in-paris\",\"Url\":\"http://famouswonders.com/louvre-museum-in-paris/\"},{\"__metadata\":{\"uri\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the louvre is\\u0027&$skip=49&$top=1\",\"type\":\"WebResult\"},\"ID\":\"bbc76261-1036-4f39-bb58-d22c580920e3\",\"Title\":\"10 Incredible Things to See in the Louvre - Cultural ...\",\"Description\":\"On my first trip to Paris, I went to the Louvre – saw the huge line of people waiting to go into the glass pyramid and said “Forget this, I’d rather walk along ...\",\"DisplayUrl\":\"www.vagobond.com/10-things-to-see-in-the-louvre-cultural-travel\",\"Url\":\"http://www.vagobond.com/10-things-to-see-in-the-louvre-cultural-travel/\"}],\"__next\":\"https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=\\u0027the%20louvre%20is\\u0027&$skip=50&$top=50\"}}";
    }
    
    public static String search(String query){        
    	String accountKey = API_KEY;
    	String searchText = query;
    	StringBuilder response = new StringBuilder();
    	String output;	        	       
    	
    	//Replace all spaces with URL encoded space.
        searchText = searchText.replaceAll(" ", "%20");        
      
        byte[] accountKeyBytes = Base64.encodeBase64((accountKey + ":" + accountKey).getBytes());
        String accountKeyEnc = new String(accountKeyBytes);
    	
		try{
		    URL url = new URL("https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=%27" + searchText + "%27&$top=50&$format=json");        
			
		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Authorization", "Basic " + accountKeyEnc);
			
		    BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));		    
		    		    
		    while ((output = br.readLine()) != null) {
		        response.append(output);	              
		    }
		    
		    conn.disconnect();		    
		} 
        catch (MalformedURLException e1) {
	         // TODO Auto-generated catch block
	         e1.printStackTrace();
	    } 
		catch (IOException e) {
	         // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
		
		return response.toString();
    }
}