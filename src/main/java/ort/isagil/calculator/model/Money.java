package ort.isagil.calculator.model;

public class Money {
    private int monto;
    private String tipoMoneda;

    public Money(int monto, String tipoMoneda) {
        this.monto = monto;
        this.tipoMoneda = tipoMoneda;
    }
    
    public Money sumar(Money otraMoneda, ExchangeRate tipoDeCambio) {
        if (this.getTipoMoneda().equals(otraMoneda.getTipoMoneda())) {
            return this.sumar(otraMoneda);
        } else {
            return this.sumar(tipoDeCambio.cambiar(otraMoneda));
        }
    }

    public Money sumar(Money otraMoneda) {
        return new Money(this.getMonto() + otraMoneda.getMonto(), this.getTipoMoneda());
    }

    public int getMonto() {
        return this.monto;
    }

    public String getTipoMoneda() {
        return this.tipoMoneda;
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof Money))
            return false;

        if (obj == this)
            return true;

        Money otraMoneda = (Money) obj;
        return this.getMonto() == otraMoneda.getMonto() && this.getTipoMoneda().equals(otraMoneda.getTipoMoneda());
    }

    @Override
    public String toString() {
       return "Monto: " + this.getTipoMoneda() + " " + this.getMonto();
    }
}