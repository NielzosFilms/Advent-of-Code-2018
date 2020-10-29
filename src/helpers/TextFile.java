package helpers;

import java.io.*;
import java.util.ArrayList;

public class TextFile {
    private File text_file;

    public TextFile(String path) {
        this.text_file = new File(path);
    }

    public ArrayList<String> getLines() {
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader(text_file));
            ArrayList<String> lines = new ArrayList<String>();

            String line = bufReader.readLine();
            while (line != null) {
                lines.add(line);
                line = bufReader.readLine();
            }
            bufReader.close();
            return lines;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
