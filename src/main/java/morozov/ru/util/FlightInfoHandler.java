package morozov.ru.util;

import morozov.ru.model.FlightInfo;

import java.util.*;

/**
 * Для просмотра листа FlightInfo и извлечения нужной информации.
 */
public class FlightInfoHandler {

    private static final Comparator<FlightInfo> comparator = new FlightInfoComparator();

    /**
     * @param infos - исходный лист
     * @param from
     * @param to
     * @return - отсортированный лист, содержащий нужные FlightInfo
     */
    public static List<FlightInfo> getReadyData(List<FlightInfo> infos, String from, String to) {
        List<FlightInfo> result = new ArrayList<>();
        for (FlightInfo fi : infos) {
            if (fi.getFromCity().equals(from) && fi.getToCity().equals(to)) {
                result.add(fi);
            }
        }
        result.sort(comparator);
        return result;
    }

    /**
     * Если не указано- откуда и куда.
     *
     * @param infos
     */
    public static void getReadyData(List<FlightInfo> infos) {
        infos.sort(comparator);
    }

    /**
     * Если указано только откуда.
     *
     * @param infos
     * @param from
     * @return
     */
    public static List<FlightInfo> getReadyDataFrom(List<FlightInfo> infos, String from) {
        List<FlightInfo> result = new ArrayList<>();
        for (FlightInfo fi : infos) {
            if (fi.getFromCity().equals(from)) {
                result.add(fi);
            }
        }
        result.sort(comparator);
        return result;
    }

    /**
     * Если указано только куда.
     *
     * @param infos
     * @param to
     * @return
     */
    public static List<FlightInfo> getReadyDataTo(List<FlightInfo> infos, String to) {
        List<FlightInfo> result = new ArrayList<>();
        for (FlightInfo fi : infos) {
            if (fi.getToCity().equals(to)) {
                result.add(fi);
            }
        }
        result.sort(comparator);
        return result;
    }
}

/**
 * Для сортировки, что бы вручную не выискивать max\min во время обхода листа.
 */
class FlightInfoComparator implements Comparator<FlightInfo> {
    @Override
    public int compare(FlightInfo fi1, FlightInfo fi2) {
        return Integer.compare(fi1.getPrice(), fi2.getPrice());
    }
}