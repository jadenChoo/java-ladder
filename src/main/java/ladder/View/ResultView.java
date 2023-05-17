package ladder.View;

import ladder.Model.LadderLine;
import ladder.Model.Ladder;
import ladder.Model.Results;

import java.util.List;

public class ResultView {
    private static final int PRINT_WIDTH = 5;
    private static final String VERTICAL_LINE = "|";
    private static final String HORIZON_LINE = "-".repeat(PRINT_WIDTH);
    private static final String HORIZON_NO_LINE = " ".repeat(PRINT_WIDTH);

    public static void printResultHeader() {
        System.out.println("");
        System.out.println("사다리 결과");
        System.out.println("");
    }
    public static void printAttendances(List<String> attendances) {
        attendances.forEach(s -> {
            System.out.print(" ".repeat(PRINT_WIDTH + 1 - s.length()));
            System.out.print(s);
        });
        System.out.println("");
    }

    public static void printLadder(Ladder ladder) {
        ladder.ladderLines().forEach(ResultView::printLadderLine);
    }

    public static void printTypedResult(Results results){
        results.of().forEach(s -> {
            System.out.print(" ".repeat(PRINT_WIDTH + 1 - s.length()));
            System.out.print(s);
        });
        System.out.println("");
    }

    private static void printLadderLine(LadderLine ladderLine) {
        for (int idx = 0; idx < ladderLine.size(); idx++) {
            printLadderHorizonLine(ladderLine, idx - 1);
            printLadderVerticalLine(ladderLine, idx);
        }

        System.out.println("");
    }

    private static void printLadderHorizonLine(LadderLine ladderLine, int idx) {
        if (idx < 0) {
            System.out.print(HORIZON_NO_LINE);
            return;
        }

        Boolean exist = ladderLine.horizonLines().get(idx);
        if (exist) {
            System.out.print(HORIZON_LINE);
            return;
        }

        System.out.print(HORIZON_NO_LINE);
    }

    private static void printLadderVerticalLine(LadderLine ladderLine, int idx) {
        if (idx < 0) {
            return;
        }

        Boolean exist = ladderLine.verticalLines().get(idx);
        if (exist) {
            System.out.print(VERTICAL_LINE);
        }
    }
}
