import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
public class Conta implements IConta {

    private static final double JUROS = 0.0005;
    private static final int AGENCIA = 1;
    private static int CONTADOR = 10000;

    private final String nomeCompleto;
    protected final String email;
    private final int numero;
    protected int agencia;
    private double saldo;
    private final int senha;
    private final Date dataDeCriacao;
    private static long dataEmMilisegundos;


    public Conta(String nomeCompleto, String email, Integer senha, Date dataDeCriacao) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.saldo = 0.0;
        this.numero = CONTADOR++;
        this.agencia = AGENCIA;
        this.senha = senha;
        this.dataDeCriacao = dataDeCriacao;
        this.dataEmMilisegundos = dataEmMilisegundos;
    }

    @Override
    public void deposito(double deposito) {
        this.saldo += deposito;
        System.out.println("Voce depositou " + deposito + " a sua conta" + "\n" +
                "O saldo agora e de: " + this.saldo);
    }

    @Override
    public void saque(double saque) {
        if (this.saldo < saque) {
            System.out.println("Voce nao possui esse valor.");
        } else {
            this.saldo -= saque;
            System.out.println("Voce sacou " + saque + " de sua conta." + "\n" +
                    "Seu saldo agora e: " + this.saldo);
        }
    }

    @Override
    public void transferencia(Conta essaConta, Conta conta, double valor) {
        if (essaConta.getSaldo() > 0) {
            conta.setSaldo(conta.saldo += valor);
            essaConta.setSaldo(this.saldo -= valor);
        } else {
            System.out.println("iii rapaz... Voce esta sem saldo.");
        }
    }

//    public void calcularEmprestimo(long data1, long data2, double valor){ //data atual comparando com data passada no indexOf(4)
//        double valorDojuros;
//        if (quantidadeDeSegundos>0){
//            valorDojuros = valor*quantidadeDeSegundos*JUROS;
//            System.out.println(valorDojuros);
//        } else {
//            System.out.println("Eita, tenta novamente amanha, pode ser?");
//        }
//    }
//    public static double calcularEmprestimo(LocalDateTime data1, LocalDateTime data2, double valor) {
//        LocalDateTime dataAtual = LocalDateTime.now();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("ss");
//        String formatoDaData = dataAtual.format(format);
//        int quantidadeDosSegundos = Integer.parseInt(formatoDaData);
//        double valorDojuros;
//        valorDojuros = valor*quantidadeDosSegundos*JUROS;
//        return valorDojuros;
//    }

//    public static LocalDateTime dataAtual() {
//        LocalDateTime dataAtual = LocalDateTime.now();
////        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
////        double formatoDaData = Double.parseDouble(dataAtual.format(format));
////        return formatoDaData;
//        return dataAtual;
//    }

    //formatar data com metodo:
    // LocalDateTime now = LocalDateTime.now();
    //        System.out.println("Before Formatting: " + now);
    //        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    //        String formatDateTime = now.format(format);
    //        System.out.println("After Formatting: " + formatDateTime);

    public static long miliSegundosAtual() {
        Date date = new Date();
        long milisegundos = date.getTime();
        return milisegundos;
    }
    public static void calcularEmprestimo(long miliSegundosDaCriacao, long miliSegundosAtual, double quantiaDoEmprestimo){
        double valorDoJuros = (miliSegundosAtual-miliSegundosDaCriacao)*quantiaDoEmprestimo*JUROS;
        System.out.println(valorDoJuros);
    }
}