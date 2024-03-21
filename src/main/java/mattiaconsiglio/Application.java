package mattiaconsiglio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mattiaconsiglio.dao.EventiDAO;
import mattiaconsiglio.dao.LocationsDAO;
import mattiaconsiglio.dao.PartecipazioniDAO;
import mattiaconsiglio.dao.PersoneDAO;
import mattiaconsiglio.entities.Evento;
import mattiaconsiglio.exceptions.EventNotFoundException;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        LocationsDAO ld = new LocationsDAO(em);
        EventiDAO ed = new EventiDAO(em);
        PersoneDAO pd = new PersoneDAO(em);
        PartecipazioniDAO pd2 = new PartecipazioniDAO(em);


        //create some people
//        Persona p1 = new Persona("p1", "c1", "n1", LocalDate.now(), Sesso.F);
//        Persona p2 = new Persona("p2", "c2", "n2", LocalDate.now(), Sesso.M);
//
//
//        pd.save(p1);
//        pd.save(p2);

//        try {
//            Evento evento1 = ed.getById(702);
//            Evento evento2 = ed.getById(703);
//            Persona p1 = pd.getById(1);
//            Persona p2 = pd.getById(2);
//            Partecipazione partecipazione1 = new Partecipazione(p1, evento1, StatoPartecipazione.CONFERMATA);
//            Partecipazione partecipazione2 = new Partecipazione(p2, evento2, StatoPartecipazione.DA_CONFERMARE);
//            pd2.save(partecipazione1);
//            pd2.save(partecipazione2);
//        } catch (EventNotFoundException e) {
//            System.out.println(e.getMessage());
//        }


        //create some partecipations


        //create location
//        Location location = new Location("location1", "citta1");

//        ld.save(location);


       /* try {
            Location locationGet = ld.getById(1);
            Evento evento1 = new Evento("test", LocalDate.now(), "descrizione", TipoEvento.PRIVATO, 10, locationGet);
            Evento evento2 = new Evento("test1", LocalDate.now(), "descrizione1", TipoEvento.PUBBLICO, 10, locationGet);
            Evento evento3 = new Evento("test2", LocalDate.now(), "descrizione2", TipoEvento.PRIVATO, 10, locationGet);

            ed.save(evento1);
            ed.save(evento2);
            ed.save(evento3);

        } catch (RecordNotFoundException e) {
            System.out.println(e.getMessage());
        }*/

        //create some events


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
