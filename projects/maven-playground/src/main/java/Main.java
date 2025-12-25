package org.example;

public class Main {
  public static void main(String[] args) {
    // Definimos un número muy grande para representar infinito (donde no hay conexión directa)
    long inf = 9999999999L;

    // Matriz de pesos (Adyacencia).
    // 0 en la diagonal principal.
    // 'infinito' donde no hay arista directa.
    // Los otros números son el peso de la arista.
    long matrizA[][] = {
      {0, 10, inf, 30, 100},
      {inf, 0, 50, inf, inf},
      {inf, inf, 0, inf, 10},
      {inf, inf, 20, 0, 60},
      {inf, inf, inf, inf, 0}
    };

    CaminosMinimos ruta = new CaminosMinimos();

    System.out.println(ruta.algoritmoFloyd(matrizA));
  }
}
