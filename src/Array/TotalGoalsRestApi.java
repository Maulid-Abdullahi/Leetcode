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
import java.net.URLEncoder;

public class TotalGoalsRestApi {
    public static int getNumDraws(String team ,int year) throws IOException, ScriptException {
        final String endpoint = "https://jsonmock.heckerrank.com/api/football_matches";
        int team1goalsAthome = getPageTotalgoals(String.format(endpoint + "?team1=%s&year=%d",
                URLEncoder.encode(team, "UTF-8"),year),0,"team1", 1);
        int team1goalsAtVisiting = getPageTotalgoals(String.format(endpoint + "?team2=%s&year=%d",
                URLEncoder.encode(team, "UTF-8"),year),0,"team2", 1);
        return team1goalsAthome + team1goalsAtVisiting;

    }

    private static int getPageTotalgoals(String request, int total_goals, String team, int page) throws IOException, ScriptException {
        URL url = new URL(request + "&page" + page);
        HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("Get");
        httpURLConnection.setConnectTimeout(50000);
        httpURLConnection.setReadTimeout(50000);
        httpURLConnection.addRequestProperty("Content-Type","Application/json");

        int status =httpURLConnection.getResponseCode();

        InputStream in = (status < 200 || status > 299) ? httpURLConnection.getErrorStream() : httpURLConnection.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String responseLine;

        StringBuffer responsecontent = new StringBuffer();

        while((responseLine = br.readLine()) != null){
            responsecontent.append(responseLine);

            br.close();

            httpURLConnection.disconnect();

            ScriptEngineManager manager = new ScriptEngineManager();

            ScriptEngine engine = manager.getEngineByName("javascript");
            String script = "var obj = JSON.parse('"+responsecontent.toString()+"');";
            script += "var total_pages = obj.total_pages";
            script += "var total_goals = obj.data.reduce(function(accumulator, current){return accumulator + parseInt(current." + team + " goals);},)";

            engine.eval(script);
            if(engine.get("total_pages") == null) {
                throw new RuntimeException("Can not retrieve data from server");
            }
                int total_pages = (int) engine.get("total_pages");
                 total_goals = (int) Double.parseDouble(engine.get("total_goals").toString());

                return(page < total_pages) ? getPageTotalgoals(request, total_goals, team, page+1) : total_goals;


        }
        return  0;
    }
}
