# Guion de Clase: TareasApp con Room (paso a paso)

Pensado para proyectar y seguir en vivo con los estudiantes. Cada paso corresponde a uno o varios TODOs del proyecto `TareasApp`.

**Duración estimada:** 45-60 min
**Requisito previo:** proyecto `TareasApp` abierto y sincronizado en Android Studio.

---

## Paso 0 — Recorrido inicial (5 min)
Antes de tocar código, mostrar la estructura del proyecto y explicar qué ya está hecho:

- `activity_main.xml` y `item_tarea.xml` → la UI, ya terminada.
- `TareaAdapter.kt` → casi terminado (falta 1 línea).
- Los 5 archivos con TODOs → lo que se va a completar hoy.

**Pregunta disparadora:** "¿Qué archivo creen que representa la tabla de la base de datos? ¿Cuál representa las consultas SQL?"

---

## Paso 1 — Entity: la tabla (5 min)
Abrir `Tarea.kt`.

1. Explicar: una `data class` con `@Entity` se convierte en una tabla real de SQLite.
2. Completar TODO 1:
   ```kotlin
   @Entity(tableName = "tareas")
   ```
3. Completar TODO 2:
   ```kotlin
   @PrimaryKey(autoGenerate = true) val id: Int = 0,
   ```

**Verificación:** el archivo compila sin errores rojos. Aún no se puede ejecutar la app (falta el resto).

---

## Paso 2 — DAO: las consultas (10 min)
Abrir `TareaDao.kt`.

1. Explicar la diferencia entre `@Insert`/`@Update`/`@Delete` (Room genera el SQL solo) y `@Query` (SQL escrito a mano).
2. Completar TODO 3: `@Dao` en la interfaz.
3. Completar TODO 4-6: `@Insert`, `@Update`, `@Delete` sobre cada función.
4. Completar TODO 7:
   ```kotlin
   @Query("SELECT * FROM tareas ORDER BY id ASC")
   ```

**Pregunta disparadora:** "¿Por qué `insertar`, `actualizar` y `eliminar` son funciones `suspend` pero `obtenerTodas()` no?" (Respuesta: `obtenerTodas()` devuelve `LiveData`, que ya maneja la actualización de forma asíncrona por sí mismo.)

---

## Paso 3 — Database: la conexión (10 min)
Abrir `AppDatabase.kt`.

1. Completar TODO 8:
   ```kotlin
   @Database(entities = [Tarea::class], version = 1, exportSchema = false)
   ```
2. Completar TODO 9:
   ```kotlin
   abstract fun tareaDao(): TareaDao
   ```
3. Completar TODO 10 dentro del `synchronized`:
   ```kotlin
   Room.databaseBuilder(
       context.applicationContext,
       AppDatabase::class.java,
       "tareas_database"
   ).build()
   ```

**Pausa para preguntar:** "¿Qué pasaría si quitamos `synchronized` y dos pantallas piden la base de datos al mismo tiempo?" — gancho para hablar de condiciones de carrera sin entrar en detalle técnico profundo.

---

## Paso 4 — ViewModel: conectar la lógica (10 min)
Abrir `TareaViewModel.kt`.

1. Completar TODO 11:
   ```kotlin
   private val dao = AppDatabase.getDatabase(application).tareaDao()
   ```
2. Completar TODO 12:
   ```kotlin
   val tareas: LiveData<List<Tarea>> = dao.obtenerTodas()
   ```
3. Completar TODO 13 y 14 (agregar y eliminar), ambos con el mismo patrón:
   ```kotlin
   viewModelScope.launch {
       dao.insertar(Tarea(descripcion = descripcion))
   }
   ```

**Demostración en vivo (opcional):** comentar temporalmente `viewModelScope.launch { }` y dejar la llamada a `dao.insertar()` suelta, para que el estudiante vea el error de compilación ("Suspend function called outside coroutine"). Luego deshacer el cambio.

---

## Paso 5 — Adapter: el último detalle (5 min)
Abrir `TareaAdapter.kt`, completar TODO 15:
```kotlin
onCompletadaChanged(tarea.copy(completada = isChecked))
```

**Explicar `copy()`:** como `Tarea` es `data class`, `copy()` crea una nueva instancia cambiando solo el campo indicado — no se modifica el objeto original.

---

## Paso 6 — MainActivity: unir todo (10 min)
Abrir `MainActivity.kt`.

1. Completar TODO 16:
   ```kotlin
   ViewModelProvider(this)[TareaViewModel::class.java]
   ```
2. Completar TODO 17 (el más importante de la clase):
   ```kotlin
   viewModel.tareas.observe(this) { lista ->
       adapter.actualizarLista(lista)
   }
   ```
3. Completar TODO 18:
   ```kotlin
   viewModel.agregarTarea(texto)
   ```

**Ejecutar la app.** Este es el momento de la clase donde debe funcionar completo.

---

## Paso 7 — Prueba en vivo y cierre (5-10 min)
Con la app corriendo en el emulador o dispositivo:

1. Agregar 2-3 tareas.
2. Marcar una como completada.
3. Cerrar la app por completo (no solo minimizar) y reabrirla → los datos deben seguir ahí.
4. Eliminar una tarea.

**Pregunta de cierre:** "¿Dónde se están guardando estos datos físicamente? ¿Se pierden si desinstalamos la app?" (Respuesta: en un archivo SQLite dentro del almacenamiento privado de la app; se pierden si se desinstala.)

---

## Si algo falla durante la clase

| Síntoma | Causa probable | Solución rápida |
|---|---|---|
| Error "Cannot find implementation for AppDatabase" | Falta alguna anotación (`@Entity`, `@Dao`, `@Database`) | Revisar Pasos 1-3 |
| App crashea al tocar "Agregar" | Falta `viewModelScope.launch` | Revisar Paso 4 |
| Lista no se actualiza en pantalla | Falta el `observe()` del Paso 6 | Revisar TODO 17 |
| Checkbox no guarda el estado | Falta `tarea.copy(completada = isChecked)` | Revisar Paso 5 |

---

## Extensión para la próxima clase
Usar la sección "Retos opcionales" de `GUIA_EJERCICIO.md` como tarea o como continuación en la siguiente sesión.
