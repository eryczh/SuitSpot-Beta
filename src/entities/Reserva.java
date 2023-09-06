package entities;

import javax.swing.*;

public class Reserva {

    String valores[] = {"Quarto Standart", "Suíte Júnior", "Quarto Temático", "Suíte Executiva", "Quarto Familiar", "Sair"};
    private static Vetor vetor = new Vetor(10);

    private String data;
    private String mes;

    public Reserva(){}

    public Reserva(String data, String mes){
        this.data = data;
        this.mes = mes;
    }

    public String getData() {
        return data;
    }

    public void realizarReserva () {
        JOptionPane.showMessageDialog(null, "Seja bem-vindo ao SuitSpot");
        int resp = 0;
        do {
            String valores[] = {"Realizar reserva", "Ver minhas reservas", "Cancelar reservas", "Sair"};
            Object escolha = JOptionPane.showInputDialog(null, "O que deseja fazer?", "SuitSpot", JOptionPane.WARNING_MESSAGE, null, valores, valores[0]);

            if (escolha.equals("Realizar reserva")) {
                selecaoQuarto();
            } else if (escolha.equals("Ver minhas reservas")) {
                visualizarReservas();
            } else if (escolha.equals("Cancelar reservas")) {
                cancelarReserva();
            } else if (escolha.equals("Sair")) {
                resp = 1;
            }
        } while (resp == 0);
    }


    private void dataReserva() {
        while(true) {
            StringBuilder reservaData = new StringBuilder();
            Reserva reserva;

            data = JOptionPane.showInputDialog("Digite a data que deseja realizar a reserva");
            mes = JOptionPane.showInputDialog("Digite o mês que deseja realizar a reserva");

            reserva = new Reserva(data, mes);

            try{
                vetor.adiciona(reserva);
                reservaData.append(reserva).append("\n");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }

            if (reservaData.length() == 1) {
                JOptionPane.showMessageDialog(null, "Você fez uma reserva\n\n" + reservaData.toString(), "SuitSpot", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Você fez uma reserva\n\n" + reservaData.toString(), "SuitSpot", JOptionPane.INFORMATION_MESSAGE);
            }
            break;
        }
    }

    private void selecaoQuarto() {
        JOptionPane.showMessageDialog(null, "Selecione o quarto que deseja reservar", "SuitSpot", JOptionPane.INFORMATION_MESSAGE);
        int resp = 0;
        do {
            Object escolha = JOptionPane.showInputDialog(null, "Quartos disponíveis", "SuitSpot", JOptionPane.WARNING_MESSAGE, null, valores, valores[0]);

            if (escolha != ("Sair")) {
                dataReserva();
                break;
            }

            if (escolha.equals("Sair")) {
                resp = 1;
            }
        } while (resp == 0);
    }

    private void cancelarReserva() {
        String diaReserva = JOptionPane.showInputDialog("Digite o dia de sua reserva a ser removida").trim().toLowerCase();

        try {
            int posicaoParaRemover = vetor.buscaData(diaReserva);
            if(posicaoParaRemover != -1) {
                vetor.removerElementos(posicaoParaRemover);
                JOptionPane.showMessageDialog(null, "Reserva cancelada com sucesso", "SuitSpot", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Data não encontrada", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void visualizarReservas() {
        if(vetor.tamanho() == 0) {
            JOptionPane.showMessageDialog(null, "Você não tem reservas");
        } else {
            JOptionPane.showMessageDialog(null, vetor.toString());
        }


    }

    public String toString() {
        return "RESERVA\nDIA: " + this.data + "\nMES: " + this.mes;
    }

}
