import java.io.*;
import java.util.List;

public class WordWork {
    private final String wordOpen;
    private final int countOpen = 2;
    private String wordClosed;

    public WordWork(){
        this.wordOpen = getString();
        this.wordClosed = wordLogic();

    }


    //проверка введённой буквы
    public boolean checkLetter(String letter){
        return wordOpen.contains(letter);
    }

    //печать букв после проверки (String literal)
    public String printWord(String letter){
        StringBuilder sb = new StringBuilder();
        int g = 0;
        for(int i = 0 ; i < getWordClosed().length(); ) {
            g = getIndexFrom(letter, i);
            if (g>= 0) {
                sb.append(getWordClosed().substring(i, g)).append(letter);
            } else {
                sb.append(getWordClosed().substring(i));
            }
            i = sb.length();
        }
        wordClosed = sb.toString();
        return wordClosed;
    }

    public int getIndexFrom(String letter, int indexStart) {
        return wordOpen.indexOf(letter, indexStart);
    }


    //logic
    public String wordLogic(){
        return getGameLine(wordOpen);
    }

    //получить слово из файла
    public String getString(){
        String line = "";
        List<String> list;
        int random = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/listWithStrings"));
            list = bufferedReader.lines().toList();
            random = (int)(Math.random() * (list.size() +1));
            int count = random < list.size() ? random : list.size() -1;
            line = list.get(count);
        } catch (FileNotFoundException i){
            i.printStackTrace();
        }
        return line;
    }

    //спрятать буквы
    public String getGameLine(String line){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <line.length(); i++){
            builder.append("_");
        }
        int indexPosition = 0;
        int indexPosition2 = 0;
        for (int i = 0; i < countOpen; i++){
            indexPosition2 = (int)(Math.random() * (line.length() +1));
            if (indexPosition2 != indexPosition & indexPosition2 > 0) {
                indexPosition = indexPosition2 >= line.length() ? line.length() - 1 : indexPosition2;
                builder.replace(indexPosition, indexPosition + 1, line.substring(indexPosition, indexPosition + 1));
            } else {
                i--;
            }
        }
        return builder.toString();
    }

    public String getWordOpen() {
        return wordOpen;
    }

    public String getWordClosed(){
        return wordClosed;
    }

    public boolean getStateGame(){
        return wordClosed.contains("_");
    }
}
