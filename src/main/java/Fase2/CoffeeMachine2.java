package Fase2;

import java.util.Scanner;

public class CoffeeMachine2 {
    public static void main(String[] args) {

        //variables de ingredientes y tazas:

        int tazas = numeroDeTazas();
        int agua = cantidadDeAgua(tazas);
        int leche = cantidadDeLeche(tazas);
        int cafe = cantidadDeCafe(tazas);

        resultado(tazas, agua, leche, cafe);
    }


        //preguntar y obtener el número de tazas de café que se quieren hacer:


    public static int numeroDeTazas() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe cuántas tazas de café vas a necesitar:");
        return teclado.nextInt();
    }

        //calcular la cantidad de agua que se necesita para ese número de tazas de café:

    public static int cantidadDeAgua(int tazas) {
        return tazas * 200;
    }

        //calcular la cantidad de leche que se necesita para ese número de tazas de café:

    public static int cantidadDeLeche(int tazas) {
        return tazas * 50;
    }


        //calcular la cantidad de café que se necesita para ese número de tazas de café:

    public static int cantidadDeCafe(int tazas) {
        return tazas * 15;
    }

        //mostrar el resultado con las cantidades que se necesitan de cada ingrediente:

    public static void resultado(int tazas, int agua, int leche, int cafe) {
        System.out.println("Para " + tazas + " tazas de café necesitas: " + "\n" + agua + " ml de agua \n" + leche + " ml de leche \n" + cafe + " g de café");

    }


}
