import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContaBancaria cb = new ContaBancaria();
        ValidaUser valida = new ValidaUser();

        System.out.println("Olá! Seja bem vindo(a) ao banco");
        System.out.println("Por onde você deseja começar ?");
        System.out.println("1 - Acessar conta");
        System.out.println("2 - Nova Conta");
        System.out.print("Qual será a opção ? ");
        int option = sc.nextInt();

        if(option == 1){
            System.out.println(" ");
            System.out.println("Bem vindo de volta! Quais são suas credenciais ?");
            System.out.print("Usuário: ");
            valida.setUser(sc.next());
            System.out.print("Senha: ");
            valida.setSenha(sc.nextInt());
            System.out.println("Carregando...");
            int retorno = valida.ValidaConta();
            if(retorno == 1){
                System.out.println("Login feito com sucesso!");
            } else {
                System.out.println("Usuário ou senha incorretos, tente novamente...");
            }
        } else if(option == 2){

        } else {

        }

        sc.close();
    }
}