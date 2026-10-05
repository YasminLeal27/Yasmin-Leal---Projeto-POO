import java.util.Scanner;

// CLASSE BASE
class PecaUsinada {

    // ATRIBUTOS - ENCAPSULAMENTO
    private String nome;
    private String tipo;
    private int quantidade;
    private String localizacao;

    // CONSTRUTOR
    public PecaUsinada(String nome, String tipo, int quantidade, String localizacao) {
        this.nome = nome;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.localizacao = localizacao;
    }

    // MÉTODO PARA ADICIONAR PEÇAS
    public void adicionarPeca(int quantidade) {
        this.quantidade += quantidade;
    }

    // MÉTODO PARA RETIRAR PEÇAS
    public void retirarPeca(int quantidade) {
        if (quantidade <= this.quantidade) {
            this.quantidade -= quantidade;
            System.out.println("Peças retiradas com sucesso!");
        } else {
            System.out.println("Quantidade insuficiente em estoque.");
        }
    }

    // MÉTODO DE CONSULTA
    public void consultarPeca() {
        System.out.println("\n--- INFORMAÇÕES DA PEÇA ---");
        System.out.println("Nome: " + nome);
        System.out.println("Tipo: " + tipo);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Localização: " + localizacao);
    }
}

// HERANÇA
class Pistao extends PecaUsinada {

    public Pistao(String nome, String tipo, int quantidade, String localizacao) {
        super(nome, tipo, quantidade, localizacao);
    }

    // POLIMORFISMO
    @Override
    public void consultarPeca() {
        System.out.println("\n--- CONSULTA DO PISTÃO ---");
        super.consultarPeca();
    }
}

class Camisa extends PecaUsinada {

    public Camisa(String nome, String tipo, int quantidade, String localizacao) {
        super(nome, tipo, quantidade, localizacao);
    }

    // POLIMORFISMO
    @Override
    public void consultarPeca() {
        System.out.println("\n--- CONSULTA DA CAMISA ---");
        super.consultarPeca();
    }
}

class Virabrequim extends PecaUsinada {

    public Virabrequim(String nome, String tipo, int quantidade, String localizacao) {
        super(nome, tipo, quantidade, localizacao);
    }

    // POLIMORFISMO
    @Override
    public void consultarPeca() {
        System.out.println("\n--- CONSULTA DO VIRABREQUIM ---");
        super.consultarPeca();
    }
}

// CLASSE PRINCIPAL
public class main {

    public static void main(String[] args) {

        // SCANNER - LEITURA DE DADOS
        Scanner scanner = new Scanner(System.in);

        // OBJETOS
        Pistao pistao = new Pistao(
            "Pistão VW",
            "Pistão",
            50,
            "Prateleira A"
        );

        Camisa camisa = new Camisa(
            "Camisa VW",
            "Camisa",
            30,
            "Prateleira B"
        );

        Virabrequim virabrequim = new Virabrequim(
            "Virabrequim VW",
            "Virabrequim",
            10,
            "Prateleira C"
        );

        int opcao;

        // REPETIÇÃO DO MENU
        do {

            System.out.println("\n===== CONTROLE DE ESTOQUE =====");
            System.out.println("1 - Consultar pistão");
            System.out.println("2 - Adicionar pistão");
            System.out.println("3 - Retirar pistão");
            System.out.println("4 - Consultar camisa");
            System.out.println("5 - Consultar virabrequim");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    pistao.consultarPeca();
                    break;

                case 2:
                    System.out.print("Quantidade para adicionar: ");
                    int adicionar = scanner.nextInt();
                    pistao.adicionarPeca(adicionar);
                    break;

                case 3:
                    System.out.print("Quantidade para retirar: ");
                    int retirar = scanner.nextInt();
                    pistao.retirarPeca(retirar);
                    break;

                case 4:
                    camisa.consultarPeca();
                    break;

                case 5:
                    virabrequim.consultarPeca();
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}