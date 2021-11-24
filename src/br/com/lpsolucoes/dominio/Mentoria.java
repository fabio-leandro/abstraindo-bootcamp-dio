package br.com.lpsolucoes.dominio;

import java.time.LocalDate;
import java.util.Objects;

public class Mentoria extends Atividade{

    private LocalDate dataMentoria;

    @Override
    public int calcularXP() {
        return getCargaHoraria() * 15;
    }

    public LocalDate getDataMentoria() {
        return dataMentoria;
    }

    public void setDataMentoria(LocalDate dataMentoria) {
        this.dataMentoria = dataMentoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Mentoria mentoria = (Mentoria) o;
        return Objects.equals(dataMentoria, mentoria.dataMentoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dataMentoria);
    }

    @Override
    public String toString() {
        return "Mentoria { Titulo: "+getTitulo()+" | Descrição: "+getDescricao()+
                " | Carga Horária: "+getCargaHoraria()+" horas "+" | Data Mentoria: "+getDataMentoria()+" }";
    }

}
