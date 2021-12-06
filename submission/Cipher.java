package submission;
import java.text.Normalizer;

public class Cipher {
    public static String normalized(String naturalText){
        String normalizado=new String();
        //Remover acentos e cedilhas 
        normalizado=Normalizer.normalize(naturalText,Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]","");
        //Remover pontuação
        normalizado=normalizado.replaceAll("\\p{Punct}", "");
        //Remover espaços
        normalizado=normalizado.replaceAll(" ", "");
        //por letras minusculas
        normalizado=normalizado.toLowerCase();
        return normalizado;
    }
}
