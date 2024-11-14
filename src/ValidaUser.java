public class ValidaUser {
    ContaBancaria cb = new ContaBancaria();
    archive arquivo = new archive();
    private String user;
    private int Senha;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setSenha(int senha) {
        Senha = senha;
    }

    public void ValidaConta(){
        int retorno = arquivo.VerificaConta(user, Senha);
        if (retorno == 1) {
            System.out.println("Login feito com sucesso!");
        } else {
            System.out.println("Usuário ou senha incorretos, tente novamente...");
        }
    }

    public void CriacaoConta(){
        int retorno = arquivo.VerificaConta(user, Senha);
        if (retorno == 1) {
            System.out.println("Cadastro feito com sucesso!");
        } else {
            System.out.println("Ocorreu um erro ao cadastrar as informações, tente novamente mais tarde...");
        }
    }
}