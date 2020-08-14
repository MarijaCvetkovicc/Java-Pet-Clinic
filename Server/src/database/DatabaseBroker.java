/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import database.connection.DatabaseConnection;
import domain.GeneralDomainObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DatabaseBroker implements IDatabaseBroker {

    Connection connection;
    Statement st;

    public DatabaseBroker() {

    }

    @Override
    public List<GeneralDomainObject> findRecords(GeneralDomainObject gdo, GeneralDomainObject gdo1) throws Exception {
        List<GeneralDomainObject> list = new LinkedList<>();
        ResultSet rs = null;
        ResultSet rs1 = null;
        String query = "SELECT *" + " FROM " + gdo.getTableName() + gdo.getJoinClauseFind()
                + " WHERE " + gdo.getWhereConditionFind();
        System.out.println(query);
        boolean signal = false;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                signal = true;
                if (gdo1 == null) {
                    list = gdo.getNewRecords(rs);
                } else {
                    list = gdo.getNewRecords(rs);
                    for (GeneralDomainObject g : list) {
                        query = "SELECT * FROM " + gdo1.getTableName() + gdo1.getJoinClauseFind() + " WHERE " + gdo1.getWhereConditionFind() + " = " + g.getWhereConditionFindList();
                        rs1 = st.executeQuery(query);
                        System.out.println(query);
                        g.createList(rs1);
                    }
                }
            }

            if (signal == false) {
                String first = gdo.getTableName().substring(0, 1).toUpperCase();
                String s = first + gdo.getTableName().substring(1);
                throw new Exception(s + " does not exist!");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<GeneralDomainObject> getAll(GeneralDomainObject gdo) throws Exception {
        List<GeneralDomainObject> list;
        try {
            String query = "SELECT * FROM " + gdo.getTableName();
            System.out.println(query);
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            list = gdo.getList(rs);
            rs.close();
            st.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
     public List<GeneralDomainObject> getAllComplex(GeneralDomainObject gdo, GeneralDomainObject gdo1) throws Exception {
          List<GeneralDomainObject> list = new LinkedList<>();
        ResultSet rs = null;
        ResultSet rs1 = null;
        String query = "SELECT *" + " FROM " + gdo.getTableName() + gdo.getJoinClauseFind();
        System.out.println(query);
        boolean signal = false;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                signal = true;
                if (gdo1 == null) {
                    list = gdo.getNewRecords(rs);
                } else {
                    list = gdo.getNewRecords(rs);
                    for (GeneralDomainObject g : list) {
                        query = "SELECT * FROM " + gdo1.getTableName() + gdo1.getJoinClauseFind() ;
                        rs1 = st.executeQuery(query);
                        System.out.println(query);
                        g.createList(rs1);
                    }
                }
            }

            if (signal == false) {
                String first = gdo.getTableName().substring(0, 1).toUpperCase();
                String s = first + gdo.getTableName().substring(1);
                throw new Exception(s + " does not exist!");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    @Override
    public void saveRecord(GeneralDomainObject gdo) throws Exception {
        try {
            String query = "INSERT INTO " + gdo.getTableName() + gdo.getColumnNames()
                    + " VALUES " + "(" + gdo.getAtrValue1() + ")";
            System.out.println(query);
            st = connection.createStatement();
            st.executeUpdate(query);
            st.close();
        } catch (Exception ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Can't save " + gdo.getTableName());
        }
    }

    @Override
    public void updateRecord(GeneralDomainObject gdo) throws Exception {
        try {
            String query = "UPDATE " + gdo.getTableName() 
                    + " SET " + gdo.setAtrValue()
                    + " WHERE " + gdo.getWhereConditionUpdate();
            System.out.println(query);
            st = connection.createStatement();
            st.executeUpdate(query);
            st.close();
        } catch (Exception ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Can't update " + gdo.getTableName());

        }

    }

    @Override
    public void deleteRecord(GeneralDomainObject gdo) throws Exception {
        try {
            String query = "DELETE FROM " + gdo.getTableName()
                    + " WHERE " + gdo.getWhereConditionUpdate();
            System.out.println(query);
            st = connection.createStatement();
            st.executeUpdate(query);
            st.close();
        } catch (Exception ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Can't delete " + gdo.getTableName());

        }
    }

    @Override
    public void saveComplexRecord(GeneralDomainObject gdo) throws Exception {
        int key = 0;
        try {
            st = connection.createStatement();
            String query = "INSERT INTO " + gdo.getTableName() + gdo.getColumnNames() + " VALUES "
                    + gdo.getAtrValue1();
            System.out.println(query);
            st.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = st.getGeneratedKeys();
            if (rs != null && rs.next()) {
                key = rs.getInt(1);
            }
            for (GeneralDomainObject gdo1 : gdo.getList()) {
                query = "INSERT INTO " + gdo1.getTableName() + gdo1.getColumnNames() + " VALUES ("
                        + key + ", " + gdo1.getAtrValue2() + ")";
                System.out.println(query);
                st.executeUpdate(query);

            }
            st.close();
        } catch (Exception ex) {
            connection.rollback();
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Can't save " + gdo.getTableName());
        }

        
    }


    @Override
    public void commitTransaction() {
        try {
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void rollbackTransaction() {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void startTransaction() {
        try {
            connection = DatabaseConnection.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
