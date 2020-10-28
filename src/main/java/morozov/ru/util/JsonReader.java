package morozov.ru.util;

import morozov.ru.model.FlightInfo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Исползуется json-simple
 */
public class JsonReader {

    private final JSONParser parser = new JSONParser();
    private static final String NAME_JSON_ARRAY_IN_FILE = "flights";
    private static final String FROM_CITY = "fromCity";
    private static final String TO_CITY = "toCity";
    private static final String PRICE = "price";
    private static final String EXTENSION = ".json";

    /**
     * Если фаил прошёл проверку-
     * Читает из фаила.
     *
     * @param path - абсолютный путь к файлу.
     * @return - список уже распарсенных FlightInfo.
     */
    public List<FlightInfo> getFlightList(String path) throws IOException, ParseException {
        List<FlightInfo> result = new ArrayList<>();
        if (FileValidator.isValid(EXTENSION, path)) {
            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray flights = (JSONArray) jsonObject.get(NAME_JSON_ARRAY_IN_FILE);
            FlightInfo flightInfoBuffer = null;
            for (Object o : flights) {
                JSONObject info = (JSONObject) o;
                flightInfoBuffer = this.createFlightInfo(info);
                result.add(flightInfoBuffer);
            }
        }
        return result;
    }

    /**
     * Перегоняет из JSONObject в FlightInfo.
     *
     * @param jsonObject
     * @return
     */
    private FlightInfo createFlightInfo(JSONObject jsonObject) {
        String from = (String) jsonObject.get(FROM_CITY);
        String to = (String) jsonObject.get(TO_CITY);
        int price = ((Long) jsonObject.get(PRICE)).intValue();
        return new FlightInfo(from, to, price);
    }

}