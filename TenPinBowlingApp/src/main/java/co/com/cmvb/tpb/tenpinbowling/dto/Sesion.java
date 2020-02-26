package co.com.cmvb.tpb.tenpinbowling.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Sesion {

    public static final String ESTADO_ACTIVO_TEXTO = "A";
    public static final String ESTADO_INACTIVO_TEXTO = "I";

    @Getter
    @Setter
    private String idUsuario;

    @Getter
    @Setter
    private String usuario;

    @Getter
    @Setter
    private String nombre;

    public Sesion() {
    }

    public Sesion(String idUsuario, String usuario, String nombre) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.nombre = nombre;
    }
}
