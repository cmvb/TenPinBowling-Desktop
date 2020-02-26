package co.com.cmvb.tpb.tenpinbowling.dto;

import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JuegoDto {

    private long id;
    private JugadorDto ganador;
    private long puntajeMaximo;
    private Map<String, List<RondaDto>> rondasPorJugador;

    public JuegoDto() {

    }
}
