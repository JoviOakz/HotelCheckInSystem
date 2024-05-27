package com.jovioakz.model;

import java.sql.*;

import javax.persistence.*;

@Entity
@Table(name = "BookingData")
public class BookingData {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "ClientName")
    private String clientname;

    @Column(name = "DataStart")
    private Date datastart;

    @Column(name = "DataEnd")
    private Date dataend;

    @Column(name = "CheckIn")
    private Time checkin;

    @Column(name = "CheckOut")
    private Time checkout;

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

    public Date getDataStart() {
        return this.datastart;
    }

    public void setDataStart(Date value) {
        this.datastart = value;
    }

    public Date getDataEnd() {
        return this.dataend;
    }

    public void setDataEnd(Date value) {
        this.dataend = value;
    }

    public Time getCheckIn() {
        return this.checkin;
    }

    public void setCheckIn(Time value) {
        this.checkin = value;
    }

    public Time getCheckOut() {
        return this.checkout;
    }

    public void setCheckOut(Time value) {
        this.checkout = value;
    }
}