/**
 * Esta clase de aqui, es mi base del proyecto(De ahi el nombre de base central), aqui se encuentran todos los metodos que mi
 * programa utiliza para realizar todas las acciones del programa.
 * 
 * VARIABLES
 * static ArrayList<datosUsuario> lista; - Esta variable es el arraylist donde almacenos los registros de mis usuarios, en la clase datos Usuario se encuentra todos los atributos que poseen los registros que son almacenados aqui.
 * datosUsuario registro; - Esta es una variable auxiliar que me sirve para registrar a mis usuario, cada vez que quiero crear un objeto la inicializo como new datosUsuario (atributo1,atributo2), para poder registrar a mi usuario, esta se usa en el metodo public void Registrar();
 * String nombre and String contraseña - Bueno estas dos variables son del constructor por el cual accede mi usuario a la hora de registrarse, por que manda el nombre que quiere tener de registro y su contraseña, este constructor las almacena  y con ayudade public void Registrar(); - se registra en el ArrayList
 * int sesionIniciada; - Esta variable se encarga de mandarse a MenuInicioSesion y con ese atributo se crea el MenuSesionIniciada que como su nombre indica es la encargada de saber quien es el usuario que accedio, para poder acceder a su pila correspondiente.
 * 
 * VARIABLES EN PASO DE PARAMETROS
 * int idEnviar,int idPropia - Estas variables se encuentran como parametro en los metodos EnviarMensaje y LeerBandeja, si en usuario quiere enviar un mensaje, necesita la idEnviar, que es la persona a la que se le va a enviar el mensaje, y la idPropia se pida para poder obtener su nombre y que aparezca cuando se manda un mensaje
 * String Mensaje - Esta variable se usa en EnviarMensaje, que concatena el mensaje que nosotros queremos enviar, este dato es guardado en la pila del usuario que queremos que reciba este mensaje.
 */
package meetme;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BaseCentral {
static ArrayList<datosUsuario> lista = new ArrayList<>();
datosUsuario registro;
String nombre;
String contraseña;
int sesionIniciada;

    public BaseCentral() { //En este constructor accede el inicio de sesion, por que en inicio de sesion viene vacio
    }
    
    public BaseCentral(String nombre, String contraseña) { //En este constructor accede el registro por que manda dos atributos
        this.nombre = nombre;
        this.contraseña = contraseña;
    }


public void Registrar(){
          registro = new datosUsuario(nombre, contraseña); //Se guardan los datos en la variable registro(que almacena datos tipo datosUsuario) y crea el objeto con ayuda del contructor
          lista.add(registro); //Se agrega a mi Arraylist
}

public boolean IniciarSesion(String _nombre,String _contraseña){ //Recibe el nombre y contraseña  ingresados por el usuario
    for (int i=0; i< lista.size();i++){ //Y se crea un ciclo for, encargado de recorrer toda nuestra lista obteniendo el nombre y contraseña, para comprobar si son iguales
            
            String auxNombre = lista.get(i).getNombre(); //Hice este paso de la variable auxiliar para en un futuro no perderme de lo que hice, pero siento es innecesario 
            String auxContraseña = lista.get(i).getContraseña();//Hice este paso de la variable auxiliar para en un futuro no perderme de lo que hice, pero siento es innecesario 

            if (_nombre.equals(auxNombre) && _contraseña.equals(auxContraseña)) //Comparo las variables auxiliares para verificar si son iguales con las que coloco el usuario
            {
                sesionIniciada=i; //Si las credenciales son validas, sesionIniciada se transforma en la sesion que se inicio
                nombre = lista.get(i).getNombre(); //Y se obtiene el nombre (Siento que este proceso se puede mejorar)
                return true; //Retorna verdadero si las credenciales son validas
            }
        }
    return false; // Retorna Falso si no son validas
}

public void enviarMensaje(int idEnviar,String nombreUsuario){
    if(idEnviar<lista.size()){ //Comprueba si el usuario al que se le va a enviar mensaje existe
        String Mensaje = "Mensaje de "+nombreUsuario+": "+JOptionPane.showInputDialog("Ingrese su mensaje:")+"\n"; //Aqui concatena el mensaje del usuario, incluyendo el nombre de quien lo manda, y un pequeño formato que cree.
        lista.get(idEnviar).PilaUsuario.push(Mensaje); //Se envia el mensaje a la pila del usuario que se desea que llegue
    }else{ //Si el usuario no existe le aparece una alerta al usuario como numero invalido
        JOptionPane.showMessageDialog(null,"Numero de ID invalido!");
    }
}

public String LeerBandeja(int idPropia){
    return  lista.get(idPropia).PilaUsuario.pop(); //Aqui se recibe la id propia y saca el ultimo dato de la pila (que es la variable Mensaje)
}


public void CambiarContraseña(String _nombre,String _contraseña){ //Cambiar contraseña, este codigo es reutilizado de iniciarSesion, primero inicia sesion y despues si el inicio de sesion es valido deja cambiar la contraseña.
    boolean credencialesCorrectas = false;
    for (int i=0; i< lista.size();i++){
            String auxNombre = lista.get(i).getNombre();
            String auxContraseña = lista.get(i).getContraseña();

            if (_nombre.equals(auxNombre) && _contraseña.equals(auxContraseña))
            {
                lista.get(i).setContraseña(JOptionPane.showInputDialog("Ingrese nueva contraseña: ")); //Si la credencial es valida le pregunta cual quiere que sea su nueva contraseña y  setea esta contraseña nueva,  en el objeto que es la variable (i).
                credencialesCorrectas=true;
                break; //Detener el ciclo for
            }  
    }
    if (!credencialesCorrectas)
   JOptionPane.showMessageDialog(null,"Credenciales Incorrectas!");//Si la credencial es invalida se le manda este mensaje.
}

public void BuscarUsuario(String BusquedaUsuario){
    //Creo metodo BuscarUsuario, recibe BusquedaUsuario y comprueba si esta en el ArrayList, si es verdadero imprime los datos del usuario
    boolean credencialesCorrectas = false;
    for (int i=0; i< lista.size();i++){ 
    
            String auxNombre = lista.get(i).getNombre(); //Creo auxNombre, para almacenar el nombre que va cambiando segun la iteracion del ciclo for y compararlos
            if (BusquedaUsuario.equals(auxNombre)) {
                credencialesCorrectas = true;
                JOptionPane.showMessageDialog(null,lista.get(i).imprimirUsuario(i));
                break;
            }
    }
    if(!credencialesCorrectas){
         JOptionPane.showMessageDialog(null,"No se encontro ese Usuario!");
    }
}

public boolean ComprobarRegistro(String usuario){
    //Este metodo sirve para comprobrar a la hora del registro, si el nombre ingresado ya esta registrado y poder tirar un error, es mandando a llamar desde MenuRegistro y recibe el nombre del usuario para compararlo.
    for (int i=0; i< lista.size();i++){ 
    
            String auxNombre = lista.get(i).getNombre(); //Creo auxNombre, para almacenar el nombre que va cambiando segun la iteracion del ciclo for y compararlos
            if (usuario.equals(auxNombre)) {
                return false; //retorna falso si el nombre ya esta registrado
            }
    }
    return true; //retorna verdadero si todo esta bien y se puede continuar con el registro
}








//Getters
public int getSesionIniciada(){
        return sesionIniciada;
}

    public String getNombre() {
        return nombre;
    }


}
