package hu.poszeidon.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@Table(name="PERSISTENT_LOGINS")
public class PersistentLogin implements Serializable{ 
	
    @Id
    private String series;
 
    @Column(name="USERNAME", unique=true, nullable=false)
    private String username;
     
    @Column(name="TOKEN", unique=true, nullable=false)
    private String token;
     
    @Temporal(TemporalType.TIMESTAMP)
    private java.time.ZonedDateTime last_used;
 

}
