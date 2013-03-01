package com.qto.web.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    private Gamer competitor;

    @ManyToOne
    @JoinColumn(name = "id_tournament")
    private Tournament tournament;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Calendar registrationDate;
    
    public static List<Enrollment> findEnrollmentsByTournament(Long idTournament) {
        
        return entityManager().createQuery("SELECT e FROM Enrollment e, Gamer g, tournament t where g.id = e.gamer.id and t.id = e.tournament.id and e.tournament.id "+idTournament, Enrollment.class).getResultList();
    }
}
