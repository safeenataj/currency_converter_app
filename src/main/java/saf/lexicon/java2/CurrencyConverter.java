package saf.lexicon.java2;

public class CurrencyConverter {
    public static double convert(double amount, String fromCurrency, String toCurrency) {
        double rate = ExchangeRateProvider.getRate(fromCurrency, toCurrency);
        return amount * rate;
    }
}



