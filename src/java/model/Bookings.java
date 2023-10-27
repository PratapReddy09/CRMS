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
@Table(name = "BOOKINGS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookings.findAll", query = "SELECT b FROM Bookings b")
    , @NamedQuery(name = "Bookings.findByBId", query = "SELECT b FROM Bookings b WHERE b.bId = :bId")
    , @NamedQuery(name = "Bookings.findByPickup", query = "SELECT b FROM Bookings b WHERE b.pickup = :pickup")
    , @NamedQuery(name = "Bookings.findByDropup", query = "SELECT b FROM Bookings b WHERE b.dropup = :dropup")
    , @NamedQuery(name = "Bookings.findByBDate", query = "SELECT b FROM Bookings b WHERE b.bDate = :bDate")
    , @NamedQuery(name = "Bookings.findByKms", query = "SELECT b FROM Bookings b WHERE b.kms = :kms")
    , @NamedQuery(name = "Bookings.findByPrice", query = "SELECT b FROM Bookings b WHERE b.price = :price")})
public class Bookings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "B_ID")
    private Integer bId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PICKUP")
    private String pickup;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DROPUP")
    private String dropup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "B_DATE")
    @Temporal(TemporalType.DATE)
    private Date bDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KMS")
    private int kms;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private double price;
    @JoinColumn(name = "D_ID", referencedColumnName = "D_ID")
    @ManyToOne(optional = false)
    private Driver dId;
    @JoinColumn(name = "U_ID", referencedColumnName = "U_ID")
    @ManyToOne(optional = false)
    private Users uId;
    @JoinColumn(name = "V_ID", referencedColumnName = "V_ID")
    @ManyToOne(optional = false)
    private Vehicle vId;

    public Bookings() {
    }

    public Bookings(Integer bId) {
        this.bId = bId;
    }

    public Bookings(Integer bId, String pickup, String dropup, Date bDate, int kms, double price) {
        this.bId = bId;
        this.pickup = pickup;
        this.dropup = dropup;
        this.bDate = bDate;
        this.kms = kms;
        this.price = price;
    }

    public Integer getBId() {
        return bId;
    }

    public void setBId(Integer bId) {
        this.bId = bId;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDropup() {
        return dropup;
    }

    public void setDropup(String dropup) {
        this.dropup = dropup;
    }

    public Date getBDate() {
        return bDate;
    }

    public void setBDate(Date bDate) {
        this.bDate = bDate;
    }

    public int getKms() {
        return kms;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Driver getDId() {
        return dId;
    }

    public void setDId(Driver dId) {
        this.dId = dId;
    }

    public Users getUId() {
        return uId;
    }

    public void setUId(Users uId) {
        this.uId = uId;
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
        hash += (bId != null ? bId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookings)) {
            return false;
        }
        Bookings other = (Bookings) object;
        if ((this.bId == null && other.bId != null) || (this.bId != null && !this.bId.equals(other.bId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return bId +"";
    }
    
}
