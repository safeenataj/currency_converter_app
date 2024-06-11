package saf.lexicon.java2;


    import java.util.HashMap;
import java.util.Map;

    public class ExchangeRateProvider {
        private static final Map<String, Double> rates = new HashMap<>();

        static {
            // These rates are examples. Adjust them as needed.
            rates.put("SEK_TO_USD", 0.095352305);
            rates.put("USD_TO_SEK", 10.486919);
            rates.put("SEK_TO_Euro", 0.08862512);
            rates.put("Euro_TO_SEK", 11.28462);
        }

        public static double getRate(String fromCurrency, String toCurrency) {
            return rates.getOrDefault(fromCurrency + "_TO_" + toCurrency, 1.0);
        }
    }



