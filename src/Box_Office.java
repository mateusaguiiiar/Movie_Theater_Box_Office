public class Box_Office {
    private int totalTickets = 0;
    private int contInteira = 0;
    private int contMeia = 0;
    private int contPromo = 0;
    private int contGratis = 0;
    private double totalAccumulation = 0.0;

    public void saleRecord(Sale s) {
        int q = s.getQuantity();
        String cat = s.getCategory();

        totalTickets += q;

        if (cat.equals("Inteira")) {
            contInteira += q;
        } else if (cat.equals("Meia")) {
            contMeia += q;
        } else if (cat.equals("Promocional")) {
            contPromo += q;
        } else if (cat.equals("Grátis") || cat.equals("Gratis")) {
            contGratis += q;
        }

        totalAccumulation += s.getTotalValue();
    }

    public void displayReport() {
        System.out.println("\n==== RELATÓRIO ====");
        System.out.println("Ingressos vendidos: " + totalTickets);
        System.out.println("Inteira: " + contInteira);
        System.out.println("Meia: " + contMeia);
        System.out.println("Promocional: " + contPromo);
        System.out.println("Grátis: " + contGratis);
        System.out.printf("Valor total recebido: R$ %.2f%n", totalAccumulation);
    }
}