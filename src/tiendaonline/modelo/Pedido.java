package tiendaonline.modelo;

public class Pedido {

    protected String codigo;
    protected String cliente;
    protected double importeBase;

    private static int totalPedidos = 0;

    public Pedido(String codigo, String cliente, double importeBase) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.importeBase = importeBase;
        totalPedidos++;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public double getImporteBase() { return importeBase; }
    public void setImporteBase(double importeBase) { this.importeBase = importeBase; }

    public double calcularImporteFinal() {
        return importeBase;
    }

    public boolean esPedidoValido() {
        return codigo != null && !codigo.isEmpty()
            && cliente != null && !cliente.isEmpty()
            && importeBase > 0;
    }

    public boolean aplicarDescuento(double porcentaje) {
        if (porcentaje <= 0 || porcentaje >= 100) return false;
        importeBase -= importeBase * (porcentaje / 100);
        return true;
    }

    public String mostrarInfo() {
        return "Código: " + codigo
            + "\nCliente: " + cliente
            + "\nImporte base: " + importeBase + " €"
            + "\nImporte final: " + calcularImporteFinal() + " €";
    }

    public static String mostrarTotalPedidos() {
        return "Total de pedidos creados: " + totalPedidos;
    }
}
