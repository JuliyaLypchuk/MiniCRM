package service;

import dao.ClientDao;
import entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

    @Autowired
    @Qualifier("clientDao")
    private ClientDao clientDao;

    public ClientDao getClientDao() {
        return clientDao;
    }

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public ClientServiceImpl() {
    }

    /*метод додає у базу нового кліента (Client)
    * для цього у метод треба передати об"єкт типу Client
    * повертає унікальний id*/
    @Override
    public Long add(Client client) {
        if (client != null && !isCreatedClient(client)) {
            Long id = clientDao.create(client);
            return id;
        }
        return null;
    }

    /*метод без параметрів, повертає список List<> усіх кліентів*/
    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }

    /*метод видаляє з бази кліента (Client)
    * для цього у метод треба передати унікальний id
    * повертає true якщо успішно видалили*/
    @Override
    public void delete(Long id) {
        Client client = clientDao.read(id);
        clientDao.delete(client);
    }

    @Override
    public void changeClient(Client oldClient, Client newClient) {
        if (oldClient != null && newClient != null) {
            oldClient.setName(newClient.getName());
            oldClient.setSureName(newClient.getSureName());
            oldClient.setAge(newClient.getAge());
            oldClient.setPhone(newClient.getPhone());
            oldClient.setEmail(newClient.getEmail());

            clientDao.update(oldClient);
        }
    }
    @Override
    public Long findIdClient(Client client) {
        if (client != null) {
            List<Client> clients = findAll();
            for (Client cl : clients) {
                if (cl.equals(client)) {
                    return cl.getId();
                }
            }
        }
        return null;
    }

    @Override
    public boolean isCreatedClient(Client client) {
        List<Client> clients = findAll();
        for (Client cl : clients) {
            if (cl.getName().equals(client.getName())
                    && cl.getSureName().equals(client.getSureName())
                    && cl.getPhone().equals(client.getPhone())
                    && cl.getAge().equals(client.getAge())
                    && cl.getEmail().equals(client.getEmail())) {
                return true;
            }
        }
        return false;
    }
}
