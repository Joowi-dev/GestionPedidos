package tiendaonline.app;

import tiendaonline.modelo.Pedido;
import tiendaonline.modelo.PedidoInternacional;
import tiendaonline.modelo.PedidoNacional;

public class Main {

    public static void main(String[] args) {

        // --- pedidoBase ---
        Pedido pedidoBase = new Pedido("P001", "Lucía", 80);

        System.out.println("=== Información pedidoBase ===");
        System.out.println(pedidoBase.mostrarInfo());

        System.out.println("\n¿Pedido válido? " + pedidoBase.esPedidoValido());

        pedidoBase.aplicarDescuento(10);

        System.out.println("\n=== pedidoBase tras descuento 10% ===");
        System.out.println(pedidoBase.mostrarInfo());

        System.out.println("\n" + Pedido.mostrarTotalPedidos());

        // --- pedidoRapido ---
        PedidoNacional pedidoRapido = new PedidoNacional("P002", "Mario", 120, 6.5, true);

        System.out.println("\n=== Información pedidoRapido ===");
        System.out.println(pedidoRapido.mostrarInfo());

        pedidoRapido.cambiarUrgencia();

        System.out.println("\n=== pedidoRapido tras cambiar urgencia ===");
        System.out.println(pedidoRapido.mostrarInfo());

        System.out.println("\n¿Pedido válido? " + pedidoRapido.esPedidoValido());

        System.out.println("\n" + Pedido.mostrarTotalPedidos());

        // --- pedidoExterior ---
        PedidoInternacional pedidoExterior = new PedidoInternacional("P003", "Sara", 250, "Suiza", true);

        System.out.println("\n=== Información pedidoExterior ===");
        System.out.println(pedidoExterior.mostrarInfo());

        System.out.println("\n¿Requiere revisión aduanera? " + pedidoExterior.requiereRevisionAduanera());

        pedidoExterior.aplicarDescuento(5);

        System.out.println("\n=== pedidoExterior tras descuento 5% ===");
        System.out.println(pedidoExterior.mostrarInfo());

        System.out.println("\n" + Pedido.mostrarTotalPedidos());

        // --- Array tiendaOnline ---
        Pedido[] tiendaOnline = { pedidoBase, pedidoRapido, pedidoExterior };

        System.out.println("\n=== Todos los pedidos en tiendaOnline ===");
        for (Pedido p : tiendaOnline) {
            System.out.println("---");
            System.out.println(p.mostrarInfo());
        }

        double importeTotalFinal = 0;
        int pedidosValidos = 0;
        Pedido pedidoMayor = tiendaOnline[0];

        for (Pedido p : tiendaOnline) {
            importeTotalFinal += p.calcularImporteFinal();
            if (p.esPedidoValido()) pedidosValidos++;
            if (p.calcularImporteFinal() > pedidoMayor.calcularImporteFinal()) {
                pedidoMayor = p;
            }
        }

        System.out.println("\n=== Resumen final ===");
        System.out.println("Importe total de todos los pedidos: " + importeTotalFinal + " €");
        System.out.println("Número de pedidos válidos: " + pedidosValidos);
        System.out.println("Pedido con mayor importe final: " + pedidoMayor.getCodigo());
        System.out.println("Su importe final: " + pedidoMayor.calcularImporteFinal() + " €");
    }
}
