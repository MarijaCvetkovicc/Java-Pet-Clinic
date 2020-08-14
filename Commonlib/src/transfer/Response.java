/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;
import transfer.util.ResponseStatus;


public class Response implements Serializable{
    private ResponseStatus status;
    private Object data;
    private Object error;

    public Response() {
    }

    public Response(ResponseStatus responseSatus, Object data, Object error) {
        this.status = responseSatus;
        this.data = data;
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public Object getError() {
        return error;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public void setStatus(ResponseStatus responseSatus) {
        this.status = responseSatus;
    }
       
}
