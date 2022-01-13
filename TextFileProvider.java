import java.io.*;
public class TextFileProvider extends MemoryProvider {
    public TextFileProvider(String fileName) throws IOException{
        super();
        BufferedReader fileReader= new BufferedReader(new FileReader(fileName));
        String a;
        while((a=fileReader.readLine())!=null){
            String[] aux= a.split("\\W");
            for(String b : aux){
                addWord(b);
            }
        }
        fileReader.close();
    }
   
}
