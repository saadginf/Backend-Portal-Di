package com.di.sd.backapi.pftransapi.inscription;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.di.sd.backapi.pftransapi.formations.CycleScolaire;
import com.di.sd.backapi.pftransapi.formations.CycleScolaireRepo;
import com.di.sd.backapi.pftransapi.formations.FormationRepo;
import com.di.sd.backapi.pftransapi.formations.Formations;
import com.di.sd.backapi.pftransapi.formations.SessionFormation;
import com.di.sd.backapi.pftransapi.formations.SessionFormationRepo;
import com.di.sd.backapi.pftransapi.formations.TypeFormation;
import com.di.sd.backapi.pftransapi.personnel.Personnel;
import com.di.sd.backapi.pftransapi.personnel.PersonnelRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImscrptionSvcImpl {
    @Autowired
    CycleScolaireRepo csRepo;
    @Autowired
    FormationRepo foRepo;
    @Autowired
    SessionFormationRepo sfoRepo;
    @Autowired
    PersonnelRepo prsRepo;
    @Autowired
    StatutRepository stRepo;
    @Autowired
    InscriptionRepo insRepo;
    @Autowired
    SessionFormationRepo sessionFormationRepo;

    public Inscription addInscriptionBaseContinue(Long idCycle, Long idFormation, Long personne, Date date) {
        CycleScolaire cs = csRepo.findById(idCycle).get();
        Formations fo = foRepo.findById(idFormation).get();
        Personnel prs = prsRepo.findById(personne).get();
        Inscription ins = new Inscription();
        Statutinscription statut = stRepo.findById(3L).get();
        List<SessionFormation> sfo = sfoRepo.findByFormationAndCycleScolaire(fo, cs);
        ins.setPersonne(prs);
        ins.setStatut(statut);
        if (sfo.isEmpty()) {
            SessionFormation newsfo = new SessionFormation();
            newsfo.setFormation(fo);
            newsfo.setDateFin(date);
            newsfo.setLabel("Session " + cs.getLabel());
            newsfo.setCycleScolaire(cs);
            newsfo.setActive(false);
            newsfo.setPlanification(false);
            SessionFormation savedSfo = sfoRepo.save(newsfo);
            ins.setSformation(savedSfo);
            return insRepo.save(ins);
        } else {
            if (sfo.size() == 1) {
                ins.setSformation(sfo.get(0));
                return insRepo.save(ins);
            } else {
                throw new RuntimeException("Contactez l'adminitrateur");
            }
        }

    }

    public List<Inscription> getInscriptionBaseByPeson(Long personne, TypeFormation tyform) {

        return insRepo.findByPersonneAndSformation_Formation_TypeFormation(prsRepo.findById(personne).get(), tyform);
    }

    public Boolean rejectInscription(Long inscId, String motif) {
        Inscription insc = insRepo.findById(inscId).get();
        insc.setStatut(stRepo.findById(4L).get());
        insc.setMotif(motif);
        insRepo.save(insc);
        return true;
    }

    public List<InscriptionResponse> getInscriptionResponse(List<Inscription> inscs) {
        List<InscriptionResponse> insRespo = new ArrayList<InscriptionResponse>();
        for (Inscription inscription : inscs) {
            InscriptionResponse inscriptionResponse = new InscriptionResponse();
            inscriptionResponse.setGrade(inscription.getPersonne().getGradeActuelle().getLabel());
            inscriptionResponse.setIdpers(inscription.getId());
            inscriptionResponse.setMle(inscription.getPersonne().getMle());
            inscriptionResponse.setNom(inscription.getPersonne().getNom());
            inscriptionResponse.setPrenom(inscription.getPersonne().getPrenom());
            inscriptionResponse.setStatut(inscription.getStatut().getLabel());
            if (inscription.getMotif().isEmpty()) {
                inscriptionResponse.setMotif("RAS");
            } else {
                inscriptionResponse.setMotif(inscription.getMotif());
            }

            inscriptionResponse.setUnite(inscription.getPersonne().getUniteActuelle().getLabel());
            insRespo.add(inscriptionResponse);
        }

        return insRespo;
    }

    public List<InscriptionResponse> getInscriptionBySession(Long sessionId) {
        List<Inscription> inscs = insRepo.findBySformation(sfoRepo.findById(sessionId).get());
        return getInscriptionResponse(inscs);
    }

    public List<InscriptionResponse> getInscriptionBySessionRetenue(Long sessionId) {
        List<Inscription> inscs = insRepo.findBySformationAndStatutNot(sfoRepo.findById(sessionId).get(),
                stRepo.findById(4L).get());
        return getInscriptionResponse(inscs);
    }

    public List<InscriptionResponse> getInscriptionBySessionRejetee(Long sessionId) {
        List<Inscription> inscs = insRepo.findBySformationAndStatut(sfoRepo.findById(sessionId).get(),
                stRepo.findById(4L).get());
        return getInscriptionResponse(inscs);
    }

    public SessionFormation getSessionById(Long id) {

        return sessionFormationRepo.findById(id).get();
    }

}