data class Color(val red: Int, val green: Int, val blue: Int) {
    init {
        require(red in 0..255) { "Red debe estar entre 0 y 255" }
        require(green in 0..255) { "Green debe estar entre 0 y 255" }
        require(blue in 0..255) { "Blue debe estar entre 0 y 255" }
    }

    fun mix(other: Color): Color =
        Color(
            (red + other.red) / 2,
            (green + other.green) / 2,
            (blue + other.blue) / 2
        )

    operator fun plus(other: Color): Color =
        Color(
            (red + other.red).coerceAtMost(255),
            (green + other.green).coerceAtMost(255),
            (blue + other.blue).coerceAtMost(255)
        )

    companion object {
        val BLACK = Color(0, 0, 0)
        val WHITE = Color(255, 255, 255)
        val RED = Color(255, 0, 0)
        val GREEN = Color(0, 255, 0)
        val BLUE = Color(0, 0, 255)
    }
}

fun Color.toHex(): String = "#${red.toHexByte()}${green.toHexByte()}${blue.toHexByte()}"
private fun Int.toHexByte(): String = toString(16).padStart(2, '0').uppercase()
fun Color.toRgbString(): String = "rgb($red, $green, $blue)"

enum class ColorName(val color: Color) {
    ROJO(Color.RED),
    VERDE(Color.GREEN),
    AZUL(Color.BLUE),
    AMARILLO(Color(255, 255, 0)),
    CIAN(Color(0, 255, 255)),
    MAGENTA(Color(255, 0, 255)),
    NEGRO(Color.BLACK),
    BLANCO(Color.WHITE),
    //VIOLETA
}

fun generateColorPalette(start: Color, end: Color, steps: Int): List<Color> {
    require(steps >= 2) { "Se necesitan al menos 2 pasos" }
    val stepRed = (end.red - start.red).toDouble() / (steps - 1)
    val stepGreen = (end.green - start.green).toDouble() / (steps - 1)
    val stepBlue = (end.blue - start.blue).toDouble() / (steps - 1)
    return (0 until steps).map { i ->
        Color(
            (start.red + stepRed * i).toInt(),
            (start.green + stepGreen * i).toInt(),
            (start.blue + stepBlue * i).toInt()
        )
    }
}

fun main() {
    val red = Color.RED
    val blue = Color.BLUE

    val purple = red.mix(blue)
    println("Mezcla de rojo y azul: ${purple.toHex()} (${purple.toRgbString()})")

    val brightRed = red + Color(50, 0, 0)


    val amarillo = ColorName.AMARILLO.color
    println("Amarillo predefinido: ${amarillo.toHex()}")

    val palette = generateColorPalette(Color.RED, Color.GREEN, 5)
    println("\nPaleta rojo → verde (5 pasos):")
    palette.forEach { println(it.toHex()) }

    println("\nColores predefinidos en ColorName:")
    ColorName.values().forEach {
        println("${it.name}: ${it.color.toHex()}")
    }
}