/**
 * Ejercicio 1: Fundamentos, Componentes y Layouts
 * Objetivo: crear una ventana, añadir componentes básicos y organizar usando "LayoutManager"
 * Conceptos: JFrame, JPanel, JLabel, JtextField, GridLayout
 *
 * */

import javax.swing.*
import java.awt.*
//funcion principal
fun main() {
    /**
     * SwingUtilities.invokeLater() es un método de Java que ejecuta una tarea de forma segura en el hilo de
     * la interfaz gráfica (EDT o Event Dispatch Thread). Como los componentes de Swing no son seguros para hilos múltiples,
     * debes usarlo para actualizar la pantalla desde otros hilos y evitar fallos.*/
    SwingUtilities.invokeLater {
        crearFormularioLogin()
    }
}
fun crearFormularioLogin() {
    //Jframe:La ventana principal
    val frame = JFrame("Ejercicio 1: Login").apply{
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE //cerrar el programa, colocar x de cerrar
        //tamaño ventana
        setSize(800, 550)
        //colocarla en centro de la pantalla
        setLocationRelativeTo(null)
    }
    //Jpanel y LayoutManger Panel contendores. GridLayout organiza los componentes en una cuadrícula (filas, columnas).
    val panel = JPanel(GridLayout(3,2,10,10))  // 3 filas, 2 columnas, 10px de espacio horizontal y vertical
    panel.border=BorderFactory.createEmptyBorder(10,10,10,10) //Margen interno
    //componetes Básicos
    // En Kotlin, usamos propiedades (propiedad.text)
    val lblUsuario = JLabel("Usuario") //etiqueta con la indicación usuario
    val txtUsuario = JTextField() // espacio donde escribe el usuario
    val lblPassword = JLabel("Contraseña") //etiqueta indicando texto contraseña
    val txtPassword = JPasswordField() //No se ven los caracteres
    val btnLogin = JButton("Iniciar Sesión")
    val lblVacio = JLabel() //Celda vacia para alinear botón a la cuadricula de la  izqueirda

    //Añadimos los componentes al panel. El GridLayout los coloca de izquierda a derecha y arriba a abajo
    panel.add(lblUsuario)
    panel.add(txtUsuario)
    panel.add(lblPassword)
    panel.add(txtPassword)
    panel.add(btnLogin)
    panel.add(lblVacio)


    frame.add(panel) //Añadimos el panel al contenido de ventana
    frame.isVisible = true // Hacemos que la ventana sera visible SIMPE VA AL FINAL

}












