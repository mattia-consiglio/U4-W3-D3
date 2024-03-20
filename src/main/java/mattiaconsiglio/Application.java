package mattiaconsiglio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mattiaconsiglio.dao.EventoDAO;
import mattiaconsiglio.entities.Evento;
import mattiaconsiglio.entities.TipoEvento;
import mattiaconsiglio.exceptions.EventNotFoundException;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDAO ed = new EventoDAO(em);

        Evento evento1 = new Evento("test", LocalDate.now(), "descrizione", TipoEvento.PRIVATO, 10);
        Evento evento2 = new Evento("test1", LocalDate.now(), "descrizione1", TipoEvento.PUBBLICO, 10);
        Evento evento3 = new Evento("test2", LocalDate.now(), "descrizione2", TipoEvento.PRIVATO, 10);

        ed.save(evento1);
        ed.save(evento2);
        ed.save(evento3);


        //try reading an event that does exist
        try {
            Evento eventoGet = ed.getById(503);
            System.out.println(eventoGet);
        } catch (EventNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //try reading an event that does not exist
        try {
            Evento eventoGet2 = ed.getById(5);
            System.out.println(eventoGet2);
        } catch (EventNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //try deleting an event that does exist
        try {
            ed.delete(504);
        } catch (EventNotFoundException e) {
            System.out.println(e.getMessage());
        }

        //try deleting an event that does not exist
        try {
            ed.delete(10);
        } catch (EventNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
