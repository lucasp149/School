package classes.readFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;


public class ExecuteReadFileToString {
    private static final Logger LOGGER = LogManager.getLogger(ExecuteReadFileToString.class);

    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/toRead.txt");
            String convertedFile = FileUtils.readFileToString(file, (String) null);
            String[] separated = StringUtils.split(convertedFile, " ,.,\n");
            ArrayList<String> strings = new ArrayList<>();


            for(String s: separated){
                if(strings.isEmpty() || !strings.contains(s)) {
                    strings.add(s);
                }
            }

            CharSequence counterChar = ((Integer)strings.size()).toString();

            FileUtils.write(file,counterChar, (Charset) null);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
