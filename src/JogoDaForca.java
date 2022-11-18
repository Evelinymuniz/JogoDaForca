import java.util.Random;
import java.util.Scanner;

public class JogoDaForca {

    public static void main(String[] args) {
        //lista de palavras
        String[] palavras = {"BICICLETA", "CAMINHAO", "CARRO", "MOTO", "ONIBUS", "TREM", "AVIAO", "NAVIO", "CANOA",};

        System.out.println("#### JOGO DA FORCA ####\n");
        System.out.println("DICA : A PALAVRA É UM MEIO DE TRANSPORTE\n");

        //  sorteador de palavras, selecionar uma palavra em um array usando o indice
        Random random = new Random();
        Scanner in = new Scanner(System.in);// entrada de dados

        Integer quantidadeDepalavras = palavras.length;// funciona com vetores pega o tamanho do vetor
        Integer indiceSorteado = random.nextInt(quantidadeDepalavras);// indice sorteado, posicao no vetor da palavra sorteada

        String sorteada = (palavras[indiceSorteado]).trim().toUpperCase();//a palavra sorteada
        String letrasUtilizadas = "";//infora as letras ja tentadas
        Character letra;// letra q o usuario digita
        Boolean ganhou = false;
        Integer chances = sorteada.length();// o tamanho da palavra sorteada trem = 4 chances

        Character[] acertos = new Character[sorteada.length()]; // vai controlar os acertos dos usuarios a ideia é que cada letro seja um acerto

        for (int i = 0; i < acertos.length; i++) {
            acertos[i] = 0;
        }
       /* // for inicializacao ; teste ; passo
            inicializacao => int i  = 0
            teste => i < acertos.length ( tamanho da palavra)
            passo => i++
            i=> uma variavel que comeca em zero e vai ate o tamanho da palavra
        */

        for (int i = 0; i < sorteada.length(); i++) {//mostra os underline com o tamanho da palavra
            System.out.print(" _ ");
        }

        System.out.println("\n");

        // apagar depois
        //System.out.println(sorteada);


        do {
            System.out.print("\n" + "VOCE TEM " + chances + " CHANCES "
                    + "\nLETRAS UTILIZADAS: " + letrasUtilizadas
                    + "\nQual letra voce deseja tentar ? ");

            letra = in.next().toUpperCase().charAt(0);// usa o scanner para ler to upper case
            // para colocar em maiusculae depois o charart 0 para pegar a primeira letrar

            letrasUtilizadas += " " + letra; // variavel vai mostrar a letra que foram utilizadas
            Boolean perdeChance = true; //vejo se tem a letra e marco o acerto
            // comecou dizendo q ele vai perder chance

            for (int i = 0; i < sorteada.length(); i++) {
                // verifica se a letra sorteada é igual a letra da palavra sorteada na posicao i.

                if (letra == sorteada.charAt(i)) {
                    acertos[i] = 1;
                    perdeChance = false;// quando a gente for mostra a palavra ao em vez de mostrar com anderline eu vou mostrar a letra
                }
            }
            if (perdeChance)// se perder uma chance ele diminue a quantiaded de chances
                chances--;// executa so se usuario nao ecertar a letra nessa rodada


            ganhou = true;// o cara ganhou, mostro o estado da palavra( digo que o usuario pode ter ganho)
            for (int i = 0; i < sorteada.length(); i++) {

                if (acertos[i] == 0) {
                    System.out.print(" _ ");
                    ganhou = false;// se existir alguma letra que ele nao acerto[i] == 0 alguma letra que nao acertou)
                    // eu digo q ele nao ganhou
                } else {
                    System.out.print(" " + sorteada.charAt(i) + " ");
                }
            }
            System.out.println("\n");
        }
        while (!ganhou && chances > 0);// se ele nao ganhou e ainda tem vidas ... repete
        resultado(chances, sorteada);


    }

    static void resultado(Integer chances, String sorteada) {
        if (chances > 0) {
            System.out.println("\n\t **** PARABENS VC ACERTOU A PALAVRA!!!!! ****");
        } else {
            System.out.println("\n\t **** ACABARAM SUAS CHANCES, VOCE PERDEU !!!!! ****\n"
                    + " \t **** A PALAVRA ERA --> " + sorteada);
        }

    }

}



