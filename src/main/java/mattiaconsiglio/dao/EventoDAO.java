package mattiaconsiglio.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mattiaconsiglio.entities.Evento;
import mattiaconsiglio.exceptions.EventNotFoundException;

public class EventoDAO {
    // DAO (Data Access Object)
    private EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(evento);
        transaction.commit();
        System.out.println("Evento" + evento.getNome() + " salvato con successo!");
    }

    public Evento getById(int id) throws EventNotFoundException {
        Evento evento = em.find(Evento.class, id);
        if (evento == null) {
            throw new EventNotFoundException(id);
        }
        return evento;
    }

    public void delete(int id) throws EventNotFoundException {
        Evento evento = this.getById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(evento);
        transaction.commit();
        System.out.println("Evento" + evento.getNome() + " eliminato con successo!");
    }
}
