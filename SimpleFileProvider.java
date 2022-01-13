import java.io.*;
public class SimpleFileProvider extends MemoryProvider {
    public SimpleFileProvider(String fileName) throws IOException{
        super();
        BufferedReader file= new BufferedReader(new FileReader(fileName));
        String readedLine;
        while((readedLine=file.readLine())!=null){
            addWord(readedLine);
        }
        file.close();
    }

}
