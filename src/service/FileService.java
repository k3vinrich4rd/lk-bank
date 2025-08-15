package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe FileUtil, feita para armazenar os métodos necessários para a
 * manipulação de arquivos
 * 
 *
 */
public class FileService {
    File f = new File("\\LKBANK\\accounts\\");

    ContaServiceImpl c = new ContaCorrente();

    String[] files = f.list();
    List<ContaServiceImpl> contas = new ArrayList<>();

    public List<ContaServiceImpl> getContas() {
        return contas;
    }

    public void setContas(List<ContaServiceImpl> contas) {
        this.contas = contas;
    }

    /**
     * Método compararNomes, compara o número de uma conta gerado com o nome de
     * todos os arquivos para evitar duplicidade
     * 
     * @param numeroConta número a ser comparado ao nome dos arquivos
     * @return retorna um booleano baseado nessa informação (true se houver
     *         duplicidade)
     */
    public boolean compararNomeDuplo(int numeroConta) {
        for (String file : files) {
            while (file.contains(String.valueOf(numeroConta))) {
                return true;
            }

        }
        return false;
    }

    /**
     * Método pesquisa, lê o atributo numeroConta e compara com o nome de todos os
     * arquivos na pasta
     * com isso, caso a conta exista, ele cria um array com as informações contidas
     * no arquivo, usando o BufferedReader e as separa pela ,
     * Cada parte sendo uma informação da conta. E adiciona a conta numa lista
     * contas do tipo TestConta e imprime a lista
     * 
     * @return retorna um valor booleano baseado se a informação foi achada ou não
     */
    public ContaServiceImpl pesquisa(int numeroConta) {
        try (BufferedReader br = new BufferedReader(new FileReader(f + "\\" + String.valueOf(numeroConta) + ".txt"))) {
            String line;
            File c = new File(f + "\\" + String.valueOf(numeroConta) + ".txt");
            if (c.exists()) {
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(" ");
                    int numeroC = Integer.parseInt(parts[0].trim());
                    String nomeC = parts[1].trim();
                    String cpfC = parts[2].trim();
                    double saldoC = Double.parseDouble(parts[3].trim());
                    ContaServiceImpl resultado = new ContaPoupanca(numeroC, nomeC, cpfC, saldoC);
                    return resultado;
                }
            }

            else {
                return null;
            }
        } catch (NumberFormatException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;

    }
}