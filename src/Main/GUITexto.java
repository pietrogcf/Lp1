package Main;

//@author Radames J Halmeman  - rjhalmeman@gmail.com
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import tools.CaixaDeFerramentas;
import tools.Tools;

public class GUITexto {

    Tools tools = new Tools();

    Saida saida = new Saida();
    Controle controle = new Controle();
    CaixaDeFerramentas cf = new CaixaDeFerramentas();
  

    public void telaList() {
        Entrada entrada = new Entrada();
        tools.clearScreen();
        System.out.println("");
        List<Materia> lt = controle.listar();

        System.out.println("NOME;PROFESSOR;NOTA;FALTAS;ULTIMODIA");
        for (Materia materia : lt) {
            System.out.println(materia);
        }

        entrada.pausaEnter();
    }

    public void telaRetrieve() {
        Entrada entrada = new Entrada();
        tools.clearScreen();
        System.out.println("");
        System.out.println("RETRIEVE\n");
        String nome = entrada.lerString("Digite o nome da materia");
        Materia materia = controle.buscar(nome);
        if (materia != null) {
            saida.rotuloString("Nome", materia.getNome());
            saida.rotuloString("Professor", materia.getProfessor());
            saida.imprimirNumeroDouble("Nota", materia.getNota());
            saida.imprimirNumeroInt("Faltas", materia.getFaltas());
            saida.imprimirDate("Ultimo dia de aula", materia.getUltimoDia());
            
        } else {
            saida.rotuloString("Não encontrou o nome", nome);
        }
        entrada.pausaEnter();
    }

    public void telaCreate() {
        Entrada entrada = new Entrada();
        tools.clearScreen();
        System.out.println("");
        System.out.println("INSERT\n");
        entrada.teclado.reset();
        String nome = entrada.lerString("Digite o Nome da materia");
        Materia mat = controle.buscar(nome);
        if (mat == null) { //não achou, então pode adicionar
            Materia materia = new Materia();
            materia.setNome(nome);
            materia.setProfessor(entrada.lerString("Digite o nome do professor"));
            materia.setNota(entrada.lerNumeroDouble("Digite a nota atual"));
            materia.setFaltas(entrada.lerNumeroInteiro("Digite o número de faltas"));
            Date x = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                x = sdf.parse(entrada.lerString("Digite o ultimo dia de aula"));
            } catch (ParseException ex) {
                System.out.println("Tá errado, corrija");
            }
            materia.setUltimoDia(x); 
            controle.adicionar(materia);
        } else {
            System.out.println(mat);
            System.out.println("Materia já cadastrada");
            entrada.pausaEnter();
        }
    }

    public void telaUpdate() {
        Entrada entrada = new Entrada();
        tools.clearScreen();
        System.out.println("");
        System.out.println("UPDATE\n");
        entrada.teclado.reset();
        String nome = entrada.lerString("Digite o nome da materia");
        Materia materia = controle.buscar(nome);
        if (materia != null) { //achou, então pode alterar
            Materia materiaAntigo = materia; //guarda dados para pesquisa no controle
            materia.setNome(nome);
            saida.rotuloString("Nome atual ", materia.getNome());
            materia.setNome(entrada.lerString("Digite o novo nome"));
            saida.imprimirNumeroDouble("Nota atual", materia.getNota());
            materia.setNota(entrada.lerNumeroDouble("Digite a nota"));
            saida.imprimirNumeroInt("Faltas atual", materia.getFaltas());
            materia.setFaltas(entrada.lerNumeroInteiro("Digite o novo número de faltas"));
            saida.imprimirDate("Ultimo dia de aula", materia.getUltimoDia());
            String a = entrada.lerString("Ultimo dia de aula");
            Date x = cf.converteDeStringParaDate(a);
            materia.setUltimoDia(x);
            controle.alterar(materia, materiaAntigo);
        } else {
            System.out.println("Materia não cadastrado, impossível alterar");
            entrada.pausaEnter();
        }
    }

    public void telaDelete() {
        Entrada entrada = new Entrada();
        tools.clearScreen();
        System.out.println("");
        System.out.println("DELETE\n");
        entrada.teclado.reset();
        String nome = entrada.lerString("Digite o Nome do materia");
        Materia materia = controle.buscar(nome);
        if (materia != null) { //achou, então pode excluir
            materia.setNome(nome);
            saida.rotuloString("Nome", materia.getNome());
            saida.rotuloString("Professor", materia.getProfessor());
            saida.imprimirNumeroDouble("Nota", materia.getNota());
            saida.imprimirNumeroInt("Faltas", materia.getFaltas());
            saida.imprimirDate("Ultimo dia de aula", materia.getUltimoDia());
        } else {
            System.out.println("Materia não cadastrado, exclusão impossível");
            entrada.pausaEnter();
        }
    }

    public GUITexto() {
        Entrada entrada = new Entrada();
        String caminho = "Materia.csv";
        //carregar dados do HD para memória RAM
        controle.carregarDados(caminho);
        
        
        int opcao = 0;
        while (opcao != 9) {
            tools.clearScreen();
            System.out.println("CRUD - Materia\n");
            System.out.println("\nMenu Principal\n");
            System.out.println("1 - Adicionar");
            System.out.println("2 - Buscar");
            System.out.println("3 - Alterar");
            System.out.println("4 - Deletar");
            System.out.println("5 - Listar");
            System.out.println("9 - Sair");

            opcao = entrada.lerNumeroInteiro("Qual a opção");

            switch (opcao) {
                case 1:
                    telaCreate();
                    break;
                case 2:
                    telaRetrieve();
                    break;
                case 3:
                    telaUpdate();
                    break;
                case 4:
                    telaDelete();
                    break;
                case 5:
                    telaList();
                    break;
                case 9:
                    //antes de sair, transferir para o HD
                    controle.gravarLista(caminho);
                    System.out.println("\n\nBye");

                    break;

                default:
                    System.out.println("Opção errada, tente novamente");
            }

        }

    }

}
