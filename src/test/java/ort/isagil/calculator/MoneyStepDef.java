package ort.isagil.calculator;

import static org.junit.Assert.*;
import cucumber.api.java.es.*;
import ort.isagil.calculator.model.*;

public class MoneyStepDef {
    private Money primerMoneda;
    private Money segundaMoneda;
    private Money resultado;
    private ExchangeRate tipoDeCambio;

    @Dado("^las monedas \"(.*?)\" (\\d+) y \"(.*?)\" (\\d+)$")
    public void dadasLasMonedas(String tipoPrimerMoneda,
                                int montoPrimerMoneda,
                                String tipoSegundaMoneda,
                                int montoSegundaMoneda) throws Throwable {
        primerMoneda = new Money(montoPrimerMoneda, tipoPrimerMoneda);
        segundaMoneda = new Money(montoSegundaMoneda, tipoSegundaMoneda);
    }

    @Dado("^el tipo de cambio entre \"(.*?)\" y \"(.*?)\" de (\\d+)$")
    public void dadasLasMonedas(String monedaOrigen,
                                String monedaDestino,
                                int montoCambio) throws Throwable {
        this.tipoDeCambio = new ExchangeRate(monedaOrigen, monedaDestino, montoCambio);
    }

    @Cuando("^las sumo$")
    public void sumarMonedas() throws Throwable {        
        resultado = primerMoneda.sumar(segundaMoneda, tipoDeCambio);
    }

    @Entonces("^el resultado es \"(.*?)\" (\\d+)$")
    public void elResultadoEs(String tipoMoneda, int montoMoneda) throws Throwable {
        Money monedaEsperada = new Money(montoMoneda, tipoMoneda);
        assertEquals(monedaEsperada, resultado);
    }
}