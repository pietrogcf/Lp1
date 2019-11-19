package Main;

import java.util.ArrayList;
import java.util.List;
import tools.CaixaDeFerramentas;
import tools.ManipulaArquivo;

/**
 *
 * @author radames
 */
public class Controle {

    private List<Materia> lista = new ArrayList<>();

    public Controle() { //esse construtor é usado para adicionar alguns dados na lista e 

    }

    public void limparLista() {
        lista.clear();//zera a lista
    }

    public void adicionar(Materia materia) {
        lista.add(materia);
    }

    public List<Materia> listar() {
        return lista;
    }

    public Materia buscar(String nome) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getNome().equals(nome)) {
                return lista.get(i);
            }
        }
        return null;

    }

    public void alterar(Materia materia, Materia materiaAntigo) {
        lista.set(lista.indexOf(materiaAntigo), materia);

    }

    public void excluir(Materia materia) {
        lista.remove(materia);
    }

    public void gravarLista(String caminho) {
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        List<String> listaDeString = new ArrayList<>();
        for (Materia materia : lista) {
            listaDeString.add(materia.toString());
        }
        manipulaArquivo.salvarArquivo(caminho, listaDeString);
    }

    void carregarDados(String caminho) {
        ManipulaArquivo manipulaArquivo = new ManipulaArquivo();
        if (!manipulaArquivo.existeOArquivo(caminho)) {
            manipulaArquivo.criarArquivoVazio(caminho);
        }

        List<String> listaDeString = manipulaArquivo.abrirArquivo(caminho);
        //converter de CSV para Materia
        Materia materia;
        CaixaDeFerramentas cf = new CaixaDeFerramentas();
        for (String string : listaDeString) {
            String aux[] = string.split(";");
            materia = new Materia(aux[0], aux[1], Double.valueOf(aux[2]), Integer.valueOf(aux[3]), cf.converteDeStringParaDate(aux[4]));
            lista.add(materia);
        }
    }

}
