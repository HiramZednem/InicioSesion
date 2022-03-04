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
 
    public String imprimirUsuario(int i){ //Es un metodo que se usa para ver los datos de los usuario mediante el arraylist.
        String impresion = "El nombre del Usuario es: "+Nombre+"\nSu ID es: "+i;
                return impresion;
    }
    
    public String imprimirAdmin(int i){ //Este metodo es para imprimir Nombre, contraseña e id de todos los usuarios
        
        String impresion = "El nombre del Usuario es: "+Nombre+"\nSu contraseña es:  "+Contraseña+"\nSu ID es: "+i+"\n";
                return impresion;
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
