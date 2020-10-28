package morozov.ru.util;

import java.io.File;

public class FileValidator {

    /**
     * Для проверки файла.
     *
     * @param targetExtension - Ожидаемое расширение.
     * @param absolutePath    - абсолютный путь к фаилу.
     * @return Если фаил существует и его расширение то, что ожидается, то вернёт true.
     */
    public static boolean isValid(String targetExtension, String absolutePath) {
        boolean result = false;
        File file = new File(absolutePath);
        String currentExtension = getFileExtension(file);
        if (targetExtension.equals(currentExtension) && file.exists()) {
            result = true;
        }
        return result;
    }

    /**
     * Возвращает имя расширения файла в формате ".%расширение%"
     *
     * @param file
     * @return
     */
    private static String getFileExtension(File file) {
        String result = "";
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            result = fileName.substring(fileName.lastIndexOf("."));
        }
        return result;
    }

}
