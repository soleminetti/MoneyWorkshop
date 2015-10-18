package ort.isagil.calculator;

import static org.junit.Assert.*;
import cucumber.api.java.es.*;
import ort.isagil.calculator.model.*;

public class ExchangeRateStepDef {
    private ExchangeRate tipoDeCambio;
    private Money resultado;
    
    @Dado("^una moneda de origen \"(.*?)\", una de destino \"(.*?)\" y su tipo de cambio a (\\d+)$")
    public void dadasLasMonedasDeOrigenYDestino(String tipoMonedaOrigen,
                                                String tipoMonedaDestino, 
                                                int tipoDeCambio) throws Throwable {
        this.tipoDeCambio = new ExchangeRate(tipoMonedaOrigen, tipoMonedaDestino, tipoDeCambio);
    }

    @Cuando("^cambio \"(.*?)\" (\\d+)$")
    public void cambio(String tipoMoneda, int montoCambio) throws Throwable {        
        resultado = this.tipoDeCambio.cambiar(new Money(montoCambio, tipoMoneda));
    }

    @Entonces("^recibo por el cambio \"(.*?)\" (\\d+)$")
    public void reciboPorElCambio(String tipoMoneda, int montoMoneda) throws Throwable {
        Money cambioEsperado = new Money(montoMoneda, tipoMoneda);
        assertEquals(cambioEsperado , resultado);
    }
}