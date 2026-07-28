//======================================
//Ejercicio 001
//Ventana emergente saludo
//======================================

//--
//Importaciones necesarias (librerias)
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.SwingConstants
import javax.swing.SwingUtilities

//---
//Clase Principal
//Hereda componentes  la libreria JFrame
//------
class SaludoPeople : JFrame (){
    // iniciador ejecuta antes de crear  la ventana. toda la interfaz previa
    init {
        //Titulo de la ventana que aparece en la parte superior
        title = "Saludo mañanero del Lunes"
        //Tamaño de la ventana. medidas son pixel ancho, alto
        setSize(300, 200)
        //Centrar la ventana en la pantalla
        setLocationRelativeTo(null)
        // Cuando se cierre la ventana termina le programa
        defaultCloseOperation = EXIT_ON_CLOSE
        //Crear el mensaje central con una variable que hereda otra libreria JLabel
        val mensaje = JLabel(
            "¡Buenos día , People!",
            SwingConstants.CENTER
        )
        //acepte que el Jlabel lo coloque en el centro de la ventana
        add(mensaje)
    }

}

//Funcion principal
fun main() {
    //Swing siempre debe iniciarse dentro del Event
    SwingUtilities.invokeLater {
        //Crea la ventana
        val ventana = SaludoPeople()
        //mostrarla
        ventana.isVisible = true
    }
}












