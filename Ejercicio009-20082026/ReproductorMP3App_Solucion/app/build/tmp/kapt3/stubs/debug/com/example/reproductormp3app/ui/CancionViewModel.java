package com.example.reproductormp3app.ui;

/**
 * ViewModel: sobrevive a cambios de configuración (como rotar la pantalla)
 * y expone los datos observables a la Activity.
 *
 * Analogía web: se parece a un "store" (Redux/Pinia) que guarda el estado
 * y avisa a la UI cuando cambia, en vez de que la UI consulte la base de
 * datos directamente cada vez.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/reproductormp3app/ui/CancionViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "canciones", "Landroidx/lifecycle/LiveData;", "", "Lcom/example/reproductormp3app/data/Cancion;", "getCanciones", "()Landroidx/lifecycle/LiveData;", "repositorio", "Lcom/example/reproductormp3app/data/CancionRepository;", "app_debug"})
public final class CancionViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.reproductormp3app.data.CancionRepository repositorio = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.example.reproductormp3app.data.Cancion>> canciones = null;
    
    public CancionViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.example.reproductormp3app.data.Cancion>> getCanciones() {
        return null;
    }
}