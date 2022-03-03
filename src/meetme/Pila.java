package meetme;
import javax.swing.*;

public class Pila {
    private String pila[];
    private int tope;

    public Pila(int capacidad){
        pila = new String[capacidad];
        tope = -1;

    }
    public void push(String dato){
        if (tope+1 < pila.length){
            pila[++tope] = dato;
        }else{
            JOptionPane.showMessageDialog(null,"La bandeja de este usuario esta llena!, intente nuevamente mas tarde!");
        }
    }
    public String pop(){
        if (!isEmpty()) {
            return pila[tope--];
        } else {
            return "No tiene mas mensajes nuevos!\n";
        }
    }
    public boolean isEmpty(){
        return tope == -1;
    }
    public boolean isFull(){
        return tope == tope;
    }
}
