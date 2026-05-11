package net.salesianos.tiendaonline.modelo;

public class PedidoNacional extends Pedido {

    private double peso;
    private boolean urgente;

    public PedidoNacional(String codigo, String cliente, double importeBase, double peso, boolean urgente) {
        super(codigo, cliente, importeBase);
        this.peso = peso;
        this.urgente = urgente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    @Override
    public double calcularImporteFinal() {
        double total = importeBase;
        if (peso <= 2) {
            total += 5;
        } else if (peso <= 10) {
            total += 12;
        } else {
            total += 20;
        }
        if (urgente)
            total += 15;
        return total;
    }

    public boolean cambiarUrgencia() {
        urgente = !urgente;
        return urgente;
    }

    @Override
    public String mostrarInfo() {
        return "Código: " + codigo
                + "\nPeso: " + peso + " kg"
                + "\nUrgente: " + (urgente ? "Sí" : "No")
                + "\nImporte final: " + calcularImporteFinal() + " €";
    }
}
