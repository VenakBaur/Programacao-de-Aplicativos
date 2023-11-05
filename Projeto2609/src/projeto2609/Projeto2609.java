package projeto2609;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Projeto2609 {

    static String[] nome = new String[999];
    static String[] email = new String[999];
    static int[] identificacao = new int[999];
    static String[] historicosLivros = new String[999];

    static String[] tituloLivro = new String[999];
    static String[] autorLivro = new String[999];
    static int[] numeroISBN = new int[999];
    static int[] anoPublicacao = new int[999];
    static String[][] emprestimo = new String[999][2];

    static LocalDate[] dataEmprestimo = new LocalDate[999];
    static LocalDate[] dataDevolucao = new LocalDate[999];

    static boolean check = false;
    static boolean check2 = false;
    static int contador = 0;
    static int cont = 0;
    static int acao = 1;
    static String continuar = "";

    public static void main(String[] args) {

        menu();

    }

    public static void menu() {
        
        do { //Loop onde fica menu com opções que levam a outros metodos
            
            //Texto do menu
            String textoMenu = "Bem-vindo ao programa da biblioteca local, você deseja:\n"
                    + "    1- Cadastrar um novo livro\n"
                    + "    2- Cadastrar um novo membro\n"
                    + "    3- Emprestimo livros\n"
                    + "    4- Devolução livros\n"
                    + "    5- Pesquisa livros/membros\n"
                    + "    6- Relatorio\n"
                    + "    7- Encerrar";

            acao = Integer.parseInt(JOptionPane.showInputDialog(textoMenu));
            
            //SwitchCase para chamar os metodos
            switch (acao) {
                case 1:
                    cadastroLivros();
                    break;
                case 2:
                    cadastroMembros();
                    break;
                case 3:
                    emprestimoLivro();
                    break;
                case 4:
                    devolucao();
                    break;
                case 5:
                    pesquisa();
                    break;
                case 6:
                    relatorio();
                    break;
                case 7:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Número inválido");

            }

        } while (acao != 7); //O loop só encerrara se for == 7

    }

    public static void cadastroLivros() { //Feito pelo Leonardo

        continuar = "sim"; //Variavel de verificação de continuidade do loop

        do { //Loop para cadastrar as informações de um livro

            tituloLivro[contador] = JOptionPane.showInputDialog("Insira o titulo do livro");

            autorLivro[contador] = JOptionPane.showInputDialog("Insira o autor do livro");

            numeroISBN[contador] = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero ISBN"));

            anoPublicacao[contador] = Integer.parseInt(JOptionPane.showInputDialog("Insira o ano da publicação"));

            JOptionPane.showMessageDialog(null, "Livro: " + tituloLivro[contador]
                    + "\nAutor: " + autorLivro[contador] + "\nISBN: " + numeroISBN[contador]
                    + "\nAno Publicação: " + anoPublicacao[contador]);

            continuar = JOptionPane.showInputDialog("Deseja inserir um novo cadastro?").toUpperCase();

            contador++; //contador para salvar as informações em locais diferentes no vetor

        } while (continuar.startsWith("S") == true); //Verifica a letra S para seguir no loop

    }

    public static void cadastroMembros() {

        String test = "sim"; ////Variavel de verificação de continuidade do loop

        do { ////Loop para cadastrar as informações de um membro
            
            nome[cont] = JOptionPane.showInputDialog("Digite seu nome ");
            identificacao[cont] = Integer.parseInt(JOptionPane.showInputDialog("Digite seu numero de indentificação"));
            email[cont] = JOptionPane.showInputDialog("Digite seu e-mail");

            JOptionPane.showMessageDialog(null, "Nome: " + nome[cont]
                    + "\nIdentificação: " + identificacao[cont]
                    + "\ne-mail: " + email[cont]);

            test = JOptionPane.showInputDialog("Dejesa inserir outro cadastro?").toUpperCase();

            cont++; //contador para salvar as informações em locais diferentes no vetor

        } while (test.startsWith("S")); //Verifica a letra S para seguir no loop

    }

    public static void emprestimoLivro() {

        int id = 0;
        int indice = 0;
        int indice2 = 0;
        String escolhaLivro = "";
        continuar = "";
        check = false;
        check2 = false;
        String membroEncontrado = "";     
        
        //Verifica se a pessoa esta cadastrada para seguir com o emprestimo        
        id = Integer.parseInt(JOptionPane.showInputDialog("Qual a sua id?"));

        for (int i = 0; i <= cont; i++) {
            
            //Identifica o membro                  
            if (id == identificacao[i]) {

                check2 = true;
                indice = i;
                JOptionPane.showMessageDialog(null, nome[indice] + " identificado");
                membroEncontrado = nome[indice];

            }

        }

        if (check2 == false) {            
            
            //Se não encontrado, o programa retorna            
            JOptionPane.showMessageDialog(null, "Membro não encontrado");
            return;
            
        }
        
        escolhaLivro = JOptionPane.showInputDialog("Que livro deseja pegar?");

        for (int i = 0; i <= 998; i++) {            
            //Procura pelo livro desejado            
            if (escolhaLivro.equals(tituloLivro[i])) {                                
                
                //Se encontrdo o livro, pergunta se e esse que deseja pegar                
                indice2 = i;
                check = true;
                JOptionPane.showMessageDialog(null, "Livro: " + tituloLivro[indice2]);
                continuar = JOptionPane.showInputDialog(null, "Deseja pegar o livro " + tituloLivro[indice2] + "? (s/n)").toUpperCase();
                
            }

        }

        if (continuar.startsWith("S")) {
            //Muda o status para emprestado
            if (emprestimo[indice2][0] != "Emprestado") {

                emprestimo[indice2][0] = "Emprestado";

                emprestimo[indice2][1] = membroEncontrado;

                JOptionPane.showMessageDialog(null, "Você pegou emprestado o livro " + tituloLivro[indice2]);

                dataEmprestimo[indice2] = LocalDate.now();

                dataDevolucao[indice2] = dataEmprestimo[indice2].plusDays(7);

                JOptionPane.showMessageDialog(null, "Data de emprestimo: " + dataEmprestimo[indice2]
                        + "\nData devolução: " + dataDevolucao[indice2]);

            } else {
                //Se o livro não estiver disponivel
                JOptionPane.showMessageDialog(null, "Livro indisponivel");

            }

        } else if (check == false) {
            //Se não tivermos o livro
            JOptionPane.showMessageDialog(null, "Não trabalhamos com esse livro");

        } else if (continuar.startsWith("S") == false) {
            //Se você não quiser pegar o livro no momento da pergunta
            JOptionPane.showMessageDialog(null, "Você não pegou o livro");

        }

    }

    public static void devolucao() {

        int id = 0;
        int indice = 0;
        int indice2 = 0;
        String escolhaLivro = "";
        check = false;
        check2 = false;
        continuar = "";
        String membroEncontrado = "";
        
        //Verifica se a pessoa esta cadastrada para seguir com a devolução
        id = Integer.parseInt(JOptionPane.showInputDialog("Qual a sua id?"));

        for (int i = 0; i <= cont; i++) {
            //Identifica o membro
            if (id == identificacao[i]) {

                check2 = true;
                indice = i;
                JOptionPane.showMessageDialog(null, nome[indice] + " identificado");
                membroEncontrado = nome[indice];

            }

        }

        if (check2 == false) {
            //Se não encontrado, o programa retorna
            JOptionPane.showMessageDialog(null, "Membro não encontrado");
            return;

        }

        escolhaLivro = JOptionPane.showInputDialog("Que livro deseja devolver?");

        for (int i = 0; i <= 998; i++) {
            //Verifica o livro desejado
            if (escolhaLivro.equals(tituloLivro[i])) {

                indice2 = i;
                check = true;
                JOptionPane.showMessageDialog(null, "Livro: " + tituloLivro[indice2]);
                continuar = JOptionPane.showInputDialog(null, "Deseja devolver o livro? (s/n)").toUpperCase();

            }
        }

        if (continuar.startsWith("S")) {
            
            //Se o membro pegar o livro
            if (emprestimo[indice2][0].equals("Emprestado") && membroEncontrado.equals(emprestimo[indice2][1])) {

                int diasAtraso = (int) ChronoUnit.DAYS.between(dataEmprestimo[indice2], LocalDate.now());
                
                if (diasAtraso < 0) {
                    
                    //Causo haja atraso, aparece uma notificação de multa
                    JOptionPane.showMessageDialog(null, "Pague 10 reais de multa pelo atraso");

                }

                emprestimo[indice2][0] = "Disponivel";
                emprestimo[indice2][1] = "";
                JOptionPane.showMessageDialog(null, "Você devolveu o livro " + tituloLivro[indice2]);

            } else if (!membroEncontrado.equals(emprestimo[indice2][1])) {
                //Se o membro nao pegou o livro
                JOptionPane.showMessageDialog(null, "Membro não pegou esse livro");

            } else {
                //Se o livro não tiver sido emprestado
                JOptionPane.showMessageDialog(null, "Livro não emprestado");

            }

        } else if (check == false) {
            //Se não tivermos o livro
            JOptionPane.showMessageDialog(null, "Não trabalhamos com esse livro");

        } else if (continuar.startsWith("S") == false) {
            //Se você não devolver
            JOptionPane.showMessageDialog(null, "Você não devolveu o livro");

        }

    }

    public static void relatorio() {

        String[] opcoes = {"Completo", "Por Membros"};
        int id = 0;
        int indice = 0;
        String membroEncontrado = "";
        check = false;

        int escolha = Integer.parseInt(JOptionPane.showInputDialog("1- Relatório Completo\n"
                + "2- Relatório por membro"));
        
        //Faz um relatorio de todos os livros emprestados no momento
        if (escolha == 1) {

            for (int i = 0; i <= 998; i++) {

                if (emprestimo[i][0] == ("Emprestado")) {

                    JOptionPane.showMessageDialog(null, tituloLivro[i] + " esta emprestado");

                } else if (emprestimo[i] == null) {

                }

            }
        
        //Faz um relatorio de todos livros emprestado para um unico membro
        } else if (escolha == 2) {

            id = Integer.parseInt(JOptionPane.showInputDialog("Digite sua id"));

            for (int i = 0; i <= cont; i++) {

                if (id == identificacao[i]) {

                    indice = i;
                    JOptionPane.showMessageDialog(null, nome[indice] + " identificado");
                    membroEncontrado = nome[indice];
                    check = true;

                }

            }

            if (check == true) {

                for (int i2 = 0; i2 <= contador; i2++) {

                    if (membroEncontrado.equals(emprestimo[i2][1])) {

                        JOptionPane.showMessageDialog(null, membroEncontrado
                                + " esta com o livro " + tituloLivro[i2]);

                    }

                }

            } else if (check == false) {

                JOptionPane.showMessageDialog(null, "Membro não identificado");

            }

        }

    }

    public static void pesquisa() { // Feito pela Clara

        //caixa de mensagem que oferece as opções de pesquisar as informações de um certo livro ou membro    
        Object[] possibilidadePesquisa = {"Livros", "Membros"};
        Object escolhaPesquisa = JOptionPane.showInputDialog(null, "O que deseja pesquisar?", "", JOptionPane.INFORMATION_MESSAGE, null, possibilidadePesquisa, possibilidadePesquisa[0]);
        String op = (String) escolhaPesquisa;
        //compara se a escolha é verdadeira em relação à opção "livros"
        if ("Livros".equals(op)) {
            //caixa de mensagem que oferece as opções de pesquisar as informações do livro por título ou autor
            Object[] possibilidadePesquisaLivro = {"Título", "Autor"};
            Object escolhaLivro = JOptionPane.showInputDialog(null, "Escolha por que caminho deseja pesquisar o livro", "", JOptionPane.INFORMATION_MESSAGE, null, possibilidadePesquisaLivro, possibilidadePesquisaLivro[0]);
            String opLivro = (String) escolhaLivro;
            //compara se a escolha é verdadeira em relação à opção "título"
            if ("Título".equals(opLivro)) {
                //caixa de mensagem que guarda o título informado    
                String pesquisaTitulo = JOptionPane.showInputDialog("Informe o título completo: ");
                //laço de repetição que percorre o vetor "tituloLivro"    
                for (int i = 0; i < 998; i++) {
                    //compara se o título informado existe no vetor    
                    if (tituloLivro[i].equals(pesquisaTitulo)) {
                        //caixa de mensagem que imprime o título, autor, número de ISBN, ano de publicação e status do livro
                        JOptionPane.showMessageDialog(null, "Título: " + tituloLivro[i] + "\nAutor: " + autorLivro[i] + "\nNúmero de ISBN: " + numeroISBN[i] + "\nAno de publicação: " + anoPublicacao[i] + "\nStatus: " + emprestimo[i][i]);
                        //comando que retorna o usuário ao menu
                        return;
                    }

                }
                //compara se a escolha é verdadeira em relação à opção "autor" 
            } else if ("Autor".equals(opLivro)) {
                //caixa de mensagem que guarda o autor informado
                String pesquisaAutor = JOptionPane.showInputDialog("Informe o nome completo do autor: ");
                //laço de repetição que percorre o vetor "autorLivro"
                for (int i = 0; i < 999; i++) {
                    //compara se o autor informado existe no vetor
                    if (autorLivro[i].equals(pesquisaAutor)) {
                        //caixa de mensagem que imprime o título, autor, número de ISBN, ano de publicação e status do livro
                        JOptionPane.showMessageDialog(null, "Título: " + tituloLivro[i] + "\nAutor: " + autorLivro[i] + "\nNúmero ISBN: " + numeroISBN[i] + "\nAno de publicação: " + anoPublicacao[i] + "\nStatus: " + emprestimo[i][i]);
                        //comando que retorna o usuário ao menu
                        return;
                    }

                }
            }
            //compara se a escolha é verdadeira em relação à opção "membros"        
        } else if ("Membros".equals(op)) {
            //caixa de mensagem que oferece as opções de pesquisar as informações do membro por nome ou número de identificação
            Object[] possibilidadePesquisaMembros = {"Nome", "Número de identificação"};
            Object escolhaMembro = JOptionPane.showInputDialog(null, "Escolha por que caminho deseja pesquisar o membro", "", JOptionPane.INFORMATION_MESSAGE, null, possibilidadePesquisaMembros, possibilidadePesquisaMembros[0]);
            String opMembro = (String) escolhaMembro;
            //compara se a escolha é verdadeira em relação à opção "nome"    
            if ("Nome".equals(opMembro)) {
                //caixa de mensagem que guarda o nome do membro informado    
                String pesquisaNome = JOptionPane.showInputDialog("Informe o nome completo do membro:");
                //laço de repetição que percorre o vetor "nome"
                for (int i = 0; i < 999; i++) {
                    //compara se o nome informado existe no vetor
                    if (nome[i].equals(pesquisaNome)) {
                        //caixa de mensagem que imprime o nome, número de identificação e endereço de email do membro
                        JOptionPane.showMessageDialog(null, "Nome: " + nome[i] + "\nNúmero de identificação: " + identificacao[i] + "\nEndereço de email: " + email[i]);
                        //comando que retorna o usuário ao menu
                        return;
                    }
                }
                //compara se a escolha é verdadeira em relação à opção "número de indetificação"    
            } else if ("Número de identificação".equals(opMembro)) {
                //caixa de mensagem que guarda o número de indetificação informado
                int pesquisaNumIdentificacao = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de identificação do membro:"));
                //laço de repetição que percorre o vetor "identificacao"
                for (int i = 0; i < 999; i++) {
                    //compara se o número de indetificação informado existe no vetor
                    if (identificacao[i] == pesquisaNumIdentificacao) {
                        //caixa de mensagem que imprime o nome, número de identificação e endereço de email do membro
                        JOptionPane.showMessageDialog(null, "Nome: " + nome[i] + "\nNúmero de identificação: " + identificacao[i] + "\nEndereço de email: " + email[i]);
                        //comando que retorna o usuário ao menu
                        return;

                    }
                }

            }

        }
    }

}