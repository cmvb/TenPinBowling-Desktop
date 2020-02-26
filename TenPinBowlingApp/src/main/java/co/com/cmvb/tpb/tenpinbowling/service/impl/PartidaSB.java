package co.com.cmvb.tpb.tenpinbowling.service.impl;

import co.com.cmvb.tpb.tenpinbowling.configuracion.CoreException;
import co.com.cmvb.tpb.tenpinbowling.dto.JuegoDto;
import co.com.cmvb.tpb.tenpinbowling.dto.JugadorDto;
import co.com.cmvb.tpb.tenpinbowling.dto.RondaDto;
import co.com.cmvb.tpb.tenpinbowling.service.PartidaSBLocal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PartidaSB implements PartidaSBLocal {

    private final int NUMERO_COLUMNAS_PERMITIDAS = 2;
    private final int NUMERO_JUGADAS_PERMITIDAS = 2;
    private final int NUMERO_JUGADAS_PERMITIDAS_FINAL = 3;
    private final int JUGADOR = 0;
    private final int PUNTAJE = 1;
    private final int RONDA_FINAL = 10;
    private final int CHUZA = 10;

    @Override
    public JuegoDto jugarPartida(JuegoDto partidaACtual) throws CoreException {
        String jugadorGanador = "";
        long puntajeMasAlto = 0;

        Map<String, List<RondaDto>> mapaPartida = partidaACtual.getRondasPorJugador();
        for (String jugadorPorRonda : mapaPartida.keySet()) {
            int contValidRonda = 1;
            long sumatoriaPuntajesGlobal = 0;
            for (RondaDto ronda : mapaPartida.get(jugadorPorRonda)) {
                RondaDto rondaSiguiente = contValidRonda == 10 ? null : mapaPartida.get(jugadorPorRonda).get(contValidRonda);
                RondaDto rondaSiguiente2 = contValidRonda == 9 || contValidRonda == 10 ? null : mapaPartida.get(jugadorPorRonda).get(contValidRonda + 1);

                // Ajustando valores totales segun reglas de juego
                if (contValidRonda < 9) {
                    if (ronda.esChuza()) {
                        // 1. Si es una chuza (X) el valor total es 10 más los puntajes de los dos siguientes tiros
                        ronda.setPuntajeTotal(sumatoriaPuntajesGlobal + ronda.getPuntajeBrutoTotal() + (rondaSiguiente.esChuza() ? rondaSiguiente.getPuntajeBrutoTotal() + (rondaSiguiente2.esChuza() ? rondaSiguiente2.getPuntajeBrutoTotal() : (rondaSiguiente2.getListaPuntajes().size() == 3 ? rondaSiguiente2.getListaPuntajes().get(0) : rondaSiguiente2.getListaPuntajes().get(0) + rondaSiguiente2.getListaPuntajes().get(1))) : rondaSiguiente.getListaPuntajes().get(0) + rondaSiguiente.getListaPuntajes().get(1)));
                    } else if (ronda.esSpare()) {
                        // 2. Si es un spare (/) el valor total es 10 más el puntaje del siguiente tiro
                        ronda.setPuntajeTotal(sumatoriaPuntajesGlobal + ronda.getPuntajeBrutoTotal() + (rondaSiguiente.esChuza() ? rondaSiguiente.getPuntajeBrutoTotal() : rondaSiguiente.getListaPuntajes().get(0)));
                    } else {
                        ronda.setPuntajeTotal(sumatoriaPuntajesGlobal + ronda.getPuntajeBrutoTotal());
                    }
                } else if (contValidRonda == 9) {
                    if (ronda.esChuza()) {
                        // 1. Si es una chuza (X) el valor total es 10 más los puntajes de los dos siguientes tiros
                        ronda.setPuntajeTotal(sumatoriaPuntajesGlobal + ronda.getPuntajeBrutoTotal() + rondaSiguiente.getListaPuntajes().get(0) + rondaSiguiente.getListaPuntajes().get(1));
                    } else if (ronda.esSpare()) {
                        // 2. Si es un spare (/) el valor total es 10 más el puntaje del siguiente tiro
                        ronda.setPuntajeTotal(sumatoriaPuntajesGlobal + ronda.getPuntajeBrutoTotal() + rondaSiguiente.getListaPuntajes().get(0));
                    } else {
                        ronda.setPuntajeTotal(sumatoriaPuntajesGlobal + ronda.getPuntajeBrutoTotal());
                    }
                } else {
                    // 3. En la ultima jugada se suman los 3 tiros
                    ronda.setPuntajeTotal(sumatoriaPuntajesGlobal + ronda.getPuntajeBrutoTotal());
                }

                sumatoriaPuntajesGlobal = 0 + ronda.getPuntajeTotal();
                contValidRonda++;
            }

            if (puntajeMasAlto < sumatoriaPuntajesGlobal) {
                puntajeMasAlto = 0 + sumatoriaPuntajesGlobal;
                jugadorGanador = "" + jugadorPorRonda;
            }
        }

        partidaACtual.setRondasPorJugador(mapaPartida);
        JugadorDto ganador = new JugadorDto();
        ganador.setNombre(jugadorGanador);
        partidaACtual.setGanador(ganador);
        partidaACtual.setPuntajeMaximo(puntajeMasAlto);

        return partidaACtual;
    }

    @Override
    public boolean validarEstructuraArchivo(List<String> registrosArchivo) throws CoreException {
        boolean result = true;

        for (String linea : registrosArchivo) {
            String[] columnas = linea.split(" ");
            if (columnas.length != NUMERO_COLUMNAS_PERMITIDAS) {
                String message = "El archivo no se puede procesar porque no cumple con la estructura esperada.";
                System.out.println(message);
                result = false;
                break;
            }

        }

        return result;
    }

    @Override
    public Map<String, List<RondaDto>> validarContenidoArchivo(List<String> registrosArchivo) throws CoreException {
        Map<String, List<RondaDto>> result = new HashMap<>();
        List<RondaDto> resultRondas = new ArrayList<>();
        Map<String, List<String>> mapaJugadorPuntajes = new HashMap<>();
        List<String> listaErrores = new ArrayList<>();

        if (registrosArchivo != null && !registrosArchivo.isEmpty()) {
            // Set jugadores diferentes
            Map<String, Integer> mapNombresPosicionJug = new HashMap<>();
            int contJugador = 0;
            for (String linea : registrosArchivo) {
                String[] columnas = linea.split(" ");
                String nombreJugador = columnas[JUGADOR];
                if (!mapNombresPosicionJug.containsKey(nombreJugador)) {
                    mapNombresPosicionJug.put(nombreJugador, contJugador);
                    contJugador++;
                }
            }

            // Validando cantidad de jugadas
            int contadorRondas = 1;
            String nombreReferenciaRonda = registrosArchivo.get(0).split(" ")[JUGADOR];
            int cantJugadores = mapNombresPosicionJug.size();
            Set<String> listaNombresJugAcumulada = new HashSet<>();

            for (String linea : registrosArchivo) {
                String[] columnas = linea.split(" ");
                String nombreJugador = columnas[JUGADOR];
                String puntajeTexto = columnas[PUNTAJE];

                // Convertir valor texto por valor numérico para luego convertir
                String puntajeConvertido = puntajeTexto.equalsIgnoreCase("X") ? "10" : (puntajeTexto.equalsIgnoreCase("F") ? "0" : puntajeTexto);

                // Validar Puntaje por tiro
                if (Long.parseLong(puntajeConvertido) > CHUZA || Long.parseLong(puntajeConvertido) < 0) {
                    String message = "El puntaje no es válido: " + puntajeConvertido;
                    listaErrores.add(message);
                    result = null;
                    break;
                }

                // Limpiar jugadores
                if (cantJugadores == listaNombresJugAcumulada.size() && nombreReferenciaRonda.equalsIgnoreCase(nombreJugador)) {
                    contadorRondas++;
                    listaNombresJugAcumulada = new HashSet<>();
                }

                if (!listaNombresJugAcumulada.contains(nombreJugador)) {
                    List<String> puntajes = new ArrayList<>();
                    puntajes.add(puntajeConvertido);
                    if (Long.parseLong(puntajeConvertido) == CHUZA) {
                        mapaJugadorPuntajes.put(nombreJugador + "-" + contadorRondas, puntajes);
                        if (!listaNombresJugAcumulada.contains(nombreJugador)) {
                            listaNombresJugAcumulada.add(nombreJugador);
                        }
                    } else {
                        if (!mapaJugadorPuntajes.containsKey(nombreJugador + "-" + contadorRondas)) {
                            mapaJugadorPuntajes.put(nombreJugador + "-" + contadorRondas, puntajes);
                        } else {
                            mapaJugadorPuntajes.get(nombreJugador + "-" + contadorRondas).add(puntajeConvertido);
                            List<String> puntajesAnteriores = mapaJugadorPuntajes.get(nombreJugador + "-" + contadorRondas);
                            long puntajeRonda = 0;
                            for (String puntaje : puntajesAnteriores) {
                                puntajeRonda = puntajeRonda + Long.parseLong(puntaje);
                            }

                            if (contadorRondas != RONDA_FINAL) {
                                if (puntajeRonda <= CHUZA) {
                                    if (!listaNombresJugAcumulada.contains(nombreJugador)) {
                                        listaNombresJugAcumulada.add(nombreJugador);
                                    }
                                } else {
                                    String message = "El puntaje no es válido: " + puntajeConvertido;
                                    listaErrores.add(message);
                                    result = null;
                                    break;
                                }
                            } else {
                                if (cantJugadores == 1) {
                                    if (puntajesAnteriores.size() == NUMERO_JUGADAS_PERMITIDAS_FINAL) {
                                        if (!listaNombresJugAcumulada.contains(nombreJugador)) {
                                            listaNombresJugAcumulada.add(nombreJugador);
                                        }
                                    } else if (puntajesAnteriores.size() > NUMERO_JUGADAS_PERMITIDAS_FINAL) {
                                        String message = "La ronda final tiene más lanzamientos de los permitidos: " + NUMERO_JUGADAS_PERMITIDAS_FINAL;
                                        listaErrores.add(message);
                                        result = null;
                                        break;
                                    }
                                } else {
                                    mapaJugadorPuntajes.get(nombreJugador + "-" + contadorRondas).add(puntajeConvertido);
                                    if (!listaNombresJugAcumulada.contains(nombreJugador)) {
                                        listaNombresJugAcumulada.add(nombreJugador);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    List<String> puntajesAnteriores = mapaJugadorPuntajes.get(nombreJugador + "-" + contadorRondas);
                    long puntajeRonda = 0;
                    for (String puntaje : puntajesAnteriores) {
                        puntajeRonda = puntajeRonda + Long.parseLong(puntaje);
                    }
                    if (!nombreReferenciaRonda.equalsIgnoreCase(nombreJugador)) {
                        puntajeRonda = puntajeRonda + Long.parseLong(puntajeConvertido);
                    }

                    if (contadorRondas != RONDA_FINAL) {
                        if (puntajeRonda <= CHUZA) {
                            mapaJugadorPuntajes.get(nombreJugador + "-" + contadorRondas).add(puntajeConvertido);
                            if (!listaNombresJugAcumulada.contains(nombreJugador)) {
                                listaNombresJugAcumulada.add(nombreJugador);
                            }
                        } else {
                            String message = "El puntaje no es válido: " + puntajeConvertido;
                            listaErrores.add(message);
                            result = null;
                            break;
                        }
                    } else {
                        if (cantJugadores == 1) {
                            if (puntajesAnteriores.size() == NUMERO_JUGADAS_PERMITIDAS_FINAL) {
                                if (!listaNombresJugAcumulada.contains(nombreJugador)) {
                                    listaNombresJugAcumulada.add(nombreJugador);
                                }
                            } else if (puntajesAnteriores.size() > NUMERO_JUGADAS_PERMITIDAS_FINAL) {
                                String message = "La ronda final tiene más lanzamientos de los permitidos: " + NUMERO_JUGADAS_PERMITIDAS_FINAL;
                                listaErrores.add(message);
                                result = null;
                                break;
                            }
                        } else {
                            mapaJugadorPuntajes.get(nombreJugador + "-" + contadorRondas).add(puntajeConvertido);
                            if (!listaNombresJugAcumulada.contains(nombreJugador)) {
                                listaNombresJugAcumulada.add(nombreJugador);
                            }
                        }
                    }
                }
            }

            // Si hay errores mostrarlos
            if (!listaErrores.isEmpty()) {
                listaErrores.forEach(error -> System.out.println(error));
                return null;
            }

            // Armar mapa con rondas DTO y mapa puntajes ronda por jugador
            Map<String, RondaDto> mapaPuntajesRonda = new HashMap<>();
            List<String> listaOrdenadaRondas = new ArrayList(mapaJugadorPuntajes.keySet());
            Collections.sort(listaOrdenadaRondas);
            for (String jugadorRonda : listaOrdenadaRondas) {
                String jugador = jugadorRonda.split("-")[0];
                RondaDto ronda = new RondaDto();
                JugadorDto jugadorDto = new JugadorDto();
                jugadorDto.setNombre(jugador);
                List<String> puntajes = mapaJugadorPuntajes.get(jugadorRonda);
                List<Long> puntajesNumerico = new ArrayList<>();
                long sumatoriaPuntaje = 0;
                for (String puntaje : puntajes) {
                    Long puntLong = Long.valueOf(puntaje);
                    puntajesNumerico.add(puntLong);
                    sumatoriaPuntaje = sumatoriaPuntaje + puntLong;
                }
                ronda.setId(Long.parseLong(jugadorRonda.split("-")[1]));
                ronda.setJugador(jugadorDto);
                ronda.setListaPuntajes(puntajesNumerico);
                ronda.setListaPuntajesTexto(puntajes);
                ronda.setPuntajeTotal(sumatoriaPuntaje);

                // Mapa resultado
                if (!result.containsKey(jugador)) {
                    resultRondas = new ArrayList<>();
                    resultRondas.add(ronda);
                    result.put(jugador, resultRondas);
                } else {
                    result.get(jugador).add(ronda);
                }

                // Mapa puntajes ronda por jugador
                if (!mapaPuntajesRonda.containsKey(jugadorRonda)) {
                    mapaPuntajesRonda.put(jugadorRonda, ronda);
                }
            }

            // Validar cantidad de rondas por jugador
            ALIASFOR:
            for (String jugador : result.keySet()) {
                int rondasTotales = result.get(jugador).size();
                if (rondasTotales != RONDA_FINAL) {
                    if (result.keySet().size() != 1) {
                        String message = "El jugador " + jugador + " no tiene las rondas correctas para completar el juego. Tiene: " + rondasTotales + ".";
                        System.out.println(message);
                        return null;
                    } else {
                        if (result.get(jugador).size() == 12) {
                            result.get(jugador).remove(2);
                            result.get(jugador).remove(2);
                            result.get(jugador).get(1).getListaPuntajes().add(10l);
                            result.get(jugador).get(1).getListaPuntajesTexto().add("X");
                            result.get(jugador).get(1).getListaPuntajes().add(10l);
                            result.get(jugador).get(1).getListaPuntajesTexto().add("X");
                        }
                    }
                }
            }

            for (String jugador : result.keySet()) {
                for (RondaDto ronda : result.get(jugador)) {
                    if (ronda.getListaPuntajes().size() == 1) {
                        long puntaje = ronda.getListaPuntajes().get(0);

                        ronda.setListaPuntajes(new ArrayList<>());
                        ronda.getListaPuntajes().add(0l);
                        ronda.getListaPuntajes().add(puntaje);

                        ronda.setListaPuntajesTexto(new ArrayList<>());
                        ronda.getListaPuntajesTexto().add(" ");
                        ronda.getListaPuntajesTexto().add("X");
                    } else if (ronda.getListaPuntajes().size() == NUMERO_JUGADAS_PERMITIDAS && ronda.getPuntajeBrutoTotal() == CHUZA) {
                        String puntajeTexto = ronda.getListaPuntajesTexto().get(0);

                        ronda.setListaPuntajesTexto(new ArrayList<>());
                        ronda.getListaPuntajesTexto().add(puntajeTexto);
                        ronda.getListaPuntajesTexto().add("/");
                    } else if (ronda.getListaPuntajes().size() == NUMERO_JUGADAS_PERMITIDAS_FINAL) {
                        if (ronda.getPuntajeBrutoTotal() == 30) {
                            ronda.setListaPuntajesTexto(new ArrayList<>());
                            ronda.getListaPuntajesTexto().add("X");
                            ronda.getListaPuntajesTexto().add("X");
                            ronda.getListaPuntajesTexto().add("X");
                        }
                    }
                }

                RondaDto moverUltimaRonda = result.get(jugador).get(1);
                result.get(jugador).remove(1);
                result.get(jugador).add(moverUltimaRonda);
            }
        }

        for (String jugador : result.keySet()) {
            int rondasTotales = result.get(jugador).size();
            if (rondasTotales != RONDA_FINAL) {
                String message = "El jugador " + jugador + " no tiene las rondas correctas para completar el juego. Tiene: " + rondasTotales + ".";
                System.out.println(message);
                return null;
            } else {
                if (result.get(jugador).get(9).getListaPuntajes().size() > NUMERO_JUGADAS_PERMITIDAS_FINAL) {
                    String message = "La ronda final tiene más lanzamientos de los permitidos: " + NUMERO_JUGADAS_PERMITIDAS_FINAL;
                    System.out.println(message);
                    return null;
                }
            }
        }

        return result;
    }
}
