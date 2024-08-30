import java.util.Scanner;

public class ContaTerminal {
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

    public static void consultarSaldos(Usuario usuario) {
        if (usuario.getNome() != null) {
            System.out.println("Saldo atual: " + usuario.getSaldo());
        } else {
            System.out.println("Entrada inválida cadastre sua conta.");
        }
    }

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
