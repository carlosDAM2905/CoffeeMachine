package Fase4;

import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeMachine4 {
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {

        int agua = 400;
        int leche = 540;
        int cafe = 120;
        int vasos = 9;
        int efectivo = 550;

        ArrayList<Integer> estado = new ArrayList<>();
        estado.add(agua);
        estado.add(leche);
        estado.add(cafe);
        estado.add(vasos);
        estado.add(efectivo);

        menu(estado);

    }

    // menú que contiene un bucle while para utilizar la máquina de café continuamente
    public static void menu(ArrayList<Integer> estado) {

        mostrarEstado(estado);

        //int exit = 0;
        String accion = "";
        while (!accion.equalsIgnoreCase("exit")) {

            System.out.println("Escribe la acción a realizar (buy, fill, take)");
            accion = teclado.nextLine();


            if (accion.equalsIgnoreCase("buy")){
                buy(estado);
            } else if (accion.equalsIgnoreCase("fill")) {
                fill(estado);
            } else if (accion.equalsIgnoreCase("take")) {
                take(estado);
            }

        }

    }

    // método mostrarEstado, muestra el estado de la máquina (ingredientes y efectivo que contiene):
    public static void mostrarEstado(ArrayList<Integer> estado) {
        System.out.println("La máquina de café tiene:\n" + estado.get(0) + " ml de agua\n" + estado.get(1) + " ml de leche\n" + estado.get(2) + " g de café\n" + estado.get(3) + " vasos desechables\n$" + estado.get(4) + " en efectivo" );

    }


    // método buy, compras un café y descuenta los ingredientes utilizados y suma el precio del café al efectivo de la máquina
    public static void buy(ArrayList<Integer> estado) {

        System.out.println("¿Qué quieres comprar? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int opcion = teclado.nextInt();
        teclado.nextLine();

        int agua;
        int cafe;
        int leche;
        int vasos;
        int efectivo;

        switch (opcion) {
            case 1:
                agua = estado.get(0) - 250;
                cafe = estado.get(2) - 16;
                vasos = estado.get(3) - 1;
                efectivo = estado.get(4) + 4;

                estado.set(0, agua);
                estado.set(2, cafe);
                estado.set(3, vasos);
                estado.set(4, efectivo);
                break;

            case 2:
                agua = estado.get(0) - 350;
                cafe = estado.get(2) - 20;
                leche = estado.get(1) - 75;
                vasos = estado.get(3) - 1;
                efectivo = estado.get(4) + 7;

                estado.set(0, agua);
                estado.set(2, cafe);
                estado.set(1, leche);
                estado.set(3, vasos);
                estado.set(4, efectivo);
                break;

            case 3:
                agua = estado.get(0) - 200;
                leche = estado.get(1) - 100;
                cafe = estado.get(2) - 12;
                vasos = estado.get(3) - 1;
                efectivo = estado.get(4) + 6;

                estado.set(0, agua);
                estado.set(1, leche);
                estado.set(2, cafe);
                estado.set(3, vasos);
                estado.set(4, efectivo);

                break;

            default:
                System.out.println("Opción incorrecta");

        }

        mostrarEstado(estado);



    }


    //método fill, rellena la máquina de café:
    public static void fill(ArrayList<Integer> estado) {




        System.out.println("Escribe cuántos ml de agua quieres añadir:");
        int agua = teclado.nextInt();
        agua = estado.get(0) + agua;
        estado.set(0, agua);

        System.out.println("Escribe cuántos ml de leche quieres añadir:");
        int leche = teclado.nextInt();
        leche = estado.get(1) + leche;
        estado.set(1, leche);

        System.out.println("Escribe cuantos gramos de café quieres añadir:");
        int cafe = teclado.nextInt();
        cafe = estado.get(2) + cafe;
        estado.set(2, cafe);


        System.out.println("Escribe cuantos vasos desechables quieres añadir:");
        int vasos = teclado.nextInt();
        teclado.nextLine();
        vasos = estado.get(3) + vasos;
        estado.set(3, vasos);

        mostrarEstado(estado);



    }

    //método take (da el efectivo)
    public static void take(ArrayList<Integer> estado) {
        int efectivo = estado.get(4);
        System.out.println("Te acabo de dar $" + efectivo);
        estado.set(4, 0);

        mostrarEstado(estado);
    }

}
