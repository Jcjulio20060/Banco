import java.io.*;

public class archive {
    public String nomeArquivo = "Contas.txt";
    private String[] nome;
    private int[] Senha;
    private int[] Saldo;

    public void CriarArquivo(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))){
            writer.write("Titular\t\tSaldo");
            writer.newLine();
            System.out.println("Arquivo .txt criado com sucesso!");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void AdicionaConta(String nome, int saldo){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))){
            writer.write(nome + "\t\tR$" + saldo);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void LerDados(){
        try(BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))){
            String Line;
            Line = reader.readLine();

            while ((Line = reader.readLine()) != null){
                String[] partes = Line.split("\t+");

                String titular = partes[0].trim();
                double saldo = Double.parseDouble(partes[1].replace("R$", "").trim());

                setNome(titular);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public String[] getNome() {
        return nome;
    }

    public void setNome(String[] nome) {
        this.nome = nome;
    }

    public int[] getSenha() {
        return Senha;
    }

    public void setSenha(int[] senha) {
        Senha = senha;
    }

    public int[] getSaldo() {
        return Saldo;
    }

    public void setSaldo(int[] saldo) {
        Saldo = saldo;
    }

    public int VerificaConta(String user, int senha){
        for(int i = 0; i < nome.length; i++){
            if(nome[i].equals(user)){
                if(Senha[i] == senha){
                    return 1;
                }
            }
        }
    }
}
