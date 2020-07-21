package com.di.sd.backapi.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import com.di.sd.backapi.dao.ExemplaireRepo;
import com.di.sd.backapi.dao.OuvrageRepo;
import com.di.sd.backapi.dao.TomeRepo;
import com.di.sd.backapi.dao.UniteRepo;
import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.modals.Auteur;
import com.di.sd.backapi.modals.Exemplaire;
import com.di.sd.backapi.modals.Ouvrage;
import com.di.sd.backapi.modals.SumUpExemplaire;
import com.di.sd.backapi.modals.Tome;
import com.di.sd.backapi.modals.Unite;
import com.di.sd.backapi.utils.Inventaire;
import com.di.sd.backapi.utils.StatsOuvByUnite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExmplaireServiceImpl {
    @Autowired
    private ExemplaireRepo exemplaireRepo;
    @Autowired
    private UniteRepo uniteRepo;
    @Autowired
    private TomeRepo tomeRepo;
    @Autowired
    private OuvrageRepo ouvRpo;

    public Exemplaire addExemp(Exemplaire ex) {

        try {
            Exemplaire exempl = exemplaireRepo.save(ex);
            Exemplaire exf = exemplaireRepo.findById(exempl.getId()).get();
            exf.setRayonId(exf.getRayonId() + "" + exf.getId());
            return exemplaireRepo.save(exf);
        } catch (Exception e) {
            throw new LibbeleException("erreur de base de donée");
        }
    }

    public Iterable<Exemplaire> getAll() {
        Iterable<Exemplaire> exeplaires = exemplaireRepo.findAll();
        for (Exemplaire exemplaire : exeplaires) {
            exemplaire.getTome().getOuvrage().setTomes(null);
            exemplaire.getTome().setExemplaires(null);
            exemplaire.getUnite().setExeplaires(null);
        }
        return exemplaireRepo.findAll();
    }

    public Exemplaire getExemplaireByRayon(String id) {

        Exemplaire exemp = exemplaireRepo.findByRayonId(id);

        if (exemp == null) {
            throw new LibbeleException("Cet exemplaire n'existe pas");
        }
        exemp.getTome().getOuvrage().setTomes(null);
        exemp.getTome().setExemplaires(null);
        exemp.getUnite().setExeplaires(null);
        return exemp;
    }

    public void deleteExemplaire(Long id) {

        Exemplaire exemp = exemplaireRepo.findById(id).get();

        if (exemp == null) {
            throw new LibbeleException("Project ID Doesn't exists");

        }
        exemplaireRepo.delete(exemp);

    }

    public void deleteProject(String projectId) {
        Exemplaire project = exemplaireRepo.findByRayonId(projectId);

        if (project == null) {
            throw new LibbeleException("Project ID Doesn't exists");
        }
        exemplaireRepo.delete(project);

    }

    public List<SumUpExemplaire> getExemplaireByUnite(Long id) {

        Unite unite = uniteRepo.findById(id).get();
        if (unite == null) {
            throw new LibbeleException("Cet Unite n'existe pas");
        }
        List<Exemplaire> exemp = exemplaireRepo.findByUnite(unite);
        if (exemp == null) {
            throw new LibbeleException("Aucun exemplaire");
        }

        List<SumUpExemplaire> sexplist = new ArrayList<SumUpExemplaire>();
        for (Exemplaire exemplaire : exemp) {
            SumUpExemplaire sexp = new SumUpExemplaire();
            sexp.setUnite(exemplaire.getUnite().getLibbele());
            sexp.setRayonId(exemplaire.getRayonId());
            sexp.setTitre(exemplaire.getTome().getOuvrage().getTitre());
            String auts = "";
            for (Auteur auteurs : exemplaire.getTome().getOuvrage().getAuteurs()) {
                auts = auts + auteurs.getLibbele() + " ";
            }
            sexp.setAuteurs(auts);
            sexp.setTheme(exemplaire.getTome().getOuvrage().getTheme().getLibbele());
            sexp.setClassification(exemplaire.getTome().getOuvrage().getClassification().getLibbele());
            if (exemplaire.isExiste()) {
                sexp.setPosition(1);
            } else {
                sexp.setPosition(0);
            }
            sexplist.add(sexp);
        }

        return sexplist;
    }

    public StatsOuvByUnite getnumberByUnite(Long id) {
        StatsOuvByUnite sobu = new StatsOuvByUnite();
        Iterable<Unite> unit = uniteRepo.findAll();
        Tome tome = tomeRepo.findById(id).get();
        for (Unite unite : unit) {
            if (unite.getLibbele().equals("INSP"))
                sobu.setUniteInsp(exemplaireRepo.countByUniteAndTome(unite, tome));
            else if (unite.getLibbele().equals("7BT"))
                sobu.setUnite7Bt(exemplaireRepo.countByUniteAndTome(unite, tome));
            else if (unite.getLibbele().equals("3BT"))
                sobu.setUnit3Bt(exemplaireRepo.countByUniteAndTome(unite, tome));
            else if (unite.getLibbele().equals("2BT"))
                sobu.setUnite2Bt(exemplaireRepo.countByUniteAndTome(unite, tome));
            else if (unite.getLibbele().equals("BST"))
                sobu.setUniteBst(exemplaireRepo.countByUniteAndTome(unite, tome));
            else if (unite.getLibbele().equals("ECT"))
                sobu.setIniteEct(exemplaireRepo.countByUniteAndTome(unite, tome));
            else if (unite.getLibbele().equals("CIT"))
                sobu.setUniteCit(exemplaireRepo.countByUniteAndTome(unite, tome));
        }

        return sobu;
    }

    public List<Inventaire> getInventaire(Long theme, Long unite) {
        List<Long> data = exemplaireRepo.generateStats(theme, unite);
        Unite un = uniteRepo.findById(unite).get();
        if (data == null || un == null) {
            throw new LibbeleException("Erreur");
        }

        List<Inventaire> stats = new ArrayList<Inventaire>();
       
     
        int i = 1;
        for (Long object : data) {
            Inventaire sts = new Inventaire();
            sts.setNumber("" + i);
            Ouvrage ouv = ouvRpo.findById(object).get();
            sts.setDate_pub(ouv.getAnneePublication().getYear()+1900);
            sts.setTitre(ouv.getTitre());
            sts.setEditeur(ouv.getEditeur().getLibbele());
                    for (Auteur auteur : ouv.getAuteurs()) {
                        sts.setAuteurs(sts.getAuteurs() != null ? sts.getAuteurs()+", "+auteur.getLibbele() : "" + auteur.getLibbele());
                    }
                   
                   List<Integer> qte = new ArrayList<Integer>();
                   List<String> to= new ArrayList<String>();
                   List<Tome> tomes = tomeRepo.findByOuvrageOrderByLibbele(ouv);
                   for (Tome tome : tomes) {
                       to.add(tome.getLibbele());
                      qte.add(exemplaireRepo.countByUniteAndTome(un, tome));
                    
                    }
                    sts.setQte(qte);
                    sts.setTomes(to);
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
        sts.setDate_ac(dateFormat.format(ouv.getTomes().iterator().next().getExemplaires().iterator().next().getDateAcquisition()));
                
            stats.add(sts);

            i++;
        }
        
        return stats;
       }
}