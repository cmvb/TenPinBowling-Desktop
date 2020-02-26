package co.com.cmvb.tpb.tenpinbowling.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RondaDto {

    private long id;
    private List<Long> listaPuntajes;
    private List<String> listaPuntajesTexto;
    private long puntajeTotal;
    private JugadorDto jugador;

    public RondaDto() {
    }

    public long getPuntajeBrutoTotal() {
        long result = 0;
        if (this.listaPuntajes != null) {
            for (Long puntaje : this.listaPuntajes) {
                result = result + puntaje;
            }
        }

        return result;
    }

    public boolean esChuza() {
        boolean result = false;
        if (this.listaPuntajes != null && this.listaPuntajes.size() <= 2) {
            for (String puntajeTexto : this.listaPuntajesTexto) {
                if (puntajeTexto.equalsIgnoreCase("X")) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

    public boolean esSpare() {
        boolean result = false;
        if (this.listaPuntajes != null && this.listaPuntajes.size() <= 2) {
            for (String puntajeTexto : this.listaPuntajesTexto) {
                if (puntajeTexto.equalsIgnoreCase("/")) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

}
