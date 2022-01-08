//package Trabalho;
import java.util.ArrayList;
import java.util.List;
//import java.lang.Character;
import  java.util.Random;

import javax.swing.text.html.HTMLDocument.RunElement;

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
        normalizado=normalizado.replaceAll("\\W", "");
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
    int aux=cols;
    for(int i=1;cipherLength<plaintText.length();i++){
        cipherLength=i*cols;
        linhas=i;
    }
    //verificamos se é necessario acrescentar letras
        cols=linhas;
        linhas=aux;
    if(cipherLength==plaintText.length()){

       for (int i=0;i<linhas;i++){
            int pos=i;
           for(int j=0;j<cols;j++){
               //System.out.print(result.charAt(pos));
               cipher.append(result.charAt(pos));
                pos=pos+linhas;
           }
           //System.out.println();

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
    public static List<String> explore(String candidate, List<String> words,int size){
        List<String> result =new ArrayList<String>();
        for(String word : words){
            if(candidate.startsWith(word)){
                String suffix=candidate.substring(word.length());
                List<String> children =explore(suffix,words,size);
                for(String c : children){
                    result.add(word +" "+c);
                }
            }
        }
        if(result.isEmpty()){
            result.add(" ");
        }
        return result;
    }
    public static List<String> breakCipher(String cipherText, List<String> words){
        List<String> result = new ArrayList<String>();
        List<String> decodedCipher= new ArrayList<String>();
        List<Integer> divisors=findDividers(cipherText.length());
        for(int divisor: divisors){
            decodedCipher.add(encode(cipherText,divisor));
            //System.out.println(divisor+": "+encode(cipherText,divisor));
        }
        //System.out.println("--"+encode(cipherText,4));
        return explore(encode(cipherText,4),words,11);
    }
    public static void main(String[] Args){
        List<String> ola = new ArrayList<String>();
        ola.add("hoje");
        ola.add("vamos");
        ola.add("ao");
        ola.add("cinema");
        ola.add("ou");
        ola.add("passear");
        ola.add("no");
        ola.add("jardim");
        ola.add("va");
        ola.add("mosao");
        ola.add("he");
        System.out.println(ola);
        String teste="hcsmoieojnaseerevmnoaaoemojoouanspraaadaosia";
        ola=breakCipher("hcsmoieojnaseerevmnoaaoemojoouanspraaadaosia", ola);
        System.out.println(ola);
    }
   
    
    
}
 