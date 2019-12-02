package karsiwek.day02


val inputtest: String = """1,9,10,3,2,3,11,0,99,30,40,50""".trimIndent()
val input1: String = """1,0,0,0,99""".trimIndent()
val input2: String = """2,3,0,3,99""".trimIndent()
val input3: String = """2,4,4,5,99,0""".trimIndent()
val input4: String = """1,1,1,4,99,5,6,0,99""".trimIndent()
var input: String = """1,12,2,3,1,1,2,3,1,3,4,3,1,5,0,3,2,13,1,19,1,10,19,23,1,6,23,27,1,5,27,31,1,10,31,35,2,10,35,39,1,39,5,43,2,43,6,47,2,9,47,51,1,51,5,55,1,5,55,59,2,10,59,63,1,5,63,67,1,67,10,71,2,6,71,75,2,6,75,79,1,5,79,83,2,6,83,87,2,13,87,91,1,91,6,95,2,13,95,99,1,99,5,103,2,103,10,107,1,9,107,111,1,111,6,115,1,115,2,119,1,119,10,0,99,2,14,0,0""";
fun getProgram(input: String): ArrayList<Int> {
    return ArrayList(input
            .split(",")
            .filter {!it.trim().equals("") }
            .map( {it.toInt() })
            );
}

fun getFuelForSingleMass(mass: Int): Int {
    return Math.max(0, (mass / 3) - 2);
}

fun runProgram(progr : ArrayList<Int>) : Int {
    var i=0;
    while(i < progr.size){
        if(progr[i]==99){
            System.out.println(progr);
            return progr[0];
        } else if(progr[i]==1){
            progr.set(progr[i+3], progr[progr[i+1]] + progr[progr[i+2]]);
            i+=4;
            continue;
        } else if(progr[i]==2){
            progr.set(progr[i+3], progr[progr[i+1]] * progr[progr[i+2]]);
            i+=4;
            continue;
        }
    }
    System.out.println(progr);
    return -1;
}
fun main(args: Array<String>) {
    runProgram(getProgram(inputtest));
    runProgram(getProgram(input1));
    runProgram(getProgram(input2));
    runProgram(getProgram(input3));
    runProgram(getProgram(input4));

    runProgram(getProgram(input));
}

