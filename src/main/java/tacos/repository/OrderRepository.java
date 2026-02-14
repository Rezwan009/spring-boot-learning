package tacos.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tacos.entity.TacoOrder;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

    TacoOrder save(TacoOrder order);

    List<TacoOrder> findByDeliveryZip(String deliveryZip);

    List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date from, Date to);

    List<TacoOrder> findByDeliveryNameAndDeliveryCity(String deliveryName, String deliveryCity);

    List<TacoOrder> findByDeliveryCityOrderByDeliveryZip(String deliveryCity);

    @Query("SELECT o FROM TacoOrder o WHERE o.deliveryCity = 'Dhaka'")
    List<TacoOrder> readOrdersDeliveredInDhaka();
}
