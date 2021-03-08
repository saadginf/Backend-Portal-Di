package com.di.sd.backapi.pftransapi.planification;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.pftransapi.formations.SessionFormation;
import com.di.sd.backapi.pftransapi.formations.SessionFormationRepo;
import com.di.sd.backapi.pftransapi.inscription.Inscription;
import com.di.sd.backapi.pftransapi.inscription.InscriptionRepo;
import com.di.sd.backapi.pftransapi.inscription.StatutRepository;
import com.di.sd.backapi.pftransapi.inscription.Statutinscription;
import com.di.sd.backapi.pftransapi.personnel.Personnel;
import com.di.sd.backapi.pftransapi.personnel.PersonnelRepo;
import com.di.sd.backapi.utils.Fiels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanificationSvcImpl {
    @Autowired
    PersonnelRepo pRepo;
    @Autowired
    SessionFormationRepo sfRepo;
    @Autowired
    StatutRepository stRepo;
    @Autowired
    InscriptionRepo insRepo;

    public static long getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public List<PlanficationReponse> planificationCDC(Fiels[] perso, Long idS) {
        List<PlanficationReponse> inscirptions = new ArrayList<PlanficationReponse>();
        Statutinscription statutRejete = stRepo.findById(4L).get();
        Statutinscription satutPlanification = stRepo.findById(1L).get();
        for (Fiels fiels : perso) {

            SessionFormation sfo = sfRepo.findById(idS).get();
            Personnel person = pRepo.findById(Long.parseLong(fiels.getValue())).get();
            if (insRepo.findByPersonneAndSformation_Formation(person, sfo.getFormation()) != null) {
                throw new LibbeleException(person.getGradeActuelle().getLabel() + " " + person.getNom() + " "
                        + person.getPrenom() + " est deja planifie");
            }
        }

        for (Fiels fiels : perso) {
            List<String> errors = new ArrayList<String>();
            PlanficationReponse planficationReponse = new PlanficationReponse();
            Inscription inscription = new Inscription();
            Personnel person = pRepo.findById(Long.parseLong(fiels.getValue())).get();
            inscription.setPersonne(person);
            inscription.setSformation(sfRepo.findById(idS).get());
            inscription.setMotif("");
            if (person.getGradeActuelle().getValue() != 8) {
                errors.add("Grade non Conforme");
            }
            Date myDate = parseDate(Calendar.getInstance().get(Calendar.YEAR) + "-09-1");

            Long nbrDays = getDifferenceDays(person.getDateNaissance(), myDate);
            System.out.println("age:" + nbrDays + "--- date calcule " + myDate);
            if (nbrDays.compareTo(17520L) > 0) {
                errors.add("Age > 48ans");
            }
            Inscription ins = insRepo.findByPersonneAndSformation_Formation_Label(person, "Cours de Perfectionnement");
            if (ins == null) {
                errors.add("CdP manquant");
            } else {
                Long nbrDay = getDifferenceDays(ins.getSformation().getDateFin(), myDate);
                System.out.println("age stage:" + nbrDay);
                if (nbrDay.compareTo(730l) < 0) {
                    errors.add("date CdP < 2");
                }

            }
            if (errors.isEmpty()) {
                inscription.setStatut(satutPlanification);
            } else {
                inscription.setStatut(statutRejete);
                for (String string : errors) {
                    inscription.setMotif(inscription.getMotif() + "-" + string);
                }
            }
            Inscription savedInscription = insRepo.save(inscription);
            planficationReponse.setInscription(savedInscription);
            planficationReponse.setPersonnel(
                    person.getGradeActuelle().getLabel() + " " + person.getNom() + " " + person.getPrenom());
            inscirptions.add(planficationReponse);
        }
        return inscirptions;
    }
}