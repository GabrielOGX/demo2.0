package com.example.demo.Form.Deficiencia;

import java.util.List;
import com.example.demo.Model.Categoria;
import com.example.demo.Model.Deficiencia;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeficienciaForm {

    @NotBlank(message = "Preencha o campo nome.")
    private String nome;

    @NotNull(message = "Preencha o campo Categoria.")
    private Categoria categoria;

    private List<Categoria> listCategorias;

    private List<Deficiencia> listDeficiencias;

    public DeficienciaForm(Deficiencia deficiencia) {
        this.nome = deficiencia.getNome();
        this.categoria = deficiencia.getCategoria();
    }


    public List<Deficiencia> getListDeficiencias() {
        return listDeficiencias;
    }

    public void setListDeficiencias(List<Deficiencia> listDeficiencias) {
        this.listDeficiencias = listDeficiencias;
    }

    public List<Categoria> getListCategorias() {
        return listCategorias;
    }
    
    public void setListCategorias(List<Categoria> listCategorias) {
        this.listCategorias = listCategorias;
    }
}
