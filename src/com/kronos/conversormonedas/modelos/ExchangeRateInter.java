package com.kronos.conversormonedas.modelos;

import java.util.Map;

public record ExchangeRateInter(
        String result,
        String base_code,
        Map<String, Double> conversion_rates) {
}
