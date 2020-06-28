
package com.example.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "affecter_type_avancements")
public class Affecter_type_avancement {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @NotNull
	@ManyToOne
	@JoinColumn(name = "type", nullable = false)
    private Type_avancement type;


    @NotNull
	@ManyToOne
	@JoinColumn(name = "id_echelon", nullable = false)
    private Echelon id_echelon;

   

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Type_avancement getType() {
        return type;
    }

    public void setType(Type_avancement type) {
        this.type = type;
    }

    public Echelon getId_echelon() {
        return id_echelon;
    }

    public void setId_echelon(Echelon id_echelon) {
        this.id_echelon = id_echelon;
    }

    public Affecter_type_avancement(@NotNull Type_avancement type, @NotNull Echelon id_echelon) {
        this.type = type;
        this.id_echelon = id_echelon;
    }

    public Affecter_type_avancement() {
    }

    @Override
    public String toString() {
        return "Affecter_type_avancement [id=" + id + ", id_echelon=" + id_echelon + ", type=" + type + "]";
    }

  

    
   

    
    

	
}