//=========================================================
// EJERCICIO 3 (MEJORADO)
// GENERADOR DE SALUDOS
//=========================================================

//---------------------------------------------------------
// Importamos las librerías necesarias
//---------------------------------------------------------
import java.awt.BorderLayout
import java.awt.Font
import java.awt.GridLayout
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.swing.*

//=========================================================
// Clase principal
//=========================================================
class GeneradorSaludos_2 : JFrame() {

    //-----------------------------------------------------
    // Caja de texto donde el usuario escribirá su nombre
    //-----------------------------------------------------
    private val txtNombre = JTextField(20)

    //-----------------------------------------------------
    // Botón para generar el saludo
    //-----------------------------------------------------
    private val btnSaludar = JButton("Saludar")

    //-----------------------------------------------------
    // Botón para limpiar la información
    //-----------------------------------------------------
    private val btnLimpiar = JButton("Limpiar")

    //-----------------------------------------------------
    // Etiqueta donde aparecerá el resultado
    //-----------------------------------------------------
    private val lblResultado = JLabel(
        "Escribe tu nombre",
        SwingConstants.CENTER
    )

    //-----------------------------------------------------
    // Constructor
    //-----------------------------------------------------
    init {

        //-------------------------------------------------
        // Configuración de la ventana
        //-------------------------------------------------
        title = "Generador de Saludos"

        setSize(520,320)

        setLocationRelativeTo(null)

        defaultCloseOperation = EXIT_ON_CLOSE

        layout = BorderLayout(10,10)

        //-------------------------------------------------
        // Configuración de fuentes
        //-------------------------------------------------
        txtNombre.font = Font("Arial", Font.PLAIN,18)

        btnSaludar.font = Font("Arial", Font.BOLD,16)

        btnLimpiar.font = Font("Arial", Font.BOLD,16)

        lblResultado.font = Font("Arial", Font.BOLD,16)

        //-------------------------------------------------
        // Panel superior
        //-------------------------------------------------
        val panelSuperior = JPanel(GridLayout(2,1,5,5))

        panelSuperior.add(JLabel("Escribe tu nombre:"))

        panelSuperior.add(txtNombre)

        //-------------------------------------------------
        // Panel inferior
        //-------------------------------------------------
        val panelInferior = JPanel()

        panelInferior.add(btnSaludar)

        panelInferior.add(btnLimpiar)

        //-------------------------------------------------
        // Agregamos los paneles
        //-------------------------------------------------
        add(panelSuperior, BorderLayout.NORTH)

        add(lblResultado, BorderLayout.CENTER)

        add(panelInferior, BorderLayout.SOUTH)

        //-------------------------------------------------
        // Evento del botón Saludar
        //-------------------------------------------------
        btnSaludar.addActionListener {

            mostrarSaludo()

        }

        //-------------------------------------------------
        // Permite saludar presionando ENTER
        //-------------------------------------------------
        txtNombre.addActionListener {

            mostrarSaludo()

        }

        //-------------------------------------------------
        // Botón Limpiar
        //-------------------------------------------------
        btnLimpiar.addActionListener {

            txtNombre.text = ""

            lblResultado.text = "Escribe tu nombre"

            txtNombre.requestFocus()

        }

    }

    //-----------------------------------------------------
    // Función que realiza el saludo
    //-----------------------------------------------------
    private fun mostrarSaludo(){

        //---------------------------------------------
        // Eliminamos espacios al inicio y al final
        //---------------------------------------------
        val nombre = txtNombre.text.trim()

        //---------------------------------------------
        // Validamos si está vacío
        //---------------------------------------------
        if(nombre.isBlank()){

            lblResultado.text =
                "Por favor, ingresa tu nombre"

            return
        }

        //---------------------------------------------
        // Validamos longitud máxima
        //---------------------------------------------
        if(nombre.length > 20){

            JOptionPane.showMessageDialog(

                this,

                "El nombre no puede tener más de 20 caracteres.",

                "Nombre demasiado largo",

                JOptionPane.WARNING_MESSAGE

            )

            return

        }

        //---------------------------------------------
        // Convertimos la primera letra a mayúscula
        //---------------------------------------------
        val nombreFormateado =
            nombre.replaceFirstChar {

                it.uppercase()

            }

        //---------------------------------------------
        // Obtener fecha y hora actual
        //---------------------------------------------
        val fechaHora = LocalDateTime.now()

        //---------------------------------------------
        // Formato de la fecha
        //---------------------------------------------
        val formato = DateTimeFormatter.ofPattern(
            "dd/MM/yyyy HH:mm:ss"
        )

        //---------------------------------------------
        // Convertir la fecha a texto
        //---------------------------------------------
        val fechaTexto =
            fechaHora.format(formato)

        //---------------------------------------------
        // Mostrar el saludo
        //---------------------------------------------
        lblResultado.text =
            "<html><center>" +
                    "¡Hola, <b>$nombreFormateado</b>!<br><br>" +
                    "Fecha y hora:<br>$fechaTexto" +
                    "</center></html>"

    }

}

//=========================================================
// Función principal
//=========================================================
fun main(){

    SwingUtilities.invokeLater{

        GeneradorSaludos_2().isVisible = true

    }

}