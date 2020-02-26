package co.com.cmvb.tpb.tenpinbowling.enums.excepcion;

import java.beans.PropertyVetoException;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;
import java.util.MissingResourceException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

public enum EMensajeException {

    EJBException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + EJBException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "000";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    ArithmeticException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + ArithmeticException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "001";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    ArrayIndexOutOfBoundsException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + ArrayIndexOutOfBoundsException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "002";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    ArrayStoreException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + ArrayStoreException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "003";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    ClassCastException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + ClassCastException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "004";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    ClassNotFoundException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + ClassNotFoundException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "005";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    CloneNotSupportedException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + CloneNotSupportedException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "006";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    IllegalAccessException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + IllegalAccessException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "007";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    IllegalArgumentException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + IllegalArgumentException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "008";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    IllegalMonitorStateException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + IllegalMonitorStateException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "009";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    IllegalStateException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + IllegalStateException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "010";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    IllegalThreadStateException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + IllegalThreadStateException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "011";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    IndexOutOfBoundsException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + IndexOutOfBoundsException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "012";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    InstantiationException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + InstantiationException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "013";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    InterruptedException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + " -" + InterruptedException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "014";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    NegativeArraySizeException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + NegativeArraySizeException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "015";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    NoSuchFieldException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + NoSuchFieldException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "016";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    NoSuchMethodException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + NoSuchMethodException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "017";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    NullPointerException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + NullPointerException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "018";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    NumberFormatException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + NumberFormatException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "019";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    SecurityException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + SecurityException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "020";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    StringIndexOutOfBoundsException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + StringIndexOutOfBoundsException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "021";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    UnsupportedOperationException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + UnsupportedOperationException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "022";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    ConcurrentModificationException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + ConcurrentModificationException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "023";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    EmptyStackException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + EmptyStackException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "024";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    MissingResourceException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + MissingResourceException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "025";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    NoSuchElementException {
        @Override
        public String mensaje() {
            return EX + getCode() + " -" + getType() + "-" + NoSuchElementException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "026";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    IntrospectionException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + IntrospectionException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "027";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    PropertyVetoException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + PropertyVetoException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "028";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    CharConversionException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + CharConversionException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "029";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    EOFException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + EOFException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "030";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    FileNotFoundException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + FileNotFoundException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "031";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    InterruptedIOException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + InterruptedIOException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "032";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    InvalidClassException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + InvalidClassException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "033";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    InvalidObjectException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + InvalidObjectException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "034";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    IOException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + IOException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "035";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    NotActiveException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + NotActiveException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "036";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    NotSerializableException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + NotSerializableException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "037";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    StreamCorruptedException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + StreamCorruptedException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "038";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    SyncFailedException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + SyncFailedException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "039";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    UnsupportedEncodingException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + UnsupportedEncodingException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "040";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    UTFDataFormatException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + UTFDataFormatException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "041";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    WriteAbortedException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + WriteAbortedException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "042";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    BindException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + BindException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "043";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    ConnectException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + ConnectException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "044";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.CONEXION.getNombre();
        }
    },
    MalformedURLException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + MalformedURLException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "045";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    NoRouteToHostException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + NoRouteToHostException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "046";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.CONEXION.getNombre();
        }
    },
    PortUnreachableException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + PortUnreachableException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "047";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.CONEXION.getNombre();
        }
    },
    ProtocolException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + ProtocolException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "048";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.CONEXION.getNombre();
        }
    },
    SocketException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + SocketException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "049";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.CONEXION.getNombre();
        }
    },
    SocketTimeoutException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + SocketTimeoutException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "050";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.CONEXION.getNombre();
        }
    },
    UnknownHostException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + UnknownHostException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "051";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.CONEXION.getNombre();
        }
    },
    UnknownServiceException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + UnknownServiceException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "052";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.CONEXION.getNombre();
        }
    },
    URISyntaxException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + URISyntaxException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "053";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    SQLException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + SQLException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "054";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.BASE_DATOS.getNombre();
        }
    },
    TImeOutException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + TImeOutException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "055";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.CONEXION.getNombre();
        }
    },
    NoResultException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + NoResultException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "056";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.INTERNO.getNombre();
        }
    },
    DatabaseException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + DatabaseException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "057";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.BASE_DATOS.getNombre();
        }
    },
    SQLSyntaxErrorException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + SQLSyntaxErrorException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "058";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.BASE_DATOS.getNombre();
        }
    },
    PersistenceException {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + PersistenceException.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "059";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.BASE_DATOS.getNombre();
        }
    },
    ERROR_500 {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + ERROR_500.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "060";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.WEB_SERVICES.getNombre();
        }
    },
    Connection_refused {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + Connection_refused.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "061";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.WEB_SERVICES.getNombre();
        }
    },
    Connection_reset {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + Connection_reset.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "062";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.WEB_SERVICES.getNombre();
        }
    },
    ErrorDefault {
        @Override
        public String mensaje() {
            return EX + getCode() + "-" + getType() + "-" + ErrorDefault.name() + ": %s";
        }

        @Override
        public String getCode() {
            return "063";
        }

        @Override
        public String getType() {
            return ETipoExcepcion.FUNCIONAL.getNombre();
        }
    },;

    public abstract String mensaje();

    public abstract String getType();

    public abstract String getCode();
    public static String EX = "EX";

    public static final Object EXCEPTIONDB = DatabaseException;

    public static String getMensaje(Object ex) {
        String mensaje = "";
        if (ex.equals(500)) {
            ex = ERROR_500;
        }

        if (ex instanceof ArithmeticException) {
            mensaje = ArithmeticException.mensaje();

            System.out.println(((ArithmeticException) ex).getMessage());
        } else if (ex instanceof ArrayIndexOutOfBoundsException) {
            mensaje = ArrayIndexOutOfBoundsException.mensaje();

            System.out.println(((ArrayIndexOutOfBoundsException) ex).getMessage());
        } else if (ex instanceof ArrayStoreException) {
            mensaje = ArrayStoreException.mensaje();

            System.out.println(((ArrayStoreException) ex).getMessage());
        } else if (ex instanceof ClassCastException) {
            mensaje = ClassCastException.mensaje();

            System.out.println(((ClassCastException) ex).getMessage());
        } else if (ex instanceof ClassNotFoundException) {
            mensaje = ClassNotFoundException.mensaje();

            System.out.println(((ClassNotFoundException) ex).getMessage());
        } else if (ex instanceof CloneNotSupportedException) {
            mensaje = CloneNotSupportedException.mensaje();

            System.out.println(((CloneNotSupportedException) ex).getMessage());
        } else if (ex instanceof IllegalAccessException) {
            mensaje = IllegalAccessException.mensaje();

            System.out.println(((IllegalAccessException) ex).getMessage());
        } else if (ex instanceof IllegalArgumentException) {
            mensaje = IllegalArgumentException.mensaje();

            System.out.println(((IllegalArgumentException) ex).getMessage());
        } else if (ex instanceof IllegalMonitorStateException) {
            mensaje = IllegalMonitorStateException.mensaje();

            System.out.println(((IllegalMonitorStateException) ex).getMessage());
        } else if (ex instanceof IllegalStateException) {
            mensaje = IllegalStateException.mensaje();

            System.out.println(((IllegalStateException) ex).getMessage());
        } else if (ex instanceof IllegalThreadStateException) {
            mensaje = IllegalThreadStateException.mensaje();

            System.out.println(((IllegalThreadStateException) ex).getMessage());
        } else if (ex instanceof InstantiationException) {
            mensaje = InstantiationException.mensaje();

            System.out.println(((InstantiationException) ex).getMessage());
        } else if (ex instanceof InterruptedException) {
            mensaje = InterruptedException.mensaje();

            System.out.println(((InterruptedException) ex).getMessage());
        } else if (ex instanceof NegativeArraySizeException) {
            mensaje = NegativeArraySizeException.mensaje();

            System.out.println(((NegativeArraySizeException) ex).getMessage());
        } else if (ex instanceof NoSuchFieldException) {
            mensaje = NoSuchFieldException.mensaje();

            System.out.println(((NoSuchFieldException) ex).getMessage());
        } else if (ex instanceof NoSuchMethodException) {
            mensaje = NoSuchMethodException.mensaje();

            System.out.println(((NoSuchMethodException) ex).getMessage());
        } else if (ex instanceof NullPointerException) {
            mensaje = NullPointerException.mensaje();

            System.out.println(((NullPointerException) ex).getMessage());
        } else if (ex instanceof NumberFormatException) {
            mensaje = NumberFormatException.mensaje();

            System.out.println(((NumberFormatException) ex).getMessage());
        } else if (ex instanceof SecurityException) {
            mensaje = SecurityException.mensaje();

            System.out.println(((SecurityException) ex).getMessage());
        } else if (ex instanceof StringIndexOutOfBoundsException) {
            mensaje = StringIndexOutOfBoundsException.mensaje();

            System.out.println(((StringIndexOutOfBoundsException) ex).getMessage());
        } else if (ex instanceof UnsupportedOperationException) {
            mensaje = UnsupportedOperationException.mensaje();

            System.out.println(((UnsupportedOperationException) ex).getMessage());
        } else if (ex instanceof ConcurrentModificationException) {
            mensaje = ConcurrentModificationException.mensaje();

            System.out.println(((ConcurrentModificationException) ex).getMessage());
        } else if (ex instanceof EmptyStackException) {
            mensaje = EmptyStackException.mensaje();

            System.out.println(((EmptyStackException) ex).getMessage());
        } else if (ex instanceof MissingResourceException) {
            mensaje = MissingResourceException.mensaje();

            System.out.println(((MissingResourceException) ex).getMessage());
        } else if (ex instanceof NoSuchElementException) {
            mensaje = NoSuchElementException.mensaje();

            System.out.println(((NoSuchElementException) ex).getMessage());
        } else if (ex instanceof PropertyVetoException) {
            mensaje = PropertyVetoException.mensaje();

            System.out.println(((PropertyVetoException) ex).getMessage());
        } else if (ex instanceof CharConversionException) {
            mensaje = CharConversionException.mensaje();

            System.out.println(((CharConversionException) ex).getMessage());
        } else if (ex instanceof EOFException) {
            mensaje = EOFException.mensaje();

            System.out.println(((EOFException) ex).getMessage());
        } else if (ex instanceof FileNotFoundException) {
            mensaje = FileNotFoundException.mensaje();

            System.out.println(((FileNotFoundException) ex).getMessage());
        } else if (ex instanceof InterruptedIOException) {
            mensaje = InterruptedIOException.mensaje();

            System.out.println(((InterruptedIOException) ex).getMessage());
        } else if (ex instanceof InvalidClassException) {
            mensaje = InvalidClassException.mensaje();

            System.out.println(((InvalidClassException) ex).getMessage());
        } else if (ex instanceof InvalidObjectException) {
            mensaje = InvalidObjectException.mensaje();

            System.out.println(((InvalidObjectException) ex).getMessage());
        } else if (ex instanceof IOException) {
            mensaje = IOException.mensaje();

            System.out.println(((IOException) ex).getMessage());
        } else if (ex instanceof NotActiveException) {
            mensaje = NotActiveException.mensaje();

            System.out.println(((NotActiveException) ex).getMessage());
        } else if (ex instanceof NotSerializableException) {
            mensaje = NotSerializableException.mensaje();

            System.out.println(((NotSerializableException) ex).getMessage());
        } else if (ex instanceof StreamCorruptedException) {
            mensaje = StreamCorruptedException.mensaje();

            System.out.println(((StreamCorruptedException) ex).getMessage());
        } else if (ex instanceof SyncFailedException) {
            mensaje = SyncFailedException.mensaje();

            System.out.println(((SyncFailedException) ex).getMessage());
        } else if (ex instanceof UnsupportedEncodingException) {
            mensaje = UnsupportedEncodingException.mensaje();

            System.out.println(((UnsupportedEncodingException) ex).getMessage());
        } else if (ex instanceof UTFDataFormatException) {
            mensaje = UTFDataFormatException.mensaje();

            System.out.println(((UTFDataFormatException) ex).getMessage());
        } else if (ex instanceof WriteAbortedException) {
            mensaje = WriteAbortedException.mensaje();

            System.out.println(((WriteAbortedException) ex).getMessage());
        } else if (ex instanceof BindException) {
            mensaje = BindException.mensaje();

            System.out.println(((BindException) ex).getMessage());
        } else if (ex instanceof ConnectException) {
            mensaje = ConnectException.mensaje();

            System.out.println(((ConnectException) ex).getMessage());
        } else if (ex instanceof MalformedURLException) {
            mensaje = MalformedURLException.mensaje();

            System.out.println(((MalformedURLException) ex).getMessage());
        } else if (ex instanceof NoRouteToHostException) {
            mensaje = NoRouteToHostException.mensaje();

            System.out.println(((NoRouteToHostException) ex).getMessage());
        } else if (ex instanceof PortUnreachableException) {
            mensaje = PortUnreachableException.mensaje();

            System.out.println(((PortUnreachableException) ex).getMessage());
        } else if (ex instanceof ProtocolException) {
            mensaje = ProtocolException.mensaje();

            System.out.println(((ProtocolException) ex).getMessage());
        } else if (ex instanceof SocketException) {
            mensaje = SocketException.mensaje();

            System.out.println(((SocketException) ex).getMessage());
        } else if (ex instanceof SocketTimeoutException) {
            mensaje = SocketTimeoutException.mensaje();

            System.out.println(((SocketTimeoutException) ex).getMessage());
        } else if (ex instanceof UnknownHostException) {
            mensaje = UnknownHostException.mensaje();

            System.out.println(((UnknownHostException) ex).getMessage());
        } else if (ex instanceof UnknownServiceException) {
            mensaje = UnknownServiceException.mensaje();

            System.out.println(((UnknownServiceException) ex).getMessage());
        } else if (ex instanceof URISyntaxException) {
            mensaje = URISyntaxException.mensaje();

            System.out.println(((URISyntaxException) ex).getMessage());
        } else if (ex instanceof SQLException) {
            mensaje = SQLException.mensaje();

            System.out.println(((SQLException) ex).getMessage());
        } else if (ex instanceof TimeoutException) {
            mensaje = TImeOutException.mensaje();

            System.out.println(((TimeoutException) ex).getMessage());
        } else if (ex.equals(EXCEPTIONDB)) {
            mensaje = DatabaseException.mensaje();

            System.out.println(ex.toString());
        } else if (ex instanceof SQLSyntaxErrorException) {
            mensaje = SQLSyntaxErrorException.mensaje();

            System.out.println(((SQLSyntaxErrorException) ex).getMessage());
        } else if (ex.equals(ERROR_500)) {
            mensaje = ERROR_500.mensaje();

            System.out.println(ex.toString());
        } else if (String.valueOf(ex).replace(" ", "_").equals(String.valueOf(Connection_refused))) {
            mensaje = Connection_refused.mensaje();

            System.out.println(ex.toString());
        } else if (String.valueOf(ex).replace(" ", "_").equals(String.valueOf(Connection_reset))) {
            mensaje = Connection_reset.mensaje();

            System.out.println(ex.toString());
        } else {
            mensaje = ErrorDefault.mensaje();

            System.out.println(mensaje);
        }

        return mensaje;
    }
}
