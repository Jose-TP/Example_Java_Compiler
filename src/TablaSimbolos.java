/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import compi.*;
import java.util.*;




public class TablaSimbolos {
    private List<Simbolo> simbolos = new ArrayList<>();
    private String ambitoActual = "global";
    private Stack<String> pilaAmbitos = new Stack<>();
    private int contadorID = 0;
    
    public TablaSimbolos() {
        pilaAmbitos.push("global");
    }

    // Método sobrecargado para compatibilidad
    public void agregar(String nombre, String tipo, int linea,Object valor) {
        agregar(nombre, tipo, "-", linea,valor);
    }

    // Método principal con tipo y tipoDato
    public void agregar(String nombre, String tipo, String tipoDato, int linea, Object valor) {
        // Verificar si el símbolo ya existe en el ámbito actual
        if (existeEnAmbitoActual(nombre)) {
            System.out.println("Error: La variable '" + nombre + 
                "' ya ha sido declarada en el ámbito '" + 
                pilaAmbitos.peek() + "' en la línea " + linea);
        }

        contadorID++;
        simbolos.add(new Simbolo(contadorID, nombre, tipo, tipoDato, 
            pilaAmbitos.peek(), linea,valor));
    }

    // Verificar si existe un símbolo en el ámbito actual
    public boolean existeEnAmbitoActual(String nombre) {
        return simbolos.stream()
            .anyMatch(s -> s.nombre.equals(nombre) && s.ambito.equals(pilaAmbitos.peek()));
    }
    
    
    public boolean existeEnAmbitosAccesibles(String nombre) {
    // Recorrer la pila de ámbitos desde el actual hasta el global
    for (int i = pilaAmbitos.size() - 1; i >= 0; i--) {
        String ambito = pilaAmbitos.get(i);
        // Buscar en cada ámbito
        boolean existe = simbolos.stream()
            .anyMatch(s -> s.nombre.equals(nombre) && s.ambito.equals(ambito));
        
        if (existe) {
            return true;
        }
    }
    return false;
}
    
    // Entrar a un nuevo ámbito
    public void entrarAmbito(String ambito) {
        pilaAmbitos.push(ambito);
    }

    // Salir del ámbito actual
    public void salirAmbito() {
        if (pilaAmbitos.size() > 1) {
            pilaAmbitos.pop();
        }
    }

        // Verificar si una variable existe por su NOMBRE
    public boolean existeVariable(String nombreVariable) {
        for (Simbolo s : simbolos) {
            if (s.nombre.equals(nombreVariable)) {
                return true;
            }
        }
        return false;
    }
    
    // Obtener el tipo de dato de una variable por su NOMBRE
    public String getTipoVariable(String nombreVariable) {
        for (Simbolo s : simbolos) {
            if (s.nombre.equals(nombreVariable)) {
                return s.tipoDato;  // Retorna "int", "String", etc.
            }
        }
        return null;
    }
    
    public boolean existeEnAmbitoActual2(String nombre) {
        for (Simbolo s : simbolos) {
            if (s.nombre.equals(nombre)) {
                return true;
            }
        }
        return false;
    }
public boolean existeEnAmbitoSuperior2(String nombre) {
    // Primero, verifica en el ámbito actual
    if (existeEnAmbitoActual(nombre)) {
        return true; // Si existe en el ámbito actual, retorna true
    }

    // Luego, verifica en los ámbitos superiores
    for (int i = pilaAmbitos.size() - 2; i >= 0; i--) {
        String ambito = pilaAmbitos.get(i);
        for (Simbolo s : simbolos) {
            if (s.nombre.equals(nombre) && s.ambito.equals(ambito)) {
                return true; // Se encontró en un ámbito superior
            }
        }
    }
    
    return false; // No se encontró en el ámbito actual ni en los superiores
}


    // Método mejorado de agregar con verificación
    public boolean agregarConVerificacion(String nombre, String tipo, String tipoDato, int linea, Object valor) {
        if (existeEnAmbitoActual(nombre)) {
            return false; // Ya existe
        }
        agregar(nombre, tipo, tipoDato, linea, valor);
        return true; // Se agregó exitosamente
    }
    
    // Buscar un símbolo por nombre en todos los ámbitos
    public Simbolo buscar(String nombre) {
        for (int i = pilaAmbitos.size() - 1; i >= 0; i--) {
            String ambito = pilaAmbitos.get(i);
            for (Simbolo s : simbolos) {
                if (s.nombre.equals(nombre) && s.ambito.equals(ambito)) {
                    return s;
                }
            }
        }
        return null; // No encontrado
    }

    public List<Simbolo> getSimbolos() {
        return simbolos;
    }

    public void imprimir() {
        System.out.println("\n=== TABLA DE SÍMBOLOS ===");
        System.out.printf("%-5s %-20s %-15s %-15s %-20s %-10s%n", 
            "ID", "NOMBRE", "TIPO", "TIPO DATO", "ÁMBITO", "LÍNEA");
        System.out.println("-".repeat(90));
        
        for (Simbolo s : simbolos) {
            System.out.printf("%-5d %-20s %-15s %-15s %-20s %-10d%n", 
                s.id, s.nombre, s.tipo, s.tipoDato, s.ambito, s.linea);
        }
    }
}






