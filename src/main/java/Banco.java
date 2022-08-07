import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Banco {

    private final List<Conta> contasDoBanco;
    private final Scanner input;

    public Banco() {
        contasDoBanco = new LinkedList<>();
        input = new Scanner(System.in);
    }

    public Conta seEssaContaExiste(String email, int senha) {
        for (Conta conta : contasDoBanco){
            if (conta.getEmail().equals(email)) {
                   return conta;
            } else {
                System.out.println("Essa conta ja existe.");
            }
        }
        System.out.println("Numero ou email errado, tente novamente.");
        return null;
    }

    public Conta seEssaContaExiste(String email) {
        for (Conta conta : contasDoBanco) {
            if (!conta.getEmail().contains(email)) {
                return conta;
            }
        }
        System.out.println("Eita... Algo deu errado, tenta de novo.");
        return null;
    }


    public void registrarConta() {
        System.out.println("Nome completo");
        String nomeCompleto = input.next();
        System.out.println("Email");
        String email = input.next();
        System.out.println("Senha de 6 digitos");
        int senha = input.nextInt();
        long dataEmMilisegundos = new Date().getTime();
        Date dataDeCriacao = new Date(dataEmMilisegundos);

        if (senhaCorreta(senha) && emailCorreto(email)) {
            contasDoBanco.add(new Conta(nomeCompleto, email, senha, dataDeCriacao));
            System.out.println("Sua conta foi criada com sucesso!");
            System.out.println("=## Bem-vindo ao Santander Bootcamp Bank! ##=" + "\n" +
                    "Sua conta e a de numero: " + contasDoBanco.get(contasDoBanco.size() - 1).getNumero());
        }

//        if (emailCorreto(email)) {
//            contasDoBanco.add(new Conta(nomeCompleto, email));
//            System.out.println("You have created account successfully!" + "\n" +
//                    "Your account ID is: " + contasDoBanco.get(contasDoBanco.size() - 1).getNumero());
//
//        }
    }

    public void fazerLogin() {
        try {
        System.out.println("Insira o email: ");
        String email = input.next();
        System.out.println("Insira a senha: ");
        int senha = input.nextInt();
        if (emailCorreto(email) && senhaCorreta(senha)) {
            Conta essaConta = seEssaContaExiste(email, senha);
            boolean loop = true;
            while (loop) {
                Imprimir imprimir = new Imprimir();
                imprimir.menuDaConta();
                int escolha = Integer.parseInt(input.next());
                    switch (escolha) {
                        case 1:
                            System.out.println(" Nome: " + essaConta.getNomeCompleto() + "\n Email: " + essaConta.getEmail() + "\n Saldo: " + essaConta.getSaldo());
                            break;
                        case 2:
                            boolean loop1 = true;
                            do {
                                System.out.println("Quanto gostaria de depositar?");
                                try {
                                    double quantiaDoDeposito = input.nextDouble();
                                    essaConta.deposito(quantiaDoDeposito);

                                } catch (InputMismatchException | NumberFormatException e) {
                                    System.out.println("Opa, acho que voce digitou errado, tenta de novo.");
                                }

                                break;
                            } while (loop1);


                        case 9:
                            List<Conta> nomeSenha = contasDoBanco.stream().limit(2).collect(Collectors.toList());
                            System.out.println(nomeSenha);
                            break;

                        case 3:
                            System.out.println("Quanto gostaria de sacar?");
                            double quantiaDoSaque = input.nextDouble();
                            essaConta.saque(quantiaDoSaque);
                            break;
                        case 4:
                            System.out.println("Digite o email de destino: ");
                            String emailDaConta = input.next();
                            if (emailCorreto(emailDaConta)) {
                                Conta contaDestino = seEssaContaExiste(emailDaConta);
                                System.out.println("Digite o valor que gostaria de transferir");
                                double valordaTransferencia = input.nextDouble();
                                essaConta.transferencia(essaConta, contaDestino, valordaTransferencia);
                                break;
                            }
                        case 5:
                            loop = false;
                            break;
                        case 6:
                            System.out.println(contasDoBanco.indexOf(2));
                            int juros = 0;
                            break;
                        case 7:
                        default:
                            System.out.println("Vish... Algo deu errado, tenta de novo.");
                            break;
                    }
                  }}} catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Pode tentar novamente?");
            }
            }



    public static boolean emailCorreto(String emailCorreto) {
        if (emailCorreto.length() <= 6) {
            System.out.println("Insira um email valido");
            return false;
        } else {
            return true;
        }
    }

    public static boolean senhaCorreta(int senha) {
        if (String.valueOf(senha).length() != 6) {
            System.out.println("A senha deve ter 6 digitos numericos");
            return false;
        } else {
            return true;
        }
    }
}

