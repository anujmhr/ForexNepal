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
@Table(name = "currency")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Currency.findAll", query = "SELECT c FROM Currency c"),
    @NamedQuery(name = "Currency.findByCurrencyId", query = "SELECT c FROM Currency c WHERE c.currencyId = :currencyId"),
    @NamedQuery(name = "Currency.findByCurrencyName", query = "SELECT c FROM Currency c WHERE c.currencyName = :currencyName"),
    @NamedQuery(name = "Currency.findByCurrencyCode", query = "SELECT c FROM Currency c WHERE c.currencyCode = :currencyCode")})
public class Currency implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "currency_id")
    private Integer currencyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "currency_name")
    private String currencyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "currency_code")
    private String currencyCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currencyId")
    private Collection<ExchangeRates> exchangeRatesCollection;

    public Currency() {
    }

    public Currency(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Currency(Integer currencyId, String currencyName, String currencyCode) {
        this.currencyId = currencyId;
        this.currencyName = currencyName;
        this.currencyCode = currencyCode;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (currencyId != null ? currencyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Currency)) {
            return false;
        }
        Currency other = (Currency) object;
        if ((this.currencyId == null && other.currencyId != null) || (this.currencyId != null && !this.currencyId.equals(other.currencyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.forexnepal.entity.Currency[ currencyId=" + currencyId + " ]";
    }
    
}
