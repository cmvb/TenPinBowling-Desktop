package co.com.cmvb.tpb.tenpinbowling.enums.excepcion;

public enum ETipoExcepcion {
    CONEXION("Conexión"),
    BASE_DATOS("Base de Datos"),
    FUNCIONAL("Funcional"),
    INTERNO("Interno"),
    WEB_SERVICES("Web Service");

    private final String nombre;

    public String getNombre() {
        return nombre;
    }

    private ETipoExcepcion(String nombre) {
        this.nombre = nombre;
    }
}
