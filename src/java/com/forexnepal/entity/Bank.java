/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author anuz
 */
@Entity
@Table(name = "bank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bank.findAll", query = "SELECT b FROM Bank b"),
    @NamedQuery(name = "Bank.findByBankId", query = "SELECT b FROM Bank b WHERE b.bankId = :bankId"),
    @NamedQuery(name = "Bank.findByBankName", query = "SELECT b FROM Bank b WHERE b.bankName = :bankName"),
    @NamedQuery(name = "Bank.findByAddress", query = "SELECT b FROM Bank b WHERE b.address = :address"),
    @NamedQuery(name = "Bank.findByContactNo", query = "SELECT b FROM Bank b WHERE b.contactNo = :contactNo"),
    @NamedQuery(name = "Bank.findByWebsite", query = "SELECT b FROM Bank b WHERE b.website = :website")})
public class Bank implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bank_id")
    private Integer bankId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "bank_name")
    private String bankName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "address")
    private String address;
    @Size(max = 255)
    @Column(name = "contact_no")
    private String contactNo;
    @Size(max = 255)
    @Column(name = "website")
    private String website;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankId")
    private Collection<ExchangeRates> exchangeRatesCollection;

    public Bank() {
    }

    public Bank(Integer bankId) {
        this.bankId = bankId;
    }

    public Bank(Integer bankId, String bankName, String address) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.address = address;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @XmlTransient
    public Collection<ExchangeRates> getExchangeRatesCollection() {
        return exchangeRatesCollection;
    }

    public void setExchangeRatesCollection(Collection<ExchangeRates> exchangeRatesCollection) {
        this.exchangeRatesCollection = exchangeRatesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bankId != null ? bankId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bank)) {
            return false;
        }
        Bank other = (Bank) object;
        if ((this.bankId == null && other.bankId != null) || (this.bankId != null && !this.bankId.equals(other.bankId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.forexnepal.entity.Bank[ bankId=" + bankId + " ]";
    }
    
}
