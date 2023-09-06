package entities;

public class Vetor {
    private Object[] elementos;
    private int tamanho;

    public Vetor(int capacidade) {
        this.elementos = new Object[capacidade];
        this.tamanho = 0;
    }

    public void adiciona(Object elemento) throws Exception {
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            ++this.tamanho;
        } else {
            throw new Exception("Vetor está cheio");
        }
    }

    public int tamanho() {
        return tamanho;
    }

    public void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            Object[] elementosNovos = new Object[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();

        for(int i=0; i<this.tamanho-1; i++){
            s.append(this.elementos[i]);
            s.append("\n");
        }

        if(this.tamanho> 0){
            s.append(this.elementos[this.tamanho-1]);
        }

        return s.toString();
    }

    public void removerElementos(int posicao) throws Exception {
        if (posicao >= 0 && posicao < this.tamanho) {
            for (int i = posicao; i < this.tamanho - 1; i++) {
                this.elementos[i] = this.elementos[i + 1];
            }
            this.tamanho--;
            this.elementos[this.tamanho] = null;
        } else {
            throw new Exception("Posição Inválida");
        }
    }
    public int buscaData(String data) {
        for (int i = 0; i < this.tamanho; i++) {
            Reserva reserva = (Reserva) elementos[i];
            if (reserva.getData().trim().equalsIgnoreCase(data)) {
                return i; // Retorna a posição quando a data é encontrado
            }
        }
        return -1; // Retorna -1 se a data não for encontrado
    }

    public Object buscarElementos(int posicao) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            return elementos[posicao];
        } else {
            throw new Exception("Posição Inválida");
        }
    }

    public boolean adicionarInicio(int posicao, Object elemento) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            for(int i = this.tamanho - 1; i >= posicao; i--) {
                this.elementos[i+1] = this.elementos[i];
            }
            this.elementos[posicao] = elemento;
            this.tamanho++;
        } else {
            throw new Exception("Posição Inválida");
        }
        return true;
    }
}
