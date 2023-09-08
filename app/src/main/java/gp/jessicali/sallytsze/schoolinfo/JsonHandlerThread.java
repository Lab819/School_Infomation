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
                for (int i = 0; i < jsonObj.length(); i++) {
                    JSONObject c = jsonObj.getJSONObject(i);

                    String A = c.getString("SCHOOL NO.");
                    String B = c.getString("ENGLISH CATEGORY");
                    String C = c.getString("中文類別");
                    String D = c.getString("ENGLISH NAME");
                    String E = c.getString("中文名稱");
                    String F = c.getString("ENGLISH ADDRESS");
                    String G = c.getString("中文地址");
                    String H = c.getString("LONGITUDE");
                    String I = c.getString("經度");
                    String J = c.getString("LATITUDE");
                    String K = c.getString("緯度");
                    String L = c.getString("EASTING");
                    String M = c.getString("坐標東");
                    String N = c.getString("NORTHING");
                    String O = c.getString("坐標北");
                    String P = c.getString("STUDENTS GENDER");
                    String Q = c.getString("就讀學生性別");
                    String R = c.getString("SESSION");
                    String S = c.getString("學校授課時間");
                    String T = c.getString("DISTRICT");
                    String U = c.getString("分區");
                    String V = c.getString("FINANCE TYPE");
                    String W = c.getString("資助種類");
                    String X = c.getString("SCHOOL LEVEL");
                    String Y = c.getString("學校類型");
                    String Z = c.getString("TELEPHONE");
                    String AA = c.getString("聯絡電話");
                    String AB = c.getString("FAX NUMBER");
                    String AC = c.getString("傳真號碼");
                    String AD = c.getString("WEBSITE");
                    String AE = c.getString("網頁");
                    String AF = c.getString("RELIGION");
                    String AG = c.getString("宗教");

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
