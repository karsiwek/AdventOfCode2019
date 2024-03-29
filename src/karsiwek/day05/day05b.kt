package karsiwek.day05b

val inputtest: String = """3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99""".trimIndent()
val input1: String = """3,9,8,9,10,9,4,9,99,-1,8"""
var input: String = """3,225,1,225,6,6,1100,1,238,225,104,0,1101,37,61,225,101,34,121,224,1001,224,-49,224,4,224,102,8,223,223,1001,224,6,224,1,224,223,223,1101,67,29,225,1,14,65,224,101,-124,224,224,4,224,1002,223,8,223,101,5,224,224,1,224,223,223,1102,63,20,225,1102,27,15,225,1102,18,79,224,101,-1422,224,224,4,224,102,8,223,223,1001,224,1,224,1,223,224,223,1102,20,44,225,1001,69,5,224,101,-32,224,224,4,224,1002,223,8,223,101,1,224,224,1,223,224,223,1102,15,10,225,1101,6,70,225,102,86,40,224,101,-2494,224,224,4,224,1002,223,8,223,101,6,224,224,1,223,224,223,1102,25,15,225,1101,40,67,224,1001,224,-107,224,4,224,102,8,223,223,101,1,224,224,1,223,224,223,2,126,95,224,101,-1400,224,224,4,224,1002,223,8,223,1001,224,3,224,1,223,224,223,1002,151,84,224,101,-2100,224,224,4,224,102,8,223,223,101,6,224,224,1,224,223,223,4,223,99,0,0,0,677,0,0,0,0,0,0,0,0,0,0,0,1105,0,99999,1105,227,247,1105,1,99999,1005,227,99999,1005,0,256,1105,1,99999,1106,227,99999,1106,0,265,1105,1,99999,1006,0,99999,1006,227,274,1105,1,99999,1105,1,280,1105,1,99999,1,225,225,225,1101,294,0,0,105,1,0,1105,1,99999,1106,0,300,1105,1,99999,1,225,225,225,1101,314,0,0,106,0,0,1105,1,99999,108,677,677,224,1002,223,2,223,1006,224,329,101,1,223,223,1107,677,226,224,102,2,223,223,1006,224,344,101,1,223,223,8,677,677,224,1002,223,2,223,1006,224,359,101,1,223,223,1008,677,677,224,1002,223,2,223,1006,224,374,101,1,223,223,7,226,677,224,1002,223,2,223,1006,224,389,1001,223,1,223,1007,677,677,224,1002,223,2,223,1006,224,404,1001,223,1,223,7,677,677,224,1002,223,2,223,1006,224,419,1001,223,1,223,1008,677,226,224,1002,223,2,223,1005,224,434,1001,223,1,223,1107,226,677,224,102,2,223,223,1005,224,449,1001,223,1,223,1008,226,226,224,1002,223,2,223,1006,224,464,1001,223,1,223,1108,677,677,224,102,2,223,223,1006,224,479,101,1,223,223,1108,226,677,224,1002,223,2,223,1006,224,494,1001,223,1,223,107,226,226,224,1002,223,2,223,1006,224,509,1001,223,1,223,8,226,677,224,102,2,223,223,1006,224,524,1001,223,1,223,1007,226,226,224,1002,223,2,223,1006,224,539,1001,223,1,223,107,677,677,224,1002,223,2,223,1006,224,554,1001,223,1,223,1107,226,226,224,102,2,223,223,1005,224,569,101,1,223,223,1108,677,226,224,1002,223,2,223,1006,224,584,1001,223,1,223,1007,677,226,224,1002,223,2,223,1005,224,599,101,1,223,223,107,226,677,224,102,2,223,223,1005,224,614,1001,223,1,223,108,226,226,224,1002,223,2,223,1005,224,629,101,1,223,223,7,677,226,224,102,2,223,223,1005,224,644,101,1,223,223,8,677,226,224,102,2,223,223,1006,224,659,1001,223,1,223,108,677,226,224,102,2,223,223,1005,224,674,1001,223,1,223,4,223,99,226""";

fun getProgram(input: String): ArrayList<Int> {
    return ArrayList(input
            .split(",")
            .filter { !it.trim().equals("") }
            .map({ it.toInt() })
    );
}

fun runProgram(progr: ArrayList<Int>): Int {
    var i = 0;
    var input: Int = 5;

    while (i < progr.size) {
        var command: Int = progr[i] % 100;
        var c: Boolean = (progr[i] / 100) % 10 == 1;
        var b: Boolean = (progr[i] / 1000) % 10 == 1;
        var a: Boolean = (progr[i] / 10000) % 10 == 1;
        if (command == 99) {
            System.out.println();
            System.out.println(progr);
            return progr[0];
        } else if (command == 1) {
            progr.set(getIdx(i + 3, a, progr), getValue(i + 1, c, progr) + getValue(i + 2, b, progr));
            i += 4;
            continue;
        } else if (command == 2) {
            progr.set(getIdx(i + 3, a, progr), getValue(i + 1, c, progr) * getValue(i + 2, b, progr));
            i += 4;
            continue;
        } else if (command == 3) {
            progr.set(progr[i + 1], input);
            i += 2;
            continue;
        } else if (command == 4) {
            System.out.print(getValue(i + 1, c, progr));
            i += 2;
            continue;
        } else if (command == 5) {
            if (getValue(i + 1, c, progr) != 0) {
                i = getValue(i + 2, b, progr)
            } else {
                i+=3;
            }
            continue;
        } else if (command == 6) {
            if (getValue(i + 1, c, progr) == 0) {
                i = getValue(i + 2, b, progr)
            } else {
                i+=3;
            }
            continue;
        } else if (command == 7) {
            if (getValue(i + 1, c, progr) < getValue(i + 2, b, progr)) {
                progr.set(getIdx(i + 3, a, progr), 1);
            } else {
                progr.set(getIdx(i + 3, a, progr), 0);
            }
            i += 4
            continue;
        } else if (command == 8) {
            if (getValue(i + 1, c, progr) == getValue(i + 2, b, progr)) {
                progr.set(getIdx(i + 3, a, progr), 1);
            } else {
                progr.set(getIdx(i + 3, a, progr), 0);
            }
            i += 4
            continue;
        }
    }
    System.out.println(progr);
    return -1;
}

fun getIdx(value: Int, a: Boolean, progr: ArrayList<Int>): Int {
    if (a) {
        return progr.get(progr.get(value));
    } else {
        return progr.get(value);
    }
}

fun getValue(value: Int, a: Boolean, progr: ArrayList<Int>): Int {
    if (a) {
        return progr.get(value);
    } else {
        return progr.get(progr.get(value));
    }
}


fun main(args: Array<String>) {
    runProgram(getProgram(input1));
//    runProgram(getProgram(input1));
//    runProgram(getProgram(input2));
//    runProgram(getProgram(input3));
//    runProgram(getProgram(input4));
    runProgram(getProgram(input));
}

