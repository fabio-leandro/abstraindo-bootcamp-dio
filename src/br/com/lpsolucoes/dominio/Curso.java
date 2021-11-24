package br.com.lpsolucoes.dominio;


public class Curso extends Atividade{

    @Override
    public int calcularXP() {
        return getCargaHoraria() * 40;
    }

    @Override
    public String toString() {
        return "Curso { Titulo: "+getTitulo()+" | Descrição: "+getDescricao()+
                " | Carga Horária: "+getCargaHoraria()+" horas }";
    }
}
