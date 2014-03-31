package com.github.yukihane.jpa_template;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.github.yukihane.jpa_template.entity.Parent;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     * 
     * @param testName
     *            name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        EntityManager em = Persistence.createEntityManagerFactory("JPAUNIT")
                .createEntityManager();

        try {
            em.getTransaction().begin();
            
            Parent p = new Parent();
            p.setName("myname");
            em.persist(p);

            Parent p2 = new Parent();
            p2.setName("myname2");
            em.persist(p2);

            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            
            em.close();
        }
    }
}
