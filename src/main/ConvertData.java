package main;

import org.json.JSONObject;
import org.json.XML;
import org.json.JSONException;

public class ConvertData {
    public static int PRETTY_PRINT_INDENT_FACTOR = 4;
    //public static String TEST_XML_STRING = "<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON</test>";

    public static JSONObject XmlToJson(String xml) {
        JSONObject xmlJSONObj;
        try {
            xmlJSONObj = XML.toJSONObject(xml);
        } catch (JSONException je) {
            System.out.println(je);
            return null;
        }
        return xmlJSONObj;
    }
}
