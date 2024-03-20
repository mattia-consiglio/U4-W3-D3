package mattiaconsiglio.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mattiaconsiglio.entities.Partecipazione;
import mattiaconsiglio.exceptions.RecordNotFoundException;

public class PartecipazioniDAO {
    private EntityManager em;

    public PartecipazioniDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione p) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(p);
        transaction.commit();
        System.out.println("Partecipazione salvata con successo");
    }


    public Partecipazione getById(int id) throws RecordNotFoundException {
        Partecipazione p = em.find(Partecipazione.class, id);
        if (p == null) {
            throw new RecordNotFoundException("Patecipazione", id);
        }
        return p;
    }

    public void delete(int id) throws RecordNotFoundException {
        Partecipazione p = em.find(Partecipazione.class, id);
        if (p == null) {
            throw new RecordNotFoundException("Partecipazione", id);
        }
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(p);
        transaction.commit();
        System.out.println("Partecipazione eliminata con successo");
    }
}
