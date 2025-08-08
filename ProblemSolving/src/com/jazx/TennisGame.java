package com.jazx;

import java.util.List;

public class TennisGame {
    private int player1Points = 0;
    private int player2Points = 0;

    public String getScore() {
        if (player1Points >= 3 && player2Points >= 3) {
            if (player1Points == player2Points) {
                return "Deuce";
            } else if (player1Points == player2Points + 1) {
                return "Advantage Player 1";
            } else if (player2Points == player1Points + 1) {
                return "Advantage Player 2";
            } else if (player1Points >= player2Points + 2) {
                return "Player 1 wins";
            } else if (player2Points >= player1Points + 2) {
                return "Player 2 wins";
            }
        }

        return getScoreText(player1Points) + " - " + getScoreText(player2Points);
    }

    private String getScoreText(int points) {
        switch (points) {
            case 0: return "0";
            case 1: return "15";
            case 2: return "30";
            case 3: return "45";
            default: return "Invalid";
        }
    }

    public void pointToPlayer(int player) {
        if (player == 1) {
            player1Points++;
        } else if (player == 2) {
            player2Points++;
        } else {
            System.out.println("Invalid player number.");
        }
    }

    public static void main(String[] args) {
        System.out.println(calculateScore(List.of(1,2,1,2,2,1,2,1,1,1,2)));
        System.out.println(calculateScore(List.of(2,1,2,1,2,1,1,2,1)));
        System.out.println(calculateScore(List.of(2,1,2,1,2,1,1,2,1,2,2,2)));

    }

    private static String calculateScore(List<Integer> playerWins) {
        TennisGame game = new TennisGame();
        for (int player : playerWins){
            game.pointToPlayer(player);
            String score = game.getScore();
            if(score.contains("wins")){
                break;
            }
        }
        return game.getScore();
    }
}

