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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Entrada entrada = new Entrada();
        String frase = entrada.lerString("Digite uma frase");
        String e1 = entrada.lerString("Digite um caracter a ser substituido");
        String e2 = entrada.lerString("Digite um caracter para substituir");
        frase = frase.toLowerCase();
        Processamento processamento = new Processamento();
        int nEspaco = processamento.getEspaco(frase);
        String nVogal = processamento.getVogais(frase);
        int nPalavras = processamento.getPalavras(frase);
        char frase02 = processamento.substituiChar(frase,e1,e2);
        
        
        Saida saida = new Saida();
        saida.imprimirNumeroEspacos("Número de espaços", nEspaco);
        saida.imprimirNumeroVogais("Número de cada vogal", nVogal);
        saida.imprimirNumeroPalavras("Número de palavras", nPalavras);
        saida.imprimirFraseSubstituida("Frase original",frase," e frase substituida",frase02);

    }  
}
