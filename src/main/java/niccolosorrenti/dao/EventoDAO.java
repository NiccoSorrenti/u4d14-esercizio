package niccolosorrenti.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import niccolosorrenti.entities.Evento;
import niccolosorrenti.exceptions.NotFoundException;

public class EventoDAO {

    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Evento nuovoEvento) {
//        Apro una nuova transaction
        EntityTransaction transaction = entityManager.getTransaction();

//        Starto la nuova transaction
        transaction.begin();

//        Aggiungo 'nuovoEvento' al PersistanceContext, facendolo diventare MANAGED
        entityManager.persist(nuovoEvento);

//        Faccio il 'commit' della transaction per far si che l'oggetto managed diventi una nuova riga
//        della tabella
        transaction.commit();

        System.out.println("L'oggetto " + nuovoEvento.getTitolo() + " è stato salvato correttamente");
    }

    public Evento getById(long eventoId) {
        Evento found = entityManager.find(Evento.class, eventoId);
        if (found == null) {
            throw new NotFoundException(eventoId);
        } else {
            return found;
            // System.out.println("L'evento con id: " + eventoId + " è stato trovato");
        }
    }

    public void delete(long eventoId) {
//        Cerco l'evento tramite id riutilizzando il metodo getById
        Evento found = this.getById(eventoId);

//        Creo una nuova transaction per persistere l'oggetto
        EntityTransaction transaction = entityManager.getTransaction();

//        Avvio la transaction
        transaction.begin();

//        Rimuovo l'evento trovato dal PersistanceContext tramite .remove
        entityManager.remove(found);

//        Per far si che l'evento venga rimosso effettivamente devo fare commit
        transaction.commit();

        System.out.println("Lo studente con id: " + found.getId() + " è stato cancellato con successo");
    }

//    public boolean getConcertiInStreaming(boolean inStreaming){
//        boolean found =
//    }

}
