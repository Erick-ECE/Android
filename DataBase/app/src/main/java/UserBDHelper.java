import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by erick on 26/06/18.
 */

public class UserBDHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "User_db";
    public static final int DATABSE_VERSION = 1;

    public UserBDHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ UsuarioBase.UsuarioEntrada.TABLE_NAME
                + "( " + UsuarioBase.UsuarioEntrada._ID + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + UsuarioBase.UsuarioEntrada.USER_NAME + "TEXT NOT NULL,"
                + UsuarioBase.UsuarioEntrada.PASSWORD + "TEXT NOT NULL" + ")");
        //
        // ingresa un registro en la base de datos
        ContentValues c = new ContentValues();
        c.put(UsuarioBase.UsuarioEntrada.USER_NAME, "ericken");
        c.put(UsuarioBase.UsuarioEntrada.PASSWORD, "123");
        db.insert(UsuarioBase.UsuarioEntrada.TABLE_NAME, null,c);

        //realiza una consulta : (obtiene todos los registros)
        Cursor cursor = db.query(UsuarioBase.UsuarioEntrada.TABLE_NAME,null,
                null,null,null,null,null);
        // consulta especifca
        Cursor cursor1= db.rawQuery("SELECT * FROM " +
        UsuarioBase.UsuarioEntrada.TABLE_NAME + " WHERE " +
        UsuarioBase.UsuarioEntrada.USER_NAME + " ='?' " , new String[] {"erick123"});




    }

    public void nuevoRegistro(SQLiteDatabase db, String u, String p){
        ContentValues c = new ContentValues();
        c.put(UsuarioBase.UsuarioEntrada.USER_NAME, u);
        c.put(UsuarioBase.UsuarioEntrada.PASSWORD, p);
        db.insert(UsuarioBase.UsuarioEntrada.TABLE_NAME, null,c);
    }

    /*
    * pubic long nuevoRegistro (Usuario u){
    *
    * }
    *
    */

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
