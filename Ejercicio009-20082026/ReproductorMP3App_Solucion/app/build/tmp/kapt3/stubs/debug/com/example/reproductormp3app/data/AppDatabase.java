package com.example.reproductormp3app.data;

/**
 * Punto de entrada a la base de datos.
 *
 * Analogía web: es como abrir la conexión a una BD (o inicializar
 * localStorage la primera vez), pero Room nos da un objeto con el que
 * trabajar en vez de tener que escribir SQL a mano.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/reproductormp3app/data/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "cancionDao", "Lcom/example/reproductormp3app/data/CancionDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.example.reproductormp3app.data.Cancion.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.example.reproductormp3app.data.AppDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.reproductormp3app.data.AppDatabase.Companion Companion = null;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.reproductormp3app.data.CancionDao cancionDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/example/reproductormp3app/data/AppDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/reproductormp3app/data/AppDatabase;", "cancionesSemilla", "", "Lcom/example/reproductormp3app/data/Cancion;", "getInstance", "context", "Landroid/content/Context;", "prepoblarSiEstaVacia", "", "db", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.reproductormp3app.data.AppDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final void prepoblarSiEstaVacia(com.example.reproductormp3app.data.AppDatabase db) {
        }
        
        private final java.util.List<com.example.reproductormp3app.data.Cancion> cancionesSemilla() {
            return null;
        }
    }
}