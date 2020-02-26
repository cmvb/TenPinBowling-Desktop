package co.com.cmvb.tpb.tenpinbowling.configuracion;

import java.io.Serializable;
import lombok.Getter;

public class CoreException extends Exception implements Serializable {

    private static final long serialVersionUID = -5603867528130258910L;
    private Integer httpStatusCode;

    @Getter
    private String mensajeUsuario;

    public CoreException() {
    }

    public CoreException(String message) {
        super(message);
    }

    public CoreException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoreException(Throwable cause) {
        super(cause);
    }

    public CoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CoreException(String message, Throwable cause, Integer httpStatusCode) {
        super(message, cause);
        this.httpStatusCode = httpStatusCode;
    }

    public Integer getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(Integer httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

}
