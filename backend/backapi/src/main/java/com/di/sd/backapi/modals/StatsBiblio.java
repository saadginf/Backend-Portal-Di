package com.di.sd.backapi.modals;

import java.util.List;

public class StatsBiblio {
    
    private Long total;
    private Long uniteInsp;
    private Long uniteCit;
    private Long uniteBst;
    private Long unite7Bt;
    private  Long unit3Bt;
    private Long unite2Bt;
    private Long initeEct;
    
    private List<Ouvrage> lastOuvrages;
    private List<Ouvrage> bestOuvrages;

    

    /**
     * @return Long return the total
     */
    public Long getTotal() {
        return total;
    }

    /**
     * @param l the total to set
     */
    public void setTotal(long l) {
        this.total = l;
    }

    /**
     * @return Long return the uniteInsp
     */
    public Long getUniteInsp() {
        return uniteInsp;
    }

    /**
     * @param uniteInsp the uniteInsp to set
     */
    public void setUniteInsp(Long uniteInsp) {
        this.uniteInsp = uniteInsp;
    }

    /**
     * @return Long return the uniteCit
     */
    public Long getUniteCit() {
        return uniteCit;
    }

    /**
     * @param uniteCit the uniteCit to set
     */
    public void setUniteCit(Long uniteCit) {
        this.uniteCit = uniteCit;
    }

    /**
     * @return Long return the uniteBst
     */
    public Long getUniteBst() {
        return uniteBst;
    }

    /**
     * @param uniteBst the uniteBst to set
     */
    public void setUniteBst(Long uniteBst) {
        this.uniteBst = uniteBst;
    }

    /**
     * @return Long return the unite7Bt
     */
    public Long getUnite7Bt() {
        return unite7Bt;
    }

    /**
     * @param unite7Bt the unite7Bt to set
     */
    public void setUnite7Bt(Long unite7Bt) {
        this.unite7Bt = unite7Bt;
    }

    /**
     * @return Long return the unit3Bt
     */
    public Long getUnit3Bt() {
        return unit3Bt;
    }

    /**
     * @param unit3Bt the unit3Bt to set
     */
    public void setUnit3Bt(Long unit3Bt) {
        this.unit3Bt = unit3Bt;
    }

    /**
     * @return Long return the unite2Bt
     */
    public Long getUnite2Bt() {
        return unite2Bt;
    }

    /**
     * @param unite2Bt the unite2Bt to set
     */
    public void setUnite2Bt(Long unite2Bt) {
        this.unite2Bt = unite2Bt;
    }

    /**
     * @return Long return the initeEct
     */
    public Long getIniteEct() {
        return initeEct;
    }

    /**
     * @param initeEct the initeEct to set
     */
    public void setIniteEct(Long initeEct) {
        this.initeEct = initeEct;
    }

    /**
     * @return List<Ouvrage> return the lastOuvrages
     */
    public List<Ouvrage> getLastOuvrages() {
        return lastOuvrages;
    }

    /**
     * @param lastOuvrages the lastOuvrages to set
     */
    public void setLastOuvrages(List<Ouvrage> lastOuvrages) {
        this.lastOuvrages = lastOuvrages;
    }

    /**
     * @return List<Ouvrage> return the bestOuvrages
     */
    public List<Ouvrage> getBestOuvrages() {
        return bestOuvrages;
    }

    /**
     * @param bestOuvrages the bestOuvrages to set
     */
    public void setBestOuvrages(List<Ouvrage> bestOuvrages) {
        this.bestOuvrages = bestOuvrages;
    }

    public StatsBiblio() {
    }

}