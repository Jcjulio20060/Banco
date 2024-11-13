import java.text.DecimalFormat;

public class ContaBancaria {
    DecimalFormat df = new DecimalFormat("0.00");
    private String Titular;
    private double Saldo;

    public ContaBancaria(){
        setTitular("");
        Saldo = 0.0;
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

    public void Depositar(double valor){
        if(valor > 0.0){
            Saldo += valor;
            System.out.println("Depósito feito com sucesso no valor de R$ " + df.format(Saldo));
        } else {
            System.out.println("Access Denied! Error in account");
        }
    }

    public void Sacar(double valor){
        if(valor > Saldo){
            System.out.println("Access Denied! Error in account");
        } else if(valor <= 0.0){
            System.out.println("Access Denied! Error in account");
        } else {
            Saldo -= valor;
            System.out.println("Saque feito com sucesso no valor de R$ " + df.format(Saldo));
        }
    }
}