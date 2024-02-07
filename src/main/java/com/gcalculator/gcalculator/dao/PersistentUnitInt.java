package com.gcalculator.gcalculator.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@SuppressWarnings("unused")
public class PersistentUnitInt {
    private EntityManager entityManager;
    private EntityManagerFactory eMf;

    public PersistentUnitInt() {
        this.eMf = Persistence.createEntityManagerFactory("gCalculator_pu");
        this.entityManager = this.eMf.createEntityManager();
    }
    public PersistentUnitInt(String persistentUnit){
        this.eMf = Persistence.createEntityManagerFactory(persistentUnit);
        this.entityManager = this.eMf.createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManagerFactory geteMf() {
        return eMf;
    }

    public void seteMf(EntityManagerFactory eMf) {
        this.eMf = eMf;
    }

    public void close(){
        this.entityManager.close();
        this.eMf.close();
    }
    public void clear(){
        this.entityManager.clear();
    }

}
