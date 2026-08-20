package com.example.reproductormp3app.ui;

/**
 * Adapter: "traduce" cada Cancion de la lista a una fila visual (item_cancion.xml).
 *
 * Analogía web: es lo mismo que un .map() sobre un array de datos que
 * genera un <div> por cada elemento, pero optimizado para reciclar vistas.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0015B\'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\b2\n\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u001c\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/reproductormp3app/ui/CancionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/reproductormp3app/ui/CancionAdapter$CancionViewHolder;", "canciones", "", "Lcom/example/reproductormp3app/data/Cancion;", "onClick", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "actualizarLista", "nuevaLista", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "CancionViewHolder", "app_debug"})
public final class CancionAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.reproductormp3app.ui.CancionAdapter.CancionViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.reproductormp3app.data.Cancion> canciones;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.example.reproductormp3app.data.Cancion, kotlin.Unit> onClick = null;
    
    public CancionAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.reproductormp3app.data.Cancion> canciones, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.reproductormp3app.data.Cancion, kotlin.Unit> onClick) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.example.reproductormp3app.ui.CancionAdapter.CancionViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.reproductormp3app.ui.CancionAdapter.CancionViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void actualizarLista(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.reproductormp3app.data.Cancion> nuevaLista) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/reproductormp3app/ui/CancionAdapter$CancionViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/reproductormp3app/databinding/ItemCancionBinding;", "(Lcom/example/reproductormp3app/ui/CancionAdapter;Lcom/example/reproductormp3app/databinding/ItemCancionBinding;)V", "getBinding", "()Lcom/example/reproductormp3app/databinding/ItemCancionBinding;", "app_debug"})
    public final class CancionViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.example.reproductormp3app.databinding.ItemCancionBinding binding = null;
        
        public CancionViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.reproductormp3app.databinding.ItemCancionBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.reproductormp3app.databinding.ItemCancionBinding getBinding() {
            return null;
        }
    }
}