package jp.ac.uryukyu.ie.e205707;

public class GameMaster {
    /**
     * ゲームを開始する。
     * @param startWord　最初の言葉
     */
    public void gameStart(String startWord){
        GameResult game = new GameResult();
        String playerAnswer;
        String computerAnswer = startWord;
        System.out.println("３文字しりとりだよ。\n全てひらがなで答えてね。\n最初は『"+computerAnswer+"』からスタートだよ!");
        while(game.getResult()){
            playerAnswer = game.playerResult(computerAnswer);
            if(!game.getResult()){ 
                continue;
            }else{
                computerAnswer = game.ComputerResult(playerAnswer);
            }   
        }
    }
    
    
}