package mattiaconsiglio.exceptions;

public class RecordNotFoundException extends Exception {
    public RecordNotFoundException(String recodType, int message) {
        super(recodType + " " + message + " non trovato!");
    }
}
