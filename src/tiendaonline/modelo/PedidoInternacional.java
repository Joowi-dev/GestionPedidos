package tiendaonline.modelo;

public class PedidoInternacional extends Pedido {

    private String paisDestino;
    private boolean aduanas;

    public PedidoInternacional(String codigo, String cliente, double importeBase, String paisDestino, boolean aduanas) {
        super(codigo, cliente, importeBase);
        this.paisDestino = paisDestino;
        this.aduanas = aduanas;
    }

    public String getPaisDestino() { return paisDestino; }
    public void setPaisDestino(String paisDestino) { this.paisDestino = paisDestino; }

    public boolean isAduanas() { return aduanas; }
    public void setAduanas(boolean aduanas) { this.aduanas = aduanas; }

    @Override
    public double calcularImporteFinal() {
        double total = importeBase + 25;
        if (aduanas) total += importeBase * 0.12;
        if (paisDestino.equals("Suiza") || paisDestino.equals("Noruega")) total += 18;
        if (importeBase > 200) total -= 10;
        return total;
    }

    public boolean requiereRevisionAduanera() {
        if (aduanas) return true;
        return !paisDestino.equals("Francia") && !paisDestino.equals("Portugal") && !paisDestino.equals("Italia");
    }

    @Override
    public String mostrarInfo() {
        return "Cliente: " + cliente
            + "\nPaís de destino: " + paisDestino
            + "\nAduanas: " + (aduanas ? "Sí" : "No")
            + "\nImporte final: " + calcularImporteFinal() + " €";
    }
}
