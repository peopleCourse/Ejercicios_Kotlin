/**
 * Ejercicio 3: Diálogos, Validación y Lógica
 * Objetivo: Leer datos del usuario, procesarlos con lógica de negocio y mostrar resultados mediante ventanas de diálogo.
 * Conceptos: JOptionPane, validación de entradas, manejo de excepciones básicas.
 * */

import javax.swing.*
import java.awt.*
//Calcular la edad del usuario y indicar  grupos infante, adolescente, joven, adulto, adulto mayor
fun crearCalculadoraEdad(){

    //ventana donde aparece todo
    val frame = JFrame("Validar Edad").apply{
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(300, 120)
        setLocationRelativeTo(null)
        layout = FlowLayout()
    }

    //usuario coloque la edad
    val txtEdad = JTextField(10)
    //boton para validar
    val btnValidar = JButton("Comprobar Edad")

    btnValidar.addActionListener {
        //trim elimina los espacio delante y detras del texto
        val texto = txtEdad.text.trim()
        //evitar que el usuario presione el boton sin introducir texto (edad)
        //validar y manejar errores
        //isNull = si  variable no tiene valor
        //isBlank = la cadena esta varia y tiene espacios en Blanco
        //isEmpty = logitud es 0
        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(
                frame,
                "POR FAVOR¡, INGRESA TU EDAD.",
                "ERROR",
                JOptionPane.ERROR_MESSAGE
            )
            return@addActionListener // sale del mensaje y vuelta al incio, nos aseguramos que se activa de nuevo el boton
        }
        //  crear un condicion de tome la edad, calcule esa edadGrupo, le diga cual es su edad, y que asesocie al grupo
        try {
            //simepre que usuario escriba algo dentro de un input el sistema con convencionalidad lo reconoce como TEXTO (STRING)!!y debemos cambiarlo a numero (int/fl/d)
            val edad = texto.toInt()
            val grupo = calcularGrupo(edad)
            JOptionPane.showMessageDialog(
                frame,
                "Tu edad es $edad,\nEl grupo al que perteneces es $grupo",
                "INFORMACION",
                JOptionPane.INFORMATION_MESSAGE
            )
        } catch (e: NumberFormatException) {
            JOptionPane.showMessageDialog(
                frame,
                "La edad debe ser un número válido.",
                "Error de formato",
                JOptionPane.WARNING_MESSAGE
            )
        }

    }
    frame.add(JLabel("EDAD"))
    frame.add(txtEdad)
    frame.add(btnValidar)
    frame.isVisible = true

}

//Logica de negocio separa la accion de claculo a un objeto aparte para mejorar la Interfaz de Usuario. Separar responsabilidades
fun calcularGrupo(edad:Int): String{
    return when{
        edad < 0 -> "Edad no válida"
        edad < 12 -> "Infante"
        edad < 18 -> "Adolescente"
        edad < 65 -> "Adulto"
        else -> "Adulto Mayor"

    }
}



fun main() {
    SwingUtilities.invokeLater { crearCalculadoraEdad() }
}