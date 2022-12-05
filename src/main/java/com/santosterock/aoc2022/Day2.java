package com.santosterock.aoc2022;

import com.santosterock.aoc2022.model.RockPaperScissorResult;
import com.santosterock.aoc2022.util.RockPaperScissorUtil;

import java.io.File;

public class Day2 {

    public static void main(String[] args) {

        var data = RockPaperScissorUtil.loadRockPaperScissor(new File("/Users/sujeshs/IdeaProjects/AOC2022/src/main/resources/day2-input.txt"));

        //data.forEach(record -> System.out.println( record.getScore()));

        System.out.println("total score = " + data.stream().mapToInt(RockPaperScissorResult::getScore).sum());

    }
}
