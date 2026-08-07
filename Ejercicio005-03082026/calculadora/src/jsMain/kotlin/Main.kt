import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLFormElement
import org.w3c.dom.events.KeyboardEvent
import kotlinx.browser.document
import kotlin.math.pow
import kotlin.math.round

//función principal
fun main(){
//obtener las referencias a los elementos HTML
    val pesoInput = document.getElementById("peso") as HTMLInputElement
    val alturaInput = document.getElementById("altura") as HTMLInputElement
    val calcularBtn = document.getElementById("calcular") as HTMLButtonElement
    val resultadoDiv = document.getElementById("resultado") as HTMLDivElement
    //nuevo
    val form = document.getElementById("imc-form") as HTMLFormElement

    //AGREGAR EVENTO AL BOTON
    //
    calcularBtn.addEventListener("click", {
        calcularIMC(pesoInput, alturaInput, resultadoDiv)
    })

    //nuevo
    // Prevenir que el formulario recargue la página al hacer submit
    form.addEventListener("submit", { event ->
        event.preventDefault()
        calcularIMC(pesoInput, alturaInput, resultadoDiv)
    })
//uso de la tecla enter
    //event is KeyboardEvent comprueba el evento
    document.addEventListener("keydown", { event ->
        if (event is KeyboardEvent && event.key == "Enter") {
            calcularIMC(pesoInput, alturaInput, resultadoDiv)
        }
    })

}
//función calcular: recibir los elementos de DOM y procesa el IMC
fun calcularIMC (
    pesoInput: HTMLInputElement,
    alturaInput: HTMLInputElement,
    resultadoDiv: HTMLDivElement
){
    //obtener valores
    try{
        //obtener los valores de los inputs como string y convertirlo en números Double
        //toDoubleOrNull retoma el null si la conversion falla
        val peso = pesoInput.value.toDoubleOrNull()
        val altura = alturaInput.value.toDoubleOrNull()

        //validar los datos -gestionar el error usando when para verificar multiples condiciones

        when {
            //si el peso es nulo o menor/igual a O
            peso == null || peso <= 0 -> {
            //muestra mensaje de error y sale de la función (return)
                mostrarResultado(resultadoDiv, "Ingresa un peso válido", "error")
                return
        }
            //si la altura es nula o menor/igual a 0
            altura == null || altura <= 0 ->{ //corregido
            //muestra mensaje de error y sale de la función (return)
                mostrarResultado(resultadoDiv, "Ingresa una altura válida", "error")
                return

            }
            //si la altura es mayor a 3 metros (probablemente ingreso en cm.)
            altura  > 3.0 -> {
                //muestra mensaje de error y sale de la función (return)
                mostrarResultado(resultadoDiv, "La altura debe ser en metros (ej.1.75)", "error")
                return

            }
    }
        ///CALCULADO IMC peso/ (altura ^2)
        //La fórmula del índice de masa corporal (IMC) es el peso en kilogramos dividido por el cuadrado de la estatura en metros
    // (IMC = peso / estatura²). Por ejemplo,
    // si una persona pesa 70 kg y mide 1,75 m, se multiplica 1,75 por 1,75 (2,89) y se divide 70 entre 2,89, lo que da un IMC de 24,2
        //pow(2) eleva la altura al cuadrado
        val imc = peso/altura.pow(2.0)
        val imcRedondeado =round(imc * 10) / 10  // Redondeo a 1 decimal

        //DETERMINAR CATEGORÍAS. usando "when" con los rangos y asignación
        //retornar (mensaje) crear un par categoria y le damos un color para que se vea en la interfaz (HTML)
        val (categoria, color) = when{
            imcRedondeado < 18.5 -> "Bajo peso" to "#2196f3" //azul
            imcRedondeado < 25.0 -> "Peso normal" to "#4CAF50" //verde
            imcRedondeado < 30.0 -> "Sobre Peso" to  "#FF9800"  //naranja
            else -> "Obesidad" to "#F44336" //rojo
        }
        //construir mensaje HTML
//         val mensaje = """
////             <strong> IMC: $imcRedondeado </strong> <br>
////             Categoría <strong style = color: $color">$categoria </strong>
////         """.trimIndent() // elimina líneas vacías al inicio y al final si las hay
////        //mostrar el resultado exitoso
////        mostrarResultado(resultadoDiv, mensaje, "success")
        val mensaje = """
            IMC: $imcRedondeado
            Categoría: $categoria 
        """.trimIndent()
        mostrarResultado(resultadoDiv, mensaje, "success")
        //para mostrar los colores
        resultadoDiv.style.color = color

    } catch (_: Exception) {
        // Captura cualquier error inesperado y muestra mensaje genérico
        mostrarResultado(resultadoDiv, "Error al calcular", "error")
    }

}

//FUNCIÓN DE VISUALIZACIÓN: Actualiza el elemento DIV con el resultado
fun mostrarResultado(elemento: HTMLDivElement, mensaje: String, tipo: String) {
    //insertar el contenido HTML en el div
    elemento.innerHTML = mensaje
    //limpiar clases anteriores
    //remove Class() recibe las nuevas clases
    //elemento.removeClass("error", "success")
    elemento.classList.remove("error", "success")

    //añadir la clase correspondiente al tipo de resultado
    //para los CSS error rojo y success es verde
    //elemento.addClass(tipo)
    elemento.classList.add(tipo)
    //Hacer visible (cambiar el display de "none" a "block"
    elemento.style.display = "block"
}














