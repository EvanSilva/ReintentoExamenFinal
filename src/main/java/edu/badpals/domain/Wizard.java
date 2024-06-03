package edu.badpals.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "t_wizards")
public class Wizard extends PanacheEntityBase {

    @Id
    @Column (name = "wizard_name")
    private String name = "";

    @Column (name = "wizard_dexterity")
    private int dexterity = 0;

    @Column (name = "wizard_person")
    @Enumerated(EnumType.STRING)
    private WizardPersona person ;

    public Wizard(String name, Integer dexterity, WizardPersona person) {
        this.name = name;
        this.dexterity = dexterity;
        this.person = person;
    }

    public Wizard() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    public WizardPersona getPerson() {
        return person;
    }

    public void setPerson(WizardPersona person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "name='" + name + '\'' +
                ", dexterity=" + dexterity +
                ", person='" + person + '\'' +
                '}';
    }
}
