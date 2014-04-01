package com.github.yukihane.jpa_template;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.github.yukihane.jpa_template.entity.Head;

/**
 * Hello world!
 * 
 */
public class App {
    public static void main(String[] args) {
        new App().run();
        System.exit(0);
    }

    public void run() {
        EntityManager em = Persistence.createEntityManagerFactory("JPAUNIT")
                .createEntityManager();

        try {
            em.getTransaction().begin();

            Head p = new Head();
            p.setName("myname");
            em.persist(p);

            Head p2 = new Head();
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
