import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final int counter = 6;
    private List<String> inputLetter;
    private boolean resultGame;

    public void startGame(){
        while (gameReturn()){
            printHelloText();
            gamePlay();
            pringEndText();
        }

    }

    public void gamePlay() {
        WordWork word = new WordWork();
        String literal = "";
        inputLetter = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Design design = new Design();
        for (int i = 0; i < counter; i++) {
            System.out.println("Осталось попыток: " + (counter - i));
            System.out.println(word.getWordClosed());
            System.out.print("Введите букву: ");
            if (word.getStateGame() && scanner.hasNext()) {
                literal = scanner.nextLine().toLowerCase();
                if (!inputLetter.contains(literal)) {
                    inputLetter.add(literal);
                    if (literal.matches("[а-я]") && literal.length()==1) {
                        if (word.checkLetter(literal)) {
                            System.out.println(word.printWord(literal));
                            i--;
                        } else {
                            System.out.println(design.getDesing(i));
                        }
                    } else {
                        System.out.println("Ввод по одной букве на русском языке");
                    }
                } else {
                    i--;
                    System.out.println("Повтор введённой буквы");
                }
            }

        }
        resultGame = word.getStateGame() == true ? false : true; //если слово не расскрыто, то getStateGame возвращает true

    }

    public void printHelloText(){
        System.out.println("Давай сыграем с тобой в игру!");
        System.out.println("Попробуй угадать слово. У тебя 6 попыток");
        System.out.println("Вводи по одной букве и, возможно, удача тебе улыбнётся!");
    }

    public void pringEndText(){
        if (resultGame) {
            System.out.println("Поздравляем!");
        }
        else {
            System.out.println("П О Т Р А Ч Е Н О");
        }
    }

    public boolean gameReturn(){
        System.out.println("Начать игру? Ответь: да/нет");
        boolean answer = false;
        String resultAnswer = "";
        while(!resultAnswer.toLowerCase().equals("да")  & !resultAnswer.toLowerCase().equals("нет")){
            resultAnswer = getAnswerUserGame();
        }
        answer = resultAnswer.toLowerCase().equals("да") ? true : false;
        return answer;
    }

    public String getAnswerUserGame(){
        System.out.print("Введите ответ: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
