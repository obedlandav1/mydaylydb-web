package mydaylydb.interfaces;

import mydaylydb.entities.UserEntity;

public interface LoginInterface {
    
    public abstract boolean AuthenticateUser(UserEntity user);
    
    public abstract String SelectPassword(String User);

    public abstract UserEntity SelectUser(String User);
    
    String SELECT_PASSWORD = "SELECT passwordUsuario FROM usuarios WHERE identidadUsuario =?";
    
    String SELECT_USER = "SELECT id, nombreUsuario, apellidoUsuario FROM usuarios WHERE identidadUsuario =? AND estado = 1;";
    
}
