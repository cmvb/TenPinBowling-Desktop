package co.com.cmvb.tpb.tenpinbowling.constantes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ConstantesGenerales {

    public static final String FORMATO_FECHA_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String FORMATO_FECHA_DD_MM_YYYY = "dd/MM/yyyy";
    public static final String FORMATO_FECHA_HORA_DD_MM_YYYY_HH_MM_SS = "dd-MM-yyyy HH:mm:ss";
    public static final LocalDate FECHA_DEFECTO = LocalDate.of(0001, 01, 01);
    public static final LocalDateTime FECHA_HORA_DEFECTO = LocalDateTime.parse(LocalDate.parse("01/01/0001", DateTimeFormatter.ofPattern(FORMATO_FECHA_DD_MM_YYYY)) + " 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    public static final int REGISTROS_MOSTRADOS_POR_CONSULTA = 5;
    public static final String EXT_TXT = "txt";
    public static final String EXT_CSV = ".csv";
    public static final String SEPARADOR_PIPE = "|";
    public static final String SEPARADOR_COMA = ",";
    public static final String SEPARADOR_RUTA = "/";
    public static final char SEPARADOR_PUNTO_COMA = ';';
    public static final Long INICIAREN0 = 0L;
    public static final Long INICIAREN1 = 1L;
    public static final String HEADER_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
}
