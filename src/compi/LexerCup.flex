package codigo;
import java_cup.runtime.Symbol;

%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char

// Definiciones de expresiones regulares
L = [a-zA-Z_]
D = [0-9]
ID = {L}({L}|{D})*
ENTERO = "-"?[0-9]+ 
DECIMAL = "-"?[0-9]+\.[0-9]+
CARACTER = \'(\\.|[^\\'])\'
CADENA = \"([^\"\\]|\\.)*\"
ESPACIOS = [ \t\r\n]+

%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}

%%

/* Espacios en blanco */
{ESPACIOS} {/*Ignore*/}

/* Comentarios */
"//".*          {/*Ignore*/}
"/*"([^*]|\*+[^*/])*\*+"/"   {/*Ignore*/}

// ------------------ PALABRAS RESERVADAS DE CONTROL DE FLUJO ------------------
( "if" )            { return new Symbol(sym.PALABRA_RESERVADA_IF, yychar, yyline, yytext()); }
( "else" )          { return new Symbol(sym.PALABRA_RESERVADA_ELSE, yychar, yyline, yytext()); }
( "for" )           { return new Symbol(sym.PALABRA_RESERVADA_FOR, yychar, yyline, yytext()); }
( "while" )         { return new Symbol(sym.PALABRA_RESERVADA_WHILE, yychar, yyline, yytext()); }
( "when" )          { return new Symbol(sym.PALABRA_RESERVADA_WHEN, yychar, yyline, yytext()); }

//OPERADORS RELACIONALES
( "&&" )            { return new Symbol(sym.OPERADOR_AND, yychar, yyline, yytext()); }
( "||" )            { return new Symbol(sym.OPERADOR_OR, yychar, yyline, yytext()); }
( "!" )            { return new Symbol(sym.OPERADOR_NOT, yychar, yyline, yytext()); }

// ------------------ TIPOS DE DATOS ------------------
( "int" )           { return new Symbol(sym.PALABRA_RESERVADA_INT, yychar, yyline, yytext()); }
( "float" )         { return new Symbol(sym.PALABRA_RESERVADA_FLOAT, yychar, yyline, yytext()); }
( "char" )          { return new Symbol(sym.PALABRA_RESERVADA_CHAR, yychar, yyline, yytext()); }
( "long" )          { return new Symbol(sym.PALABRA_RESERVADA_LONG, yychar, yyline, yytext()); }
( "short" )         { return new Symbol(sym.PALABRA_RESERVADA_SHORT, yychar, yyline, yytext()); }
( "String" )        { return new Symbol(sym.PALABRA_RESERVADA_STRING, yychar, yyline, yytext()); }
( "List" )          { return new Symbol(sym.PALABRA_RESERVADA_LIST, yychar, yyline, yytext()); }
( "ArrayList" )     { return new Symbol(sym.PALABRA_RESERVADA_ARRAYLIST, yychar, yyline, yytext()); }
( "Map" )           { return new Symbol(sym.PALABRA_RESERVADA_MAP, yychar, yyline, yytext()); }
( "boolean" )       { return new Symbol(sym.PALABRA_RESERVADA_BOOLEAN, yychar, yyline, yytext()); }

// ------------ POO: DEFINICIÓN Y USO ------------------
( "class" )         { return new Symbol(sym.PALABRA_RESERVADA_CLASS, yychar, yyline, yytext()); }
( "interface" )     { return new Symbol(sym.PALABRA_RESERVADA_INTERFACE, yychar, yyline, yytext()); }
( "enum" )          { return new Symbol(sym.PALABRA_RESERVADA_ENUM, yychar, yyline, yytext()); }
( "abstract" )      { return new Symbol(sym.PALABRA_RESERVADA_ABSTRACT, yychar, yyline, yytext()); }
( "final" )         { return new Symbol(sym.PALABRA_RESERVADA_FINAL, yychar, yyline, yytext()); }
( "extends" )       { return new Symbol(sym.PALABRA_RESERVADA_EXTENDS, yychar, yyline, yytext()); }
( "implements" )    { return new Symbol(sym.PALABRA_RESERVADA_IMPLEMENTS, yychar, yyline, yytext()); }
( "super" )         { return new Symbol(sym.PALABRA_RESERVADA_SUPER, yychar, yyline, yytext()); }
( "this" )          { return new Symbol(sym.PALABRA_RESERVADA_THIS, yychar, yyline, yytext()); }
( "new" )           { return new Symbol(sym.PALABRA_RESERVADA_NEW, yychar, yyline, yytext()); }

// ------------ MODIFICADORES DE ACCESO ------------------
( "public" )        { return new Symbol(sym.PALABRA_RESERVADA_PUBLIC, yychar, yyline, yytext()); }
( "private" )       { return new Symbol(sym.PALABRA_RESERVADA_PRIVATE, yychar, yyline, yytext()); }
( "protected" )     { return new Symbol(sym.PALABRA_RESERVADA_PROTECTED, yychar, yyline, yytext()); }

// ------------ OTROS MODIFICADORES ------------------
( "static" )        { return new Symbol(sym.PALABRA_RESERVADA_STATIC, yychar, yyline, yytext()); }
( "override" )      { return new Symbol(sym.PALABRA_RESERVADA_OVERRIDE, yychar, yyline, yytext()); }

// ------------ FUNCIONES Y RETORNO ------------------
( "return" )        { return new Symbol(sym.PALABRA_RESERVADA_RETURN, yychar, yyline, yytext()); }
( "void" )          { return new Symbol(sym.PALABRA_RESERVADA_VOID, yychar, yyline, yytext()); }

// ------------ MANEJO DE EXCEPCIONES ------------------
( "try" )           { return new Symbol(sym.PALABRA_RESERVADA_TRY, yychar, yyline, yytext()); }
( "catch" )         { return new Symbol(sym.PALABRA_RESERVADA_CATCH, yychar, yyline, yytext()); }

// ------------ UTILIDADES ------------------
( "import" )        { return new Symbol(sym.PALABRA_RESERVADA_IMPORT, yychar, yyline, yytext()); }
( "var" )           { return new Symbol(sym.PALABRA_RESERVADA_VAR, yychar, yyline, yytext()); }
( "val" )           { return new Symbol(sym.PALABRA_RESERVADA_VAL, yychar, yyline, yytext()); }
( "const" )         { return new Symbol(sym.PALABRA_RESERVADA_CONST, yychar, yyline, yytext()); }


// ------------ LITERAL NULO ------------------
( "null" )          { return new Symbol(sym.PALABRA_RESERVADA_NULL, yychar, yyline, yytext()); }

( "true" )          { return new Symbol(sym.PALABRA_RESERVADA_TRUE, yychar, yyline, yytext()); }
( "false" )          { return new Symbol(sym.PALABRA_RESERVADA_FALSE, yychar, yyline, yytext()); }


// ------------------ OPERADORES COMPUESTOS (ORDEN IMPORTANTE) ------------------
( "->" )            { return new Symbol(sym.OPERADOR_FLECHA, yychar, yyline, yytext()); }
( ".." )            { return new Symbol(sym.OPERADOR_RANGO, yychar, yyline, yytext()); }
( "++" )            { return new Symbol(sym.OPERADOR_INCREMENTO, yychar, yyline, yytext()); }
( "--" )            { return new Symbol(sym.OPERADOR_DISMINUCION, yychar, yyline, yytext()); }
( ">=" )            { return new Symbol(sym.OPERADOR_MAYOR_IGUAL_QUE, yychar, yyline, yytext()); }
( "<=" )            { return new Symbol(sym.OPERADOR_MENOR_IGUAL_QUE, yychar, yyline, yytext()); }
( "==" )            { return new Symbol(sym.OPERADOR_IGUAL, yychar, yyline, yytext()); }
( "!=" )            { return new Symbol(sym.OPERADOR_DISTINTO, yychar, yyline, yytext()); }
( "*=" )            { return new Symbol(sym.OPERADOR_ASIGNACION_MULTIPLICACION, yychar, yyline, yytext()); }
( "/=" )            { return new Symbol(sym.OPERADOR_ASIGNACION_DIVISION, yychar, yyline, yytext()); }
( "+=" )            { return new Symbol(sym.OPERADOR_ASIGNACION_ADICION, yychar, yyline, yytext()); }
( "-=" )            { return new Symbol(sym.OPERADOR_ASIGNACION_SUSTRACCION, yychar, yyline, yytext()); }
( ">>=" )           { return new Symbol(sym.OPERADOR_ASIGNACION_DESPLAZAMIENTO_DERECHA, yychar, yyline, yytext()); }
( "<<=" )           { return new Symbol(sym.OPERADOR_ASIGNACION_DESPLAZAMIENTO_IZQUIERDA, yychar, yyline, yytext()); }
( ">>" )            { return new Symbol(sym.OPERADOR_DESPLAZAMIENTO_DERECHA, yychar, yyline, yytext()); }
( "<<" )            { return new Symbol(sym.OPERADOR_DESPLAZAMIENTO_IZQUIERDA, yychar, yyline, yytext()); }

// ------------------ OPERADORES SIMPLES ------------------
( "+" )             { return new Symbol(sym.OPERADOR_ADICION, yychar, yyline, yytext()); }
( "-" )             { return new Symbol(sym.OPERADOR_SUSTRACCION, yychar, yyline, yytext()); }
( "*" )             { return new Symbol(sym.OPERADOR_MULTIPLICACION, yychar, yyline, yytext()); }
( "/" )             { return new Symbol(sym.OPERADOR_DIVISION, yychar, yyline, yytext()); }
( ">" )             { return new Symbol(sym.OPERADOR_MAYOR_QUE, yychar, yyline, yytext()); }
( "<" )             { return new Symbol(sym.OPERADOR_MENOR_QUE, yychar, yyline, yytext()); }
( "=" )             { return new Symbol(sym.OPERADOR_ASIGNACION, yychar, yyline, yytext()); }

// ------------------ DELIMITADORES ------------------
( "(" )             { return new Symbol(sym.OPERADOR_PARENTESIS_ABRIR, yychar, yyline, yytext()); }
( ")" )             { return new Symbol(sym.OPERADOR_PARENTESIS_CERRAR, yychar, yyline, yytext()); }
( "[" )             { return new Symbol(sym.OPERADOR_CORCHETE_ABRIR, yychar, yyline, yytext()); }
( "]" )             { return new Symbol(sym.OPERADOR_CORCHETE_CERRAR, yychar, yyline, yytext()); }
( "{" )             { return new Symbol(sym.OPERADOR_LLAVE_ABRIR, yychar, yyline, yytext()); }
( "}" )             { return new Symbol(sym.OPERADOR_LLAVE_CERRAR, yychar, yyline, yytext()); }

// ------------------ SIGNOS DE PUNTUACIÓN ------------------
( "," )             { return new Symbol(sym.COMA, yychar, yyline, yytext()); }
( ";" )             { return new Symbol(sym.PUNTO_Y_COMA, yychar, yyline, yytext()); }
( "\"" )            { return new Symbol(sym.COMILLA_DOBLE, yychar, yyline, yytext()); }
( "'" )             { return new Symbol(sym.COMILLA_SIMPLE, yychar, yyline, yytext()); }

// ------------------ LITERALES ------------------
// Lexer (JFlex)
{DECIMAL}    { return new Symbol(sym.LITERAL_NUM_FLOTANTE, yyline, yycolumn, yytext()); }
{ENTERO}     { return new Symbol(sym.LITERAL_NUM_ENTERO, yyline, yycolumn, yytext()); }
{CADENA}     { return new Symbol(sym.LITERAL_STRING, yyline, yycolumn, yytext()); }

{CARACTER}          { return new Symbol(sym.LITERAL_CARACTER, yychar, yyline, yytext()); }
// ------------------ IDENTIFICADORES ------------------
{ID}                { 
        System.out.println("Se uso una vriable en:"+ yychar+" o mejor dicho en "+ yyline);
return new Symbol(sym.IDENTIFICADOR,  yyline, yychar, yytext()); }

// ------------------ ERROR DE ANÁLISIS ------------------
.                   { return new Symbol(sym.PUNTO, yychar, yyline, yytext()); }