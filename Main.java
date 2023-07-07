import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe abstrata Conteudo
abstract class Conteudo {
    private String titulo;
    private int anoLancamento;
    private String genero;

    public Conteudo(String titulo, int anoLancamento, String genero) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Métodos abstrato que será implementado nas subclasses
    public abstract void exibirInformacoes();

    public void cadastrar() {
    }

    public void alterar() {
    }

    public void excluir() {
    }
}

// Classe Filme (subclasse de Conteudo)
class Filme extends Conteudo{
    private int duracao;

    public Filme(String titulo, int anoLancamento, String genero, int duracao) {
        super(titulo, anoLancamento, genero);
        this.duracao = duracao;
    }

    // Getters e Setters
    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }


    // Implementação do método exibirInformacoes() da classe Conteudo
    @Override
    public void exibirInformacoes() {
        System.out.println("Título: " + getTitulo());
        System.out.println("Ano de lançamento: " + getAnoLancamento());
        System.out.println("Duração: " + getDuracao() + " minutos");
        System.out.println("Gênero: " + getGenero());
        System.out.println();
    }

    // Implementação dos métodos da interface Cadastro
    @Override
    public void cadastrar() {
        // Lógica para cadastrar um filme
        System.out.println("Cadastro de Filme: " + getTitulo());
    }

    @Override
    public void alterar() {
        // Lógica para alterar um filme
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o novo título do filme:");
        String novoTitulo = scanner.nextLine();
        setTitulo(novoTitulo);

        System.out.println("Digite o novo ano de lançamento do filme:");
        int novoAnoLancamento = scanner.nextInt();
        setAnoLancamento(novoAnoLancamento);

        System.out.println("Digite a nova duração do filme em minutos:");
        int novaDuracao = scanner.nextInt();
        setDuracao(novaDuracao);

        scanner.nextLine();

        System.out.println("Digite o novo gênero do filme:");
        String novoGenero = scanner.nextLine();
        setGenero(novoGenero);

        System.out.println("Filme alterado com sucesso: " + getTitulo());
    }

    @Override
    public void excluir() {
        // Lógica para excluir um filme
        System.out.println("Exclusão do Filme: " + getTitulo());
    }
}

// Classe Série (subclasse de Conteudo)
class Serie extends Conteudo{
    private int numTemporadas;

    public Serie(String titulo, int anoLancamento, String genero, int numTemporadas) {
        super(titulo, anoLancamento, genero);
        this.numTemporadas = numTemporadas;
    }

    // Getters e Setters
    public int getNumTemporadas() {
        return numTemporadas;
    }

    public void setNumTemporadas(int numTemporadas) {
        this.numTemporadas = numTemporadas;
    }

    // Implementação do método exibirInformacoes() da classe Conteudo
    @Override
    public void exibirInformacoes() {
        System.out.println("Título: " + getTitulo());
        System.out.println("Ano de lançamento: " + getAnoLancamento());
        System.out.println("Número de temporadas: " + getNumTemporadas());
        System.out.println("Gênero: " + getGenero());
        System.out.println();
    }

    // Implementação dos métodos da interface Cadastro
    @Override
    public void cadastrar() {
        // Lógica para cadastrar uma série
        System.out.println("Cadastro de Série: " + getTitulo());
    }

    @Override
    public void alterar() {
        // Lógica para alterar uma série
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o novo título da série:");
        String novoTitulo = scanner.nextLine();
        setTitulo(novoTitulo);

        System.out.println("Digite o novo ano de lançamento da série:");
        int novoAnoLancamento = scanner.nextInt();
        setAnoLancamento(novoAnoLancamento);

        System.out.println("Digite o novo número de temporadas da série:");
        int novoNumTemporadas = scanner.nextInt();
        setNumTemporadas(novoNumTemporadas);

        scanner.nextLine(); // Limpar o buffer do scanner

        System.out.println("Digite o novo gênero da série:");
        String novoGenero = scanner.nextLine();
        setGenero(novoGenero);

        System.out.println("Alteração da Série: " + getTitulo());
    }

    @Override
    public void excluir() {
        // Lógica para excluir uma série
        System.out.println("Exclusão da Série: " + getTitulo());
    }
}

// Classe Stream
class Stream {
    private final List<Conteudo> catalogo;

    public Stream() {
        catalogo = new ArrayList<>();
    }

    public void adicionarItem(Conteudo item) {
        catalogo.add(item);
        item.cadastrar();
    }

    public void alterarItem(Conteudo item) {
        item.alterar();
    }

    public void removerItem(Conteudo item) {
        catalogo.remove(item);
        item.excluir();
    }

    public void exibirCatalogo() {
        System.out.println("Catálogo de Filmes e Séries:");
        System.out.println("============================");
        for (Conteudo item : catalogo) {
            item.exibirInformacoes();
        }
    }

    public List<Conteudo> getCatalogo() {
        return catalogo;
    }
}

public class Main {
    public static void main(String[]args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                InterfaceConteudo interfaceConteudo = new InterfaceConteudo();
                interfaceConteudo.executarPrograma();
            }
        });
    }
}

class InterfaceConteudo extends JFrame {
    private JTextField campoTitulo;
    private JTextField campoAno;
    private JTextField campoGenero;
    private JButton botaoAdicionar;
    private JTextArea areaTexto;
    private Stream netflix;

    public InterfaceConteudo() {
        netflix = new Stream();

        setTitle("Adicionar Conteúdo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel painelCampos = new JPanel(new GridLayout(3, 2));
        JLabel labelTitulo = new JLabel("Título:");
        campoTitulo = new JTextField(20);
        JLabel labelAno = new JLabel("Ano de Lançamento:");
        campoAno = new JTextField(20);
        JLabel labelGenero = new JLabel("Gênero:");
        campoGenero = new JTextField(20);
        painelCampos.add(labelTitulo);
        painelCampos.add(campoTitulo);
        painelCampos.add(labelAno);
        painelCampos.add(campoAno);
        painelCampos.add(labelGenero);
        painelCampos.add(campoGenero);
        add(painelCampos, BorderLayout.NORTH);

        botaoAdicionar = new JButton("Adicionar");
        botaoAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String titulo = campoTitulo.getText();
                int anoLancamento = Integer.parseInt(campoAno.getText());
                String genero = campoGenero.getText();

                Filme filme = new Filme(titulo, anoLancamento, genero, 0);
                netflix.adicionarItem(filme);
                areaTexto.append("Conteúdo adicionado: " + titulo + "\n");
            }
        });
        add(botaoAdicionar, BorderLayout.CENTER);

        areaTexto = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        add(scrollPane, BorderLayout.SOUTH);

        setVisible(true);
    }

    void executarPrograma() {
        // Criando filmes
        Filme filme1 = new Filme("Matrix", 1999, "Ficção Científica", 136);
        Filme filme2 = new Filme("Interestelar", 2014, "Ficção Científica", 169);

        // Criando séries
        Serie serie1 = new Serie("Stranger Things", 2016, "Drama, Fantasia, Terror", 4);
        Serie serie2 = new Serie("Friends",1994, "Comédia", 10);

        // Adicionando os filmes e séries ao catálogo
        netflix.adicionarItem(filme1);
        netflix.adicionarItem(filme2);
        netflix.adicionarItem(serie1);
        netflix.adicionarItem(serie2);

        // Exibindo o catálogo
        areaTexto.append("Catálogo de Filmes e Séries:\n");
        areaTexto.append("============================\n");
        for (Conteudo item : netflix.getCatalogo()) {
            item.exibirInformacoes();
            areaTexto.append("\n");
        }
    }
}
