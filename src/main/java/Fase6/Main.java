package Fase6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        CoffeeMachine6 maquina = new CoffeeMachine6();

        System.out.println("Escribe la acción a realizar (buy, fill, take, remaining, exit)");
        while (!maquina.getEstado().equalsIgnoreCase("Saliendo")) {
            String seleccion = teclado.nextLine();
            maquina.manejo(seleccion);
        }

    }
}
