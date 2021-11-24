package br.com.lpsolucoes;

import br.com.lpsolucoes.dominio.*;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        Curso javaBasico = new Curso();
        javaBasico.setCargaHoraria(4);
        javaBasico.setDescricao("Conceitos básicos da Linguagem Java");
        javaBasico.setTitulo("Java Basico");

        Mentoria mentoriaJavaIntermediario = new Mentoria();
        mentoriaJavaIntermediario.setDataMentoria(LocalDate.now().plusDays(5));
        mentoriaJavaIntermediario.setDescricao("Aplicando conceitos Intermediários da Linguagem Java");
        mentoriaJavaIntermediario.setTitulo("Java Intermediario");
        mentoriaJavaIntermediario.setCargaHoraria(2);

        Curso javaAvancado = new Curso();
        javaAvancado.setTitulo("Java Avançado");
        javaAvancado.setDescricao("Conceitos Avançados da Linguagem Java");
        javaAvancado.setCargaHoraria(6);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.getAtividades().add(javaBasico);
        bootcamp.getAtividades().add(mentoriaJavaIntermediario);
        bootcamp.getAtividades().add(javaAvancado);

        System.out.println("Total XP de Mentoria no Bootcamp: "+mentoriaJavaIntermediario.calcularXP());
        System.out.println("Total XP de Cursos no Bootcamp: "+(javaBasico.calcularXP()+javaAvancado.calcularXP()));
        System.out.println("Total XP do Bootcamp: "+bootcamp.calcularXP());

        Dev devFabio = new Dev();
        devFabio.setNome("Fábio Leandro");
        devFabio.inscreverNoBootcamp(bootcamp);
        Dev devCamila = new Dev();
        devCamila.setNome("Camila Rodrigues");
        devCamila.inscreverNoBootcamp(bootcamp);

        System.out.print("Devs Inscritos no bootcamp: ");
        bootcamp.getDevsInscritos().forEach(d -> System.out.print(d));

        System.out.println();
        devFabio.exibirCursos("Inscritas");
        System.out.println();

        devCamila.progredir();
        System.out.printf("******ATIVIDADES PARA REALIZAR DO DEV %s****** \n",devCamila.getNome());
        devCamila.getAtividadesInscritas().forEach(a -> System.out.print(a+"\n"));
        System.out.println();
        System.out.printf("******ATIVIDADES REALIZADAS DO DEV %s****** \n",devCamila.getNome());
        devCamila.getAtividadesRealizadas().forEach(a-> System.out.println(a+"\n"));
        System.out.println();
        System.out.printf("******TOTAL DE XP DO DEV %s NO BOOTCAMP****** \n",devCamila.getNome());
        System.out.println(devCamila.calcularMeuXp());

    }
}
