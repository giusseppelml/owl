package owl.app.owlser.models;

public class Slider {

    private int id;
    private String titulo;
    private String descripcion;
    private int imagen;
    private int portada;

    public Slider(int id, String titulo, String descripcion, int imagen, int portada){
        setId(id);
        setTitulo(titulo);
        setDescripcion(descripcion);
        setImagen(imagen);
        setPortada(portada);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getPortada() {
        return portada;
    }

    public void setPortada(int portada) {
        this.portada = portada;
    }
}
