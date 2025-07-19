/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 
package compi;

/**
 *
 * @author joset
 
public enum Tokens {
    Reservadas,
    Igual,
    Suma,
    Resta,
    Multiplicacion,
    Division,
    Identificador,
    Numero,
    ERROR
}*/
package compi;


public enum Tokens {
    // ------------------- IDENTIFICADORES -------------------
    IDENTIFICADOR,

    // ------------------- OPERADORES -------------------
    OPERADOR,
    OPERADOR_FLECHA,
    OPERADOR_RANGO,
    COMA,
    PUNTO_Y_COMA,
    COMILLA_DOBLE,
    COMILLA_SIMPLE,

    // Aritméticos
    OPERADOR_ADICION,
    OPERADOR_SUSTRACCION,
    OPERADOR_MULTIPLICACION,
    OPERADOR_DIVISION,
    OPERADOR_SIGNO,

    // Unarios
    OPERADOR_INCREMENTO,
    OPERADOR_DISMINUCION,

    // Relacionales y lógicos
    OPERADOR_MAYOR_QUE,
    OPERADOR_MAYOR_IGUAL_QUE,
    OPERADOR_MENOR_QUE,
    OPERADOR_MENOR_IGUAL_QUE,
    OPERADOR_IGUAL,
    OPERADOR_DISTINTO,

        // Lógicos
    OPERADOR_AND,  // Para la operación lógica AND
    OPERADOR_OR,   // Para la operación lógica OR
    OPERADOR_NOT,  // Para la operación lógica NOT
    
    // Asignación
    OPERADOR_ASIGNACION,
    OPERADOR_ASIGNACION_MULTIPLICACION,
    OPERADOR_ASIGNACION_DIVISION,
    OPERADOR_ASIGNACION_ADICION,
    OPERADOR_ASIGNACION_SUSTRACCION,
    OPERADOR_ASIGNACION_DESPLAZAMIENTO_DERECHA,
    OPERADOR_ASIGNACION_DESPLAZAMIENTO_IZQUIERDA,

    // Bits
    OPERADOR_DESPLAZAMIENTO_DERECHA,
    OPERADOR_DESPLAZAMIENTO_IZQUIERDA,

    // Paréntesis, corchetes y llaves
    OPERADOR_PARENTESIS_ABRIR,
    OPERADOR_PARENTESIS_CERRAR,
    OPERADOR_CORCHETE_ABRIR,
    OPERADOR_CORCHETE_CERRAR,
    OPERADOR_LLAVE_ABRIR,
    OPERADOR_LLAVE_CERRAR,
    OPERADOR_PUNTO,

    // ------------------- PALABRAS RESERVADAS -------------------
    PALABRA_RESERVADA,
    
    // ------------------- PALABRAS RESERVADAS -------------------
        // Control de flujo
        PALABRA_RESERVADA_IF,
        PALABRA_RESERVADA_ELSE,
        PALABRA_RESERVADA_FOR,
        PALABRA_RESERVADA_WHILE,
        PALABRA_RESERVADA_WHEN,

        // Tipos de datos
        PALABRA_RESERVADA_INT,
        PALABRA_RESERVADA_FLOAT,
        PALABRA_RESERVADA_CHAR,
        PALABRA_RESERVADA_LONG,
        PALABRA_RESERVADA_SHORT,
        PALABRA_RESERVADA_STRING,
        PALABRA_RESERVADA_LIST,
        PALABRA_RESERVADA_BOOLEAN,
        PALABRA_RESERVADA_ARRAYLIST,
        PALABRA_RESERVADA_MAP,

        // Programación orientada a objetos - estructura
        PALABRA_RESERVADA_CLASS,
        PALABRA_RESERVADA_INTERFACE,
        PALABRA_RESERVADA_ENUM,
        PALABRA_RESERVADA_ABSTRACT,
        PALABRA_RESERVADA_FINAL,
        PALABRA_RESERVADA_EXTENDS,
        PALABRA_RESERVADA_IMPLEMENTS,
        PALABRA_RESERVADA_SUPER,
        PALABRA_RESERVADA_THIS,
        PALABRA_RESERVADA_NEW,

        // Modificadores de acceso
        PALABRA_RESERVADA_PUBLIC,
        PALABRA_RESERVADA_PRIVATE,
        PALABRA_RESERVADA_PROTECTED,

        // Otros modificadores
        PALABRA_RESERVADA_STATIC,
        PALABRA_RESERVADA_OVERRIDE,

        // Retorno
        PALABRA_RESERVADA_RETURN,
        PALABRA_RESERVADA_VOID,

        // Manejo de excepciones
        PALABRA_RESERVADA_TRY,
        PALABRA_RESERVADA_CATCH,

        // Utilidades
        PALABRA_RESERVADA_IMPORT,
        PALABRA_RESERVADA_VAR,
        PALABRA_RESERVADA_VAL,
        PALABRA_RESERVADA_CONST,

        // Literal nulo (puede ir como literal también)
        PALABRA_RESERVADA_NULL,

    

    // ------------------- LITERALES -------------------
    LITERAL,
    LITERAL_NUM_ENTERO,
    LITERAL_NUM_FLOTANTE,
    LITERAL_CARACTER,
    LITERAL_STRING,

        // Literales booleanos
    PALABRA_RESERVADA_TRUE,  // Para el valor booleano verdadero
    PALABRA_RESERVADA_FALSE,  // Para el valor booleano falso
    
    // ------------------- COMENTARIOS -------------------
    COMENTARIO,
    
    LITERAL_NULO,

    // ------------------- ERRORES -------------------
    ERROR,
    ERROR_LITERAL,
    ERROR_IDENTIFICADOR,
    ERROR_PALABRA_RESERVADA,
    ERROR_OPERADOR,

    // ------------------- FIN -------------------
    FIN
}

