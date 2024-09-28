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
    private Long categoriaId;

    private List<Categoria> listCategorias;

    public DeficienciaForm(Deficiencia deficiencia) {
        this.nome = deficiencia.getNome();
        this.categoriaId = deficiencia.getCategoria().getId();
    }

    public List<Categoria> getListCategorias() {
        return listCategorias;
    }
    
    public void setListCategorias(List<Categoria> listCategorias) {
        this.listCategorias = listCategorias;
    }
}