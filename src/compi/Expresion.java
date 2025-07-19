/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compi;

/**
 *
 * @author joset
 */
public class Expresion {
    private String tipo; // Tipo de dato de la expresión
    private String valor; // Valor de la expresión (opcional)

    public Expresion(String tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }


    public String getTipo() {
        return tipo; // Devuelve el tipo de dato
    }

    public String getValor() {
        return valor; // Devuelve el valor de la expresión
    }
}
