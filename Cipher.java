//package Trabalho;
import java.util.ArrayList;
import java.util.List;
//import java.lang.Character;
import  java.util.Random;
import java.text.Normalizer;
import java.lang.String;
import java.lang.StringBuilder;

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

    public static String encode(String plaintText,int cols){
        plaintText=normalized(plaintText);
    //calcular o tamanho necessario para a cifra
    int cipherLength=0;
    int linhas=0;
    String result=plaintText;
    StringBuilder cipher=new StringBuilder();
    for(int i=1;cipherLength<plaintText.length();i++){
        cipherLength=i*cols;
        linhas=i;
    }
    //verificamos se é necessario acrescentar letras
    if(cipherLength==plaintText.length()){
       

       for (int i=0;i<linhas;i++){
            int pos=i;
           for(int j=0;j<cols;j++){
               cipher.append(result.charAt(pos));
                pos=pos+linhas;
           }

       }
       //System.out.println(cipher);
       return cipher.toString();
        
    }else{//acrescenta letras
        Random r=new Random();
        while(result.length()!=cipherLength){
            result=result+plaintText.charAt(r.nextInt(plaintText.length()));
        }
        for (int i=0;i<linhas;i++){
            int pos=i;
           for(int j=0;j<cols;j++){
               cipher.append(result.charAt(pos));
                pos=pos+linhas;
           }
       }
       //System.out.println(cipher);
       return cipher.toString();
    }      

    }
    public static List<Integer> findDividers(int x){
        List<Integer> divisor=new ArrayList<Integer>();
        divisor.add(1);
        for(int i=2;i<x;i++){
            if(x%i==0){
                divisor.add(i);
            }
        }
        divisor.add(x); 
        return divisor;
    }

    
    
    
}
 
