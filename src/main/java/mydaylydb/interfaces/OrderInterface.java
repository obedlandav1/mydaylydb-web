package mydaylydb.interfaces;

import java.util.List;
import mydaylydb.entities.OrderEntity;
import org.json.JSONArray;

public interface OrderInterface {

    public abstract boolean Create(OrderEntity orderEntity);

    public abstract JSONArray ReadById(int id);

    public abstract boolean Update(OrderEntity orderEntity);

    public abstract boolean Delete(int Id);

    public abstract List<OrderEntity> SelectAllOrdersByProject(int projectid);
    
    String ORDER_CREATE = "CALL ORDER_CREATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

    String READ_BY_ID = "CALL ORDER_READ_BY_ID(?)";

    String ORDER_UPDATE = "CALL ORDER_UPDATE_BY_ID (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    String DELETE_BY_ID = "CALL ORDER_DELETE_BY_ID(?)";

    String ORDER_SELECT_ALL_BY_PROJECT = "CALL ORDER_SELECT_ALL_BY_PROJECT(?)";
}
