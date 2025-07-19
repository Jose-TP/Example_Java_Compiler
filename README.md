Compiler for a Java-based language, for the final project of the compilers course.

# Compilador Java con Análisis Léxico, Sintáctico y Semántico
<img width="1350" height="719" alt="image" src="https://github.com/user-attachments/assets/f7921cf9-4794-4330-9749-c0415d9e65b7" />

<div align="center">
  
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![JFlex](https://img.shields.io/badge/JFlex-1.7.0-blue?style=for-the-badge)
![CUP](https://img.shields.io/badge/JavaCUP-11b-green?style=for-the-badge)
![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans-ide&logoColor=white)

</div>

## 📋 Descripción

Este proyecto es un **compilador completo para un lenguaje similar a Java/Kotlin** desarrollado como proyecto final del curso de Compiladores. Implementa todas las fases fundamentales de un compilador: análisis léxico, análisis sintáctico y análisis semántico. El compilador es capaz de detectar y reportar errores en cada una de estas fases, proporcionando información detallada sobre la ubicación y naturaleza de los errores.

## ✨ Características

### 🔍 Análisis Léxico
- Reconocimiento de tokens complejos (identificadores, literales, operadores, palabras reservadas)
- Manejo de comentarios de línea y bloque
- Detección de errores léxicos con información de línea y columna
- Soporte para literales de diferentes tipos (enteros, flotantes, strings, booleanos)

### 🌳 Análisis Sintáctico
- Parser robusto construido con JavaCUP
- Soporte para estructuras POO (clases, interfaces, herencia)
- Manejo de estructuras de control (if/else, while, for, when)
- Expresiones complejas con precedencia de operadores correcta
- Tipos genéricos (List<T>, Map<K,V>)
- Manejo de excepciones (try/catch)

### 🧠 Análisis Semántico
- **Verificación de tipos**: Compatibilidad en asignaciones y operaciones
- **Verificación de declaraciones**: Detección de variables no declaradas o duplicadas
- **Verificación de alcance**: Manejo correcto de ámbitos locales y globales
- **Tabla de símbolos completa** con información de tipo, valor y ámbito
- Soporte para constantes y verificación de inmutabilidad

### 🖥️ Interfaz Gráfica
- Editor de código con resaltado de sintaxis
- Vista en tiempo real de la tabla de símbolos
- Panel de errores léxicos, sintácticos y semánticos
- Visualización del árbol sintáctico (AST)

## 🛠️ Tecnologías Utilizadas

- **Java 11+** - Lenguaje principal de desarrollo
- **JFlex 1.7.0** - Generador de analizadores léxicos
- **JavaCUP 11b** - Generador de analizadores sintácticos
- **Swing** - Interfaz gráfica de usuario
- **NetBeans IDE** - Entorno de desarrollo

## 📦 Instalación

### Prerrequisitos

- Java JDK 11 o superior
- NetBeans IDE (recomendado) o cualquier IDE Java
- JFlex 1.7.0
- JavaCUP 11b

### Pasos de Instalación

1. **Clonar el repositorio**
   ```bash
   git clone https://github.com/tu_usuario/compilador-java.git
   cd compilador-java

## 🚀 Uso
- Ejecutar el compilador
- Abrir el proyecto en NetBeans
- Ejecutar la clase principal Home.java
- La interfaz gráfica se abrirá automáticamente
- Escribir código de prueba

## 🧪 Ejemplos de Características

### Tipos de datos soportados
- Primitivos: `int`, `float`, `double`, `char`, `boolean`, `string`
- Complejos: `List<T>`, `Map<K,V>`, `ArrayList<T>`

### Operadores
- Aritméticos: `+`, `-`, `*`, `/`, `%`
- Lógicos: `&&`, `||`, `!`
- Relacionales: `>`, `<`, `>=`, `<=`, `==`, `!=`
- Asignación: `=`, `+=`, `-=`, `*=`, `/=`

### Estructuras de control
```java
// If-else
if (condicion) {
    // código
} else {
    // código
}

// While
while (condicion) {
    // código
}

// For tradicional y for-range
for (int i = 0; i < 10; i++) { }
for (int x in 0..10) { }
```

## 👥 Autor

**Tu Nombre**
- GitHub: [Jose-TP](https://github.com/Jose-TP)
- LinkedIn: [Tu Perfil](https://linkedin.com/in/tu_perfil)

## 🙏 Agradecimientos

- A mi profesora de Compiladores por la guía y apoyo durante el desarrollo
- A la comunidad de JFlex y JavaCUP por las excelentes herramientas
- A mis compañeros de clase por el feedback y pruebas

---

⭐ Si este proyecto te ha sido útil, considera darle una estrella en GitHub ⭐

