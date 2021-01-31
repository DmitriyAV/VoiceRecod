package grammars;


import java.io.*;
import java.net.URL;

import com.itextpdf.text.Image;
import com.voicerecoder.VoiceRecogniz;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import javax.sound.midi.VoiceStatus;

import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfDocument;


public class JSONobject {

/*    public static String read(Reader re) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = re.read()) != -1) {

            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject getJsonStringFromFile(String html) throws IOException {

        try (InputStream is = new URL(html).openStream();
             BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
            String jsonText = read(rd);

            return new JSONObject(jsonText);
        }
    }

    public static String getValue() throws IOException {
    JSONObject j = getJsonStringFromFile(url);
        JSONArray results_arr = j.getJSONArray("results");
        for (int i = 0; i<2; i++){
            JSONObject json = results_arr.getJSONObject(i).getJSONObject(url);
            return json.toString();
        }return null;
    }*/

    public static String newURLs(String url) {

        HttpsURLConnection con = null;
        try {
            URL u = new URL(url);
            con = (HttpsURLConnection) u.openConnection();

            con.connect();


            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            br.close();
            return sb.toString();


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void start(String nUrl) {
        String json = newURLs(nUrl);
        JSONObject obj = null;
        try {

            obj = new JSONObject(json);
            JSONArray results_arr = obj.getJSONArray("results");
            for (int i = 0; i < results_arr.length(); i++) {
                // get the place id of each object in JSON (Google Search API)
                JSONObject place_id = results_arr.getJSONObject(i).getJSONObject("urls");
                for (int j = 0; j < i; j++) {
                    String picJson = place_id.getString("regular");
                    System.out.println(picJson);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void pic(String pic) {
        PdfDocument document = new PdfDocument();

        try {
            PdfWriter.getInstance(document,
                    new FileOutputStream("Image.pdf"));
            document.open();

            Image image1 = Image.getInstance("watermark.png");
            document.add(image1);


            Image image2 = Image.getInstance(new URL(pic));
            document.add(image2);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

