
//import com.teamdev.jxbrowser.chromium.Browser;
//import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import compi.Lexer;
import compi.Simbolo;
import compi.Sintax;
import compi.Tokens;


import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;


import static compi.Tokens.COMENTARIO;
import static compi.Tokens.ERROR;
import static compi.Tokens.IDENTIFICADOR;
import static compi.Tokens.LITERAL_CARACTER;
import static compi.Tokens.LITERAL_NUM_ENTERO;
import static compi.Tokens.LITERAL_NUM_FLOTANTE;
import static compi.Tokens.LITERAL_STRING;
import static compi.Tokens.PALABRA_RESERVADA;
//import compi.formulario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import javax.swing.tree.TreePath;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import org.fife.ui.rtextarea.*;
import org.fife.ui.rsyntaxtextarea.*;







public class home extends javax.swing.JFrame {
    
    

    
    boolean a=false, b=true, c=true, d=true, e=false,
     f=false, g=false, h=false, i=false;
    
    boolean themeDark = false;
    private RSyntaxTextArea syntaxArea = new RSyntaxTextArea();

    DefaultListModel<String> modeloLista;
        DefaultListModel<String> modeloLista2;

    
    private String textoGuardado = "";



    private JEditorPane webView;
    private JScrollPane webScrollPane;
    //private int geeksFlag = 0;
    
    
    private String fpath=null;
    private String fname=null;
    private LinkedList<String> plist=new LinkedList<String>();
    private LinkedList<String> nlist=new LinkedList<String>();
    private JTree tree=new JTree();
    private String face="Abyssinica SIL";
    private int fsize=18;
    private int flagProj=1,flagStat=1,projSizeX,projSizeY,statSizeX,statSizeY,fullFlag=1,geeksFlag=1;
    private int count,op=(int)'{',cl=(int)'}',prev=0,indflag=0;
    private JPopupMenu jp=new JPopupMenu();
//    private BrowserView view;
    
    
    public home() {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        initComponents();
        inicializarVisorWeb();
        changeEnabled();
        jPanel2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        jPanel2.revalidate();
        jPanel2.repaint();
        jPanel8.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        jPanel8.revalidate();
        jPanel8.repaint();
        jPanel9.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        jPanel9.revalidate();
        jPanel9.repaint();
        jPanel10.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        jPanel10.revalidate();
        jPanel10.repaint();
        jcloseTab.setContentAreaFilled(false);
        jcloseTab.setOpaque(true);
        
        



//temaa.setIcon(new ImageIcon("C:\\Users\\joset\\OneDrive\\Desktop\\Adapter_IDE\\src\\icon\\sol.png"));

        

                    //configurarEditorBonito(); // aquí

        //changeColor();
        //aplicarColores(this.getContentPane(),new Color(15,15,15),Color.WHITE);  
        //aplicarColores(this.getContentPane(),new Color(247,247,247),Color.BLACK);   
        //aplicarEstiloBotones(this.getContentPane());
        jLabel9.setForeground(Color.blue);
        
            configurarEditorBonito(); // aquí

        modeloLista = new DefaultListModel<>();
        jList1.setModel(modeloLista);

            
            
        
        this.setBounds(0, 0, 1864,1040);
        
        ttree();
        plist.add(null);
        nlist.add(null);
        projSizeX=projectPane.getWidth();
        projSizeY=projectPane.getHeight();
        statSizeX=jScrollPane2.getWidth();
        statSizeY=jScrollPane2.getHeight();
        JMenuItem m1=new JMenuItem();
        m1.setText("Cut");
        jp.add(m1);
        m1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuActionPerformed(evt);
            }
        });
        JMenuItem m2=new JMenuItem();
        m2.setText("Copy");
        jp.add(m2);
        m2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuActionPerformed(evt);
            }
        });
        JMenuItem m3=new JMenuItem();
        m3.setText("Paste");
        jp.add(m3);
        m3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteMenuActionPerformed(evt);
            }
        });
        JMenuItem m4=new JMenuItem();
        m4.setText("Save");
        jp.add(m4);
        m4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuActionPerformed(evt);
            }
        });
        JMenuItem m5=new JMenuItem();
        m5.setText("Run");
        jp.add(m5);
        m5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runMenuActionPerformed(evt);
            }
        });
        JMenuItem m6=new JMenuItem();
        m6.setText("Full Screen");
        jp.add(m6);
        m6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullMenuActionPerformed(evt);
            }
        });
        
        
        
        
        
            syntaxArea.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            System.out.println("1");
            actualizarEstadoBoton();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
                        System.out.println("2");

            actualizarEstadoBoton();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
                        System.out.println("3");

            actualizarEstadoBoton();
        }
    });
                    actualizarEstadoBoton();

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Verificar tu condición aquí
                if (h) {  // Si NO se cumple la condición
                    // Mostrar diálogo de confirmación
                    int opcion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Estás seguro de que quieres cerrar? Hay cambios sin guardar.",
                        "Confirmar cierre",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                    );

                    if (opcion == JOptionPane.YES_OPTION) {
                        System.exit(0); // Cerrar la aplicación
                    }
                    // Si elige NO, no hace nada (la ventana permanece abierta)
                } else {
                    // Si se cumple la condición, cerrar normalmente
                    System.exit(0);
                }
            }
        });

    }
  

        private void mostrarTablaSimbolos(compi.TablaSimbolos tabla) {
        String[] columnas = {"ID", "Nombre", "Tipo", "Tipo Dato", "Alcance","Valor" ,"Línea"};

        List<Simbolo> simbolos = tabla.getSimbolos();
        Object[][] datos = new Object[simbolos.size()][7];

        for (int i = 0; i < simbolos.size(); i++) {
            Simbolo s = simbolos.get(i);
            datos[i][0] = s.id;
            datos[i][1] = s.nombre;
            datos[i][2] = s.tipo;
            datos[i][3] = s.tipoDato;
            datos[i][4] = s.ambito;
            datos[i][5] = s.valor;
            datos[i][6] = s.linea;
        }

        DefaultTableModel modelo = new DefaultTableModel(datos, columnas);
        tablaSimbolos.setModel(modelo);
    }

    
    private void actualizarEstadoBoton() {
    String textoActual = syntaxArea.getText(); // Reemplaza 'tuCampoTexto' por el nombre de tu campo
    h = !textoActual.isEmpty() && !textoActual.equals(textoGuardado);
    e= !textoActual.isEmpty();
    f= !textoActual.isEmpty();
    g = !textoActual.isEmpty();
    i = !textoActual.isEmpty();

    changeEnabled();
    }

    
    private void inicializarVisorWeb() {
        webView = new JEditorPane();
        webView.setEditable(false);
        webView.setContentType("text/html");
        
        // Crear scroll para el contenido web
        webScrollPane = new JScrollPane(webView);
        webScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        webScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }
    
    private void toggleGeeksPanel() {
        if (geeksFlag == 0) {
            mostrarPanelWeb();
        } else {
            ocultarPanelWeb();
        }
    }
    
    private void mostrarPanelWeb() {
        // Redimensionar componentes principales
        pane.setBounds(pane.getX(), pane.getY(), pane.getWidth() - 550, pane.getHeight());
        jScrollPane2.setBounds(jScrollPane2.getX(), jScrollPane2.getY(), 
                              jScrollPane2.getWidth() - 550, jScrollPane2.getHeight());
        cond.setBounds(jScrollPane2.getX(), jScrollPane2.getY(), 
                      jScrollPane2.getWidth() - 550, jScrollPane2.getHeight());
        
        // Configurar panel web
        geeksPane.setBounds(pane.getX() + pane.getWidth() + 10, pane.getY(), 
                           530, pane.getHeight() + jScrollPane2.getHeight());
        geeksPane.setBorder(pane.getBorder());
        
        // Agregar el visor web
        geeksPane.getViewport().removeAll();
        geeksPane.getViewport().add(webScrollPane);
        
        // Cargar contenido
        cargarContenidoWeb();
        
        geeksFlag = 1;
        revalidate();
        repaint();
    }
    
    private void cargarContenidoWeb() {
        try {
            // Intentar cargar la página
            webView.setPage("https://www.geeksforgeeks.org/");
        } catch (IOException e) {
            // Si no puede cargar, mostrar contenido estático
            mostrarContenidoEstatico();
        }
    }
    
    private void mostrarContenidoEstatico() {
        String htmlContent = 
            "<html>" +
            "<head><title>GeeksforGeeks</title></head>" +
            "<body style='font-family: Arial, sans-serif; margin: 20px;'>" +
            "<h1 style='color: #0f9d58;'>GeeksforGeeks</h1>" +
            "<p>Portal de programación y algoritmos</p>" +
            "<h3>Enlaces útiles:</h3>" +
            "<ul>" +
            "<li><a href='#'>Algoritmos</a></li>" +
            "<li><a href='#'>Estructuras de Datos</a></li>" +
            "<li><a href='#'>Programación en Java</a></li>" +
            "<li><a href='#'>Programación en Python</a></li>" +
            "</ul>" +
            "<p><strong>Nota:</strong> Para ver el contenido completo, " +
            "<a href='#' onclick='alert(\"Abriendo navegador...\")'>haz clic aquí</a> " +
            "para abrir en tu navegador web.</p>" +
            "</body>" +
            "</html>";
        
        webView.setContentType("text/html");
        webView.setText(htmlContent);
        
        // Agregar listener para abrir enlaces en navegador externo
        webView.addHyperlinkListener(e -> {
            if (e.getEventType() == javax.swing.event.HyperlinkEvent.EventType.ACTIVATED) {
                abrirEnNavegadorExterno("https://www.geeksforgeeks.org/");
            }
        });
    }
    
    private void ocultarPanelWeb() {
        // Restaurar tamaños originales
        pane.setBounds(pane.getX(), pane.getY(), pane.getWidth() + 550, pane.getHeight());
        jScrollPane2.setBounds(pane.getX(), jScrollPane2.getY(), 
                              jScrollPane2.getWidth() + 550, jScrollPane2.getHeight());
        cond.setBounds(pane.getX(), jScrollPane2.getY(), 
                      jScrollPane2.getWidth() + 550, jScrollPane2.getHeight());
        
        // Ocultar panel web
        geeksPane.setBounds(pane.getWidth() + pane.getX() + 8, pane.getY(), 
                           0, pane.getHeight() + jScrollPane2.getHeight());
        geeksPane.setBorder(null);
        
        geeksFlag = 0;
        revalidate();
        repaint();
    }
    
    private void abrirEnNavegadorExterno(String url) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new java.net.URI(url));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Error al abrir navegador: " + e.getMessage());
        }
    }
    
    
    
    
    
private void configurarEditorBonito() {
    // Crear el RSyntaxTextArea
    syntaxArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA); // o el lenguaje que quieras
    syntaxArea.setCodeFoldingEnabled(true);
    syntaxArea.setAntiAliasingEnabled(true);
    syntaxArea.setFont(new Font("Consolas", Font.PLAIN, 14));
    syntaxArea.setText(txtEntrada.getText()); // copiar texto existente

    // Crear el scroll con numeración de líneas
    RTextScrollPane sp = new RTextScrollPane(syntaxArea);
    sp.setFoldIndicatorEnabled(true);

    // Reemplazar el componente anterior en su contenedor
    Container parent = txtEntrada.getParent();
    int index = -1;

    for (int i = 0; i < parent.getComponentCount(); i++) {
        if (parent.getComponent(i) == txtEntrada) {
            index = i;
            break;
        }
    }

    if (index != -1) {
        parent.remove(index);              // quita el JTextArea
        parent.add(sp, index);             // pone el nuevo editor en el mismo lugar
        parent.revalidate();               // actualiza el diseño
        parent.repaint();
    }
    
   
    
    
}

    
    
private void aplicarEstiloBotones(Container container) {
    
    Component[] comps = container.getComponents();
    for (int i = 0; i < comps.length; i++) {
        Component comp = comps[i];

        if (comp instanceof JButton && !(comp instanceof BotonDegradadoAnimado)) {
            JButton viejo = (JButton) comp;

            BotonDegradadoAnimado nuevo = new BotonDegradadoAnimado(viejo.getText(), viejo.getIcon());
            nuevo.setBounds(viejo.getBounds());

            // Copiar propiedades
            nuevo.setToolTipText(viejo.getToolTipText());
            nuevo.setFont(viejo.getFont());
            nuevo.setEnabled(viejo.isEnabled());

            // Copiar ActionListeners
            for (ActionListener al : viejo.getActionListeners()) {
                nuevo.addActionListener(al);
            }

            // Copiar MouseListeners si usas
            for (MouseListener ml : viejo.getMouseListeners()) {
                nuevo.addMouseListener(ml);
            }

            container.remove(viejo);
            container.add(nuevo, i);
        } else if (comp instanceof Container) {
            aplicarEstiloBotones((Container) comp);
        }
    }
    container.revalidate();
    container.repaint();

    
}

    
    
    
    
    
    
    
    
    
    public static void aplicarColores(Component comp, Color fondo, Color texto) {
    comp.setBackground(fondo);
    comp.setForeground(texto);
    if (comp instanceof Container) {
        for (Component child : ((Container) comp).getComponents()) {
            aplicarColores(child, fondo, texto);
        }
    }
}


    
    void unDoreDo(JTextArea jt)
    {
        final UndoManager undo = new UndoManager();
   Document doc = jt.getDocument();
    
   // Listen for undo and redo events
   doc.addUndoableEditListener(new UndoableEditListener() {
       public void undoableEditHappened(UndoableEditEvent evt) {
           undo.addEdit(evt.getEdit());
       }
   });
    
   // Create an undo action and add it to the text component
   jt.getActionMap().put("Undo",
       new AbstractAction("Undo") {
           public void actionPerformed(ActionEvent evt) {
               try {
                   if (undo.canUndo()) {
                       undo.undo();
                   }
               } catch (CannotUndoException e) {
               }
           }
      });
    
   // Bind the undo action to ctl-Z
   jt.getInputMap().put(KeyStroke.getKeyStroke("control Z"), "Undo");
    
   // Create a redo action and add it to the text component
   jt.getActionMap().put("Redo",
       new AbstractAction("Redo") {
           public void actionPerformed(ActionEvent evt) {
               try {
                   if (undo.canRedo()) {
                       undo.redo();
                   }
               } catch (CannotRedoException e) {
               }
           }
       });
    
   // Bind the redo action to ctl-Y
   jt.getInputMap().put(KeyStroke.getKeyStroke("control Y"), "Redo");
    
    }
    
    
    private void ttree()
    {
        treeUpdater l=new treeUpdater();
        tree=l.get();
        tree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeValueChanged(evt);
            }
        });
        projectPane.getViewport().add(tree);
    }
    
    private void treeValueChanged(javax.swing.event.TreeSelectionEvent evt)
    {
       try{
        TreePath p=tree.getSelectionPath();
        Object[] pa=p.getPath();
        int l=p.getPathCount();
        String tfpath="";
        for(int i=0;i<l-1;i++)
            tfpath="/"+pa[i];
        String fnme=""+pa[l-1];
        if(fnme.endsWith(".c")||fnme.endsWith(".cpp")||fnme.endsWith(".java"))
        {
            fnme="/home/mojojojo/Adapter-IDEProjects"+tfpath;
            String filename=""+pa[l-1];
                plist.add(fnme);
                nlist.add(filename);
                open op=new open();
                String s=op.get(fnme+"/"+filename);
                RSyntaxTextArea syn=new RSyntaxTextArea();
                if(filename.endsWith(".c"))
                syn.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_C);
                else if(filename.endsWith(".cpp"))
                 syn.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS);
                else
                    syn.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
                JTextArea jt=syn;
                jt.setText(s);
                jt.addCaretListener(new javax.swing.event.CaretListener() {
                public void caretUpdate(javax.swing.event.CaretEvent evt) {
                textAreaCaretUpdate(evt);
                }
                });
                jt.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                textAreaKeyTyped(evt);
                 }
                });
                JScrollPane js=new JScrollPane();
                js.getViewport().add(jt);
                pane.add(""+filename,js);
                pane.setSelectedIndex(plist.size()-1);
                               
        }
        
       }catch(Exception e)
       {
           System.out.println(e);
       }
    }
    
    void textAreaCaretUpdate(javax.swing.event.CaretEvent evt)
    {
        JScrollPane js=(JScrollPane)pane.getSelectedComponent();
            JTextArea jt=(JTextArea)js.getViewport().getView();
       
            int n=jt.getCaretPosition();
        String s=jt.getText();
        int x=0, y=0;
        for(int i=0;i<n;i++)
        { 
            char c=s.charAt(i);
            x=x+1;
            if(c=='\n')
            {
                x=0;
                y++;
            }
        }
        posLabel.setText(x+" , "+y);
    }
    
    void textAreaKeyTyped(java.awt.event.KeyEvent evt)
    {
       /* JScrollPane js=(JScrollPane)pane.getSelectedComponent();
        JTextArea jt=(JTextArea)js.getViewport().getView();
        if(jt.getText().equals(""));
            indflag=0;
        char c=evt.getKeyChar();
        int asc=(int)c;
        System.out.print(asc+" ");
        String add="           ";
        String s="     ",s2="  ";
        if(asc==op)
          ++count;
        if(asc==cl)
          --count;
        if(asc==10 && prev!=62)
        {
             String toAdd=add;
             for(int i=0;i<count;i++)
                 toAdd=toAdd+s;
             if(prev==41)
                 toAdd+=s2;
             if(prev==41&&indflag==0)
             {
                 toAdd=s2;
                 indflag=1;
             }
             
             jt.setT;
        }
        prev=asc;
        System.out.println("Here "+count);*/
            
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        pane = new javax.swing.JTabbedPane();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtEntrada = new javax.swing.JTextArea();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        projectPane = new javax.swing.JScrollPane();
        pathlbl = new javax.swing.JLabel();
        coProjects = new javax.swing.JButton();
        coStatus = new javax.swing.JButton();
        posLabel = new javax.swing.JLabel();
        geeksPane = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaSimbolos = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        cond = new javax.swing.JTextPane();
        jPanel11 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        copyIcon = new javax.swing.JButton();
        newProjectIcon = new javax.swing.JButton();
        openFile = new javax.swing.JButton();
        cutIcon = new javax.swing.JButton();
        pasteIcon = new javax.swing.JButton();
        saveIcon = new javax.swing.JButton();
        newFileInOIcon = new javax.swing.JButton();
        newFileIcon = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        run = new javax.swing.JButton();
        temaa = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        goGeeks = new javax.swing.JButton();
        deleteBut = new javax.swing.JButton();
        jcloseTab = new javax.swing.JButton();
        jMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newProjectMenu = new javax.swing.JMenuItem();
        newFileMenu = new javax.swing.JMenuItem();
        saveMenu = new javax.swing.JMenuItem();
        newFileInOMenu = new javax.swing.JMenuItem();
        openFileMenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        cutMenu = new javax.swing.JMenuItem();
        copyMenu = new javax.swing.JMenuItem();
        pasteMenu = new javax.swing.JMenuItem();
        fullMenu = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        runMenu = new javax.swing.JMenuItem();

        jMenu4.setText("jMenu4");

        jMenu5.setText("jMenu5");

        jMenu6.setText("jMenu6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Adapter-IDE");
        setBackground(new java.awt.Color(15, 15, 15));
        setBounds(new java.awt.Rectangle(0, 0, 1875, 964));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(1875, 964));
        getContentPane().setLayout(null);

        pane.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                paneStateChanged(evt);
            }
        });

        txtEntrada.setColumns(20);
        txtEntrada.setFont(new java.awt.Font("MingLiU-ExtB", 0, 14)); // NOI18N
        txtEntrada.setRows(5);
        jScrollPane7.setViewportView(txtEntrada);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1166, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );

        pane.addTab("tab2", jPanel14);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setEnabled(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1086, 400));

        jLabel4.setFont(new java.awt.Font("Nimbus Mono L", 0, 36)); // NOI18N
        jLabel4.setText("Smarter Way To Code");

        jLabel5.setFont(new java.awt.Font("Nimbus Mono L", 0, 24)); // NOI18N
        jLabel5.setText("Shortcut");

        jLabel6.setText("New Project                     Ctrl+Shift+N");

        jLabel7.setFont(new java.awt.Font("Nimbus Mono L", 0, 36)); // NOI18N
        jLabel7.setText("Calidad en tus manos!");

        jLabel8.setFont(new java.awt.Font("Nimbus Mono L", 0, 36)); // NOI18N
        jLabel8.setText("Alt+B");

        jLabel9.setFont(new java.awt.Font("Nimbus Mono L", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(43, 200, 43));
        jLabel9.setText("SoluTech Compiler");

        jLabel11.setText("New File                             Ctrl+N");

        jLabel12.setText("Save                                   Ctrl+S");

        jLabel13.setText("Open File                           Ctrl+O");

        jLabel14.setText("Cut                                      Ctrl+X");

        jLabel15.setText("Copy                                    Ctrl+C");

        jLabel16.setText("Paste                                  Ctrl+V    ");

        jLabel17.setText("Full Screen                        Ctrl+Shift+Enter");

        jLabel18.setText("Run                                     Shift+F6");

        jLabel19.setText("Close Tab                          Alt+X");

        jLabel20.setText("Delete                               Alt+D");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(108, 108, 108))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(139, 139, 139))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(227, 227, 227)))
                        .addGap(128, 128, 128))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel18))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(191, 191, 191)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pane.addTab("WELCOME", jPanel1);

        getContentPane().add(pane);
        pane.setBounds(190, 60, 1170, 370);

        projectPane.setForeground(new java.awt.Color(0, 0, 255));
        projectPane.setViewportBorder(javax.swing.BorderFactory.createTitledBorder("Projects"));
        projectPane.setMinimumSize(new java.awt.Dimension(2, 2));
        projectPane.setPreferredSize(new java.awt.Dimension(0, 0));
        getContentPane().add(projectPane);
        projectPane.setBounds(0, 60, 190, 650);

        pathlbl.setBackground(new java.awt.Color(199, 195, 195));
        getContentPane().add(pathlbl);
        pathlbl.setBounds(90, 950, 486, 24);

        coProjects.setText(".");
        coProjects.setToolTipText("Close/Open Project Window");
        coProjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coProjectsActionPerformed(evt);
            }
        });
        getContentPane().add(coProjects);
        coProjects.setBounds(20, 830, 31, 23);

        coStatus.setText(".");
        coStatus.setToolTipText("Close/Open Status");
        coStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coStatusActionPerformed(evt);
            }
        });
        getContentPane().add(coStatus);
        coStatus.setBounds(1550, 950, 31, 23);

        posLabel.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        posLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(posLabel);
        posLabel.setBounds(1640, 950, 127, 24);

        geeksPane.setBackground(new java.awt.Color(252, 113, 113));
        getContentPane().add(geeksPane);
        geeksPane.setBounds(1850, 60, 0, 922);
        getContentPane().add(jTabbedPane1);
        jTabbedPane1.setBounds(190, 530, 0, 1);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1135, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Analisis Lexico", jPanel5);

        txtResultado.setEditable(false);
        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane4.setViewportView(txtResultado);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1135, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Analisis Sintactico", jPanel6);

        tablaSimbolos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablaSimbolos);

        jTabbedPane2.addTab("Tabla de simbolos", jScrollPane3);

        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane8.setViewportView(jList3);

        jTabbedPane2.addTab("Analisis Semantico", jScrollPane8);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(200, 470, 1150, 230);

        cond.setEditable(false);
        cond.setVisible(true);
        cond.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "STATUS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14))); // NOI18N
        cond.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        cond.setEnabled(false);
        cond.setFocusable(false);
        jScrollPane2.setViewportView(cond);
        cond.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(190, 440, 1170, 270);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo3.jpg"))); // NOI18N
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel10)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
        );

        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        copyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/copiar-texto.png"))); // NOI18N
        copyIcon.setToolTipText("Copy (Ctrl+c)");
        copyIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        copyIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyIconActionPerformed(evt);
            }
        });

        newProjectIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nuevo-proyecto.png"))); // NOI18N
        newProjectIcon.setToolTipText("New Project(Ctrl+Shit+N)");
        newProjectIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newProjectIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProjectIconActionPerformed(evt);
            }
        });

        openFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/abrir-doc.png"))); // NOI18N
        openFile.setToolTipText("Open File(Ctrl+O)");
        openFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });

        cutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cortar-texto.png"))); // NOI18N
        cutIcon.setToolTipText("Cut(Ctrl+X)");
        cutIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cutIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutIconActionPerformed(evt);
            }
        });

        pasteIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pegar-texto.png"))); // NOI18N
        pasteIcon.setToolTipText("Paste(Ctrl+V)");
        pasteIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pasteIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteIconActionPerformed(evt);
            }
        });

        saveIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/guardar-el-archivo.png"))); // NOI18N
        saveIcon.setToolTipText("Save(Ctrl+S)");
        saveIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveIconActionPerformed(evt);
            }
        });

        newFileInOIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nuevo-archivo.png"))); // NOI18N
        newFileInOIcon.setToolTipText("New File in Other Project(Shit+N)");
        newFileInOIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newFileInOIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileInOIconActionPerformed(evt);
            }
        });

        newFileIcon.setForeground(new java.awt.Color(255, 255, 102));
        newFileIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nuevo-archivo-en carpeta.png"))); // NOI18N
        newFileIcon.setToolTipText("New File (Ctrl+N)");
        newFileIcon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        newFileIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileIconActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(newFileIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newFileInOIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newProjectIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(openFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cutIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(copyIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pasteIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveIcon)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newFileIcon)
                    .addComponent(newFileInOIcon)
                    .addComponent(newProjectIcon)
                    .addComponent(openFile)
                    .addComponent(cutIcon)
                    .addComponent(copyIcon)
                    .addComponent(pasteIcon)
                    .addComponent(saveIcon))
                .addGap(5, 5, 5))
        );

        run.setForeground(new java.awt.Color(51, 255, 0));
        run.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/frun.png"))); // NOI18N
        run.setToolTipText("Run(Ctrl+F6)");
        run.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runActionPerformed(evt);
            }
        });

        temaa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/luna.png"))); // NOI18N
        temaa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                temaaActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/config.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(run, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(temaa)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(run, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1)
                        .addComponent(temaa)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        goGeeks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/informacion.png"))); // NOI18N
        goGeeks.setMnemonic('B');
        goGeeks.setToolTipText("");
        goGeeks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goGeeksActionPerformed(evt);
            }
        });

        deleteBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/eliminar.png"))); // NOI18N
        deleteBut.setMnemonic('D');
        deleteBut.setToolTipText("");
        deleteBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButActionPerformed(evt);
            }
        });

        jcloseTab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cerrar.png"))); // NOI18N
        jcloseTab.setMnemonic('X');
        jcloseTab.setToolTipText("");
        jcloseTab.setBorderPainted(false);
        jcloseTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcloseTabActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jcloseTab)
                .addGap(18, 18, 18)
                .addComponent(deleteBut)
                .addGap(18, 18, 18)
                .addComponent(goGeeks)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcloseTab, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deleteBut, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(goGeeks, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel11);
        jPanel11.setBounds(0, 0, 1360, 60);

        jMenu.setMinimumSize(new java.awt.Dimension(2, 0));
        jMenu.setPreferredSize(new java.awt.Dimension(87, 0));

        jMenu1.setMnemonic('f');
        jMenu1.setText("File");

        newProjectMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        newProjectMenu.setText("New Project...");
        newProjectMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newProjectMenuMouseClicked(evt);
            }
        });
        newProjectMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProjectMenuActionPerformed(evt);
            }
        });
        jMenu1.add(newProjectMenu);

        newFileMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        newFileMenu.setText("New File...");
        newFileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileMenuActionPerformed(evt);
            }
        });
        jMenu1.add(newFileMenu);

        saveMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveMenu.setText("Save...");
        saveMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuActionPerformed(evt);
            }
        });
        jMenu1.add(saveMenu);

        newFileInOMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        newFileInOMenu.setText("New File in Other Project..");
        newFileInOMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileInOMenuActionPerformed(evt);
            }
        });
        jMenu1.add(newFileInOMenu);

        openFileMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openFileMenu.setText("Open File");
        openFileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileMenuActionPerformed(evt);
            }
        });
        jMenu1.add(openFileMenu);

        jMenu.add(jMenu1);

        jMenu2.setText("Edit");

        cutMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        cutMenu.setText("Cut");
        cutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuActionPerformed(evt);
            }
        });
        jMenu2.add(cutMenu);

        copyMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        copyMenu.setText("Copy");
        copyMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyMenuActionPerformed(evt);
            }
        });
        jMenu2.add(copyMenu);

        pasteMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        pasteMenu.setText("Paste");
        pasteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteMenuActionPerformed(evt);
            }
        });
        jMenu2.add(pasteMenu);

        fullMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        fullMenu.setText("Full Screen");
        fullMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullMenuActionPerformed(evt);
            }
        });
        jMenu2.add(fullMenu);

        jMenu.add(jMenu2);

        jMenu3.setText("Run");

        runMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        runMenu.setText("Run");
        runMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runMenuActionPerformed(evt);
            }
        });
        jMenu3.add(runMenu);

        jMenu.add(jMenu3);

        setJMenuBar(jMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newProjectMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newProjectMenuMouseClicked

        
    }//GEN-LAST:event_newProjectMenuMouseClicked

    private void newFileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileMenuActionPerformed
        JScrollPane js;
        JTextArea jt=new JTextArea();
        RSyntaxTextArea syn=new RSyntaxTextArea();
        if(fpath==null)
        {
            JFileChooser jf=new JFileChooser();
            jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            jf.showDialog(this,"Select Folder");
            File file=jf.getSelectedFile();
            if(file!=null)
            {
                fpath=file.getAbsolutePath();
            }
        }
        String fname=JOptionPane.showInputDialog("Enter file name with extension .java)");
      String[] comm=null;
        if(fpath!=null&& fname!=null)
        {
            boolean b=false;
            int t=0;
            if(fname.endsWith(".c"))
                t=1;
            else if(fname.endsWith(".cpp"))
                t=2;
            else if(fname.endsWith(".java"))
                t=3;
            
            if(t==1)
            {
                comm=new String[]{"/bin/sh","-c","printf \'#include<stdio.h>\n\nint main()\n{\n    printf(\"Hello World!\");\n    return 0;\n}\'> "+fname};
                syn.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_C);
            }
            if(t==2)
            {
                comm=new String[]{"/bin/sh","-c","printf \'#include<iostream>\n#include<bits/stdc++.h>\n\nusing namespace std;\n\nint main()\n{\n    printf(\"Hello World!\");\n    return 0;\n}\'> "+fname};
                syn.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS);
            }
            if(t==3)
            {
                int l=fname.length();
                String g=fname.substring(0,l-5);
                comm=new String[]{"/bin/sh","-c","printf \'public class "+g+"\n{\n "
                        + "     public static void main(String args[])\n    {\n       System.out.print(\"Hello java\");"
                        + "\n    }\n}  \'> "+fname};
                syn.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
                Script s=new Script();
                    s.scr(g,fpath);
                
            }
            if(t!=0)
            {
            ProcessBuilder pb=new ProcessBuilder(comm);
              pb.directory(new File(fpath));
              try{
              Process p=pb.start();
              while(p.isAlive());
              }
              catch(Exception e)
              {
                   System.out.println(e);
              }
            }
            if(t!=0)
            {
                plist.add(fpath);
                nlist.add(fname);
                open op=new open();
                String s=op.get(fpath+"/"+fname);
                jt=syn;
                jt.setText(s);
                jt.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                textAreaCaretUpdate(evt);
            }
        });     
                jt.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                textAreaKeyTyped(evt);
                 }
                });
                js=new JScrollPane(jt);
                pane.add(""+fname,js);
                pane.setSelectedIndex(plist.size()-1);
            }
        }
        ttree();
    }//GEN-LAST:event_newFileMenuActionPerformed

    @SuppressWarnings("empty-statement")
    private void newProjectMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProjectMenuActionPerformed
        JFileChooser jf=new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jf.showDialog(this,"Select Folder");
        File file=jf.getSelectedFile();
        if(file!=null)
        {
        String fullp=file.getAbsolutePath();
        String name=JOptionPane.showInputDialog(null,"Project Name");
        fpath=fullp+"/"+name;
        if(name!=null)
           {
              ProcessBuilder pb1=new ProcessBuilder("/bin/sh","-c","mkdir "+name);
              ProcessBuilder pb2=new ProcessBuilder("/bin/sh","-c","mkdir Resource");
              ProcessBuilder pb5=new ProcessBuilder("/bin/sh","-c","touch state");
              
              pb1.directory(new File(fullp));
              pb2.directory(new File(fullp+"/"+name));
              pb5.directory(new File(fullp+"/"+name+"/Resource"));
              
              Process p1,p2,p3,p4,p5;
              try{
                    p1=pb1.start();
                    while(p1.isAlive());
                    p2=pb2.start();
                    while(p2.isAlive());
                    p5=pb5.start();
                    Script s=new Script();
                    s.scr("ZEH",fullp+"/"+name);
              
              }
              catch(Exception e)
                      {
                          System.out.println(e);
                      }
           }
        }
        ttree();
    }//GEN-LAST:event_newProjectMenuActionPerformed

    private void jcloseTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcloseTabActionPerformed
        
        int index=pane.getSelectedIndex();
        if(index!=0)
        {
            pane.remove(index);
            plist.remove(index);
            nlist.remove(index);
        }
        else
            JOptionPane.showMessageDialog(rootPane, "Can not close this");
    }//GEN-LAST:event_jcloseTabActionPerformed

    private void runMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runMenuActionPerformed
       

        if(flagStat==0)
        {
            this.coStatusActionPerformed(evt);
        }
        long startTime=(long) 0.0,stopTime=(long) 0.0;
        if(pane.getSelectedIndex()==0)
            return;
       
           // home g=new home();
           int flag=1;
           String cm1[]=null;
           String cm2[]=null;
           
            this.saveMenuActionPerformed(evt);
           
            String path=plist.get(pane.getSelectedIndex());
            String name=nlist.get(pane.getSelectedIndex());
            int t=0;
            if(name.endsWith(".c"))
                t=1;
            else if(name.endsWith(".cpp"))
                t=2;
            else if(name.endsWith(".java"))
                t=3;
            
            if(t==1)
            {
                cm1=new String[]{"/bin/sh","-c","gcc "+name+" 2> "+path+"/Resource/state"};
                cm2=new String[]{"/bin/sh","-c","./ZEH.sh"};
            }
            if(t==2)
            {
                cm1=new String[]{"/bin/sh","-c","g++ "+name+" 2> "+path+"/Resource/state"};
                cm2=new String[]{"/bin/sh","-c","./ZEH.sh"};
            }
            if(t==3)
            {
                int l=name.length();
                String g=name.substring(0,l-5);
                cm1=new String[]{"/bin/sh","-c","javac "+name+" 2> "+path+"/Resource/state"};
                cm2=new String[]{"/bin/sh","-c","./"+g+".sh"};
            }
            ProcessBuilder pb1=new ProcessBuilder(cm1);
            ProcessBuilder pb2=new ProcessBuilder(cm2);
            
            pb1.directory(new File(path));
            pb2.directory(new File(path+"/Resource"));
            
            try{
                 startTime=System.nanoTime();
            Process p=pb1.start();
                 stopTime=System.nanoTime();
            while(p.isAlive());
            }
            catch(Exception e)
            {
                
            }
            
            try{
                String curr=null,s=null;
            FileReader fr=new FileReader(path+"/Resource/state");
            BufferedReader br=new BufferedReader(fr);
            if(br.readLine()==null)
                cond.setText("Successfull Execution :-)\nCompilation Time : " +(((double)(stopTime-startTime))/1000000000.0));
            else
            {  
                flag=0;
                s="";
                while((curr=br.readLine())!=null)
               {
                s=s+curr;
                s=s+"\n";
               }
              cond.setText(s);
            }
            }
            catch(Exception e)
            {
            }
            if(flag==1)
            {
            try {
                Process pb=pb2.start();
            } catch (IOException ex) {
                Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
       
    }//GEN-LAST:event_runMenuActionPerformed

    private void saveMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuActionPerformed
        Save sv=new Save();
        int ind=pane.getSelectedIndex();
        if(ind>0)
        {
            JScrollPane js=(JScrollPane)pane.getSelectedComponent();
            int n=sv.save(js,plist.get(ind),nlist.get(ind));
        }
    }//GEN-LAST:event_saveMenuActionPerformed

    private void cutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuActionPerformed
        //cut
        int ind=pane.getSelectedIndex();
        if(ind>0)
        {
            JScrollPane js=(JScrollPane)pane.getSelectedComponent();
            JTextArea jt=(JTextArea)js.getViewport().getView();
            jt.cut();
        }
        
    }//GEN-LAST:event_cutMenuActionPerformed

    private void copyMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyMenuActionPerformed
        // copy
        int ind=pane.getSelectedIndex();
        if(ind>0)
        {
            JScrollPane js=(JScrollPane)pane.getSelectedComponent();
            JTextArea jt=(JTextArea)js.getViewport().getView();
            jt.copy();
        }
    }//GEN-LAST:event_copyMenuActionPerformed

    private void pasteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteMenuActionPerformed
        // paste
        int ind=pane.getSelectedIndex();
        if(ind>0)
        {
            JScrollPane js=(JScrollPane)pane.getSelectedComponent();
            JTextArea jt=(JTextArea)js.getViewport().getView();
            jt.paste();
        }
    }//GEN-LAST:event_pasteMenuActionPerformed

    private void newFileInOMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileInOMenuActionPerformed
        // TODO add your handling code here:
        fpath=null;
        this.newFileMenuActionPerformed(evt);
    }//GEN-LAST:event_newFileInOMenuActionPerformed

    private void deleteButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButActionPerformed
        int index=pane.getSelectedIndex();
        if(index!=0)
        {
            
            pane.remove(index);
            String p=plist.get(index);
 
            plist.remove(index);
            String n=nlist.get(index);
            String g=n;
            nlist.remove(index);
            if(n.endsWith(".java"))
            {
                int l=n.length();
                g=n.substring(0,l-5);
            }
            ProcessBuilder pb1=new ProcessBuilder("/bin/sh","-c","rm "+n);
            ProcessBuilder pb2=new ProcessBuilder("/bin/sh","-c","rm "+g+".sh");
            pb1.directory(new File(p));
            pb2.directory(new File(p+"/"+"Resource"));
            try{
                Process p1=pb1.start();
                while(p1.isAlive());
                Process p2;
                if(n.endsWith(".java"))
                {
                    p2=pb2.start();
                    while(p2.isAlive());
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            ttree();
        }
        else
            JOptionPane.showMessageDialog(rootPane, "Can not delete this");
        
    }//GEN-LAST:event_deleteButActionPerformed

    private void openFileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileMenuActionPerformed
        // TODO add your handling code here:
        String filename=null,fpath=null;
        JFileChooser jf=new JFileChooser();
            jf.showDialog(this,"Select Desired File");
            File file=jf.getSelectedFile();
            if(file!=null)
            {
                filename=file.getName();
                fpath=file.getParent();
                plist.add(fpath);
                nlist.add(filename);
                open op=new open();
                String s=op.get(fpath+"/"+filename);
                RSyntaxTextArea syn=new RSyntaxTextArea();
                if(filename.endsWith(".c"))
                syn.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_C);
                else if(filename.endsWith(".cpp"))
                 syn.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_CPLUSPLUS);
                else
                    syn.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
                RSyntaxTextArea jt=syn;
                jt.setText(s);
                jt.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                textAreaCaretUpdate(evt);
            }
        });
                jt.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyTyped(java.awt.event.KeyEvent evt) {
                textAreaKeyTyped(evt);
                 }
                });
                JScrollPane js=new JScrollPane(jt);
                pane.add(""+filename,js);
                pane.setSelectedIndex(plist.size()-1);
            }
    }//GEN-LAST:event_openFileMenuActionPerformed

    private void changeEnabled(){
        newFileIcon.setEnabled(a);
        newFileInOIcon.setEnabled(b);
        newProjectIcon.setEnabled(c);
        openFile.setEnabled(d);
        cutIcon.setEnabled(e);
        copyIcon.setEnabled(f);
        pasteIcon.setEnabled(g);
        saveIcon.setEnabled(h);
        run.setEnabled(i);
    }
    
    private void newFileIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileIconActionPerformed
        // TODO add your handling code here:
      
        this.newFileMenuActionPerformed(evt);
    }//GEN-LAST:event_newFileIconActionPerformed

    private void newFileInOIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileInOIconActionPerformed
        // TODO add your handling code here:
        this.newFileInOMenuActionPerformed(evt);
                a=true;

            changeEnabled();
    }//GEN-LAST:event_newFileInOIconActionPerformed

    private void newProjectIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProjectIconActionPerformed
        // TODO add your handling code here:
        this.newProjectMenuActionPerformed(evt);
        a=true;
        changeEnabled();
    }//GEN-LAST:event_newProjectIconActionPerformed

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        // TODO add your handling code here:
        this.openFileMenuActionPerformed(evt);
    }//GEN-LAST:event_openFileActionPerformed

    private void cutIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutIconActionPerformed
        // TODO add your handling code here:
        this.cutMenuActionPerformed(evt);
    }//GEN-LAST:event_cutIconActionPerformed

    private void copyIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyIconActionPerformed
        // TODO add your handling code here:\
        this.copyMenuActionPerformed(evt);
    }//GEN-LAST:event_copyIconActionPerformed

    private void pasteIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteIconActionPerformed
        // TODO add your handling code here:
        this.pasteMenuActionPerformed(evt);
    }//GEN-LAST:event_pasteIconActionPerformed

    private void saveIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveIconActionPerformed
        // TODO add your handling code here:
        this.saveMenuActionPerformed(evt);
        textoGuardado = syntaxArea.getText();
        actualizarEstadoBoton();
    }//GEN-LAST:event_saveIconActionPerformed

    private void runActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runActionPerformed
        // TODO add your handling code here:
        //fullFlag=1;
        textoGuardado = syntaxArea.getText();
        actualizarEstadoBoton();
            if(fullFlag ==0){
                fullMenuActionPerformed(evt);
                jPanel4.repaint();
            }
           

                // TODO add your handling code here:
                File archivo = new File("archivo.txt");
                PrintWriter escribir;
                try {
                    escribir = new PrintWriter(archivo);
                    escribir.print(syntaxArea.getText());
                    escribir.close();
                } catch (FileNotFoundException ex) {
                    //Logger.getLogger(formulario.class.getName()).log(Level.SEVERE, null, ex);
                }

               try {
            Reader lector = new BufferedReader(new FileReader("archivo.txt"));
            Lexer lexer = new Lexer(lector);
            modeloLista.clear(); // Limpiar antes de agregar

            while (true) {
                Tokens tokens = lexer.nextToken();
                if (tokens == null) {
                    modeloLista.addElement("FIN");
                    break;
                }

                switch (tokens) {
                    case ERROR:
                        modeloLista.addElement(lexer.yytext() + ": Es un " + tokens);
                        break;
                    default:
                        modeloLista.addElement(lexer.yytext() + ": Es un " + tokens);
                        break;
                }
                
            }
            analizarSintaxis();
        }catch (FileNotFoundException ex) {
            //Logger.getLogger(formulario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            //Logger.getLogger(formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.runMenuActionPerformed(evt);
    }//GEN-LAST:event_runActionPerformed

    
    void analizarSintaxis(){
        // TODO add your handling code here:
        // TODO add your handling code here:
        String ST = syntaxArea.getText();
        Sintax s = new Sintax(new compi.LexerCup(new StringReader(ST)));
        
        try {
            System.out.println("JAAAAAAA");
            s.parse();
            mostrarTablaSimbolos(s.tabla);  // Acceder a la tabla
            List<String> erroresSemanticos = s.semantico.getErrores();
            modeloLista2 = new DefaultListModel<>();
            // Agregar los errores al modelo

                        // Limpiar el JTextArea antes de mostrar nuevos errores
                        //txtAnalizarSin1.setText("");
                        // Verificar si hay errores y mostrarlos en el JTextArea
                if (!erroresSemanticos.isEmpty()) {
                    for (String error : erroresSemanticos) {
                        modeloLista2.addElement(error); // Agregar cada error al modelo

                    }
                    
                }else {
                    modeloLista2.addElement("Análisis semántico completado sin errores."); // Agregar cada error al modelo
                } 
                jList3.setModel(modeloLista2);
                
                
            txtResultado.setText("Analisis realizado correctamente");
            txtResultado.setForeground(new Color(25, 111, 61));
            System.out.println("JAAAAAAA");
        } catch (Exception ex) {
            Symbol sym = s.getS();
            txtResultado.setText("Error "+ s.getS() +"de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            txtResultado.setForeground(Color.red);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void coStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coStatusActionPerformed
        // TODO add your handling code here:
        System.out.println("hello");
        if(flagStat==1)
        {
            statSizeX=jScrollPane2.getWidth();
            statSizeY=jScrollPane2.getHeight();
            jScrollPane2.setBounds(jScrollPane2.getX(),jScrollPane2.getY()+statSizeY,jScrollPane2.getWidth(),0);
                    cond.setBounds(jScrollPane2.getX(),jScrollPane2.getY()+statSizeY,jScrollPane2.getWidth(),0);
            pane.setBounds(pane.getX(),pane.getY(),pane.getWidth(),pane.getHeight()+statSizeY);
            flagStat=0;
        }
        else
        {    
                pane.setBounds(pane.getX(),pane.getY(),pane.getWidth(),pane.getHeight()-statSizeY);
                jScrollPane2.setBounds(jScrollPane2.getX(),jScrollPane2.getY()-statSizeY,pane.getWidth(),statSizeY);
                        cond.setBounds(jScrollPane2.getX(),jScrollPane2.getY()-statSizeY,pane.getWidth(),statSizeY);
                flagStat=1;     
        }
    }//GEN-LAST:event_coStatusActionPerformed

    private void fullMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullMenuActionPerformed
        // TODO add your handling code here:
        if(fullFlag==1)
        {
            flagStat=1;
            flagProj=1;
            this.coProjectsActionPerformed(evt);
            this.coStatusActionPerformed(evt);
            fullFlag=0;
        }
        else
        {
            flagStat=0;
            flagProj=0;
            this.coProjectsActionPerformed(evt);
            this.coStatusActionPerformed(evt);
            fullFlag=1;
        }
    }//GEN-LAST:event_fullMenuActionPerformed

    private void abrirPaginaWeb() {
    try {
        String url = "file:///C:/Users/joset/OneDrive/Desktop/Ejemplos/index.html";
        Desktop desktop = Desktop.getDesktop();
        desktop.browse(new URI(url));
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al abrir el navegador: " + e.getMessage());
    }
}
    
    private void goGeeksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goGeeksActionPerformed

        abrirPaginaWeb();
         
    }//GEN-LAST:event_goGeeksActionPerformed

    private void coProjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coProjectsActionPerformed
        // TODO add your handling code here:
        if(flagProj==1)
        {
            projSizeX=projectPane.getWidth();
            projSizeY=projectPane.getHeight();
            projectPane.setBounds(projectPane.getX(),projectPane.getY(),1,projSizeY);
            pane.setBounds(projectPane.getX()+4, pane.getY(), (pane.getWidth()+projSizeX),pane.getHeight());
            jScrollPane2.setBounds(projectPane.getX()+4,jScrollPane2.getY(),(jScrollPane2.getWidth()+projSizeX),jScrollPane2.getHeight());
            cond.setBounds(projectPane.getX()+4,jScrollPane2.getY(),(jScrollPane2.getWidth()+projSizeX),jScrollPane2.getHeight());
            flagProj=0;
        }
        else
        {
            projectPane.setBounds(projectPane.getX(),projectPane.getY(),projSizeX,projSizeY);
            pane.setBounds(projSizeX, pane.getY(), (pane.getWidth()-projSizeX),pane.getHeight());
            jScrollPane2.setBounds(projSizeX,jScrollPane2.getY(),(jScrollPane2.getWidth()-projSizeX),jScrollPane2.getHeight());
            cond.setBounds(projSizeX,jScrollPane2.getY(),(jScrollPane2.getWidth()-projSizeX),jScrollPane2.getHeight());
            flagProj=1;
        }
    }//GEN-LAST:event_coProjectsActionPerformed

    private void temaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_temaaActionPerformed
        // TODO add your handling code here:
       
        temaa.setIcon(new ImageIcon("C:\\Users\\joset\\OneDrive\\Desktop\\Adapter_IDE\\src\\icon\\cortar-texto.png"));
        System.out.println("LLEHEEE");
        themeDark = !themeDark;
        if(themeDark){
            aplicarColores(this.getContentPane(),new Color(15,15,15),Color.WHITE);   
        }else{
            aplicarColores(this.getContentPane(),new Color(247,247,247),Color.BLACK);   

        }
                jLabel9.setForeground(Color.blue);

        //jButton1.repaint();
    }//GEN-LAST:event_temaaActionPerformed

    private void paneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_paneStateChanged
        // TODO add your handling code here:
        posLabel.setText("");
        int i=pane.getSelectedIndex();
        if(i>0)
        {

            posLabel.setText("0 , 0");
            pathlbl.setText("Path of file= "+plist.get(i));
            JScrollPane jt=(JScrollPane) pane.getSelectedComponent();
            JTextArea j=(JTextArea) jt.getViewport().getView();
            Font f=new Font(face,Font.PLAIN,fsize);
            j.setFont(f);
            j.setComponentPopupMenu(jp);
            unDoreDo(j);
        }
        if(i==0)
        pathlbl.setText("");
    }//GEN-LAST:event_paneStateChanged

        private void JAJAJJAJ() {        
            RSyntaxTextArea TE = new RSyntaxTextArea(20,60);
        }
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                // TODO add your handling code here:
                ConfiguracionEditor conf = new ConfiguracionEditor(syntaxArea);
                conf.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton coProjects;
    private javax.swing.JButton coStatus;
    private javax.swing.JTextPane cond;
    private javax.swing.JButton copyIcon;
    private javax.swing.JMenuItem copyMenu;
    private javax.swing.JButton cutIcon;
    private javax.swing.JMenuItem cutMenu;
    private javax.swing.JButton deleteBut;
    private javax.swing.JMenuItem fullMenu;
    private javax.swing.JScrollPane geeksPane;
    private javax.swing.JButton goGeeks;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList3;
    private javax.swing.JMenuBar jMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton jcloseTab;
    private javax.swing.JButton newFileIcon;
    private javax.swing.JButton newFileInOIcon;
    private javax.swing.JMenuItem newFileInOMenu;
    private javax.swing.JMenuItem newFileMenu;
    private javax.swing.JButton newProjectIcon;
    private javax.swing.JMenuItem newProjectMenu;
    private javax.swing.JButton openFile;
    private javax.swing.JMenuItem openFileMenu;
    private javax.swing.JTabbedPane pane;
    private javax.swing.JButton pasteIcon;
    private javax.swing.JMenuItem pasteMenu;
    private javax.swing.JLabel pathlbl;
    private javax.swing.JLabel posLabel;
    private javax.swing.JScrollPane projectPane;
    private javax.swing.JButton run;
    private javax.swing.JMenuItem runMenu;
    private javax.swing.JButton saveIcon;
    private javax.swing.JMenuItem saveMenu;
    private javax.swing.JTable tablaSimbolos;
    private javax.swing.JButton temaa;
    private javax.swing.JTextArea txtEntrada;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
