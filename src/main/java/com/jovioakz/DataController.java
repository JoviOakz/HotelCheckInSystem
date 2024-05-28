package com.jovioakz;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jovioakz.model.BookingData;

public class DataController {
    public static void insertData(BookingData data) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("insert into BookingData(ClientName, DataStart, DataEnd, CheckIn, CheckOut) " +
                                          "values (':ClientName', ':DataStart', ':DataEnd', ':CheckIn', ':CheckOut')");

        query.setParameter("ClientName", data.getClientName());
        query.setParameter("DataStart", data.getDataStart());
        query.setParameter("DataEnd", data.getDataEnd());
        query.setParameter("CheckIn", data.getCheckIn());
        query.setParameter("CheckOut", data.getCheckOut());

        int updated = query.executeUpdate();
        
        transaction.commit();
    }
}
