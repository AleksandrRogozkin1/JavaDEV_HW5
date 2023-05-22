package org.example.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReaderFileSQL {
        private static StringBuffer stringBuffer = new StringBuffer();
        public static String readSQLFile(String path){
            try(BufferedReader reader = Files.newBufferedReader(Path.of(path));) {
                while (reader.ready()) {
                    stringBuffer.append(reader.readLine());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return stringBuffer.toString();

        }


}


