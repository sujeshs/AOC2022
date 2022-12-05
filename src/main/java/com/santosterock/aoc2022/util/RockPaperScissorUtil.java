package com.santosterock.aoc2022.util;

import com.santosterock.aoc2022.model.RockPaperScissorResult;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public final class RockPaperScissorUtil {

    public static List<RockPaperScissorResult> loadRockPaperScissor(File file) {

        Objects.requireNonNull(file);
        var rockpaperScissorData = new ArrayList<RockPaperScissorResult>();

        try (var reader = new Scanner(file)) {

            while (reader.hasNextLine()) {

                var data = reader.nextLine().split(" ");

                rockpaperScissorData.add(RockPaperScissorResult.newBuilder().withOpponent(data[0]).withUser(data[1]).build());
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return rockpaperScissorData;

    }



}
