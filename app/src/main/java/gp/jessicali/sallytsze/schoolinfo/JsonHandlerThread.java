package gp.jessicali.sallytsze.schoolinfo;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

//Retrieve json from url
public class JsonHandlerThread extends Thread {
    private static final String TAG = "JsonHandlerThread";
    // URL to get contacts JSON file
    private static String jsonUrl = "https://www.edb.gov.hk/attachment/en/student-parents/sch-info/sch-search/sch-location-info/SCH_LOC_EDB.json";

    public static String makeRequest() {
        String response = null;
        try {
            URL url = new URL(jsonUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            response = inputStreamToString(in);
        } catch (MalformedURLException e) {
            Log.e(TAG, "MalformedURLException: " + e.getMessage());
        } catch (ProtocolException e) {
            Log.e(TAG, "ProtocolException: " + e.getMessage());
        } catch (IOException e) {
            Log.e(TAG, "IOException: " + e.getMessage());
        } catch (Exception e) {
            Log.e(TAG, "Exception: " + e.getMessage());
        }
        return response;
    }

    private static String inputStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = "";
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            Log.e(TAG, "IOException: " + e.getMessage());
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                Log.e(TAG, "IOException: " + e.getMessage());
            }
        }
        return sb.toString();
    }

    public void run() {
        String infoStr = makeRequest();

        if (infoStr != null) {
            try {
                JSONArray jsonObj = new JSONArray(infoStr);

                // looping through All Contacts
                for (int i = 1; i < jsonObj.length(); i++) {
                    JSONObject c = jsonObj.getJSONObject(i);

                    String A = c.getString("A");
                    String B = c.getString("B");
                    String C = c.getString("C");
                    String D = c.getString("D");
                    String E = c.getString("E");
                    String F = c.getString("F");
                    String G = c.getString("G");
                    String H = c.getString("H");
                    String I = c.getString("I");
                    String J = c.getString("J");
                    String K = c.getString("K");
                    String L = c.getString("L");
                    String M = c.getString("M");
                    String N = c.getString("N");
                    String O = c.getString("O");
                    String P = c.getString("P");
                    String Q = c.getString("Q");
                    String R = c.getString("R");
                    String S = c.getString("S");
                    String T = c.getString("T");
                    String U = c.getString("U");
                    String V = c.getString("V");
                    String W = c.getString("W");
                    String X = c.getString("X");
                    String Y = c.getString("Y");
                    String Z = c.getString("Z");
                    String AA = c.getString("AA");
                    String AB = c.getString("AB");
                    String AC = c.getString("AC");
                    String AD = c.getString("AD");
                    String AE = c.getString("AE");
                    String AF = c.getString("AF");
                    String AG = c.getString("AG");

                    SchoolInfo.addContact(A, B, C, D, E, F, G, H, I, J, K, L, M, N,
                            O, P, Q, R, S, T, U, V, W, X, Y, Z, AA, AB, AC, AD, AE, AF, AG);
                }
            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());
            }
        } else {
            Log.e(TAG, "Couldn't get json from server.");
        }
    }
}
