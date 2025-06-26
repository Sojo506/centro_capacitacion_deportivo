package controller;

import dao.invoice.InvoiceDAO;
import dao.invoice.InvoiceDAOImpl;
import dao.athlete.AthleteDAO;
import dao.athlete.AthleteDAOImpl;
import dao.routine.RoutineDAO;
import dao.routine.RoutineDAOImpl;

import model.Invoice;
import model.Athlete;
import model.Routine;

import java.util.List;

public class InvoiceController {

    private InvoiceDAO dao = new InvoiceDAOImpl();
    private AthleteDAO athleteDAO = new AthleteDAOImpl();
    private RoutineDAO routineDAO = new RoutineDAOImpl();

    public boolean registerInvoice(Invoice invoice) {
        // Validar atleta
        Athlete a = athleteDAO.findById(invoice.getAthleteId());
        if (a == null || !a.isActive()) {
            return false;
        }

        // Validar rutinas
        for (Routine r : invoice.getRoutines()) {
            Routine routineDB = routineDAO.findById(r.getId());
            if (routineDB == null || !routineDB.isActive()) {
                return false;
            }
        }

        dao.create(invoice);
        return true;
    }

    public List<Invoice> listInvoices() {
        return dao.getAll();
    }

    public Invoice getInvoiceById(int id) {
        return dao.findById(id);
    }

    public boolean deactivateInvoice(int id) {
        return dao.deactivate(id);
    }
}
