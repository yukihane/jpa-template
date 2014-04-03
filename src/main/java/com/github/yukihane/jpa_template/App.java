package com.github.yukihane.jpa_template;

import java.awt.HeadlessException;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Subgraph;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.github.yukihane.jpa_template.entity.Bridge;
import com.github.yukihane.jpa_template.entity.Bridge_;
import com.github.yukihane.jpa_template.entity.Child1;
import com.github.yukihane.jpa_template.entity.Child2;
import com.github.yukihane.jpa_template.entity.Cusp;
import com.github.yukihane.jpa_template.entity.Emb;
import com.github.yukihane.jpa_template.entity.Head;
import com.github.yukihane.jpa_template.entity.Head_;
import com.github.yukihane.jpa_template.entity.OptionalBranch;
import com.github.yukihane.jpa_template.entity.Parent;
import com.github.yukihane.jpa_template.entity.Parent_;

/**
 * Hello world!
 * 
 */
public class App {

    private long id;

    public static void main(String[] args) {
        try {
            new App().run();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }

    public void run() {
        EntityManager em = Persistence.createEntityManagerFactory("JPAUNIT")
                .createEntityManager();

        try {
            em.getTransaction().begin();
            operateEntities(em);
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            em.close();
        }

        em = Persistence.createEntityManagerFactory("JPAUNIT")
                .createEntityManager();

        try {
            em.getTransaction().begin();
            queryEntities(em);
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            em.close();
        }
    }

    private void operateEntities(EntityManager em) {

        Cusp cusp = new Cusp("cusp1");

        Emb emb = new Emb("emb1");

        Child1 c1 = new Child1("c1");
        Child2 c2 = new Child2("c2");

        Bridge b = new Bridge();
        b.setName("bridge1");

        OptionalBranch ob = new OptionalBranch();
        ob.setName("optional bridge 1");

        Head h = new Head();
        h.setName("myname1");

        emb.setCusp(cusp);
        c1.setEmb(emb);
        b.addParents(c1);
        b.addParents(c2);
        h.setBridge(b);
        h.setOptionalBranch(ob);

        em.persist(h);

        this.id = h.getId();

    }

    private void queryEntities(EntityManager em) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Head> cq = cb.createQuery(Head.class);
        Root<Head> head = cq.from(Head.class);
        cq.select(head);
        Path<Long> id = head.<Long> get("id");
        Predicate idExp = cb.equal(id, this.id);
        cq.where(idExp);

        // head.fetch("bridge");
        // head.fetch("optionalBranch", JoinType.LEFT);

        EntityGraph<Head> graph = em.createEntityGraph(Head.class);
        graph.addAttributeNodes(Head_.bridge, Head_.optionalBranch);
        Subgraph<Bridge> bridgeGraph = graph.addSubgraph(Head_.bridge);
        bridgeGraph.addAttributeNodes(Bridge_.parents);
        Subgraph<Child1> aa = bridgeGraph.addSubgraph("parents", Child1.class);



        TypedQuery<Head> q = em.createQuery(cq);
        q.setHint("javax.persistence.fetchgraph", graph);
        List<Head> l = q.getResultList();

        System.out.println(l.get(0).getBridge().getName());
    }
}
