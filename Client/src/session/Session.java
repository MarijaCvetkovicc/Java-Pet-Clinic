/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import domain.Veterinar;


public class Session {

    private static Session instance;
    private Veterinar currentVet;
    private static int currentUseCase;
    private static Object useCaseParams;

    private Session() {
       
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public Veterinar getCurrentVet() {
        return currentVet;
    }

    public void setCurrentVet(Veterinar currentVet) {
        this.currentVet = currentVet;
    }

    public void setCurrentUseCase(int currentUseCase) {
        this.currentUseCase = currentUseCase;
    }

    public int getCurrentUseCase() {
        return currentUseCase;
    }

    public Object getUseCaseParams() {
        return useCaseParams;
    }

    public  void setUseCaseParams(Object useCaseParams) {
        Session.useCaseParams = useCaseParams;
    }
   
}
