import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int option;

        do {
            inicio();
            option = sc.nextInt();

            switch (option) {
                case 1:
                    login(sc);
                    break;
                case 2:
                    Cadastro(sc);
                    break;
                case 3:
                    System.out.println("Obrigado por usar nosso banco! Até logo.");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    Tempo(1000);
            }

        } while (option != 3);

        sc.close();
    }

    public static void inicio() {
        System.out.println("\nOlá! Seja bem-vindo(a) ao banco");
        System.out.println("Por onde você deseja começar?");
        System.out.println("1 - Acessar conta");
        System.out.println("2 - Nova Conta");
        System.out.println("3 - Sair");
        System.out.print("Qual será a opção? ");
    }

    public static void login(Scanner sc) {
        ValidaUser valida = new ValidaUser();

        for (int i = 1; i <= 3; i++) {
            System.out.println("\nBem-vindo de volta! Quais são suas credenciais?");
            System.out.print("Usuário: ");
            valida.setUser(sc.next());
            System.out.print("Senha: ");
            valida.setSenha(sc.nextInt());

            System.out.println("Carregando...");
            Tempo(3000);

            if (valida.ValidaConta()) {
                System.out.println("Login realizado com sucesso!");
                return; // Sai do método após login bem-sucedido
            } else {
                System.out.println("Credenciais incorretas! Tentativa " + i + " de 3.");
            }
        }

        System.out.println("Você excedeu o limite de tentativas. Por favor, aguarde 5 minutos para tentar novamente.");
    }

    public static void Cadastro(Scanner sc) {
        ValidaUser valida = new ValidaUser();

        System.out.println("\nSeja bem-vindo ao banco! Por favor, informe as seguintes credenciais:");
        System.out.print("Usuário: ");
        valida.setUser(sc.next());
        System.out.print("Senha: ");
        int senha = sc.nextInt();
        System.out.print("Confirme a senha: ");
        int confirmaSenha = sc.nextInt();

        if (senha == confirmaSenha) {
            System.out.println("Gerando informações...");
            valida.setSenha(senha);
            Tempo(3000);

            if (valida.CriacaoConta()) {
                System.out.println("Conta criada com sucesso!");
            } else {
                System.out.println("Erro ao criar a conta. Tente novamente.");
            }
        } else {
            System.out.println("As senhas não são iguais. Cadastro não concluído.");
        }
    }

    public static void Tempo(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Erro na pausa do programa: " + e.getMessage());
        }
    }
}