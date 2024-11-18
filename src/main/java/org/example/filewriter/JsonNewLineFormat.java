package org.example.filewriter;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class JsonNewLineFormat {


    public static void main(String[] args)  {
        List<DataTransferObject> dataTransferObjects = new ArrayList<>();

        for (int i=0; i<1000; i++){
            dataTransferObjects.add(new DataTransferObject("name " + i, "type",
                    new Structure1("name_"+i+"_structure", "type", null)));
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try  (FileOutputStream outputStream = new FileOutputStream("output.txt")){
            for (DataTransferObject dataTransferObject : dataTransferObjects) {
                String data = objectMapper.writeValueAsString(dataTransferObject) + "\n";
                outputStream.write(data.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Zip the file
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("output.zip"))) {
            ZipEntry zipEntry = new ZipEntry("output.txt");
            zos.putNextEntry(zipEntry);
            Files.copy(Paths.get("output.txt"), zos);
            zos.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
