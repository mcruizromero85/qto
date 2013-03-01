package com.qto.web.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Gamer {

    @NotNull
    @Size(min = 3, max = 15)
    private String nick;

    @NotNull
    @Size(min = 5, max = 120)
    @Pattern(regexp = "^[0-9A-Za-z_\\-\\.]+@[0-9a-z\\-\\.]+\\.[a-z]{2,4}$")
    private String email;
}
