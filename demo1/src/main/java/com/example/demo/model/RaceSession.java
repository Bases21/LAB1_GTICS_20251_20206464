package com.example.demo.model;

import java.util.*;

public class RaceSession {

    private static class Tortuga {
        String nombre;
        double velocidad;
        double resistencia;
        double suerte;

        public Tortuga(String nombre, double velocidad, double resistencia, double suerte) {
            this.nombre = nombre;
            this.velocidad = velocidad;
            this.resistencia = resistencia;
            this.suerte = suerte;
        }

        public double getPuntaje() {
            double aleatorio = new Random().nextDouble();
            return (velocidad * 1.5) + (resistencia * 1.2) + (aleatorio * suerte);
        }
    }

    public List<Map.Entry<String, Double>> simularCarrera(String seleccionUsuario) {
        List<Tortuga> tortugas = Arrays.asList(
                new Tortuga("Turbo", 8, 7, 5),
                new Tortuga("Flash", 7, 6, 8),
                new Tortuga("Zoom", 6, 9, 6)
        );

        Map<String, Double> resultados = new HashMap<>();
        for (Tortuga t : tortugas) {
            resultados.put(t.nombre, t.getPuntaje());
        }

        List<Map.Entry<String, Double>> ranking = new ArrayList<>(resultados.entrySet());
        ranking.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        return ranking;
    }
}
