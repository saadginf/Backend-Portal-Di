package com.di.sd.backapi.pftransapi.formations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.transaction.Transactional;

import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.utils.Fiels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class FormationSvcImpl {
    @Value("${file.upload-formations}")
    private String path;
    @Autowired
    FormationRepo formationRepo;
    @Autowired
    CategorieFormationRepo catFromRepo;
    @Autowired
    SessionFormationRepo sessionFormationRepo;
    @Autowired
    TypeFormationRepo tfRepo;
    @Autowired
    CycleScolaireRepo csRepo;

    public Formations addFormations(Formations formation) {
        MultipartFile file = formation.getFile();
        // String[] fileFrags = file.getOriginalFilename().split("\\.");
        // String extension = fileFrags[fileFrags.length-1];
        System.out.println(file.getOriginalFilename());
        formation.setNoteDeBase(file.getOriginalFilename());

        formation = formationRepo.save(formation);

        try {
            Files.write(Paths.get(path + "/" + formation.getId() + "_" + formation.getNoteDeBase()), file.getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return formation;

    }

    public CategorieFormation addCategorieFormation(CategorieFormation ct) {
        try {
            return catFromRepo.save(ct);
        } catch (Exception e) {
            throw new LibbeleException("Champs Invalides");
        }
    }

    public SessionFormation addSession(SessionFormation sf) {
        System.out.println(sf);
        try {
            return sessionFormationRepo.save(sf);
        } catch (Exception e) {
            throw new LibbeleException("Champ Invalide");
        }

    }

    public List<Formations> getFormationByType(TypeFormation tf) {
        return formationRepo.findByTypeFormation(tf);
    }

    public List<Formations> getFormationsInitiales() {
        TypeFormation tf = tfRepo.findById(1L).get();
        return getFormationByType(tf);
    }

    public List<Formations> getFormationsContinues() {
        TypeFormation tf = tfRepo.findById(2L).get();
        return getFormationByType(tf);
    }

    public List<Formations> getFormationsSpecifiques() {
        TypeFormation tf = tfRepo.findById(3L).get();
        return getFormationByType(tf);
    }

    public List<Formations> getFormationsDiverses() {
        TypeFormation tf = tfRepo.findById(4L).get();
        return getFormationByType(tf);
    }

    public List<SessionFormation> getSessionActives() {

        return sessionFormationRepo.findByActiveTrue();
    }

    public Formations getById(Long id) {
        return formationRepo.findById(id).get();
    }

    public FormationCycleFields getFieldsFoCs9() {
        FormationCycleFields fCs = new FormationCycleFields();
        for (Formations formations : formationRepo.findAll()) {
            Fiels fiels = new Fiels();
            fiels.setLabel(formations.getLabel());
            fiels.setValue(formations.getId().toString());
            fCs.getFormations().add(fiels);

        }
        for (CycleScolaire cs : csRepo.findAll()) {
            Fiels fiels2 = new Fiels();
            fiels2.setLabel(cs.getLabel());
            fiels2.setValue(cs.getValue().toString());
            fCs.getCycleScolaire().add(fiels2);
        }
        return fCs;
    }

    public List<SessionFormation> getSessionPlanifActives() {

        return sessionFormationRepo.findByActiveTrueAndPlanificationTrue();
    }

    public SessionFormation getSessionById(Long id) {

        return sessionFormationRepo.findById(id).get();
    }

    public Boolean finplanifcation(Long id) {
        SessionFormation sFormation = sessionFormationRepo.findById(id).get();
        sFormation.setPlanification(false);
        sessionFormationRepo.save(sFormation);
        return true;

    }

    public Boolean finsession(Long id) {
        SessionFormation sFormation = sessionFormationRepo.findById(id).get();
        sFormation.setActive(false);
        sFormation.setPlanification(false);
        sessionFormationRepo.save(sFormation);
        return true;

    }

}