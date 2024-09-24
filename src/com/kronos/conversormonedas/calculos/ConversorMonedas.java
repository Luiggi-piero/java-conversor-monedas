package com.kronos.conversormonedas.calculos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kronos.conversormonedas.modelos.ApiResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMonedas {

    // https://v6.exchangerate-api.com/v6/YOUR-API-KEY/latest/USD
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Double convertirMoneda(String codigoMonedaOrigen, Double valor, String codigoMonedaDestino){
        URI direccion =
                    URI.create("https://v6.exchangerate-api.com/v6/27b4cac3373ff75699bb4edf/latest/" + codigoMonedaOrigen);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            ApiResponse apiResponse = gson.fromJson(json, ApiResponse.class);
            return (apiResponse.getConversioRates().get(codigoMonedaDestino) * valor);
        }catch (Exception e){
            throw new RuntimeException("No se pudo hacer la conversión");
        }
    }
}
