/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "REPAIR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Repair.findAll", query = "SELECT r FROM Repair r")
    , @NamedQuery(name = "Repair.findByRId", query = "SELECT r FROM Repair r WHERE r.rId = :rId")
    , @NamedQuery(name = "Repair.findByGName", query = "SELECT r FROM Repair r WHERE r.gName = :gName")
    , @NamedQuery(name = "Repair.findByRDate", query = "SELECT r FROM Repair r WHERE r.rDate = :rDate")
    , @NamedQuery(name = "Repair.findByCost", query = "SELECT r FROM Repair r WHERE r.cost = :cost")})
public class Repair implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "R_ID")
    private Integer rId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "G_NAME")
    private String gName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "R_DATE")
    @Temporal(TemporalType.DATE)
    private Date rDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COST")
    private double cost;
    @JoinColumn(name = "D_ID", referencedColumnName = "D_ID")
    @ManyToOne(optional = false)
    private Driver dId;
    @JoinColumn(name = "V_ID", referencedColumnName = "V_ID")
    @ManyToOne(optional = false)
    private Vehicle vId;

    public Repair() {
    }

    public Repair(Integer rId) {
        this.rId = rId;
    }

    public Repair(Integer rId, String gName, Date rDate, double cost) {
        this.rId = rId;
        this.gName = gName;
        this.rDate = rDate;
        this.cost = cost;
    }

    public Integer getRId() {
        return rId;
    }

    public void setRId(Integer rId) {
        this.rId = rId;
    }

    public String getGName() {
        return gName;
    }

    public void setGName(String gName) {
        this.gName = gName;
    }

    public Date getRDate() {
        return rDate;
    }

    public void setRDate(Date rDate) {
        this.rDate = rDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Driver getDId() {
        return dId;
    }

    public void setDId(Driver dId) {
        this.dId = dId;
    }

    public Vehicle getVId() {
        return vId;
    }

    public void setVId(Vehicle vId) {
        this.vId = vId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rId != null ? rId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Repair)) {
            return false;
        }
        Repair other = (Repair) object;
        if ((this.rId == null && other.rId != null) || (this.rId != null && !this.rId.equals(other.rId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return rId+"";
    }
    
}
