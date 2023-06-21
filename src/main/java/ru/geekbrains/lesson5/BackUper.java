package ru.geekbrains.lesson5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class BackUper {

    private static File sourceDir;

    private static File backupDir;


    public BackUper(String pathToSourceDirectory, String pathToBackupDirectory) {
        sourceDir = new File(pathToSourceDirectory);
        backupDir = new File(pathToBackupDirectory);
    }

    /**
     * Создает новую папку по адресу pathToBackupDirectory и копирует в нее файлы из директории pathToSourceDirectory
     * Вызов в main оборачивать в блоки try-catch
     * @throws IOException
     */
    public static void createBackup() throws IOException {


        // Создаем новую папку для резервной копии
        if (!backupDir.exists()) {
            backupDir.mkdir();
        }

        // Формируем список файлов в исходной директории для работы с файлами
        File[] files = sourceDir.listFiles();

        // Копируем каждый файл в резервную папку
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    File backupFile = new File(backupDir, file.getName());
                    Files.copy(file.toPath(), backupFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
    }
}
