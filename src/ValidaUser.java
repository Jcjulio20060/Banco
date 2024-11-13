public class ValidaUser {
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

    public int ValidaConta(){
        int retorno;
        if(user.equals("jc")){
            if(Senha == 123456){
                retorno = 1;
            } else {
                retorno = 0;
            }
        } else {
            retorno = 0;
        }
        return retorno;
    }
}