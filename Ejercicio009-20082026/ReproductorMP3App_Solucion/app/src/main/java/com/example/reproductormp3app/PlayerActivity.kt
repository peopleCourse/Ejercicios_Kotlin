package com.example.reproductormp3app

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.example.reproductormp3app.databinding.ActivityPlayerBinding

/**
 * Pantalla del reproductor.
 *
 * Analogía web: MediaPlayer es el equivalente en Android a la etiqueta
 * <audio> de HTML5. Así como en JavaScript harías:
 *
 *      const audio = new Audio("cancion.mp3");
 *      audio.play();
 *      audio.pause();
 *      audio.currentTime = 0;
 *
 * en Android usamos MediaPlayer con métodos muy parecidos: start(),
 * pause(), seekTo(), getCurrentPosition(), getDuration().
 */
class PlayerActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TITULO = "extra_titulo"
        const val EXTRA_ARTISTA = "extra_artista"
        const val EXTRA_AUDIO_RES_ID = "extra_audio_res_id"
        const val EXTRA_IMAGEN_RES_ID = "extra_imagen_res_id"
    }

    private lateinit var binding: ActivityPlayerBinding
    private var mediaPlayer: MediaPlayer? = null

    private val handler = Handler(Looper.getMainLooper())
    private lateinit var actualizarSeekBarRunnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titulo = intent.getStringExtra(EXTRA_TITULO) ?: ""
        val artista = intent.getStringExtra(EXTRA_ARTISTA) ?: ""
        val audioResId = intent.getIntExtra(EXTRA_AUDIO_RES_ID, -1)
        val imagenResId = intent.getIntExtra(EXTRA_IMAGEN_RES_ID, -1)

        binding.tvTituloCancion.text = titulo
        binding.tvArtista.text = artista
        binding.ivCaratulaGrande.setImageResource(imagenResId)

        inicializarMediaPlayer(audioResId)
        configurarBotones()
        configurarSeekBar()
    }

    private fun inicializarMediaPlayer(audioResId: Int) {
        mediaPlayer = MediaPlayer.create(this, audioResId)

        binding.seekBar.max = mediaPlayer?.duration ?: 0
        binding.tvTiempoTotal.text = formatearTiempo(mediaPlayer?.duration ?: 0)

        mediaPlayer?.setOnCompletionListener {
            binding.tvEstado.text = "Estado: terminado"
            binding.seekBar.progress = 0
            binding.tvTiempoActual.text = formatearTiempo(0)
        }
    }

    private fun configurarBotones() {
        binding.btnPlay.setOnClickListener {
            mediaPlayer?.start()
            binding.tvEstado.text = "Estado: reproduciendo"
            iniciarActualizacionSeekBar()
        }

        binding.btnPause.setOnClickListener {
            mediaPlayer?.pause()
            binding.tvEstado.text = "Estado: pausado"
        }

        binding.btnStop.setOnClickListener {
            mediaPlayer?.pause()
            mediaPlayer?.seekTo(0)
            binding.seekBar.progress = 0
            binding.tvTiempoActual.text = formatearTiempo(0)
            binding.tvEstado.text = "Estado: detenido"
        }
    }

    private fun configurarSeekBar() {
        actualizarSeekBarRunnable = object : Runnable {
            override fun run() {
                mediaPlayer?.let {
                    binding.seekBar.progress = it.currentPosition
                    binding.tvTiempoActual.text = formatearTiempo(it.currentPosition)
                }
                handler.postDelayed(this, 500)
            }
        }

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer?.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    private fun iniciarActualizacionSeekBar() {
        handler.post(actualizarSeekBarRunnable)
    }

    private fun detenerActualizacionSeekBar() {
        handler.removeCallbacks(actualizarSeekBarRunnable)
    }

    private fun formatearTiempo(ms: Int): String {
        val totalSegundos = ms / 1000
        val minutos = totalSegundos / 60
        val segundos = totalSegundos % 60
        return String.format("%02d:%02d", minutos, segundos)
    }

    override fun onDestroy() {
        super.onDestroy()
        detenerActualizacionSeekBar()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
