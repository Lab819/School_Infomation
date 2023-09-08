package gp.jessicali.sallytsze.schoolinfo;

import java.util.ArrayList;
import java.util.HashMap;

// A utility class for creating contact list
public class SchoolInfo {
    public static String SCHOOLNO = "A";
    public static String CATEGORY = "B";
    public static String CHCATEGORY = "C";
    public static String NAME = "D";
    public static String CHNAME = "E";
    public static String ADDRESS = "F";
    public static String CHADDRESS = "G";
    public static String LONGITUDE = "H";
    public static String CHLONGITUDE = "I";
    public static String LATITUDE = "J";
    public static String CHLATITUDE = "K";
    public static String EASTING = "L";
    public static String CHEASTING = "M";
    public static String NORTHING = "N";
    public static String CHNORTHING = "O";
    public static String STUDENTSGENDER = "P";
    public static String CHSTUDENTSGENDER = "Q";
    public static String SESSION = "R";
    public static String CHSESSION = "S";
    public static String DISTRICT = "T";
    public static String CHDISTRICT = "U";
    public static String FINANCETYPE = "V";
    public static String CHFINANCETYPE = "W";
    public static String SCHOOLLEVEL = "X";
    public static String CHSCHOOLLEVEL = "Y";
    public static String TELEPHONE = "Z";
    public static String CHTELEPHONE = "AA";
    public static String FAXNUMBER = "AB";
    public static String CHFAXNUMBER = "AC";
    public static String WEBSITE = "AD";
    public static String CHWEBSITE = "AE";
    public static String RELIGION = "AF";
    public static String CHRELIGION = "AG";

    //"infoList"
    //it is used in JsonHandlerThread and also MainActivity program
    public static ArrayList<HashMap<String, String>> infoList = new ArrayList<>();

    // Creates and add contact to contact list
    public static void addContact(String A, String B, String C, String D, String E,
                                  String F, String G, String H, String I, String J,
                                  String K, String L, String M, String N, String O,
                                  String P, String Q, String R, String S, String T, String U,
                                  String V, String W, String X, String Y, String Z, String AA, String AB, String AC,
                                  String AD, String AE, String AF, String AG) {
        // Create contact
        HashMap<String, String> info = new HashMap<>();
        info.put(SCHOOLNO, A);
        info.put(CATEGORY, B);
        info.put(CHCATEGORY, C);
        info.put(NAME, D);
        info.put(CHNAME, E);
        info.put(ADDRESS, F);
        info.put(CHADDRESS, G);
        info.put(LONGITUDE, H);
        info.put(CHLONGITUDE, I);
        info.put(LATITUDE, J);
        info.put(CHLATITUDE, K);
        info.put(EASTING, L);
        info.put(CHEASTING, M);
        info.put(NORTHING, N);
        info.put(CHNORTHING, O);
        info.put(STUDENTSGENDER, P);
        info.put(CHSTUDENTSGENDER, Q);
        info.put(SESSION, R);
        info.put(CHSESSION, S);
        info.put(DISTRICT, T);
        info.put(CHDISTRICT, U);
        info.put(FINANCETYPE, V);
        info.put(CHFINANCETYPE, W);
        info.put(SCHOOLLEVEL, X);
        info.put(CHSCHOOLLEVEL, Y);
        info.put(TELEPHONE, Z);
        info.put(CHTELEPHONE, AA);
        info.put(FAXNUMBER, AB);
        info.put(CHFAXNUMBER, AC);
        info.put(WEBSITE, AD);
        info.put(CHWEBSITE, AE);
        info.put(RELIGION, AF);
        info.put(CHRELIGION, AG);

        infoList.add(info);
    }

    public static HashMap<String, String> getInfoList(int index) {
        return SchoolInfo.infoList.get(index);
    }

}
