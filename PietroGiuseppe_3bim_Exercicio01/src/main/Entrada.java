/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author Iva
 */
public class Entrada {
    Scanner teclado = new Scanner(System.in);
    public String lerString(String msg) {
        while (true) {
            try {
                System.out.print(msg + ": ");
                String x = teclado.nextLine();
                if (x.trim().isEmpty()) {
                    int k = 3 / 0;
                }
                return x;
            } catch (Exception e) {
                System.out.println("Erro, a string não pode ser vazia");
                teclado = new Scanner(System.in);
            }
        }
    }

}
