package niccolosorrenti;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import niccolosorrenti.dao.EventoDAO;

public class Application {

    //    Questo è il modo per connetterci al database tramite il persistence name dato nel file 'persistence.xml'
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("u4d14-esercizio-pu");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EventoDAO eventoDAO = new EventoDAO(entityManager);

//        Evento evento1 = new Evento("Titolo1", LocalDate.now(), "Descrizione titolo1", TipoEvento.PRIVATO);
//        Evento evento2 = new Evento("Titolo2", LocalDate.now(), "Descrizione titolo2", TipoEvento.PUBBLICO);
//        Evento evento3 = new Evento("Titolo3", LocalDate.now(), "Descrizione titolo3", TipoEvento.PRIVATO);

//        eventoDAO.save(evento1);
//        eventoDAO.save(evento2);
//        eventoDAO.save(evento3);

//        try {
//            Evento eventoDalDb = eventoDAO.getById(2);
//            System.out.println(eventoDalDb);
//        } catch (NotFoundException exception) {
//            System.out.println(exception.getMessage());
//        }
//
//        try {
//            eventoDAO.delete(3);
//        } catch (NotFoundException exception) {
//            System.out.println(exception.getMessage());
//        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
