package edu.badpals.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table (name = "t_orders")
public class Order extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ord_id")
    private long id = 0L;

    @ManyToOne
    @JoinColumn (name = "ord_wizard")
    private Wizard wizard;

    @OneToOne
    @JoinColumn (name = "ord_item")
    private  MagicalItem magicalItem;

    public Order(Wizard wizard, MagicalItem magicalItem) {
        this.wizard = wizard;
        this.magicalItem = magicalItem;
    }

    public Order() {
    }

    public Wizard getWizard() {
        return wizard;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }

    public MagicalItem getMagicalItem() {
        return magicalItem;
    }

    public void setMagicalItem(MagicalItem magicalItem) {
        this.magicalItem = magicalItem;
    }

    @Override
    public String toString() {
        return "Order{" +
                "wizard=" + wizard +
                ", magicalItem=" + magicalItem +
                '}';
    }
}
