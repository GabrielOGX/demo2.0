package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Form.Deficiencia.DeficienciaForm;
import com.example.demo.Model.Categoria;
import com.example.demo.Model.Deficiencia;
import com.example.demo.Repository.CategoriaRepository;
import com.example.demo.Repository.DeficienciaRepository;

@Service
public class DeficienciaService {

    @Autowired
    private DeficienciaRepository deficienciaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Deficiencia> findAll() {
        return deficienciaRepository.findAll();
    }

    public Deficiencia create(DeficienciaForm deficienciaForm) {
        Deficiencia deficiencia = new Deficiencia();
        deficiencia.setNome(deficienciaForm.getNome());

        Categoria categoria = categoriaRepository.findById(deficienciaForm.getCategoriaId())
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        deficiencia.setCategoria(categoria);

        return deficienciaRepository.save(deficiencia);
    }

    public Deficiencia update(DeficienciaForm deficienciaForm, Long id) {
        Deficiencia deficiencia = deficienciaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Deficiência não encontrada"));

        deficiencia.setNome(deficienciaForm.getNome());

        Categoria categoria = categoriaRepository.findById(deficienciaForm.getCategoriaId())
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        deficiencia.setCategoria(categoria);

        return deficienciaRepository.save(deficiencia);
    }

    public void delete(Long id) {
        Deficiencia deficiencia = deficienciaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Deficiência não encontrada"));

        deficienciaRepository.delete(deficiencia);
    }
}
