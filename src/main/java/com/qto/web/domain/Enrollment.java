package com.qto.web.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Query;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Enrollment {

    @ManyToOne
    @JoinColumn(name = "id_gamer")
    private Gamer gamer;

    @ManyToOne
    @JoinColumn(name = "id_tournament")
    private Tournament tournament;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Calendar registrationDate;
    
    public static List<Enrollment> findEnrollmentsByTournament(Long idTournament) {
        
//    	CriteriaBuilder criteriaBuilder =  entityManager().getCriteriaBuilder();  
//    	
//    	CriteriaQuery criteriaQuery= criteriaBuilder.createQuery();
//    	
//    	Root<Enrollment> enrollment = criteriaQuery.from(Enrollment.class);
//    	criteriaQuery.select( criteriaQuery.from(Enrollment.class).join("").  )
//    	
//    	createQuery("SELECT e FROM Enrollment e where e.tournament.id ="+idTournament);
//    	q.
//    	1
//    	2
//    	3
//    	Criteria criteria = session.createCriteria(Club.class);
//    	    criteria.setFetchMode("Team", FetchMode.JOIN);
//    	    List list = criteria.list();
//    	
//   	 *     CriteriaQuery&#060;String&#062; q = cb.createQuery(String.class);
//   	 *     Root&#060;Order&#062; order = q.from(Order.class);
//   	 *     q.select(order.get("shippingAddress").&#060;String&#062;get("state"));
//   	 *
//   	 *     CriteriaQuery<Product> q2 = cb.createQuery(Product.class);
//   	 *     q2.select(q2.from(Order.class)
//   	 *                 .join("items")
//   	 *                 .<Item,Product>join("product"));
    	
//    	entityManager().createQuery(
    	
        return entityManager().createQuery("SELECT e FROM Enrollment e, Gamer g where g.id = e.gamer.id and e.tournament.id ="+idTournament, Enrollment.class).getResultList();
    }
}
