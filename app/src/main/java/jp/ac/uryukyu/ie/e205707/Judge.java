package jp.ac.uryukyu.ie.e205707;

import java.util.ArrayList;
import java.util.List;
/**
 * 再入力、負けを判定する。
 */
public class Judge{
    //一度使った文字を保存するリストを作成。
    List<String> usedWordList = new ArrayList<String>();

    /**
     * 入力が平仮名とーであるかの判定。
     * @param word　入力された文字列
     * @return　true(◯) or false(×)
     */
    public boolean hiragana(String word){
        if(word == null || !word.matches("^[\\u3040-\\u309F\\ー]+$")){
            return false;
        }else{ return true; }
    }

    /**
     * 入力が３文字であるかの判定。
     * @param word　入力された文字列
     * @return　true(◯) or false(×)
     */
    public boolean wordCount(String word){
        if(word.length() == 3){
            return true;
        }else{ return false; }
    }

    /**
     * 「ー」を省き、小文字を大文字に変換する。
     * @param word　入力された文字
     * @return　しりとりに最適化された文字列
     */
    public String wordSet(String word){
        word = word.replace("ゃ","や");
        word = word.replace("ゅ","ゆ");
        word = word.replace("ょ","よ");
        word = word.replace("ぁ","あ");
        word = word.replace("ぃ","い");
        word = word.replace("ぅ","う");
        word = word.replace("ぇ","え");
        word = word.replace("ぉ","お");
        if(word.substring(word.length()-1).equals("ー")){
            word = word.substring(0,(word.length()-1));
       }
       return word;
    }

    /**
     * しりとりの文字が繋がっているかの判定。
     * 「ー」を省き、小文字を大文字に変換した文字列で考える。
     * @param before　前の言葉
     * @param after　後の言葉
     * @return　true(◯) or false(×)
     */
    public boolean wordConnect(String  before, String after){
        before = wordSet(before);
        if(before.charAt(before.length() - 1 ) == after.charAt(0) ){
            return true;
        }else{ return false; }
    }

    /**
     * 最後の文字が『ん』であるかを判定する。
     * @param word　入力された文字
     * @return　true(ん以外) or false(ん)
     */
    public boolean loseWord(String word){
        if(word.substring(word.length()-1).equals("ん")){
            return false;
        }else{
            return true;
        }
    }

    /**
     * 使った言葉をリストに入れる。
     * @param word　入力された文字
     */
    public void addWord(String word){
        usedWordList.add(word);
    }

    /**
     * 一度使われた言葉かを判断する。
     * @param word　入力された文字
     * @return　true(使われてない) or false(使われた)
     */
    public boolean usedWord(String word){
        return !usedWordList.contains(word);
    }

    /**
     * カタカナを平仮名にするメソッド
     * @param word　入力された文字
     * @return　平仮名に変換後の文字
     */
    public String getHiragana(String word){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(0x30A1 <= ch && ch <= 0x30F3){
                ch -= 0x0060;
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    /**
     * 「降参」の判定
     * @param word　入力された文字
     * @return　true(降参) or false(降参以外)
     */
    public boolean loseWordkousann(String word){
        if(word.equals("降参") || word.equals("こうさん")){
            return true;
        }else{
            return false;
        }
    }
}