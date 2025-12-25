package org.example;

public class CaminosMinimos {

  // Método para determinar todos los caminos más cortos (Algoritmo de Floyd)
  public String algoritmoFloyd(long[][] mAdt) {
    int vertices = mAdt.length;
    long[][] matrizAdyacencia = mAdt;
    String[][] caminos = new String[vertices][vertices];
    String[][] caminosAuxiliares = new String[vertices][vertices];
    String caminoRecorrido = "", cadena = "", caminitos = "";
    int i, j, k;
    float temporal1, temporal2, temporal3, temporal4, minimo;

    // Inicializando las matrices caminos y caminosAuxiliares
    for (i = 0; i < vertices; i++) {
      for (j = 0; j < vertices; j++) {
        caminos[i][j] = "";
        caminosAuxiliares[i][j] = "";
      }
    }

    // Lógica del Algoritmo de Floyd (3 ciclos anidados)
    for (k = 0; k < vertices; k++) {
      for (i = 0; i < vertices; i++) {
        for (j = 0; j < vertices; j++) {

          temporal1 = matrizAdyacencia[i][j];
          temporal2 = matrizAdyacencia[i][k];
          temporal3 = matrizAdyacencia[k][j];
          temporal4 = temporal2 + temporal3;

          // Encontrando el mínimo
          minimo = Math.min(temporal1, temporal4);

          if (temporal1 != temporal4) {
            if (minimo == temporal4) {
              caminoRecorrido = "";
              caminosAuxiliares[i][j] = k + "";
              // Llamada al método recursivo para reconstruir el camino
              caminos[i][j] = caminosR(i, k, caminosAuxiliares, caminoRecorrido) + (k + 1);
            }
          }
          matrizAdyacencia[i][j] = (long) minimo;
        }
      }
    }

    // Agregando la matriz de pesos mínimos a la cadena de resultado
    for (i = 0; i < vertices; i++) {
      for (j = 0; j < vertices; j++) {
        cadena += "[" + matrizAdyacencia[i][j] + "]";
      }
      cadena += "\n";
    }

    // Buscando y formateando los caminos encontrados
    for (i = 0; i < vertices; i++) {
      for (j = 0; j < vertices; j++) {
        // Verificamos que no sea infinito (9999999999L es el valor usado como infinito)
        if (matrizAdyacencia[i][j] != 9999999999L) {
          if (i != j) {
            if (caminos[i][j].equals("")) {
              caminitos +=
                  "De ("
                      + (i + 1)
                      + "--->"
                      + (j + 1)
                      + ") Irse por...("
                      + (i + 1)
                      + ", "
                      + (j + 1)
                      + ")\n";
            } else {
              caminitos +=
                  "De ("
                      + (i + 1)
                      + "--->"
                      + (j + 1)
                      + ") Irse por...("
                      + (i + 1)
                      + ", "
                      + caminos[i][j]
                      + ", "
                      + (j + 1)
                      + ")\n";
            }
          }
        }
      }
    }

    return "La matriz de caminos más cortos entre los diferentes vértices es:\n"
        + cadena
        + "\nLos diferentes caminos más cortos entre vértices son:\n"
        + caminitos;
  }

  // Método recursivo para recuperar el camino recorrido
  public String caminosR(int i, int k, String[][] caminosAuxiliares, String caminoRecorrido) {
    if (caminosAuxiliares[i][k].equals("")) {
      return "";
    } else {
      // Recursividad para ir concatenando los nodos intermedios
      caminoRecorrido +=
          caminosR(i, Integer.parseInt(caminosAuxiliares[i][k]), caminosAuxiliares, caminoRecorrido)
              + (Integer.parseInt(caminosAuxiliares[i][k]) + 1)
              + ", ";
      return caminoRecorrido;
    }
  }
}
