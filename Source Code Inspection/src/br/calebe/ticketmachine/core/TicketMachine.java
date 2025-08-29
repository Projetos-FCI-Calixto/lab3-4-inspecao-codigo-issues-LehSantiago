package br.calebe.ticketmachine.core;


import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.Iterator;


/**
 * Corretoras:
 * Isadora Caetano Brandão de Sousa - 10420646
 * Letícia Santiago da Silva - 10420655
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {


    protected int valor;
    protected int saldo;
    protected int[] papelMoeda = {2, 5, 10, 20, 50, 100};


    /**
     * Tipo de Defeito: Omissão
     *
     * Não a o precoDoBilhete que está presente no diagrama
     * de classe e deveria estar presente.
     *
     *
     * Tipo de Defeito: Comissão
     *
     * Saldo acumulado total do sistema não é armazenado.
     */
    public TicketMachine(int valor) {
        this.valor = valor;
        this.saldo = 0;
    }


    /*
	 * Tipo de Defeito: Dados
	 *
	 * O índice está incorreto, deveria ser papelMoeda[i] invés de papelMoeda[1].
	 * */
    public void inserir(int quantia) throws PapelMoedaInvalidaException {
        boolean achou = false;
        for (int i = 0; i < papelMoeda.length && !achou; i++) {
            if (papelMoeda[1] == quantia) {
                achou = true;
            }
        }
        if (!achou) {
            throw new PapelMoedaInvalidaException();
        }
        this.saldo += quantia;
    }


    public int getSaldo() {
        return saldo;
    }


    /*
	 * Tipo de Defeito: Comissão
	 *
	 * Método sempre retorna null quando deveria também calcular o troco para o usuário.
	 * */
    public Iterator<Integer> getTroco() {
        return null;
    }


    /*
	 * Tipo de Defeito: Comissão
	 *
	 * Mostra o valor do saldo ao invés do valor do bilhete.
	 * */
    public String imprimir() throws SaldoInsuficienteException {
        if (saldo < valor) {
            throw new SaldoInsuficienteException();
        }
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        return result;
    }
}
