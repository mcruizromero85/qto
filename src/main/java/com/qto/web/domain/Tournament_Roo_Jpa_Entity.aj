// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.qto.web.domain;

import com.qto.web.domain.Tournament;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect Tournament_Roo_Jpa_Entity {
    
    declare @type: Tournament: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Tournament.id;
    
    @Version
    @Column(name = "version")
    private Integer Tournament.version;
    
    public Long Tournament.getId() {
        return this.id;
    }
    
    public void Tournament.setId(Long id) {
        this.id = id;
    }
    
    public Integer Tournament.getVersion() {
        return this.version;
    }
    
    public void Tournament.setVersion(Integer version) {
        this.version = version;
    }
    
}
