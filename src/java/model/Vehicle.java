/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "VEHICLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v")
    , @NamedQuery(name = "Vehicle.findByVId", query = "SELECT v FROM Vehicle v WHERE v.vId = :vId")
    , @NamedQuery(name = "Vehicle.findByVName", query = "SELECT v FROM Vehicle v WHERE v.vName = :vName")
    , @NamedQuery(name = "Vehicle.findByVType", query = "SELECT v FROM Vehicle v WHERE v.vType = :vType")
    , @NamedQuery(name = "Vehicle.findByCompany", query = "SELECT v FROM Vehicle v WHERE v.company = :company")
    , @NamedQuery(name = "Vehicle.findByPrice", query = "SELECT v FROM Vehicle v WHERE v.price = :price")})
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "V_ID")
    private String vId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "V_NAME")
    private String vName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "V_TYPE")
    private String vType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "COMPANY")
    private String company;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private double price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vId")
    private Collection<Bookings> bookingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vId")
    private Collection<Repair> repairCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vId")
    private Collection<FuelDetails> fuelDetailsCollection;

    public Vehicle() {
    }

    public Vehicle(String vId) {
        this.vId = vId;
    }

    public Vehicle(String vId, String vName, String vType, String company, double price) {
        this.vId = vId;
        this.vName = vName;
        this.vType = vType;
        this.company = company;
        this.price = price;
    }

    public String getVId() {
        return vId;
    }

    public void setVId(String vId) {
        this.vId = vId;
    }

    public String getVName() {
        return vName;
    }

    public void setVName(String vName) {
        this.vName = vName;
    }

    public String getVType() {
        return vType;
    }

    public void setVType(String vType) {
        this.vType = vType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<Bookings> getBookingsCollection() {
        return bookingsCollection;
    }

    public void setBookingsCollection(Collection<Bookings> bookingsCollection) {
        this.bookingsCollection = bookingsCollection;
    }

    @XmlTransient
    public Collection<Repair> getRepairCollection() {
        return repairCollection;
    }

    public void setRepairCollection(Collection<Repair> repairCollection) {
        this.repairCollection = repairCollection;
    }

    @XmlTransient
    public Collection<FuelDetails> getFuelDetailsCollection() {
        return fuelDetailsCollection;
    }

    public void setFuelDetailsCollection(Collection<FuelDetails> fuelDetailsCollection) {
        this.fuelDetailsCollection = fuelDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vId != null ? vId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.vId == null && other.vId != null) || (this.vId != null && !this.vId.equals(other.vId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return vId+"";
    }
    
}
