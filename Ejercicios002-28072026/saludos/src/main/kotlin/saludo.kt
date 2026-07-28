/**
 * GENERADOR DE SALUDOS
 *
 * */
/**
 * java.*: Contiene las clases esenciales que forman parte indiscutible del entorno de ejecución básico de Java desde sus inicios.
 * javax.*: Significaba "Java Extension". Agrupa tecnologías que crecieron con el tiempo, herramientas gráficas avanzadas (como javax.swing) y APIs de la plataforma
 * Evolución actual (jakarta.*): Debido a cambios de marcas y licencias tras pasar a manos de la Eclipse Foundation, las librerías empresariales de javax pasaron a llamarse jakarta.* a partir de la versión Jakarta EE 9
 * */
//IMPORTAR LIBRERIAS
import javax.swing.*
import java.awt.BorderLayout
import java.awt.Font
import java.awt.GridLayout

//Clase principal
class GeneradorSaludos : JFrame() {
    //El usuario escriba su nombre
    private val txtNombre = JTextField(20)

    //botn para generar un saludo
    private val btnSaludar = JButton("Saludar")

    //etiqueta donde aparezca el resultado
    private val lblResultado = JLabel(
        "Escribe tu nombre",
        SwingConstants.CENTER
    )


    //Constructor(inicializador)
    init {
        //configurar la ventana
        title = "Generar Saludos"
        setSize(420, 200)
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
        //utilizar BorderLayout --> margen
        layout = BorderLayout(10,10)
        //estilos tipografia
        lblResultado.font = Font("Arial", Font.BOLD,20)
        txtNombre.font = Font("Arial", Font.ITALIC,15)
        btnSaludar.font = Font("Arial", Font.BOLD,18)
        //panel superior
        val panelSuperior = JPanel(GridLayout(2, 1, 5, 5))
        panelSuperior.add(JLabel("Escribe tu nombre"))
        panelSuperior.add(txtNombre)
        //panel inferior
        val panelInferior= JPanel()
        panelInferior.add(btnSaludar)
        //organizar los paneles en frame
        add(panelSuperior, BorderLayout.NORTH)
        add(lblResultado, BorderLayout.CENTER)
        add(panelInferior, BorderLayout.SOUTH)

        //agregar accion al boton (EVENTO)
        btnSaludar.addActionListener {
            //acciones a realizar cuando hagamos click
            val nombre =txtNombre.text
            //verificar que el usuario escribio algo
            //usando una condicional - si le da click y no escribe le dice "escribe tu nombre", si lo escribe ENTONCES (ELSE) lo saluda
           if (nombre.isBlank()) {
               lblResultado.text = "Por favor ingresa tu nombre"
           } else{
               lblResultado.text = "Buenas, espero que estes bien, $nombre"
           }


        }

    }



}

//funcion principal
fun main() {
    SwingUtilities.invokeLater {
        val ventana = GeneradorSaludos()
        ventana.isVisible = true
    }
}



