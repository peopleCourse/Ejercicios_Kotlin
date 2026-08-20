package com.example.reproductormp3app.data;

/**
 * DAO = Data Access Object.
 *
 * Analogía web: es como los endpoints de una API REST (GET /canciones,
 * POST /canciones). En vez de escribir fetch("/canciones"), aquí
 * escribimos una interfaz con anotaciones y Room genera el SQL por nosotros.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\fH\'\u00a8\u0006\r"}, d2 = {"Lcom/example/reproductormp3app/data/CancionDao;", "", "contar", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertarTodas", "", "canciones", "", "Lcom/example/reproductormp3app/data/Cancion;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "obtenerTodas", "Landroidx/lifecycle/LiveData;", "app_debug"})
@androidx.room.Dao()
public abstract interface CancionDao {
    
    @androidx.room.Query(value = "SELECT * FROM canciones ORDER BY id ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.example.reproductormp3app.data.Cancion>> obtenerTodas();
    
    @androidx.room.Insert(onConflict = 5)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertarTodas(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.reproductormp3app.data.Cancion> canciones, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM canciones")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object contar(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
}