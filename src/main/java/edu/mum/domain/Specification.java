/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.domain;

import edu.mum.domain.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Type;
import org.joda.money.Money;
import org.joda.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Yoni
 */
@Entity
@Table(name = "Specification")
public class Specification {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "year", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate year;
    
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "bestBefore", nullable = false)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate bestBefore;
    
     
    @Columns(columns = {@Column(name = "priceCurrency"), @Column(name = "price")})
    @Type(type = "org.jadira.usertype.moneyandcurrency.joda.PersistentMoneyAmountAndCurrency")
    private Money estimatedPrice; 
    
    
    @OneToOne(mappedBy="specification", cascade = CascadeType.PERSIST)
    private Item item;

   

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(LocalDate bestBefore) {
        this.bestBefore = bestBefore;
    }

    public Money getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(Money estimatedPice) {
        this.estimatedPrice = estimatedPice;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Specification{" + "id=" + id + ", year=" + year + ", bestBefore=" + bestBefore + ", estimatedPice=" + estimatedPrice + ", item=" + item + '}';
       
    }
    
    
    
    

    
}
