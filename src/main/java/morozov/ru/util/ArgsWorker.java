package morozov.ru.util;

import morozov.ru.model.FlightInfo;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class ArgsWorker {

    private final JsonReader jsonReader = new JsonReader();
    private static final String FROM_KEY = "from";
    private static final String TO_KEY = "to";

    /**
     * На входе для корректной работы args.length может быть 1, 3 или 5 где
     * file_path
     * или
     * file_path from FROM to TO
     * или
     * file_path from FROM (или to TO)
     * соответственно.
     *
     * @param args
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public List<FlightInfo> lookAtCommands(String[] args) throws IOException, ParseException {
        List<FlightInfo> result = null;
        switch (args.length) {
            case 0:
                break;
            case 1:
                result = jsonReader.getFlightList(args[0]);
                FlightInfoHandler.getReadyData(result);
                break;
            case 3:
                if (args[1].equals(FROM_KEY)) {
                    result = FlightInfoHandler.getReadyDataFrom(jsonReader.getFlightList(args[0]), args[2]);
                } else if (args[1].equals(TO_KEY)) {
                    result = FlightInfoHandler.getReadyDataTo(jsonReader.getFlightList(args[0]), args[2]);
                }
                break;
            case 5:
                if (args[1].equals(FROM_KEY) && args[3].equals(TO_KEY)) {
                    result = FlightInfoHandler.getReadyData(jsonReader.getFlightList(args[0]), args[2], args[4]);
                }
                break;
        }
        return result;
    }
}