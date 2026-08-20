package com.example.reproductormp3app;

/**
 * Pantalla del reproductor.
 *
 * Analogía web: MediaPlayer es el equivalente en Android a la etiqueta
 * <audio> de HTML5. Así como en JavaScript harías:
 *
 *     const audio = new Audio("cancion.mp3");
 *     audio.play();
 *     audio.pause();
 *     audio.currentTime = 0;
 *
 * en Android usamos MediaPlayer con métodos muy parecidos: start(),
 * pause(), seekTo(), getCurrentPosition(), getDuration().
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J\u0012\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/example/reproductormp3app/PlayerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "actualizarSeekBarRunnable", "Ljava/lang/Runnable;", "binding", "Lcom/example/reproductormp3app/databinding/ActivityPlayerBinding;", "handler", "Landroid/os/Handler;", "mediaPlayer", "Landroid/media/MediaPlayer;", "configurarBotones", "", "configurarSeekBar", "detenerActualizacionSeekBar", "formatearTiempo", "", "ms", "", "inicializarMediaPlayer", "audioResId", "iniciarActualizacionSeekBar", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "app_debug"})
public final class PlayerActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_TITULO = "extra_titulo";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_ARTISTA = "extra_artista";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_AUDIO_RES_ID = "extra_audio_res_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_IMAGEN_RES_ID = "extra_imagen_res_id";
    private com.example.reproductormp3app.databinding.ActivityPlayerBinding binding;
    @org.jetbrains.annotations.Nullable()
    private android.media.MediaPlayer mediaPlayer;
    @org.jetbrains.annotations.NotNull()
    private final android.os.Handler handler = null;
    private java.lang.Runnable actualizarSeekBarRunnable;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.reproductormp3app.PlayerActivity.Companion Companion = null;
    
    public PlayerActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void inicializarMediaPlayer(int audioResId) {
    }
    
    private final void configurarBotones() {
    }
    
    private final void configurarSeekBar() {
    }
    
    private final void iniciarActualizacionSeekBar() {
    }
    
    private final void detenerActualizacionSeekBar() {
    }
    
    private final java.lang.String formatearTiempo(int ms) {
        return null;
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/reproductormp3app/PlayerActivity$Companion;", "", "()V", "EXTRA_ARTISTA", "", "EXTRA_AUDIO_RES_ID", "EXTRA_IMAGEN_RES_ID", "EXTRA_TITULO", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}