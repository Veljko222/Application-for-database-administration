/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository.db;

import repository.Repository;

/**
 *
 * @author User
 */
public interface DbRepository<T> extends Repository<T> {
    default public void connect() throws Exception{
   DbConnectionFactory.getInstance().getConnection();
        System.out.println("db conected");
    }
default public void disconnect() throws Exception{
DbConnectionFactory.getInstance().getConnection().close();
    System.out.println("db disconected");
}
default public void commit() throws Exception{
DbConnectionFactory.getInstance().getConnection().commit() ;
}
default public void rollback() throws Exception{
DbConnectionFactory.getInstance().getConnection().rollback();
}

}