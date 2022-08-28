package com.ledung;

public class RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {
        var pos = new int[2];
        for (char c :  moves.toCharArray()) {
            switch (c) {
                case 'U':
                    pos[1]++;
                    break;
                case 'D':
                    pos[1]--;
                    break;
                case 'R':
                    pos[0]++;
                    break;
                case 'L':
                    pos[0]--;
                    break;
            }
        }
        return pos[0] == pos[1] && pos[0] == 0;
    }

    public static void main(String[] args) {

    }
}
