package Fase3;

import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeMachine3 {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Escribe cuántos ml de agua tiene la máquina:");
        int agua = teclado.nextInt();

        System.out.println("Escribe cuántos ml de leche tiene la máquina:");
        int leche = teclado.nextInt();

        System.out.println("Escribe cuántos gramos de café tiene la máquina:");
        int cafe = teclado.nextInt();

        System.out.println("Escribe cuántas tazas de café necesitas hacer:");
        int numeroTazas = teclado.nextInt();



        resultado(agua,leche,cafe,numeroTazas);


    }




    // calcular cuantos cafés pueden prepararse con los ingredientes que disponemos:

    public static int cantidadDeCafes(int agua, int leche, int cafe) {

        int tazasPorAgua = agua / 200;
        int tazasPorLeche = leche / 50;
        int tazasPorCafe = cafe / 15;

        ArrayList<Integer> lista = new ArrayList<>();

        lista.add(tazasPorAgua);
        lista.add(tazasPorLeche);
        lista.add(tazasPorCafe);

        int tazasMáximas = Integer.MAX_VALUE;

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i) < tazasMáximas) {
                tazasMáximas = lista.get(i);
            }

        }
            return tazasMáximas;
    }


    //Resultado:

    public static void resultado(int agua, int leche, int cafe, int numeroTazas) {
        if (cantidadDeCafes(agua, leche,cafe) == numeroTazas) {
            System.out.println("Sí, puedo hacer esa cantidad de café");
        } else if (cantidadDeCafes(agua, leche, cafe) > numeroTazas) {
            System.out.println("Sí, puedo preparar esa cantidad de café (e incluso " + (cantidadDeCafes(agua, leche, cafe) - numeroTazas) + " taza(s) más)");
        } else if (cantidadDeCafes(agua, leche, cafe) < numeroTazas) {
            System.out.println("No, sólo puedo hacer " + cantidadDeCafes(agua, leche, cafe) + " taza(s) de café");

        }
    }
}
