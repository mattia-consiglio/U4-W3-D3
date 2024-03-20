package mattiaconsiglio.exceptions;

public class EventNotFoundException extends Exception {
    public EventNotFoundException(int message) {
        super("Evento " + message + " non trovato!");
    }
}
