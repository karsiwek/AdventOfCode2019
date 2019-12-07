package karsiwek.day06

var testInput: String = """
COM)B
B)C
C)D
D)E
E)F
B)G
G)H
D)I
E)J
J)K
K)L
K)YOU
I)SAN
""".trimIndent();

fun solveShit(definition: HashMap<String, Pair<String, Int>>): Int {
    getOrbits(definition);
    var commonAncestor: String = getCommonAncestor("SAN", "YOU", definition);

    return (definition.get("YOU")!!.second - definition.get(commonAncestor)!!.second) + (definition.get("SAN")!!.second - definition.get(commonAncestor)!!.second) - 2

}

fun getCommonAncestor(elem1: String, elem2: String, definition: HashMap<String, Pair<String, Int>>): String {
    var set1: HashSet<String> = HashSet();

    var elem = elem1;
    while (true) {
        if (definition.containsKey(elem)) {
            elem = definition.get(elem)!!.first;
            set1.add(elem);
        } else {
            break;
        }
    }

    elem = elem2;
    while (true) {
        elem = definition.get(elem)!!.first;
        if (set1.contains(elem)) {
            return elem;
        }
    }
}

fun main(args: Array<String>) {
    println(solveShit(getDefinition(testInput)));
    println(solveShit(getDefinition(input)));
}
