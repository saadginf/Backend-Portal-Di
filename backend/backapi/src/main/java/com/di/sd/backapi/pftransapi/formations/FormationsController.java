package com.di.sd.backapi.pftransapi.formations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import com.di.sd.backapi.services.MapVAlidationErrorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
@RequestMapping("api/formation")
public class FormationsController {
    @Autowired
    TypeFormationRepo tyFormationRepo;
    @Autowired
    CategorieFormationRepo catFormRepo;
    @Autowired
    FormationSvcImpl ssSvc;
    @Autowired
    EtablissementRepo etabRepo;
    @Autowired
    FormationRepo formationRepo;
    @Autowired
    FormationSvcImpl fsi;
    @Value("${file.upload-formations}")
    private String path;
    @Autowired
    MapVAlidationErrorService mVerrors;

    @PostMapping("")
    public ResponseEntity<?> addFormation(@RequestParam MultipartFile file, @RequestParam String label,
            @RequestParam String reference, @RequestParam String compositionDossier, @RequestParam Long typeFormation,
            @RequestParam Long catForm, @RequestParam String conditions, @RequestParam Long etablissement) {
        if (!file.getContentType().equals("application/pdf")) {
            throw new RuntimeException("Fichier Invalid");
        }
        TypeFormation tyFormation = tyFormationRepo.findById(typeFormation).get();
        CategorieFormation catFormation = catFormRepo.findById(catForm).get();
        Etablissement etablissementF = etabRepo.findById(etablissement).get();

        Formations formation = new Formations();
        formation.setConditions(conditions);
        System.out.println(conditions);
        formation.setCategorieFormation(catFormation);
        formation.setEtablissement(etablissementF);
        formation.setTypeFormation(tyFormation);
        formation.setLabel(label);
        formation.setReference(reference);
        formation.setCompositionDossier(compositionDossier);
        formation.setNoteDeBase(file.getOriginalFilename());

        Formations formsaved = formationRepo.save(formation);
        try {
            Files.write(Paths.get(path + "/" + formsaved.getId() + "_" + formsaved.getNoteDeBase()), file.getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping(path = "/download/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getFile(@PathVariable("id") Long id) throws Exception {
        Formations u = formationRepo.findById(id).get();
        return Files.readAllBytes(Paths.get(path + "/" + u.getId() + "_" + u.getNoteDeBase()));
    }

    @PostMapping("/addSession")
    public ResponseEntity<?> addSession(@Valid @RequestBody SessionFormation ssf, BindingResult result) {

        ResponseEntity<?> errorMap = mVerrors.MapValidationService(result);
        if (errorMap != null)
            return errorMap;
        SessionFormation ssform = ssSvc.addSession(ssf);
        return new ResponseEntity<SessionFormation>(ssform, HttpStatus.OK);

    }

    @GetMapping("")
    public List<Formations> getAllFormation() {
        return formationRepo.findAll();

    }

    @GetMapping("/fieldsFoCs")
    public FormationCycleFields getFieldsFormationCs() {
        return fsi.getFieldsFoCs9();

    }

    @GetMapping("/formationsdebase")
    public List<Formations> getAllFormationFi() {
        return fsi.getFormationsInitiales();

    }

    @GetMapping("/formationcontinues")
    public List<Formations> getAllFormationCont() {
        return fsi.getFormationsContinues();

    }

    @GetMapping("/formationspecifiques")
    public List<Formations> getAllFormationSp() {
        return fsi.getFormationsSpecifiques();

    }

    @GetMapping("/formationdiverse")
    public List<Formations> getAllFormationDiv() {
        return fsi.getFormationsDiverses();

    }

    @GetMapping("/activeSessions")
    public List<SessionFormation> getAllactiveSess() {
        return fsi.getSessionActives();

    }

    @GetMapping(path = "/{id}")
    public Formations getFormationsById(@PathVariable("id") Long id) {
        return fsi.getById(id);

    }

    @GetMapping("/planifSession")
    public List<SessionFormation> getAllactiveplanifSess() {
        return fsi.getSessionPlanifActives();

    }

    @GetMapping("/session/{id}")
    public SessionFormation getSessionById(@PathVariable("id") Long id) {
        return fsi.getSessionById(id);

    }

    @GetMapping("/finplanification/{id}")
    public Boolean finPlanification(@PathVariable("id") Long id) {
        return fsi.finplanifcation(id);

    }

    @GetMapping("/finsession/{id}")
    public Boolean finSession(@PathVariable("id") Long id) {
        return fsi.finsession(id);

    }
}