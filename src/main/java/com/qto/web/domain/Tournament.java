package com.qto.web.domain;

import java.util.Calendar;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Tournament {

    @NotNull
    @Size(min = 15, max = 50)
    private String title;

    @NotNull
    @Size(min = 50, max = 200)
    private String description;

    private String urlLogo;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Calendar confirm;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Calendar init;

    @NotNull
    @Pattern(regexp = "gb|g|b")
    private String modality;

    @NotNull
    @Pattern(regexp = "Starcraft2|WarcraftDota|HoN|LoL|Dota2|CounterStrike")
    private String game;
    
 

    @ManyToOne
    @JoinColumn(name = "id_gamer")
    private Gamer organizador;


}
