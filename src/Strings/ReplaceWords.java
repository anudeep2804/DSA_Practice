package Strings;
import java.util.*;

public class ReplaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {

          HashSet<String> set = new HashSet<>(dictionary);

          String[] words = sentence.split("\\s+");

          for(int i=0; i<words.length; i++){
              for(int j=0; j<words[i].length(); j++){
                  if(set.contains(words[i].substring(0, i))){
                      words[i]=words[i].substring(0,i);
                      break;
                  }
              }
          }

          StringBuilder stringBuilder = new StringBuilder();

          for(String word : words){
              stringBuilder.append(word).append(" ");
          }

          stringBuilder.deleteCharAt(stringBuilder.length()-1);

          return stringBuilder.toString();
    }


}
