package karsiwek.day02

val target: Int = 19690720;

fun main(args: Array<String>) {
    for (i in (0..99)) {
        for (j in (0..99)) {
            var progr = getProgram(input);
            progr.set(1, i);
            progr.set(2, j);
            var res = runProgram(progr)
            if (res == target) {
                System.out.println(i * 100 + j);
                return;
            }
        }
    }
}

