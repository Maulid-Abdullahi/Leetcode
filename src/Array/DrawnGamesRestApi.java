package Array;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DrawnGamesRestApi {
    public static int getNumDraws(int year) throws IOException, ScriptException {
        final String endpoint = "https://jsonmock.heckerrank.com/api/football_matches" + year;
        int gamesdrawn = 0;
        int maxscore = 10;

        for(int score = 0; score<=maxscore; score++){
            gamesdrawn += getGamesDrawn(String.format(endpoint + "&team1goals=%d&team2goals=%d", score, score));
        }
        return gamesdrawn;
    }
    private static int getGamesDrawn(String request) throws IOException, ScriptException {
        URL url = new URL(request);

        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setReadTimeout(50000);
        httpURLConnection.setConnectTimeout(50000);
        httpURLConnection.addRequestProperty("Content-Type", "application/json");

        int status = httpURLConnection.getResponseCode();

        InputStream in = (status < 200 || status > 299) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String responseLine;

        StringBuffer responsecontent  = new StringBuffer();
        while ((responseLine = br.readLine()) != null){
            responsecontent.append(responseLine);
        }
        br.close();
        httpURLConnection.disconnect();

        ScriptEngineManager manager = new ScriptEngineManager();

        ScriptEngine engine = manager.getEngineByName("javascript");

        String script = "var obj = JSON.parse('" + responsecontent.toString() + "');";
        script += "var total = obj.total;";

        engine.eval(script);

        if(engine.get("total") == null){
            throw  new RuntimeException("Can not retrieve data from server");
        }


        return (int) engine.get("total");


    }
}
