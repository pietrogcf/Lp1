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
public class Saida {
    public void imprimirNumeroEspacos(String msg, int s) {
        System.out.println(msg + ": " + s);
    }
    public void imprimirNumeroVogais(String msg, String s) {
        System.out.println(msg + ": " + s);
    }
    public void imprimirNumeroPalavras(String msg, int s) {
        System.out.println(msg + ": " + s);
    }
    public void imprimirFraseSubstituida(String msg,String a, String msg02, char s) {
        System.out.println(msg + ": " + a + msg02 + ": " + s);
    }
}
