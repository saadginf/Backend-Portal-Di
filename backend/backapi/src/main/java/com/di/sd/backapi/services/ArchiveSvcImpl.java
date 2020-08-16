package com.di.sd.backapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.di.sd.backapi.dao.DocumentRepo;
import com.di.sd.backapi.dao.SousThemeRepo;
import com.di.sd.backapi.dao.TypeDocRepo;
import com.di.sd.backapi.modals.Document;
import com.di.sd.backapi.modals.SousTheme;
import com.di.sd.backapi.modals.TypeDoc;

@Service
public class ArchiveSvcImpl {

   
    @Autowired
    DocumentRepo docrepo;
    @Autowired
    TypeDocRepo tDocSvc;
    @Autowired
    SousThemeRepo sthSvc;
    @Value("${file.upload-archive}")
    private String path;


    public Iterable<Document> getAll(){
      return docrepo.findAll();
    }

    public Document storeArchive(Document doc) {
      MultipartFile file = doc.getFile();
      //String[] fileFrags = file.getOriginalFilename().split("\\.");
      //String extension = fileFrags[fileFrags.length-1];
      System.out.println(file.getOriginalFilename());
      doc.setFileDoc(file.getOriginalFilename());
      doc = docrepo.save(doc);

      try {
        Files.write(Paths.get(path + "/" + doc.getId() + "_" + doc.getFileDoc()), file.getBytes());
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return doc;
    }

    //public Resource loadFileAsResource(String fileName) {
      //  try {
        //    Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
          //  Resource resource = new UrlResource(filePath.toUri());
            //if(resource.exists()) {
              //  return resource;
    //        } else {
            //    throw new MyFileNotFoundException("File not found " + fileName);
      //      }
        //} catch (MalformedURLException ex) {
         //   throw new MyFileNotFoundException("File not found " + fileName, ex);
        //}
   // }
   public List<Document> FindByTyAndSth(Long tyId, Long sthId){
    TypeDoc tyDoc =  tDocSvc.findById(tyId).get();
    SousTheme sThDoc = sthSvc.findById(sthId).get();
    
     List<Document> docs = docrepo.findByTypedocumentAndSousThemeOrderByDateArrivee(tyDoc, sThDoc);
     for (Document document : docs) {
       System.out.println(document.getDateArrivee());
     }
     return docs;
     
   }
}
