package listacircula;

public class Cancion {

    private String titulo;
    private String artista;
    private int duracionSeg; // duración aproximada en segundos (para simulación)

    public Cancion(String titulo, String artista, int duracionSeg) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracionSeg = duracionSeg;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracionSeg() {
        return duracionSeg;
    }

    @Override
    public String toString() {
        int m = duracionSeg / 60;
        int s = duracionSeg % 60;
        return String.format("%s - %s (%d:%02d)", titulo, artista, m, s);
    }
}
