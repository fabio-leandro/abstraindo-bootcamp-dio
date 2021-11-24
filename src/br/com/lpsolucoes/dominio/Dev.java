package br.com.lpsolucoes.dominio;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private String nome;
    private Set<Atividade> atividadesInscritas = new LinkedHashSet<>();
    private Set<Atividade> atividadesRealizadas = new LinkedHashSet<>();
    private int somaXP = 0;


    public void inscreverNoBootcamp(Bootcamp bootcamp){
        this.atividadesInscritas.addAll(bootcamp.getAtividades());
        bootcamp.getDevsInscritos().add(this);
    }
    public void progredir(){
        Optional<Atividade> atividade = this.atividadesInscritas.stream().findFirst();
        if (atividade.isPresent()){
            this.atividadesRealizadas.add(atividade.get());
            this.atividadesInscritas.remove(atividade.get());
        }else {
            System.out.println("Você não está inscrito neste curso.");
        }
    }

    public int calcularMeuXp(){

        this.atividadesRealizadas.forEach(a -> {
           somaXP += a.calcularXP();
        });
        return somaXP;
    }

    public void exibirCursos(String realizadasOuInscritas){

        if(realizadasOuInscritas.equals("Realizadas")){
            System.out.println();
            for(Atividade a:atividadesRealizadas){
                System.out.println(a.toString());
            }
        }else if(realizadasOuInscritas.equalsIgnoreCase("Inscritas")){
            System.out.println();
            for (Atividade a:atividadesInscritas){
                System.out.println(a.toString());
            }
        }else {
            System.out.println("A consulta é para atividades inscritas ou realizadas.");
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Atividade> getAtividadesInscritas() {
        return atividadesInscritas;
    }

    public void setAtividadesInscritas(Set<Atividade> atividadesInscritas) {
        this.atividadesInscritas = atividadesInscritas;
    }

    public Set<Atividade> getAtividadesRealizadas() {
        return atividadesRealizadas;
    }

    public void setAtividadesRealizadas(Set<Atividade> atividadesRealizadas) {
        this.atividadesRealizadas = atividadesRealizadas;
    }

    @Override
    public String toString() {
        return "Dev{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
