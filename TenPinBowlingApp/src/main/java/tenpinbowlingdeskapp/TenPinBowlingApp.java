package tenpinbowlingdeskapp;

import co.com.cmvb.tpb.tenpinbowling.configuracion.CoreException;
import co.com.cmvb.tpb.tenpinbowling.constantes.ConstantesGenerales;
import co.com.cmvb.tpb.tenpinbowling.dto.JuegoDto;
import co.com.cmvb.tpb.tenpinbowling.dto.RondaDto;
import co.com.cmvb.tpb.tenpinbowling.service.PartidaSBLocal;
import co.com.cmvb.tpb.tenpinbowling.service.impl.PartidaSB;
import co.com.cmvb.tpb.tenpinbowling.util.Util;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;

public class TenPinBowlingApp {

    @Getter
    @Setter
    private PartidaSBLocal partidaSB;

    @Getter
    @Setter
    private Map<String, List<RondaDto>> mapaJugadoresPuntajes;

    @Getter
    @Setter
    private int contadorPartidas;

    @Getter
    @Setter
    private JuegoDto partidaActual;

    @Getter
    @Setter
    private List<JuegoDto> partidasHistorial;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // MAIN
        System.out.println("-------------------------------------------------------------");
        System.out.println("Bienvenido, vamos a jugar Ten Pin-Bowling");
        System.out.println("-------------------------------------------------------------");
        if (args != null && args.length > 0) {
            if (args.length > 1) {
                System.out.println("ADVERTENCIA: Solo puede enviar una ruta a la vez.");
            } else {
                new TenPinBowlingApp().procesarArchivo(args[0]);
            }
        } else {
            System.out.println("Por favor escriba la ruta del archivo a procesar =>");
            String ruta = "";
            Scanner scan = new Scanner(System.in);
            ruta = scan.nextLine(); //Invocamos un método sobre un objeto Scanner
            new TenPinBowlingApp().procesarArchivo(ruta);
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("FIN DEL JUEGO");
        System.out.println("-------------------------------------------------------------");
    }

    /*
    * Método para procesar el archivo dada la ruta
     */
    public void procesarArchivo(String rutaArchivo) {
        this.contadorPartidas = 1;
        this.partidaActual = new JuegoDto();
        this.partidasHistorial = new ArrayList<>();
        this.mapaJugadoresPuntajes = new HashMap<>();
        this.partidaSB = new PartidaSB();

        try {
            File file = new File(rutaArchivo);
            InputStream fileIS = null;
            if (Util.validarExtensionArchivo(file.getName(), ConstantesGenerales.EXT_TXT)) {
                fileIS = Util.obtenerFicheroInputStream(rutaArchivo);
            } else {
                String message = "La extensión del archivo no es correcta. La extensión permitida es: (TXT).";
                System.out.println(message);
            }

            if (fileIS != null) {
                if (validaciones(fileIS)) {
                    String message = "El Archivo ha sido procesado correctamente.";
                    System.out.println(message);

                    this.jugar();
                }
            } else {
                String message = "Debe seleccionar un archivo para procesar.";
                System.out.println(message);
            }
        } catch (IOException ex) {
            String message = "No se pudo leer el archivo. Verifique la ruta por favor.";
            System.out.println(message);
        }
    }

    /**
     * Método de validación
     *
     * @param fileIS
     * @return
     */
    public boolean validaciones(InputStream fileIS) {
        this.mapaJugadoresPuntajes = new HashMap<>();
        boolean esEstructuraValida = this.validarEstructuraArchivo(fileIS);
        boolean esContenidoValido = esEstructuraValida ? this.validarContenidoArchivo(fileIS) : false;

        return esEstructuraValida && esContenidoValido;
    }

    /**
     * Método que permite saber si la estructura del archivo de lectura es
     * correcta
     *
     * @param fileIS
     * @return
     */
    public boolean validarEstructuraArchivo(InputStream fileIS) {
        boolean result = false;

        try {
            List<String> registrosArchivo = Util.listaCargueArchivos(fileIS);
            if (registrosArchivo != null && !registrosArchivo.isEmpty()) {
                result = this.partidaSB.validarEstructuraArchivo(registrosArchivo);
            } else {
                String message = "El archivo está vacío.";
                System.out.println(message);
            }
        } catch (CoreException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    /**
     * Método que permite saber si el contenido del archivo de lectura es
     * correcto
     *
     * @param fileIS
     * @return
     */
    public boolean validarContenidoArchivo(InputStream fileIS) {
        boolean result = false;

        try {
            List<String> registrosArchivo = Util.listaCargueArchivos(fileIS);
            this.mapaJugadoresPuntajes = this.partidaSB.validarContenidoArchivo(registrosArchivo);

            result = this.mapaJugadoresPuntajes != null && !this.mapaJugadoresPuntajes.isEmpty();
        } catch (CoreException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    /**
     * Jugar Ten Pin-Bowling
     */
    public void jugar() {
        try {
            this.setPartidaActual(new JuegoDto());
            this.getPartidaActual().setId(contadorPartidas);
            this.getPartidaActual().setRondasPorJugador(this.mapaJugadoresPuntajes);

            JuegoDto partida = this.partidaSB.jugarPartida(this.getPartidaActual());
            String message = "El ganador es: " + partida.getGanador().getNombre() + " con " + partida.getPuntajeMaximo() + " puntos.";
            System.out.println(message);
            this.mapaJugadoresPuntajes = new HashMap<>();
            this.mapaJugadoresPuntajes = partida.getRondasPorJugador();

            this.getPartidasHistorial().add(partida);
            this.contadorPartidas++;

            // Mostrar en consola la tabla de resultados
        } catch (CoreException ex) {
            ex.printStackTrace();
        }
    }
}
