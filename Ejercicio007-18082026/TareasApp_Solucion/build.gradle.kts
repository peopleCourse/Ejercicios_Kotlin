// Archivo de configuración raíz. Declara los plugins usados por los módulos
// pero no los aplica aquí (se aplican en app/build.gradle.kts).
plugins {
    id("com.android.application") version "8.4.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.24" apply false
    id("org.jetbrains.kotlin.kapt") version "1.9.24" apply false
}
