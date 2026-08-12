/*
 * ============================================================
 *  MainActivity.kt
 *  Proyecto: CalculadoraIMC (Android Studio)
 *
 *  Es el equivalente al "script" que en el HTML original estaba
 *  en main.bundle.js: contiene la lógica que conecta el formulario
 *  con el cálculo y muestra el resultado.
 *
 *  MISMA lógica que ya usamos en consola y en Swing:
 *   - validar datos
 *   - calcular IMC = peso / (altura * altura)
 *   - clasificar en categorías
 *  Lo único que cambia es CÓMO se conecta con la pantalla.
 * ============================================================
 */

package com.daysi.calcladoraimc  // ajusta este nombre al de tu proyecto

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/*
 * AppCompatActivity = clase base de una "pantalla" en Android.
 * Equivalente a que el navegador cargue y muestre el documento HTML completo.
 */
class MainActivity : AppCompatActivity() {

    // Declaramos las variables que apuntarán a los elementos del XML.
    // "lateinit" significa "se inicializará más adelante" (en onCreate).
    private lateinit var campoPeso: EditText
    private lateinit var campoAltura: EditText
    private lateinit var botonCalcular: Button
    private lateinit var textoResultado: TextView

    /*
     * onCreate() se ejecuta cuando la pantalla se crea por primera vez.
     * Es el equivalente al momento en que el navegador termina de
     * parsear el HTML y el DOM está listo (como "DOMContentLoaded" en JS).
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setContentView conecta esta clase Kotlin con el layout XML,
        // es decir, con activity_main.xml (nuestro "HTML" de Android)
        setContentView(R.layout.activity_main)

        // --- CONEXIÓN CON LOS ELEMENTOS DEL XML ---
        // findViewById es el equivalente a document.getElementById() en JavaScript
        campoPeso = findViewById(R.id.campoPeso)
        campoAltura = findViewById(R.id.campoAltura)
        botonCalcular = findViewById(R.id.botonCalcular)
        textoResultado = findViewById(R.id.textoResultado)

        // --- EVENTO DE CLIC (equivalente al "submit" del <form> en JS) ---
        botonCalcular.setOnClickListener {
            calcularIMC()
        }
    }

    /*
     * Misma lógica de validación y cálculo que en consola y Swing.
     */
    private fun calcularIMC() {
        // Leemos el texto de los EditText (equivalente a leer los <input>)
        val pesoTexto = campoPeso.text.toString().replace(",", ".")
        val alturaTexto = campoAltura.text.toString().replace(",", ".")

        val peso = pesoTexto.toDoubleOrNull()
        val altura = alturaTexto.toDoubleOrNull()

        // --- Validación (igual que required/min en el HTML) ---
        if (peso == null || altura == null) {
            mostrarError("Debes introducir valores numéricos válidos en ambos campos (*)")
            return
        }
        if (peso < 1) {
            mostrarError("El peso debe ser mayor o igual a 1 kg")
            return
        }
        if (altura < 0.5) {
            mostrarError("La altura debe ser mayor o igual a 0.5 m")
            return
        }

        // --- Cálculo del IMC ---
        val imc = peso / (altura * altura)

        // --- Clasificación, igual que en las versiones anteriores ---
        val categoria = when {
            imc < 18.5 -> "Bajo peso"
            imc <= 24.9 -> "Peso normal"
            imc <= 29.9 -> "Sobrepeso"
            else -> "Obesidad"
        }

        mostrarResultado(imc, categoria)
    }

    /*
     * Muestra el resultado en azul, equivalente a #resultado.success del CSS
     */
    private fun mostrarResultado(imc: Double, categoria: String) {
        val imcFormateado = "%.2f".format(imc)
        textoResultado.text = "Tu IMC es: $imcFormateado\nCategoría: $categoria"
        textoResultado.setTextColor(0xFF073d7a.toInt()) // azul, como .success
    }

    /*
     * Muestra el error en rojo, equivalente a #resultado.error del CSS
     */
    private fun mostrarError(mensaje: String) {
        textoResultado.text = mensaje
        textoResultado.setTextColor(0xFFd20808.toInt()) // rojo, como .error
    }
}