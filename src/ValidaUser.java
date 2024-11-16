public class ValidaUser {
    archive arquivo = new archive();
    private String user;
    private int Senha;

    public void setUser(String user) {
        this.user = user;
    }

    public void setSenha(int senha) {
        Senha = senha;
    }

    public boolean ValidaConta() {
        int retorno = arquivo.verificaConta(getUser(), Senha);
        if (retorno == 1) {
            System.out.println("Login feito com sucesso!");
            ContaBancaria cb = new ContaBancaria(arquivo); // Passando o arquivo ao criar ContaBancaria
            Tempo(1000);
            cb.Home();
        } else {
            System.out.println("Usuário ou senha incorretos, tente novamente...");
            Tempo(1000);
        }
        return true;
    }

    public void Tempo(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean CriacaoConta() {
        int retorno = arquivo.criacaoConta(getUser(), Senha);
        if (retorno == 1) {
            System.out.println("Cadastro feito com sucesso!");
            System.out.println("Por favor! Abra novamente o terminal");
            Tempo(2000);
        } else if(retorno == 2) {
            System.out.println("Usuário Já Cadastrado! Por favor! Utilize outro Usuário");
            Tempo(2000);
        } else {
            System.out.println("Ocorreu um erro ao cadastrar as informações, tente novamente mais tarde...");
            Tempo(1000);
        }
        return true;
    }

    public String getUser() {
        return user;
    }
}