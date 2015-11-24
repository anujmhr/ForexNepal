/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forexnepal.entity;

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
 * @author anuz
 */
@Entity
@Table(name = "exchange_rates")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExchangeRates.findAll", query = "SELECT e FROM ExchangeRates e"),
    @NamedQuery(name = "ExchangeRates.findByRecordId", query = "SELECT e FROM ExchangeRates e WHERE e.recordId = :recordId"),
    @NamedQuery(name = "ExchangeRates.findByUnit", query = "SELECT e FROM ExchangeRates e WHERE e.unit = :unit"),
    @NamedQuery(name = "ExchangeRates.findBySellingRate", query = "SELECT e FROM ExchangeRates e WHERE e.sellingRate = :sellingRate"),
    @NamedQuery(name = "ExchangeRates.findByBuyingRate", query = "SELECT e FROM ExchangeRates e WHERE e.buyingRate = :buyingRate"),
    @NamedQuery(name = "ExchangeRates.findByForexDate", query = "SELECT e FROM ExchangeRates e WHERE e.forexDate = :forexDate"),
    @NamedQuery(name = "ExchangeRates.findByForexTime", query = "SELECT e FROM ExchangeRates e WHERE e.forexTime = :forexTime")})
public class ExchangeRates implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "record_id")
    private Integer recordId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unit")
    private int unit;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "selling_rate")
    private Double sellingRate;
    @Column(name = "buying_rate")
    private Double buyingRate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "forex_date")
    @Temporal(TemporalType.DATE)
    private Date forexDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "forex_time")
    @Temporal(TemporalType.TIME)
    private Date forexTime;
    @JoinColumn(name = "bank_id", referencedColumnName = "bank_id")
    @ManyToOne(optional = false)
    private Bank bank;
    
    @JoinColumn(name = "currency_id", referencedColumnName = "currency_id")
    @ManyToOne(optional = false)
    private Currency currency;

    public ExchangeRates() {
    }

    public ExchangeRates(Integer recordId) {
        this.recordId = recordId;
    }

    public ExchangeRates(Integer recordId, int unit, Date forexDate, Date forexTime) {
        this.recordId = recordId;
        this.unit = unit;
        this.forexDate = forexDate;
        this.forexTime = forexTime;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public Double getSellingRate() {
        return sellingRate;
    }

    public void setSellingRate(Double sellingRate) {
        this.sellingRate = sellingRate;
    }

    public Double getBuyingRate() {
        return buyingRate;
    }

    public void setBuyingRate(Double buyingRate) {
        this.buyingRate = buyingRate;
    }

    public Date getForexDate() {
        return forexDate;
    }

    public void setForexDate(Date forexDate) {
        this.forexDate = forexDate;
    }

    public Date getForexTime() {
        return forexTime;
    }

    public void setForexTime(Date forexTime) {
        this.forexTime = forexTime;
    }
    
 
    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recordId != null ? recordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExchangeRates)) {
            return false;
        }
        ExchangeRates other = (ExchangeRates) object;
        if ((this.recordId == null && other.recordId != null) || (this.recordId != null && !this.recordId.equals(other.recordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.forexnepal.entity.ExchangeRates[ recordId=" + recordId + " ]";
    }
    
}
