package Fase6;


import java.util.Scanner;

public class CoffeeMachine6 {

    // DECLARAR CONSTANTES PARA TENER REFERENCIADOS LOS PRECIOS DE LOS CAFÉS A LA HORA DE ACTUALIZAR EL EFECTIVO
private static final int PRECIO_ESPRESSO = 4;
private static final int PRECIO_LATTE = 7;
private static final int PRECIO_CAPPUCCINNO = 6;

    // DECLARACION DE LOS ATRIBUTOS QUE VAMOS A NECESITAR (INGREDIENTES, EFECTIVO, Y EL ESTADO EN QUE SE ENCUENTRA LA MÁQUINA DEPENDIENDO DE LA OPERACIÓN QUE ESTÉ REALIZANDO)
    private int agua;
    private int leche;
    private int cafe;
    private int vasos;
    private int efectivo;
    private String estado;


    // CONSTRUCTOR CON TODOS LOS ATRIBUTOS QUE HEMOS DECLARADO INICIALIZADOS CON LAS CANTIDADES DADAS EN EL EJRCICIO Y EL ESTADO "eligiendo una acción" QUE ES EL PRINCIPAL QUE SE ENCUENTRA EL USUARIO ANTES DE REALIZAR CUALQUIER OPERACIÓN:
    public CoffeeMachine6() {
        this.agua = 400;
        this.leche = 540;
        this.cafe = 120;
        this.vasos = 9;
        this.efectivo = 550;
        this.estado = "Eligiendo una acción";
    }

    // GETTER estado PARA PODER ACCEDER AL ESTADO DE LA MÁQUINA Y ACTUAR DE UNA FORMA U OTRA DENTRO DEL MÉTODO MANEJO:

    public String getEstado() {
        return estado;
    }


    // toString PARA IMPRIMIR EL REMAINING DE LA MÁQUINA

    @Override
    public String toString() {
        return estado + "\nLa máquina de café tiene:\n" + agua + " ml de agua\n" + leche + " ml de leche\n" + cafe + " g de café\n" + vasos + " vasos desechables\n$" + efectivo + " en efectivo";
    }

    // MÉTODO PRINCIPAL CON LA LÓGICA DEL PROGRAMA:

    public void manejo(String seleccion) {

        // DECLARAMOS UN SWITCH PARA ACTUAR DEPENDIENDO DEL ESTADO EN QUE SE ENCUENTRE LA MÁQUINA:

            switch (estado) {

                case "Eligiendo una acción": // INICIO DEL PROGRAMA, DEPENDIENDO DE LA OPCIÓN QUE ELIJA EL USUARIO, DEBEREMOS IR MODIFICANDO EL ESTADO EN QUE SE ENCUENTRE
                    if (seleccion.equalsIgnoreCase("buy")) { // SI DAMOS A COMPRAR, EL ESTADO PASA A "Eligiendo tipo de café" Y MOSTRAMOS LA SELECCIÓN DE CAFÉS QUE DISPONE LA MÁQUINA
                        estado = "Eligiendo tipo de café";
                        System.out.println("¿Qué quieres comprar? 1 - espresso, 2 - latte, 3 - cappuccino:  (back para volver al menú principal)");
                    } else if (seleccion.equalsIgnoreCase("fill")) { // SI ELEGIMOS FILL (RELLENAR LA MÁQUINA), EL ESTADO CAMBIA A "Rellenando agua"
                        estado = "Rellenando agua";
                        System.out.println("Escribe cuántos ml de agua quieres añadir:");

                    } else if (seleccion.equalsIgnoreCase("take")) { // SI ELEGIMOS TAKE, EL ESTADO CAMBIA A "Entrega de efectivo", LLAMA AL MÉTODO take() Y VACÍA LA MÁQUINA PARA POSTERIORMENTE VOLVER AL ESTADO "Eligiendo una acción"
                        estado = "Entrega de efectivo";
                        take();
                        estado = "Eligiendo una acción";
                        System.out.println("Escribe la acción a realizar (buy, fill, take, remaining, exit)");
                    } else if (seleccion.equalsIgnoreCase("remaining")) { // SI ELEGIMOS REMAINING, NOS MOSTRARÁ EL ESTADO DE LA MÁQUINA CON LA CANTIDAD DE INGREDIENTES LLAMANDO AL MÉTODO remaining() QUE A SU VEZ LLAMA AL MÉTODO toString QUE DECLARAMOS ANTERIORMENTE. TRAS REALIZAR SU TRABAJO, VOLVEMOS AL ESTADO "Eligiendo una acción"
                        estado = "Mostrando estado";
                        remaining();
                        estado = "Eligiendo una acción";
                        System.out.println("Escribe la acción a realizar (buy, fill, take, remaining, exit)");
                    } else if (seleccion.equalsIgnoreCase("exit")) { // SI ELEGIMOS EXIT, FINALIZA EL BUCLE CON UN MENSAJE DE DESPEDIDA "Hasta pronto" Y EL ESTADO CAMBIA A SALIENDO (CREO QUE UN POCO CHORRA ESTE ESTADO)
                        System.out.println("Hasta pronto");
                        estado = "Saliendo";
                    }
                    break;

                case "Eligiendo tipo de café": { // EN CASO DE QUE EL ESTADO SEA "Eligiendo tipo de café", SE LLAMA AL MÉTODO buy(seleccion) QUE SE ENCARGA DE DESCONTAR LOS INGREDIENTES Y AUMENTAR EL EFECTIVO DEPENDIENDO DE LA SELECCIÓN QUE HAGAMOS DE CAFÉ (ESPRESO, LATTE, CAPPUCCINO). FINALMENTE, VOLVEMOS DE NUEVO AL ESTADO "Eligiendo una acción"
                    buy(seleccion);
                        estado = "Eligiendo una acción";
                    System.out.println("Escribe la acción a realizar (buy, fill, take, remaining, exit)");
                    break;

                } case "Rellenando agua": // SI HEMOS SELECCIONADO FILL, AUTOMATICAMENTE EL ESTADO CAMBIA A "Rellenando agua" Y VA INCREMENTANDO LA CANTIDAD A DEMANDA DE AGUA, LECHE, CAFE Y VASOS. AL NO PODER UTILIZAR EL SCANNER EN ESTA CLASE Y TENER QUE USAR OBLIGATORIAMENTE UN String, UTILIZAMOS Integer.parseInt PARA CAMBIAR EL TIPO DE DATO DE String A int Y PODER AUMENTAR LAS CANTIDADES QUE SON ATRIBUTOS DE TIPO int (AGUA, LECHE, CAFE, VASOS, EFECTIVO) HACEMOS LO MISMO CON TODOS LOS INGREDIENTES SIGUIENTES:
                    this.agua += Integer.parseInt(seleccion);
                    estado = "Rellenando leche";
                    System.out.println("Escribe cuántos ml de leche quieres añadir:");
                    break;

                case "Rellenando leche":
                    this.leche += Integer.parseInt(seleccion);
                    estado = "Rellenando café";
                    System.out.println("Escribe cuantos gramos de café quieres añadir:");
                    break;

                case "Rellenando café":
                    this.cafe += Integer.parseInt(seleccion);
                    estado = "Rellenando vasos";
                    System.out.println("Escribe cuantos vasos desechables quieres añadir:");
                    break;

                case "Rellenando vasos":
                    this.vasos += Integer.parseInt(seleccion);
                    estado = "Eligiendo una acción";
                    System.out.println("Escribe la acción a realizar (buy, fill, take, remaining, exit)");
                    break;

                default:
                    System.out.println("Ha habido un error");
            }
        }

        public void buy(String seleccion) { // MÉTODO PARA COMPRAR, COMPROBAR SI TENEMOS INGREDIENTES SUFICIENTES Y EN CASO CONTRARIO LANZAR UN MENSAJE DE FALTA DE INGREDIENTES EN LA MÁQUINA Y EN CASO DE ÉXITO APLICAR LA LÓGICA PARA DESCONTAR LOS INGREDIENTES QUE HEMOS GASTADO REALIZANDO EL CAFÉ
        if (seleccion.equalsIgnoreCase("back")) {
            estado = "Eligiendo una acción";
            return;
        }

        switch (seleccion) {
            case "1":
                if (agua < 250) {
                    System.out.println("¡Lo siento, no tengo suficiente agua!");
                } else if (cafe < 16) {
                    System.out.println("¡Lo siento, no tengo suficiente café!");
                } else if (vasos < 1) {
                    System.out.println("¡Lo siento, no tengo suficientes vasos!");

                } else {
                    System.out.println("Tengo suficientes recursos, ¡marchando un café!");
                    this.agua -= 250;
                    this.cafe -= 16;
                    this.vasos -= 1;
                    this.efectivo += PRECIO_ESPRESSO;
                }
                break;

            case "2":
                if (agua < 350) {
                    System.out.println("¡Lo siento, no tengo suficiente agua!");
                } else if (leche < 75) {
                    System.out.println("¡Lo siento, no tengo suficiente leche!");
                } else if (cafe < 20) {
                    System.out.println("¡Lo siento, no tengo suficiente café!");
                } else if (vasos < 1) {
                    System.out.println("¡Lo siento, no tengo suficientes vasos!");


                } else {
                    System.out.println("Tengo suficientes recursos, ¡marchando un café!");
                    this.agua -= 350;
                    this.leche -= 75;
                    this.cafe -= 20;
                    this.vasos -= 1;
                    this.efectivo += PRECIO_LATTE;
                }
                break;

            case "3":
                if (agua < 200) {
                    System.out.println("¡Lo siento, no tengo suficiente agua!");
                } else if (leche < 100) {
                    System.out.println("¡Lo siento, no tengo suficiente leche!");
                } else if (cafe < 12) {
                    System.out.println("¡Lo siento, no tengo suficiente café!");
                } else if (vasos < 1) {
                    System.out.println("¡Lo siento, no tengo suficientes vasos!");


                } else {
                    System.out.println("Tengo suficientes recursos, ¡marchando un café!");
                    this.agua -= 200;
                    this.leche -= 100;
                    this.cafe -= 12;
                    this.vasos -= 1;
                    this.efectivo += PRECIO_CAPPUCCINNO;

                }
                break;
            default:
                System.out.println("Ha habido un error");
            }

        }
        public void take() { // MÉTODO QUE IMPRIME EL EFECTIVO DE LA MÁQUINA Y LA VACÍA DE DINERO
            System.out.println("Te acabo de dar $" + efectivo);
            this.efectivo = 0;
        }
        public void remaining() { // MÉTODO PARA IMPRIMIR EL ESTADO DE LA MÁQUINA (STOCK DE INGREDIENTES Y EFECTIVO QUE CONTIENE)
            System.out.println(this.toString());
        }
}
