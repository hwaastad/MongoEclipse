/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.datametrix.testdeleteprocess.producer;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
@Slf4j
public class Resources {
//
//    @PersistenceContext(unitName = "TestPU")
//    private EntityManager em;
//
//    @Produces
//    public EntityManager getEntityManager() {
//        log.info("Producing Entitymanager......");
//        return em;
//    }

    @PersistenceUnit(unitName = "TestPU")
    private EntityManagerFactory entityManagerFactory;

    @Produces
    @RequestScoped
    @Default
    public EntityManager getEntityManager() {
        log.info("Producing Entitymanager......");
        return this.entityManagerFactory.createEntityManager();
    }

    public void dispose(@Disposes @Default EntityManager entityManager) {
        if (entityManager.isOpen()) {
            log.info("Disposing Entitymanager......");
            entityManager.close();
        }
    }
}
