package compi;

import java.util.*;

public class AnalizadorSemantico {
    private TablaSimbolos tabla;
    private List<String> errores;
    private String tipoActual;
    private String metodoActual;
    
    public AnalizadorSemantico(TablaSimbolos tabla) {
        this.tabla = tabla;
        this.errores = new ArrayList<String>();
    }

    public void addError(String errores) {
        this.errores.add(errores);
    }
    // Método principal que recorrerás desde tu parser
    public void analizar() {
        //verificarVariables();
        //verificarTipos();
        //verificarRetornos();
    }
    
    public Simbolo verificarDeclaracion(String nombre){
        return tabla.buscar(nombre);
    }
    
    public boolean sonTiposCompatibles(String tipoVar, String tipoExpr) {
        // Tipos primitivos
        if (tipoVar.equals(tipoExpr)) {
            return true; // Tipos iguales son compatibles
        }

       /* // Reglas de promoción automática
        if (tipoVar.equals("double") && (tipoExpr.equals("float") || tipoExpr.equals("int"))) {
            return true; // float e int pueden ser promovidos a double
        }
        if (tipoVar.equals("float") && tipoExpr.equals("int")) {
            return true; // int puede ser promovido a float
        }

        // Asignaciones de char
        if (tipoVar.equals("int") && tipoExpr.equals("char")) {
            return false; // char puede ser convertido a int
        }*/

        // Comparaciones
        if (tipoVar.equals("boolean") && tipoExpr.equals("boolean")) {
            return true; // boolean es compatible consigo mismo
        }

        // Tipos de referencia (clases)
        // Aquí puedes agregar reglas para tipos de referencia, como clases y objetos
        // Por ejemplo, si tienes una jerarquía de clases:
        // if (tipoVar.equals("ClaseBase") && tipoExpr.equals("ClaseDerivada")) {
        //     return true; // Clase derivada puede ser asignada a clase base
        // }

        // Si no se cumple ninguna regla, los tipos no son compatibles
        return false;
    }

    public List<String> getErrores() {
        return errores;
    }
}
