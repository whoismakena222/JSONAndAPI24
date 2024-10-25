import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class B_JsonArrayPractice {

    public static void main(String[] args) throws ParseException {
        B_JsonArrayPractice practice = new B_JsonArrayPractice();
    }

    public B_JsonArrayPractice() throws ParseException {
        String s = "{\"name\":\"Darth Vader\"," +
                "\"height\":\"202\"," +
                "\"mass\":\"136\"," +
                "\"hair_color\":\"none\"," +
                "\"skin_color\":\"white\"," +
                "\"eye_color\":\"yellow\"," +
                "\"birth_year\":\"41.9BBY\"," +
                "\"gender\":\"male\"," +
                "\"homeworld\":\"https://swapi.dev/api/planets/1/\"," +
                "\"films\":[\"https://swapi.dev/api/films/1/\",\"https://swapi.dev/api/films/2/\",\"https://swapi.dev/api/films/3/\",\"https://swapi.dev/api/films/6/\"]," +
                "\"species\":[]," +
                "\"vehicles\":[]," +
                "\"starships\":[\"https://swapi.dev/api/starships/13/\"]," +
                "\"created\":\"2014-12-10T15:18:20.704000Z\",\"edited\":\"2014-12-20T21:17:50.313000Z\",\"url\":\"https://swapi.dev/api/people/4/\"}\n";

        JSONParser parser = new JSONParser();// parser turns a string into JSON object
        JSONObject json = (JSONObject) (parser.parse(s)); // parse s and turn it a JSON

        System.out.println("String format: " + s);
        System.out.println("JSON format: " + json); // --> string and json print differently

        // get a single value out of the json
        String height = (String) json.get("height");
        System.out.println("HEIGHT: " + height);
        // int h = integer.parseInt(height); - turn number string into int
        String birthYear = (String) json.get("birth_year");
        System.out.println("birth_year: " + birthYear);

        System.out.println("FILMS: " + json.get("films")); // ugly json format

        // get a json array out of the json - pretty formatting
        JSONArray filmsArray = (JSONArray) json.get("films"); // new array filled with films cast(recognized) to be an array
        int n = filmsArray.size(); // number of things in film
        System.out.println("FILMS: ");
        for (int i = 0; i < n; i++) {
            String film = (String) filmsArray.get(i); // .get(i) instead of [i] to get value
            System.out.println(film);
        }

        JSONArray starshipsArray = (JSONArray) json.get("starships");
        int m = starshipsArray.size();
        System.out.println("starships: ");
        for(int i = 0; i < m; i++){
            String starships = (String) starshipsArray.get(i);
            System.out.println(starships);
        }

        //jsons CAN be in another json

    } // end of constructor
}
