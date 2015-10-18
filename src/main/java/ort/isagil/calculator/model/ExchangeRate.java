package ort.isagil.calculator.model;

public class ExchangeRate {
    private String monedaOrigen;
    private String monedaDestino;
    private int tipoDeCambio;

    public ExchangeRate(String monedaOrigen, String monedaDestino, int tipoDeCambio){
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.tipoDeCambio = tipoDeCambio;
    }

    public Money cambiar(Money monedaACambiar) {
        if (monedaACambiar.getTipoMoneda().equals(monedaOrigen)) {
            return new Money(monedaACambiar.getMonto() * this.tipoDeCambio, this.monedaDestino);
        } else {
            if (monedaACambiar.getTipoMoneda().equals(monedaDestino)) {
                return new Money(monedaACambiar.getMonto() * (1/this.tipoDeCambio), this.monedaOrigen);
            } else {
                return null; //TODO: Tirar una excepcion.
            }
        }
    }
}