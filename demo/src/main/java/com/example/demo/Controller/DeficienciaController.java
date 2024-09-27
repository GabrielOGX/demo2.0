package com.example.demo.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Form.Deficiencia.DeficienciaForm;
import com.example.demo.Model.Deficiencia;
import com.example.demo.Model.Categoria;
import com.example.demo.Repository.DeficienciaRepository;
import com.example.demo.Repository.CategoriaRepository;

@Controller
public class DeficienciaController {

    @Autowired
    private DeficienciaRepository deficienciaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/deficiencia")
    public String index(Model model) {

        List<Deficiencia> listaDeficiencias = deficienciaRepository.findAll();

        model.addAttribute("listaDeficiencias", listaDeficiencias);
        
        return "deficiencia/listar";
    }

    @GetMapping("/deficiencia/create")
    public String create(Model model) {
        DeficienciaForm deficienciaForm = new DeficienciaForm();

        List<Deficiencia> listaDeficiencias = deficienciaRepository.findAll();
        List<Categoria> listaCategorias = categoriaRepository.findAll();

        deficienciaForm.setListDeficiencias(listaDeficiencias);
        deficienciaForm.setListCategorias(listaCategorias);

        model.addAttribute("deficienciaForm", deficienciaForm);

        return "deficiencia/create";
    }
}
