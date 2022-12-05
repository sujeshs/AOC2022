package com.santosterock.aoc2022.model;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Map;

public final class RockPaperScissorResult {

    private static final Map<String, Integer> WEIGHTAGE = Map.of(
            "A",1
            ,"B",2
            ,"C",3
            ,"X",1
            ,"Y",2
            ,"Z",3
    );

    private static final int WIN_POINTS = 6;
    private static final int LOSE_POINTS = 0;
    private static final int DRAW_POINTS = 3;

    private static final Map<Pair<String, String>, Integer> tupleScores =
            Map.of(
                    Pair.of("A","X"),4
                    ,Pair.of("A","Y"),8
                    ,Pair.of("A","Z"),8


            );

    private final String opponent;
    private final String user;
    private final int score;

    public String getOpponent() {
        return opponent;
    }

    public String getUser() {
        return user;
    }

    public int getScore() {
        return score;
    }

    private RockPaperScissorResult(Builder builder) {
        opponent = builder.opponent;
        user = builder.user;

        if (WEIGHTAGE.get(opponent) < WEIGHTAGE.get(user)) {
            score = WIN_POINTS + WEIGHTAGE.get(user);
        } else if (WEIGHTAGE.get(opponent) > WEIGHTAGE.get(user)) {
            score = LOSE_POINTS + WEIGHTAGE.get(user);
        } else {
            score = DRAW_POINTS + WEIGHTAGE.get(user);
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(RockPaperScissorResult copy) {
        Builder builder = new Builder();
        builder.opponent = copy.getOpponent();
        builder.user = copy.getUser();
        return builder;
    }


    public static final class Builder {
        private String opponent;
        private String user;

        private Builder() {
        }

        public Builder withOpponent(String val) {
            opponent = val;
            return this;
        }

        public Builder withUser(String val) {
            user = val;
            return this;
        }

        public RockPaperScissorResult build() {
            return new RockPaperScissorResult(this);
        }
    }
}
