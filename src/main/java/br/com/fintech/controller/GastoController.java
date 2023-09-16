package br.com.fintech.controller;

import br.com.fintech.model.Gasto;
import br.com.fintech.model.dto.GastoRegisterData;
import br.com.fintech.model.dto.GastoUpdateData;
import br.com.fintech.repository.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/gastos")
public class GastoController {

    @Autowired
    private GastoRepository repository;


    //1 - LISTAR
    @GetMapping
    public String loadListPage(Model model) {
        model.addAttribute("gastos", repository.findAll());
        return "gastos/list";
    }

    //Abre Form tanto para 2 - REGISTRAR e 3 - EDITAR
    @GetMapping("/form")
    public String loadFormPage(Long id, Model model) {
        if(id != null) {
            var gasto = repository.getReferenceById(id);
            model.addAttribute("gasto", gasto);
        }
        return "gastos/form";
    }

    //2 - REGISTRAR
    @PostMapping
    @Transactional
    public String insertNewGasto(GastoRegisterData data) {
        var gasto = new Gasto(data);
        repository.save(gasto);
        return "redirect:/gastos";
    }

    //3 - EDITAR
    @PutMapping
    @Transactional //Transaction with database
    public String updateGasto(GastoUpdateData data) {
        var gasto = repository.getReferenceById(data.id());
        gasto.updateGasto(data);
        return "redirect:/gastos";
    }

    //4 - DELETAR
    @DeleteMapping
    @Transactional
    public String deleteGasto(Long id) {
        repository.deleteById(id);
        return "redirect:/gastos";
    }

}
