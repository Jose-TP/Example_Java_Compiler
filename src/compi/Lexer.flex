package codigo;

import static codigo.Tokens.*;

%%
// Configuración del scanner
%class Lexer
%unicode
%line
%column
%public
%unicode
%cup
%type Tokens

// Definiciones de expresiones regulares
L       = [a-zA-Z_]
D       = [0-9]
ID      = {L}({L}|{D})*
ENTERO  = "-"?[0-9]+  
DECIMAL = "-"?[0-9]+\.[0-9]+
CARACTER = \'(\\.|[^\\'])\'
CADENA = \"([^\"\\]|\\.)*\"
ESPACIOS = [ \t\r\n]+

// Código Java que se incluirá en la clase generada
%{
    public String lexeme;
%}

%%

// ------------------ PALABRAS RESERVADAS DE CONTROL DE FLUJO ------------------
"if"            { lexeme = yytext(); return PALABRA_RESERVADA_IF; }
"else"          { lexeme = yytext(); return PALABRA_RESERVADA_ELSE; }
"for"           { lexeme = yytext(); return PALABRA_RESERVADA_FOR; }
"while"         { lexeme = yytext(); return PALABRA_RESERVADA_WHILE; }
"when"          { lexeme = yytext(); return PALABRA_RESERVADA_WHEN; }

// ------------------ TIPOS DE DATOS ------------------
"int"           { lexeme = yytext(); return PALABRA_RESERVADA_INT; }
"float"         { lexeme = yytext(); return PALABRA_RESERVADA_FLOAT; }
"char"          { lexeme = yytext(); return PALABRA_RESERVADA_CHAR; }
"long"          { lexeme = yytext(); return PALABRA_RESERVADA_LONG; }
"short"         { lexeme = yytext(); return PALABRA_RESERVADA_SHORT; }
"String"        { lexeme = yytext(); return PALABRA_RESERVADA_STRING; }
"List"          { lexeme = yytext(); return PALABRA_RESERVADA_LIST; }
"ArrayList"     { lexeme = yytext(); return PALABRA_RESERVADA_ARRAYLIST; }
"Map"           { lexeme = yytext(); return PALABRA_RESERVADA_MAP; }
"boolean"       { lexeme = yytext(); return PALABRA_RESERVADA_BOOLEAN; }


// ------------ POO: DEFINICIÓN Y USO ------------------
"class"         { lexeme = yytext(); return PALABRA_RESERVADA_CLASS; }
"interface"     { lexeme = yytext(); return PALABRA_RESERVADA_INTERFACE; }
"enum"          { lexeme = yytext(); return PALABRA_RESERVADA_ENUM; }
"abstract"      { lexeme = yytext(); return PALABRA_RESERVADA_ABSTRACT; }
"final"         { lexeme = yytext(); return PALABRA_RESERVADA_FINAL; }
"extends"       { lexeme = yytext(); return PALABRA_RESERVADA_EXTENDS; }
"implements"    { lexeme = yytext(); return PALABRA_RESERVADA_IMPLEMENTS; }
"super"         { lexeme = yytext(); return PALABRA_RESERVADA_SUPER; }
"this"          { lexeme = yytext(); return PALABRA_RESERVADA_THIS; }
"new"           { lexeme = yytext(); return PALABRA_RESERVADA_NEW; }

// ------------ MODIFICADORES DE ACCESO ------------------
"public"        { lexeme = yytext(); return PALABRA_RESERVADA_PUBLIC; }
"private"       { lexeme = yytext(); return PALABRA_RESERVADA_PRIVATE; }
"protected"     { lexeme = yytext(); return PALABRA_RESERVADA_PROTECTED; }

// ------------ OTROS MODIFICADORES ------------------
"static"        { lexeme = yytext(); return PALABRA_RESERVADA_STATIC; }
"override"      { lexeme = yytext(); return PALABRA_RESERVADA_OVERRIDE; }

// ------------ FUNCIONES Y RETORNO ------------------
"return"        { lexeme = yytext(); return PALABRA_RESERVADA_RETURN; }
"void"          { lexeme = yytext(); return PALABRA_RESERVADA_VOID; }

// ------------ MANEJO DE EXCEPCIONES ------------------
"try"           { lexeme = yytext(); return PALABRA_RESERVADA_TRY; }
"catch"         { lexeme = yytext(); return PALABRA_RESERVADA_CATCH; }

// ------------ UTILIDADES ------------------
"import"        { lexeme = yytext(); return PALABRA_RESERVADA_IMPORT; }
"var"           { lexeme = yytext(); return PALABRA_RESERVADA_VAR; }
"val"           { lexeme = yytext(); return PALABRA_RESERVADA_VAL; }
"const"         { lexeme = yytext(); return PALABRA_RESERVADA_CONST; }

// ------------ BOOLEANOS ------------------
"true"         { lexeme = yytext(); return PALABRA_RESERVADA_TRUE; }
"false"         { lexeme = yytext(); return PALABRA_RESERVADA_FALSE; }
"&&"         { lexeme = yytext(); return OPERADOR_AND; }
"||"         { lexeme = yytext(); return OPERADOR_OR; }
"!"         { lexeme = yytext(); return OPERADOR_NOT; }


// ------------ LITERAL NULO ------------------
"null"          { lexeme = yytext(); return PALABRA_RESERVADA_NULL; }


// ------------------ OPERADORES ------------------
"->"            { return OPERADOR_FLECHA; }
".."            { return OPERADOR_RANGO; }
","            { return COMA; }
";"            { return PUNTO_Y_COMA; }
\"             { return COMILLA_DOBLE; }
\'             { return COMILLA_SIMPLE; }




// Aritméticos
"+"             { return OPERADOR_ADICION; }
"-"             { return OPERADOR_SUSTRACCION; }
"*"             { return OPERADOR_MULTIPLICACION; }
"/"             { return OPERADOR_DIVISION; }

// Unarios
"++"            { return OPERADOR_INCREMENTO; }
"--"            { return OPERADOR_DISMINUCION; }

// Relacionales
">"             { return OPERADOR_MAYOR_QUE; }
">="            { return OPERADOR_MAYOR_IGUAL_QUE; }
"<"             { return OPERADOR_MENOR_QUE; }
"<="            { return OPERADOR_MENOR_IGUAL_QUE; }
"=="            { return OPERADOR_IGUAL; }
"!="            { return OPERADOR_DISTINTO; }

// Asignación
"="             { return OPERADOR_ASIGNACION; }
"*="            { return OPERADOR_ASIGNACION_MULTIPLICACION; }
"/="            { return OPERADOR_ASIGNACION_DIVISION; }
"+="            { return OPERADOR_ASIGNACION_ADICION; }
"-="            { return OPERADOR_ASIGNACION_SUSTRACCION; }
">>="           { return OPERADOR_ASIGNACION_DESPLAZAMIENTO_DERECHA; }
"<<="           { return OPERADOR_ASIGNACION_DESPLAZAMIENTO_IZQUIERDA; }

// Bits (desplazamiento)
">>"            { return OPERADOR_DESPLAZAMIENTO_DERECHA; }
"<<"            { return OPERADOR_DESPLAZAMIENTO_IZQUIERDA; }

// Paréntesis, corchetes, llaves
"("             { return OPERADOR_PARENTESIS_ABRIR; }
")"             { return OPERADOR_PARENTESIS_CERRAR; }
"["             { return OPERADOR_CORCHETE_ABRIR; }
"]"             { return OPERADOR_CORCHETE_CERRAR; }
"{"             { return OPERADOR_LLAVE_ABRIR; }
"}"             { return OPERADOR_LLAVE_CERRAR; }

// ------------------ LITERALES ------------------
{DECIMAL}       { lexeme = yytext(); return LITERAL_NUM_FLOTANTE; }
{ENTERO}        { lexeme = yytext(); return LITERAL_NUM_ENTERO; }
{CARACTER}      { lexeme = yytext(); return LITERAL_CARACTER; }
{CADENA}        { lexeme = yytext(); return LITERAL_STRING; }

// ------------------ COMENTARIOS ------------------
"//".*          { /* Comentario de línea - ignorar */ return COMENTARIO; }
"/*"([^*]|\*+[^*/])*\*+"/"   { return COMENTARIO; }

// ------------------ IDENTIFICADORES ------------------
{ID}            { lexeme = yytext(); return IDENTIFICADOR; }

// ------------------ ESPACIOS EN BLANCO ------------------
{ESPACIOS}      { /* ignorar espacios */ }

// ------------------ ERRORES ------------------
.               { lexeme = yytext(); return OPERADOR_PUNTO; }
