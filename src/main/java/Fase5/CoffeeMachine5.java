package Fase5;

import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeMachine5 {

    static final int AGUA = 0;
    static final int LECHE = 1;
    static final int CAFE = 2;
    static final int VASOS = 3;
    static final int EFECTIVO = 4;
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {


        ArrayList<Integer> estado = new ArrayList<>();
        estado.add(400); //AGUA
        estado.add(540); //LECHE
        estado.add(120); //CAFE
        estado.add(9);   //VASOS
        estado.add(550); //EFECTIVO

        menu(estado);

    }

    // menú que contiene un bucle while para utilizar la máquina de café continuamente Y LAS NUEVAS FUNCIONES, (remaining para mostrar el estado de la máquina y exit para finalizar el programa)
    public static void menu(ArrayList<Integer> estado) {

        String accion = "";
        while (!accion.equalsIgnoreCase("exit")) {

            System.out.println("Escribe la acción a realizar (buy, fill, take, remaining, exit)");
            accion = teclado.nextLine();



            if (accion.equalsIgnoreCase("buy")){
                buy(estado);
            } else if (accion.equalsIgnoreCase("fill")) {
                fill(estado);
            } else if (accion.equalsIgnoreCase("take")) {
                take(estado);
            } else if (accion.equalsIgnoreCase("remaining")) {
                remaining(estado);
            }
        }
    }

    // método mostrarEstado, muestra el estado de la máquina (ingredientes y efectivo que contiene):
    public static void remaining(ArrayList<Integer> estado) {
        System.out.println("La máquina de café tiene:\n" + estado.get(AGUA) + " ml de agua\n" + estado.get(LECHE) + " ml de leche\n" + estado.get(CAFE) + " g de café\n" + estado.get(VASOS) + " vasos desechables\n$" + estado.get(EFECTIVO) + " en efectivo" );
    }

    // método buy, compras un café y descuenta los ingredientes utilizados y suma el precio del café al efectivo de la máquina
    public static void buy(ArrayList<Integer> estado) {

        System.out.println("¿Qué quieres comprar? 1 - espresso, 2 - latte, 3 - cappuccino:  (back para volver al menú principal)");
        String opcion = teclado.nextLine();

        if (opcion.equalsIgnoreCase("back")) {
            return;
        }

        switch (opcion) {
            case "1":
                if (estado.get(AGUA) < 250) {
                    System.out.println("¡Lo siento, no tengo suficiente agua!");
                } else if (estado.get(CAFE) < 16) {
                    System.out.println("¡Lo siento, no tengo suficiente café!");
                } else if (estado.get(VASOS) < 1) {
                    System.out.println("¡Lo siento, no tengo suficientes vasos!");
                } else {
                    System.out.println("Tengo suficientes recursos, ¡marchando un café!");
                    estado.set(AGUA, estado.get(AGUA) - 250);
                    estado.set(CAFE, estado.get(CAFE) - 16);
                    estado.set(VASOS, estado.get(VASOS) - 1);
                    estado.set(EFECTIVO, estado.get(EFECTIVO) + 4);
                }
                break;

            case "2":

                if (estado.get(AGUA) < 350) {
                    System.out.println("¡Lo siento, no tengo suficiente agua!");
                } else if (estado.get(LECHE) < 75) {
                    System.out.println("¡Lo siento, no tengo suficiente leche!");
                } else if (estado.get(CAFE) < 20) {
                    System.out.println("¡Lo siento, no tengo suficiente café!");
                } else if (estado.get(VASOS) < 1) {
                    System.out.println("¡Lo siento, no tengo suficientes vasos!");
                } else {
                    System.out.println("Tengo suficientes recursos, ¡marchando un café!");
                    estado.set(AGUA, estado.get(AGUA) - 350);
                    estado.set(LECHE, estado.get(LECHE) - 75);
                    estado.set(CAFE, estado.get(CAFE) - 20);
                    estado.set(VASOS, estado.get(VASOS) - 1);
                    estado.set(EFECTIVO, estado.get(EFECTIVO) + 7);
                }
                break;

            case "3":

                if (estado.get(AGUA) < 200) {
                    System.out.println("¡Lo siento, no tengo suficiente agua!");
                } else if (estado.get(LECHE) < 100) {
                    System.out.println("¡Lo siento, no tengo suficiente leche!");
                } else if (estado.get(CAFE) < 12) {
                    System.out.println("¡Lo siento, no tengo suficiente café!");
                } else if (estado.get(VASOS) < 1) {
                    System.out.println("¡Lo siento, no tengo suficientes vasos!");
                } else {
                    System.out.println("Tengo suficientes recursos, ¡marchando un café!");
                    estado.set(AGUA, estado.get(AGUA) - 200);
                    estado.set(LECHE, estado.get(LECHE) - 100);
                    estado.set(CAFE, estado.get(CAFE) - 12);
                    estado.set(VASOS, estado.get(VASOS) - 1);
                    estado.set(EFECTIVO, estado.get(EFECTIVO) + 6);
                }
                break;

            default:
                System.out.println("Opción incorrecta");

        }
    }

    //método fill, rellena la máquina de café:
    public static void fill(ArrayList<Integer> estado) {

        System.out.println("Escribe cuántos ml de agua quieres añadir:");
        estado.set(AGUA, estado.get(AGUA) + teclado.nextInt());
        teclado.nextLine();

        System.out.println("Escribe cuántos ml de leche quieres añadir:");
        estado.set(LECHE, estado.get(LECHE) + teclado.nextInt());
        teclado.nextLine();

        System.out.println("Escribe cuantos gramos de café quieres añadir:");
        estado.set(CAFE, estado.get(CAFE) + teclado.nextInt());
        teclado.nextLine();

        System.out.println("Escribe cuantos vasos desechables quieres añadir:");
        estado.set(VASOS, estado.get(VASOS) + teclado.nextInt());
        teclado.nextLine();

    }

    //método take (da el efectivo)
    public static void take(ArrayList<Integer> estado) {
        System.out.println("Te acabo de dar $" + estado.get(EFECTIVO));
        estado.set(EFECTIVO, 0);

    }
}

