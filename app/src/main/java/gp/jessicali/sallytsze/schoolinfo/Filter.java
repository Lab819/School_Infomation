package gp.jessicali.sallytsze.schoolinfo;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Filter {

    public static ArrayList<HashMap<String, String>> filterList = new ArrayList<>();

    public static JSONObject obj;

    public static Boolean doFilter(int i, String schoolName, String district, String schoolLevel, String financeType
            , String studentGender, String religion, String session) {
        obj = new JSONObject(SchoolInfo.getInfoList(i));

        return checkName(schoolName) && checkDistrict(district) && checkSchoolLevel(schoolLevel)
                && checkFinanceType(financeType) && checkStudentGender(studentGender)
                && checkReligion(religion) && checkSession(session);
    }

    public static Boolean checkName(String name) {
        if ("--".equals(name))
            return true;
        else {
            try {
                if (obj.getString("E").contains(name)
                        || obj.getString("D").contains(name)) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static Boolean checkDistrict(String district) {
        if ("--".equals(district))
            return true;
        else {
            try {
                if (obj.getString("U").contains(district)
                        || obj.getString("T").contains(district)) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static Boolean checkSchoolLevel(String schoolLevel) {
        if ("--".equals(schoolLevel))
            return true;
        else {
            try {
                if (obj.getString("Y").contains(schoolLevel)
                        || obj.getString("X").contains(schoolLevel)) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static Boolean checkFinanceType(String financeType) {
        if ("--".equals(financeType))
            return true;
        else {
            try {
                if (obj.getString("W").contains(financeType)
                        || obj.getString("V").contains(financeType)) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static Boolean checkStudentGender(String studentGender) {
        if ("--".equals(studentGender))
            return true;
        else {
            try {
                if (obj.getString("Q").contains(studentGender)
                        || obj.getString("P").contains(studentGender)) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static Boolean checkReligion(String religion) {
        if ("--".equals(religion))
            return true;
        else if ("NOT APPLICABLE".equals(religion)) {
            try {
                if (obj.getString("AG").contains("NOT APPLICABLE")
                        || obj.getString("AG").contains("N.A.")
                        || obj.getString("AF").contains("NOT APPLICABLE")
                        || obj.getString("AF").contains("N.A.")) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                if (obj.getString("AG").contains(religion)
                        || obj.getString("AF").contains(religion)) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static Boolean checkSession(String session) {
        if ("--".equals(session))
            return true;
        else {
            try {
                if (obj.getString("S").contains(session)
                        || obj.getString("R").contains(session)) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
