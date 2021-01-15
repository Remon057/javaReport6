package jp.ac.uryukyu.ie.e205707;
/**
 * ゲームを開始する
 * ループを行い敗北者が現れた時にループを抜ける
 */
public class GameMaster {
    /**
     * ゲームを開始する。
     * @param startWord　最初の言葉
     */
    public void gameStart(String startWord){
        GameResult game = new GameResult();
        String playerAnswer;
        String computerAnswer = startWord;
        System.out.println("３文字しりとりだよ。\n全て平仮名かカタカナで答えてね。\n最初は『"+computerAnswer+"』の『"+computerAnswer.charAt(computerAnswer.length() - 1)+"』から初めてね");
        while(game.getResult()){
            playerAnswer = game.playerResult(computerAnswer);
            if(!game.getResult()){ 
                continue;
            }else{
                computerAnswer = game.computerResult(playerAnswer);
            }   
        }
    }
    
    
}