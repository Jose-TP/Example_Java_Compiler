/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package compi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author joset
 */
public class Compi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String ruta = "C:\\Users\\joset\\OneDrive\\Desktop\\Adapter_IDE\\src\\compi\\Lexer.flex";
        generarLexer(ruta);
    }
    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
    /* public static void main(String[] args) throws Exception {
        String ruta1 = "C:\\Users\\joset\\OneDrive\\Documents\\NetBeansProjects\\Compi\\src\\compi\\Lexer.flex";
        String ruta2 = "C:\\Users\\joset\\OneDrive\\Documents\\NetBeansProjects\\Compi\\src\\compi\\LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "C:\\Users\\joset\\OneDrive\\Documents\\NetBeansProjects\\Compi\\src\\compi\\Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
    }
    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);
   
        Path rutaSym = Paths.get("C:\\Users\\joset\\OneDrive\\Documents\\NetBeansProjects\\Compi\\src\\compi\\sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("C:\\Users\\joset\\OneDrive\\Documents\\NetBeansProjects\\Compi\\sym.java"), 
                Paths.get("C:\\Users\\joset\\OneDrive\\Documents\\NetBeansProjects\\Compi\\src\\compi\\sym.java")
        );
        Path rutaSin = Paths.get("C:\\Users\\joset\\OneDrive\\Documents\\NetBeansProjects\\Compi\\src\\compi\\Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("C:\\Users\\joset\\OneDrive\\Documents\\NetBeansProjects\\Compi\\Sintax.java"), 
                Paths.get("C:\\Users\\joset\\OneDrive\\Documents\\NetBeansProjects\\Compi\\src\\compi\\Sintax.java")
        );
    }*/
    
}
