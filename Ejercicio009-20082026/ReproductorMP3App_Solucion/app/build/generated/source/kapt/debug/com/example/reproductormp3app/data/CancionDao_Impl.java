package com.example.reproductormp3app.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class CancionDao_Impl implements CancionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Cancion> __insertionAdapterOfCancion;

  public CancionDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCancion = new EntityInsertionAdapter<Cancion>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR IGNORE INTO `canciones` (`id`,`titulo`,`artista`,`duracionTexto`,`audioResId`,`imagenResId`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Cancion entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitulo() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitulo());
        }
        if (entity.getArtista() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getArtista());
        }
        if (entity.getDuracionTexto() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDuracionTexto());
        }
        statement.bindLong(5, entity.getAudioResId());
        statement.bindLong(6, entity.getImagenResId());
      }
    };
  }

  @Override
  public Object insertarTodas(final List<Cancion> canciones,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCancion.insert(canciones);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<Cancion>> obtenerTodas() {
    final String _sql = "SELECT * FROM canciones ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"canciones"}, false, new Callable<List<Cancion>>() {
      @Override
      @Nullable
      public List<Cancion> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitulo = CursorUtil.getColumnIndexOrThrow(_cursor, "titulo");
          final int _cursorIndexOfArtista = CursorUtil.getColumnIndexOrThrow(_cursor, "artista");
          final int _cursorIndexOfDuracionTexto = CursorUtil.getColumnIndexOrThrow(_cursor, "duracionTexto");
          final int _cursorIndexOfAudioResId = CursorUtil.getColumnIndexOrThrow(_cursor, "audioResId");
          final int _cursorIndexOfImagenResId = CursorUtil.getColumnIndexOrThrow(_cursor, "imagenResId");
          final List<Cancion> _result = new ArrayList<Cancion>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Cancion _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitulo;
            if (_cursor.isNull(_cursorIndexOfTitulo)) {
              _tmpTitulo = null;
            } else {
              _tmpTitulo = _cursor.getString(_cursorIndexOfTitulo);
            }
            final String _tmpArtista;
            if (_cursor.isNull(_cursorIndexOfArtista)) {
              _tmpArtista = null;
            } else {
              _tmpArtista = _cursor.getString(_cursorIndexOfArtista);
            }
            final String _tmpDuracionTexto;
            if (_cursor.isNull(_cursorIndexOfDuracionTexto)) {
              _tmpDuracionTexto = null;
            } else {
              _tmpDuracionTexto = _cursor.getString(_cursorIndexOfDuracionTexto);
            }
            final int _tmpAudioResId;
            _tmpAudioResId = _cursor.getInt(_cursorIndexOfAudioResId);
            final int _tmpImagenResId;
            _tmpImagenResId = _cursor.getInt(_cursorIndexOfImagenResId);
            _item = new Cancion(_tmpId,_tmpTitulo,_tmpArtista,_tmpDuracionTexto,_tmpAudioResId,_tmpImagenResId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object contar(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM canciones";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
