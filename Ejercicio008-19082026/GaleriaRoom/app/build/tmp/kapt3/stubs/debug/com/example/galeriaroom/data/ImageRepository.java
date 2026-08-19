package com.example.galeriaroom.data;

/**
 * Repositorio: capa intermedia entre el DAO y el ViewModel.
 *
 * No es estrictamente obligatorio en un ejercicio tan sencillo, pero se
 * incluye porque es la arquitectura recomendada por Google (separar el
 * origen de datos de la lógica de la UI). Facilita, por ejemplo, añadir
 * en el futuro otra fuente de datos (una API) sin tocar el ViewModel.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u000eR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/galeriaroom/data/ImageRepository;", "", "imageDao", "Lcom/example/galeriaroom/data/ImageDao;", "(Lcom/example/galeriaroom/data/ImageDao;)V", "allImages", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/galeriaroom/data/ImageItem;", "getAllImages", "()Lkotlinx/coroutines/flow/Flow;", "delete", "", "image", "(Lcom/example/galeriaroom/data/ImageItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "app_debug"})
public final class ImageRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.example.galeriaroom.data.ImageDao imageDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.galeriaroom.data.ImageItem>> allImages = null;
    
    public ImageRepository(@org.jetbrains.annotations.NotNull()
    com.example.galeriaroom.data.ImageDao imageDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.galeriaroom.data.ImageItem>> getAllImages() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.example.galeriaroom.data.ImageItem image, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.example.galeriaroom.data.ImageItem image, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}