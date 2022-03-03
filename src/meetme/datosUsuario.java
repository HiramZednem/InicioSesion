package meetme;

public class datosUsuario {
    //Atributos de mi usuario
    private String Nombre;
    private String Contraseña;
    Pila PilaUsuario = new Pila(10);

    public datosUsuario(String Nombre, String Contraseña) {
        this.Nombre = Nombre;
        this.Contraseña = Contraseña;
    }
 
    
    //Getters and Setters

    public String getNombre() {
        return Nombre;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    } 
}
