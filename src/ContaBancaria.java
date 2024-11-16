import java.util.Scanner;
import java.text.DecimalFormat;

public class ContaBancaria {
    Scanner sc = new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("0.00");
    archive arquivo; // Removido a inicialização direta
    private String Titular; // Inicializado após validação
    private double Saldo; // Inicializado após validação

    // Adicionado um construtor que recebe o objeto archive
    public ContaBancaria(archive arquivo) {
        this.arquivo = arquivo;
        setTitular(arquivo.getNome());
        setSaldo(arquivo.getSaldo());
    }

    public void Home() {
        System.out.println("Bem-vindo(a), " + getTitular() + "!");
        System.out.println("Seu saldo atual é de: R$ " + df.format(getSaldo()));
        Options();
    }

    public void Options() {
        int option;

        do {
            System.out.println("\nEscolha uma das opções abaixo:");
            System.out.println("1 - Fazer Depósito");
            System.out.println("2 - Fazer Saque");
            System.out.println("3 - Fazer Transferência");
            System.out.println("4 - Sair da Conta");
            System.out.print("Qual opção você deseja? ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Qual valor você deseja depositar? R$ ");
                    double deposito = sc.nextDouble();
                    Tempo(1000);
                    Depositar(deposito);
                    break;
                case 2:
                    System.out.print("Qual valor você deseja sacar? R$ ");
                    double saque = sc.nextDouble();
                    Tempo(1000);
                    Sacar(saque);
                    break;
                case 3:
                    // Lógica para transferência
                    break;
                case 4:
                    System.out.println("Saindo da conta...");
                    Tempo(1000);
                    arquivo.AtualizaDados(getSaldo());
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    Tempo(1000);
            }
        } while (option != 4);

        System.out.println("Obrigado por usar nosso banco!");
    }

    public String getTitular() {
        return Titular;
    }

    public void setTitular(String titular) {
        Titular = titular;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double saldo) {
        Saldo = saldo;
    }

    public void Tempo(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void Depositar(double valor) {
        if (valor > 0.0) {
            Saldo += valor;
            Tempo(1000);
            System.out.println("Depósito realizado com sucesso! Saldo atual: R$ " + df.format(Saldo));
        } else {
            System.out.println("Erro: Valor inválido para depósito.");
        }
    }

    public void Sacar(double valor) {
        Tempo(1000);
        if (valor > Saldo) {
            System.out.println("Erro: Saldo insuficiente para saque.");
        } else if (valor <= 0.0) {
            System.out.println("Erro: Valor inválido para saque.");
        } else {
            Saldo -= valor;
            System.out.println("Saque realizado com sucesso! Saldo atual: R$ " + df.format(Saldo));
        }
    }
}
