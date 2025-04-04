package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.RaceConfig;
import com.example.demo.model.RaceSession;
import org.springframework.ui.Model;  // IMPORTANTE: Asegúrate de importar Model

import java.util.List;
import java.util.Map;

@Controller

public class HomeController {

    @GetMapping("/")
    public String mostrarFormulario(Model model) {
        model.addAttribute("config", new RaceConfig());
        return "formulario";
    }

    @PostMapping("/simular")
    public String simularCarrera(@ModelAttribute RaceConfig config, Model model) {
        RaceSession session = new RaceSession();
        List<Map.Entry<String, Double>> resultados = session.simularCarrera(config.getTortuga());

        String ganador = resultados.get(0).getKey();
        boolean gano = config.getTortuga().equals(ganador);

        double ganancia = gano ? config.getApuesta() * 2 : 0;

        model.addAttribute("resultados", resultados);
        model.addAttribute("ganador", ganador);
        model.addAttribute("gano", gano);
        model.addAttribute("ganancia", ganancia);
        model.addAttribute("seleccion", config.getTortuga());
        model.addAttribute("apuesta", config.getApuesta());

        return "resultado";
    }


}
