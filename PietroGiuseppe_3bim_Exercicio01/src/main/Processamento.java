/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Iva
 */
public class Processamento {
    //a)
    public int getEspaco(String a){
        char vet[] = new char[a.length()];
        for(int i=0;i<=a.length();i++){
            vet[i]= a.charAt(i);
        }
        int cont = 0;
        for(int i = 0; i <= a.length(); i++){
            if (vet[i] == ' '){
                cont++;  
            }
        }
        return cont;
    }
    //b
    public String getVogais(String a){
        char vet[] = new char[a.length()];
        for(int i=0;i<=a.length();i++){
            vet[i]= a.charAt(i);
        }
        int contA = 0;
        int contE = 0;
        int contI = 0;
        int contO = 0;
        int contU = 0;
        for(int i = 0; i <= a.length(); i++){
            if (vet[i] == 'a'){
                contA++;  
            }
            if (vet[i] == 'e'){
                contE++;  
            }
            if (vet[i] == 'i'){
                contI++;  
            }
            if (vet[i] == 'o'){
                contO++;  
            }
            if (vet[i] == 'u'){
                contU++;  
            }
        }
        String vogais = "A - "+contA+"; E - "+contE+"; I - "+contI+"; O - "+contO+"; U - "+contU;
        return vogais;
    }
    //c
    public int getPalavras(String a){
        a = a.trim();
        char vet[] = new char[a.length()];
        for(int i=0;i<=a.length();i++){
            vet[i]= a.charAt(i);
        }
        int cont = 0;
        for(int i = 0; i <= a.length(); i++){
            if (vet[i] == ' '){
                cont++;  
            }
        }
        return cont + 1;
    }
    //d
    public char substituiChar(String a, String e1, String e2){
        char vet[] = new char[a.length()];
        for(int i=0;i<=a.length();i++){
            vet[i]= a.charAt(i);
        }
        for(int i = 0; i <= a.length(); i++){
            if (vet[i] == e1.charAt(0)){
                char frase2[] = new char[a.length()];
                frase2[i] = frase2[e2.charAt(0)];  
            }
        }
        return frase2[];
    }
}
