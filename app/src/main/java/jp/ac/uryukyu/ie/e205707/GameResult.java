package jp.ac.uryukyu.ie.e205707;
/**
 * プレーヤーとコンピュータの敗北を決定する
 */
class GameResult{
    private boolean result = true;
    Judg ju = new Judg();

    /**
     * resultのゲッターメソッド
     * @return　　true or false
     */
    public boolean getResult(){
        return this.result;
    }

    /**
     * プレイヤーに入力、再入力をさせて負け、続行を判定する。
     * resultに負けか続行を代入する：true(続行) or false(負け)
     * @param befor　前の言葉
     * @return　答え
     */
    public String playerResult(String befor){
        Player player = new Player();
        String answer;
        while(true){
            answer = player.input(befor);
            if(!ju.hiragana(answer)){
                System.out.println("(^O^) 全部平仮名で入力してね");
                continue;
            }else if(!ju.wordConnect(befor, answer)){
                System.out.println("((；ﾟДﾟ))『"+ju.wordSet(befor).charAt(befor.length() - 1)+"』から始まる言葉だよ");
                continue;
            }else if(!ju.wordCount(answer)){
                System.out.println("(｀・ω・´)　３文字の言葉だよ");
                continue;
            }else if(!ju.usedWord(answer)){
                System.out.println("(｀∇´)　一度使われた言葉だよ");
                continue;
            }else{ break; }
        }
        if(!ju.loseWord(answer)){
            System.out.println("(^.^) あなたの負け");
            result = false;
            return answer;
        }else{
            ju.addWord(answer);
            result = true;
            return answer;
        }   
    }
    
    /**
     * コンピュータに出力させて負け、続行を判定する。
     * resultに負けか続行を代入する：true(続行) or false(負け)
     * @param befor　前の言葉
     * @return　答え
     */
    public String computerResult(String befor){
        Computer computer = new Computer();
        String answer = computer.computerAnswer(befor , ju);
        
        if(answer == null){
            System.out.println(">_<　ん〜思いつかない・・・参りました〜");
            result = false;
            return answer;
        }else{
            System.out.println(answer);
            ju.addWord(answer);
            result = true;
            return answer;
        }
    }
    
}