/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "DRIVER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Driver.findAll", query = "SELECT d FROM Driver d")
    , @NamedQuery(name = "Driver.findByDId", query = "SELECT d FROM Driver d WHERE d.dId = :dId")
    , @NamedQuery(name = "Driver.findByDName", query = "SELECT d FROM Driver d WHERE d.dName = :dName")
    , @NamedQuery(name = "Driver.findByAddress", query = "SELECT d FROM Driver d WHERE d.address = :address")
    , @NamedQuery(name = "Driver.findByCity", query = "SELECT d FROM Driver d WHERE d.city = :city")
    , @NamedQuery(name = "Driver.findByDState", query = "SELECT d FROM Driver d WHERE d.dState = :dState")
    , @NamedQuery(name = "Driver.findByMobile", query = "SELECT d FROM Driver d WHERE d.mobile = :mobile")
    , @NamedQuery(name = "Driver.findByLicNo", query = "SELECT d FROM Driver d WHERE d.licNo = :licNo")
    , @NamedQuery(name = "Driver.findByLicExp", query = "SELECT d FROM Driver d WHERE d.licExp = :licExp")})
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "D_ID")
    private Integer dId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "D_NAME")
    private String dName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "D_STATE")
    private String dState;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MOBILE")
    private String mobile;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LIC_NO")
    private String licNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LIC_EXP")
    @Temporal(TemporalType.DATE)
    private Date licExp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dId")
    private Collection<Bookings> bookingsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dId")
    private Collection<Repair> repairCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dId")
    private Collection<FuelDetails> fuelDetailsCollection;

    public Driver() {
    }

    public Driver(Integer dId) {
        this.dId = dId;
    }

    public Driver(Integer dId, String dName, String address, String city, String dState, String mobile, String licNo, Date licExp) {
        this.dId = dId;
        this.dName = dName;
        this.address = address;
        this.city = city;
        this.dState = dState;
        this.mobile = mobile;
        this.licNo = licNo;
        this.licExp = licExp;
    }

    public Integer getDId() {
        return dId;
    }

    public void setDId(Integer dId) {
        this.dId = dId;
    }

    public String getDName() {
        return dName;
    }

    public void setDName(String dName) {
        this.dName = dName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDState() {
        return dState;
    }

    public void setDState(String dState) {
        this.dState = dState;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLicNo() {
        return licNo;
    }

    public void setLicNo(String licNo) {
        this.licNo = licNo;
    }

    public Date getLicExp() {
        return licExp;
    }

    public void setLicExp(Date licExp) {
        this.licExp = licExp;
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
        hash += (dId != null ? dId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Driver)) {
            return false;
        }
        Driver other = (Driver) object;
        if ((this.dId == null && other.dId != null) || (this.dId != null && !this.dId.equals(other.dId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return dId +"";
    }
    
}
