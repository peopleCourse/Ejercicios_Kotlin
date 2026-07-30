/**
 * Ejercicio 2: Manejo de Eventos y Estado
 * Objetivo: Interactuar con el usuario mediante clics y actualizar la interfaz dinámicamente.
 * Conceptos: ActionListener
 * */
//librerias
import javax.swing.*
import java.awt.*

//Crear un contador
fun crearContador(){
    val frame = JFrame("Contador").apply {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(250, 150)
        setLocationRelativeTo(null)
        //layout = FlowLayout organizar automaticamente los componentes uno al lado del otro
        layout = FlowLayout(FlowLayout.CENTER, 20, 20)
    }

    val lblContador = JLabel ("0").apply{
        font = Font("Arial", Font.BOLD, 30)
    }

    val btnIncrementar = JButton("Sumar 1")

    var contador = 0 //estado inicial

    btnIncrementar.addActionListener{
        contador++

        //cada vez que se le acciones al boton btnIncrementar, el texto del lblContador cambiará
        //reflejando el nuevo estado. el numero que aparece en contador lo voy a transforma a TEXTO
        lblContador.text = contador.toString()

        //Cambiamos el color del fondo según el valor
        frame.contentPane.background = when {
            contador < 5 -> Color.GREEN
            contador < 10 -> Color.YELLOW
            else -> Color.RED
        }
    }
    frame.add(lblContador)
    frame.add(btnIncrementar)
    frame.isVisible = true
}

fun main() {
    SwingUtilities.invokeLater { crearContador() }
}








