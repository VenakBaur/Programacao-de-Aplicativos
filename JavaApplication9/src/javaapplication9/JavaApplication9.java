package javaapplication9;

import javax.swing.JOptionPane;

public class JavaApplication9 {

    public static void main(String[] args) {

        String nomes[] = {"Bernardo Jardel", "Alan Bittencourt", "Raquel Ferreira", "Valentina Elisa", "Matheus Otto", "Mikaella Velma", "Geraldo Brito",
            "Andressa Tatiane", "Maria Pontes", "Ivan Vinícius"};

        String sobrenomes = "", nome = "";

        sobrenomes = "";
        sobrenomes = JOptionPane.showInputDialog("Pesquise o sobrenome");
        boolean encontrado = false;
        for (int i = 0; i <= 9; i++) {

            if (nomes[i].endsWith(sobrenomes)) {

                JOptionPane.showMessageDialog(null, "Nome: " + nomes[i]);
                encontrado = true;
                
            }

        }
        
        if (!encontrado) {

            JOptionPane.showMessageDialog(null, "Não encontrado!");
        }

        nome = "";
        nome = JOptionPane.showInputDialog("Pesquise o nome");
        boolean encontrei = false;

        for (int i = 0; i <= 9; i++) {

            if (nomes[i].startsWith(nome)) {

                JOptionPane.showMessageDialog(null, "Nome: " + nomes[i]);
                encontrei = true;
            }
        }
        
        if (!encontrei) {

            JOptionPane.showMessageDialog(null, "Não encontrado!");
            
        }
    }

}
