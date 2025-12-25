package nodosdobles;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        ListaCircular lista = new ListaCircular();

        boolean exit = false;
        int opcion;
        String titulo;
        String artista;
        int duracion;
        int indice;

        Cancion cancion;

        Scanner sc = new Scanner(System.in);

        while (exit == false) {

            System.out.println("Selecciona una opcion:");
            System.out.println("1. INSERTAR FRENTE \t 2. Insertar ULTIMO \t 3. Insertar INDICE");
            System.out.println("4. ELIMINAR FRENTE \t 5. Eliminar ULTIMO \t 6. Eliminar INDICE \t 7. Vaciar LISTA");
            System.out.println("8. IMPRIMIR LISTA \t 9. Mostrar FRENTE \t 10. Mostrar ULTIMO \t 11.  TAMANIO de la lista");
            System.out.println("12. Salir");

            System.out.print("Entrada: ");
            if (!sc.hasNextInt()) {
                System.out.println("Opcion invalida, ingrese un numero entero");
                sc.next();
                System.out.print("Entrada: ");
                continue;
            }

            opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();
            switch (opcion) {

                case 1 -> {
                    System.out.print("Titulo: ");
                    titulo = sc.next();
                    System.out.print("Artista: ");
                    artista = sc.next();
                    System.out.print("Duracion: ");
                    duracion = sc.nextInt();

                    System.out.println();
                    cancion = new Cancion(titulo, artista, duracion);

                    lista.insertarAlFrente(cancion);
                    System.out.println();
                }
                case 2 -> {
                    System.out.print("Titulo: ");
                    titulo = sc.next();
                    System.out.print("Artista: ");
                    artista = sc.next();
                    System.out.print("Duracion: ");
                    duracion = sc.nextInt();

                    System.out.println();
                    cancion = new Cancion(titulo, artista, duracion);

                    lista.insertarAlFinal(cancion);
                    System.out.println();
                    System.out.println();
                }

                case 3 -> {
                    System.out.print("Indice: ");
                    indice = sc.nextInt();
                    System.out.print("Titulo: ");
                    titulo = sc.next();
                    System.out.print("Artista: ");
                    artista = sc.next();
                    System.out.print("Duracion: ");
                    duracion = sc.nextInt();

                    System.out.println();
                    cancion = new Cancion(titulo, artista, duracion);

                    lista.insertarIndice(indice, cancion);
                }
                case 4 ->
                    lista.eliminarFrente();
                case 5 ->
                    lista.eliminarUltimo();
                case 6 -> {
                    System.out.print("Indice: ");
                    indice = sc.nextInt();
                    lista.eliminarIndice(indice);
                    //lista.eliminarIndice();
                }

                case 7 ->
                    lista.vaciarLista();

                case 8 ->
                    lista.imprimirLista();
                case 9 ->
                    System.out.println(lista.getFrente());
                case 10 ->
                    System.out.println(lista.getUltimo());
                case 11 ->
                    System.out.println(lista.cuentaNodos());
                case 12 ->
                    exit = true;
                default -> {
                    System.out.println("Opcion invalida");
                    System.out.println();
                }
            }
        }

    }

}
