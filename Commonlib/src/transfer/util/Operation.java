/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer.util;


public interface Operation {
    public static final int OPERATION_LOGIN = 1;
    public static final int OPERATION_GET_ALL_SPECIES = 2;
    public static final int OPERATION_SEARCH_PATIENTS = 3;
    public static final int OPERATION_SAVE_PATIENT = 4;
    public static final int OPERATION_UPDATE_PATIENT = 5;
    public static final int OPERATION_DELETE_PATIENT = 6;
    public static final int OPERATION_GET_ALL_PATIENTS=7;//Da li mi treba?
    public static final int OPERATION_GET_ALL_DIAGNOSIS = 8;
    public static final int OPERATION_GET_ALL_SERVICES = 9;
    public static final int OPERATION_SAVE_APPOINTMENT = 10;
    public static final int OPERATION_SEARCH_APPOINTMENTS = 11;
    public static final int OPERATION_UPDATE_APPOINTMENT = 12;
    public static final int OPERATION_LOGOUT = 13;
    public static final int OPERATION_GET_ALL_APPOINTMENTS=14;//Da li mi je potrebno?
    
}
