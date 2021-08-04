package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    //method
    //getProperty("RedShelsfURL");->return "https:redshelf.com/"

    private static FileInputStream input;
    private static Properties properties;

    static {

        String path = "/Users/cub/IdeaProjects/MindtekTestNGAutomation/src/test/resources/configurations/Config.properties";
        try {

            input = new FileInputStream(path); //txt,propeeties,xls,json
            properties = new Properties();//it is properties type of file
            properties.load(input);
        } catch (FileNotFoundException e) {
            System.out.println("Path for properties is invalid.");
        } catch (IOException e) {
            System.out.println("Could not load propeeties file.");
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                System.out.println("could not close input object.");
            }
        }
    }

    public static String getProperty(String key) {

      return properties.getProperty(key); //RedShelfURL-->https://redshelf.com/
    }
}