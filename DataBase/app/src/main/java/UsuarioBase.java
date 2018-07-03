import android.provider.BaseColumns;

/**
 * Created by erick on 26/06/18.
 */

public class UsuarioBase {

    public static abstract class UsuarioEntrada implements BaseColumns{
        public static final String TABLE_NAME = "users";
        public static final String USER_NAME = "username";
        public static final String PASSWORD = "password";

    }
}
