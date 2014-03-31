package com.github.yukihane.jpa_template;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.github.yukihane.jpa_template.entity.Parent;

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
