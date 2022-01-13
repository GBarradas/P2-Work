import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MemoryProvider extends AbstractProvider {
    List<String> words;
    public MemoryProvider(){
        words=new ArrayList<String>();
    }
    public void quickSort(){
        Collections.sort(words);
    }
    public List<String> getWords(){
        quickSort();
        return words;
    }
    public void addWord(String word){
        word=Cipher.normalized(word);
        if(!words.contains(word)&&!word.isEmpty() ){
            words.add(word);
        }
    }
}
;