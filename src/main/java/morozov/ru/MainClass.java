package morozov.ru;

import morozov.ru.model.FlightInfo;
import morozov.ru.util.ArgsWorker;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

/**
 * Запуск программы.
 */
public class MainClass {

    /**
     * Для работы программы обязательно указать путь к файлу .json
     * Опционально: добавить
     * from FROM to To - откуда и куда
     * from FROM - только откуда
     * to To - только куда
     * - что бы выбрать только данные по этим параметрам.
     *
     * @param args
     */
    public static void main(String[] args) {

        ArgsWorker argsWorker = new ArgsWorker();
        List<FlightInfo> flights = null;

        try {
            flights = argsWorker.lookAtCommands(args);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        FlightInfo first = null;
        FlightInfo last = null;

        if (flights != null && flights.size() > 1) {

            first = flights.get(0);
            last = flights.get(flights.size() - 1);

            System.out.println("\nМинимальная стоимость:");
            System.out.println(first.toString());
            System.out.println("\nМаксимальная стоимость:");
            System.out.println(last.toString());
            System.out.println("\nСредняя стоимость:");
            System.out.println(flights.get(flights.size() / 2));

        } else if (flights != null && flights.size() == 1) {
            first = flights.get(0);
            System.out.println(first.toString());
        } else {
            System.out.println("Что-то не так.");
        }
    }
}
