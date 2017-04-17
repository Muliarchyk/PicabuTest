package testdata;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Andrei_Muliarchyk on 3/23/2017.
 */
public class CSVReader {
    public List<List<String>> getData (String fileName,String separator){
        List<List<String>> data = new ArrayList<>();

        String s;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((s = reader.readLine())!=null){
                List<String> list = new ArrayList<>();
                String[] line = s.split(separator);
                for (int i =0;i<line.length;i++){
                    list.add(line[i]);
                }
                data.add(list);
            }
            } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
