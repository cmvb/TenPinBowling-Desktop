package co.com.cmvb.tpb.tenpinbowling.enums;

import lombok.Getter;

public enum ESeveridadMensaje {
    DEFAULT("default"),
    INFO("info"),
    SUCCESS("success"),
    WARNING("warning"),
    DANGER("danger");

    @Getter
    private final String nombre;

    private ESeveridadMensaje(String nombre) {
        this.nombre = nombre;
    }
}
