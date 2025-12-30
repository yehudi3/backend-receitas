package com.yehudi.backend.service;

import com.yehudi.backend.model.Receita;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ReceitaService {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Receita> buscarReceitas(String nome) {

        String url = "https://www.themealdb.com/api/json/v1/1/search.php?s=" + nome;

        Map resposta = restTemplate.getForObject(url, Map.class);

        List<Map<String, Object>> meals =
                (List<Map<String, Object>>) resposta.get("meals");

        List<Receita> receitas = new ArrayList<>();

        if (meals != null) {
            for (Map<String, Object> meal : meals) {

                String nomeReceita = (String) meal.get("strMeal");
                String imagem = (String) meal.get("strMealThumb");
                String categoria = (String) meal.get("strCategory");
                String preparo = (String) meal.get("strInstructions");

                StringBuilder ingredientes = new StringBuilder();

                for (int i = 1; i <= 20; i++) {
                    String ingrediente =
                            (String) meal.get("strIngredient" + i);
                    String medida =
                            (String) meal.get("strMeasure" + i);

                    if (ingrediente != null && !ingrediente.isBlank()) {
                        ingredientes.append("- ")
                                    .append(ingrediente);

                        if (medida != null && !medida.isBlank()) {
                            ingredientes.append(" (")
                                        .append(medida)
                                        .append(")");
                        }

                        ingredientes.append("\n");
                    }
                }

                receitas.add(
                    new Receita(
                        nomeReceita,
                        imagem,
                        categoria,
                        ingredientes.toString(),
                        preparo
                    )
                );
            }
        }

        return receitas;
    }
}
