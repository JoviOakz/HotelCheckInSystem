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

        // Cria uma query com um parâmetro
        Query query = session.createQuery("insert into BookingData values (:ClientName, :DataStart, :DataEnd, :CheckIn, :CheckOut)");
        query.setParameter("ClientName", data.getClientName());
        query.setParameter("DataStart", data.getDataStart());
        query.setParameter("DataEnd", data.getDataEnd());
        query.setParameter("CheckIn", data.getCheckIn());
        query.setParameter("CheckOut", data.getCheckOut());

        // Chama a query
        @SuppressWarnings({ "unchecked", "unused" })
        List<BookingData> result = query.list();
        
        transaction.commit();
    }
}
