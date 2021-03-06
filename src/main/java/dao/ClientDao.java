package dao;

import entity.Client;
import java.util.List;

/**
 * Created by Yura on 13.02.2017.
 */
public interface ClientDao {
    Long create(Client client);
    Client read(Long id);
    void update(Client client);
    void delete(Client client);
    List<Client> findAll();
}
