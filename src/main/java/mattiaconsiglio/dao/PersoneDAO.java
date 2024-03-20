package mattiaconsiglio.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mattiaconsiglio.entities.Persona;
import mattiaconsiglio.exceptions.EventNotFoundException;

public class PersoneDAO {
    private EntityManager em;

    public PersoneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(persona);
        transaction.commit();
        System.out.println("Persona" + persona.getNome() + " " + persona.getCognome() + " salvata con successo!");
    }

    public Persona getById(int id) throws EventNotFoundException {
        Persona persona = em.find(Persona.class, id);
        if (persona == null) {
            throw new EventNotFoundException(id);
        }
        return persona;
    }

    public void delete(int id) throws EventNotFoundException {
        Persona persona = this.getById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(persona);
        transaction.commit();
        System.out.println("Persona" + persona.getNome() + " " + persona.getCognome() + " eliminata con successo!");
    }
}
