/**
 * Created by erick on 26/06/18.
 */

public class Usuario {
    private String username;
    private  String pasword;

    public Usuario(String u, String p){
        this.username = u;
        this.pasword = p;
    }

    public String getUsername(){
        return username;
    }

    public  String getPasword(){
        return pasword;
    }

}
