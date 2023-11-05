package projeto2609;

import javax.swing.JOptionPane;

public class MetodoLeo {

    public static void main(String[] args) {

        String[] tituloLivro = new String[999];
        String[] autorLivro = new String[999];
        int[] numeroISBN = new int[999];
        int[] anoPublicacao = new int[999];
        String continuar = "sim";
        int contador = 0;

        do {

            tituloLivro[contador] = JOptionPane.showInputDialog("Insira o titulo do livro");

            autorLivro[contador] = JOptionPane.showInputDialog("Insira o autor do livro");

            numeroISBN[contador] = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero ISBN"));

            anoPublicacao[contador] = Integer.parseInt(JOptionPane.showInputDialog("Insira o ano da publicação"));

            continuar = JOptionPane.showInputDialog("Deseja inserir um novo cadastro?").toUpperCase();
            
            contador++;

        } while (continuar.startsWith("S") == true);

    }

}