//importar librerias html -kotlin
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLDivElement






//funcion principal
fun main(){
//obtener las referencias a los elementos HTML
    val pesoInput = document.getElementById("peso") as HTMLInputElement
    val alturaInput = document.getElementById("altura") as HTMLInputElement
    val calcularBtn = document.getElementById("calcular")
    val resultadoDiv = document.getElementById("resultado") as HTMLDivElement

    //AGREGAR EVENTO AL BOTON
    calcularBtn?.addEventListener("click", {
        calcularIMC(pesoInput, alturaInput, resultadoDiv)
    })

    //permitir que usuario calcule usando enter
    document.addEventListener("keydown",{
        if (it.key =="Enter"){
            calcularIMC(pesoInput, alturaInput, resultadoDiv)
        }
    })

}

fun calcularIMC (pesoInput: HTMLInputElement, alturaInput: HTMLInputElement, resultadoDiv: HTMLDivElement  ){
    //obtener valors

    val peso = pesoInput.value.toDoubleOrNull()
    val altura = alturaInput.value.toDoubleOrNull()

    //validar los catos -gestionar el error

    when
}















