package com.automation.api.utils;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class FileUtils {

    public static String getUserDir() {
        return System.getProperty("user.dir");
    }

    public static String getTestResourcesPath() {
        return getUserDir() + "/src/test/resources";
    }

    public static String getRequestJSONsPath() {
        return getUserDir() + "/src/test/resources/RequestJSONs";
    }

    public static byte[] getFileIntoByteArray(String filePath)  {

        File file = new File(filePath);

        try {
            byte[] fileContent = Files.readAllBytes(file.toPath());
            return  fileContent;
        } catch (IOException e) {
            return null;
        }

    }

}
