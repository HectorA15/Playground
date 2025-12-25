package listacircula;



public class ListaCircula {

    public static void main(String[] args) {
        
   lista.insertarAlFrente(new Cancion("One more hour", "Tame Impala", 160));
        lista.insertarAlFrente(new Cancion("A", "A,A,A", 130));
        lista.insertarAlFrente(new Cancion("B ", "B,B,B", 180));
        lista.insertarAlFrente(new Cancion("C", "C,C,C", 210));
             lista.insertarAlFrente(new Cancion("D", "D,D,D", 210));
        System.out.println("Tamano inicial " + lista.tamanio());
        System.out.println();
        

        System.out.println("Lista de Canciones");
        for (Cancion c : lista.toList()) {
           System.out.println(c);
        }
        System.out.println();

        System.out.println("la navegacion del papu");
          System.out.println();
        System.out.println("Cancion actual: " + lista.getActual());
        lista.next();
        System.out.println("Despues de next(): " + lista.getActual());
        lista.previous();
        System.out.println("Despues de previous(): " + lista.getActual());

   System.out.println();
   
        System.out.println("la eliminacion");
        System.out.println("Eliminado de la cancion actual: " + lista.getActual());
        lista.eliminarActual();

        System.out.println("despues de eliminar:");
        for (Cancion cancion : lista.toList()) {
            System.out.println(cancion);
        }
          System.out.println();
        System.out.println("tamano Final: " + lista.tamanio());
    }

}
