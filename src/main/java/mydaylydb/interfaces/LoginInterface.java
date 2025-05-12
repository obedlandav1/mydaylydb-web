package mydaylydb.interfaces;

import mydaylydb.entities.UserEntity;

public interface LoginInterface {
    
    public abstract boolean AuthenticateUser(UserEntity user);
    
    public abstract String SelectPassword(String User);

    String SELECT_PASSWORD = "SELECT passwordUsuario FROM usuarios WHERE identidadUsuario =?";
    
}
