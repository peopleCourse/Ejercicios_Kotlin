import java.awt.BorderLayout
import java.awt.Font
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.SwingConstants
import javax.swing.SwingUtilities
import javax.swing.WindowConstants

//=========================
//EJERCICIO 02
//CONTADOR DE CLICKS
//=========================

//Importar librerias


//Clase Principal Hereda los compentes de ventana (JFrame)
class ContadorClicks : JFrame(){
//Crear la estructura de los clicks, tiene que ser privado solo puede usar la clase
    //variable donde guardaremos la cantidad de clicks
    private var contador = 0
    //colocar de un etiqueta donde se muestra el contador
    private val lblContador = JLabel(
        "Clicks: 0",
        SwingConstants.CENTER
    )
    private val btnClick = JButton("Haz Click aquí")


    //inicializador
    init {
        //titulo
        title = "Contador de Clicks"
      //tamaño ventana
      setSize(320, 200)
      //centrar en pantalla
      setLocationRelativeTo(null)
      //cerrar el programa
      defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        layout = BorderLayout()
        //estilos del texto del contador
        lblContador.Font = Font("Arial", Font.BOLD, 30)
        //estilo del boton del clic
        btnClick.font = Font("Arial", Font.BOLD, 15)
        // creamos un panel donde se va a colocar el boton
        val panelInferior = JPanel()
        panelInferior.add(btnClick)
        //Agregar los elementos a la ventana
        add(lblContador, BorderLayout.CENTER)
        add(panelInferior, BorderLayout.SOUTH)

        //cREAR ACCION DEL BOTON (Evento)
        btnClick.addActionListener {
            //incrementar el contador
            contador++
            //actualiza el texto Label

            lblContador.text = "Clicks: $contador"
        }


    }
}
fun main() {
//Llamada a todas las apliación Swing del programa que se deben inicializar
    SwingUtilities.invokeLater {
        //Preparar la Ventana
        val ventana = ContadorClicks()
        //la mostramos
        ventana.isVisible = true
    }

}