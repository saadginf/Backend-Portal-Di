package com.di.sd.backapi.services;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

import com.di.sd.backapi.dao.EventsRepo;
import com.di.sd.backapi.exceptions.LibbeleException;
import com.di.sd.backapi.modals.Events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventSvcImpl {
    @Autowired
    private EventsRepo editeRepo;

    public Events addEditeur(Events editeur) {

        
        try {
            System.out.println(editeur);
            return editeRepo.save(editeur);
           
        } catch (Exception e) {
           throw new LibbeleException("Erreur de base de donnée");
        }
    }
    public Iterable<Events> getAll(){
        
        Iterable<Events> events = editeRepo.findAll();
        for (Events event : events) {
            if (event.getTypeEvent().getLibbele().equals("Cyclique")){
                

                int year = Calendar.getInstance().get(Calendar.YEAR);
                    event.setStart(year+"-"+event.getStart());
                    event.setEnd(year+"-"+event.getEnd());
                }
            
        }
        return events;
    }
    public void deleteExemplaire(Long id) {

     

        try {
            Events exemp = editeRepo.findById(id).get();
            editeRepo.delete(exemp);
        } catch (Exception e) {
           throw new LibbeleException("Erreur de base de donnée");
        }
        

    }
    public List<Events> getTop10(){
        Iterable<Events> event = getAll();
        List<Events> sortEvents = new ArrayList<Events>();
     
        LocalDateTime now = LocalDateTime.now();  
       
       
        for (Events events : event) {
            
            LocalDate date = LocalDate.parse(events.getStart());
            long noOfDaysBetween = ChronoUnit.DAYS.between(date,now);
           
            if(noOfDaysBetween==-10){
                sortEvents.add(events);
            }
        }
        return sortEvents;
    }
    public List<Events> getTop5(){
        Iterable<Events> event = getAll();
        List<Events> sortEvents = new ArrayList<Events>();
     
        LocalDateTime now = LocalDateTime.now();  
       
       
        for (Events events : event) {
            
            LocalDate date = LocalDate.parse(events.getStart());
            long noOfDaysBetween = ChronoUnit.DAYS.between(date,now);
           
            if(noOfDaysBetween==-5){
                sortEvents.add(events);
            }
        }
        return sortEvents;
    }
    public List<Events> getTop2(){
        Iterable<Events> event = getAll();
        List<Events> sortEvents = new ArrayList<Events>();
     
        LocalDateTime now = LocalDateTime.now();  
       
       
        for (Events events : event) {
            
            LocalDate date = LocalDate.parse(events.getStart());
            long noOfDaysBetween = ChronoUnit.DAYS.between(date,now);
           
            if(noOfDaysBetween==-2){
                sortEvents.add(events);
            }
        }
        return sortEvents;
    }
}