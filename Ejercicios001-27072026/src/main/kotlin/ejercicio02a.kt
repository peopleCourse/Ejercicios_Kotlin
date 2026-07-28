import java.awt.BorderLayout
import java.awt.Color
import java.awt.Font
import javax.swing.*

//=========================
//EJERCICIO 02
//CONTADOR DE CLICKS
//=========================

/**
 * RETO:
 * Agregar un boton de reiniciar el contador vuelva a 0
 * Cambiar el color del texto contador cuando llegue a 10 clicks
 * Enviar al usuario un mensaje cuando llegue a 50 clicks
 * Cambiar el titulo de la ventana por Conctador de Entradas
 * */

//Importar librerias


//Clase Principal Hereda los compentes de ventana (JFrame) cambiarle el nombre la clase no puede llamar igual que el ejercicio 2
class ContadorClicks2 : JFrame() {
    //Crear la estructura de los clicks, tiene que ser privado solo puede usar la clase
    //variable donde guardaremos la cantidad de clicks
    private var contador = 0

    //colocar de un etiqueta donde se muestra el contador
    private val lblContador = JLabel(
        "Clicks: 0",
        SwingConstants.CENTER
    )
    private val btnClick = JButton("Haz Click aquí")

    //BOTON DE REINICIAR
    private val btnReiniciar = JButton("Reiniciar")


    //inicializador
    init {
        //titulo inicial
        title = "Contador de Clicks - 02 "
        //tamaño ventana
        setSize(400, 200)
        //centrar en pantalla
        setLocationRelativeTo(null)
        //cerrar el programa
        defaultCloseOperation = EXIT_ON_CLOSE
        //creama un espacio d margenes
        layout = BorderLayout(10, 10)
        //estilos del texto del contador
        lblContador.font = Font("Arial", Font.BOLD, 30)
        //estilo del boton del click
        btnClick.font = Font("Arial", Font.BOLD, 15)
        //estilo del boton de reiniciar
        btnReiniciar.font = Font("Arial", Font.BOLD, 15)


        // creamos un panel donde se va a colocar el boton
        val panelBotones = JPanel()
        panelBotones.add(btnClick)
        panelBotones.add(btnReiniciar)

        //Agregar los elementos a la ventana
        add(lblContador, BorderLayout.CENTER)
        add(panelBotones, BorderLayout.SOUTH)

        //CREAR ACCION DEL BOTON click (Evento)
        btnClick.addActionListener {
            //incrementar el contador
            contador++
            //actualiza el texto Label
            lblContador.text = "Clicks: $contador"
            ///actualizar el titulo de la ventana
            title = "Contador Nuevo $contador"

            //crear una condicion que cambia a verde cuando llegue a 10 click
            if (contador >= 10) {
                //el color para hacerlo en RGB Color(r,g,b)
                lblContador.foreground = Color(0, 150, 0)
            } else {
                //el color es directo Color.COLOR
                lblContador.foreground = Color.GRAY
            }

            //crear un condicion cunado el contador llegue a 50 clikcs
            if (contador == 50) {
                JOptionPane.showMessageDialog(
                    this,
                    "Fin del conteo!!! \n Has llegado a 50 clicks",
                    "Aforo lleno",
                    JOptionPane.INFORMATION_MESSAGE
                )
            }
        }
//crear evento para el boton Reiniciar
        btnReiniciar.addActionListener {
            //reiniciar el contador
            contador = 0
            //Actualizar el Label
            lblContador.text = "Click: 0"
            //Cambiamos el color a VIOLETA
            lblContador.foreground = Color.MAGENTA
            //Restaura el titulo
            title = "Reinicio"
        }

    }
}
fun main() {
//Llamada a todas las apliación Swing del programa que se deben inicializar
    SwingUtilities.invokeLater {
        //Preparar la Ventana
        val ventana = ContadorClicks2()
        //la mostramos
        ventana.isVisible = true
    }

}