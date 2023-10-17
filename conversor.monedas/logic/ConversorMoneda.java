package logic;

public class ConversorMoneda {

    public static double convertirMoneda(double monto, Moneda monedaOrigen, Moneda monedaDestino) {
        double valorOrigen = monedaOrigen.getValor();
        double valorDestino = monedaDestino.getValor();
        return monto *(valorOrigen / valorDestino);
    }
}

