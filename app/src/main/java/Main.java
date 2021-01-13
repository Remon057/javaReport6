import jp.ac.uryukyu.ie.e205707.*;
/**
 * Mainクラス
 * 3文字しりとりを「じゃば」からスタートで始める
 */
public class Main{
    /**
     * ゲーム開始を呼び出す。
     * 最初の文字は「じゃば」と設定
     * @param args
     */
    public static void main(String[] args){
        String startWord = "じゃば";
        GameMaster gameMaster = new GameMaster();
        gameMaster.gameStart(startWord);
    }
}
