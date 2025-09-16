import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Box_Office bo = new Box_Office();
        String continueService;
        int paymentMethod;

        while (true) {
            System.out.println("===== CINEMA =====");
            System.out.print("Quantidade de ingressos: ");
            int ticketQuantity = sc.nextInt();
            System.out.print("Tipo (1-Inteira, 2-Meia, 3-Promocional): ");
            int ticketType = sc.nextInt();
            System.out.print("Idade: ");
            int clientAge = sc.nextInt();

            Sale s = new Sale(ticketQuantity, clientAge, ticketType);

            System.out.println("\nResumo da Compra:");
            System.out.println("Tipo do ingresso: " + s.getCategory());
            System.out.printf("Valor total: R$ %.2f", s.getTotalValue());

            if (s.getTotalValue() > 0) {
                while (true) {
                    System.out.print("\nForma de pagamento (1-Dinheiro, 2-Cartão): ");
                    paymentMethod = sc.nextInt();

                    if (paymentMethod == 1 || paymentMethod == 2) {
                        break;
                    } else {
                        System.out.println("Opção inválida! Digite 1 para Dinheiro ou 2 para Cartão.");
                    }
                }

                if (paymentMethod == 1) {
                    System.out.print("Digite o valor pago: ");
                    double amountPaid = sc.nextDouble();
                    if (amountPaid >= s.getTotalValue()) {
                        System.out.println("Troco: R$ " + (amountPaid - s.getTotalValue()));
                    } else {
                        System.out.println("Valor insuficiente!");
                    }
                } else {
                    System.out.println("Pagamento confirmado no cartão");
                }
            } else {
                System.out.println("\nIngresso grátis, não é necessário pagamento!");
            }

            bo.saleRecord(s);

            while (true) {
                System.out.print("\nAtender próximo cliente? (S/N): ");
                continueService = sc.next();
                if (continueService.equalsIgnoreCase("S") || continueService.equalsIgnoreCase("N")) {
                    break;
                } else {
                    System.out.println("Opção inválida! Digite S para sim ou N para não.");
                }
            }

            if (continueService.equalsIgnoreCase("N")) {
                break;
            }
        }

        bo.displayReport();
        sc.close();
    }
}