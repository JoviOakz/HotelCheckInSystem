package com.jovioakz.model;

import java.sql.*;

import javax.persistence.*;

import com.jovioakz.BookingDataRow;

import javafx.beans.property.SimpleStringProperty;

@Entity
@Table(name = "BookingData")
public class BookingData {
    

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "ClientName")
    private String clientname;

    @Column(name = "DataStart")
    private java.util.Date datastart;

    @Column(name = "DataEnd")
    private java.util.Date dataend;

    @Column(name = "CheckIn")
    private String checkin;

    @Column(name = "CheckOut")
    private String checkout;

    public Long getId() {
        return this.id;
    }

    public void setId(Long value) {
        this.id = value;
    }

    public String getClientName() {
        return this.clientname;
    }

    public void setClientName(String value) {
        this.clientname = value;
    }

    public java.util.Date getDataStart() {
        return this.datastart;
    }

    public void setDataStart(java.util.Date value) {
        this.datastart = value;
    }

    public java.util.Date getDataEnd() {
        return this.dataend;
    }

    public void setDataEnd(java.util.Date value) {
        this.dataend = value;
    }

    public String getCheckIn() {
        return this.checkin;
    }

    public void setCheckIn(String value) {
        this.checkin = value;
    }

    public String getCheckOut() {
        return this.checkout;
    }

    public void setCheckOut(String value) {
        this.checkout = value;
    }
}