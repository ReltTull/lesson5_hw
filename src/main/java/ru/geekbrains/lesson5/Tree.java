package ru.geekbrains.lesson5;

import java.io.File;

public class Tree {
    public static void print(File file, String indent, boolean isLast) {
        System.out.print(indent); // рисуем отступ
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

        // подсчитываем общее количество директорий (subDirTotal) и файлов (fileTotal), чтобы на эти переменные
        // опираться при использовании boolean isLast
        int subDirTotal = 0;
        int filesTotal = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory())
                subDirTotal++;
            else if (files[i].isFile()) {
                filesTotal++;
            }
        }


        int subDirCounter = 0;
        int fileCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                print(files[i], indent, subDirCounter == subDirTotal - 1);
                subDirCounter++;
            } else if (files[i].isFile()) {
                print(files[i], indent, fileCounter == filesTotal - 1);
                fileCounter++;
            }
        }
    }
}
