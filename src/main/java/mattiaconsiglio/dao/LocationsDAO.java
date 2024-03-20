package mattiaconsiglio.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mattiaconsiglio.entities.Location;
import mattiaconsiglio.exceptions.RecordNotFoundException;

public class LocationsDAO {
    private EntityManager em;

    public LocationsDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
        System.out.println("Location" + location.getName() + " salvata con successo!");
    }


    public Location getById(int id) throws RecordNotFoundException {
        Location location = em.find(Location.class, id);
        if (location == null) {
            throw new RecordNotFoundException("Location", id);
        }
        return location;
    }


    public void delete(int id) throws RecordNotFoundException {
        Location location = this.getById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(location);
        transaction.commit();
        System.out.println("Location" + location.getName() + " eliminata con successo!");
    }
}
