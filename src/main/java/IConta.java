public interface IConta {

    void deposito(double deposito);

    void saque(double saque);

    void transferencia(Conta essaConta, Conta conta, double valor);
}
