package co.com.cmvb.tpb.tenpinbowling.service;

import co.com.cmvb.tpb.tenpinbowling.configuracion.CoreException;
import co.com.cmvb.tpb.tenpinbowling.dto.JuegoDto;
import co.com.cmvb.tpb.tenpinbowling.dto.RondaDto;
import java.util.List;
import java.util.Map;

public interface PartidaSBLocal {

    /**
     * Realiza el procesamiento de una partida de Ten Pin-Bowling
     *
     * @param partidaACtual
     * @return
     * @throws CoreException
     */
    public JuegoDto jugarPartida(JuegoDto partidaACtual) throws CoreException;

    /**
     * Valida la estructura del archivo leído y convertido a líneas de texto
     *
     * @param registrosArchivo
     * @return
     * @throws CoreException
     */
    public boolean validarEstructuraArchivo(List<String> registrosArchivo) throws CoreException;

    /**
     * Valida el contenido del archivo leído y convertido a líneas de texto
     *
     * @param registrosArchivo
     * @return
     * @throws CoreException
     */
    public Map<String, List<RondaDto>> validarContenidoArchivo(List<String> registrosArchivo) throws CoreException;

}
