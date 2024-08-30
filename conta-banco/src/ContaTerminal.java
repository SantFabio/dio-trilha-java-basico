import java.util.Scanner;

/**
 * Classe principal para simular operações bancárias em um terminal.
 */
public class ContaTerminal {
    /**
     * Método principal que executa o programa.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     * @throws Exception Pode lançar uma exceção se houver um erro na entrada do
     *                   usuário.
     */
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Usuario usuario = new Usuario();
        int escolha = 0;
        boolean logOut = false;

        String menu = """
                --------------------------------------
                Operações

                1- Criar conta
                2- Consultar saldos
                3- Receber valor
                4- Sacar valor
                5- Sair

                Digite a opção desejada:
                --------------------------------------
                    """;

        // Loop para exibir o menu e processar as operações até que o usuário escolha
        // sair.
        while (!logOut) {
            System.out.println(menu);
            if (scanner.hasNextInt()) {
                escolha = scanner.nextInt();
                scanner.nextLine();
                switch (escolha) {
                    case 1:
                        criarConta(usuario, scanner);
                        break;
                    case 2:
                        consultarSaldos(usuario);
                        break;
                    case 3:
                        depositar(usuario, scanner);
                        break;
                    case 4:
                        sacar(usuario, scanner);
                        break;
                    case 5:
                        System.out.println("Obrigado por ser nosso cliente! Até mais!");
                        logOut = !logOut;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        scanner.nextLine();
                        break;
                }
            }
        }
        scanner.close();
    }

    /**
     * Cria uma conta para o usuário, pedindo o nome e o saldo inicial.
     *
     * @param usuario O objeto Usuario que será configurado.
     * @param scanner O Scanner para leitura de entradas do usuário.
     */
    private static void criarConta(Usuario usuario, Scanner scanner) {
        if (usuario.getNome() == null) {
            System.out.println("Nome:");
            String nome = scanner.nextLine();
            usuario.setNome(nome);
            System.out.println("Saldo inicial:");
            if (scanner.hasNextDouble()) {
                double saldo = scanner.nextDouble();
                usuario.setSaldo(saldo);
                scanner.nextLine();
            } else {
                System.out.println("Entrada inválida para saldo. Tente novamente.");
            }
        } else if (usuario.getNome() != null) {
            System.out.println("Usuário já cadastrado ");
            System.out.println("Usuário: " + usuario.getNome());
            System.out.println("Conta: " + usuario.getNumero());
            System.out.println("Agência: " + usuario.getAgencia());
        }
    }

    /**
     * Consulta e exibe o saldo atual do usuário.
     *
     * @param usuario O objeto Usuario cujos saldos serão consultados.
     */
    public static void consultarSaldos(Usuario usuario) {
        if (usuario.getNome() != null) {
            System.out.println("Saldo atual: " + usuario.getSaldo());
        } else {
            System.out.println("Entrada inválida cadastre sua conta.");
        }
    }

    /**
     * Permite ao usuário depositar um valor em sua conta.
     *
     * @param usuario O objeto Usuario onde o valor será depositado.
     * @param scanner O Scanner para leitura de entradas do usuário.
     */
    public static void depositar(Usuario usuario, Scanner scanner) {
        if (usuario.getNome() != null) {
            System.out.println("Digite o valor que deseja adicionar:");
            double saldo = scanner.nextDouble();
            usuario.setSaldo(usuario.getSaldo() + saldo);
            System.out.println("Novo Saldo: " + usuario.getSaldo());
            scanner.nextLine();
        } else {
            System.out.println("Entrada inválida cadastre sua conta.");
        }
    }

    /**
     * Permite ao usuário sacar um valor de sua conta.
     *
     * @param usuario O objeto Usuario de onde o valor será sacado.
     * @param scanner O Scanner para leitura de entradas do usuário.
     */
    public static void sacar(Usuario usuario, Scanner scanner) {
        if (usuario.getNome() != null) {
            System.out.println("Digite o valor que deseja sacar:");
            if (scanner.hasNextDouble()) {
                double saque = scanner.nextDouble();
                if (saque > usuario.getSaldo()) {
                    System.out.printf("Valor %.2f%n acima do seu saldo atual.", saque);
                    System.out.println("Saldo atual: " + usuario.getSaldo());
                } else {
                    usuario.setSaldo(usuario.getSaldo() - saque);
                    System.out.printf("Valor do saque: %.2f%n", saque);
                    System.out.println("Saldo atual: " + usuario.getSaldo());
                }
            } else {
                System.out.println("Entrada inválida para saldo. Tente novamente.");
            }
        } else {
            System.out.println("Entrada inválida cadastre sua conta.");
        }
    }
}
