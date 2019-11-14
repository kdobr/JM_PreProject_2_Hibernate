package app.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Stream;

public class PropertyReader {
    public  static String getProperty (String propertyName) {

//        String value = null;
//        Properties properties = new Properties();
//        try(InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream("application.properties")){
//            properties.load(input);
//            value = properties.getProperty(propertyName);
//        } catch (IOException e) {
//            System.out.println("Can`t read properties file");
//        }
//        return value;

        Map<String, String> propMap = new HashMap<>();

       try (Stream<String> lines = Files.lines(Paths.get("C:\\IntellijIDEAnewWork\\JM_PreProject_1\\src\\main\\webapp\\WEB-INF\\application.properties")))

        {
            System.out.println();

            lines.forEach(l->{
                    String[]arr = l.split("=");
                    propMap.put(arr[0], arr[1]);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return propMap.get(propertyName);
    }
}
