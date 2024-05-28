package com.jovioakz;

import javafx.beans.property.SimpleStringProperty;

public class BookingDataRow {
    public final SimpleStringProperty clientName;
    public final SimpleStringProperty dataStart;
    public final SimpleStringProperty dataEnd;
    public final SimpleStringProperty checkIn;
    public final SimpleStringProperty checkOut;

    public BookingDataRow(String clientName, String dataStart, String dataEnd,
        String checkIn, String checkOut) {
        
        this.clientName = new SimpleStringProperty(clientName);
        this.dataStart = new SimpleStringProperty(dataStart);
        this.dataEnd = new SimpleStringProperty(dataEnd);
        this.checkIn = new SimpleStringProperty(checkIn);
        this.checkOut = new SimpleStringProperty(checkOut);
    }

    
}
