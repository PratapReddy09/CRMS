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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "FUEL_DETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuelDetails.findAll", query = "SELECT f FROM FuelDetails f")
    , @NamedQuery(name = "FuelDetails.findByFId", query = "SELECT f FROM FuelDetails f WHERE f.fId = :fId")
    , @NamedQuery(name = "FuelDetails.findByFDate", query = "SELECT f FROM FuelDetails f WHERE f.fDate = :fDate")
    , @NamedQuery(name = "FuelDetails.findByQty", query = "SELECT f FROM FuelDetails f WHERE f.qty = :qty")
    , @NamedQuery(name = "FuelDetails.findByCost", query = "SELECT f FROM FuelDetails f WHERE f.cost = :cost")})
public class FuelDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "F_ID")
    private Integer fId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "F_DATE")
    @Temporal(TemporalType.DATE)
    private Date fDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QTY")
    private double qty;
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

    public FuelDetails() {
    }

    public FuelDetails(Integer fId) {
        this.fId = fId;
    }

    public FuelDetails(Integer fId, Date fDate, double qty, double cost) {
        this.fId = fId;
        this.fDate = fDate;
        this.qty = qty;
        this.cost = cost;
    }

    public Integer getFId() {
        return fId;
    }

    public void setFId(Integer fId) {
        this.fId = fId;
    }

    public Date getFDate() {
        return fDate;
    }

    public void setFDate(Date fDate) {
        this.fDate = fDate;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
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
        hash += (fId != null ? fId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuelDetails)) {
            return false;
        }
        FuelDetails other = (FuelDetails) object;
        if ((this.fId == null && other.fId != null) || (this.fId != null && !this.fId.equals(other.fId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return fId +"";
    }
    
}
