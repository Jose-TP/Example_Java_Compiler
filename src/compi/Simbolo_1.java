/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compi;

public class Simbolo_1 {
    public int id;
    public String nombre;
    public String tipo;        // "variable", "metodo", "clase", "atributo", "parametro"
    public String tipoDato;    // "int", "String", "float", "void", etc.
    public String ambito;
    public int linea;
    public String tipoGenerico; // Para tipos internos en colecciones ("String" para List<String>)

    
    public Simbolo_1(int id, String nombre, String tipo, String tipoDato, String ambito, int linea) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.tipoDato = tipoDato;
        this.ambito = ambito;
        this.linea = linea;
        if (tipoDato != null && tipoDato.contains("<")) {
            this.tipoGenerico = tipoDato.substring(tipoDato.indexOf("<") + 1, tipoDato.indexOf(">"));
        }
    }
}
