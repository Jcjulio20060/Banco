import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        archive arquivo = new archive();

        arquivo.CriarArquivo();

        inicio();

        int option = 0;

        while(option != 3){
            option = sc.nextInt();
            System.out.println(" ");
            if (option == 1) {
                login();
            } else if (option == 2) {
                Cadastro();
            } else {
                System.out.print("Opção escolhida nao foi aceita, tente novamente. ");
            }
        }
        sc.close();
    }

    public static void inicio(){
        System.out.println("Olá! Seja bem vindo(a) ao banco");
        System.out.println("Por onde você deseja começar ?");
        System.out.println("1 - Acessar conta");
        System.out.println("2 - Nova Conta");
        System.out.print("Qual será a opção ? ");
    }

    public static void login(){
        Scanner sc = new Scanner(System.in);
        ValidaUser valida = new ValidaUser();
        for(int i = 0; i < 4; i++){
            if(i < 3) {
                System.out.println("Bem vindo de volta! Quais são suas credenciais ?");
                System.out.print("Usuário: ");
                valida.setUser(sc.next());
                System.out.print("Senha: ");
                valida.setSenha(sc.nextInt());
                System.out.println("Carregando...");
                valida.ValidaConta();
            } else {
                System.out.println("Você excedeu 3 tentativas. Por favor! Espere 5 minutos e tente novamente!");
            }
        }
        sc.close();
    }

    public static void Cadastro(){
        Scanner sc = new Scanner(System.in);
        ValidaUser valida = new ValidaUser();
        for(int i = 0; i < 3; i++){
            System.out.println("Seja bem vindo ao banco! Por favor! Informe as seguintes credenciais: ?");
            System.out.print("Usuário: ");
            valida.setUser(sc.next());
            System.out.print("Senha: ");
            int senha = sc.nextInt();
            System.out.print("Confirme a senha:");
            int Confirmasenha = sc.nextInt();
            if(senha == Confirmasenha){
                System.out.println("Gerando informações...");
                valida.setSenha(senha);
            } else {
                System.out.println("As senhas não são iguais");
            }
        }
        sc.close();
    }
}